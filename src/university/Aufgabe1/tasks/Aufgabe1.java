/**********************************************************************************************************************

 AUFGABENBLATT 4 - Allgemeine Informationen

 Das Projekt Aufgabenblatt4 besteht aus fünf Aufgaben in den Klassen Aufgabe1 bis Aufgabe5, die Sie erweitern und in
 den Übungen vom 16.11. bis 20.11. präsentieren können müssen.

 Achten Sie bei der Implementierung von Aufgabe1-Aufgabe5 auf folgende Punkte:

 - Ihr Programm sollte kompilierbar und ausführbar sein.
 - Testen und kommentieren Sie Ihre Programme ausführlich.
 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich thematisch auf das erstellte Programm.
   Sie müssen diese Zusatzfragen in der Übung beantworten können.

 Abgabe: Die Abgabe erfolgt in TUWEL indem Sie bis Montag, den 16.11.2015 um 06:00 Ihre Kreuzerl des aktuellen
 Aufgabenblattes eintragen. Nur durch Ankreuzen können Sie auch Punkte bekommen. Allerdings müssen Sie
 angekreuzte Aufgaben auch vorzeigen können.

 ***********************************************************************************************************************/
/*
    Aufgabe1) Mehrfache Rekursion versus einfache Iteration

    Implementieren Sie in Aufgabe1 je eine iterative (iter) und eine rekursive (rec) statische Methode, die für eine
    ganze nicht-negative Zahl n die Zahl L(n) berechnet. L(n) ist definiert durch:

        L(0) = 1
        L(1) = 1
        L(n) = L(n - 1) + L(n - 2) + 1  wenn  n > 1.

    Rufen Sie in main die Methoden iter und rec mit allen Zahlen von 0 bis 30 auf und geben Sie die Ergebnisse aus.

    Zusatzfragen:
    1. Welche Vor- und Nachteile hat iter im Vergleich zu rec?
       Rekursiv ist in diesem Fall einfacher zu programmieren, da die Mathematische Grundlage bereits rekursiv programmiert ist
       und man somit den Ansatz 1:1 übernehmen kann.
    2. Ist int als Ergebnistyp zur Lösung dieser Aufgabe geeignet? Warum? Welche Alternative(n) gibt es?
       int ist geeignet, sofern man nicht vor hat den Wertebereich zu sprengen. Alternativen sind long oder Ganzzahlbasierte Eigenkreationen.
    3. Warum ist double kein geeigneter Ergebnistyp für diese Aufgabe?
       Double ist nicht geeignet, da man bei dieser Rechenoperation nur mit Ganzen Zahlen arbeitet und man sonst auf Rundungsfehler achten müsste
    4. [optional] Vermutlich enthält Ihre erste Implementierung von rec zwei rekursive Aufrufe. Versuchen Sie rec so
       abzuändern, dass nur ein rekursiver Aufruf nötig ist. Wie wirkt sich die Änderung auf die Vor- und Nachteile aus?
       Grundsätzlich ist es möglich (siehe rec2) jedoch muss man dann beim Aufruf die Anfangswerte mitliefern, die man extrahieren sollte.
*/
public class Aufgabe1 {

    // invokes iter as well as rec with all integers from 0 to 30 and prints the results
    // (without empty lines or other output)
    public static void main(String[] args) {

        for (int i = 0; i <= 30; i++) {
            System.out.println(iter(i));
        }

        for (int i = 0; i <= 30; i++) {
            System.out.println(rec(i));
        }

    }

    public static int iter(int n) {
        if (n < 0) {
            return -1; // The case if there is an n smaller than 0
        }
        if (n == 0) {
            return 1; // a special case
        }
        int prev2 = 0; // n - 2
        int prev1 = 1; // n - 1

        for (int i = 0; i < n; i++) {
            if (prev2 < prev1) {
                prev2 = prev1 + prev2;
            }
            else {
                prev1 = prev1 + prev2;
            }
        }
        return (prev1 > prev2) ? prev1 : prev2;
    }

    public static int rec(int n) {
        if (n < 0) {
            return -1; // The case if there is an n smaller than 0
        }
        if (n == 0) {
            return 1; // a special case
        }
        return recHelper(n, 0, 1, 0);
    }

    private static int recHelper(int n, int position, int prev1, int prev2) {
        if (position == n) {
            return prev1;
        }
        return recHelper(n, position + 1, prev1 + prev2, prev1);
    }

    // Aufruf rec2(n, 0, 1, 0)
    private static int rec2(int n, int position, int prev1, int prev2) {
        if (n < 0) {
            return -1; // The case if there is an n smaller than 0
        }
        if (n == 0) {
            return 1; // a special case
        }
        if (position == n) {
            return prev1;
        }
        return recHelper(n, position + 1, prev1 + prev2, prev1);
    }
}
