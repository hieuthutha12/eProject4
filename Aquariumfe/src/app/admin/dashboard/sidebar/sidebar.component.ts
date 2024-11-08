import { Component } from '@angular/core';
import { UserInfo } from '../../../models/user-info.model';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {
  userInfo: UserInfo | null = null;
  constructor(private authService : AuthService, private router :Router){}
  ngOnInit(): void {
    this.authService.userInfo$.subscribe(user => {
      this.userInfo = user;
    });
  }
}
