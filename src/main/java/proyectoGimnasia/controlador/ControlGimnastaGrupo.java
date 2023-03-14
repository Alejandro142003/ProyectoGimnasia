package proyectoGimnasia.controlador;

import proyectoGimnasia.interfaces.iControllerGimnastaGrupo;

public class ControlGimnastaGrupo implements iControllerGimnastaGrupo{
	
	private ControlPrincipal parent;
	public ControlGimnastaGrupo(ControlPrincipal parent) {
		this.parent = parent;
	}
}
