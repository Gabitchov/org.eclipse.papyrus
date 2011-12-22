package org.eclipse.papyrus.uml.properties.tabbedproperties.appearance;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.uml2.uml.NamedElement;

public class NodeNamedElementFilter implements IFilter {

	public boolean select(Object object) {
		if(object instanceof GraphicalEditPart
				&& ((GraphicalEditPart)object).getNotationView().getElement() instanceof NamedElement)
			return true;

		return false;
	}
}
