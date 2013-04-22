package org.eclipse.papyrus.uml.diagram.sequence.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.CustomMessages;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;

/**
 * This helper performs non generated validation tasks.
 * 
 * @author vhemery
 */
public class UMLValidationHelper {

	/**
	 * Validate modification and update the interaction operand's or interaction's fragments order if necessary.
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 * 
	 * @param context
	 *        object on which update is performed
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	public static IStatus validateFragmentsOrder(EObject context, IValidationContext ctx) {
		if(context instanceof View) {
			return validateFragmentsOrder(((View)context).getElement(), ctx);
		} else if(context instanceof Bounds) {
			return validateFragmentsOrder(((Bounds)context).eContainer(), ctx);
		} else if(context instanceof Interaction) {
			return validateFragmentsOrder((Interaction)context, ctx);
		} else if(context instanceof InteractionOperand) {
			return validateFragmentsOrder((InteractionOperand)context, ctx);
		} else if(context instanceof InteractionFragment) {
			return validateFragmentsOrder(((InteractionFragment)context).getOwner(), ctx);
		} else if(context instanceof Message) {
			// both events are in the same container, but they may not exist
			MessageEnd sendEvent = ((Message)context).getSendEvent();
			EObject sendFragmentContainer = sendEvent != null ? sendEvent.eContainer() : null;
			MessageEnd receiveEvent = ((Message)context).getReceiveEvent();
			EObject receiveFragmentContainer = receiveEvent != null ? receiveEvent.eContainer() : null;
			if(sendFragmentContainer != null) {
				return validateFragmentsOrder(sendFragmentContainer, ctx);
			} else if(receiveFragmentContainer != null) {
				return validateFragmentsOrder(receiveFragmentContainer, ctx);
			}
		} else if(context instanceof Lifeline) {
			// events may have changed of container while lifeline was moving
			return validateFragmentsOrder(((Lifeline)context).getInteraction(), ctx);
		}
		// no implementation for this element
		return ctx.createSuccessStatus();
	}

	/**
	 * Validate modification and update the interaction's fragments order if necessary.
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 * 
	 * @param context
	 *        element on which update is performed
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	public static IStatus validateFragmentsOrder(Interaction context, IValidationContext ctx) {
		try {
			FragmentOrderingKeeper keeper = new FragmentOrderingKeeper();
			return keeper.validate(context, ctx);
		} catch (Exception e) {
			UMLDiagramEditorPlugin.getInstance().logError(CustomMessages.FragmentOrderingKeeper_error, e);
			// avoid returning the exception, or the constraint will never be called again.
			return ctx.createSuccessStatus();
		}
	}

	/**
	 * Validate modification and update the interaction operand's fragments order if necessary.
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 * 
	 * @param context
	 *        element on which update is performed
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	public static IStatus validateFragmentsOrder(InteractionOperand context, IValidationContext ctx) {
		try {
			FragmentOrderingKeeper keeper = new FragmentOrderingKeeper();
			return keeper.validate(context, ctx);
		} catch (Exception e) {
			UMLDiagramEditorPlugin.getInstance().logError(CustomMessages.FragmentOrderingKeeper_error, e);
			// avoid returning the exception, or the constraint will never be called again.
			return ctx.createSuccessStatus();
		}
	}
}
