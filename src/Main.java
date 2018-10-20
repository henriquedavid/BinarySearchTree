
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        BinaryTree abb = new BinaryTree();

        //System.out.println("Informe o nome do primeiro arquivo de entrada: ");
        String prim = "";//entrada.nextLine();
        lerArquivoPrimeiro(prim, abb);      
                
        //System.out.println("Informe o nome do segundo arquivo de entrada: ");
        String segun = "";//entrada.nextLine();
        ArrayList<String> comandos = lerSegundoArquivo(segun);

        String percursoEmOrdem = abb.ordem(abb.root);
        System.out.println("Simétrica/Ordem: " + percursoEmOrdem);
        
        for(String acao : comandos){
            if(acao.equals("IMPRIMA"))
                System.out.println(abb.toString());
            
            if(acao.contains("BUSCAR ")){
                char[] valor = acao.toCharArray();
                String valorS = "";
                for( int i = 7 ; i < acao.length(); i++){
                    valorS += valor[i];
                }
                int valorInteger = Integer.parseInt(valorS);
                abb.search(abb.root, valorInteger);
            }
            
            if(acao.contains("POSICAO ")){
                char[] valor = acao.toCharArray();
                String valorS = "";
                for( int i = 8 ; i < acao.length(); i++){
                    valorS += valor[i];
                }
                int valorInteger = Integer.parseInt(valorS);
                System.out.println(valorInteger + " está na posição " + abb.posicao(valorInteger));
            }
            
            if( acao.contains("ENESIMO ") ){
                char[] valor = acao.toCharArray();
                String valorS = "";
                for( int i = 8 ; i < acao.length(); i++){
                    valorS += valor[i];
                }
                int valorInteger = Integer.parseInt(valorS);
                System.out.println(valorInteger + "º elemento é " + abb.enesimoElemento(valorInteger));
            }
            
            if( acao.contains("MEDIANA")){
                System.out.println("A mediana é " + abb.mediana());
            }
            
            if( acao.contains("REMOVA ") ){
                char[] valor = acao.toCharArray();
                String valorS = "";
                for( int i = 7; i < acao.length(); i++){
                    valorS += valor[i];
                }
                int valorInteger = Integer.parseInt(valorS);
                abb.remove(valorInteger);
                System.out.println("Removido!!!");
                System.out.println(abb.ordem(abb.root));
            }
        }
        
        
                       

    }

    public static void lerArquivoPrimeiro(String nome, BinaryTree tree) {
        
        try {

            ArrayList<Integer> entrada = new ArrayList<>();

            FileReader arq = new FileReader("arquivo de entrada da ABB" + ".txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            while (linha != null) {

                char[] valores = linha.toCharArray();
                String valor = "";
                for (int i = 0; i < valores.length; i++) {
                    if (valores[i] != ' ') {
                        valor += valores[i];
                    } else {
                        int valorInteiro = Integer.parseInt(valor);
                        tree.insert(valorInteiro);
                        //entrada.add(valorInteiro);
                        valor = "";
                    }
                }
                int valorInteiro = Integer.parseInt(valor);
                tree.insert(valorInteiro);
                //entrada.add(valorInteiro);
                linha = lerArq.readLine();
            }

            arq.close();

        } catch (IOException o) {
            System.err.println("Erro ao abrir o primeiro arquivo. Erro: " + o.getMessage());
        }

        System.out.println();


    }

    public static ArrayList<String> lerSegundoArquivo(String nome) {
        try {
            ArrayList<String> entrada = new ArrayList<>();

            FileReader arq = new FileReader("arquivo de comandos" + ".txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            while (linha != null) {

                entrada.add(linha);
                linha = lerArq.readLine();
                
            }

            arq.close();
            return entrada;

        } catch (IOException o) {
            System.err.println("Erro ao abrir o segundo arquivo. Erro: " + o.getMessage());
        }

        System.out.println();

        return null;
    }

}
