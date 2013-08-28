package org.eclipse.papyrus.uml.xtext.integration.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

/**
 * Creates an error if a model element has an annotation. If an annotation exist
 * the xtext string couldn't be parsed and is out of sync with the UML model.
 * 
 * 
 * @author Markus Mühlbrandt
 * 
 */
public class ExistsAnnotationConstraint extends AbstractModelConstraint {

	public static final String ANNOTATION_SOURCE = "expression_source";
	public static final String ANNOTATION_DETAIL = "expression";

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		String text = null;
		// In the case of batch mode.
		if (eType == EMFEventType.NULL) {
			if (eObj instanceof EModelElement) {
				EAnnotation eAnnotation = ((EModelElement) eObj)
						.getEAnnotation(ANNOTATION_SOURCE);
				if (eAnnotation != null) {
					text = eAnnotation.getDetails().get(ANNOTATION_DETAIL);
				}
			}

			if (text != null && !text.isEmpty()) {
				return ctx.createFailureStatus(eObj.eClass().getName());
			}
		}
		return ctx.createSuccessStatus();
	}

}
