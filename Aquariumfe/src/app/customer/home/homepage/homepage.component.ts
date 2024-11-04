import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AnimalService } from '../services/animal.service';
import { AlertService } from '../../../shared/custom-alert/alert.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css'
})
export class HomepageComponent implements OnInit {
  animals: any[] = [];  

  constructor(private router: Router, private animalService: AnimalService,private alertService: AlertService) {}

  ngOnInit() {
    this.fetchAnimal();
  }
  fetchAnimal() {
    this.animalService.getAllDistinctCreatures().subscribe(
      (data: any[]) => {
        this.animals = this.getRandomAnimals(data, 3);
      }
    );
  }
  
  getRandomAnimals(array: any[], count: number): any[] {
    const shuffled = array.sort(() => 0.5 - Math.random());
    return shuffled.slice(0, count);
  }
  
}
