/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.classes;
import java.util.ArrayList;
import modelos.interfaces.IServicos;

public class ConjuntoProfessores implements IServicos{
  //Atributos
  private int tamanho = 0;
  private int indiceOcupacao = -1;
  private Professor array[] = null;
  //Metodos

  public ConjuntoProfessores(int tamanho)throws Exception {
    if(tamanho <= 0) throw new Exception("Tamanho não pode ser <= 0 ");
    this.tamanho = tamanho;
    array = new Professor[tamanho];
  }
  
  public int getTamanho() {
    return tamanho;
  }
  public int getIndiceOcupacao() {
    return indiceOcupacao;
  }
  public boolean verificarEstaCheio(){
    return (tamanho-1 == indiceOcupacao);
  }

  private int buscaSequencial(int matricula)throws Exception{
    for(int pos = 0; pos <= indiceOcupacao; pos++){
      if(matricula == array[pos].getMatricula()) return pos;
    }
    throw new Exception("Elemento não Existe");
  }

  @Override
  public void incluir(Professor professor) throws Exception {
    if (verificarEstaCheio()) {
      throw new Exception("Conjunto está cheio");
    }

    try {
      buscaSequencial(professor.getMatricula());
      throw new Exception("Professor com esta matrícula já existe");
    } catch (Exception e) {
      if (e.getMessage().equals("Elemento não Existe")) {
        indiceOcupacao++;
        array[indiceOcupacao] = professor;
      } else {
        throw e;
      }
    }
  }

  @Override
  public void excluir(int matricula) throws Exception {
    int pos = buscaSequencial(matricula);
    if (pos == -1) {
      throw new Exception("Professor não encontrado");
    }

    array[pos] = array[indiceOcupacao];
    array[indiceOcupacao] = null;
    indiceOcupacao--;
  }

  @Override
  public void alterar(Professor professor) throws Exception {
    int pos = buscaSequencial(professor.getMatricula());
    if (pos == -1) {
      throw new Exception("Professor não encontrado");
    }

    array[pos] = professor;
  }

  @Override
  public Professor[] listagemDeProfessores() throws Exception {
    return array.clone();
  }
}
