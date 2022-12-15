package modelo;

public class Fornecedor extends Entidade {
    
    private String nameFantasy;
    private long cnpj;
    private String adress;
    private long phone;

    public Fornecedor() {

    	this.id = 0;
    	this.cnpj = 0;
    	this.adress = "";
        this.nameFantasy = "";
        this.phone = 0;
    }

    public Fornecedor(String nameFantasy, long cnpj, long phone, String adress, int id) {
    	
    	this.id = id;
        this.cnpj = cnpj;
    	this.adress = adress;
    	this.nameFantasy = nameFantasy;
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
        return this.nameFantasy;
    }
    
    public void setName(String nameFantasy) {
        this.nameFantasy = nameFantasy;
    }

    public long getPhone() {
        return this.phone;
    }
    
    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void status() {
        System.out.println("Nome Fantasia: "+ this.nameFantasy);
        System.out.println("CNPJ: " + this.cnpj);
        System.out.println("Telefone: " + this.phone);
        System.out.println("Endereço: " + this.adress);
    }
    
}
