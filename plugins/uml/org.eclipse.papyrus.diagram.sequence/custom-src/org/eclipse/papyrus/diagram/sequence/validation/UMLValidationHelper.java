package org.eclipse.papyrus.diagram.sequence.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.papyrus.diagram.sequence.part.Messages;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionOperand;

/**
 * This helper performs non generated validation tasks.
 * 
 * @author vhemery
 */
public class UMLValidationHelper {

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
			return keeper.validate(ctx);
		} catch (Exception e) {
			UMLDiagramEditorPlugin.getInstance().logError(Messages.FragmentOrderingKeeper_error, e);
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
			return keeper.validate(ctx);
		} catch (Exception e) {
			UMLDiagramEditorPlugin.getInstance().logError(Messages.FragmentOrderingKeeper_error, e);
			// avoid returning the exception, or the constraint will never be called again.
			return ctx.createSuccessStatus();
		}
	}

}
