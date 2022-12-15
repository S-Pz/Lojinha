package modelo;

public class Produto extends Entidade {
    
    private String name;
    private String type;
    private float price;
    private int quantity;

    public String dados;

    public Produto() {

    	this.id = 0;
    	this.name = "";
    	this.price = 0;
        this.quantity = 0;
        this.type = "";
    }

    public Produto(int id, String name, String ty, int quant, float price) {

    	this.id = id;
    	this.name = name;
    	this.price = price;
        this.quantity = quant;
        this.type = ty;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return this.price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quant) {
        this.quantity = quant;
    }
    
    public void status() {
        System.out.println("Nome: "+ this.name);
        System.out.println("Tipo: " + this.type);
        System.out.println("Preço: " + this.price);
        System.out.println("Quantidade: " + this.quantity);
    }
    
}
