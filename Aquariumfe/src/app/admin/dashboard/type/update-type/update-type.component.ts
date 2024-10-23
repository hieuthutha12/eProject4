import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-type',
  templateUrl: './update-type.component.html',
  styleUrls: ['./update-type.component.css']
})
export class UpdateTypeComponent implements OnInit {
  typeId: string | null = null;
  typeData: any = {}; // Placeholder for type data

  constructor(private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.typeId = params.get('id'); // Get the ID from route params
      // Fetch the type data by ID (e.g., from a service)
      this.typeData = {
        id: this.typeId,
        name: 'Sample Type',
        description: 'This is a sample type description.'
      }; // Mock data for demonstration
    });
  }

  onSubmit(typeData: any) {
    // Here you would typically make a service call to update the type
    console.log('Type Updated:', typeData);
    this.router.navigate(['/types/list']); // Navigate to list after submission
  }
}
