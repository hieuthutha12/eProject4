import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-type',
  templateUrl: './list-type.component.html',
  styleUrls: ['./list-type.component.css']
})
export class ListTypeComponent {
  types = [
    { id: 1, name: 'Type 1', description: 'Description of Type 1' },
    { id: 2, name: 'Type 2', description: 'Description of Type 2' },
    // Add more types for demonstration
  ];

  constructor(private router: Router) {}

  editType(id: number) {
    this.router.navigate(['/types/update', id]); // Navigate to update route
  }
}
