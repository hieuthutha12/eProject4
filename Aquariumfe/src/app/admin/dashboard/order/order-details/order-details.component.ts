import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {
  orderId: string | null = null; 
  orderDetails: any; 

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.orderId = params.get('id'); 
      
      this.orderDetails = {
        id: this.orderId,
        item: 'Event Ticket 1',
        date: '2023-12-01',
        status: 'Completed',
        buyer: 'John Doe',
        paymentMethod: 'Credit Card'
      }; 
    });
  }
}
