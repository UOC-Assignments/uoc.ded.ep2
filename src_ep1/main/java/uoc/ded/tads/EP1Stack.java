package uoc.ded.tads;

import uoc.ei.tads.Pila;
import uoc.ei.tads.PilaVectorImpl;

public class EP1Stack {

        // Capacitat màxima de la seqüència.
        public final int CAPACITY = 9;

        private Pila<Character> pila;

        public void newStack() {
            System.out.println("\nCrea una pila fitada per a " + CAPACITY + " elements ");
            pila = new PilaVectorImpl<Character>(CAPACITY);
        }


        public void fillStack() {
            System.out.println("Empila els digits del '0' al '" + (CAPACITY-1) + "'");
            // Emmagatzema els digits del '0' al '8'
            for (char c = '0'; c < '9'; c++) {
                pila.empilar(Character.valueOf(c));
            }
        }

        public String clearAllStack() {
            String desempilar = "";
            while (! pila.estaBuit())
                desempilar += (pila.desempilar() + " ");
            System.out.println("Desempila tots els elements: " + desempilar);
            return desempilar;
        }

    public Pila<Character> getStack() {
        return this.pila;
    }
}
