package FolhaDePagamento;

//herda de funcionario 
//classe pra calcular funcionario pago por hora
public class HourlyEmployee extends Employee {
	
	//atributos
	private double wage; //valor por hr
	private double hours; // horas
	
	//contrutores que vai iniciar os atributos da super + os da classe funcionario pago por hora
	public HourlyEmployee(String firstName , String lastName , String socialSecurityNumber , double wage , double hours) {
		super(firstName, lastName, socialSecurityNumber);// pegando da super
		
		if (wage < 0.0)
			//se for invalido lança uma exceção
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		
		if ((hours < 0.0) || (hours > 168.0))///horas max semanais 
			throw new IllegalArgumentException("hours worked must be >= 0.0 and <= 168.00");
		
		this.wage = wage;//atribiu a remuneração 
		this.hours = hours;
	}
	
	//getter
	public double getWage() {
		return wage;
	}
	
	//setter para wage 
	public void setWage(double wage) {
		if (wage < 0.0)
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		this.wage = wage;
	}
	
	//get pra hora
	public double getHours() {
		return hours;
	}
	
	//calcula considerando as horas extras 
	@Override
	public double earnings() {
		if (getHours() <= 40)
			return getWage() * getHours(); //pagamento normal
		else 
			//40 horas normais + hora estra * 1.5 * wage
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
	}
	
	//toString inclue o tipo , dados da super, salario por hora e horas trab
	@Override
	public String toString() {
		return String.format("hourly employee: %s%nhourly wage: $%,.2f; hours worked: %,.2f", super.toString(), getWage(), getHours());
	}
}
