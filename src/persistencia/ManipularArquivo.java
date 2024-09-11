/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import java.io.BufferedReader;
import java.io.FileReader;
import modelos.classes.Professor;
import modelos.classes.ConjuntoProfessores;
/**
 *
 * @author ejmcc
 */
public class ManipularArquivo {
  //Atributo
  private String nomeDoArquivo = "";
  //Metodos

  public ManipularArquivo(String nomeDoArquivo) {
    this.nomeDoArquivo = nomeDoArquivo;
  }
  public ConjuntoProfessores obterListaProfessores()throws Exception{
    try{
      ConjuntoProfessores objConjuntoProfessores = new ConjuntoProfessores(600);
      FileReader fr = new FileReader(nomeDoArquivo);
      BufferedReader br  = new BufferedReader(fr);
      String linha = "";
      while((linha=br.readLine())!=null){
        String vetorStr[] = linha.split(";");
        Professor objetoProfessor = new Professor(Integer.parseInt(vetorStr[0]),
                  vetorStr[1],vetorStr[2],vetorStr[3],vetorStr[4]);
        objConjuntoProfessores.incluir(objetoProfessor);
      }
      br.close();
      return objConjuntoProfessores;
    }catch(Exception erro){
      throw erro;
    }   
  }
  }

