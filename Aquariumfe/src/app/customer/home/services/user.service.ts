import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8080/api/user';

  constructor(private http: HttpClient) {}

  updateUserInfo(id: number, userInfo: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/update/${id}`, userInfo);
  }

  getUserTickets(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/user-tickets`);
  }
  changePassword(id: number, passwordData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/changePassword/${id}`, passwordData);
  }
}
