import {Student} from "./student";

export interface SchoolCareer {
  id:number;
  year: string;
  level: string;
  faculty: string;
  school: string;
  results: string;
  student: Student;
}
