import { Injectable, Inject, PLATFORM_ID } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { isPlatformBrowser } from '@angular/common';
import { UserInfo } from '../../models/user-info.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrlLogin = 'http://localhost:8080/api/auth/login';
  private apiUrlRegister = 'http://localhost:8080/api/auth/register'; 
  private apiUrl = 'http://localhost:8080/api/user/info'; 

  private userInfoSubject: BehaviorSubject<UserInfo | null> = new BehaviorSubject<UserInfo | null>(null);
  public userInfo$: Observable<UserInfo | null> = this.userInfoSubject.asObservable();

  constructor(
    private http: HttpClient,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {
    const storedUserInfo = this.getStoredUserInfo();
    if (storedUserInfo) {
      this.userInfoSubject.next(storedUserInfo);
    }
  }

  login(credentials: { username: string; password: string }): Observable<any> {
    return this.http.post<{ token: string }>(this.apiUrlLogin, credentials, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.getToken()}`
      })
    }).pipe(
      tap(response => {
        this.setToken(response.token);
        this.fetchUserInfo().subscribe();
      })
    );
  }
  register(credentials: { firstName: string; lastName: string; address: string; phone: string; email: string; password: string }): Observable<any> {
    return this.http.post<{ token: string }>(this.apiUrlRegister, credentials, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }).pipe(
      tap(response => this.setToken(response.token)), 
    );
  }

  private setToken(token: string) {
    if (isPlatformBrowser(this.platformId)) {
      localStorage.setItem('authToken', token);
    }
  }

  getToken(): string | null {
    if (isPlatformBrowser(this.platformId)) {
      return localStorage.getItem('authToken');
    }
    return null;
  }

  logout(): void {
    if (isPlatformBrowser(this.platformId)) {
      localStorage.removeItem('authToken');
      sessionStorage.removeItem('userInfo');
    }
    this.userInfoSubject.next(null);
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  fetchUserInfo(): Observable<UserInfo> {
    if (this.userInfoSubject.value !== null) {
      return this.userInfo$ as Observable<UserInfo>;
    }

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.getToken()}`
    });
    return this.http.get<UserInfo>(this.apiUrl, { headers }).pipe(
      tap((userInfo: UserInfo) => {
        this.setUserInfo(userInfo);
      })
    );
  }

  public setUserInfo(userInfo: UserInfo): void {
    this.userInfoSubject.next(userInfo);
    if (isPlatformBrowser(this.platformId)) {
      sessionStorage.setItem('userInfo', JSON.stringify(userInfo));
    }
  }

  private getStoredUserInfo(): UserInfo | null {
    if (isPlatformBrowser(this.platformId)) {
      const storedData = sessionStorage.getItem('userInfo');
      return storedData ? JSON.parse(storedData) : null;
    }
    return null;
  }
}
