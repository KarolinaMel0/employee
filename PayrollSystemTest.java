package FolhaDePagamento;

//Classe de teste 
public class PayrollSystemTest {
 public static void main(String[] args) {
     // Cria instâncias concretas 
     SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
     HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
     CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
     BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300);

     // Exibe informações e ganhos de cada funcionario individualmente
     System.out.println("Employees processed individually:\n");
     System.out.printf("%s%nEarned: $%,.2f%n%n", salariedEmployee, salariedEmployee.earnings());
     System.out.printf("%s%nEarned: $%,.2f%n%n", hourlyEmployee, hourlyEmployee.earnings());
     System.out.printf("%s%nEarned: $%,.2f%n%n", commissionEmployee, commissionEmployee.earnings());
     System.out.printf("%s%nEarned: $%,.2f%n%n", basePlusCommissionEmployee, basePlusCommissionEmployee.earnings());

     // Cria um array de Employee 
     Employee[] employees = { salariedEmployee, hourlyEmployee, commissionEmployee, basePlusCommissionEmployee };

     System.out.println("Employees processed polymorphically:\n");

     // Percorre o array para cada elemento, chama toString() e earnings() polimorficamente
     for (Employee currentEmployee : employees) {
         System.out.println(currentEmployee); 

         // Se o funcionário for do tipo BasePlusCommissionEmployee, aplica aumento de 10% no baseSalary
         if (currentEmployee instanceof BasePlusCommissionEmployee) {
             // Downcast converte referência Employee para BasePlusCommissionEmployee
             BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
             employee.setBaseSalary(employee.getBaseSalary() * 1.10); // aumenta baseSalary em 10%
             System.out.printf("New base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
         }

         // Exibe os ganhos calculados (earnings) da forma polimórfica
         System.out.printf("Earned: $%,.2f%n%n", currentEmployee.earnings());
     }

     // Mostra o nome da classe real de cada objeto no array
     for (int j = 0; j < employees.length; j++) {
         System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
     }
 }
}