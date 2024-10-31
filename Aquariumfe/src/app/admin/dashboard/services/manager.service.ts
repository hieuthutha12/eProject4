import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ManagerService {
  private apiUrl = 'http://localhost:8080/api/managers';

  constructor(private http: HttpClient) { }

  createManager(data: FormData): Observable<any> {
    return this.http.post(this.apiUrl, data);
  }

  updateManager(id: number, data: FormData): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, data);
  }

  getAllManagers(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  getEventById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }
}
