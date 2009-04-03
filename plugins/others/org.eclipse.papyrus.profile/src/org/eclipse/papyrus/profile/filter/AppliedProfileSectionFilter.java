package org.eclipse.papyrus.profile.filter;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.filters.ShapeEditPartPropertySectionFilter;

public class AppliedProfileSectionFilter extends ShapeEditPartPropertySectionFilter {

	public boolean select(Object object) {
		if (object instanceof ShapeEditPart) {
			if (((ShapeEditPart) object).resolveSemanticElement() != null && ((ShapeEditPart) object).resolveSemanticElement() instanceof org.eclipse.uml2.uml.Package) {
				return true;
			}
		}

		return false;
	}
}
