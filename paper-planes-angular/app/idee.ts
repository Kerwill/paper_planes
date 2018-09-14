export class Idee {
  private nom: string;
  private prenom: string;
  private mail: string;
  private description: string;
  private href: string;


  constructor(private json?: any) {
      if (json !== undefined) {
          this.nom = json.nom;
          this.prenom = json.prenom;
          this.mail = json.mail;
          this.description = json.description;
          if (json._links !== undefined) {
              this.href = json._links.self.href;
          }
      }
  }
  public getNom(): string {
    return this.nom;
  }

  public getPrenom(): string {
    return this.prenom;
  }

  public getMail(): string {
    return this.mail;
  }

  public getDescription(): string {
    return this.description;
  }

  public getHref(): string {
      return this.href;
  }
  }
