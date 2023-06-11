//TODO: dodati importe
import { Dostavljanje } from "./Dostavljanje";
import { NazivPronalaska } from "./NazivPronalaska";
import { Podnosilac } from "./Podnosilac";
import { Predstavnik } from "./Predstavnik";
import { Pronalazac } from "./Pronalazac";
import { Zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava } from "./Zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava";

export interface Zahtev {
    nazivPronalaska?: NazivPronalaska | undefined,
    podnosilac?: Podnosilac | undefined,
    pronalazac?: Pronalazac | undefined,
    predstavnik?: Predstavnik | undefined,
    dostavljanje?: Dostavljanje,
    zahtevi_za_priznanje_prava_prvenstva_iz_ranijih_prijava?: Zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava,
    [key: string]: any,
}