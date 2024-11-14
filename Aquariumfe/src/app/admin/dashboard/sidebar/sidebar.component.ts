import { Component, OnInit } from '@angular/core';
import { UserInfo } from '../../../models/user-info.model';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  userInfo: UserInfo | null = null;

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.authService.fetchUserInfo().subscribe({
      next: (user: UserInfo) => {
        this.userInfo = user;
      },
      error: (error) => {
        console.error('Error fetching user info:', error);
      }
    });
  }
}
