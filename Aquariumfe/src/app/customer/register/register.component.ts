import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  emailError: string = ''; 
  passwordError: string = ''; 
  firstNameError: string = ''; 
  lastNameError: string = ''; 
  generalErrorMessage: string = '';

  constructor(
    private authService: AuthService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    this.registerForm = this.formBuilder.group({
      email: [''], 
      password: [''],
      firstName:[''],
      lastName:[''],
      address:[''],
      phone:[''],
    });
  }

  ngOnInit(): void {
  }

  onRegister() {
    this.emailError = '';
    this.passwordError = '';
    this.firstNameError='';
    this.lastNameError='';
    this.generalErrorMessage = '';

    
    const credentials = this.registerForm.value;

    this.authService.register(credentials).subscribe({
      next: (response) => {
        this.router.navigate(['/customer/login']);
      },
      error: (error) => {
        console.error('Register failed:', error);
        if (error.error) {
          this.generalErrorMessage = error.error.message || 'An unknown error occurred.';
          if (error.error.errors) {
            this.emailError = error.error.errors.email || ''; 
            this.passwordError = error.error.errors.password || '';
            this.firstNameError = error.error.errors.firstName || ''; 
            this.lastNameError = error.error.errors.lastName || '';
          }
        } else {
          this.generalErrorMessage = 'An unknown error occurred.';
        }
      }
    });
  }

  showPassword: boolean = false;

    togglePasswordVisibility(): void {
        this.showPassword = !this.showPassword;
    }
    
}
