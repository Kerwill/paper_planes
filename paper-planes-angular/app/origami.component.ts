import { Component } from '@angular/core';
import { Origami } from './origami';
import { OrigamiService } from './origami.service';
import { CategorieService} from './categorie.service';
import { Categorie} from './categorie';
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



  //filtre pour recherche par mot

  private filtreRecherche: string = "";

  //boolean sur niveau

  private isOccasionnel : boolean = false;
  private isNormal : boolean = false;
  private isAvance : boolean = false;
  private isExpert : boolean = false;
  private filtreNiveau: string = "";
  private selectedCategorieId : number = 0;

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




//afficher l'ensemble des categories dans le select

  public getCategories() {
    return this.categorieService.findAll();
  }


//appel à Origami Service pour générer les tableaux d'origamis


public getOrigamis() : Array <Origami>{

this.origamis = this.origamiService.findAllFiltrated(this.filtreRecherche, this.selectedCategorieId, this.isOccasionnel,this.isNormal, this.isAvance, this.isExpert);

return this.origamis;

  }
}


//   public getOrigamis() : Array <Origami>{
//
//     if (!this.filtreRecherche && !this.selectedCategorie && !isExpert && !isNormal && !isAvance && !isOccasionnel){
//         this.origamis = this.origamiService.findAll();
//     }
//
//     else{
//     this.origamis = this.origamiService.findAllFiltrated(this.filtreRecherche, this.selectedCategorie, this.isOccasionnel, this.isNormal, this.isAvance, this.isExpert);
// }
// return this.origamis;
