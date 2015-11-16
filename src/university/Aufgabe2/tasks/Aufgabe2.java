/*
    Aufgabe2) Rekursion

    Implementieren Sie das Diamanten-Beispiel aus Aufgabenblatt3 nun rekursiv. Die Methode "drawNumDiamond(int h)"
    soll den Diamanten (Raute) generieren und dabei Rekursion anwenden. Sie können zusätzliche Methoden anlegen.
    Der übergebene Parameter "h" entspricht der Höhe des Diamanten (Raute). Ein h=9 führt zu folgender Ausgabe:

        1
       222
      33333
     4444444
    555555555
     4444444
      33333
       222
        1

    Testen Sie Ihre Methode mit weiteren Höhen für "h"! Der Rückgabetyp der Methode ist "void".

    Zusatzfragen:
    1. Welche Unterschiede konnten Sie zwischen der rekursiven und iterativen Implementierung feststellen?
       iterativ muss man sich um die indexe kümmern und man braucht mehr hilfsvariablen
*/
public class Aufgabe2 {

    // just for testing ...
    public static void main(String[] args) throws Exception {
        drawNumDiamond(9);
    }

    public static void drawNumDiamond(int h) throws Exception {
        if (h < 0) {
            throw new Exception("height must be a positive number");
        }
        drawNumDiamondHelper((h % 2) == 1 ? h + 1 : h, 1);
    }

    private static void drawNumDiamondHelper(int height, int position) {
        if (height <= position) {
            return;
        }
        int letterIndex = (height - position) < position ? (height - position): position;
        int letterCount = letterIndex + (letterIndex - 1);
        String line = repeat(" ", (height - letterCount) / 2) + repeat("" + letterIndex, letterCount) + repeat(" ", (height - letterCount) / 2);
        System.out.println(line);
        drawNumDiamondHelper(height, position + 1);
    }

    private static String repeat(String s, int n) {
        if(s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder(s.length() * n);
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

}
