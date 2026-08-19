import java.util.Scanner;

public class Pedido {
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        double valor = 0.0;
        int pedido;
        int escolha;


        do{
            System.out.println("------Cardapio-----------------------");
            System.out.println("Código 1 - Cachorro quente - R$12,00");
            System.out.println("Código 2 - X-Salada - R$15,00");
            System.out.println("Código 3 - X-Bacon - R$18,00");
            System.out.println("Código 4 - Refrigerante - R$6,00");
            System.out.println("Código 5 - Suco - R$7,00");
            System.out.println("-------------------------------------");

            System.out.print("Digite a opção desejada: ");
            pedido = teclado.nextInt();

                switch (pedido) {
                    case 1:
                        valor += 12;
                        break;

                    case 2:
                        valor += 15;
                        break;
                    case 3:
                        valor += 18;
                        break;

                    case 4:
                        valor += 6;
                        break;

                    case 5:
                        valor += 7;
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                        break;

                    System.out.println("Deseja fazer mais um pedido? (1) Sim (0) Não: ");
                    escolha = teclado.nextInt();
                } while (escolha == 1) ;
        }

        System.out.println("O valor total do pedido foi: R$" + valor);

        teclado.close();
    }
}
