import java.util.*;

//Jonathan
public class Cadastro {
	
	private List<Aluno> alunos = new LinkedList();
	private List<Professor> professores = new LinkedList();
	private Login login;
	
	
	public Aluno getAlunoByIndex(int id){
		for (Aluno alu:getAlunos()){
			if(alu.getId()==id) return alu;
		}
		return null;
	}
	
	public Professor getProfessorByIndex(int id){
		for (Professor pro:getProfessores()){
			if(pro.getId()==id) return pro;
		}
		return null;
	}
	
	public List<Aluno> getAlunos(){
		return alunos;
	}
	
	public List<Professor> getProfessores(){
		return professores;
	}
	
	public void cadastrarAluno(Aluno a){
		alunos.add(a);
	}
	
	public void cadastrarProfessor(Professor p){
		professores.add(p);
	}
	
	public boolean logarAluno(Login a){
		System.out.println("Logando aluno ["+a.getNomeUsuario()+"]...");
		for(Aluno alu:getAlunos()){
			if (a.verificarLogin(alu.getLogin()) && !alu.isLogado()){
				System.out.println("++Aluno logado com sucesso!");
				alu.setLogado(true);
				return true;
			}
		}
		return false;
	}	
	
	public boolean logarProfessor(Login p){
		System.out.println("Logando professor ["+p.getNomeUsuario()+"]...");
		for(Professor pro:getProfessores()){
			if (p.verificarLogin(pro.getLogin()) && !pro.isLogado()){
				System.out.println("++Professor logado com sucesso!");
				pro.setLogado(true);
				return true;
			}
		}
		return false;
	}	
	public void excluirProfessor(Professor p){
		professores.remove(p);
	}
	
	public void excluirAluno(Aluno a){
		professores.remove(a);
	}

}
