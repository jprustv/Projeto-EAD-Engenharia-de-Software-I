import java.util.List;
import java.util.LinkedList;
//Gustavo
public class Materia {
	private String senha_inscricao;
	private List<Aluno> alunos = new LinkedList();
	private List<Material> material = new LinkedList();
	private List<Tarefa> tarefas = new LinkedList();
	private List<Notas> notas = new LinkedList();
	private String nome;
	
	Materia(String senha_inscricao,String nome){
		this.senha_inscricao = senha_inscricao;
		this.nome = nome;
	}
	
	public boolean verificarSenha(String senha){
		if(!this.getSenha().equals(senha)){
			return false;
		}
		return true;
	}
	public boolean matches(String materia){
		if(this.nome.equalsIgnoreCase(materia))
			return true;
		return false;
	}
	
	public String getNome(){
		return this.nome;
	}
	public Notas mostrarNotaNota(Aluno aluno){
		for (Notas nota : notas) {
			if(nota.verificarAluno(aluno)){
				Notas nota_aluno = nota;
				return nota_aluno;
			}
		}
		return null;
	}
	
	public void addMaterial(Material material){
		this.material.add(material);
	}
	
	public String getSenha(){
		return this.senha_inscricao;
	}
	
	public List<Tarefa> getTarefas(){
		return this.tarefas;
	}
	
	public void incluirAluno(Aluno aluno, String senha){
		if(this.verificarSenha(senha)){
			alunos.add(aluno);
		}
	}
	
	public void excluirAluno(String aluno){
		for (Aluno alu : alunos) {
			if(alu.getNome().equalsIgnoreCase(aluno)){
				alunos.remove(alu);
			}
		}
	}
	
	public void publicarNotaAluno(Notas nota){
		notas.add(nota);
	}
	
	public void addTarefa(Tarefa tarefa){
		this.tarefas.add(tarefa);
	}
}
