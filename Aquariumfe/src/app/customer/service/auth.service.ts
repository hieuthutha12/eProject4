import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { UserInfo } from '../user-info.model';



@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrlLogin = 'http://localhost:8080/api/auth/login';
  private apiUrlRegister = 'http://localhost:8080/api/auth/register'; 

  constructor(private http: HttpClient) { }

  login(credentials: { username: string; password: string }): Observable<any> {
    const token = this.getToken();

    return this.http.post<{ token: string }>(this.apiUrlLogin, credentials, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        ...(token ? { 'Authorization': `Bearer ${token}` } : {})
      })
    }).pipe(
      tap(response => this.setToken(response.token))
    );
  }

  register(credentials: { firstName: string; lastName: string; address: string; phone: string; email: string; password: string }): Observable<any> {
    return this.http.post<{ token: string }>(this.apiUrlRegister, credentials, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }).pipe(
      tap(response => this.setToken(response.token)), 
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
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }


  private userInfoSubject: BehaviorSubject<UserInfo | null> = new BehaviorSubject<UserInfo | null>(null);
  public userInfo$: Observable<UserInfo | null> = this.userInfoSubject.asObservable();
  private apiUrl = 'http://localhost:8080/api/user/info'; 
  fetchUserInfo(): Observable<UserInfo> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.getToken()}`
    });
    return this.http.get<UserInfo>(this.apiUrl, { headers }).pipe(
      tap((userInfo: UserInfo) => {
        this.setUserInfo(userInfo); 
      })
    );
  }
  setUserInfo(userInfo: UserInfo): void {
    this.userInfoSubject.next(userInfo); 
  }
}
