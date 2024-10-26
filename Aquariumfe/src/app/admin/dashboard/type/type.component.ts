import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TypeService } from '../services/type.service';

@Component({
  selector: 'app-type',
  templateUrl: './type.component.html',
  styleUrls: ['./type.component.css']
})
export class TypeComponent implements OnInit {
  typeList: any[] = [];
  typeForm = {
    price: null,
    typeName: '',
    description: '',
    status: '',
  };
  typeId: number | null = null;
  priceError: string = '';
  typeNameError: string = '';
  descriptionError: string = '';
  statusError: string = '';
  generalErrorMessage: string = '';
  isUpdateMode: boolean = false;

  constructor(private router: Router, private typeService: TypeService) {}

  ngOnInit() {
    this.fetchTypes();
  }

  fetchTypes() {
    this.typeService.getAllTypes().subscribe(
      (data: any) => {
        this.typeList = data; 
      },
      error => {
        console.error('Error fetching types:', error); 
      }
    );
  }

  editType(id: number) {
    this.typeId = id;
    this.isUpdateMode = true;
    this.getTypeData(this.typeId);
  }

  getTypeData(id: number) {
    this.typeService.getTypesById(id).subscribe(
      (typeData: any) => {
        this.typeForm = {
          price: typeData.price,
          typeName: typeData.typeName,
          description: typeData.description,
          status: typeData.status,
        };
      },
      (error) => {
        console.error('Failed to fetch type:', error);
        this.generalErrorMessage = 'Could not retrieve type data. Please try again.';
      }
    );
  }

  onSubmit(): void {
    this.resetErrorMessages();
    const typeData = {
      price: this.typeForm.price,
      typeName: this.typeForm.typeName,
      description: this.typeForm.description,
      status: this.typeForm.status,
    };

    const typeObservable = this.isUpdateMode && this.typeId
      ? this.typeService.updateTypes(this.typeId, typeData)
      : this.typeService.createTypes(typeData);

    typeObservable.subscribe(
      (response) => {
        console.log(`${this.isUpdateMode ? 'Type updated' : 'Type created'} successfully:`, response);
        this.fetchTypes(); // Refresh the list
        this.resetForm();
      },
      (error) => {
        this.handleErrors(error);
      }
    );
  }

  handleErrors(error: any) {
    this.resetErrorMessages();

    if (error.error && error.error.errors) {
      this.priceError = error.error.errors.price || '';
      this.typeNameError = error.error.errors.typeName || '';
      this.descriptionError = error.error.errors.description || '';
      this.statusError = error.error.errors.status || '';
    } else {
      this.generalErrorMessage = 'An unknown error occurred. Please try again later.';
    }
  }

  resetErrorMessages() {
    this.priceError = '';
    this.typeNameError = '';
    this.descriptionError = '';
    this.statusError = '';
    this.generalErrorMessage = '';
  }

  resetForm() {
    this.typeForm = {
      price: null,
      typeName: '',
      description: '',
      status: 'ACTIVE',
    };
    this.isUpdateMode = false;
  }
}
