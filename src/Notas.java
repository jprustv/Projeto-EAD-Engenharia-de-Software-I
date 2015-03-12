
public class Notas {
	private Double nota;
	private String materia;
	private Aluno aluno;
	
	Notas(Double nota,String materia,Aluno aluno){
		this.nota = nota;
		this.materia = materia;
		this.aluno = aluno;
	}
	public Double getNota(){
		return this.nota;
	}
	
	public boolean verificarAluno(Aluno aluno){
		if(this.aluno.equals(aluno)) return true;
		return false;
	}
}
