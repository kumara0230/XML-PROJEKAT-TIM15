import { Adresa } from "./Adresa";


export interface Predstavnik {
    adresa?: Adresa,
    [key: string]: any
}