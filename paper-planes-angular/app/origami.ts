export class Origami {
  public nom: string;
  public temps: number;
  public note: number;
  public niveau: any;
  public etapes: Array<Etape>;
  public categories: Array<Categorie>;

  constructor(public nom?: string) {
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

}
