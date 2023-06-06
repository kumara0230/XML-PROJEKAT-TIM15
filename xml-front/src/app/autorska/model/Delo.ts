import { DeloPrerade } from "./DeloPrerade";

export interface Delo {
    naslov: String,
    vrsta: String,
    formaZapisa: String,
    alternativniNaziv: String,
    deloStvorenoURadnomOdnosu: boolean,
    nacinKoriscenjaDela: String,
    deloPrerade?: DeloPrerade 
}