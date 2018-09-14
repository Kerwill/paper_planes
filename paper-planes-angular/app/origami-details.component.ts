import { Component } from '@angular/core';
import { EtapeService } from './etape.service';
import { OrigamiService } from './origami.service';
import { Etape } from './etape';
import {ActivatedRoute} from '@angular/router';
import { Origami } from './origami';


@Component({
    templateUrl: 'app/origami-details.component.html',
    styleUrls: ['app/origami-details.component.css']
	})

export class OrigamiDetailsComponent {

private id : number;
private origami : Origami;

constructor(private etapeService : EtapeService, private origamiService : OrigamiService, private route: ActivatedRoute ) {

}

ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id']
    });

  }

getOrigami() : Origami{
    return this.origamiService.findById(this.id);

}

public getEtapes() : Array <Etape> {
  return this.etapeService.findAllById(this.id);
//   return this.etapes;
// }
}
}
