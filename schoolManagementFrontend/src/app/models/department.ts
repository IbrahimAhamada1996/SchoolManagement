
import { Employee } from "./employee";
import {Faculty} from "./faculty";

export interface Department {
  id:number;
  name: string;
  faculties: Array<Faculty>;
  employee: Employee;
}
