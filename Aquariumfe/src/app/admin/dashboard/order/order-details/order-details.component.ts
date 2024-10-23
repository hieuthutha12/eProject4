import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {
  orderId: string | null = null; // To hold the order ID
  orderDetails: any; // Placeholder for the order details

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.orderId = params.get('id'); // Get the ID from route params
      // Fetch the order details by ID (e.g., from a service)
      this.orderDetails = {
        id: this.orderId,
        item: 'Event Ticket 1',
        date: '2023-12-01',
        status: 'Completed',
        buyer: 'John Doe',
        paymentMethod: 'Credit Card'
      }; // Mock data for demonstration
    });
  }
}
