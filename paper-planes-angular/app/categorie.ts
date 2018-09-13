<<<<<<< HEAD
export class Categorie {
  private nom: string;
  private href: string;

  constructor(private json?: any) {
      if (json !== undefined) {
          this.nom = json.nom;

=======
xport class Categorie {
  private nom: string;
  private href: string;
  constructor(private json?: any) {
      if (json !== undefined) {
          this.nom = json.nom;
>>>>>>> angular
          if (json._links !== undefined) {
              this.href = json._links.self.href;
          }
      }
  }
<<<<<<< HEAD

  public getNom(): string {
      return this.nom;
  }

=======
  public getNom(): string {
      return this.nom;
  }
>>>>>>> angular
  public getHref(): string {
      return this.href;
  }
}
