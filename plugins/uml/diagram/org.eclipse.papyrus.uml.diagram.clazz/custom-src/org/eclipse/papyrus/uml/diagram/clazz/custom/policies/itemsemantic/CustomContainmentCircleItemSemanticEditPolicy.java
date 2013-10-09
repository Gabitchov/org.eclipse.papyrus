/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Fadoi LAKHAL  Fadoi.Lakhal@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.popups.PopupNotification;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CustomReorientContainmentLinkCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part.CContainmentCircleEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.ContainmentHelper;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConnectorDurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConnectorTimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.TemplateBindingEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.swt.SWT;
import org.eclipse.uml2.uml.NamedElement;

public class CustomContainmentCircleItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	public CustomContainmentCircleItemSemanticEditPolicy() {
		super(UMLElementTypes.Node_3032);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the destroy element command gen.
	 * 
	 * @param req
	 *        the req
	 * @return the destroy element command gen
	 */
	protected Command getDestroyElementCommandGen(DestroyElementRequest req) {
		// copy of super.getDestroyElementCommand() 
		// with commented case of AddedLinkAddedPart wihich causes NPE
		View view = (View)getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for(Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge)it.next();
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == RealizationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == AbstractionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == UsageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == DependencyEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == DependencyBranchEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == CommentAnnotatedElementEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == ConstraintConstrainedElementEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == TemplateBindingEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			/**
			 * if(UMLVisualIDRegistry.getVisualID(incomingLink) == AddedLinkEditPart.VISUAL_ID) {
			 * DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
			 * cmd.add(new DestroyElementCommand(r));
			 * cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
			 * continue;
			 * }
			 **/
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == ConnectorTimeObservationEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == ConnectorDurationObservationEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for(Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge)it.next();
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == RealizationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == AbstractionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == UsageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == DependencyEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == DependencyBranchEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			/**
			 * if(UMLVisualIDRegistry.getVisualID(outgoingLink) == AddedLinkEditPart.VISUAL_ID) {
			 * DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
			 * cmd.add(new DestroyElementCommand(r));
			 * cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
			 * continue;
			 * }
			 **/
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if(annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			/**
			 * cmd.add(new DestroyElementCommand(req));
			 **/
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		View circle = (View)getHost().getModel();
		List<String> targetNames = new ArrayList<String>();
		for(Object next : circle.getSourceEdges()) {
			Edge outgoingLink = (Edge)next;
			if(ContainmentHelper.isContainmentLink(outgoingLink)) {
				targetNames.add(((NamedElement)outgoingLink.getTarget().getElement()).getName());
			}
		}
		cmd.add(new AskToDeleteContainmentCommand(targetNames));
		ICommandProxy command = (ICommandProxy)getDestroyElementCommandGen(req);
		cmd.add(command.getICommand());
		for(Object next : circle.getSourceEdges()) {
			Edge outgoingLink = (Edge)next;
			if(ContainmentHelper.isContainmentLink(outgoingLink)) {
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				//delete target view as it actually contained by the source object and will be deleted 
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink.getTarget()));
				// Important! Here we remove target
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(outgoingLink.getTarget().getElement(), true)));
				ContainmentHelper.addDeleteOutgoingContainmentLinkViewCommands(getEditingDomain(), outgoingLink.getTarget(), cmd);
			}
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public Command getCommand(Request request) {
		if(request instanceof ReconnectRequest) {
			if(((ReconnectRequest)request).getTarget() instanceof CContainmentCircleEditPart) {
				return getCustomReconnectRequest((ReconnectRequest)request);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * 
	 * use the AbstractTransactionalCommand "CustomReorientLinkCommand" to change the owner of the target class
	 */
	public Command getCustomReconnectRequest(ReconnectRequest request) {
		CompoundCommand cc = new CompoundCommand();
		cc.add(new ICommandProxy(new CustomReorientContainmentLinkCommand(getEditingDomain(), request)));
		return cc;
	}

	public static class AskToDeleteContainmentCommand extends AbstractOperation {

		private List<String> myTargetNames;

		public AskToDeleteContainmentCommand(List<String> targetNames) {
			super("Show Question Dialog");
			myTargetNames = targetNames;
		}

		@Override
		public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			String messageFormat = "You are about to delete a Containment Link - %s and its contained elements will be deleted as well. Are you sure you want to delete it?";
			String message = String.format(messageFormat, getNamesString());
			NotificationBuilder builder = NotificationBuilder.createYesNo(message);
			int dialogResult = ((PopupNotification)builder.run()).getResult();
			if(dialogResult == SWT.YES) {
				return Status.OK_STATUS;
			}
			return Status.CANCEL_STATUS;
		}

		private String getNamesString() {
			String namesString = "";
			Iterator<String> namesIterator = myTargetNames.iterator();
			while(namesIterator.hasNext()) {
				namesString += "'" + namesIterator.next() + "'";
				if(namesIterator.hasNext()) {
					namesString += ", ";
				}
			}
			return namesString;
		}

		@Override
		public IStatus redo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			return Status.OK_STATUS;
		}

		@Override
		public IStatus undo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			return Status.OK_STATUS;
		}
	}
}
