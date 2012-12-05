package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.uml.service.types.utils.InteractionConstraintUtil;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.UMLPackage;


public class LiteralIntegerEditHelper extends ElementEditHelper {

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#getSetCommand(org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest)
	 * 
	 * @param req
	 * @return
	 */

	@Override
	protected ICommand getSetCommand(SetRequest req) {
		LiteralInteger element = (LiteralInteger)req.getElementToEdit();
		EObject eContainer = element.eContainer();
		Object value = req.getValue();
		if(eContainer instanceof InteractionConstraint) {
			InteractionConstraint parent = (InteractionConstraint)eContainer;
			EStructuralFeature eContainingFeature = element.eContainingFeature();
			if(UMLPackage.eINSTANCE.getInteractionConstraint_Minint() == eContainingFeature) {
				Integer minintValue = InteractionConstraintUtil.getNonNegativeInteger(value);
				if(minintValue == null) {
					return UnexecutableCommand.INSTANCE;
				}
				Integer maxintValue = InteractionConstraintUtil.getMaxintValue(parent);
				if(maxintValue != null && maxintValue.intValue() < minintValue.intValue()) {
					return UnexecutableCommand.INSTANCE;
				}
			} else if(UMLPackage.eINSTANCE.getInteractionConstraint_Maxint() == eContainingFeature) {
				Integer maxintValue = InteractionConstraintUtil.getNonNegativeInteger(value);
				if(maxintValue == null || maxintValue.intValue() == 0) {
					return UnexecutableCommand.INSTANCE;
				}
				Integer minintValue = InteractionConstraintUtil.getMinintValue(parent);
				if(minintValue != null && maxintValue.intValue() < minintValue.intValue()) {
					return UnexecutableCommand.INSTANCE;
				}
			}
		}
		return super.getSetCommand(req);
	}
}
