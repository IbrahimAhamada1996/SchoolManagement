import { Course } from "./course";
import { Role } from "./role";
import { Schedule } from "./schedule";
import {User} from "./user";

export interface Employee extends User {

  salary?: number;
  hireDate?: string;
  situationFamilliale?: string;
  decede?: boolean;
  fire?: boolean;
  childNumber?: number;
  schedules: Array<Schedule>;
  courses: Array<Course>;

  // constructor(
  //   id:number,
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
  //   active: boolean,
  //   salary: number,
  //   hireDate: string,
  //   situationFamilliale: string,
  //   decede: boolean,
  //   fire: boolean,
  //   childNumber: number
  //   ){
  //     super(id,firstname,lastname,email,username,password,birthDay,birthPlace,phone,cni,gender,address,image,roles,active);
      
  //     this.salary=salary
  //     this.hireDate=hireDate;
  //     this.situationFamilliale=situationFamilliale;
  //     this.decede=decede;
  //     this.fire=fire;
  //     this.childNumber=childNumber;
     
      

  // }

}
