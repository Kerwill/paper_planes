export class Categorie {
  private nom: string;
  private id: number;
  private href: string;



  constructor(private json?: any) {
      if (json !== undefined) {
          this.nom = json.nom;
          this.id = json.id;

          if (json._links !== undefined) {
              this.href = json._links.self.href;
          }
      }
  }

  public getNom(): string {
      return this.nom;
  }

  public getHref(): string {
      return this.href;
  }
}
