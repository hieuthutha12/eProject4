import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TicketService } from '../services/ticket.service';

interface BuyTicket{
  userId: number;
  totalAmount: number;
  discount: number;
  orderDetails: OrderDetails[];
} 
interface OrderDetails{
  price: number;
  ticket: Ticket[];
}
interface Ticket{
  purchaseDate: String;
  expirationDate: String;
  typeId: number;
}
interface TypeQuantity {
  typeId: number;   
  quantity: number; 
}

@Component({
  selector: 'app-ticket-booking',
  templateUrl: './buy-ticket.component.html',
  styleUrls: ['./buy-ticket.component.css']
})

export class BuyTicketComponent implements OnInit {
  minDate: string = "";
  currentStep: number = 1;
  score: number = 0;
  
  showAlert: boolean = false;
  alertMessage: string = '';
  typeQuantity: TypeQuantity[] = [];
  constructor(private router: Router, private ticketService: TicketService) {
      const today = new Date();
      this.minDate = today.toISOString().split('T')[0];
  }
  ngOnInit(): void {
      this.fetchTypes();
  }
  //step 3
  getTypeById(id: number): any {
    return this.types.find(type => type.id === id) || null;
  }

  removeTypeQuantity(typeId: number) {
    const index = this.typeQuantity.findIndex(item => item.typeId === typeId);
    if (index !== -1) {
        this.typeQuantity.splice(index, 1);
    }
}
  //step 2
  changeNum(num: number, id: number) {
    const typeIndex = this.typeQuantity.findIndex(item => item.typeId === id);
    if (typeIndex !== -1) {
        
        if ((this.typeQuantity[typeIndex].quantity > 0 && num === -1) || 
            (this.typeQuantity[typeIndex].quantity < 15 && num === 1)) {
            this.typeQuantity[typeIndex].quantity += num;
            console.log(this.typeQuantity[typeIndex].quantity);
        }
    } else {
        if (num === 1) {
            this.typeQuantity.push({ typeId: id, quantity: 1 });
        }
    }
  }
  getQuantity(typeId: number): number {
    if (!this.typeQuantity) return 0; 
    const type = this.typeQuantity.find(item => item.typeId === typeId);
    return type ? type.quantity : 0;
  }


  confirmStepTwo() {
    this.typeQuantity = this.typeQuantity.filter(item => item.quantity > 0);
    const allQuantitiesZero = this.typeQuantity.every(item => item.quantity === 0);
    if (allQuantitiesZero) {
      this.alertMessage = 'Please select at least one type and quantity.';
      this.showAlert = true;
    }else{
      this.showAlert = false;
      this.nextStep();
    }
  }
  //step 1
  selectedDate: string = "";
  selectedTime: string = "";
  nextDayDate: string = "";
  updateDate(date: string) {
    this.selectedDate = date;
  }
  onDateChange() {
    if (this.selectedDate) {
      const date = new Date(this.selectedDate);
      date.setDate(date.getDate() + 1);
      this.nextDayDate = date.toISOString().split('T')[0];
    }
  }
  confirmStepOne() {
    if (this.selectedDate && this.selectedTime) {
      const formattedDateTime = `${this.selectedDate}T${this.selectedTime}`;
      const formattedNextDateTime = `${this.nextDayDate}T${this.selectedTime}`;
      this.showAlert = false;
      this.nextStep();
    } else {
      this.alertMessage = 'Please select both date and time.';
      this.showAlert = true;
    }
  }
  showWarning(message: string) {
    alert(message);
  }
    // next page
  nextStep() {
    if (this.currentStep < 4) {
      this.currentStep++;
    }
  }

  prevStep() {
    if (this.currentStep > 1) {
      this.currentStep--;
    }
  }

  submitScore() {
    console.log(`Score submitted: ${this.score}`);
  }
//  getType
  types: any[]=[];
  fetchTypes() {
    this.ticketService.getAllTypeOnActive().subscribe(
      (data: any) => {
        this.types = data; 
        this.types.forEach(item => {
          this.typeQuantity.push({ typeId: item.id, quantity: 0 });
      });
      },
      error => {
        console.error('Error fetching events:', error); 
      }
    );
  }
}

