import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
interface UserProfile {
  username: string;
  email: string;
  phone: string;
  address: string;
}

@Component({
  selector: 'app-get-profile',
  templateUrl: './get-profile.component.html',
  styleUrls: ['./get-profile.component.css']
})
export class GetProfileComponent implements OnInit {
  profile: UserProfile | null = null;

  ngOnInit(): void {
    this.profile = {
      username: 'JohnDoe',
      email: 'john.doe@example.com',
      phone: '123-456-7890',
      address: '123 Main St, Anytown, USA'
    };
  }
  toggleChangePassword(): void {
    const changePasswordSection = document.getElementById('changePasswordSection') as HTMLElement | null;

    // Check if the element exists before trying to access its style property
    if (changePasswordSection) {
      if (changePasswordSection.style.display === "none" || changePasswordSection.style.display === "") {
        changePasswordSection.style.display = "block";
      } else {
        changePasswordSection.style.display = "none";
      }
    }
  }
}
