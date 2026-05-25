import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Jogo {
    public static void main(String[] args) throws Exception{
        var gerador = new Random();
        // ArrayList <Musica> colecao = new ArrayList<>();
        // colecao.add(new Musica("Time"));
        // colecao.add(new Musica("Echoes"));
        // colecao.add(new Musica("Into the Void"));
        // colecao.add(new Musica("Solitude"));
        // colecao.add(new Musica("Fairies Wear Boots"));
        // colecao.add(new Musica("Take Five"));
        // colecao.add(new Musica("Sonata No.27 op.90"));
        // colecao.add(new Musica("Paranoid"));
        // colecao.add(new Musica("Snowblind"));
        // colecao.add(new Musica("Dogs"));
        Personagem p1 = new Cacador("Jarbas");
        Personagem p2 = new Bardo("Tico Trovador", 3, 8, 8);
        p2.novaMusica(new Musica("Cheia de Manias"));
        boolean campeaoDeclarado = false;
        while(true){

            p1.realizarAcaoAleatoria();
            p2.realizarAcaoAleatoria();
            
            var novoGerador = gerador.nextInt(1, 3);
            if(!p1.estaMorto() && !p2.estaMorto()){
                
                switch(novoGerador){
                    case 1:
                        p1.duelar(p2);
                        break;
                    case 2:
                        p2.duelar(p1);
                        break;
                }
            }
            if(p1.estaMorto() && !p2.estaMorto() && !campeaoDeclarado){
                System.out.println(p2.nome+" é o campeão\n");
                campeaoDeclarado = true;
            }
            if(!p1.estaMorto() && p2.estaMorto() && !campeaoDeclarado){
                System.out.println(p1.nome+" é o novo campeão\n");
                campeaoDeclarado = true;
            }
            System.out.println(p1);
            System.out.println(p2);
            System.out.println("******************************");
            if(p1.estaMorto() && p2.estaMorto()){
                System.out.println("Fim de Jogo!");
                break;
            }
            Thread.sleep(1);
        }
        
    }
}