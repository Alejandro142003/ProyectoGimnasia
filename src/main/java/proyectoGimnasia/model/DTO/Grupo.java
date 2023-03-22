package proyectoGimnasia.model.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grupo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String groupName;
	private String club;
	private List<Gimnasta> listGimnasta;

  
    public Grupo(String groupName, String club) {
    
		this.groupName = groupName;
		this.club = club;
		listGimnasta = new ArrayList<Gimnasta>();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public List<Gimnasta> getListGimnasta() {
		return listGimnasta;
	}

	public void setListGimnasta(List<Gimnasta> listGimnasta) {
		this.listGimnasta = listGimnasta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
	         + " - Club: " + club + "\n";
	}
}

