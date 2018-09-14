export class Origami {
  private nom: string;
  private temps: number;
  private note: number;
  private niveau: any;
  private href: string;


  constructor(private json?: any) {
      if (json !== undefined) {
          this.nom = json.nom;
          this.temps = json.temps;
          this.note = json.note;
          this.niveau = json.niveau;
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

  public getHref(): string {
      return this.href;
  }

}
