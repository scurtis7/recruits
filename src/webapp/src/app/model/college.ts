export class College {

  id: number;
  siteName: string;
  displayName: string;
  conference: string;
  division: string;

  constructor(id: number, siteName: string, displayName: string, conference: string, division: string) {
    this.id = id;
    this.siteName = siteName;
    this.displayName = displayName;
    this.conference = conference;
    this.division = division;
  }

}
