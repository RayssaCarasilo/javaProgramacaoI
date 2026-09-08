import java.util.Arrays;

public class Cinema {
    public static void main(String[] args) {
        int quantidadeFileiras = 30;
        int quantidadeCadeirasPorFileira = 20;
        int primeiraFileiraComLateraisIndisponiveis = 16;
        int sessoes = 5;
        int vendas[] = new int[sessoes];
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int[][][] assentos = new int[sessoes][quantidadeFileiras][quantidadeCadeirasPorFileira];
        boolean[][][] vendaRealizada = new boolean[sessoes][quantidadeFileiras][quantidadeCadeirasPorFileira];
        for (int s = 0; s < sessoes; s++) {
            for (int i = 0; i < quantidadeFileiras; i++) {
                int numeroFileira = i + 1;
                int quantidadeIndisponivel = 0;

                if (numeroFileira >= primeiraFileiraComLateraisIndisponiveis) {
                    quantidadeIndisponivel = ((numeroFileira - primeiraFileiraComLateraisIndisponiveis) / 2) + 1;
                }

                for (int j = 0; j < quantidadeCadeirasPorFileira; j++) {
                    boolean indisponivelNaLateral = j < quantidadeIndisponivel
                            || j >= quantidadeCadeirasPorFileira - quantidadeIndisponivel;

                    assentos[s][i][j] = indisponivelNaLateral ? 1 : 0;
                }
            }
        }

        System.out.println("Exibição das sessões com as cadeiras disponíveis:");
        for (int s = 0; s < sessoes; s++) {
            System.out.println("Sessão " + (s + 1) + ":");
            for (int i = 0; i < quantidadeFileiras; i++) {
                for (int j = 0; j < quantidadeCadeirasPorFileira; j++) {
                    System.out.print(assentos[s][i][j] + " ");
                }
                System.out.println();
            }
        }

        boolean encerrar = false;

        while (!encerrar) {
            System.out.print("Digite a sessão que deseja realizar a compra: ");
            int sessao = scanner.nextInt();
            System.out.print("Digite a cadeira que deseja comprar: ");
            int cadeira = scanner.nextInt();
            System.out.print("Digite a fileira que deseja comprar: ");
            int fileira = scanner.nextInt();

            if (sessao < 0 && cadeira < 0 && fileira < 0) {
                System.out.println("Fim das vendas.");
                encerrar = true;
                break;
            }

            if (sessao > 0 && sessao <= sessoes
                    && cadeira > 0 && cadeira <= quantidadeCadeirasPorFileira
                    && fileira > 0 && fileira <= quantidadeFileiras
                    && assentos[sessao - 1][fileira - 1][cadeira - 1] == 0) {
                assentos[sessao - 1][fileira - 1][cadeira - 1] = 1;
                System.out.println("Compra realizada com sucesso!");
                vendas[sessao - 1]++;
                vendaRealizada[sessao - 1][fileira - 1][cadeira - 1] = true;
            } else {
                System.out.println("Cadeira indisponível");
            }

            if (!(sessao > 0 && sessao <= sessoes)) {
                System.out.println("Sessão inexistente");
            }
            if (!(cadeira > 0 && cadeira <= quantidadeCadeirasPorFileira)) {
                System.out.println("Cadeira inexistente");
            }
            if (!(fileira > 0 && fileira <= quantidadeFileiras)) {
                System.out.println("Fileira inexistente");
            }
        }

        System.out.println("Mapa de assentos atualizado:");
        for (int s = 0; s < sessoes; s++) {
            System.out.println("Sessão " + (s + 1) + ":");
            for (int i = 0; i < quantidadeFileiras; i++) {
                for (int j = 0; j < quantidadeCadeirasPorFileira; j++) {
                    System.out.print(assentos[s][i][j] + " ");
                }
                System.out.println();
            }
        }

        for (int s = 0; s < sessoes; s++) {
            System.out.println("Vendas na sessão " + (s + 1) + ": " + vendas[s]);
        }

        System.out.println("Total de vendas: " + Arrays.stream(vendas).sum());

        System.out.println("Assentos vendidos em todas as sessões:");

        boolean encontrouAssento = false;

        for (int fileira = 0; fileira < quantidadeFileiras; fileira++) {
            for (int cadeira = 0; cadeira < quantidadeCadeirasPorFileira; cadeira++) {

                boolean vendeuEmTodas = true;

                for (int sessao = 0; sessao < sessoes; sessao++) {
                    if (!vendaRealizada[sessao][fileira][cadeira]) {
                        vendeuEmTodas = false;
                        break;
                    }
                }

                if (vendeuEmTodas) {
                    System.out.println(
                            "Fileira " + (fileira + 1)
                                    + ", cadeira " + (cadeira + 1));
                    encontrouAssento = true;
                }
            }
        }

        if (!encontrouAssento) {
            System.out.println("Nenhum assento foi vendido em todas as sessões.");
        }

        System.out.println("Fileiras vendidas em todas as sessões: ");
        for (int fileira = 0; fileira < quantidadeFileiras; fileira++) {
            boolean vendeuEmTodas = true;
            for (int sessao = 0; sessao < sessoes; sessao++) {
                for (int cadeira = 0; cadeira < quantidadeCadeirasPorFileira; cadeira++) {
                    if (!vendaRealizada[sessao][fileira][cadeira]) {
                        vendeuEmTodas = false;
                        break;
                    }
                }
                if (!vendeuEmTodas) {
                    break;
                }
            }
            if (vendeuEmTodas) {
                System.out.println("Fileira " + (fileira + 1));
            }
        }

        scanner.close();
    }
}