package FolhaDePagamento;
//superclasse 
public abstract class Employee {
//abstract representa um funcionario generico, é um modelo (nao se instancia) e é uma basse para outras subclasses
	//a ideia é que qualquer classe q estenda essa classe abstrata precisa obrigattoriamente implementar o metodo 
	
	//atributos COMUNS
	//"final" siginifica que esses atributos sao imutáveis 
	private final String firstName;
	private final String lastName; 
	private final String socialSecurityNumber; 
	
	//construtores para inicializar os dados 
	public Employee(String firstName, String lastName , String socialSecurityNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	//método get(permite acesso segguro para os atributos priv) para acessar os dados 
	public String getFirstName() {
		return firstName; //retorna nome 
	}
	
	public String getLastName() {
		return lastName; //retorna sobrenome
	}
	
	public String getSocialSecurityNumber() {
		return socialSecurityNumber; // retorna numero de acesse /identificação
	}
	
	@Override
	// ele reescreve o método e faz o java usar o formato personalizado que faça senindo ao usuario
	//toString é uma representação textual básica tipo exibirInfo
	public String toString() {
		//vai retornar os atributos dado no inicio do codigo 
		
		return String.format("%s %s%nsocial security number: %s", getFirstName() , getLastName() , getSocialSecurityNumber());
			//format é apenas uma formatação para mostrar uma String personalizada
			//%s é pra string e %n é pra quebra de linha igual o \n
	}
	
	//metodo abstrato que pra calacular ganhos dos funcionarios 
	//cada subclasse deve implementar essa log especif
	public abstract double earnings(); //metodo earnings vai ser responsavel por retornar os ganho, e como ele é abstrato , a classe que herda precisa implementar

}


