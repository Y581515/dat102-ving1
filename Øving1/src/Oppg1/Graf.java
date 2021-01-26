package Oppg1;

import java.util.List;
/**
*
* @author soh
*
*/
public interface Graf {
/*
* Forklaring som normalt ikkje ville vore med
* Alle metodane i eit interface er public. Difor er det vanleg å
* utelate public. Det er lov å ta med public.
*
*/
/**
*
* @return antal nodar i grafen.
*/
int getAntallNoder();
/**
*
* @return antal kantar i grafen.
*/
int getAntallKanter();
/**
*
* Metoden gir oss alle nodenavn i grafen. De trenger ikke komme
* i en bestemt rekkefølge.
*
* @return liste av namn på alle nodane i grafen
*/
List<String> alleNoder();
/**
* Metode som avgjer om to nodar er naboar.
*
* @param u fra node.
* @param v til node.
* @return true dersom u og v er naboar, false elles.
*/
boolean erNaboer(String u, String v);
/**
* Legg ein ny node til grafen. Denne metoden treng ikkje fungere. Man
* kan bare la metoden returnere false.
*
* @param w node som skal leggast til.
* @return true dersom noden ikkje finst frå før, false elles.
*/
boolean leggTilNode(String w);

/**
* Legg til ein kant mellom nodane u og v i grafen.
*
* @param u frå node.
* @param v til node.
* @return true om kanten er lagt til, false om u eller v ikkje er lovlige
* nodenavn. Også false om kanten finst frå før.
*/
boolean leggTilKant(String u, String v);
/**
* Metoden kan legge flere kanter til i en operasjon
*
* @param w node i grafen
* @param naboer Tabell med noder som skal bli nabo med w
* @return true dersom ingen kanter finnes i grafen fra før, false elles.
Dersom
* en kant finnes fra før, blir ingen kanter lagt til.
*/
boolean leggTilKanter(String w, String[] naboer);
/**
* Fjerner en kant i grafen.
*
* @param u node i grafen.
* @param v node i grafen.
* @return true dersom det var en kant mellom u og v i grafen, false elles.
*/
boolean fjern(String u, String v);
/**
* Henter en liste av alle naboene til en gitt node.
*
* @param w node i grafen.
* @return Liste med alle naboene til w.
*/
List<String> getNaboer(String w);
}
