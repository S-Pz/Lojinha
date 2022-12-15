package modelo;

public class Cliente extends Entidade {
    
    private int age;
    private long cpf;
    private String adress;
    private String name;
    private long phone;

    public Cliente() {

    	this.id = 0;
    	this.age = 0;
    	this.cpf = 0;
    	this.adress = "";
    	this.name = "";
    	this.phone = 0;
    }
    
    public Cliente(int id, String name, long cpf, long phone, int age, String adress) {
    	this.id = id;
    	this.age = age;
    	this.cpf = cpf;
    	this.adress = adress;
    	this.name = name;
    	this.phone = phone;
    } 

    public int getAge() {
        return this.age;
    }
    
    public void setAge(int ag) {
        this.age = ag;
    }

    public long getCpf() {
        return this.cpf;
    }
    
    public void setCpf(long cp) {
        this.cpf = cp;
    }

    public String getAdress() {
        return this.adress;
    }
    
    public void setAdress(String Ad) {
        this.adress = Ad;
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
        
        System.out.println("Nome: " + this.name);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Telefone: " + this.phone);
        System.out.println("Idade: " + this.age);
        System.out.println("Endereço: " + this.adress);
    }
    
}