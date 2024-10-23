import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-aquatic-creatures',
  templateUrl: './add-aquatic-creatures.component.html',
  styleUrls: ['./add-aquatic-creatures.component.css']
})
export class AddAquaticCreaturesComponent {
  
  constructor(private router: Router) {}

  onFormSubmit(data: any) {
    console.log('Adding aquatic creature:', data);
    this.router.navigate(['/aquatic-creatures/list']);
  }
}
