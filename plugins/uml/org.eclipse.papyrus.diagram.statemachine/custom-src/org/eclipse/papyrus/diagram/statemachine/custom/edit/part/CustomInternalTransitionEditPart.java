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
 *   Arthur daussy (Atos) arthur.daussy@atos.net - Bug : 365405: [State Machine Diagram] Behaviours (Entry,exit,do) on states should have their own mechanisms
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.custom.edit.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.util.CommandUtil;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.InternalTransitionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.TransitionKind;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Customization of this edit part in order to handle InternalTransition mecanism
 * 
 * @see Bug : 365405: [State Machine Diagram] Behaviours (Entry,exit,do) on states should have their own mechanisms
 * @author adaussy
 * 
 */
public class CustomInternalTransitionEditPart extends InternalTransitionEditPart {

	public CustomInternalTransitionEditPart(View view) {
		super(view);
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		/*
		 * Handle Internal Transition mechanism
		 * If this transition become internal
		 * then this transition has change its representation InternalTansitionEditPart -> TransitionEditPart
		 */
		if(event instanceof Notification) {
			Notification notif = (Notification)event;
			Object feature = notif.getFeature();
			if(feature instanceof EStructuralFeature) {
				EStructuralFeature eStructuralFeature = (EStructuralFeature)feature;
				if(isCorrectKindStructuralfeature(eStructuralFeature)) {
					handleKindModification(event, eStructuralFeature);
				}
			}

		}
	}

	/**
	 * Return one of the following true is the event structural feature is UMLPackage.Literals.TRANSITION__KIND
	 * 
	 * @param eStructuralFeature
	 * @return
	 */
	private boolean isCorrectKindStructuralfeature(EStructuralFeature eStructuralFeature) {
		if(UMLPackage.Literals.TRANSITION__KIND.equals(eStructuralFeature)) {
			return true;
		}
		return false;
	}

	/**
	 * Handle modification on behavior attribute of state (entry , exit , do activity)
	 * 
	 * @param notif
	 * @param eStructuralFeature
	 */
	protected void handleKindModification(Notification notif, EStructuralFeature eStructuralFeature) {

		if(notif.getEventType() == Notification.SET) {
			Object object = notif.getNewValue();
			if(object instanceof TransitionKind) {
				TransitionKind kind = (TransitionKind)object;
				if(TransitionKind.INTERNAL_LITERAL != kind) {
					IGraphicalEditPart stateHost = getInternalTransitionStateHost();
					if(stateHost != null) {

//						//get the request to create the editPart
//						Command cmd1 = getInternalTransitionCreateCommand(resolveSemanticElement());
//						if(cmd1 != null && cmd1.canExecute()) {
//							CommandUtil.executeCommand(cmd1, stateHost);
//						}
//						//Get the request to delete the editPart
//						Command cmd2 = getTransitionDeleteCommand(this);
//						if(cmd2 != null && cmd2.canExecute()) {
//							CommandUtil.executeCommand(cmd2, stateHost);
//						}
//
//						//reset cache
//						internalTransitionstateHost_cached = null;
					}
				}

			}
		}
	}


	/**
	 * Get the command to delete this editPart
	 * 
	 * @param customTransitionEditPart
	 * @return
	 */
	protected Command getTransitionDeleteCommand(CustomTransitionEditPart customTransitionEditPart) {
		GroupRequest request;
		if(customTransitionEditPart instanceof CustomTransitionEditPart) {
			request = new GroupRequest(RequestConstants.REQ_DELETE);
			((GroupRequest)request).setEditParts(customTransitionEditPart);
			IGraphicalEditPart editPart = getInternalTransitionStateHost();
			if(editPart != null) {
				return editPart.getCommand(request);
			}
		}
		return null;
	}


	/**
	 * Return the command to display this transition as internal transition
	 * (or null if fail)
	 * 
	 * @param object
	 * @return
	 */
	protected Command getInternalTransitionCreateCommand(Object object) {
		if(object instanceof Transition) {
			IGraphicalEditPart stateEditPart = getInternalTransitionStateHost();
			if(stateEditPart != null) {
				DropObjectsRequest request = new DropObjectsRequest();
				request.setLocation(new Point(1, 1));
				request.setObjects(Collections.singletonList(object));
				Command cmd = stateEditPart.getCommand(request);
				return cmd;
			}
		}
		return null;
	}

	/**
	 * Get the edit part which would host this internal transition
	 * 
	 * @return
	 */
	protected StateEditPart getInternalTransitionStateHost() {
//		if(internalTransitionstateHost_cached == null) {
//			EditPart result = this.getTarget();
//			EditPart result2 = this.getSource();
//			if(result instanceof StateEditPart && result.equals(result2)) {
//				internalTransitionstateHost_cached = (StateEditPart)result;
//			}
//		}
//		return internalTransitionstateHost_cached;
		return null;
	}

	/**
	 * Get the corresponding part to the {@link Behavior} passed in argument
	 * 
	 * @param oldBehavior
	 * @return
	 */
	private List<IGraphicalEditPart> getChildBehaviorEditPart(Behavior oldBehavior) {
		Iterator<?> ite = this.getChildren().iterator();
		List<IGraphicalEditPart> result = new ArrayList<IGraphicalEditPart>();
		while(ite.hasNext()) {
			Object iEditPart = ite.next();
			if(iEditPart instanceof IGraphicalEditPart) {
				IGraphicalEditPart iGraphEditPart = (IGraphicalEditPart)iEditPart;
				EObject eObject = iGraphEditPart.resolveSemanticElement();
				if(eObject.equals(oldBehavior)) {
					result.add(iGraphEditPart);
				}
			}
		}
		return result;
	}



}
