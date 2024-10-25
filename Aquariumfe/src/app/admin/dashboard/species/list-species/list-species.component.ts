import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SpeciesService } from '../../services/species.service';

@Component({
  selector: 'app-list-species',
  templateUrl: './list-species.component.html',
  styleUrls: ['./list-species.component.css']
})
export class ListSpeciesComponent implements OnInit {
  speciesList: any[] = [];

  constructor(private router: Router, private speciesService: SpeciesService) {}

  ngOnInit() {
    this.fetchSpecies();
  }

  fetchSpecies() {
    this.speciesService.getAllSpecies().subscribe(
      (data: any) => {
        this.speciesList = data; 
      },
      error => {
        console.error('Error fetching species:', error); 
      }
    );
  }

  editSpecies(id: number) {
    this.router.navigate([`/admin/dashboard/species/form/${id}`]);
  }

  addSpecies() {
    this.router.navigate(['/admin/dashboard/species/form']);
  }
}
