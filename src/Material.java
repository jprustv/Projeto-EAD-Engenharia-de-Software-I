//Davi
public class Material {
	private String nomeArquivo;
	private String data_upload;
	
	Material(String nomeArquivo, String data_upload){
		this.nomeArquivo = nomeArquivo;
		this.data_upload = data_upload;
	}
	public String getMaterial(){
		return this.nomeArquivo;
	}
}


