//Ronald Pereira Evangelista
package Pessoa;

public class Pessoa {
    private static int kp = 0;
    private String nome = "";
    private char sexo = ' ';
    private int idade = 0;

    //CONSTRUCTOS METHODS
    public Pessoa(){
    }
    public Pessoa(String nome, char sexo, int idade){
        this.idade = idade;
        this.nome = nome;
        this.sexo = sexo;
    }

    //SETTERS METHODS
    public static void setKp(int kp) {
        Pessoa.kp = kp;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    //GETTERS METHODS
    public int getIdade() {
        return idade;
    }
    public static int getKp() {
        return kp;
    }
    public String getNome() {
        return nome;
    }
    public char getSexo() {
        return sexo;
    }
}
