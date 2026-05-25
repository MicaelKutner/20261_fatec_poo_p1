//data access object: objeto de acesso a dados
//jdbc: Java DataBase Connectivity
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class MusicaDAO {
  //cláusula catch or declare
  public void cadastrar(Musica m) throws Exception{
    //1. Definir o comando SQL
    var sql = "INSERT INTO tb_musicas(titulo) VALUES(?)";
    //2. Estabelecer uma conexão com O SGBD
    var conexao = ConnectionFactory.obterConexao();
    //3. Preparar o comando
    PreparedStatement ps = conexao.prepareStatement(sql);
    //4. Substituir os eventuais placeholders
    ps.setString(1, m.getTitulo());
    //5. Executar o comando
    ps.execute();
    ps.close();
    conexao.close();
  }  
  

  public static void listar(ArrayList<Musica> c) throws Exception{
    var sql = "SELECT * FROM tb_musicas";
    try(
      var conexao =  ConnectionFactory.obterConexao();
      var ps = conexao.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
    ){
      while(rs.next()){
        var titulo = rs.getString("titulo");
        var m = new Musica(titulo);
        c.add(m);
      }
    }
  }
  
}