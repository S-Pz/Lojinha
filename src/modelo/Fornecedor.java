package modelo;

public class Fornecedor extends Entidade {
    
    private static final long serialVersionUID = 1L;
    
	private String name;
    private long cnpj;
    private String adress;
    private long phone;

    public Fornecedor() {
    	this.id = 0;
    	this.cnpj = 0;
    	this.adress = "";
        this.name = "";
        this.phone = 0;
    }

    public Fornecedor(String name, long cnpj, long phone, String adress, int id) {
    	this.id = id;
        this.cnpj = cnpj;
    	this.adress = adress;
    	this.name = name;
    	this.phone = phone;
    } 

    public long getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getAdress() {
        return this.adress;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return this.phone;
    }
    
    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void status() {
        System.out.println("Nome: "+ this.name);
        System.out.println("CNPJ: " + this.cnpj);
        System.out.println("Telefone: " + this.phone);
        System.out.println("Endereço: " + this.adress);
    }
    
}
