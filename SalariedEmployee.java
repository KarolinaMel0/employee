package FolhaDePagamento;

// Subclasse
public class SalariedEmployee extends Employee {
    // extends pq herda de Employee (super)
    
    private double weeklySalary; 
    
    // Construtor
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber); // chama os construtores da super 
        
        // Verifica se é negativo
        if (weeklySalary < 0.0) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0"); // uma exceção
        }
        this.weeklySalary = weeklySalary; // se for validado, será atribuído
    }

    // Setter para weekly com a validação
    public void setWeeklySalary(double weekSalary) {
        if (weekSalary < 0.0) {  // Correção: verificar o parâmetro, não o campo
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        }
        this.weeklySalary = weekSalary; // atualiza
    }
    
    // Getter para semanal
    public double getWeeklySalary() {
        return weeklySalary; // retorna o valor semanal
    }
    
    // Implementa earnings: para assalariado, retorna o salário semanal
    @Override
    public double earnings() {
        return getWeeklySalary();  // Retorna o salário semanal como ganhos
    }
    
    // Implementa toString: adiciona informação do tipo e do salário à representação da superclasse
    @Override
    public String toString() {
        // "salaried employee: <super.toString()>
        //  weekly salary: $X"
        return String.format("salaried employee: %s%nweekly salary: $%,.2f", super.toString(), getWeeklySalary());
        // .2f para duas casas decimais (float)
    }
}
