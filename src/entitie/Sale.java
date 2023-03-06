package entitie;

public class Sale {

	private Integer month;
	private Integer year;
	private String seller;
	private Integer items;
	private Double Total;
	
	public Sale() {
		
	}

	public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
		
		this.month = month;
		this.year = year;
		this.seller = seller;
		this.items = items;
		Total = total;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Integer getItems() {
		return items;
	}

	public void setItens(Integer items) {
		this.items = items;
	}

	public Double getTotal() {
		return Total;
	}
	
	public Double avaragePrice() {
		
		return Total / items;
		
	}
	
	

	/*public double filterSum(List<Sale> list, Predicate<Sale> criteria) {
		double sum = 0.0;
		for (Sale s : list) {
			if (criteria.test(s)) {
				sum += s.getTotal();
			}
		}
		return sum;
		}
*/
		
	@Override
	public String toString() {
		return  month + "/" + year + ", " + seller + ", " + items + ", "
				+ Total + ", pm = " + String.format("%.2f", avaragePrice());
	}

	
	
	
	
}
