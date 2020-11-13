package uoc.ded.tads;

import uoc.ei.tads.Cua;
import uoc.ei.tads.CuaVectorImpl;

public class EP1Queue {

        // Capacitat maxima de la sequencia.
        public final int CAPACITY = 9;

        private Cua<Character> cua;

        public void newQueue() {
            System.out.println("\nCrea una cua fitada per a " + CAPACITY + " elements");
            cua = new CuaVectorImpl<Character>(CAPACITY);
        }

        public void fillQueue() {
            System.out.println("Encua els digits del '0' al '" + (CAPACITY-1) + "'");
            // Emmagatzema els digits del '0' al '8'
            for (char c = '0'; c < '9'; c++) {
                cua.encuar(Character.valueOf(c));
            }
        }


        public String clearFullQueue() {
            String desencuar = "";
            while (! cua.estaBuit())
                desencuar += (cua.desencuar() + " ");
            System.out.println("Desencua tots els elements: " + desencuar);
            return desencuar;
        }

        public Cua<Character> getQueue() {
            return this.cua;
        }

}
