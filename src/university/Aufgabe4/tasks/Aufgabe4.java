/*
    Aufgabe4) Rekursion und Termination

    Die Methoden f, g, h, p und q sind vorgegeben. Rufen Sie in main jede dieser Methoden mit allen Argumenten im
    Bereich von -10 bis 10 (in aufsteigender Reihenfolge) auf und geben sie die Ergebnisse aus, wenn die Aufrufe mit
    Argumenten terminieren. Aufrufe, die nicht terminieren, sind auszulassen. Vermeiden Sie Exceptions.

    Hinweis: Für diese Aufgabe ist es besonders wichtig, die Zusatzfragen beantworten zu können.

    Zusatzfragen:
    1. Nennen Sie für jeden nicht terminierenden Aufruf von f, g, h, p und q im Intervall einen Grund für die
       Endlosrekursion (im Hinblick auf Fundiertheit und Fortschritt).
    2. Beschreiben Sie überblicksartig, was die Methoden f, g, h, p und q berechnen.
    3. Bedeutet ein StackOverflowError immer, dass eine Endlosrekursion vorhanden ist?
       Nicht unbedingt, man könnte ja zb eine große Datei laden. Jedoch kann man immer stark auf endlos schleife tippen wenn man den Fehler sieht.
    4. [optional] Ist die Aufgabe überhaupt lösbar (wegen der Unentscheidbarkeit des Halteproblems der Turing-Maschine)?
*/
public class Aufgabe4 {


    // Zählt die Anzahl der Zahlen wobei x^2 < 10 ist
    private static int f(int x) {
        return x * x > 10 ? 0 : f(x - 1) + 1;
    }

    // bei negativen Zahlen wird 0 geliefert. Ansonsten ein Stackoverflow Error ( man kommt nie ins negative um die Funktion zu enden)
    private static int g(int x) {
        return x < 0 ? 0 : g(x / 2) + 1;
    }

    // wenn das Quadrat einer Zahl 11+ ist wird 1 addiert.
    // bei 1, 0, -1 kommt eine Endlosrekursion, weil 1 * 1 = 1 und 0 * 0 = 0 --> man kommt nie auf 11+
    private static int h(int x) {
        return x > 10 ? 0 : h(x * x) + 1;
    }

    // wenn x = 0 liefern wir 0
    // wenn x ungerade = neuer versuch mit (x) / 2 (mit int cut) und 2 für das ergebnis
    // wenn x gerade = x * (-1) - 1 und 1 für das ergebnis
    // sobald x % 2 == -1 haben wir probleme
    private static int p(int x) {
        return x == 0 ? 0 : x % 2 == 1 ? p(x / 2) + 2 : p(- x - 1) + 1;
    }

    // alle Zahlen die durch 3 Teilbar sind laufen durch, alle anderen nicht
    private static int q(int x) {
        return x % 3 == 0 ? 0 : q(x + x % 3 + 1) + 1;
    }

    // to be implemented by you
    public static void main(String[] args) {

        for (int i = -10; i <= 10; i++) {
            System.out.println("i" + i + "  " + q(i));
        }

    }
}
