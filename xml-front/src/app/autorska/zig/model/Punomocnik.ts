import { Adresa } from "./Adresa";

export interface Punomocnik {
    adresa: Adresa,
    [key: string]: any
    // brojTelefona?: String,
    // email?: String,
    // faks?: String,
    // ime?: String,
    // prezime?: String,
    // drzavljanstvo?: String,
    // poslovnoIme?: String,
    // podnosilacAutor?: boolean
}