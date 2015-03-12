import java.util.*;
//Jonathan
public class Login {
	
	private String nome_usuario;
	private String senha;
	
	public Login(String nu, String s){
		nome_usuario=nu;
		senha=s;
	}
	
	public Login getLogin(){
		return this;
	}
	

	public boolean verificarLogin(Login l){
		if(!nome_usuario.equals(l.nome_usuario)) return false;
		if(!senha.equals(l.senha)) return false;
		return true;
	}
	
	public String getNomeUsuario(){
		return nome_usuario;
	}
	
	public String getSenha(){
		return senha;
	}
	
	public void setNomeUsuario(String nu){
		nome_usuario=nu;
	}
	
	public void setSenha(String s){
		senha=s;
	}
	
}
