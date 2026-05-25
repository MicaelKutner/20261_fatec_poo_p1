import java.util.Random;
public class Bardo extends Personagem {
    Bardo(){
        super();
        System.out.println("Construindo novo personagem");
        this.novaMusica(new Musica("Cheia de Manias"));
        // energia = 10;
        // fome = 0;
        // sono = 0;
    }
    Bardo(String nome){
        super(nome);
        this.novaMusica(new Musica("Cheia de Manias"));
        // this();
        // this.nome = nome;
    }
    Bardo(int energia, int fome, int sono) {
        super(energia, fome, sono);
        System.out.println("Construindo novo personagem");
        this.novaMusica(new Musica("Cheia de Manias"));
        // this.energia = energia < 0 || energia > 10 ? 10 : energia;
        // this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        // this.sono = sono >= 0 && sono <= 10 ? sono : 0;
    }
    Bardo(String nome,int energia, int fome, int sono){
        super (nome, energia, fome, sono);
        System.out.println("Construindo novo personagem");
        this.novaMusica(new Musica("Cheia de Manias"));
        // this.nome = nome;
        // this.energia = energia < 0 || energia > 10 ? 10 : energia;
        // this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        // this.sono = sono >= 0 && sono <= 10 ? sono : 0;
    }

    void realizarAcaoAleatoria(){
        if(!this.estaMorto()){
            var gerador = new Random();
            var oQueFazer = gerador.nextInt(1,11);

            switch(oQueFazer){
                case 1, 2:
                    this.cacar();
                    break;
                case 3, 4:
                    this.comer();
                    break;
                case 5,6,7,8,9,10:
                    this.dormir();
                    break;
                }
                
            this.aprenderMusica();
        }
        else{
                System.out.println(this.nome + " morreu");
                
            }
    }
    @Override
    public void duelar(Personagem inimigo) {
        if(getRepertorio().size() == 0){
            return;
        }
        else{
            var gerador = new Random();
            var qualeAmusica = gerador.nextInt(0, getRepertorio().size());
            Musica ataque = getRepertorio().get(qualeAmusica);
            if (inimigo.getRepertorio().contains(ataque)){
                this.dano();
                inimigo.dano();
                System.out.println("\nO publico ficou entediado.");
            }
            else{
                inimigo.dano();
                inimigo.novaMusica(ataque);
                System.out.println("\n"+inimigo.nome+" foi vencido pelo ineditismo de "+this.nome);
            }

        }
    }
}
