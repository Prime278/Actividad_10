package pocket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Deck {
    private HashMap<String, String> palos = new HashMap();
    private ArrayList<Card> mazo = new ArrayList();
    private String strFormat = "Queda %s";//Se muestra la cantidad de cartas restantes
    int a;

    public Deck() {
    }

    public ArrayList<Card> getMazo() {
        return this.mazo;
    }

    public void mazo() {
        this.palos.put("Diamante", "rojo");
        this.palos.put("Trebol", "Negro");
        this.palos.put("Pica", "Negro");
        this.palos.put("Corazon", "rojo");
    }

    public void construir() {
        this.mazo();
        Iterator var1 = this.palos.entrySet().iterator();

        while(var1.hasNext()) {
            Entry<String, String> palo = (Entry)var1.next();
            String paloCard = (String)palo.getKey();
            String color = (String)palo.getValue();

            for(int i = 1; i <= 13; ++i) {
                Card card = new Card(paloCard, color);
                card.setValor(i);
                this.mazo.add(card);
            }
        }

    }

    public void Barajear() {
        Collections.shuffle(this.mazo);
        System.out.println("Se mezclo el Mazo de cartas");
    }

    public void head() throws Exception { //Se empieza a utilizar las excepciones para que el programa verifique en tiempo real si tiene o no cartas
        Card card = (Card)this.mazo.get(this.mazo.size() - 1);
        this.mazo.remove(card);
        System.out.println(card.toString());
        System.out.println(String.format(this.strFormat, this.mazo.size()));
        this.a = this.mazo.size();
        if (this.a == 0) {
            throw new Exception("Se han agotado las cartas");//------------------------------------------------------
        }
    }

    private Card azar() {
        int max = this.mazo.size() - 1;
        int rd = (int)Math.floor(Math.random() * (double)(0 - max + 1) + (double)max);
        return (Card)this.mazo.get(rd);
    }

    public Card pick() throws Exception {
        Card card = this.azar();
        this.mazo.remove(card);
        System.out.println(card.toString());
        System.out.println(String.format(this.strFormat, this.mazo.size()));
        this.a = this.mazo.size();
        if (this.a == 0) {
            throw new Exception("Se han agotado las cartas");//------------------------------------------------------
        } else {
            return card;
        }
    }

    private void printHand(ArrayList<Card> cards) {
        Iterator var2 = cards.iterator();

        while(var2.hasNext()) {
            Card card = (Card)var2.next();
            System.out.println(card.toString());
        }

    }

    public void hand() throws Exception {
        ArrayList<Card> cards = new ArrayList();
        if (this.mazo.isEmpty()) {
            throw new Exception("Se han agotado las cartas");//------------------------------------------------------
        } else if (this.mazo.size() < 4) {
            throw new Exception("Quedan pocas cartas");//------------------------------------------------------
        } else {
            for(int i = 1; i <= 5; ++i) {
                cards.add(this.pick());
            }

        }
    }
}

