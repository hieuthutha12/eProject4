import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject, tap } from 'rxjs';
import { UserInfo } from '../../user-info.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from '../../service/auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private authService: AuthService) {}

  
}
