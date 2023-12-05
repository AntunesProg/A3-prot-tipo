package bin.Class;

public class Boss {
    public String nome;
    public String skill1;
    public String skill2;
    public String skill3;
    public int vida = 100;
    public int dano, mana, resistencia;

    public int obterQuantidadeMana() {
        return mana;
    }

    public Boolean configurarVida(int vida) {
        if (vida > 0) {
            this.vida = vida;
            return true;
        } else {
            this.vida = 0;
            return false;
        }
    }

    @Override
    public String toString() {
        return "\n Nome: "
                + this.nome
                + "\n Vida: "
                + this.vida
                + "\n Mana: "
                + this.mana
                + "\n Habilidade 1: "
                + this.skill1
                + "\n Habilidade 2: "
                + this.skill2
                + "\n Habilidade 3: "
                + this.skill3
                + "\n";
    }
}