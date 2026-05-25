import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Personagem{
    String nome;
    private int energia;
    private int fome;
    private int sono;
    private ArrayList <String> mochila = new ArrayList<String>();
    private ArrayList <Musica> repertorio = new ArrayList<Musica>();
   
    public ArrayList <Musica> colecao = new ArrayList<>();

    public void carregarColecao(){
        colecao.add(new Musica("Time"));
        colecao.add(new Musica("Echoes"));
        colecao.add(new Musica("Into the Void"));
        colecao.add(new Musica("Solitude"));
        colecao.add(new Musica("Fairies Wear Boots"));
        colecao.add(new Musica("Take Five"));
        colecao.add(new Musica("Sonata No.27 op.90"));
        colecao.add(new Musica("Paranoid"));
        colecao.add(new Musica("Snowblind"));
        colecao.add(new Musica("Dogs"));
    }
    Personagem(){
        System.out.println("Construindo novo personagem");
        energia = 10;
        fome = 0;
        sono = 0;
        carregarColecao();
    }
    Personagem(String nome){
        this();
        this.nome = nome;
        carregarColecao();
    }
    Personagem(int energia, int fome, int sono) {
        System.out.println("Construindo novo personagem");
        this.energia = energia < 0 || energia > 10 ? 10 : energia;
        this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        this.sono = sono >= 0 && sono <= 10 ? sono : 0;
        carregarColecao();
    }
    Personagem(String nome,int energia, int fome, int sono){
        System.out.println("Construindo novo personagem");
        this.nome = nome;
        this.energia = energia < 0 || energia > 10 ? 10 : energia;
        this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        this.sono = sono >= 0 && sono <= 10 ? sono : 0;
        carregarColecao();
    }
    void novaMusica(Musica musica){
        repertorio.add(musica);
    }
    void cacar(){
        if(energia >= 2){
            System.out.printf("%s caçando\n", nome);
            energia -= 2; // energia = energia - 2
            loot();
        }else{
            System.out.printf("%s sem energia para caçar\n", nome);
        }
        // fome +=1 fome++ ++fome
        if (fome < 10) fome = fome + 1;
        // sono = sono + 1 > 10 ? sono : sono + 1;
        sono = sono == 10 ? sono : sono + 1;
    }
    //método comer
    void comer(){
        if(fome >= 1){
            System.out.println(nome + " comendo\n");
            energia = Math.min(energia + 1, 10);
            fome--;
        }
        else{
            System.out.println(nome + " sem fome\n");
        }
    }
    //método dormir
    void dormir(){
        if(sono >= 1){
        System.out.print(nome + " dormindo\n");
        energia = energia == 10 ? energia : energia + 1;
        sono -= 1;
        }else{
        System.out.println(nome + " sem sono\n");
        }
    }
    //método loot
    void loot(){
        var gerador = new Random();
        var gerarLoot = gerador.nextInt(1, 6);
        switch(gerarLoot){
            case 1:
                mochila.add("pena");
                break;
            case 2:
                mochila.add("couro");
                break;
            case 3:
                mochila.add("osso");
                break;
            case 4:
                mochila.add("presa");
                break;
            case 5:
                mochila.add("garra");
                break;
        }
    }
    void aprenderMusica(){
        var gerador = new Random();
        var qualeAmusica = gerador.nextInt(0, 10);
        if (repertorio.contains(colecao.get(qualeAmusica))){
            System.out.println(nome + " lembrou de uma musica\n");
        }  
        else{
            repertorio.add(colecao.get(qualeAmusica));
            System.out.println("\n"+nome + " Aprendeu uma nova musica!\n");
        }
    }
    abstract void realizarAcaoAleatoria();
    void dano(){
        energia -= 1;
    }
    boolean estaMorto(){
        if (energia <= 0){
            return true;
        }
        return false;
    }
    void duelar(Personagem inimigo){
        if(repertorio.size() == 0){
            return;
        }
        else{
            var gerador = new Random();
            var qualeAmusica = gerador.nextInt(0, repertorio.size());
            Musica ataque = repertorio.get(qualeAmusica);
            if (inimigo.repertorio.contains(ataque)){
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
    public String toString(){
        var sb = new StringBuilder("");
        if(estaMorto()){
            sb.append("\n").append("Falecido");
        }
        sb.append("\n").append(nome).append(" status:");
        sb.append("\n").append("energia: ").append(energia);
        sb.append("\n").append("fome: ").append(fome);
        sb.append("\n").append("sono:").append(sono);
        sb.append("\n").append("repertorio:");
        for (int i = 0; i < repertorio.size(); i++){
            sb.append("\n").append(" - ").append(repertorio.get(i));
        }
        sb.append("\n").append("inventario:");
        for (int i = 0; i < mochila.size(); i++){
            sb.append("\n").append(" - ").append(mochila.get(i));
        }
        return sb.toString();
    }
}