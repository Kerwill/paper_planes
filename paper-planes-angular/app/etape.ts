export class etape {
  private ordre: number;
  private descriptif: string;
  private image: string;
  private video: string;
  private href: string;

  constructor(private json?: any) {
      if (json !== undefined) {
          this.ordre = json.ordre;
          this.descriptif = json.descriptif;
          this.image = json.image;
          this.video = json.video;

          if (json._links !== undefined) {
              this.href = json._links.self.href;
          }
      }
  }

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
      
  public getHref(): string {
      return this.href;
  }
}
