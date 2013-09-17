package org.eclipse.papyrus.uml.xtext.integration.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.papyrus.uml.xtext.integration.InvalidStringUtil;
import org.eclipse.uml2.uml.Element;

/**
 * Creates an error if a model element has an annotation. If an annotation exist
 * the xtext string couldn't be parsed and is out of sync with the UML model.
 * 
 * 
 * @author Markus Mühlbrandt
 * 
 */
public class ExistsAnnotationConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		String text = null;
		// In the case of batch mode.
		if (eType == EMFEventType.NULL) {
			if (eObj instanceof Element) {
				Element element = (Element) eObj;
				text = InvalidStringUtil.getTextualRepresentation(element);
			}

			if (text != null && !"".equals(text)) {
				return ctx.createFailureStatus(eObj.eClass().getName());
			}
		}
		return ctx.createSuccessStatus();
	}

}
