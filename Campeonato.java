import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;
        
public class Campeonato implements Serializable{
    
    static Scanner in = new Scanner(System.in);
    static int[][] cartela = new int[13][4];
    static List<Jogador>jogadores = new LinkedList<>();         //Lista de jogadores
    static JogoGeneral jogoGeneral = new JogoGeneral();         //Um jogo general para os 3 jogadores
    
    //A main
    public static void main(String[] args) {
        menu();            //Chama o menu
        System.exit(0);
    }
    
    public static void menu(){
    
    //Menu   
    int OP=-1;
    while(OP!=0) {
        System.out.println("1 - Incluir Jogador ");
        System.out.println("2 - Remover Jogador ");
        System.out.println("3 - Iniciar/Reiniciar jogo ");
        System.out.println("4 - Mostrar Resultados ");
        System.out.println("5 - Gravar Dados do Campeonato em Arquivo");
        System.out.println("6 - Ler os Dados do Campeonato em Arquivo");
        System.out.println("0 - Fechar Jogo");
        OP=in.nextInt();
        switch (OP) {
            case 1:
                incluirJogador();
            break;
            case 2:
                excluirJogador();
                break;
            case 3:
                iniciar();
                break;
            case 4:
                resultado();
            break;
            case 5:
                gravar();
            break;
            case 6:
                ler();
            break;
	}
    }
        
    }
    //Função para incluir jogador, com parada de no máximo 3 jogadores
    public static void incluirJogador(){
        if (jogadores.size() == 3) {
            System.out.println("Já há 3 jogadores - Limite máximo");        //Confere se há o máximo de jogadores
        } else {
            System.out.println("Nome do jogador: ");                        //Adiciona jogador
            String nome = in.next();                                        //Salva o jogador em uma lista
            jogadores.add(new Jogador(nome));
            System.out.println("Jogador adicionado");
        }
    }
    //Excluir jogador
    public static void excluirJogador() {
        System.out.println("Qual jogador deseja retirar - 1, 2 ou 3?");     // Exclui o jogador excolhido, a escolha é feita por número
        int id = in.nextInt();
        jogadores.remove(id-1);
        System.out.println("Jogador removido");
    }

    //Iniciar o jogo, o jogo só para após 13 rodadas.
    public static void iniciar() {
        iniciarCartela();                                                   //Inicializa a cartela, cartela é uma matriz 13x4
        for (int k = 0; k < 13; k++) {
            for (int i = 0; i < jogadores.size(); i++) {
                Jogador get = jogadores.get(i);
                System.out.println("Rolando dados para " + get.getNome());
                System.out.println("valores obtidos:");
                jogoGeneral.rolarDados();
                Dado[] dado = jogoGeneral.getDados();
                System.out.print(dado[0].getSideUp());
                for (int j = 1; j < 5; j++) {
                    System.out.print(" - "+dado[j].getSideUp());
                }
                System.out.println("");
                System.out.println("Marque na cartela a melhor jogada - [1 - 13]");
                System.out.println("1  2  3  4  5  6 7(T) 8(Q) 9(F) 10(S-) 12(G) 13(X)");
                for (int j = 0; j < 13; j++) {                              //"For" usado para marcar o X na tela do usuário
                    if (cartela[j][i] != 0){
                        System.out.print("X  ");
                    } else {
                    System.out.print("-  ");
                    }
                }
                System.out.println("");
                
                int ponto = in.nextInt();                                  // Recebo a posição de onde será marcado na cartela
                
                if (cartela[ponto-1][i] != 1 ){
                    if (((ponto - 1) > -1 && (ponto - 1) < 6)  &&  (cartela[ponto-1][i] == 0)){
                            cartela[ponto-1][i] = cartela[ponto-1][3];
                    }else if(((ponto - 1) == 6 || (ponto - 1) == 7 || (ponto - 1) == 12) && (ponto -1) != 0){
                        for (int j = 0; j < 5; j++) {
                            cartela[ponto-1][i] = cartela[ponto-1][i] + dado[j].getSideUp();
                        }
                    } else if((ponto - 1) == 8 && (ponto -1) != 0){
                        cartela[ponto-1][i] = 25;
                    } else if((ponto -1) == 9 && (ponto -1) != 0){
                        cartela[ponto-1][i] = 30;
                    } else if((ponto -1) == 10 && (ponto -1) != 0){
                        cartela[ponto-1][i] = 40;
                    } else if((ponto -1) == 11 && (ponto -1) != 0){
                        cartela[ponto-1][i] = 50;
                    }
                        
                    System.out.println("");
                } else {
                    System.out.println("Ponto já acumulado");
                    System.out.println("");
                }
            }
        }
    }
    public static void resultado(){
        if (jogadores.size() != 0){
            int qut[] = new int[jogadores.size()];                //Confiro se a lista está vazia
            System.out.println("---Cartela de Resultados---");
            for (int i = 0; i < jogadores.size(); i++) {
                Jogador get = jogadores.get(i);
                System.out.print(get.getNome()+"   ");
            }
            System.out.println("");
            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < jogadores.size(); j++) {
                    System.out.print(cartela[i][j]+"    ");
                    qut[j] = qut[j] + cartela[i][j];
                }
                System.out.println("");
            }
            System.out.println("----------------------------");
            System.out.print("Total   ");
            for (int i = 0; i < jogadores.size(); i++) {
                Jogador get = jogadores.get(i);
                System.out.print(qut[i]+"   ");
                
            }
        } else {
            System.out.println("Não há nenhum jogador inscrito");
        }
        System.out.println("");
    }

    public static void gravar() {                         //Gravar resultados em arquivo .txt
        File arquivo = new File("JogoGeneral.txt");       //Usei para gravar a função que ler diretamente tudo que sai do print
                                                          //Foi a forma mais pratica que encontrei pra me ajudar por causa da lista que estou usando
        try{
            FileWriter arq = new FileWriter(arquivo);
            PrintWriter gravar = new PrintWriter(arq);
            
 
            if (jogadores.size() != 0){                   //confiro se a lista está vazia
            int qut[] = new int[jogadores.size()];
            gravar.println("---Cartela de Resultados---");
            for (int i = 0; i < jogadores.size(); i++) {
                Jogador get = jogadores.get(i);
                gravar.print(get.getNome()+"   ");
            }
            gravar.println("");
            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < jogadores.size(); j++) {
                    gravar.print(cartela[i][j]+"    ");
                    qut[j] = qut[j] + cartela[i][j];
                }
                gravar.println("");
            }
            gravar.println("----------------------------");
            gravar.print("Total   ");
            for (int i = 0; i < jogadores.size(); i++) {
                Jogador get = jogadores.get(i);
                gravar.print(qut[i]+"   ");
                
            }
            } else {
            gravar.println("Não há nenhum jogador inscrito");
            }
            
            gravar.flush();
            gravar.close();
            //fout.close();
            arq.close();
            
        }catch(Exception ex){
            System.err.println();
        }
    }
            
    public static void ler() {
        System.out.println("");
        System.out.println("Não consegui fazer essa função a tempo");
        System.out.println("");
    }
    
    public static void iniciarCartela(){         //Deixando fixo alguns valores que não depende de somas
        for (int i = 0; i < 13; i++) {           //Foi feito uma matrix 13x4, a posição [][4] é para os valores fixos
            for (int j = 0; j < 3; j++) {
                cartela[i][j]=0;    
            }   
        }
        cartela[0][3] = 3;
        cartela[1][3] = 4;
        cartela[2][3] = 3;
        cartela[3][3] = 8;
        cartela[4][3] = 5;
        cartela[5][3] = 6;
        
    }
}
