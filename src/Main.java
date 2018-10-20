
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        BinaryTree abb = new BinaryTree();

        System.out.println("Informe o nome do primeiro arquivo de entrada: ");
        String prim = "";//entrada.nextLine();
        lerArquivoPrimeiro(prim, abb);      
                
        System.out.println("Informe o nome do segundo arquivo de entrada: ");
        String segun = "";//entrada.nextLine();
        ArrayList<String> comandos = lerSegundoArquivo(segun);

        
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
