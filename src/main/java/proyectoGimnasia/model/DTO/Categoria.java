package proyectoGimnasia.model.DTO;

public enum Categoria {
	prebenjamin(5,7),
	benjamin(8,9),
	alevin(10,11),
	infantil(12,13),
	junior(14,15),
	senior(16,25);
	
	private final int minAge;
	private final int maxAge;
	
	Categoria(int minAge, int maxAge){
		this.minAge=minAge;
		this.maxAge=maxAge;
	}
	
	public boolean areInCategory(int age) {
		return age >= minAge && age <= maxAge;
	}
	
}
