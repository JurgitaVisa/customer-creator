import { Pipe, PipeTransform } from '@angular/core';
import { Customer } from './../Customer';

@Pipe({
  name: 'searchfilter'
})
export class SearchfilterPipe implements PipeTransform {

  transform(Customers: Customer[], searchValue: string): Customer[] {

    if (!Customers || !searchValue) {
      return Customers;
    }

    return Customers.filter(customer =>
      customer.name.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase()) ||
      customer.surname.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase())
    );
  }

}
