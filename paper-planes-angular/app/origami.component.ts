import { Component } from '@angular/core';
import { Origami } from './origami';
import { OrigamiService } from './origami.service';
import { CategorieService} from './categorie.service';
//import service si besoin
//import classe model si besoin

@Component({
    selector: 'origamis',
    templateUrl: 'app/origami.component.html',
    styleUrls: ['app/origami.component.css']
	})

export class OrigamiComponent {
  private origami: Origami = new Origami();
  private origamis: Array<Origami> = new Array<Origami>();
  private filtre: string = "";

  constructor(private origamiService : OrigamiService, private categorieService : CategorieService) {
      // this.origamis.push(new Origami("Lapin", "Normal", 10, 3, "blabla"));
  }

  public getOrigamis() {
      return this.origamiService.findAll();
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

  public getCategories() {
    return this.categorieService.findAll();
  }

  // public getOrigamiCategorie() {
  //   return this.categorie
  // }
}
