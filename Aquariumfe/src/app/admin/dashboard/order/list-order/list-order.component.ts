import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-order',
  templateUrl: './list-order.component.html',
  styleUrls: ['./list-order.component.css']
})
export class ListOrderComponent {
  orders = [
    { id: 1, item: 'Event Ticket 1', date: '2023-12-01', status: 'Completed' },
    { id: 2, item: 'Event Ticket 2', date: '2024-01-15', status: 'Pending' },
    // Add more orders for demonstration
  ];

  constructor(private router: Router) {}

  viewOrderDetails(id: number) {
    this.router.navigate(['/orders/details', id]); // Navigate to order details route
  }
}
