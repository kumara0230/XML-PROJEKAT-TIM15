import { Podnosilac } from "./Podnosilac";
import { Punomocnik } from "./Punomocnik";

export interface Zahtev {
    podnosilac?: Podnosilac,
    punomocnik?: Punomocnik,
    tip_ziga?: string,
    vrsta_ziga?: string,
    izgled?: string,
    boje?: string,
    opis?: string,
    klasa?: number,
    prava?: string,
    [key: string]: any
}