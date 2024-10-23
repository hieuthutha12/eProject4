import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-aquatic-creatures',
  templateUrl: './update-aquatic-creatures.component.html',
  styleUrls: ['./update-aquatic-creatures.component.css']
})
export class UpdateAquaticCreaturesComponent implements OnInit {
  creatureId: string | null = null; 
  creatureData: any;

  constructor(private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.creatureId = params.get('id'); 
      
      this.creatureData = {
        name: 'Shark',
        type: 'Fish',
        habitat: 'Ocean',
        description: 'A large predatory fish.'
      }; // Mock data for demonstration
    });
  }

  onFormSubmit(data: any) {
    
    console.log('Updating aquatic creature:', data);
    
    this.router.navigate(['/aquatic-creatures/list']);
  }
}
