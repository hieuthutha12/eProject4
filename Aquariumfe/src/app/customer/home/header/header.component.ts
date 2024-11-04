import { Component, ElementRef, HostListener, ViewChild } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { UserInfo } from '../../../models/user-info.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  isHeaderHidden = false;
  lastScrollTop = 0;

  constructor(private authService : AuthService, private router :Router){}

  userInfo: UserInfo | null = null;
  
  ngOnInit(): void {
    this.authService.userInfo$.subscribe(user => {
      this.userInfo = user;
    });
  }
  checkLogin(): boolean{
    return this.authService.isLoggedIn();
  }
  @HostListener("window:scroll", [])
  onWindowScroll() {
    const currentScroll = window.pageYOffset || document.documentElement.scrollTop;
    this.isHeaderHidden = currentScroll > this.lastScrollTop;
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
  logout(): void {
    this.authService.logout();
    this.router.navigate(['/home']);
  }
}
