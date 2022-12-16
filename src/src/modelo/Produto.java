package modelo;

public class Produto extends Entidade {
    
    private static final long serialVersionUID = 1L;
    
	private String name;
    private String type;
    private float price;
    private int quantity;
    private Fornecedor fornecedor;

    public Produto() {
    	this.id = 0;
    	this.name = "";
    	this.price = 0;
        this.quantity = 0;
        this.type = "";
        this.fornecedor = null;
    }

    public Produto(int id, String name, String ty, int quant, float price, Fornecedor f) {
    	this.id = id;
    	this.name = name;
    	this.price = price;
        this.quantity = quant;
        this.type = ty;
        this.fornecedor = f;
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
    
    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }
    
    public void setFornecedor(Fornecedor f) {
        this.fornecedor = f;
    }
    
    public void status() {
        System.out.println("Nome: "+ this.name);
        System.out.println("Tipo: " + this.type);
        System.out.println("Preço: " + this.price);
        System.out.println("Quantidade: " + this.quantity);
    }
    
}
