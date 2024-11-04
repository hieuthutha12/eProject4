import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrl: './user-info.component.css'
})
export class UserInfoComponent implements OnInit {
  userInfo: any;
  showPasswordFields: boolean = false;
  constructor(private authService: AuthService){};
  ngOnInit(): void {
    this.authService.userInfo$.subscribe((info) => {
      this.userInfo = info;
    });
  }
  togglePasswordFields() {
    this.showPasswordFields = !this.showPasswordFields;
  }
  
}
