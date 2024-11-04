import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root', 
})
export class AlertService {
  private alertMessageSource = new BehaviorSubject<string | null>(null);
  alertMessage$ = this.alertMessageSource.asObservable();

  showAlert(message: string) {
    this.alertMessageSource.next(message);
  }

  clearAlert() {
    this.alertMessageSource.next(null);
  }
}
