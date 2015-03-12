import java.util.List;
//Gustavo
import java.util.LinkedList;

public class Aluno {
   private List<Materia> materias = new LinkedList();	
   private int id;
   private List<Mensagem> mensagem = new LinkedList();
   private Login login;
   private String nome;
   private boolean logado;
   
   Aluno(int id,Login login,String nome){
	   this.nome = nome;
	   this.login = login;
	   this.id = id;
   }
   
   public Aluno getAluno(){
	   return this;
   }
   
   public int getId(){
	   return id;
   }
   
	public boolean isLogado(){
		return logado;
	} 

	public void setLogado(boolean b){
		logado=b;
	}
   
   public boolean incluirMateria(String senha_inscricao,String materia,List<Materia> materias){
	   if(logado){ // Testando se está logado
		   for (Materia mate : materias) {
			   if(mate.matches(materia)){
		    		mate.incluirAluno(this, senha_inscricao);
		    		this.materias.add(mate);
		    		return true;
			   }
		   }
	   }
	   return false;
   }
   
   public void excluirMateria(String materia){
	   for (Materia mate : materias) {
		   if(mate.matches(materia))
			   materias.remove(mate);
	   }
   }
   
   public Login getLogin(){
	   return login;
   }
   
   public String getNome(){
	   return this.nome;
   }
   
   public void enviarMensagem(String mensagem,String dest,String data){
	   this.mensagem.add(new Mensagem(mensagem,dest,data));
	   System.out.println("Enviada com sucesso!");
   }
   
   public boolean carregarArquivo(String materia,Tarefa tarefa){
	   for(Materia mate:materias){
		   if(mate.matches(materia)){
			   mate.addTarefa(tarefa);
			   return true;
		   }
	   }
	   return false;
   }
   
   public boolean verNota(String materia){
	   for(Materia mate:this.materias){
		   if(mate.matches(materia)){
			  Notas nota= mate.mostrarNotaNota(this);
			  System.out.println("Sua nota: "+nota.getNota());
			  return true;
		   }
	   }
	   return false;
   }
}
