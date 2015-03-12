import java.util.LinkedList;
import java.util.List;

//Davi
public class Administrador {
	private String nome;
	private Cadastro cadastro;
	private String senha;
	private String login;
	private List<Materia> materias = new LinkedList();
	private List<Mensagem> mensagem = new LinkedList();
	
	Administrador(String nome,String senha,String login, Cadastro cad){
		this.nome = nome;
		this.senha = senha;
		this.login = login;
		this.cadastro = cad;
	}
	
	public void cadastrarMateria(Materia mat){
		materias.add(mat);
	}
	public boolean excluirMateria(String  mat){
		for (Materia mate: materias){
			
			if(mate.matches(mat)){
				materias.remove(mat);
				return true;
			}
		}
		return false;
	}
	public void definirCursosProfessor(String prof,String nome_materia){
		Professor enco = null;
		for(Professor pro:this.cadastro.getProfessores()){
			//System.out.println(cadastro.getProfessores());
			if(pro.getNome().equalsIgnoreCase(prof)) enco = pro;
		}
		for(Materia mat:materias){
			if(mat.matches(nome_materia)){
					enco.addMateria(mat);
			}
		}
	}
	
	public void enviarMensagem(String mensagem,String dest,String data){
		this.mensagem.add(new Mensagem(mensagem,dest,data));
	}
	
	public List<Materia> getMaterias(){
		return this.materias;
	}
	
	public Materia procuraMateria(String nome){
		Materia encon = null;
		for(Materia mat:this.materias){
			if(mat.matches(nome))encon = mat;
		}
		return encon;
	}
}