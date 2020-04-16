import { Component } from '@angular/core';
import { MotorcycleService } from './services/motorcycle.service';
import {FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'moto-ui';
  search: FormGroup;

  constructor(private motorcycleService: MotorcycleService) { }
}
