export class SiteUser {

  fullName: string;
  username: string;
  password: string;

  constructor(fullName: string, username: string, password: string) {
    this.fullName = fullName;
    this.username = username;
    this.password = password;
  }

}
