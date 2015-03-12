
public class Mensagem {
	private String corpoMsg;
	private String destinatario;
	private String data_envio;	
	 
	Mensagem(String corpo,String dest, String data){
		this.corpoMsg = corpo;
		this.destinatario = dest;
		this.data_envio = data;
	}
	/*public String getMensagem(){
		return this.corpoMsg;
	}
	public void setMensagem(String msg){
		this.corpoMsg = msg;
	}
	public void setDestinatario(String destinatario){
		this.destinatario = destinatario;
		}
	public void setData_envio(String data_envio){
		this.data_envio = data_envio;
	}*/
	
}
