package FolhaDePagamento;

//funcionario que ecebe salario base mais a comissao
public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary; // salário fixo semanal

    // Construtor
    public BasePlusCommissionEmployee(String firstName, String lastName,String socialSecurityNumber, double grossSales, double commissionRate,double baseSalary){
     super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

        if (baseSalary < 0.0) // valida 
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary; // atribui 
    }
    
    // Getter para baseSalary
    public double getBaseSalary(){ 
    	return baseSalary; }

    // Setter para baseSalary com validação
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        this.baseSalary = baseSalary;
    }

    

    // retorna baseSalary + comissão 
    @Override
    public double earnings() {
        return getBaseSalary() + super.earnings(); // soma salário-base com a parte comissionada
    }

    // indica que é base-salaried e adiciona o valor do salário-base
    @Override
    public String toString() {
        return String.format("base-salaried %s; base salary: $%,.2f",
                super.toString(), getBaseSalary());
    }


}
