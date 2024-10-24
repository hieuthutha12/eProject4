import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventService } from '../../services/event.service';

@Component({
  selector: 'app-list-event',
  templateUrl: './list-event.component.html',
  styleUrls: ['./list-event.component.css']
})
export class ListEventComponent implements OnInit {
  events: any[] = [];

  constructor(private router: Router, private eventService: EventService) {}

  ngOnInit() {
    this.fetchEvents();
  }

  fetchEvents() {
    this.eventService.getAllEvents().subscribe(
      (data: any) => {
        this.events = data; 
      },
      error => {
        console.error('Error fetching events:', error); 
      }
    );
  }

  editEvent(id: number) {
    this.router.navigate([`/admin/dashboard/event/form/${id}`]);
  }
  addEvent() {
    this.router.navigate(['/admin/dashboard/event/form']);
}
}
