import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrlLogin = 'http://localhost:8080/api/auth/login';
  private apiUrlRegister = 'http://localhost:8080/api/auth/register';

  constructor(private http: HttpClient) { }

  login(credentials: { username: string; password: string }): Observable<any> {
    return this.http.post(this.apiUrlLogin, credentials, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }
  register(credentials: { firstName: string;lastName: string;address: string;phone: string; email: string; password: string }): Observable<any> {
    return this.http.post(this.apiUrlRegister, credentials, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }
}
