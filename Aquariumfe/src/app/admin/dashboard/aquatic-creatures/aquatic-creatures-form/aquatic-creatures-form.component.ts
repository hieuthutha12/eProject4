import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AquaticCreaturesService } from '../../services/aquatic-creatures.service';

interface AquaticCreaturesForm {
  name: string;
  weight: number;
  length: number;
  entryDate: Date;
  exhibitStatus: string;
  userId: number;
  speciesId: number;
  images: File[] | null;
}

@Component({
  selector: 'app-aquatic-creatures-form',
  templateUrl: './aquatic-creatures-form.component.html',
  styleUrls: ['./aquatic-creatures-form.component.css']
})
export class AquaticCreaturesFormComponent implements OnInit {
  aquaticCreaturesForm: AquaticCreaturesForm = {
    name: '',
    weight: 0,
    length: 0,
    entryDate: new Date(),
    exhibitStatus: '',
    userId: 1,
    speciesId: 1,
    images: null,
  };
  creatureId: number | null = null;
  nameError: string = '';
  weightError: string = '';
  lengthError: string = '';
  entryDateError: string = '';
  exhibitStatusError: string = '';
  generalErrorMessage: string = '';
  isUpdateMode: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private aquaticCreaturesService: AquaticCreaturesService
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.creatureId = parseInt(id, 10);
        this.isUpdateMode = true;
        this.getAquaticCreatureData(this.creatureId);
      }
    });
  }

  getAquaticCreatureData(id: number) {
    this.aquaticCreaturesService.getCreatureById(id).subscribe(
      (creatureData: any) => {
        this.aquaticCreaturesForm = {
          name: creatureData.name,
          weight: creatureData.weight,
          length: creatureData.length,
          entryDate: new Date(creatureData.entryDate),
          exhibitStatus: creatureData.exhibitStatus,
          userId: creatureData.userId,
          speciesId: creatureData.speciesId,
          images: null,
        };
      },
      error => {
        console.error('Failed to fetch aquatic creature:', error);
        this.generalErrorMessage = 'Could not retrieve aquatic creature data. Please try again.';
      }
    );
  }

  onSubmit(): void {
    this.resetErrorMessages();

    const formData = this.createFormData();

    const creatureObservable = this.isUpdateMode && this.creatureId
      ? this.aquaticCreaturesService.updateCreature(this.creatureId, formData)
      : this.aquaticCreaturesService.createCreature(formData);

    creatureObservable.subscribe(
      response => {
        console.log(`${this.isUpdateMode ? 'Aquatic creature updated' : 'Aquatic creature created'} successfully:`, response);
        this.router.navigate(['/aquatic-creatures/list']);
      },
      error => {
        this.handleErrors(error);
      }
    );
  }

  createFormData(): FormData {
    const formData = new FormData();
    formData.append('name', this.aquaticCreaturesForm.name);
    formData.append('weight', this.aquaticCreaturesForm.weight.toString());
    formData.append('length', this.aquaticCreaturesForm.length.toString());
    formData.append('entryDate', this.aquaticCreaturesForm.entryDate.toISOString());
    formData.append('exhibitStatus', this.aquaticCreaturesForm.exhibitStatus);
    formData.append('userId', this.aquaticCreaturesForm.userId.toString());
    formData.append('speciesId', this.aquaticCreaturesForm.speciesId.toString());

    if (this.aquaticCreaturesForm.images) {
      this.aquaticCreaturesForm.images.forEach(image => {
        formData.append('images', image);
      });
    }
    return formData;
  }

  handleErrors(error: any) {
    this.resetErrorMessages();

    if (error.error && error.error.errors) {
      this.nameError = error.error.errors.name || '';
      this.weightError = error.error.errors.weight || '';
      this.lengthError = error.error.errors.length || '';
      this.entryDateError = error.error.errors.entryDate || '';
      this.exhibitStatusError = error.error.errors.exhibitStatus || '';
    } else {
      this.generalErrorMessage = 'An unknown error occurred. Please try again later.';
    }
  }

  resetErrorMessages() {
    this.nameError = '';
    this.weightError = '';
    this.lengthError = '';
    this.entryDateError = '';
    this.exhibitStatusError = '';
    this.generalErrorMessage = '';
  }

  onFileChange(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length) {
      this.aquaticCreaturesForm.images = Array.from(input.files);
    }
  }
}
