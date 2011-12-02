/*****************************************************************************
 * Copyright (c) 2010-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Arthur daussy (Atos) arthur.daussy@atos.net - Bug : 365405: [State Machine Diagram] Behaviours (Entry,exit,do) on states should have their own mechanisms
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
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.util.CommandUtil;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.UMLPackage;

public class CustomStateEditPart extends StateEditPart {

	public CustomStateEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		// TODO Auto-generated method stub
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);

	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		/*
		 * handle creation and removal of entry / do / exit behavior
		 */
		if(event instanceof Notification) {
			Notification notif = (Notification)event;
			Object feature = notif.getFeature();
			if(feature instanceof EStructuralFeature) {
				EStructuralFeature eStructuralFeature = (EStructuralFeature)feature;
				if(getCorrectBehaviorStructuralfeature(eStructuralFeature) != null) {
					handleBehaviorModification(event, eStructuralFeature);
				}
			}
			// Layout figure after all modification
			getPrimaryShape().getLayoutManager().layout(getPrimaryShape());
		}
	}

	/**
	 * Return one of the following {@link EStructuralFeature} (UMLPackage.Literals.STATE__DO_ACTIVITY.equals(eStructuralFeature) ||
	 * UMLPackage.Literals.STATE__EXIT.equals(eStructuralFeature) || UMLPackage.Literals.STATE__ENTRY.equals(eStructuralFeature))or null if the
	 * {@link EStructuralFeature} in argument do concerne behaviors
	 * 
	 * @param eStructuralFeature
	 * @return
	 */
	private EStructuralFeature getCorrectBehaviorStructuralfeature(EStructuralFeature eStructuralFeature) {
		if(UMLPackage.Literals.STATE__DO_ACTIVITY.equals(eStructuralFeature)) {
			return UMLPackage.Literals.STATE__DO_ACTIVITY;
		} else if(UMLPackage.Literals.STATE__EXIT.equals(eStructuralFeature)) {
			return UMLPackage.Literals.STATE__EXIT;
		} else if(UMLPackage.Literals.STATE__ENTRY.equals(eStructuralFeature)) {
			return UMLPackage.Literals.STATE__ENTRY;
		}
		return null;
	}

	/**
	 * Handle modification on behavior attribute of state (entry , exit , do activity)
	 * 
	 * @param notif
	 * @param eStructuralFeature
	 */
	protected void handleBehaviorModification(Notification notif, EStructuralFeature eStructuralFeature) {
		Request createRequest = null;
		Request deleteRequest = null;
		if(notif.getEventType() == Notification.SET) {
			Object object = notif.getNewValue();
			Object oldObject = notif.getOldValue();
			if(object instanceof Behavior) {
				//Get the request to create the editPart
				createRequest = getCreateRequest(object);
			}
			//Get the request to delete the editPart
			deleteRequest = getDeleteRequest(oldObject);
			//handle both request if needed
			handleRequest(createRequest);
			handleRequest(deleteRequest);
		}
	}

	/**
	 * Handle the request passed in arguement
	 * 1. Look for the command
	 * 2. Execute the command
	 * 
	 * @param request
	 */
	protected void handleRequest(Request request) {
		//Run the request if any
		if(request != null) {
			final Command cmd = this.getCommand(request);
			if(cmd != null && cmd.canExecute()) {
				CommandUtil.executeCommand(cmd, this);

			}
		}
	}

	/**
	 * Get the request to delete the EditPart of corresponding behavior
	 * 
	 * @param notif
	 * @param request
	 *        (
	 * @return
	 */
	private Request getDeleteRequest(Object oldObject) {
		Request request = null;
		//When unset the feature
		if(oldObject instanceof Behavior) {
			Behavior oldBehavior = (Behavior)oldObject;
			List<IGraphicalEditPart> iGrapEditParts = getChildBehaviorEditPart(oldBehavior);
			if(!iGrapEditParts.isEmpty()) {
				request = new GroupRequest(RequestConstants.REQ_DELETE);
				((GroupRequest)request).setEditParts(iGrapEditParts);
			}
		}
		return request;
	}

	private Request getCreateRequest(Object object) {
		Request request;
		Behavior behavior = (Behavior)object;
		request = new DropObjectsRequest();
		((DropObjectsRequest)request).setLocation(new Point(1, 1));
		((DropObjectsRequest)request).setObjects(Collections.singletonList(behavior));
		return request;
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
