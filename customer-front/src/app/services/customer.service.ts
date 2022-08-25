import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Customer } from './../Customer';
import { environment } from './../../environments/environment.prod';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': 'allow-all'
  }),
};

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private apiUrl = environment.serverUrl;
  CUSTOMERS: Customer[] = [];
  customerSource: BehaviorSubject<Customer> = new BehaviorSubject(
    {
      name: '',
      surname: '',
      birthdate: '',
      phoneNumber: '',
      email: ''
    }
  );

  constructor(private http: HttpClient) { }

  getCustomerList(): Observable<Customer[]> {
    const url = `${this.apiUrl}/all`;
    return this.http.get<Customer[]>(url);
  }

  deleteCustomer(customer: Customer): Observable<Customer> {
    const url = `${this.apiUrl}/delete/${customer.id}`;
    return this.http.delete<Customer>(url);
  }

  addCustomer(customer: Customer): Observable<Customer> {
    console.log(customer);
    const url = `${this.apiUrl}/create`;
    return this.http.post<Customer>(url, customer, httpOptions);
  }

  generateCustomerData(): Observable<Customer> { 
    const url = `${this.apiUrl}/temporary`;
    return this.http.get<Customer>(url);
  }
}
