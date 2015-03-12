import java.util.*;
public class Tarefa {
	private String nome_arquivo;
	private String data_upload;
	private int tamanho;
	private Aluno autor;
	
	public Tarefa(String na, String du, int t, Aluno a){
		nome_arquivo=na;
		data_upload=du;
		tamanho=t;
		autor=a;
	}
	
	public Tarefa getTarefa(){
		return this;
	}
	
	public void setTarefa(Tarefa t){
		nome_arquivo=t.nome_arquivo;
		data_upload=t.data_upload;
		tamanho=t.tamanho;
		autor=t.autor;
	}
	
	public String getNomeArquivo(){
		return nome_arquivo;
	}
	
	public String getDataUpload(){
		return data_upload;
	}
	
	public int getTamanho(){
		return tamanho;
	}
	
	public Aluno getAutor(){
		return autor;
	}
	
	public void setNomeArquivo(String na){
		nome_arquivo=na;
	}
	
	public void setDataUpload(String du){
		data_upload=du;
	}
	
	public void setTamanho(int t){
		tamanho=t;
	}
	
	public void setAutor(Aluno a){
		autor=a;
	}
}
