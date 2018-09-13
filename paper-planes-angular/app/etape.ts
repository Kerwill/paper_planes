export class etape {
  private ordre: number;
  private descriptif: string;
  private image: string;
  private video: string;
  private href: string;
<<<<<<< HEAD

=======
>>>>>>> angular
  constructor(private json?: any) {
      if (json !== undefined) {
          this.ordre = json.ordre;
          this.descriptif = json.descriptif;
          this.image = json.image;
          this.video = json.video;
<<<<<<< HEAD

=======
>>>>>>> angular
          if (json._links !== undefined) {
              this.href = json._links.self.href;
          }
      }
  }
<<<<<<< HEAD

  public getOrdre(): number {
      return this.ordre;
  }

public getDescriptif(): string {
      return this.descriptif;
  }

  public getImage(): string {
        return this.image;
    }

    public getVideo(): string {
          return this.video;
      }

=======
  public getOrdre(): number {
      return this.ordre;
  }
public getDescriptif(): string {
      return this.descriptif;
  }
  public getImage(): string {
        return this.image;
    }
    public getVideo(): string {
          return this.video;
      }
>>>>>>> angular
  public getHref(): string {
      return this.href;
  }
}
