package org.eclipse.papyrus.diagram.clazz.custom.policies.itemsemantic;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.command.ContainmentLinkReorientCommand;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.custom.helper.ContainmentHelper;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AddedLinkEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.policies.PackageItemSemanticEditPolicy;

public class CustomPackageItemSemanticEditPolicy extends PackageItemSemanticEditPolicy {

	/**
	 * /*
	 * * {@inheritDoc}
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch(getVisualID(req)) {
		case AddedLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new ContainmentLinkReorientCommand(req, getHost()));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy#getReorientRefRelationshipTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected Command getReorientRefRelationshipTargetCommand(ReconnectRequest request) {
		if(ContainmentHelper.isReorientContainmentLink(request)) {
			request = ContainmentHelper.extendReorientTargetRequest(request);
		}
		return super.getReorientRefRelationshipTargetCommand(request);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy#getReorientRefRelationshipSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected Command getReorientRefRelationshipSourceCommand(ReconnectRequest request) {
		if(ContainmentHelper.isReorientContainmentLink(request)) {
			request = ContainmentHelper.extendReorientSourceRequest(request);
		}
		return super.getReorientRefRelationshipSourceCommand(request);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View)getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for(Object child: view.getVisibleChildren()) {
			View childView = (View)child;
			if (ContainmentHelper.isContainmentCircle(childView)) {
				for (Object next: childView.getSourceEdges()) {
					Edge outgoingLink = (Edge)next;
					if(ContainmentHelper.isContainmentLink(outgoingLink)) {
						cmd.add(ContainmentHelper.deleteOutgoingContainmentLinkCommand(getEditingDomain(), outgoingLink));
					}
				}
			}
		}
		for(Object next: view.getTargetEdges()) {
			Edge incomingLink = (Edge)next;
			if(ContainmentHelper.isContainmentLink(incomingLink)) {
				cmd.add(ContainmentHelper.deleteIncomingContainmentLinkCommand(getEditingDomain(), incomingLink));
			}
		}

		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if(annotation == null) {
			addDestroyShortcutsCommand(cmd, view);
			List<EditPart> editParts = getHost().getChildren();
			Iterator<EditPart> editPartIterator = editParts.iterator();
			while(editPartIterator.hasNext()) {
				EditPart currentEditPart = editPartIterator.next();
				if(currentEditPart instanceof CContainmentCircleEditPart) {
					List<AddedLinkEditPart> links = ((CContainmentCircleEditPart)currentEditPart).getSourceConnections();
					Iterator<AddedLinkEditPart> nestedPackageIterator = links.iterator();
					while(nestedPackageIterator.hasNext()) {
						AddedLinkEditPart currentNestedPackage = nestedPackageIterator.next();
						if((currentNestedPackage.getTarget() instanceof ClassEditPart)) {
							cmd.add(new DeleteCommand(getEditingDomain(), (View)currentNestedPackage.getTarget().getModel()));
						}
					}

				}
			}

			cmd.add(new DestroyElementCommand(req));

		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}
}
