package org.eclipse.papyrus.diagram.clazz.custom.policies.itemsemantic;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.command.ContainmentLinkReorientCommand;
import org.eclipse.papyrus.diagram.clazz.custom.helper.ContainmentHelper;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AddedLinkEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConnectorDurationObservationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConnectorTimeObservationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ElementImportEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageMergeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ProfileApplicationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.TemplateBindingEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.UsageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.policies.PackageItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;

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

	@Override
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		// TODO Auto-generated method stub
		return super.getDestroyReferenceCommand(req);
	}

	protected Command getDestroyElementCommandGen(DestroyElementRequest req) {
		View view = (View)getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);

		for(Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge)it.next();
			switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
			case CommentAnnotatedElementEditPart.VISUAL_ID:
			case ConstraintConstrainedElementEditPart.VISUAL_ID:
			case ConnectorTimeObservationEditPart.VISUAL_ID:
			case ConnectorDurationObservationEditPart.VISUAL_ID:
				DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(destroyRefReq));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				break;
			case RealizationEditPart.VISUAL_ID:
			case AbstractionEditPart.VISUAL_ID:
			case UsageEditPart.VISUAL_ID:
			case DependencyEditPart.VISUAL_ID:
			case DependencyBranchEditPart.VISUAL_ID:
			case ElementImportEditPart.VISUAL_ID:
			case PackageImportEditPart.VISUAL_ID:
			case PackageMergeEditPart.VISUAL_ID:
			case TemplateBindingEditPart.VISUAL_ID:
//			case AddedLinkEditPart.VISUAL_ID:
				DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(destroyEltReq));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				break;
			}
		}

		for(Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge)it.next();
			switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
			case RealizationEditPart.VISUAL_ID:
			case AbstractionEditPart.VISUAL_ID:
			case UsageEditPart.VISUAL_ID:
			case DependencyEditPart.VISUAL_ID:
			case DependencyBranchEditPart.VISUAL_ID:
			case ElementImportEditPart.VISUAL_ID:
			case PackageImportEditPart.VISUAL_ID:
			case PackageMergeEditPart.VISUAL_ID:
			case ProfileApplicationEditPart.VISUAL_ID:
			case TemplateBindingEditPart.VISUAL_ID:
//			case AddedLinkEditPart.VISUAL_ID:
				DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(destroyEltReq));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				break;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if(annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		
		ICommandProxy command = (ICommandProxy)getDestroyElementCommandGen(req);
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.add(command.getICommand());
		
		addDestroyIncomingContainmentLinksCommand(cmd);
		ContainmentHelper.addDeleteOutgoingContainmentLinkViewCommands(getEditingDomain(), (View)getHost().getModel(), cmd);
		return getGEFWrapper(cmd.reduce());
	}
	
	/**
	 * Adds the destroy incoming containment links command.
	 *
	 * @param cmd the cmd
	 */
	private void addDestroyIncomingContainmentLinksCommand(ICompositeCommand cmd) {
		View view = (View)getHost().getModel();
		for(Object next : view.getTargetEdges()) {
			Edge incomingLink = (Edge)next;
			if(ContainmentHelper.isContainmentLink(incomingLink)) {
				cmd.add(ContainmentHelper.deleteIncomingContainmentLinkCommand(getEditingDomain(), incomingLink));
			}
		}
	}

}
