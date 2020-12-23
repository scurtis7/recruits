export class ChangePassword {

  oldUsername: string;
  oldPassword: string;
  newPassword: string;

  constructor(oldUsername: string, oldPassword: string, newPassword: string) {
    this.oldUsername = oldUsername;
    this.oldPassword = oldPassword;
    this.newPassword = newPassword;
  }

}
