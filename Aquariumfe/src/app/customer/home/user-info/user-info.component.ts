import { Component } from '@angular/core';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrl: './user-info.component.css'
})
export class UserInfoComponent {
  showPasswordFields = false;

  togglePasswordFields() {
    this.showPasswordFields = !this.showPasswordFields;
  }
}
