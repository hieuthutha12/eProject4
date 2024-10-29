import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  isHeaderHidden = false;
  lastScrollTop = 0;

  @HostListener("window:scroll", [])
  onWindowScroll() {
    const currentScroll = window.pageYOffset || document.documentElement.scrollTop;
    if (currentScroll > this.lastScrollTop) {
      // Scrolling down
      this.isHeaderHidden = true;
    } else {
      // Scrolling up
      this.isHeaderHidden = false;
    }
    this.lastScrollTop = currentScroll;
  }
}
