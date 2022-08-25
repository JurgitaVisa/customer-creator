import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Customer } from './../../Customer';
import { faTrash, faInfo } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-actions',
  templateUrl: './actions.component.html',
  styleUrls: ['./actions.component.css']
})
export class ActionsComponent implements OnInit {  
  @Input() customer!: Customer;
  @Output() onDeleteCustomer = new EventEmitter();
  @Output() onShowCustomerDetails= new EventEmitter();

  faInfo = faInfo;
  faTrash = faTrash;

  constructor() { }

  ngOnInit(): void {
  }

  onDelete(customer:Customer) {
    this.onDeleteCustomer.emit(customer);
  }

  onShow(customer:Customer) {
    this.onShowCustomerDetails.emit(customer);
  }

}
