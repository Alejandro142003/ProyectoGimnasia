package proyectoGimnasia.model.DTO;

public enum Categoria {
	Prebenjamin(5,7),
	Benjamin(8,9),
	Alevin(10,11),
	Infantil(12,13),
	Junior(14,15),
	Senior(16,25);
	
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
