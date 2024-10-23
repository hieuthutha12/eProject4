import { Component, OnInit } from '@angular/core';

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
}
