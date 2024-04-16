
package pocket;
import java.util.InputMismatchException;
import java.util.Scanner;

//Se crea la clase pocket para todo el conjunto de cartas de juego
public class Pocket {
    public static void main(String[] args) {
       
        //se establece el mazo que se va contruir con sus funciones
        Deck deck= new Deck();
        deck.construir();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opciones;
        System.out.println("Bienvenido a Poker!");
        System.out.println("---------------------------------");

        while (!salir){
            
            //Las distintas opciones a mostrar en el Menu
            System.out.println("Opciones a elegir:");
            System.out.println("1 Mezclar Mazo");
            System.out.println("2 Sacar una carta");
            System.out.println("3 Carta al azar");
            System.out.println("4 Generar una mano de 5 cartas");
            System.out.println("0 Salir");
            System.out.println("---------------------------------");
            try {
                System.out.println("Selecciona una opción:");
                opciones = scanner.nextInt();
                switch (opciones){ //Se establecen los casos para cada opcion
                    case 1:
                        deck.Barajear();
                        break;
                    case 2:
                        deck.head();
                        break;
                    case 3:
                        deck.pick();
                        break;
                    case 4:
                        deck.hand();
                        break;
                    case 0:
                        salir = true;
                        System.out.println("Se acabo el juego");
                        break;
                    default:
                        throw new IllegalStateException("opción no valida " + opciones);
                }
            }
            catch (InputMismatchException e){
                System.out.println("Opción no válida");
                scanner.next();
            }
            catch (Exception a){
                a.printStackTrace();
            }
        }
        
    }
    
}