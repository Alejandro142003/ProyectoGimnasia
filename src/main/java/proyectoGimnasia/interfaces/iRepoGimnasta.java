package proyectoGimnasia.interfaces;

import proyectoGimnasia.model.DTO.Gimnasta;

public interface iRepoGimnasta {
	boolean addGymnast(Gimnasta gimnasta);
	boolean editGymnast(int dorsal);
	void deleteGymnast(int dorsal);
	Gimnasta showGymnast(int dorsal);
	String showAllGymnasts();
}
