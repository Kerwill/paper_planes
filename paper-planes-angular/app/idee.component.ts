import { Component } from '@angular/core';
import { IdeeService } from './idee.service';
import { Idee } from './idee';

@Component({
    templateUrl: 'app/idee.component.html',
    styleUrls: ['app/idee.component.css']
	})

export class IdeeComponent {


  constructor(private ideeService : IdeeService) {}

  public addIdee(idee){
  this.ideeService.save(idee);
}
}
