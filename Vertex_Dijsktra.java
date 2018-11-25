package dijkstra_package;
/**
*
* @author EduardBalasa
* 
*/
public class Vertex_Dijsktra {
	final private String id;
	final private int name;

	public Vertex_Dijsktra(String id, int name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public int getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Vertex_Dijsktra other = (Vertex_Dijsktra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(name);
	}

}