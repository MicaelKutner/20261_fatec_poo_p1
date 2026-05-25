import java.util.Random;

public class Cacador extends Personagem {
    Cacador(){
        super();
        System.out.println("Construindo novo personagem");
        // energia = 10;
        // fome = 0;
        // sono = 0;
    }
    Cacador (String nome){
        super(nome);
        // this();
        // this.nome = nome;
    }
    Cacador(int energia, int fome, int sono) {
        super(energia, fome, sono);
        System.out.println("Construindo novo personagem");
        // this.energia = energia < 0 || energia > 10 ? 10 : energia;
        // this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        // this.sono = sono >= 0 && sono <= 10 ? sono : 0;
    }
    Cacador(String nome,int energia, int fome, int sono){
        super (nome, energia, fome, sono);
        System.out.println("Construindo novo personagem");
        // this.nome = nome;
        // this.energia = energia < 0 || energia > 10 ? 10 : energia;
        // this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        // this.sono = sono >= 0 && sono <= 10 ? sono : 0;
    }

    void realizarAcaoAleatoria() {
        var gerador = new Random();
        if(!this.estaMorto()){
            var oQueFazer = gerador.nextInt(1,4);
            switch(oQueFazer){
                case 1:
                    this.cacar();
                    break;
                case 2:
                    this.comer();
                    break;
                case 3:
                    this.dormir();
                    break;                   
                }
            }
        else{
            System.out.println(this.nome + " morreu");
        }
    }
}