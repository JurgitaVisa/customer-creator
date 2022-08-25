import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { AppComponent } from './app.component';
import { TableComponent } from './components/table/table.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavigationComponent } from './components/navigation/navigation.component';
import { ActionsComponent } from './components/actions/actions.component';
import { ModalComponent } from './components/modal/modal.component';
import { CustomerFormComponent } from './components/customer-form/customer-form.component';
import { SearchfilterPipe } from './services/searchfilter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    NavigationComponent,
    ActionsComponent,
    ModalComponent,
    CustomerFormComponent,
    SearchfilterPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    FontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
