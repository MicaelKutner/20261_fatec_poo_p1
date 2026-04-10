import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Personagem{
    String nome;
    private int energia;
    private int fome;
    private int sono;
    private ArrayList <String> mochila = new ArrayList<String>();
    
    Personagem(){
        System.out.println("Construindo novo personagem");
        energia = 10;
        fome = 0;
        sono = 0;
    }
    Personagem(String nome){
        this();
        this.nome = nome;
    }
    Personagem(int energia, int fome, int sono) {
        System.out.println("Construindo novo personagem");
        this.energia = energia < 0 || energia > 10 ? 10 : energia;
        this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        this.sono = sono >= 0 && sono <= 10 ? sono : 0;
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
            System.out.println(nome + " comendo");
            energia = Math.min(energia + 1, 10);
            fome--;
        }
        else{
            System.out.println(nome + " sem fome");
        }
    }
    //método dormir
    void dormir(){
        if(sono >= 1){
        System.out.print(nome + " dormindo\n");
        energia = energia == 10 ? energia : energia + 1;
        sono -= 1;
        }else{
        System.out.println(nome + " sem sono");
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
    public String toString(){
        var sb = new StringBuilder("");
        sb.append("\n").append(nome).append(" status:");
        sb.append("\n").append("energia: ").append(energia);
        sb.append("\n").append("fome: ").append(fome);
        sb.append("\n").append("sono:").append(sono);
        sb.append("\n").append("inventario:");
        for (int i = 0; i < mochila.size(); i++){
            sb.append("\n").append(" - ").append(mochila.get(i));
        }
        return sb.toString();
    }
}