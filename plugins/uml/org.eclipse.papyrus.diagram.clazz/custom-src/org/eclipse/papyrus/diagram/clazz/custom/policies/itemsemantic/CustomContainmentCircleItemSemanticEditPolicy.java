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
package org.eclipse.papyrus.diagram.clazz.custom.policies.itemsemantic;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.Shape;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.papyrus.diagram.clazz.custom.command.ContainmentLinkReorientCommand;
import org.eclipse.papyrus.diagram.clazz.custom.command.CustomOwnerClassChangeCommand;
import org.eclipse.papyrus.diagram.clazz.custom.command.CustomReorientContainmentLinkCommand;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AddedLinkEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.policies.ContainmentCircleItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.internal.impl.ConnectorImpl;


public class CustomContainmentCircleItemSemanticEditPolicy extends ContainmentCircleItemSemanticEditPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View)getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for(Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge)it.next();
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == AddedLinkEditPart.VISUAL_ID) {
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				Shape containmentCircle = (Shape)incomingLink.getSource();
				if(((View)containmentCircle).getSourceEdges().size() == 1) {
					cmd.add(new DeleteCommand(getEditingDomain(), (View)containmentCircle));
				}
				continue;
			}
		}
		for(Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge)it.next();
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == AddedLinkEditPart.VISUAL_ID) {
				PackageableElement containedclassifier = (PackageableElement)outgoingLink.getTarget().getElement();
				cmd.add(new CustomOwnerClassChangeCommand(getEditingDomain(), containedclassifier));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		return getGEFWrapper(cmd.reduce());

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
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



	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch(getVisualID(req)) {
		case AddedLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new ContainmentLinkReorientCommand(req, getHost()));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
