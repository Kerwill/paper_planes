import { Component } from '@angular/core';
import { IdeeService } from './idee.service';
import { Idee } from './idee';

@Component({
    selector: 'myIdee',
    templateUrl: 'app/idee.component.html',
    styleUrls: ['app/idee.component.css']
	})

export class IdeeComponent {
private idee: Idee = new Idee();

  constructor(private ideeService : IdeeService) {}

  public addIdee(){
  this.ideeService.save(this.idee);
  this.idee = new Idee();
}
}
