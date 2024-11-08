import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { isPlatformBrowser } from '@angular/common';
import { UserInfo } from '../../models/user-info.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient,
    @Inject(PLATFORM_ID) private platformId: Object) {
       const storedUserInfo = this.getStoredUserInfo();
      if (storedUserInfo) {
        this.userInfoSubject.next(storedUserInfo);
      }}
    private userInfoSubject: BehaviorSubject<UserInfo | null> = new BehaviorSubject<UserInfo | null>(null);
    public userInfo$: Observable<UserInfo | null> = this.userInfoSubject.asObservable();
    login(credentials: { email: string; password: string, targetRole: string }): Observable<any> {
      return this.http.post<{ token: string }>(`${this.apiUrl}/auth/login`, credentials, {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
        })
      }).pipe(
        tap(response => {
          this.setAdminToken(response.token);
          this.fetchUserInfo().subscribe();
        }),
      );
    }
    private setAdminToken(token: string) {
      if (isPlatformBrowser(this.platformId)) {
        localStorage.clear();
        sessionStorage.clear();
        localStorage.setItem('adminToken', token);
      }
    }
  
    getToken(): string | null {
      if (isPlatformBrowser(this.platformId)) {
        return localStorage.getItem('adminToken');
      }
      return null;
    }
  
    logout(): void {
      if (isPlatformBrowser(this.platformId)) {
        localStorage.clear();
        sessionStorage.clear();
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
      return this.http.get<UserInfo>(`${this.apiUrl}/user/info`, { headers }).pipe(
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
    changePassword(id: number, passwordData: any): Observable<any> {
      return this.http.post(`${this.apiUrl}/user/changePassword/${id}`, passwordData);
    }
  
}
