import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrlLogin = 'http://localhost:8080/api/auth/login';
  private apiUrlRegister = 'http://localhost:8080/api/auth/register';
  private apiUrlCheckToken = 'http://localhost:8080/api/user/checkToken';

  constructor(private http: HttpClient) { }

  async isAuthenticated(): Promise<boolean> {
    const token = localStorage.getItem('authToken');
    if (!token) {
      return false; 
    }
    return this.checkToken(token).toPromise()
      .then(response => {
        return response !== null; 
      })
      .catch(() => false); 
  }

  login(credentials: { username: string; password: string }): Observable<any> {
    return this.http.post(this.apiUrlLogin, credentials, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  checkToken(token: string): Observable<any> {
    return this.http.get(this.apiUrlCheckToken, {
      params: { token }
    }).pipe(
      
      catchError(err => {
        console.error('Error checking token:', err); 
        return of(null);
      })
    );
  }

  setToken(token: string) {
    localStorage.setItem('authToken', token);
  }

  getToken() {
    return localStorage.getItem('authToken');
  }

  logout() {
    localStorage.removeItem('authToken');
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  register(credentials: { firstName: string; lastName: string; address: string; phone: string; email: string; password: string }): Observable<any> {
    return this.http.post(this.apiUrlRegister, credentials, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }
}
