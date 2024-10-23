import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.css']
})
export class EventFormComponent {
  @Input() eventData: any = null; // Input to receive data for update
  @Output() formSubmit = new EventEmitter<any>(); // Output to emit the form data

  eventForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.eventForm = this.fb.group({
      title: ['', Validators.required],
      date: ['', Validators.required],
      location: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  ngOnInit() {
    if (this.eventData) {
      this.eventForm.patchValue(this.eventData); 
    }
  }

  onSubmit() {
    if (this.eventForm.valid) {
      this.formSubmit.emit(this.eventForm.value);
    }
  }
}
