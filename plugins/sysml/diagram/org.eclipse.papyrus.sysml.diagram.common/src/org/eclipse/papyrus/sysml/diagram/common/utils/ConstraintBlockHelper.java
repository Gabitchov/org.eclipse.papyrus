package org.eclipse.papyrus.sysml.diagram.common.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.helper.ElementHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

public class ConstraintBlockHelper extends ElementHelper {

	public static boolean couldBeConstraintParameter(EObject possibleContraintParameter, EObject ownerConstraintBlock) {
		if (!(ownerConstraintBlock instanceof org.eclipse.uml2.uml.Class && UMLUtil.getStereotypeApplication((Element)ownerConstraintBlock, ConstraintBlock.class) != null)) {
			return false;
		}
		return !(((ISpecializationType)SysMLElementTypes.PART_PROPERTY).getMatcher().matches(possibleContraintParameter) ||
					((ISpecializationType)SysMLElementTypes.REFERENCE_PROPERTY).getMatcher().matches(possibleContraintParameter) ||
					possibleContraintParameter instanceof Port);
	}
	
	public static boolean isConstraintParameter(Element element, View view) {
		if (element instanceof Property) {
			Property constraintProperty = (Property) element;
			Element ownerConstraintBlock = constraintProperty.getOwner();
			if (ownerConstraintBlock instanceof org.eclipse.uml2.uml.Class && UMLUtil.getStereotypeApplication(ownerConstraintBlock, ConstraintBlock.class) != null) {
				// check for graphics : owned by a constraintProperty
				if (view != null) {
					View containerView = ViewUtil.getContainerView(view);
					Element containerElement = (Element)containerView.getElement();
					// Owned by a ConstraintProperty
					if (containerElement instanceof Property 
							&& UMLUtil.getStereotypeApplication(containerElement, ConstraintProperty.class) != null 
							&& ((Property)containerElement).getType() == ownerConstraintBlock) { 
						return true;
					}
					// Owned by a ConstraintBlock
					if (containerElement instanceof org.eclipse.uml2.uml.Class 
							&& UMLUtil.getStereotypeApplication(containerElement, ConstraintBlock.class) != null 
							&& containerElement == ownerConstraintBlock) { 
						return true;
					}
				}
			}
		}
		return false;
	}
	
}
