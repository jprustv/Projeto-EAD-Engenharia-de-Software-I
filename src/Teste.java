import java.util.List;


public class Teste {
	
	public static void main(String[] args){
		System.out.println("== Inicio do Programa ==\n");
		
		Cadastro cada = new Cadastro();
			
		String msgErroLogin = "++Falha no login. Possíveis causas: Login/Senha incorreto ou usuário já logado.\n";
		
		Administrador adm = new Administrador("Gustavo","senha123","ADMGUSTAVO", cada);
		adm.cadastrarMateria(new Materia("matematica","Matematica"));
		adm.cadastrarMateria(new Materia("portugues","Portugues"));
		adm.cadastrarMateria(new Materia("pythonelegal","Algoritmos"));
		
		cada.cadastrarProfessor(new Professor(1,new Login("AlineH","profaline123"),"Aline"));
		cada.cadastrarProfessor(new Professor(2,new Login("Massa","massa"),"Fernando"));
		cada.cadastrarAluno(new Aluno(2, new Login("johnny", "1234"), "Jonathan"));
		cada.cadastrarAluno(new Aluno(1,new Login("ZeDaDP","ze123"),"Zelmir"));
		cada.cadastrarAluno(new Aluno(3, new Login("davi","4321"), "Davi"));
		
		adm.definirCursosProfessor("Aline","Matematica");
		adm.definirCursosProfessor("Fernando","Algoritmos");
		
		if(adm.excluirMateria("Portugues"))
			System.out.println("Materia excluida com sucesso!");
		
		if(!cada.logarAluno(new Login("johnny","1234"))) System.out.println(msgErroLogin); // Login certo
		if(!cada.logarAluno(new Login("johnny","1234"))) System.out.println(msgErroLogin); // Tentando logar denovo
		if(!cada.logarAluno(new Login("johnny","senhaErrada"))) System.out.println(msgErroLogin); // Login errado
		if(!cada.logarProfessor(new Login("AlineH", "profaline123")))System.out.println(msgErroLogin); // Login certo
		if(!cada.logarProfessor(new Login("AlineH", "profaline123")))System.out.println(msgErroLogin); // Tentando logar denovo
		if(!cada.logarProfessor(new Login("LoginErrado", "profaline123")))System.out.println(msgErroLogin); // Login errado
		
		List<Professor> prof = cada.getProfessores();
		Professor profe = null;
		for(Professor pro:prof){
			if(pro.isLogado()){
				profe = pro;
				System.out.println(pro.getNome()+" está ativo(a)");
				break;
			}
		}

		if(profe.addMaterial(new Material("apostila1.pptx","21/04/14"), "Matematica"))
			System.out.println("Material adicionado!");
		else
			System.out.println("Erro ao adicionar o material!");
		
		List<Aluno> alu = cada.getAlunos();
		Aluno alun=null;
		for(Aluno aluno :alu){
			if(aluno.isLogado()){
				alun = aluno;
				System.out.println(alun.getNome()+" está ativo(a)");
				break;
			}
		}
		if(alun.incluirMateria("matematica", "Matematica",adm.getMaterias()))
			System.out.println("Materia inclusa com sucesso!");
		else
			System.out.println("Não foi possivel fazer a inscrição, verifique a senha de inscrição!");
		
		if(alun.incluirMateria("pitonelegal", "Python",adm.getMaterias()))
			System.out.println("Materia inclusa com sucesso!");
		else 
			System.out.println("Não foi possivel fazer a inscrição, verifique a senha de inscrição!");
		
		if(alun.carregarArquivo("Matematica", new Tarefa("list1.docx","21/04/14",404,alun)))
			System.out.println("Tarefa entregue com sucesso!");
		else
			System.out.println("Tarefa não entregue !");
		
		Aluno alunoNaoLogado = cada.getAlunoByIndex(3); // Testando aluno não logado tentando executar funções
		if(alunoNaoLogado.incluirMateria("matematica", "Matematica", adm.getMaterias()))
			System.out.println("Materia inclusa com sucesso!");
		else
			System.out.println("Não foi possivel fazer a inscrição, verifique a senha!");
		
		for(Tarefa tar:profe.baixarTarefas()){
			System.out.println("Aluno:"+tar.getAutor().getNome()+" "+tar.getNomeArquivo());
		}
		
		profe.publicarNotaAluno("Matematica", new Notas(8.5, "Matematica", cada.getAlunoByIndex(2))); 
		if(!alun.verNota("Matematica"))
			System.out.println("Matéria não existente!");
		if(!alun.verNota("Cálculo"))
			System.out.println("Matéria não existente!");	
		
		profe.enviarMensagem("o trabalho foi recebido.", "Jonathan", "24/04/2014");
		alun.enviarMensagem("Qual o dia da Prova?","Aline","28/04/2014");
		System.out.println("\n== Fim do Programa ==");
		
	}
}