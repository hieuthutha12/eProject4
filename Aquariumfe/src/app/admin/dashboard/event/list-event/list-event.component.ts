import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-event',
  templateUrl: './list-event.component.html',
  styleUrls: ['./list-event.component.css']
})
export class ListEventComponent {
  events = [
    { id: 1, title: 'Sample Event 1', date: '2023-12-31', location: 'Location 1' },
    { id: 2, title: 'Sample Event 2', date: '2024-01-01', location: 'Location 2' },
  ];

  constructor(private router: Router) {}

  editEvent(id: number) {
    this.router.navigate(['/update', id]); 
  }
}
