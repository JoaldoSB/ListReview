package br.com.listreview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListApplication {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o n�mero de funcionarios que ser�o cadastrados:");
		int num = sc.nextInt();
		
		List<Funcionario> list = new ArrayList<>();
		
		for (int i=0; i<num; i++) {
			System.out.println("Funcionario #" +(i+1) +":");
			System.out.println("ID:");
			Integer id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.println("Id informado j� encontra-se cadastrato, tente novamente:");
				id = sc.nextInt();
			}
			
			sc.nextLine();//necessario em virtude do enter est� consumindo o scanner
			System.out.println("Nome:");
			String nome = sc.nextLine();
			System.out.println("Salario:");
			Double salario = sc.nextDouble();
			
			Funcionario funcionario = new Funcionario(id, nome, salario);
			
			list.add(funcionario);
		}
				
		System.out.println("Informe o ID do funcionario que receber� a promo��o:");
		Integer idPromo = sc.nextInt();
		
		Funcionario funcPromo = list.stream().filter(f -> f.getId() == idPromo).findFirst().orElse(null);
		
		if (funcPromo == null) {
			System.out.println("Nenhum funcionario encontrado!");
		} else {
			System.out.println("Informe o percentual de aumento:");
			double percentage = sc.nextDouble();
			funcPromo.aumentoSalario(percentage);
		}
		
		System.out.println("Lista de funcionarios:");
		for (Funcionario funcionarios : list) {
			System.out.println(funcionarios);
		}
		
	}
	
	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario idExist = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return idExist != null;
	}
	
}
