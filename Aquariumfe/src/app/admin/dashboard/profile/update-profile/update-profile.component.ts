import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent {
  profileForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.profileForm = this.fb.group({
      username: [''],
      email: [''],
      phone: [''],
      address: ['']
    });
  }

  onSubmit() {
    // Logic to submit the form and update the profile
    console.log(this.profileForm.value);
  }
}
