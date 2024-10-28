import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventService } from '../../services/event.service';

@Component({
  selector: 'app-event-page',
  templateUrl: './event-page.component.html',
  styleUrls: ['./event-page.component.css']
})
export class EventPageComponent implements OnInit {
  events: any[] = [];  // Events displayed on the current page
  originalEvents: any[] = [];  // Full list of all events from the server
  filteredEvents: any[] = [];  // Events after applying the search filter
  searchTerm: string = '';
  currentPage: number = 1;
  eventsPerPage: number = 3;
  totalPages: number = 0;

  constructor(private router: Router, private eventService: EventService) {}

  ngOnInit() {
    this.fetchEvents();
  }

  fetchEvents() {
    this.eventService.getAllEvents().subscribe(
      (data: any[]) => {
        this.originalEvents = data;
        this.filteredEvents = [...this.originalEvents];
        this.totalPages = Math.ceil(this.filteredEvents.length / this.eventsPerPage);
        this.updateEvents();
      },
      error => {
        console.error('Error fetching events:', error);
      }
    );
  }

  onSearch() {
    this.currentPage = 1;
    const searchTermLower = this.searchTerm.toLowerCase();

    if (this.searchTerm) {
      this.filteredEvents = this.originalEvents.filter(event =>
        event.eventName && event.eventName.toLowerCase().includes(searchTermLower)
      );
    } else {
      this.filteredEvents = [...this.originalEvents];
    }

    this.totalPages = Math.ceil(this.filteredEvents.length / this.eventsPerPage);
    this.updateEvents();
  }

  goToNextPage() {
    if (this.currentPage < this.totalPages) {
      this.currentPage++;
      this.updateEvents();
    }
  }

  goToPreviousPage() {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.updateEvents();
    }
  }

  updateEvents() {
    const startIndex = (this.currentPage - 1) * this.eventsPerPage;
    this.events = this.filteredEvents.slice(startIndex, startIndex + this.eventsPerPage);
  }
}
