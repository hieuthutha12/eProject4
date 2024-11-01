import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';
import { UserInfo } from '../user-info.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  emailError: string = ''; 
  passwordError: string = ''; 
  generalErrorMessage: string = '';

  constructor(
    private authService: AuthService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    this.loginForm = this.formBuilder.group({
      email: [''], 
      password: ['']
    });
  }

   ngOnInit(): void {
  }
  loadUserInfo() {
    this.authService.fetchUserInfo().subscribe({
      next: (data) => {
        this.authService.setUserInfo(data);
        console.log(this.authService.userInfo$);
        console.log('hieu'); 
      },
      error: (error) => {
        console.error('Failed to load user info:', error);
      }
    });
  }
  onLogin() {
    this.emailError = '';
    this.passwordError = '';
    this.generalErrorMessage = '';

    const credentials = this.loginForm.value;

    this.authService.login(credentials).subscribe({
      next: (response) => {
        this.loadUserInfo();  // Load user info after successful login
        this.router.navigate(['/customer/home']); 
      },
      error: (error) => {
        console.error('Login failed:', error);
        if (error.error) {
          this.generalErrorMessage = error.error.message || 'An unknown error occurred.';
          if (error.error.errors) {
            this.emailError = error.error.errors.email || ''; 
            this.passwordError = error.error.errors.password || '';
          }
        } else {
          this.generalErrorMessage = 'An unknown error occurred.';
        }
      }
    });
  }
}
