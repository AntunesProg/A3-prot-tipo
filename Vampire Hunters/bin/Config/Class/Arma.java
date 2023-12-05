package bin.Config.Class;

public class Arma {
    private String nome;
    private int dano;
    private double acertoCritico;

    public Arma(String nome, int dano, double acertoCritico) {
        this.nome = nome;
        this.dano = dano;
        this.acertoCritico = acertoCritico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public double getAcertoCritico() {
        return acertoCritico;
    }

    public void setAcertoCritico(double acertoCritico) {
        this.acertoCritico = acertoCritico;
    }

    public int calcularDano() {
        double chanceCritico = Math.random() * 100; 
        if (chanceCritico <= acertoCritico) {
            return (int) (dano * 2); 
        } else {
            return dano;
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome
                + "\nDano: " + dano
                + "\nAcerto Crítico: " + acertoCritico + "%";
    }
}
