package org.eclipse.papyrus.profile.utils;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;


public class UmlElementFilter implements IFilter {

	 public boolean select(Object object) {
	        if (object instanceof GraphicalEditPart && ((GraphicalEditPart)object).getNotationView().getElement() instanceof Element)
	            return true;

	        return false;
	    }

}
