# Trabalho realizado na disciplina de Programação Orientada a Objetos

<p> 

Nesse trabalho tivemos como função simular a 
implementação de um sistema fictício, onde tivemos os desafio de implementar interfaces gráfica (janela) utilizando o java e implementar Padrões de estruturação de software como o MVC e o Singleton.
</p>

## MVC
<p>

O **Model-View-Controller (MVC)** é um padrão arquitetural de
software que organiza o software em três camadas:

•**Modelo:** gerencia e controla a forma como os dados se comportam;

• **Controlador:** intermedia as requisições enviadas pela Camada de
Visão com as respostas fornecidas pela Camada de Modelo;

• **Visão:** coleta e apresenta informações de/para o usuário.
</p>

## Singleton
<p>

Garante que uma classe tem uma única instância e provê um ponto de
acesso global a essa instância.

**Observamos em :** Em todas as classes controles encontramos algo semelhante com esse padrão. 
````java
private ClientePersist() {
	  clientes = new ArrayList<>();
	}

	public static ClientePersist getCliPer(){

	  if(cP == null){
		  cP = new ClientePersist();
		  cP.setIds(0);
		}

	  return cP;
	}
````
Nele obsevamos que a classe ````ClientePersist ```` possui um método que a instancia, o que garante que mesma seja instanciada uma única vez durante o código.

</p>