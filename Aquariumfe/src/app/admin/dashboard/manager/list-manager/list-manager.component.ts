import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
@Component({
  selector: 'app-list-manager',
  templateUrl: './list-manager.component.html',
  styleUrl: './list-manager.component.css'
})
export class ListManagerComponent {
  Listmana: any[] = [];

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.loadManagers();
  }

  loadManagers() {
    this.userService.getManagers().subscribe(
      (data) => {
        this.Listmana = data;
      },
      (error) => {
        console.error('Error fetching manager', error);
      }
    );
  }

  editCreature(id: number) {
    this.router.navigate(['/manager/update', id]);
  }
  addCreature() {
    this.router.navigate(['/admin/dashboard/manafer/form']);
  }
  searchUser(): void {
    
    const input: string = (document.getElementById("searchInput") as HTMLInputElement).value.toUpperCase();
    const table: HTMLTableElement = document.getElementById("userTable") as HTMLTableElement;
    const tr: HTMLCollectionOf<HTMLTableRowElement> = table.getElementsByTagName("tr");

    
    for (let i = 1; i < tr.length; i++) {
      const td: HTMLCollectionOf<HTMLTableCellElement> = tr[i].getElementsByTagName("td");
      let match: boolean = false;
      for (let j = 0; j < td.length; j++) {
        if (td[j]) {
          if (td[j].innerHTML.toUpperCase().indexOf(input) > -1) {
            match = true;
            break;
          }
        }
      }

      // Show or hide the row based on the search result
      tr[i].style.display = match ? "" : "none";
    }
  }
}
