import { Component } from '@angular/core';
import { Origami } from './origami';
import { OrigamiService } from './origami.service';
//import service si besoin
//import classe model si besoin

@Component({
    selector: 'origamis',
    templateUrl: 'app/origamis.component.html',
    styleUrls: ['app/origamis.component.css']
	})

export class OrigamiComponent {
  private origami: Origami = new Origami();
  private origamis: Array<Origami> = new Array<Origami>();

  constructor() {
      this.origamis.push(new Origami("Lapin", "Normal", 10, 3, "blabla"));
  }

  public getOrigamis() {
      this.OrigamiService.findAll();
  }

  public addOrigami() {
      this.origamis.push(this.origami);
      this.origami = new Origami();
  }

  public filtrerOrigamis(): Array<Origami> {
      return this.origamis.filter(o =>
          o.getNom()
              .toLowerCase()
              .indexOf(this.filtre.toLowerCase()) !== -1
      )
  }
}
