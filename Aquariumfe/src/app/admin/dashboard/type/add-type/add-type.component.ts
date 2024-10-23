import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-type',
  templateUrl: './add-type.component.html',
  styleUrls: ['./add-type.component.css']
})
export class AddTypeComponent {
  constructor(private router: Router) {}

  onSubmit(typeData: any) {
    // Here you would typically make a service call to save the type
    console.log('Type Added:', typeData);
    this.router.navigate(['/types/list']); // Navigate to list after submission
  }
}
