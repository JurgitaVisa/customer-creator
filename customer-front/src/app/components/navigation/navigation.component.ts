import { Component, OnInit } from '@angular/core';
import {NgbNavConfig} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(config: NgbNavConfig) {
    config.destroyOnHide = false;
    config.roles = false;
   }

  ngOnInit(): void {
  }

}
