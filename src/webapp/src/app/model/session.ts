export class Session {

  id: string;
  created: string;
  expiration: number;
  username: string;
  role: string;
  college: string;

  constructor(id: string, created: string, expiration: number, username: string, role: string, college: string) {
    this.id = id;
    this.created = created;
    this.expiration = expiration;
    this.username = username;
    this.role = role;
    this.college = college;
  }

}
