import {Module} from "./module";

export interface Unity {
  id:number;
  name: string;
  credit: number;
  modules: Array<Module>;
}
