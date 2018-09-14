import { Component } from '@angular/core';
import { EtapeService } from './etape.service';
import { OrigamiService } from './origami.service';

@Component({
    templateUrl: 'app/origami-details.component.html',
    styleUrls: ['app/origami-details.component.css']
	})

export class OrigamiDetailsComponent {
// private etapes : Array<Etape>;

constructor(private etapeService : EtapeService, private origamiService: OrigamiService ) {

// this.etapes = this.etapeService.findAll();
}

// private getOrigami() : any{
//   origamiService
// }


// public getEtapes(){
//   return this.etapes;
// }
}
