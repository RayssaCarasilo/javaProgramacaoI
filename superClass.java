class Veiculos{
    private int codigo;
    private String marca;
    private String modelo;
    private int ano;

    // construtor

    public Veiculo(int c, String ma, String mo, int a){
        this.codigo = c;
        this.marca = ma;
        this.modelo = mo;
        this.ano = a; 
    }

    // getters setters

    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.codigo = modelo;
    }

    public int getAno(){
        return ano;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public void mostrarDados(){
        System.out.println("\nCodigo : " + this.codigo);
        System.out.println("\nMarca : " + this.marca);
        System.out.println("\nModelo : " + this.modelo);
        System.out.println("\nAno : " + this.ano);
    }
    
}

public class Carro extends Veiculo{
    int numeroPortas;

    public Carro(int c, String ma, String mo, int a, int np){
        super (c, ma, mo, a);
    } 

    public int getNumeroPortas(){
        return numeroPortas;
    }       

    public void setNumeroPortas(int np){
        this.numeroPortas = np;
    }

    @Override 
    public void mostrarDados(){
        System.out.println("\nCodigo : " + this.codigo);
        System.out.println("\nMarca : " + this.marca);
        System.out.println("\nModelo : " + this.modelo);
        System.out.println("\nAno : " + this.ano);
        System.out.println("\nNumero de portas: " + this.numeroPortas);
    }
}

public class Moto extends Veiculo{
    int potencia;

    public Moto(int c, String ma, String mo, int a, int pot){
        super (c, ma, mo, a);
    } 

    public int getPotencia(){
        return potencia;
    }       

    public void setPotencia(int pot){
        this.potencia = pot;
    }

    @Override 
    public void mostrarDados(){
        System.out.println("\nCodigo : " + this.codigo);
        System.out.println("\nMarca : " + this.marca);
        System.out.println("\nModelo : " + this.modelo);
        System.out.println("\nAno : " + this.ano);
        System.out.println("\nPotencia: " + this.potencia);
    }
}

public class ExemploOOheranca{
    public static void main(String args[]){
        Carro c1 = new Carro( 1, "VW", "Tera", 2026, 6);
        c1.mostrarDados();

        Moto m1 = new Moto(2, "Honda", "CG160", 2020, 10);
        m1.mostrarDados();
    }
}
