package org.eclipse.papyrus.diagram.sequence.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.sequence.edit.parts.ElementOwnedCommentEditPart;

/**
 * @generated
 */
public class ElementOwnedCommentItemSemanticEditPolicy extends
		UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated NOT
	 */
	@Override
	public Command getCommand(Request request) {
		if (request instanceof GroupRequest
				&& RequestConstants.REQ_DELETE.equals(request.getType())) {
			ElementOwnedCommentEditPart ep = (ElementOwnedCommentEditPart) getHost();
			DestroyReferenceRequest drr = new DestroyReferenceRequest(
					((View) ep.getSource().getModel()).getElement(),
					UMLPackage.eINSTANCE.getElement_OwnedComment(), ((View) ep
							.getTarget().getModel()).getElement(), false);
			return getDestroyReferenceCommand(drr);
		}
		return super.getCommand(request);
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		EObject eObject = org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil
				.getDiagramEditPart(
						((ElementOwnedCommentEditPart) this.getHost())
								.getTarget()).resolveSemanticElement();

		SetRequest sr = new SetRequest(eObject, UMLPackage.eINSTANCE
				.getElement_OwnedComment(), req.getReferencedObject());
		return new ICommandProxy(new SetValueCommand(sr));
	}

}
