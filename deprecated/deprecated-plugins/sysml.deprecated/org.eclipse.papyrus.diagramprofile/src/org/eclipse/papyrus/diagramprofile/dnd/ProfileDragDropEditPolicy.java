/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.diagramprofile.dnd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

public abstract class ProfileDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	public ProfileDragDropEditPolicy() {
		super(new ILinkMappingHelper() {

			public Collection<?> getTarget(Element link) {
				return Collections.EMPTY_LIST;
			}

			public Collection<?> getSource(Element link) {
				return Collections.EMPTY_LIST;
			}
		});
	}

	public ProfileDragDropEditPolicy(ILinkMappingHelper helper) {
		super(helper);
	}

	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return 0;
	}

	public EObject getApplication(EObject domainElement) {
		if (getStereotypeAvailable() != null && domainElement instanceof Element) {
			Element element = (Element) domainElement;
			List<EObject> applications = element.getStereotypeApplications();
			for (EObject e : applications) {
				if (getStereotypeAvailable().equals(e.eClass())) {
					return e;
				}
			}
		}
		return null;
	}

	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement instanceof Element) {
			EObject e = getApplication(domainElement);
			if (e != null) {
				return getNodeVisualID();
			}
		}
		return -1;
	}

	@Override
	public abstract IElementType getUMLElementType(int elementID);

	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		// Create a view request from the drop request and then forward getting
		// the command for that.
		CompositeCommand cc = new CompositeCommand("Drop");
		List viewDescriptors = new ArrayList();
		Iterator iter = dropRequest.getObjects().iterator();
		if (dropRequest.getObjects().size() > 0 && dropRequest.getObjects().get(0) instanceof String) {
			return getDropFileCommand(dropRequest);
		}
		Point location = dropRequest.getLocation().getCopy();
		((GraphicalEditPart) getHost()).getContentPane().translateToRelative(location);
		((GraphicalEditPart) getHost()).getContentPane().translateFromParent(location);
		location.translate(((GraphicalEditPart) getHost()).getContentPane().getClientArea().getLocation().getNegated());
		while (iter.hasNext()) {
			EObject next = (EObject) iter.next();
			EObject droppedObject = getApplication(next);
			int nodeVISUALID = getNodeVisualID(((IGraphicalEditPart) getHost()).getNotationView(), next);
			// int linkVISUALID = getLinkWithClassVisualID(droppedObject);
			// if (specificDrop.contains(nodeVISUALID) || specificDrop.contains(linkVISUALID)) {
			// return getSpecificDropCommand(dropRequest, (Element) droppedObject, nodeVISUALID,
			// linkVISUALID);
			// }

			if (nodeVISUALID != -1) {
				// The element to drop is a node
				// Retrieve it's expected graphical parent
				EObject graphicalParent = ((GraphicalEditPart) getHost()).resolveSemanticElement();

				// Restrict the default node creation to the following cases:
				// . Take the containment relationship into consideration
				// . Release the constraint when GraphicalParent is a Package (Canvas for most
				// diagrams)
				if (graphicalParent instanceof Package) {
					cc = getDefaultDropNodeCommand(nodeVISUALID, location, droppedObject);

				} else if ((graphicalParent instanceof Element)
						&& ((Element) graphicalParent).getOwnedElements().contains(droppedObject)) {
					cc = getDefaultDropNodeCommand(nodeVISUALID, location, droppedObject);

				} else {
					return UnexecutableCommand.INSTANCE;
				}

			}
			// Collection sources = get.getSource((Element) droppedObject);
			// Collection targets = linkmappingHelper.getTarget((Element) droppedObject);
			// if (sources.size() == 0 || targets.size() == 0) {
			// return UnexecutableCommand.INSTANCE;
			// }
			// binary association
			// Element source = (Element) sources.toArray()[0];
			// Element target = (Element) targets.toArray()[0];
			// cc = dropBinaryLink(cc, source, target, linkVISUALID, dropRequest.getLocation(),
			// (Element) droppedObject);
		}
		return new ICommandProxy(cc);
	}

	public abstract int getNodeVisualID();

	public abstract EClass getStereotypeAvailable();

}
