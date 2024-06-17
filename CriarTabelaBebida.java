package controleestoque;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;


public class CriarTabelaBebida {

    private final Conexao conexaoSQLite = new Conexao();
    /** Utiliza a classe Statements para declarar a uma tabela.
     * A tabela receberá como nome a marca do produto.
     */
    public void criarTabela(String marca) {
        String sql = "CREATE TABLE IF NOT EXISTS "+ marca 
                + "("
                + "id text PRIMARY KEY,"
                + "nome text NOT NULL,"
                + "marca text NOT NULL,"
                + "valor REAL NOT NULL"
                + ");";
        boolean conectou = false;
        try {
            conectou = this.conexaoSQLite.conectar();
            Statement stmt = this.conexaoSQLite.criarStatement();
            stmt.execute(sql);
            System.out.println("Tabela " + marca + " criada!");
        } catch (SQLException e) {
//mensagem de erro na criação da tabela
        } finally {
            if (conectou) {
                this.conexaoSQLite.desconectar();
            }
        }
    }

}
