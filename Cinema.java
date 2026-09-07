import java.util.Arrays;

public class Cinema {
    public static void main(String[] args) {
        int quantidadeFileiras = 30;
        int quantidadeCadeirasPorFileira = 20;
        int primeiraFileiraComLateraisIndisponiveis = 16;
        int sessoes = 5;
        int vendas[] = new int[sessoes];
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int[][] assentos = new int[quantidadeFileiras][quantidadeCadeirasPorFileira];
        for (int i = 0; i < quantidadeFileiras; i++) {
            int numeroFileira = i + 1;
            int quantidadeIndisponivel = 0;

            if (numeroFileira >= primeiraFileiraComLateraisIndisponiveis) {
                quantidadeIndisponivel = ((numeroFileira - primeiraFileiraComLateraisIndisponiveis) / 2) + 1;
            }

            for (int j = 0; j < quantidadeCadeirasPorFileira; j++) {
                boolean indisponivelNaLateral = j < quantidadeIndisponivel
                        || j >= quantidadeCadeirasPorFileira - quantidadeIndisponivel;

                assentos[i][j] = indisponivelNaLateral ? 1 : 0;
            }
        }
        for (int i = 0; i < quantidadeFileiras; i++) {
            for (int j = 0; j < quantidadeCadeirasPorFileira; j++) {
                System.out.print(assentos[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Exibição das sessões com as cadeiras disponíveis:");
        for (int s = 0; s < sessoes; s++) {
            System.out.println("Sessão " + (s + 1) + ":");
            for (int i = 0; i < quantidadeFileiras; i++) {
                for (int j = 0; j < quantidadeCadeirasPorFileira; j++) {
                    System.out.print(assentos[i][j] + " ");
                }
                System.out.println();
            }
        }

        for (int s = 0; s < sessoes; s++) {
            System.out.print("Digite a sessão que deseja realizar a compra: ");
            int sessao = scanner.nextInt();
            System.out.print("Digite a cadeira que deseja comprar: ");
            int cadeira = scanner.nextInt();
            System.out.print("Digite a fileira que deseja comprar: ");
            int fileira = scanner.nextInt();

            if (cadeira > 0 && cadeira <= quantidadeCadeirasPorFileira && fileira > 0
                    && fileira <= quantidadeFileiras) {
                assentos[fileira - 1][cadeira - 1] = 1;
                System.out.println("Compra realizada com sucesso!");
                vendas[sessao - 1]++;
            } else {
                System.out.println("Cadeira ou fileira inválida!");
            }

            if(sessao < 1 || sessao > sessoes) {
                System.out.println("Sessão inválida!");
            }
        }

        System.out.println("Mapa de assentos atualizado:");
        for (int i = 0; i < quantidadeFileiras; i++) {
            for (int j = 0; j < quantidadeCadeirasPorFileira; j++) {
                System.out.print(assentos[i][j] + " ");
            }
            System.out.println();
        }

        for (int s = 0; s < sessoes; s++) {
            System.out.println("Vendas na sessão " + (s + 1) + ": " + vendas[s]);
        }

        System.out.println("Total de vendas: " + Arrays.stream(vendas).sum());

        System.out.println("Vendas em todas as sessões: " + Arrays.toString(vendas));

        System.out.println("Fileiras que tiveram vendas em todas as sessões: " + Arrays.toString(
            java.util.stream.IntStream.range(0, quantidadeFileiras)
                .filter(fileira -> java.util.stream.IntStream.range(0, sessoes)
                    .allMatch(sessao -> assentos[fileira][sessao] == 1))
                .toArray()
        ));

    }
}