package proyectoGimnasia.interfaces;

import proyectoGimnasia.model.DTO.Gimnasta;

public interface iRepoGimnasta {
	boolean addGymnast(Gimnasta gimnasta);
	void editGymnast();
	void deleteGymnast();
	void showGymnast();
}
