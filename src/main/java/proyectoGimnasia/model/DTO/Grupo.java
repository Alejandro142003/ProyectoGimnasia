package proyectoGimnasia.model.DTO;

import java.util.ArrayList;

public class Grupo {
	private String groupName;
	private int dorsal;
	private String club;
	private ArrayList<Gimnasta> listGimnasta;

    public Grupo() {
        listGimnasta = new ArrayList<Gimnasta>();
    }
  
    public Grupo(String groupName, int dorsal, String club, ArrayList<Gimnasta> listGimnasta) {
    
		this.groupName = groupName;
		this.dorsal = dorsal;
		this.club = club;
		this.listGimnasta = listGimnasta;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public ArrayList<Gimnasta> getListGimnasta() {
		return listGimnasta;
	}

	public void setListGimnasta(ArrayList<Gimnasta> listGimnasta) {
		this.listGimnasta = listGimnasta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dorsal;
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (dorsal != other.dorsal)
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		return true;
	}

	@Override
	public String toString() {
	    return "Grupo:\n"
	         + " - Nombre del grupo: " + groupName + "\n"
	         + " - Dorsal: " + dorsal + "\n"
	         + " - Club: " + club + "\n";
	}

}

