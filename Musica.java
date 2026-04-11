public class Musica {
    private String titulo;
    
    Musica (){

    }

    Musica(String titulo){
        this.titulo = titulo;
    }
    

    public String getTitulo() {
        return titulo;
    }
    
    @Override
    public String toString() {

        return String.format("%s", titulo);
    }
}
