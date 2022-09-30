import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Arquivos_Atividade {
    File file;

    public Arquivos_Atividade(){
        file = new File("C:\\Users\\vinit\\OneDrive\\Área de Trabalho\\Arquivos_atividade");

        if(file.exists() == false){
            file.mkdir();
        }
    }

    public static void main(String[] args) {
        Arquivos_Atividade obj = new Arquivos_Atividade();
        obj.CriandoDiretorios();
        obj.criandoArquivos();
        obj.EscrevendoArquvios();
        obj.lerArquivo();

        //Escreva os cinco nomes lidos noutro arquivo com os nomes 
        //em caixa alta.

    }
    
    public void CriandoDiretorios(){
    // Crie um diretorio com outros três diretorios dentro
       try {
        
        if(file.isDirectory()){
            for(int i=0; i<3; i++){
                File dic = new File(file.getAbsoluteFile() + "\\diretorio_"+ String.valueOf(i+1));
                dic.mkdir();
            }
        }

       } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e.getMessage());
       }

    }

    public void criandoArquivos(){

        //criando o arquivo para escrever 
       try {
        
        File arquivo = new File(file.getAbsoluteFile() + "\\diretorio_1\\nomes.txt");
        arquivo.createNewFile();

        File arquivo1 = new File(file.getAbsoluteFile() + "\\diretorio_1\\nomes_altos.txt");
        arquivo1.createNewFile();

       } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e.getMessage());
       }
        
    }

    public void EscrevendoArquvios(){
    //Escreva um arquivo manualmente com cinco nomes, leia e imprima
        try {

            //escrevendo no arquivo
            FileWriter escritor = new FileWriter(file + "\\diretorio_1\\nomes.txt");
            BufferedWriter bfw = new BufferedWriter(escritor);
            String tmp = "Neymar JR" + "\r\n" + "Vini JR" + "\r\n" + "Raphinha" + "\r\n" + "Richarlison" + "\r\n" + "Pedro";

            FileWriter escritor1 = new FileWriter(file + "\\diretorio_1\\nomes_altos.txt");
            BufferedWriter bfw1 = new BufferedWriter(escritor1);


            bfw.write(tmp);
            bfw1.write(tmp.toUpperCase());


            bfw.close();
            bfw1.close();
            escritor.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public void lerArquivo(){

        try {
            FileReader leitor = new FileReader(file + "\\diretorio_1\\nomes.txt");
            BufferedReader bfr = new BufferedReader(leitor);
            String tmp="";

            FileReader leitor1 = new FileReader(file + "\\diretorio_1\\nomes_altos.txt");
            BufferedReader bfr1 = new BufferedReader(leitor1);

            JOptionPane.showMessageDialog(null, "Os arquivos lidos foram: \n" + "Arquivo lido: " + file + "\\diretorio_1\\nomes.txt" + "\n" + "Arquivo lido: " + file + "\\diretorio_1\\nomes_altos.txt");
            //JOptionPane.showMessageDialog(null, "Arquivo lido: " + file + "\\diretorio_1\\nomes_altos.txt");
            //System.out.println("Arquivo lido: " + file + "\\diretorio_1\\nomes.txt");
            while((tmp=bfr.readLine()) != null){
                System.out.println(tmp);
            }
            System.out.println("----------");
            //System.out.println("Arquivo lido: " + file + "\\diretorio_1\\nomes_altos.txt");
            while((tmp=bfr1.readLine()) != null){
                System.out.println(tmp);
            }

            bfr.close();
            bfr1.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}