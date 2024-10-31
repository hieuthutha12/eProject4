import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ManagerService } from '../../services/manager.service';
@Component({
  selector: 'app-list-manager',
  templateUrl: './list-manager.component.html',
  styleUrl: './list-manager.component.css'
})
export class ListManagerComponent {
  Listmana: any[] = [];

  constructor(private router: Router, private managerService: ManagerService) { }

  ngOnInit() {
    this.loadCreatures();
  }

  loadCreatures() {
    this.managerService.getAllManagers().subscribe(
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
    // Get the value from the search input
    const input: string = (document.getElementById("searchInput") as HTMLInputElement).value.toUpperCase();
    const table: HTMLTableElement = document.getElementById("userTable") as HTMLTableElement;
    const tr: HTMLCollectionOf<HTMLTableRowElement> = table.getElementsByTagName("tr");

    // Iterate through all rows in the table and hide those that don't match the search
    for (let i = 1; i < tr.length; i++) {
      const td: HTMLCollectionOf<HTMLTableCellElement> = tr[i].getElementsByTagName("td");
      let match: boolean = false;

      // Check each cell in the row
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
