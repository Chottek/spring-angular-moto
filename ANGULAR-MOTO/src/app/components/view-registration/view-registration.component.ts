import { Component, OnInit } from '@angular/core';
import { MotorcycleService} from '../../services/motorcycle.service';
import { ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-view-registration',
  templateUrl: './view-registration.component.html',
  styleUrls: ['./view-registration.component.css']
})
export class ViewRegistrationComponent implements OnInit {

  public motoReg;

  constructor(private motorcycleService: MotorcycleService, private route: ActivatedRoute) { }

  ngOnInit(){
     this.getMotoReg(this.route.snapshot.params.id);
  }

  getMotoReg(id: number){
    this.motorcycleService.getMotorcycle(id).subscribe(
      data => {
        this.motoReg = data;
      },
      err => console.error(err),
            () => console.log('motorcycles loaded')
    );
  }

  deleteMotorcycle(id: number){
    return this.motorcycleService.deleteMotorcycle(id);
  }

}
