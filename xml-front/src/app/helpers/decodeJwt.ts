
export default class DecodeJwt {
  static getUserFromAuthToken(): UserFromJwt | undefined {
    const auth_token = localStorage.getItem('access_token');
    if (auth_token) {
      const parsed = JSON.parse(atob(auth_token.split('.')[1]));
      const user = parsed as UserFromJwt;
      user.email = parsed.sub;
      return user;
    }
    else return undefined;
  }
}

export interface UserFromJwt {
  email: string;
  firstName: string;
  lastName: string;
  role: string;
}
