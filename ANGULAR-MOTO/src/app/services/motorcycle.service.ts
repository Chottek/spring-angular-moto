import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
}

@Injectable({
  providedIn: 'root'
})
export class MotorcycleService {

  constructor(private http: HttpClient) { }

  getMotorcycles() {
    return this.http.get('/server/api/v1/motorcycles');
  }

  getMotorcyclesByManufacturer(name: string){
    return this.http.get('/server/api/v1/motorcycles/search?by=' + name);
  }

  getMotorcycle(id: number){
     return this.http.get('/server/api/v1/motorcycles/' + id);
  }

  createMotorcycleRegistration(motorcycle){
     let body = JSON.stringify(motorcycle);
     return this.http.post('/server/api/v1/motorcycles', body, httpOptions);
  }

  deleteMotorcycle(id: number){
    const url = '/server/api/v1/motorcycles/' + id;
    return this.http.delete(url).toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Error', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
