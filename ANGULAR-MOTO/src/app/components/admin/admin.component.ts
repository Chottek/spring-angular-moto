import { Component, OnInit } from '@angular/core';
import { MotorcycleService } from "../../services/motorcycle.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  public motorcycles;

  constructor(private motorcycleService: MotorcycleService) { }

  ngOnInit() {
    this.getMotorcycles();
  }

  getMotorcycles(){
    this.motorcycleService.getMotorcycles().subscribe(
      data => { this.motorcycles = data},
           err => console.error(err),
          () => console.log('motorcycles loaded')
    );
  }

}
