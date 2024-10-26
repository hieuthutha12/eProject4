import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AquaticCreaturesService } from '../../services/aquatic-creatures.service'; 

@Component({
  selector: 'app-list-aquatic-creatures',
  templateUrl: './list-aquatic-creatures.component.html',
  styleUrls: ['./list-aquatic-creatures.component.css']
})
export class ListAquaticCreaturesComponent implements OnInit {
  creatures: any[] = []; 

  constructor(private router: Router, private aquaticCreaturesService: AquaticCreaturesService) {}

  ngOnInit() {
    this.loadCreatures();
  }

  loadCreatures() {
    this.aquaticCreaturesService.getAllCreatures().subscribe(
      (data) => {
        this.creatures = data; 
      },
      (error) => {
        console.error('Error fetching aquatic creatures', error);
      }
    );
  }

  editCreature(id: number) {
    this.router.navigate(['/aquatic-creatures/update', id]); 
  }
}
