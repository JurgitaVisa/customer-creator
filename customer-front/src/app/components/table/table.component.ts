import { Component, OnInit } from '@angular/core';
import { CustomerService } from './../../services/customer.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Customer } from '../../Customer';
import { ModalComponent } from './../modal/modal.component';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  customers: Customer[] = [];
  searchValue: string = '';
  page: number = 1;
  pageSize: number = 10;
  collectionSize: number;
  pageSizes: number[] = [10, 25, 50];

  columns: any[] = [
    { label: "#", content: (customer: Customer) => customer.id },
    { label: "Name", content: (customer: Customer) => customer.name },
    { label: "Surname", content: (customer: Customer) => customer.surname },
  ]


  constructor(private servise: CustomerService, private modalService: NgbModal) {
    this.collectionSize = this.customers.length;
  }

  ngOnInit(): void {
    this.servise.getCustomerList().subscribe(customers => this.customers = customers);
    this.servise.customerSource.subscribe((customer) => this.customers.push(customer));

  }

  handleDeleteCustomer(customer: Customer) {
    console.log(customer);
    this.servise.deleteCustomer(customer).subscribe(
      () => this.customers = this.customers.filter(entry => entry.id !== customer.id)
    );
  }

  handleShowCustomerDetails(customer: Customer) {
    console.log(customer);
    const modalRef = this.modalService.open(ModalComponent);
    modalRef.componentInstance.customer = customer;
  }

  addNewCustomer(customer: Customer) {
    this.customers.push(customer);
  }

  onTableSizeChange(event: any) {
    this.page = 1;
    this.pageSize = event.target.value;
  }

}
