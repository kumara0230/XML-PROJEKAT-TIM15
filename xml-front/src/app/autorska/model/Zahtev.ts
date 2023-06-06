import { Autor } from "./Autor";
import { Delo } from "./Delo";
import { Podnosilac } from "./Podnosilac";
import { Punomocnik } from "./Punomocnik";

export interface Zahtev {
    podnosilac?: Podnosilac,
    autor?: Autor | undefined,
    punomocnik?: Punomocnik | undefined,
    delo?: Delo,
}