package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import entitie.Sale;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Entre o caminho do arquivo: ");
		String path = sc.next();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			List<Sale> list = new ArrayList<>();
			
			String line = br.readLine();
			System.out.println();
			while (line != null) {
				
				String[] field = line.split(",");
				Integer month = Integer.parseInt(field[0]);
				Integer year = Integer.parseInt(field[1]);
				String seller = field[2];
				Integer items = Integer.parseInt(field[3]);
				Double total = Double.parseDouble(field[4]);
				
				list.add(new Sale(month, year, seller, items, total));
				line = br.readLine();
			}
			
			System.out.println("======================================");
			
			ToDoubleFunction<Sale> sales = s -> s.avaragePrice();
			Comparator<Sale> Compare = Comparator.comparingDouble(sales);
									
			 list.stream()
			 		.filter(p -> p.getYear() == 2016)
			 		.sorted(Compare.reversed())
			 		.limit(5)
					.toList().forEach(System.out :: println);
			 
				System.out.println("======================================");
			
			List<Sale> sellers = list.stream()
			 		.filter(p -> p.getSeller().equals("Logan") )
			 		.collect(Collectors.toList());
			      
			 				 	
			 	Double sumVendas1 = sellers.stream()
			 			.filter(p -> p.getMonth() == 1 || p.getMonth() == 7)
			 			.map(p -> p.getTotal())
			 			.reduce(0.0, (x, y) -> x + y);
			 	
			 				 
			 	System.out.printf("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = %.2f ", sumVendas1 );
						
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();

	}

}
