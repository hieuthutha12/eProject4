import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-aquatic-creatures-form',
  templateUrl: './aquatic-creatures-form.component.html',
  styleUrls: ['./aquatic-creatures-form.component.css']
})
export class AquaticCreaturesFormComponent {
  @Input() creatureData: any = null; // Input to receive data for update
  @Output() formSubmit = new EventEmitter<any>(); // Output to emit the form data

  creatureForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.creatureForm = this.fb.group({
      name: ['', Validators.required],
      type: ['', Validators.required],
      habitat: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  ngOnInit() {
    if (this.creatureData) {
      this.creatureForm.patchValue(this.creatureData); 
    }
  }

  onSubmit() {
    if (this.creatureForm.valid) {
      this.formSubmit.emit(this.creatureForm.value); 
    }
  }
}
