package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.Address;
import Entities.Department;
import Entities.Employee;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Nome do departamento:");
		String nameDepartment = sc.nextLine();
		System.out.print("Dia do pagamento:");
		int payDay = sc.nextInt();
		System.out.print("Email:");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Telefone:");
		String phone = sc.nextLine();

		Address add = new Address(email,phone);
		Department dept = new Department(nameDepartment,payDay,add);
		
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.println("Dados do funcionário " + (i + 1) + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String nameEmployee = sc.nextLine();
			System.out.print("Salário:");
			double salaryEmployee = sc.nextDouble();
			Employee emp = new Employee(nameEmployee,salaryEmployee);
			dept.addEmployee(emp);
		}

		showReport(dept);
		sc.close();
	}
	
	private static void showReport(Department dept) {
		
		System.out.println("\nFOLHA DE PAGAMENTO:");
		System.out.print("Departamento Vendas = " + String.format("%.2f", dept.payroll()));
		System.out.print("\nPagamento realizado no dia " + dept.getPayDay());
		System.out.println("\nFuncionários: ");
		for (Employee e: dept.getEmployees()) {
			System.out.println(e.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato:" + dept.getAdress().getEmail());
	}

}
