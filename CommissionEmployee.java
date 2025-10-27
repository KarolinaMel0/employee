package FolhaDePagamento;

//subclasse
public class CommissionEmployee extends Employee {
	 private double grossSales;      // vendas brutas na semana
	    private double commissionRate;  // taxa 

	    // Construtores
	    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate){
	        super(firstName, lastName, socialSecurityNumber); // chama super

	        if (commissionRate <= 0.0 || commissionRate >= 1.0) // valida  (0 < rate < 1)
	            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

	        if (grossSales < 0.0) // valida vendas
	            throw new IllegalArgumentException("Gross sales must be >= 0.0");

	        this.grossSales = grossSales; // atribui vendas
	        this.commissionRate = commissionRate; // atribui taxa
	    }

	    // Getter para grossSales
	    public double getGrossSales(){
	    	return grossSales; }

	    // Setter para grossSales 
	    public void setGrossSales(double grossSales) {
	        if (grossSales < 0.0)
	            throw new IllegalArgumentException("Gross sales must be >= 0.0");
	        this.grossSales = grossSales;
	    }
	    
	 // Getter para commissionRate
	    public double getCommissionRate(){
	    	return commissionRate; }

	   
	    // Setter para commissionRate com validação
	    public void setCommissionRate(double commissionRate) {
	        if (commissionRate <= 0.0 || commissionRate >= 1.0)
	            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
	        this.commissionRate = commissionRate;
	    }

	    

	    // earnings: calcula comissão = commissionRate * grossSales
	    @Override
	    public double earnings() { return getCommissionRate() * getGrossSales(); }

	    // toString: inclui tipo, string da superclasse, vendas e taxa
	    @Override
	    public String toString() {
	        return String.format("commission employee: %s%ngross sales: $%,.2f; commission rate: %.2f",
	                super.toString(), getGrossSales(), getCommissionRate());
	    }

}
