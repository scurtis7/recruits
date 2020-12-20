export class SiteUser {

  fullname: string;
  username: string;
  password: string;
  college: string;

  constructor(fullname: string, username: string, password: string, college: string) {
    this.fullname = fullname;
    this.username = username;
    this.password = password;
    this.college = college;
  }

}
