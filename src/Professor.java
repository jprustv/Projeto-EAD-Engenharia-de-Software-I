import java.util.List;
import java.util.LinkedList;

//Davi
public class Professor {
	private List<Materia> materias = new LinkedList();
	private int id;
	private Login login;
	private String nome;
	private List<Mensagem> mensagem = new LinkedList();
	private boolean logado;
	
	Professor(int id,Login login,String nome){
		this.id = id;
		this.login = login;
		this.nome = nome;
	}
	
	public int getId(){
		return id;
	}
	
	public Professor getProfessor(){
		return this;
	}
	
	public boolean isLogado(){
		return logado;
	} 

	public void setLogado(boolean b){
		logado=b;
	}
	
	public void addMateria(Materia mate){
		materias.add(mate);
	}
	
	public boolean addMaterial(Material material,String materia){
		for(Materia mate: materias){
			if(mate.getNome().equalsIgnoreCase(materia)){
				mate.addMaterial(material);
				return true;
			}
		}
		return false;
	}
	
	public Login getLogin(){
		return this.login;
	}
	
	public String getNome(){
		return this.nome;
	}
	public List<Tarefa> baixarTarefas(){
		List<Tarefa> tarefas = new LinkedList();
		for (Materia m: materias){
			for (Tarefa t:m.getTarefas()){
				tarefas.add(t);
			}
		}
		return tarefas;
	}
	
	public boolean matches(String nome){
		if(this.getNome().equals(nome))
			return true;
		return false;
	}
	
	public void enviarMensagem(String mensagem,String dest,String data){
		this.mensagem.add(new Mensagem(mensagem,dest,data));
		System.out.println("Enviada com sucesso!");
	}
	
	public void publicarNotaAluno(String materia, Notas nota){
		for(Materia mat:this.materias){
			if(mat.matches(materia)){
				mat.publicarNotaAluno(nota);
			}
		}
	}
}
