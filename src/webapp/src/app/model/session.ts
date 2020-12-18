export class Session {

  id: string;
  created: string;
  expiration: number;
  username: string;

  constructor(id: string, created: string, expiration: number, username: string) {
    this.id = id;
    this.created = created;
    this.expiration = expiration;
    this.username = username;
  }

}
