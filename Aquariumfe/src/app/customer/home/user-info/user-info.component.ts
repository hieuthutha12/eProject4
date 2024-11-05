import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../services/user.service';
import { AlertService } from '../../../shared/custom-alert/alert.service';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {
  userInfoForm: FormGroup;
  passwordForm: FormGroup;
  userInfo: any;
  oldPasswordError: string = ''; 
  newPasswordError: string = ''; 
  generalErrorMessage: string = '';

  constructor(
    private authService: AuthService,
    private fb: FormBuilder,
    private userService: UserService,
    private alertService: AlertService
  ) {
    this.userInfoForm = this.fb.group({
      firstName: [''],
      lastName: [''],
      email: [''],
      phone: [''],
      address: ['']
    });

    this.passwordForm = this.fb.group({
      oldPassword: [''],
      newPassword: ['']
    });
  }

  ngOnInit(): void {
    this.authService.userInfo$.subscribe((info) => {
      if (info) {
        this.userInfo = info;
        this.userInfoForm.patchValue(info);
      }
    });
  }

  // Method to update user info without password
  updateUserInfo(): void {
    if (this.userInfoForm.valid) {
      const updatedInfo = this.userInfoForm.value;
      this.userService.updateUserInfo(this.userInfo.id, updatedInfo).subscribe({
        next: (response) => {
        },
        error: (error) => {
          if (error.error) {
            this.generalErrorMessage = error.error.message || 'An unknown error occurred.';
            if (error.error.errors) { 
              this.alertService.showAlert(error.error.errors.firstName);
              this.alertService.showAlert(error.error.errors.lastName);
              this.alertService.showAlert(error.error.errors.email);
              this.alertService.showAlert(error.error.errors.address);
              this.alertService.showAlert(error.error.errors.phone);
            }
          } else {
            this.generalErrorMessage = 'An unknown error occurred.';
          }
        }
      });
    }
  }

  changePassword(): void {
    if (this.passwordForm.valid) {
      const passwordData = this.passwordForm.value;
      this.userService.changePassword(this.userInfo.id, passwordData).subscribe({
        next: (response) => {
          this.passwordForm.reset();
        },
        error: (error) => {
          if (error.error) {
            this.generalErrorMessage = error.error.message || 'An unknown error occurred.';
            if (error.error.errors) { 
              this.alertService.showAlert(error.error.errors.oldPassword);
              this.alertService.showAlert(error.error.errors.newPassword);
            }
          } else {
            this.generalErrorMessage = 'An unknown error occurred.';
          }
        }
      });
    }
  }
  showPasswordFields: boolean = false;
  togglePasswordFields() {
    this.showPasswordFields = !this.showPasswordFields;
  }
}
