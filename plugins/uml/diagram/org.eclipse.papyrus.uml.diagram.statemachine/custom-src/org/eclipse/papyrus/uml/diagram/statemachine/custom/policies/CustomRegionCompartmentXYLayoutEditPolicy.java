package org.eclipse.papyrus.uml.diagram.statemachine.custom.policies;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.commands.CustomStateResizeCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateEditPart;

public class CustomRegionCompartmentXYLayoutEditPolicy extends XYLayoutEditPolicy {

	/**
	 * This method analyzes a resize and/or move request and routes the call to
	 * the appropriate specific ResizeCommand either for a State
	 * in other cases passes on the call to the super class method.
	 * 
	 * @param child
	 *        the concerned EditPart
	 * @param constraint
	 *        the object embedding the constraint rectangle
	 * @param request
	 *        the ChangeBoundsRequest
	 * 
	 * @return
	 */
	@Override
	public Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
		// precautionary test
		if((request == null) || (child == null) || (constraint == null))
			throw new IllegalArgumentException();

		if(child instanceof StateEditPart) {
			View state = (View)child.getModel();

			// retrieve the deltas of the resize request
			int dx = request.getSizeDelta().width;
			int dy = request.getSizeDelta().height;
			if((dx == 0) && (dy == 0)) {
				// nothing to do except move the state edit part
				// all locations of embedded figures are relative to it
				// and thus hold when their container is moved around
				return super.createChangeConstraintCommand(request, child, constraint);
			}

			// now we face a resize command

			TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
			CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, DiagramUIMessages.AddCommand_Label);
			// a resize request, which we route to the specific ResizeCommand
			IAdaptable adaptableForState = new SemanticAdapter(null, state);

			CustomStateResizeCommand resizeStateMachine = new CustomStateResizeCommand(adaptableForState, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint(), editingDomain, DiagramUIMessages.CreateCommand_Label, request, (Rectangle)constraint, false);

			cc.add(resizeStateMachine);

			return new ICommandProxy(cc.reduce());
		}
		return super.createChangeConstraintCommand(request, child, constraint);
	}

	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		// specific resize edit policy which correct ghost figure management by
		// GMF
		if(child instanceof StateEditPart) {
			ResizableEditPolicy policy = new ResizableEditPolicy() {

				public void eraseSourceFeedback(Request request) {
					if(RequestConstants.REQ_DROP.equals(request.getType())) {
						eraseChangeBoundsFeedback((ChangeBoundsRequest)request);
					}
					else {
						super.eraseSourceFeedback(request);
					}
				}
				
				public void showSourceFeedback(Request request) {
					if(RequestConstants.REQ_DROP.equals(request.getType())) {
						// also show feedback in case of a drop request
						showChangeBoundsFeedback((ChangeBoundsRequest) request);
					}
					else {
						super.showSourceFeedback(request);
					}	
				}
			};
			return policy;
		}
		// all others, namely state machines and states, pseudostates, etc.
		// will have the generic policy which allows resize in all directions
		return super.createChildEditPolicy(child);
	}

	/**
	 * 
	 * {@inheritedDoc}
	 */
	public EditPart getTargetEditPart(Request request) {
		//this enables to make links when pointing inside a region
		if(request instanceof CreateUnspecifiedTypeConnectionRequest)
			return getHost().getParent().getParent().getParent();
		else
			return super.getTargetEditPart(request);
	}
}
