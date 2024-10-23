import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-aquatic-creatures',
  templateUrl: './list-aquatic-creatures.component.html',
  styleUrls: ['./list-aquatic-creatures.component.css']
})
export class ListAquaticCreaturesComponent {
  creatures = [
    { id: 1, name: 'Shark', type: 'Fish', habitat: 'Ocean' },
    { id: 2, name: 'Dolphin', type: 'Mammal', habitat: 'Ocean' },
  ];

  constructor(private router: Router) {}

  editCreature(id: number) {
    this.router.navigate(['/aquatic-creatures/update', id]); 
  }
}
