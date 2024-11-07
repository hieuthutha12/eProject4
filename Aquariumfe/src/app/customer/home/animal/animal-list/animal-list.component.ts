import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AnimalService } from '../../services/animal.service';
import { error } from 'console';

@Component({
  selector: 'app-animal-list',
  templateUrl: './animal-list.component.html',
  styleUrl: './animal-list.component.css'
})
export class AnimalListComponent implements OnInit {
  animals: any[] = [];  
  originalAnimals: any[] = [];
  filteredAnimals: any[] = [];
  searchTerm: string = '';
  currentPage: number = 1;
  animalsPerPage: number = 8;
  totalPages: number = 0;

  constructor(private router: Router, private animalService: AnimalService) {}

  ngOnInit() {
    this.fetchAnimal();
  }
  fetchAnimal() {
    this.animalService.getAllAnimals().subscribe(
      (data: any[]) => {
        this.originalAnimals = data;
        this.filteredAnimals = [...this.originalAnimals];
        this.totalPages = Math.ceil(this.filteredAnimals.length / this.animalsPerPage);
        this.updateAnimals();
      }
    );
  }
  onSearch() {
    this.currentPage = 1;
    const searchTermLower = this.searchTerm.toLowerCase();

    if (this.searchTerm) {
      this.filteredAnimals = this.originalAnimals.filter(animal =>
        animal.name && animal.name.toLowerCase().includes(searchTermLower)
        ||animal.name.toLowerCase().startsWith(searchTermLower));
    } else {
      this.filteredAnimals = [...this.originalAnimals];
    }

    this.totalPages = Math.ceil(this.filteredAnimals.length / this.animalsPerPage);
    this.updateAnimals();
  }
  // goToNextPage() {
  //   if (this.currentPage < this.totalPages) {
  //     this.currentPage++;
  //     this.updateAnimals();
  //   }
  // }

  // goToPreviousPage() {
  //   if (this.currentPage > 1) {
  //     this.currentPage--;
  //     this.updateAnimals();
  //   }
  // }

  // updateAnimals() {
  //   const startIndex = (this.currentPage - 1) * this.animalsPerPage;
  //   this.animals = this.filteredAnimals.slice(startIndex, startIndex + this.animalsPerPage);
  // }

  updateAnimals() {
    const startIndex = (this.currentPage - 1) * this.animalsPerPage;
    const endIndex = startIndex + this.animalsPerPage;
    this.animals = this.filteredAnimals.slice(startIndex, startIndex + this.animalsPerPage);
  }

  goToPreviousPage() {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.updateAnimals();
    }
  }

  goToNextPage() {
    if (this.currentPage < this.totalPages) {
      this.currentPage++;
      this.updateAnimals();
    }
  }

  goToPage(page: number) {
    this.currentPage = page;
    this.updateAnimals();
  }

  getPageNumbers(): number[] {
    const pageNumbers = [];
    const startPage = Math.max(1, this.currentPage - 2);
    const endPage = Math.min(this.totalPages, this.currentPage + 2);

    for (let i = startPage; i <= endPage; i++) {
      pageNumbers.push(i);
    }

    return pageNumbers;
  }
}

