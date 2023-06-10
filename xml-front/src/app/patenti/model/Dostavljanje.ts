import { Adresa } from "./Adresa";

export interface Dostavljanje {
    adresa: Adresa,
    // dostavljanje_elektronskim_putem: Boolean,
    [key: string]: any
}