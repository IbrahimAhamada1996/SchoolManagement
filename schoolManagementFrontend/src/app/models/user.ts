import {Role} from "./role";

export interface User {
  id?:number;
  firstname?: string;
  lastname?: string;
  email?: string;
  username?: string;
  password?: string;
  birthDay?: Date;
  birthPlace?: string;
  phone?: string;
  cni?: string;
  gender?: string;
  address?: string;
  image?: string;
  roles?: Array<Role>;
  createdAt?: string;
  updatedAt?:string;
  active?: boolean;

  // constructor(id:number,slug: string,
  //   firstname: string,
  //   lastname: string,
  //   email: string,
  //   username: string,
  //   password: string,
  //   birthDay: Date,
  //   birthPlace: string,
  //   phone: string,
  //   cni: string,
  //   gender: string,
  //   address: string,
  //   image: string,
  //   roles: Array<Role>,
  //   active: boolean){
  //     this.id=id;
  //     this.slug = slug;
  //     this.firstname = firstname;
  //     this.lastname = lastname;
  //     this.email = email;
  //     this.username = username;
  //     this.password = password;
  //     this.birthDay = birthDay;
  //     this.birthPlace = birthPlace;
  //     this.phone = phone;
  //     this.cni = cni;
  //     this.gender =  gender;
  //     this.address = address;
  //     this.image = image;
  //     this.roles = roles;
  //     this.active = active;

  // }
}
