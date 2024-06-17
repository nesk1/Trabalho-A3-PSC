package controleestoque;

// Classe para gerar uma conexão sql.
import java.sql.Connection;
// Classe que gerenciar a conexão sql.
import java.sql.DriverManager;
// Classe para tratamento da conexão sql.
import java.sql.SQLException;
// Cria as entidades e executa instruções SQL
import java.sql.Statement;
//Subclasse de Statements, executando instruçoes parametrizadas.
import java.sql.PreparedStatement;

public class Conexao {

    private Connection conexao;

    //Inicia a conexão com o banco de dados.
    public boolean conectar() {
        try {
            String url = "jdbc:sqlite:banco_sqlite.db";
            this.conexao = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        
        return true;
    }

    //Encerra a conecção.
    public boolean desconectar() {
        try {
            if (this.conexao.isClosed() == false) {
                this.conexao.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        
        return true;
    }

    /**Executa instruções SQL de forma estática.
     * Isto é, os valores da tabela devem estar predefinidos.
     * Será usada para fazermos criamos a entidade.
    **/
    public Statement criarStatement() {
        try {
            return this.conexao.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }
   /**Também executa instruções SQL, porém de forma parametrizada.
    * Isto é, os valores declarados podem ser variáveis.
    * Será usada para inserírmos dados na tabela.
    **/
    public PreparedStatement criarPreparedStament(String sql) {
        try {
            return this.conexao.prepareStatement(sql);
        } catch (SQLException e) {
            return null;
        }
    }
    // Retorna o resultado da conexão.
    public Connection getConexao() {
        return this.conexao;
    }

}
