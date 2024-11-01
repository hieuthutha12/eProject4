import { Component, ElementRef, HostListener, ViewChild } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  isHeaderHidden = false;
  lastScrollTop = 0;

  @HostListener("window:scroll", [])
  onWindowScroll() {
    const currentScroll = window.pageYOffset || document.documentElement.scrollTop;
    this.isHeaderHidden = currentScroll > this.lastScrollTop; // Hide header when scrolling down
    this.lastScrollTop = currentScroll;
  }

  @ViewChild('userDropdown') userDropdown!: ElementRef;
  @ViewChild('animalsDropdown') animalsDropdown!: ElementRef;

  @HostListener('document:click', ['$event'])
  onClickOutside(event: Event) {
    // Close User Dropdown
    if (this.userDropdown && !this.userDropdown.nativeElement.contains(event.target)) {
      (document.getElementById('user-dropdown-toggle') as HTMLInputElement).checked = false;
    }

    // Close Animals Dropdown
    if (this.animalsDropdown && !this.animalsDropdown.nativeElement.contains(event.target)) {
      (document.getElementById('dropdown-toggle') as HTMLInputElement).checked = false;
    }
  }
}
