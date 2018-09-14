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
  constructor(private origamiService : OrigamiService, private categorieService : CategorieService) {
  }
  private origami: Origami = new Origami();
  private origamis: Array<Origami> = new Array<Origami>();
  private filtreRecherche: string = "";

  private isOccasionnel : boolean = false;
  private isNormal : boolean = false;
  private isAvance : boolean = false;
  private isExpert : boolean = false;
  private filtreNiveau: string = "";

  public Occasionnel() {
    if (this.isOccasionnel){
      this.isOccasionnel = false;
  }
    else{
        this.isOccasionnel = true;
    }
    return this.isOccasionnel;
  }

  public Normal() : boolean{
    if (this.isNormal){
      this.isNormal = false;
    }
    else{
        this.isNormal = true;
    }
    return this.isNormal;
  }

  public Avance() : boolean{
    if (this.isAvance){
      this.isAvance = false;
    }
    else{
        this.isAvance = true;
    }
    return this.isAvance;
  }

public Expert() : boolean{
  if (this.isExpert){
    this.isExpert = false;
  }
  else{
      this.isExpert = true;
  }
      return this.isExpert;
}


  public getOrigamis() : Array <Origami>{

    if (this.filtreRecherche !== null) {
      this.origamis = this.origamiService.findByNomContaining(this.filtreRecherche);
    }
    else {
      this.origamis = this.origamiService.findAll();
}
return this.origamis;

  }

  // public getOrigamisByNiveau() {
  //
  // }

  // click(ev){
  //    console.log(ev);
  // }

  public addOrigami() {
      this.origamis.push(this.origami);
      this.origami = new Origami();
  }

  public filtrerOrigamis(): Array<Origami> {
    return null;
      // return this.origamis.filter(o =>
      //     o.getNom()
      //         .toLowerCase()
      //         .indexOf(this.filtre.toLowerCase()) !== -1
      // )
  }

  public getCategories() {
    return this.categorieService.findAll();
  }

  // public getOrigamiCategorie() {
  //   return this.categorie
  // }
}
