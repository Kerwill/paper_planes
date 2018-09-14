import { Component } from '@angular/core';
import { EtapeService } from './etape.service';
import { Etape } from './etape';


@Component({
    templateUrl: 'app/origami-details.component.html',
    styleUrls: ['app/origami-details.component.css']
	})

export class OrigamiDetailsComponent {
// private etapes : Array<Etape>;

constructor(private etapeService : EtapeService ) {

// this.etapes = this.etapeService.findAll();
}

// public getEtapes(){
//   return this.etapes;
// }
}
