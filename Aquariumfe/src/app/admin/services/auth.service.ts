import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { isPlatformBrowser } from '@angular/common';
import { UserInfo } from '../../models/user-info.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient, @Inject(PLATFORM_ID) private platformId: Object) {}

  login(credentials: { email: string; password: string; targetRole: string }): Observable<any> {
    return this.http.post<{ token: string }>(`${this.apiUrl}/auth/login`, credentials, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
    }).pipe(
      tap(response => {
        this.setAdminToken(response.token);
      }),
    );
  }

  private setAdminToken(token: string) {
    if (isPlatformBrowser(this.platformId)) {
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
      localStorage.removeItem('adminToken');
    }
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  fetchUserInfo(): Observable<UserInfo> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.getToken()}`,
    });
    return this.http.get<UserInfo>(`${this.apiUrl}/user/info`, { headers });
  }

  changePassword(id: number, passwordData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/user/changePassword/${id}`, passwordData);
  }
}
