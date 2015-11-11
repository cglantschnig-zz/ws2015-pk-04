/*
    Aufgabe5) Vervollständigung von Methoden

    Vervollständigen Sie die Methoden, sodass sie sich den Kommentaren entsprechend verhalten. Verändern Sie dabei nur
    Ausdrücke, die in einem Kommentar mit TODO: gekennzeichnet sind. Lassen Sie andere Teile der Klasse unverändert.
    Von dieser Einschränkung ausgenommen ist nur die Methode main, die Sie beliebig zum Testen verwenden können.

    Zusatzfragen:
    1. Wie lautet jeweils die Abbruchbedingung?
       siehe code und suche nach erstem if statement part
    2. In welchen Fällen (in dieser Aufgabe) werden Kurzschlussoperatoren benötigt?
       siehe code und suche nach || und &&
    3. Warum wird in isPrime eine Hilfsmethode benötigt?
       weil wir 2 parameter benötigen
    4. Warum liefert Java keine Fehlermeldung, wenn mehrere Methoden denselben Namen haben?
       weil java das konzept der Überladung kennt. Man muss nur auf unterschiedliche parameter (datentypen) achten
*/
public class Aufgabe5 {

    // Returns true if (and only if) n is a prime number;  n > 1 is assumed.
    private static boolean isPrime(long n) {
        return ((n > 1) && !isPrime(n, 2));
    }

    // Helper method for isPrime ...
    private static boolean isPrime(long n, long m) {
        return (m < n) && (((n % m) == 0) || isPrime(n , m + 1));
    }

    // Prints the largest prime number smaller than or equal to n;  n > 1 is assumed.
    private static void printPrime(long n) {
        if (isPrime(n)) {
            System.out.println(n);
        } else {
            printPrime(n - 1);
        }
    }


    // Returns the sum of all odd numbers in the range from x to y (including x and y).
    private static int sum(int x, int y) {
        if (x > y) {
            return 0;
        }
        return (x % 2 == 0 ? 0 : x) + sum((x + 1), y);
    }


    // Returns x * y without applying the operator *;  y >= 0 is assumed.
    private static int prod(int x, int y) {
        if (y < 1) {
            return 0;
        }
        return x + prod(x, y - 1);
    }


    // just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie beliebig verändern.

        printPrime(2);
        printPrime(129);
        printPrime(3456);

        System.out.println(sum(5, 5));
        System.out.println(sum(5, 7));
        System.out.println(sum(6, 5));
        System.out.println(sum(-6, 5));

        System.out.println(prod(2, 5));
        System.out.println(prod(2, 1));
        System.out.println(prod(2, 2));
        System.out.println(prod(-2, 3));

    }
}
