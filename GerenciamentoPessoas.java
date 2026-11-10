
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pessoa {
    private String nome;
    private int matricula;
    private int idade;

    public Pessoa(String nome, int matricula, int idade) {
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void exibirDados() {
        System.out.println("Nome : " + this.nome);
        System.out.println("Matricula : " + this.matricula);
        System.out.println("Idade : " + this.idade);
    }
}

class Funcionario extends Pessoa {
    private String setor;
    private double salario;

    public Funcionario(String nome, int matricula, int idade, String setor, double salario) {
        super(nome, matricula, idade);
        this.setor = setor;
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void exibirDados() {
        System.out.println("\nDados do Funcionario:");
        super.exibirDados();
        System.out.println("Setor : " + this.setor);
        System.out.println("Salario: " + this.salario);
    }
}

class Professor extends Pessoa {
    private String disciplina;
    private String titulacao;

    public Professor(String nome, int matricula, int idade, String disciplina, String titulacao) {
        super(nome, matricula, idade);
        this.disciplina = disciplina;
        this.titulacao = titulacao;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public void exibirDados() {
        System.out.println("\nDados do Professor:");
        super.exibirDados();
        System.out.println("Disciplina : " + this.disciplina);
        System.out.println("Titulacao: " + this.titulacao);
    }
}

class Aluno extends Pessoa {
    private String curso;
    private int semestre;

    public Aluno(String nome, int matricula, int idade, String curso, int semestre) {
        super(nome, matricula, idade);
        this.curso = curso;
        this.semestre = semestre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public void exibirDados() {
        System.out.println("\nDados do Aluno:");
        super.exibirDados();
        System.out.println("Curso : " + this.curso);
        System.out.println("Semestre: " + this.semestre);
    }
}

public class GerenciamentoPessoas {

    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        int escolha, tipoPessoa;
        int matricula, idade;
        String nome;
        boolean matriculaJaCadastrada = false;

        listaPessoas.add(new Funcionario("Exemplildo da Silva", 232323, 23, "Limpeza", 4000));
        listaPessoas.add(new Professor("Ronaldinho", 565656, 32, "Robotica", "Mestrado"));
        listaPessoas.add(new Aluno("Fulaninho Querido", 787878, 15, "Sistemas de Informacoes", 3));

        do {
            System.out.println("\n=========== Menu ===========");
            System.out.println("1 - Incluir pessoa");
            System.out.println("2 - Consultar pessoa");
            System.out.println("3 - Retirar pessoa");
            System.out.println("4 - Listar todas as pessoas");
            System.out.println("0 - Sair");
            System.out.println("=============================");
            System.out.print("\nDigite a opcao desejada: ");
            escolha = teclado.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o tipo de pessoa: ");
                    System.out.println("1 - Funcionario");
                    System.out.println("2 - Professor");
                    System.out.println("3- Aluno");
                    tipoPessoa = teclado.nextInt();

                    if (tipoPessoa != 1 && tipoPessoa != 2 && tipoPessoa != 3) {
                        System.out.println("Tipo de pessoa invalido. Tente novamente.");
                    }

                    if (tipoPessoa == 1) {
                        System.out.println("Digite o nome do funcionario: ");
                        nome = teclado.next();

                        System.out.println("Digite a matricula do funcionario: ");
                        matricula = teclado.nextInt();

                        System.out.println("Digite a idade do funcionario: ");
                        idade = teclado.nextInt();

                        for (Pessoa p : listaPessoas) {
                            if (p.getMatricula() == matricula) {
                                System.out.println("Matricula ja cadastrada. Pessoa nao incluida. Tente novamente.");
                                matriculaJaCadastrada = true;
                                break;
                            } else if (nome.isEmpty() || matricula <= 0 || idade <= 0) {
                                System.out.println("Dados invalidos. Pessoa nao incluida. Tente novamente.");
                                matriculaJaCadastrada = true;
                                break;
                            }
                        }

                        System.out.println("Digite o setor do funcionario: ");
                        String setor = teclado.next();

                        System.out.println("Digite o salario do funcionario: ");
                        double salario = teclado.nextDouble();

                        Funcionario funcionario = new Funcionario(nome, matricula, idade, setor, salario);
                        listaPessoas.add(funcionario);

                    } else if (tipoPessoa == 2) {
                        System.out.println("Digite o nome do professor: ");
                        nome = teclado.next();

                        System.out.println("Digite a matricula do professor: ");
                        matricula = teclado.nextInt();

                        System.out.println("Digite a idade do professor: ");
                        idade = teclado.nextInt();

                        for (Pessoa p : listaPessoas) {
                            if (p.getMatricula() == matricula) {
                                System.out.println("Matricula ja cadastrada. Pessoa nao incluida. Tente novamente.");
                                matriculaJaCadastrada = true;
                                break;
                            } else if (nome.isEmpty() || matricula <= 0 || idade <= 0) {
                                System.out.println("Dados invalidos. Pessoa nao incluida. Tente novamente.");
                                matriculaJaCadastrada = true;
                                break;
                            }
                        }

                        System.out.println("Digite a disciplina do professor: ");
                        String disciplina = teclado.next();

                        System.out.println("Digite a titulacao do professor: ");
                        String titulacao = teclado.next();

                        Professor professor = new Professor(nome, matricula, idade, disciplina, titulacao);
                        listaPessoas.add(professor);

                    } else if (tipoPessoa == 3) {
                        System.out.println("Digite o nome do aluno: ");
                        nome = teclado.next();

                        System.out.println("Digite a matricula do aluno: ");
                        matricula = teclado.nextInt();

                        System.out.println("Digite a idade do aluno: ");
                        idade = teclado.nextInt();

                        for (Pessoa p : listaPessoas) {
                            if (p.getMatricula() == matricula) {
                                System.out.println("Matricula ja cadastrada. Pessoa nao incluida. Tente novamente.");
                                matriculaJaCadastrada = true;
                                break;
                            } else if (nome.isEmpty() || matricula <= 0 || idade <= 0) {
                                System.out.println("Dados invalidos. Pessoa nao incluida. Tente novamente.");
                                matriculaJaCadastrada = true;
                                break;
                            }
                        }

                        System.out.println("Digite o curso do aluno: ");
                        String curso = teclado.next();

                        System.out.println("Digite o semestre do aluno: ");
                        int semestre = teclado.nextInt();

                        Aluno aluno = new Aluno(nome, matricula, idade, curso, semestre);
                        listaPessoas.add(aluno);
                        break;
                    }

                    break;

                case 2:
                    System.out.println("Digite a matricula da pessoa que deseja consultar: ");
                    int matriculaConsulta = teclado.nextInt();
                    boolean pessoaEncontrada = false;

                    for (Pessoa pessoa : listaPessoas) {
                        if (pessoa.getMatricula() == matriculaConsulta) {
                            System.out.println("\nDados da pessoa encontrada:");
                            pessoa.exibirDados();
                            pessoaEncontrada = true;
                            break;
                        }
                    }
                    if (!pessoaEncontrada) {
                        System.out.println("Pessoa não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Digite a matricula da pessoa que deseja retirar: ");
                    int matriculaRetirar = teclado.nextInt();
                    boolean pessoaRemovida = false;

                    for (Pessoa pessoa : listaPessoas) {
                        if (pessoa.getMatricula() == matriculaRetirar) {
                            listaPessoas.remove(pessoa);
                            System.out.println("Pessoa removida com sucesso.");
                            pessoaRemovida = true;
                            break;
                        }
                    }
                    if (!pessoaRemovida) {
                        System.out.println("Pessoa não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("\n==== Lista de pessoas cadastradas ====");
                    for (Pessoa pessoa : listaPessoas) {
                        pessoa.exibirDados();
                    }
                    break;

                case 0:
                    System.out.println("Saindo do programa.");
                    break;

                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (escolha != 0);
    }
}
