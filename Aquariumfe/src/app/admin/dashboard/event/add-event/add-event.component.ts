import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})
export class AddEventComponent {
  
  constructor(private router: Router) {}

  onFormSubmit(data: any) {
  
    console.log('Adding event:', data);
    
    this.router.navigate(['/events/list']);
  }
}
