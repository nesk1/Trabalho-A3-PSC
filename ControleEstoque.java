package controleestoque;

import java.util.Scanner;

public class ControleEstoque {

    /**Execução do Gerenciador de estoque propriamente dito.
  **/
    public static void main(String[] args) {
/** declaração das vairiáveis usadas e instanciação do objeto bebida para termos .
*   acesso aos métodos.
**/    
        ControleEstoque controleestoque = new ControleEstoque();
        Scanner ler = new Scanner(System.in);
        Bebida bebida = new Bebida();
        String id,marca,descricao;
        double valor;
        int opcao;
//Loop de execução do programa, para que o usuário possa interagir o quanto quiser.
        do {
/**Imprimindo na tela as opções e pedindo ao usuário para inserir os dados nescessários
 * preenchendo os parâmetros necessários para a execução dos métodos.
 */ 
            System.out.println("\n Escolha uma das opçôes abaixo");
            System.out.println("1.Cadastrar Bebida");
            System.out.println("2.Remover Bebida");
            System.out.println("3. Consultar Bebida");
            System.out.println("4. editar Bebida");
            System.out.println("5.Sair");
            
            opcao = ler.nextInt();

            switch (opcao) {

                case 1:

                    System.out.println("Insira o codigo da nova bebida: ");
                    id = ler.next();
                    System.out.println("Insira a marca da nova bebida:");
                    marca = ler.next();
                    System.out.println("Insira a descrição da nova bebida:");
                    descricao = ler.next();
                    System.out.println("Insira o valor da nova bebida:");
                    valor = ler.nextDouble();

                    bebida.cadastrar(id, descricao, marca, valor);

                    break;

                case 2:

                    System.out.println("Insira o codigo bebida: ");
                    id = ler.next();
                    System.out.println("Insira a marca bebida:");
                    marca = ler.next();

                    bebida.remover(id, marca);

                    break;

                case 3:
                    System.out.println("Insira o codigo bebida: ");
                    id = ler.next();
                    System.out.println("Insira a marca bebida:");
                    marca = ler.next();

                    bebida.consulta(id, marca);

                    break;

                case 4:

                    System.out.println("Insira o codigo bebida: ");
                    id = ler.next();
                    System.out.println("Insira a marca bebida:");
                    marca = ler.next();
                    System.out.println("Insira a nova descrição da bebida: ");
                    descricao = ler.next();
                    System.out.println("Insira o valor da nova bebida:");
                    valor=ler.nextDouble();

                    bebida.remover(id,marca);
                    bebida.cadastrar(id,descricao,marca,valor);
                            
                    break;

                case 5:

                    break;
            }

        } while (opcao != 5);

    }

}
