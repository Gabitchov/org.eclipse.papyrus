/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.ElementToStereotypedShape;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ChangeStereotypedShapeEditPolicy;
import org.eclipse.swt.widgets.Display;

/**
 * the goal of this class is to allow changing the aspect of an element by taking in account its stereotype
 * 
 */
public class ClazzDiagramChangeStereotypedShapeEditpolicy extends ChangeStereotypedShapeEditPolicy {

	@Override
	public void transformIntoShape(final EditPart part) {
		try {
			((IGraphicalEditPart)getHost()).getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							if(part instanceof GraphicalEditPart) {
								GraphicalEditPart gmfpart = (GraphicalEditPart)part;
								ElementToStereotypedShape command = new ElementToStereotypedShape(gmfpart.getEditingDomain(), gmfpart);
								gmfpart.getEditingDomain().getCommandStack().execute(command);
								Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
								Command deleteCommand = gmfpart.getCommand(deleteViewRequest);
								gmfpart.getDiagramEditDomain().getDiagramCommandStack().execute(deleteCommand);
							}
						}
					});
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void transformIntoNormalShape(final EditPart part) {
		try {
			((IGraphicalEditPart)getHost()).getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							if(part instanceof GraphicalEditPart) {
								GraphicalEditPart gmfpart = (GraphicalEditPart)part;
								DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
								ArrayList<EObject> list = new ArrayList<EObject>();
								list.add(gmfpart.resolveSemanticElement());
								dropObjectsRequest.setObjects(list);
								dropObjectsRequest.setLocation(gmfpart.getFigure().getBounds().getLocation());
								Command command = gmfpart.getParent().getCommand(dropObjectsRequest);
								gmfpart.getEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
								Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
								Command deleteCommand = gmfpart.getCommand(deleteViewRequest);
								gmfpart.getDiagramEditDomain().getDiagramCommandStack().execute(deleteCommand);
							}
						}
					});
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
