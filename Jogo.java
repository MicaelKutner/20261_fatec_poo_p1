import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Jogo {
    public static void main(String[] args) throws Exception{
        var gerador = new Random();
        var p1 = new Personagem("Jarbas");
        ArrayList <Musica> colecao = new ArrayList<>();
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
        var p2 = new Personagem("Tico Trovador", 3, 8, 8);
        p2.novaMusica(new Musica("Cheia de Manias"));
        while(true){
            if(!p1.estaMorto()){
                var oQueFazer = gerador.nextInt(1,4);
                switch(oQueFazer){
                    case 1:
                        p1.cacar();
                        break;
                    case 2:
                        p1.comer();
                        break;
                    case 3:
                        p1.dormir();
                        break;                   
                }
        
                p1.aprenderMusica(colecao);
                if(p1.estaMorto()){
                    System.out.println(p1.nome + " morreu");
                }
            }
            if(!p2.estaMorto()){
                var oQueFazer2 = gerador.nextInt(1,11);

                    switch(oQueFazer2){
                        case 1, 2:
                            p2.cacar();
                            break;
                        case 3, 4:
                            p2.comer();
                            break;
                        case 5,6,7,8,9,10:
                            p2.dormir();
                            break;
                }
                p2.aprenderMusica(colecao);
                if(p2.estaMorto()){
                    System.out.println(p2.nome + " morreu");
                }
            }
            boolean teste = p1.estaMorto();
            boolean teste2 = p2.estaMorto();
            System.out.println(p1);
            System.out.println(p2);
            System.out.println("******************************");
            if(teste && teste2){
                System.out.println("Fim de Jogo!");
                break;
            }
            //Thread.sleep(5000);
        }
        
    }
}