import {Faculty} from "./faculty";
import {Level} from "./level";

export interface Grade {
  id:number;
  name: string;
  faculties: Array<Faculty>;
  levels: Array<Level>;
}
