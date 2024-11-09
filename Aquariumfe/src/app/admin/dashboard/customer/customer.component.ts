import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent {
  // customerList: any[] = [];
  // constructor(private router: Router, private customerService: CustomerService) { }

  // ngOnInit() {
  //   this.fetchCus();
  // }

  // fetchCus() {
  //   this.customerService.getAllCustomers().subscribe(
  //     (data: any) => {
  //       this.customerList = data;
  //     },
  //     error => {
  //       console.error('Error fetching customer:', error);
  //     }
  //   );
  // }
  // searchUser(): void {
  //   const input: string = (document.getElementById("searchInput") as HTMLInputElement).value.toUpperCase();
  //   const table: HTMLTableElement = document.getElementById("userTable") as HTMLTableElement;
  //   const tr: HTMLCollectionOf<HTMLTableRowElement> = table.getElementsByTagName("tr");
  //   for (let i = 1; i < tr.length; i++) {
  //     const td: HTMLCollectionOf<HTMLTableCellElement> = tr[i].getElementsByTagName("td");
  //     let match: boolean = false;

  //     for (let j = 0; j < td.length; j++) {
  //       if (td[j]) {
  //         if (td[j].innerHTML.toUpperCase().indexOf(input) > -1) {
  //           match = true;
  //           break;
  //         }
  //       }
  //     }

  //     tr[i].style.display = match ? "" : "none";
  //   }
  // }

}
