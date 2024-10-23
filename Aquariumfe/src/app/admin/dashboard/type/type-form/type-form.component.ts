import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-type-form',
  templateUrl: './type-form.component.html',
  styleUrls: ['./type-form.component.css']
})
export class TypeFormComponent {
  @Input() typeData: any; // For receiving existing data for update
  @Output() submitForm = new EventEmitter<any>(); // Emit form submission
  typeForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.typeForm = this.fb.group({
      name: ['', Validators.required],
      description: ['']
    });
  }

  ngOnChanges() {
    if (this.typeData) {
      this.typeForm.patchValue(this.typeData); // Fill form for editing
    }
  }

  onSubmit() {
    if (this.typeForm.valid) {
      this.submitForm.emit(this.typeForm.value);
    }
  }
}
