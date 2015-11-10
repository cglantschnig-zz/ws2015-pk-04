/*
    Aufgabe3) Darstellung rekursiver Aufrufe

    Wandeln Sie die Methode rec aus der Klasse TuermeVonHanoi (Vorlesung vom 9.11.2015) so ab, dass zusätzlich
    in jedem Aufruf von rec folgende Daten mittels System.out.print und System.out.println ausgegeben werden:

    - aktuelle Aufrufebene (bzw Rekursionstiefe) wie in der Vorlesung vom 5.11.2015
    - aktuelle Werte der Parameter i, a, b und c

    Außerdem soll rec die Anzahl aller rekursiven Aufrufe von rec während der Ausführung von rec zurückgeben.

    Ein Aufruf von rec(3, 'A', 'B', 'C', 1) soll beispielsweise 7 zurückgeben und folgende Zeilen ausgeben:

        Aufrufebene 1:  i = 2, a = A, b = B, c = C
        Aufrufebene 2:  i = 1, a = A, b = C, c = B
        Aufrufebene 3:  i = 0, a = A, b = B, c = C
        von A nach B
        Aufrufebene 3:  i = 0, a = C, b = A, c = B
        von A nach C
        Aufrufebene 2:  i = 1, a = B, b = A, c = C
        Aufrufebene 3:  i = 0, a = B, b = C, c = A
        von B nach C
        Aufrufebene 3:  i = 0, a = A, b = B, c = C

    Hinweis: Zur Ermittlung der Aufrufebene ist ein zusätzlicher Parameter 'level' nötig.

    Zusatzfragen:
    1. Wieso kann man die Aufrufebene nicht direkt aus dem Wert von i ermitteln?
    2. Warum sind die Werte von a, b und c nicht in jedem Aufruf gleich?
       Weil jeder Aufruf die Parameter vertauscht
    3. Welche Ergebnisse gibt rec zurück, wenn der erste Parameter gleich 5, 10, 15 bzw. 20 ist?
    4. Hängt das zurückgegebene Ergebnis von den Parametern a, b und c ab?
       Nein. Diese Parameter sind nur für die Ausgabe relevant
*/
public class Aufgabe3 {

    // just for testing ...
    public static void main(String[] args) {
        rec(3, 'A', 'B', 'C', 1);
    }

    private static void rec(int i, char a, char b, char c, int level) {
        System.out.println("Aufrufebene " + level + ": i = " + i + ", a = " + a + ", b = " + b + ", c = " + c);
        if (i > 0) {
            rec(i-1, a, c, b, 1);
            System.out.println("von " + a + " nach " + c);
            rec(i-1, b, a, c, 1);
        }
    }
}
