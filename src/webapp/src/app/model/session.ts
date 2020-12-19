export class Session {

  id: string;
  created: string;
  expiration: number;
  username: string;
  role: number;

  constructor(id: string, created: string, expiration: number, username: string, role: number) {
    this.id = id;
    this.created = created;
    this.expiration = expiration;
    this.username = username;
    this.role = role;
  }

}
