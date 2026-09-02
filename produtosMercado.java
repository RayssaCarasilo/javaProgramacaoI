import java.util.Scanner;

public class produtosMercado {
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        String[] registro = new String[10];

        for(int i = 0; i < registro.length; i++){
            System.out.print("Registre o produto da posição " + i+1 + ": ");
            registro[i] = teclado.nextLine();
        }

        System.out.print("Qual produto deseja buscar?: ");
        String busca = teclado.nextLine();

        boolean encontrado = false;

        for(int i = 0; i < registro.length; i++){
            if(registro[i].equalsIgnoreCase(busca)){
                System.out.println("O produto está na lista na posição " + i);

                if(i+1 < registro.length){
                System.out.println("O próximo produto é " + registro[i+1]);
                }else{
                    System.out.println("Este é o último produto da lista.");
                }

                encontrado = true;
                break;
            }

            if(!encontrado){
                System.out.println("produto não encontrado.");
            }
        }

        teclado.close();

    }
}
