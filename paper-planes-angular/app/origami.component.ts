import { Component } from '@angular/core';
import { OrigamiService } from './origami.service';
import { Origami } from './origami';

@Component({
    selector: 'origami',
    templateUrl: 'app/origami.component.html',
    styleUrls: ['app/origami.component.css']
	})


export class OrigamiComponent {

  private origami: Origami = new Origami();
  private origamis: Array<Origami> = new Array<Origami>();


  constructor() {
      this.origamis.push(new Origami("Lapin", "Normal", 10, 3, "blabla"));
  }

  public filtrerOrigamis(): Array<Origami> {
      return this.origamis.filter(o =>
          o.getNom()
              .toLowerCase()
              .indexOf(this.filtre.toLowerCase()) !== -1
      )
  }
}
