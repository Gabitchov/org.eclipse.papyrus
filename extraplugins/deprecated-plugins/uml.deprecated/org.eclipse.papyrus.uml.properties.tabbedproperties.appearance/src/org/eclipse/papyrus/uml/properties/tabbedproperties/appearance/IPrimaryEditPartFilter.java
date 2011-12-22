package org.eclipse.papyrus.uml.properties.tabbedproperties.appearance;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.uml2.uml.NamedElement;

public class IPrimaryEditPartFilter implements IFilter {

	public boolean select(Object object) {
		if(object instanceof IPrimaryEditPart && !(object instanceof ConnectionEditPart))
			return true;

		return false;
	}
}
