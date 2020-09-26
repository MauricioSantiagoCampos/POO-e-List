package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US); // O comando faz o programa utilizar o padrão americano de separador de decimais, ou seja, o ponto.
		Scanner scanner = new Scanner(System.in);
		
		
		List<Employee> list = new ArrayList<>(); 
		
		System.out.print("How many employees will be registered?");
		int N = scanner.nextInt();
		
		for (int i=0; i<N; i++) {
			
			System.out.println();
			System.out.println("Employee #" + (i+1) + ": ");
			
			System.out.print("Id: ");
			Integer id = scanner.nextInt();			
			
			System.out.print("Name: ");
			
	/*
	 *  Este .nextLine é para limpar o o scanner, pois se não o comando abaixo irá ler uma linha vazia logo após o .nextInt
	 *  Para testar o que acontece, pode comentar o comando abaixo com [ // ] e rodar o programa.
	 */
			scanner.nextLine();
			
			String name = scanner.nextLine();
			
			System.out.print("Salary: ");
			Double salary = scanner.nextDouble();
			
			Employee employee = new Employee(id, name, salary);
			
			list.add(employee);
		}
		
		System.out.println();
		System.out.print("Enter de employee id that will have salary increase: ");
		int increasedSalaryId = scanner.nextInt();
		
		Employee employee = list.stream().filter(x -> x.getId() == increasedSalaryId).findFirst().orElse(null);
	/*
	 *  OBS.: abaixo foi utilizado um método sem utilizar a função acima para verificar se há ou não o id do funcionario digitado em increasedSalaryId.
	 *  É necessario refatorar o programa caso deseje testar o método abaixo, favor verificar o commit anterior [ Primeira Resolução ]
	 */
		//Integer position = position(list, increasedSalaryId);
		
		if(employee == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = scanner.nextDouble();
			
			employee.increaseSalary(percentage);
		}
		
		System.out.println();
		System.out.println("List of Employyes: ");
		
		for (Employee listOfEmployees : list) {
			System.out.println(listOfEmployees);
		}
		
		
		scanner.close();
	}
	
	public static Integer position(List<Employee> list, int id) {
		
		for(int i=0; i < list.size(); i++) {
			
			if(list.get(i).getId() == id) {
				return i;
			}			
		}
		
		return null;
		
	}

}
