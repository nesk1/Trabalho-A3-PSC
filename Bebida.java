package controleestoque;

import java.sql.*;
import java.util.Scanner;

public class Bebida extends CriarTabelaBebida {

    // Atributos da classe bebida e respectivo encapsulamento.
    private final Conexao conexaoSQLite = new Conexao();
    Scanner ler = new Scanner(System.in);

    public Bebida() {

    }

    // Método para cadastrar a bebida.
   public void cadastrar(String id, String nome, String marca, double valor) {

// instância do objeto criartabela.
        CriarTabelaBebida tabelabebida = new CriarTabelaBebida();
//Criando e definindo o nome da tabela. 
        tabelabebida.criarTabela(marca);
        
/**Conectando ao banco de dados e inserindo uma declaração sql para setar dados
  * uma linha da tabela, que terá seu nome segundo a marca.
  **/
        conexaoSQLite.conectar();
        String sqlInsert = "INSERT INTO " + marca + " (id,nome,marca,valor) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStament(sqlInsert);
        try {
//inserindo os dados na tabela
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, nome);
            preparedStatement.setString(3, marca);
            preparedStatement.setDouble(4, valor);
            int resultado = preparedStatement.executeUpdate();
//Se resultado for 1 inseriu, senão quer dizer que não inseriu.
            if (resultado == 1) {
                System.out.println("Dados inseridos com sucesso");
            } else {
                System.out.println("Dados não inseridos!!!!");
            }
        } catch (SQLException e) {
            System.out.println("Dados não inseridos!!!!");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                conexaoSQLite.desconectar();
            }
        }

    }

    // Método para remover a bebida.
    public void remover(String id, String marca) {
        
/**Conectando ao banco de dados e inserindo uma declaração sql para deletar
  * uma linha da tabela buscando-a por id.
  **/
        conexaoSQLite.conectar();
        String sqlInsert = "DELETE FROM " + marca + " WHERE id= " + id;
        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStament(sqlInsert);

        try {
            int resultado = preparedStatement.executeUpdate();
//Se resultado for 1 inseriu, senão quer dizer que não inseriu.
            if (resultado == 1) {
                System.out.println("Dados removidos com sucesso");
            } else {
                System.out.println("Dados não removidos!!!!");
            }
        } catch (SQLException e) {
            System.out.println("Dados não removidos!!!!");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                conexaoSQLite.desconectar();
            }
        }

    }

    // Método para consultar a bebida recebendo ser nome
    public void consulta(String id, String marca) {
/**Conectando ao banco de dados e inserindo uma declaração sql para retornar
  * uma linha da tabela buscando-a por id.
  **/
        final String SQL = "select * from " + marca + " where id = " + id;
        
        try {
            conexaoSQLite.conectar();
            PreparedStatement select = conexaoSQLite.criarPreparedStament(SQL);
            ResultSet rs = select.executeQuery();
            while (rs.next()) {
/**Imprimindo na tela os dados de uma linha da tabela.
  **/
                System.out.println(" - id: " + rs.getString("id") + "\n"
                        + " - " + "descrição: " + rs.getString("nome") + "\n"
                        + " - " + "marca: " + rs.getString("marca") + "\n"
                        + " - " + "valor: " + rs.getDouble("valor") + "\n");
            }
            conexaoSQLite.desconectar();
            select.close();
        } catch (SQLException e) {
            System.out.println("Linha inexistente");
        }
    }

}
