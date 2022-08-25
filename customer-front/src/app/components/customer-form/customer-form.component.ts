import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Customer } from './../../Customer';
import { CustomerService } from './../../services/customer.service';
import { NgbCalendar, NgbDate, NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { faCalendar } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {
  @Output() addCustomer: EventEmitter<Customer> = new EventEmitter();
  customerName: string = '';
  customerSurname: string = '';
  customerBirthdate: any = '';
  customerPhoneNumber: string = '';
  customerEmail: string = '';
  successfullyAdded: boolean = false;
  errors: any[] = [];
  minDate: NgbDate;
  maxDate: NgbDate;
  faCalendar = faCalendar;

  constructor(private service: CustomerService, private parserFormatter: NgbDateParserFormatter, private calendar: NgbCalendar) {
    this.minDate = calendar.getPrev(calendar.getToday(), 'y', 120);
    this.maxDate = calendar.getToday();
  }

  ngOnInit(): void {
  }

  handleSubmit() {
    const newCustomer: Customer = {
      name: this.customerName.trim(),
      surname: this.customerSurname.trim(),
      birthdate: this.parserFormatter.format(this.customerBirthdate),
      phoneNumber: this.customerPhoneNumber.trim(),
      email: this.customerEmail.trim()
    }
    this.service.addCustomer(newCustomer).subscribe(
      (customer) => {
        this.service.customerSource.next(customer);
        this.successfullyAdded = true;

        setTimeout(() => {
          this.successfullyAdded = false;
        }, 1000);
      },
      ({ error }) => {
        Object.values(error.details).forEach(msg=>this.errors.push(msg))
        setTimeout(() => {
          this.errors = [];
        }, 2000);
      }
    );
  }

  prefillForm() {
    this.service.generateCustomerData().subscribe(customer => {
      this.customerName = customer.name;
      this.customerSurname = customer.surname;
      this.customerPhoneNumber = customer.phoneNumber;
      this.customerEmail = customer.email;
    })
  }

}
