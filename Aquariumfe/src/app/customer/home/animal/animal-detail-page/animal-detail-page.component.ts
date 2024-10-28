import { Component } from '@angular/core';

@Component({
  selector: 'app-animal-detail-page',
  templateUrl: './animal-detail-page.component.html',
  styleUrl: './animal-detail-page.component.css'
})
export class AnimalDetailPageComponent {
  images = [
    'assets/img/abalone.jpg',
    'assets/img/test.jpg',
    'assets/img/turtle.jpg'
  ];
  currentImageIndex = 0;

  nextImage() {
    this.currentImageIndex = (this.currentImageIndex + 1) % this.images.length;
  }

  prevImage() {
    this.currentImageIndex = (this.currentImageIndex - 1 + this.images.length) % this.images.length;
  }
}
