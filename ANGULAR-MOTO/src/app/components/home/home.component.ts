import { Component, OnInit } from '@angular/core';
import { MotorcycleService} from "../../services/motorcycle.service";
import {FormGroup, FormControl, Validators } from "@angular/forms";
import {Observable} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  motorcycleForm: FormGroup;
  validMessage: string = "";
  constructor(private motorcycleService: MotorcycleService) { }

  ngOnInit(){
    this.motorcycleForm = new FormGroup({
      owner_name: new FormControl('', Validators.required),
      manufacturer: new FormControl('', Validators.required),
      model: new FormControl('', Validators.required),
      productionYear: new FormControl('', Validators.required),
      size: new FormControl('', Validators.required),
      registration: new FormControl('', Validators.required),
      mileage: new FormControl('', Validators.required),
      purchaseprice: new FormControl('', Validators.required),
      purchasedate: new FormControl(),
    });
  }

  submitRegistration(){
    if (this.motorcycleForm.valid){
      this.validMessage = "Motorcycle registered successfuly!";
      this.motorcycleService.createMotorcycleRegistration(this.motorcycleForm.value).subscribe(
        data => {
          this.motorcycleForm.reset();
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      )
    } else {
      this.validMessage = "Please fill the form before submitting!";
    }
  }

}
