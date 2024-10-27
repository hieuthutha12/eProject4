import { Component } from '@angular/core';

@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrl: './animal.component.css'
})
export class AnimalComponent {
  animals: Animal[] = [
    { name: "Asian small-clawed otter", image: "assets/images/otter.jpg" },
    { name: "Asiatic lion", image: "assets/images/lion.jpg" },
    { name: "Azara's agouti", image: "assets/images/agouti.jpg" },
    { name: "Baer's pochard", image: "assets/images/pochard.jpg" },
    { name: "Blue poison dart frog", image: "assets/images/frog.jpg" },
    { name: "Capuchin monkey", image: "assets/images/monkey.jpg" },
    // Add more animals as needed
  ];

  filteredAnimals: Animal[] = [...this.animals]; // Initially show all animals
  searchValue: string = '';
  currentPage: number = 1;
  itemsPerPage: number = 4;

  constructor() {
    this.updateFilteredAnimals();
  }

  // Filter animals based on search input
  filterAnimals(): void {
    this.currentPage = 1; // Reset to first page
    this.updateFilteredAnimals();
  }

  // Update filteredAnimals based on search and pagination
  updateFilteredAnimals(): void {
    const searchLower = this.searchValue.toLowerCase();
    const filtered = this.animals.filter(animal =>
      animal.name.toLowerCase().includes(searchLower)
    );
    const start = (this.currentPage - 1) * this.itemsPerPage;
    const end = start + this.itemsPerPage;
    this.filteredAnimals = filtered.slice(start, end);
  }

  // Go to the next page
  nextPage(): void {
    this.currentPage++;
    this.updateFilteredAnimals();
  }

  // Go to the previous page
  previousPage(): void {
    this.currentPage--;
    this.updateFilteredAnimals();
  }

  // Check if there's a next page
  hasNextPage(): boolean {
    const searchLower = this.searchValue.toLowerCase();
    const filtered = this.animals.filter(animal =>
      animal.name.toLowerCase().includes(searchLower)
    );
    return this.currentPage * this.itemsPerPage < filtered.length;
  }

  // Check if there's a previous page
  hasPreviousPage(): boolean {
    return this.currentPage > 1;
  }
}
