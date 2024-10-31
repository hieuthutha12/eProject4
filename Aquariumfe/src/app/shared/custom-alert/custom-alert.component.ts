import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-custom-alert',
  templateUrl: './custom-alert.component.html',
  styleUrls: ['./custom-alert.component.css']
})
export class CustomAlertComponent {
  @Input() message: string = '';
  @Input() isVisible: boolean = false;

  @Output() close = new EventEmitter<void>();

  closeAlert() {
    this.isVisible = false;
    this.close.emit(); // Gửi sự kiện để component cha xử lý
  }
}
