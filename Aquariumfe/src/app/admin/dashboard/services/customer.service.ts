import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private apiUrl = 'http://localhost:8080/api/user';
  constructor(private http: HttpClient) { }

  getAllCustomers(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  getTypesById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }
}
