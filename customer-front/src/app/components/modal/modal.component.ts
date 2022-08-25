import { Component, Input, ViewEncapsulation } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Customer } from './../../Customer';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  encapsulation: ViewEncapsulation.None,
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {
  @Input() customer!: Customer;
  closeResult: string = '';

  constructor(private activeModal: NgbActiveModal) { }

  ngOnInit(): void {
  }

  closeModal() {
    this.activeModal.close('Modal Closed');
  }

  objectFields(customer: Customer) {
    let fields: any[] = [];
    Object.entries(customer).forEach(
      entry => {
        let newEntry = [];
        newEntry[0] = entry[0]
          .replace(/([a-z])([A-Z])/g, '$1 $2')
          .replace(/^./, entry[0][0].toUpperCase());
        newEntry[1] = entry[1];
        fields.push(newEntry);
      });
    return fields;
  }
}
