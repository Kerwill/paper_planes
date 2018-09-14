import { Component } from '@angular/core';
import { EtapeService } from './etape.service';
import { Etape } from './etape';
import {ActivatedRoute} from '@angular/router';


@Component({
    templateUrl: 'app/origami-details.component.html',
    styleUrls: ['app/origami-details.component.css']
	})

export class OrigamiDetailsComponent {

private id : number;

constructor(private etapeService : EtapeService, private route: ActivatedRoute ) {

// this.etapes = this.etapeService.findAll();
}

ngOnInit() {
    this.route.params.subscribe(params => {
      console.log(params['id']);
      this.id = params['id'];
    });

  }

public getEtapes(){
  return this.etapeService.findAllById(this.id);
//   return this.etapes;
// }
}
}
