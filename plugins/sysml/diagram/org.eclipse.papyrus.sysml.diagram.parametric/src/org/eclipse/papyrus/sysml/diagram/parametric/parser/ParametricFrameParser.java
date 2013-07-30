package org.eclipse.papyrus.sysml.diagram.parametric.parser;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.uml.diagram.common.parser.NamedElementLabelParser;
import org.eclipse.uml2.uml.util.UMLUtil;

public class ParametricFrameParser extends NamedElementLabelParser {

	@Override
	public String getPrintString(IAdaptable element, int flags) {
		String elementType = null;
		if (element instanceof EObjectAdapter) {
			Object realObject = ((EObjectAdapter)element).getRealObject();
			if (realObject instanceof org.eclipse.uml2.uml.Class) {
				elementType = UMLUtil.getStereotypeApplication(((org.eclipse.uml2.uml.Class)realObject), ConstraintBlock.class) != null ? "ConstraintBlock" : "Block";
			}
		}
		return "par [" + elementType + "] " + super.getPrintString(element, flags);
	}
}
