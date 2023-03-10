package proyectoGimnasia.interfaces;

public interface iRepoGimnastaGrupo {
	void addGymnast();
	void editGymnast();
	void deleteGymnast();
	void showGymnast();

	public interface iRepoGrupo {
		void addGroup();
		void editGroup();
		void showGroup();
		void deleteGroup();
	}
}
