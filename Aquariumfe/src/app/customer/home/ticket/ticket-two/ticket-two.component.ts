import { Component } from '@angular/core';
import { HomeComponent } from '../../home.component';
var $: any;

@Component({
  selector: 'app-ticket-two',
  templateUrl: './ticket-two.component.html',
  styleUrl: './ticket-two.component.css'
})

export class TicketTwoComponent {
  ticketTypes = [
    { 
      name: 'Adult',
      price: 26.5,
      number: 0,
      detail: "16 years +",
    },
    { 
      name: 'Kid',
      price: 10.5,
      number: 0,
      detail: "Aged 3 to 15 years old inclusive. A child ticket must be booked with an adult, concession or carer ticket",
    },
    { 
      name: 'Under 3s',
      price: 0,
      number: 0,
      detail: "Children under the age of 3 are admitted for free but must have a ticket",
    }
  ]

  changeNum(ticket: any, num: number){
    if((ticket.number > 0 && num ==-1) || (ticket.number < 15 && num ==1)){
      ticket.number += num;
    }
  }
}
