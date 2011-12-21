/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.listeners;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.diagram.activity.edit.part.interfaces.InterruptibleEdge;
import org.eclipse.papyrus.diagram.activity.request.InterruptibleEdgeRequest;
import org.eclipse.papyrus.diagram.common.listeners.AbstractModifcationTriggerListener;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This listener handle Interruptible Edge
 * 
 * @author arthur daussy
 * 
 */
public class InterruptibleEdgeListener extends AbstractModifcationTriggerListener<ActivityEdge> {

	@Override
	protected boolean isCorrectStructuralfeature(EStructuralFeature eStructuralFeature) {
		if(UMLPackage.Literals.ACTIVITY_EDGE__INTERRUPTS.equals(eStructuralFeature)) {
			return true;
		}
		return false;
	}

	@Override
	protected ICommand getModificationCommand(Notification notif,TransactionalEditingDomain domain) {
		if(Notification.SET == notif.getEventType()) {
			IGraphicalEditPart edgeEditPart = getChildByEObject((EObject)notif.getNotifier(), getDiagramEditPart(), true);
			if(edgeEditPart != null && edgeEditPart instanceof InterruptibleEdge) {
				InterruptibleEdgeRequest request = new InterruptibleEdgeRequest();
				if(notif.getNewValue() != null) {
					request.setType(InterruptibleEdgeRequest.SET_INTERRUPTIBLE_EDGE);
				} else {
					request.setType(InterruptibleEdgeRequest.UNSET_INTERRUPTIBLE_EDGE);
				}
				Command command = edgeEditPart.getCommand(request);
				if(command != null && command.canExecute()) {
					return new CommandProxy(command);
				}
			}
		}
		return null;
	}

	@Override
	protected ActivityEdge getElement(Notification notif) {
		Object element = notif.getNotifier();
		if(element instanceof ActivityEdge) {
			return (ActivityEdge)element;
		}
		return null;
	}
}
