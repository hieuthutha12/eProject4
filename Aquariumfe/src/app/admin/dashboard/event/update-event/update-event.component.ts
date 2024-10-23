import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-event',
  templateUrl: './update-event.component.html',
  styleUrls: ['./update-event.component.css']
})
export class UpdateEventComponent implements OnInit {
  eventId: string | null = null;
  eventData: any; 

  constructor(private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.eventId = params.get('id'); 
      
      this.eventData = {
        title: 'Sample Event',
        date: '2023-12-31',
        location: 'Sample Location',
        description: 'This is a sample event description.'
      }; // Mock data for demonstration
    });
  }

  onFormSubmit(data: any) {
    
    console.log('Updating event:', data);
    
    this.router.navigate(['/events/list']);
  }
}
