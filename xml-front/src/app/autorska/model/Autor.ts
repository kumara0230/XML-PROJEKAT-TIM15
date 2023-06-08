import { Adresa } from "./Adresa";

export interface Autor {
    adresa?: Adresa,
    [key: string]: any,
    // brojTelefona?: String,
    // email?: String,
    // faks?: String,
    // ime?: String,
    // prezime?: String,
    // drzavljanstvo?: String,
    // pseudonim?: String,
    // godinaSmrti?: String,
    // autorAnoniman?: boolean
}