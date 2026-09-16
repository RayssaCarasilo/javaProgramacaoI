import java.util.Scanner;

// Classe Televisao
class Produto {
    private int codigoProduto;
    private String nomeProduto;
    private int quantidadeProduto;
    private double precoProduto;

    public Produto (int codigoProduto, String nomeProduto, int quantidadeProduto, double precoProduto){
        this.codigoProduto     = codigoProduto;
        this.nomeProduto       = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.precoProduto      = precoProduto;
    }

    public int getCodigoProduto(){
        return codigoProduto;
    }

    public String getNomeProduto(){
        return nomeProduto;
    }

    public int getQuantidadeProduto(){
        return quantidadeProduto;
    }

    public double getPrecoProduto(){
        return precoProduto;
    }

    public void setCodigoProduto(int codigoProduto){
        this.codigoProduto = codigoProduto;
    }

    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto){
        this.quantidadeProduto = quantidadeProduto;
    }

    public void setPrecoProduto(double precoProduto){
        this.precoProduto = precoProduto;
        System.out.println("Preço atualizado: " + this.precoProduto);
    }

    public void exibirInformacoes(){
        System.out.println("\n\nCódigo   : " + this.codigoProduto);
        System.out.println("Nome  : " + this.nomeProduto);
        System.out.println("Quantidade : " + this.quantidadeProduto);
        System.out.println("Preço  : " + this.precoProduto);
    }

    public void atualizarEstoque( int quantidade ){
        this.quantidadeProduto += quantidade;
        System.out.println("Quantidade atualizada  : " + this.quantidadeProduto);
    }
}

public class ProdutosLoja {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Produto produto = null;

                    System.out.println("\n\nRegistre um produto primeiro.");

                    System.out.print("\nInforme o código do produto: ");
                    int codigo = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Informe o nome do produto: ");
                    String nome = entrada.nextLine();

                    System.out.print("Informe a quantidade do produto: ");
                    int quantidade = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Informe o preço do produto: ");
                    double preco = entrada.nextDouble();
                    entrada.nextLine();

                    produto = new Produto ( codigo , nome , quantidade, preco );

                    System.out.println("\nProduto registrado com sucesso!");


        int opcao = -1;

        do {
            System.out.println("\n\nMENU");
            System.out.println("1 - Exibir todas as informações do produto");
            System.out.println("2 - Atualizar o estoque");
            System.out.println("3 - Mostrar nome e quantidade em estoque");
            System.out.println("4 - Alterar o preço do produto");
            System.out.println("5 - Mostrar o preço do produto");
            System.out.println("0 - Encerrar o programa");
            System.out.print("\nEscolha uma opção : ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1 -> {
                    produto.exibirInformacoes();
                }

                case 2 -> {
                    System.out.println("Informe a quantidade que quer adicionar: ");
                    int adicao = entrada.nextInt();
                    produto.atualizarEstoque(adicao);
                }

                case 3 -> {
                    System.out.println("Produto: " + produto.getNomeProduto()); 
                    System.out.println("Quantidade: " +produto.getQuantidadeProduto());
                }

                case 4 -> {
                    System.out.println("Informe o novo preço do produto: ");
                    double novoPreco = entrada.nextDouble();
                    produto.setPrecoProduto(novoPreco);
                }

                case 5 -> {
                    System.out.println("Preço: " + produto.getPrecoProduto());
                }

                case 0 -> {
                    System.out.println("\nPrograma encerrado.");
                }

                default -> {
                    System.out.println("\nOpção inválida. Confira as opções disponíveis e tente novamente.");
                }
            }

        } while ( opcao != 0 );

        entrada.close();
    }
}

