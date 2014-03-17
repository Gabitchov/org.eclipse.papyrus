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
 *  
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ViewComponentEditPolicy;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part.CContainmentCircleEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ContainmentCircleEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ContainmentSubLinkEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.PackageableElement;

public class CustomViewComponentEditPolicy extends ViewComponentEditPolicy {

	public Command getCommand(Request request) {
		if (REQ_ORPHAN.equals(request.getType()))
			return getOrphanCommand();
		if (REQ_DELETE.equals(request.getType())) {
			return getDeleteCommand((GroupRequest) request);
		}
		return null;
	}

	/**
	 * Return a command to delete the host's view. The host's primary view is deleted if {@link GroupRequest#getEditParts()} returns a <tt>null</tt> or empty list; otherwise each
	 * editpart's view is deleted.
	 * 
	 * @param deleteRequest
	 *            the original delete request.
	 * @return Command
	 */
	protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
		CompositeCommand cc = new CompositeCommand(StringStatics.BLANK);
		TransactionalEditingDomain editingDomain = getEditingDomain();
		if (editingDomain == null) {
			return null;
		}
		List<?> toDel = deleteRequest.getEditParts();
		/* if the element deleted is the link between a containment circle and a class */
		if (getHost() instanceof ContainmentSubLinkEditPart) {
			ContainmentSubLinkEditPart hostaddedlink = (ContainmentSubLinkEditPart) getHost();
			EditPart circlecontainment = hostaddedlink.getSource();
			ContainmentCircleEditPart containmentcircleeditpart = (ContainmentCircleEditPart) hostaddedlink.getSource();
			/* The containment circle node is deleted only if any other link is connected */
			if (containmentcircleeditpart.getSourceConnections().size() == 1) {
				cc.compose(new DeleteCommand(editingDomain, (View) circlecontainment.getModel()));
			}
		}
		/* if the element deleted is the contained class, the link connected should be delete also */
		if (getHost() instanceof ClassEditPart) {
			List<Connector> linkList = new ArrayList<Connector>();
			ClassEditPart hostClass = (ClassEditPart) getHost();
			View hostShape = (View) hostClass.getModel();
			for (Object object : hostShape.getTargetEdges()) {
				linkList.add((Connector) object);
			}

			Classifier classhost = (Classifier) hostShape.getElement();
			Iterator<Connector> addedLinkIterator = linkList.iterator();
			if (classhost.getOwner() instanceof org.eclipse.uml2.uml.Class) {
				while (addedLinkIterator.hasNext()) {
					Connector currentConnector = addedLinkIterator.next();
					Shape containmentCircleShape = (Shape) ((Edge) currentConnector).getSource();
					if (((View) containmentCircleShape).getType().equals(Integer.toString(CContainmentCircleEditPart.VISUAL_ID))) {
						/* The containment circle node is deleted only if any other link is connected */
						if (((View) containmentCircleShape).getSourceEdges().size() == 1) {
							cc.compose(new DeleteCommand(editingDomain, (View) containmentCircleShape));
						}
					}
				}
			}
		}
		/* if the element deleted is the contained class, the link connected should be delete also */
		if (getHost() instanceof PackageEditPart) {
			List<Connector> linkList = new ArrayList<Connector>();
			PackageEditPart hostPackage = (PackageEditPart) getHost();
			View shapehost = (View) hostPackage.getModel();
			for (Object object : shapehost.getTargetEdges()) {
				linkList.add((Connector) object);
			}

			PackageableElement classhost = (PackageableElement) shapehost.getElement();
			Iterator<Connector> addedLinkIterator = linkList.iterator();
			if (classhost.getOwner() instanceof org.eclipse.uml2.uml.Package) {
				while (addedLinkIterator.hasNext()) {
					Connector currentConnector = addedLinkIterator.next();
					Shape containmentCircleShape = (Shape) ((Edge) currentConnector).getSource();
					if (((View) containmentCircleShape).getType().equals(Integer.toString(CContainmentCircleEditPart.VISUAL_ID))) {
						/* The containment circle node is deleted only if any other link is connected */
						if (((View) containmentCircleShape).getSourceEdges().size() == 1) {
							cc.compose(new DeleteCommand(editingDomain, (View) containmentCircleShape));
						}
					}
				}
			}
		}
		if (toDel == null || toDel.isEmpty()) {
			cc.compose(new DeleteCommand(editingDomain, (View) getHost().getModel()));
		} else {
			for (int i = 0; i < toDel.size(); i++) {
				IGraphicalEditPart gep = (IGraphicalEditPart) toDel.get(i);
				cc.compose(new DeleteCommand(editingDomain, (View) gep.getModel()));
			}
		}
		return new ICommandProxy(cc.reduce());
	}

	private TransactionalEditingDomain getEditingDomain() {
		if (getHost() instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart) getHost()).getEditingDomain();
		} else if (getHost() instanceof IEditingDomainProvider) {
			Object domain = ((IEditingDomainProvider) getHost()).getEditingDomain();
			if (domain instanceof TransactionalEditingDomain) {
				return (TransactionalEditingDomain) domain;
			}
		}
		return null;
	}
}
