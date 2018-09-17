import { Categorie } from './categorie';

export class Origami {
  private nom: string;
  private temps: number;
  private note: number;
  private niveau: any;
  private href: string;
  private id: string;
  private categories: Array<Categorie>;


  constructor(private json?: any) {
      if (json !== undefined) {
          this.nom = json.nom;
          this.temps = json.temps;
          this.note = json.note;
          this.niveau = json.niveau;
          this.id = json.id;
          this.categories = json.categories;

          if (json._links !== undefined) {
              this.href = json._links.self.href;
          }
      }
  }

  public getNom(): string {
    return this.nom;
  }

  public getTemps(): number {
    return this.temps;
  }

  public getNote(): number {
    return this.note;
  }

  public getNiveau(): any {
    return this.niveau;
  }

  public getCategories(): Array<Categorie> {
      return this.categories;
  }

  public getHref(): string {
      return this.href;
  }

}
