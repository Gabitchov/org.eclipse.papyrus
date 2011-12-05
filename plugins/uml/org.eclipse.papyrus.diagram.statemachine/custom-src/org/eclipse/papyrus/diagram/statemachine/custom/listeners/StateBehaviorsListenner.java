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
 * 
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.custom.listeners;

import java.util.Collections;
import java.util.NoSuchElementException;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.util.EditPartUtilities;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;


/**
 * This listener will handle the creation of visual for element for behavior (/do /entry /exit).
 * @author Arthur Daussy
 *
 */
public class StateBehaviorsListenner extends TriggerListener {

	@Override
	protected Command trigger(TransactionalEditingDomain domain, Notification notification) {
		if(notification != null) {
			Object feature = notification.getFeature();
			if(feature instanceof EStructuralFeature) {
				EStructuralFeature eStructuralFeature = (EStructuralFeature)feature;
				if(getCorrectBehaviorStructuralfeature(eStructuralFeature) != null) {
					CompositeCommand cc = getBehaviorModificationCommand(notification, eStructuralFeature);
					return new GMFtoEMFCommandWrapper(cc);
				}
			}
		}
		return null;
	}

	/**
	 * Return one of the following {@link EStructuralFeature} (UMLPackage.Literals.STATE__DO_ACTIVITY.equals(eStructuralFeature) ||
	 * UMLPackage.Literals.STATE__EXIT.equals(eStructuralFeature) || UMLPackage.Literals.STATE__ENTRY.equals(eStructuralFeature))or null if the
	 * {@link EStructuralFeature} in argument do concern behaviors
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
	protected CompositeCommand getBehaviorModificationCommand(Notification notif, EStructuralFeature eStructuralFeature) {
		Request createRequest = null;
		Request deleteRequest = null;
		if(notif.getEventType() == Notification.SET) {
			Object object = notif.getNewValue();

			Object oldObject = notif.getOldValue();
			StateEditPart stateEditPart = getContainingEditPart(notif.getNotifier());
			if(object instanceof Behavior) {
				//Get the request to create the editPart
				createRequest = getCreateRequest(object, stateEditPart);
			}
			//Get the request to delete the editPart
			deleteRequest = getDeleteRequest(oldObject, stateEditPart);
			//handle both request if needed
			CompositeCommand cc = new CompositeCommand("blabla");
			org.eclipse.gef.commands.Command cmd1 = getCommandFromRequest(createRequest, stateEditPart);
			if(cmd1 != null && cmd1.canExecute()) {
				cc.compose(new CommandProxy(cmd1));
			}
			org.eclipse.gef.commands.Command cmd2 = getCommandFromRequest(deleteRequest, stateEditPart);
			if(cmd2 != null && cmd2.canExecute()) {
				cc.compose(new CommandProxy(cmd2));
			}
			return cc;
		}
		return null;
	}

	/**
	 * Handle the request passed in argument
	 * 1. Look for the command
	 * 2. Execute the command
	 * 
	 * @param request
	 */
	protected org.eclipse.gef.commands.Command getCommandFromRequest(Request request, IGraphicalEditPart editPart) {
		if(request != null) {
			return editPart.getCommand(request);
		}
		return null;
	}

	/**
	 * Get the request to delete the EditPart of corresponding behavior
	 * 
	 * @param notif
	 * @param request
	 *        (
	 * @return
	 */
	private Request getDeleteRequest(Object oldObject, StateEditPart stateEditPart) {
		Request request = null;
		//When unset the feature
		if(oldObject instanceof Behavior) {
			Behavior oldBehavior = (Behavior)oldObject;
			IGraphicalEditPart iGrapEditPart = getChildByEObject(oldBehavior, stateEditPart);
			if(iGrapEditPart != null) {
				request = new GroupRequest(RequestConstants.REQ_DELETE);
				((GroupRequest)request).setEditParts(iGrapEditPart);
			}
		}
		return request;
	}

	private Request getCreateRequest(Object object, StateEditPart stateEditPart) {
		Request request;
		Behavior behavior = (Behavior)object;
		request = new DropObjectsRequest();
		Point dropLocation = getTranslatedLocation(stateEditPart.getPrimaryShape().getInformationLabel().getLocation(), stateEditPart);
		((DropObjectsRequest)request).setLocation(new Point(1, 1));
		((DropObjectsRequest)request).setObjects(Collections.singletonList(behavior));
		return request;
	}

	protected Point getTranslatedLocation(Point location, StateEditPart stateEditPart) {
		((GraphicalEditPart)stateEditPart).getContentPane().translateToRelative(location);
		((GraphicalEditPart)stateEditPart).getContentPane().translateFromParent(location);
		location.translate(((GraphicalEditPart)stateEditPart).getContentPane().getClientArea().getLocation().getNegated());
		return location;
	}


	/**
	 * Get the containing edit part (stateEditPart)
	 * 
	 * @param oldBehavior
	 * @return
	 */
	protected StateEditPart getContainingEditPart(Object toTest) {
		//If not EObject found return null;
		if(toTest == null && toTest instanceof EObject) {
			return null;
		}

		IGraphicalEditPart found = getChildByEObject((EObject)toTest, getDiagramEditPart());
		if(found instanceof StateEditPart) {
			return (StateEditPart)found;
		}
		return null;
	}


	/**
	 * Return the main edipart which correspond to the {@link EObject}
	 * 
	 * @param eObject
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected IGraphicalEditPart getChildByEObject(final EObject eObject, IGraphicalEditPart editPart) {
		if(eObject != null && editPart != null) {
			try {
				EditPart find = Iterables.find((Iterable<EditPart>)EditPartUtilities.getAllChildren(editPart), new Predicate<EditPart>() {

					public boolean apply(EditPart input) {
						if(input instanceof IGraphicalEditPart) {
							IGraphicalEditPart current = (IGraphicalEditPart)input;
							//Same EObject
							if(eObject.equals(current.resolveSemanticElement())) {
								EditPart parent = current.getParent();
								if(parent instanceof IGraphicalEditPart) {
									// its parent do not have the same EObject
									if(!eObject.equals(((IGraphicalEditPart)parent).resolveSemanticElement())) {
										return true;
									}
								}
							}
						}
						return false;
					}
				});
				return (IGraphicalEditPart)find;
			} catch (NoSuchElementException e) {
				//Nothing to do
			}

		}
		return null;
	}

	/**
	 * get the edit part registry
	 * 
	 * @return
	 */
	protected DiagramEditPart getDiagramEditPart() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchPage page = wb.getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = page.getActiveEditor();
		if(editor instanceof PapyrusMultiDiagramEditor) {
			PapyrusMultiDiagramEditor papyrusEditor = (PapyrusMultiDiagramEditor)editor;
			return papyrusEditor.getDiagramEditPart();
		}
		return null;
	}


}
