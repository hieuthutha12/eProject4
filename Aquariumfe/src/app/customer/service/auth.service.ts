import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, of, switchMap, tap, catchError } from 'rxjs';

export interface UserInfo {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  address: string;
  phone: string;
  accountStatus: string;
  roleName: string;
  points: number;
  discountPercentage: number;
  createdAt: Date;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrlLogin = 'http://localhost:8080/api/auth/login';
  private apiUrlRegister = 'http://localhost:8080/api/auth/register';
  private apiUrl = 'http://localhost:8080/api/user/info';  
  private userInfoSubject = new BehaviorSubject<UserInfo | null>(null);

  userInfo$ = this.userInfoSubject.asObservable();
  constructor(private http: HttpClient) { }

  private fetchAndSetUserInfo(token: string): Observable<UserInfo> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<UserInfo>(this.apiUrl, { headers }).pipe(
      tap((userInfo) => this.userInfoSubject.next(userInfo)),
      catchError(() => {
        const fallbackUserInfo: UserInfo = {
          id: 0,
          firstName: '',
          lastName: '',
          email: '',
          address: '',
          phone: '',
          accountStatus: 'Unknown',
          roleName: 'Guest',
          points: 0,
          discountPercentage: 0,
          createdAt: new Date()
        };
        this.userInfoSubject.next(fallbackUserInfo);
        return of(fallbackUserInfo);
      })
    );
  }
  getUserInfo(): Observable<UserInfo | null> {
    const token = this.getToken();
    if (token && !this.userInfoSubject.value) {
      return this.fetchAndSetUserInfo(token);
    }
    return this.userInfo$;
  }

  login(credentials: { username: string; password: string }): Observable<UserInfo> {
    return this.http.post<{ token: string }>(this.apiUrlLogin, credentials, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }).pipe(
      tap(response => this.setToken(response.token)), 
      switchMap(response => this.fetchAndSetUserInfo(response.token))
    );
  }

  register(credentials: { firstName: string; lastName: string; address: string; phone: string; email: string; password: string }): Observable<UserInfo> {
    return this.http.post<{ token: string }>(this.apiUrlRegister, credentials, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }).pipe(
      tap(response => this.setToken(response.token)), 
      switchMap(response => this.fetchAndSetUserInfo(response.token))
    );
  }

  private setToken(token: string) {
    localStorage.setItem('authToken', token);
  }

  getToken(): string | null {
    return localStorage.getItem('authToken');
  }

  logout(): void {
    localStorage.removeItem('authToken');
    this.userInfoSubject.next(null); // Reset user info on logout
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }
}
