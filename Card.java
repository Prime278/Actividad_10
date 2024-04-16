package pocket;

public class Card {

    //Se establecen las clases para las cartas
    private String valor;
    private String palo;
    private String color;

    //Se establece el valor para cada una
    Card(String palo, String color, String valor) {
        this.valor = valor;
        this.palo = palo;
        this.color = color;
    }

    Card(String palo, String color) {
        this.palo = palo;
        this.color = color;
    }

    public String getPalo() {
        return this.palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(Integer valor) {
        if (valor <= 10) {
            if (valor == 1) {
                this.valor = "A";
            }

            this.valor = valor.toString();
        } else if (valor == 11) {
            this.valor = "J";
        } else if (valor == 12) {
            this.valor = "Q";
        } else {
            this.valor = "k";
        }

    }

    public String toString() {
        return "valor=" + this.valor + ", palo=" + this.palo + ",color=" + this.color;
    }
}

