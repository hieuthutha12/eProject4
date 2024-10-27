import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventService } from '../../services/event.service';

@Component({
  selector: 'app-event-page',
  templateUrl: './event-page.component.html',
  styleUrls: ['./event-page.component.css']
})
export class EventPageComponent implements OnInit {
  events: any[] = [];
  originalEvents: any[] = [];
  searchTerm: string = '';
  currentPage: number = 1; 
  eventsPerPage: number = 3; 

  constructor(private router: Router, private eventService: EventService) {}

  ngOnInit() {
    this.fetchEvents();
  }

  fetchEvents() {
    this.eventService.getAllEvents().subscribe(
      (data: any[]) => {
        const currentDate = new Date();
        this.originalEvents = data.filter(event => {
          const endDate = new Date(event.endDate);
          return endDate >= currentDate;//
        });
        this.events = this.originalEvents.slice(0, this.eventsPerPage);
      },
      error => {
        console.error('Error fetching events:', error);
      }
    );
  }

  onSearch() {
    if (this.searchTerm) {
      this.events = this.originalEvents.filter(event =>
        event.eventName && event.eventName.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    } else {
      this.events = this.originalEvents.slice(0, this.eventsPerPage); 
    }
  }

  // Pagination methods
  goToNextPage() {
    this.currentPage++;
    this.updateEvents();
  }

  goToPreviousPage() {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.updateEvents();
    }
  }

  updateEvents() {
    const startIndex = (this.currentPage - 1) * this.eventsPerPage;
    this.events = this.originalEvents.slice(startIndex, startIndex + this.eventsPerPage);
  }
}
