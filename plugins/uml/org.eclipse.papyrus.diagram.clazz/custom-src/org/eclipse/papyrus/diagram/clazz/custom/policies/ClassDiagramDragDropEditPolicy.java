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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.helper.AssociationClassHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.ClassLinkMappingHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.ContainmentHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiAssociationHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiDependencyHelper;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentCircleEditPart;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;

/**
 * The Class ClassDiagramDragDropEditPolicy.
 */
public class ClassDiagramDragDropEditPolicy extends CustomDiagramDragDropEditPolicy {

	/** The specific drop node. */
	public int[] secificDropNode = { 2014, 2013, 2015, 3014, 2008 };

	/**
	 * Instantiates a new class diagram drag drop edit policy.
	 */
	public ClassDiagramDragDropEditPolicy() {
		super();
		init(secificDropNode);
	}

	/**
	 * this method has in charge to create command for create an association if the number of
	 * endtype is superior of 2 a multi association is dropped. if the number of endtype this is
	 * binary association that is dropped.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visualid
	 * 
	 * @return the command
	 */
	protected Command dropAssociation(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		Collection endtypes = ClassLinkMappingHelper.getInstance().getSource(semanticLink);
		if(endtypes.size() == 2) {
			Element source = (Element)endtypes.toArray()[0];
			Element target = (Element)endtypes.toArray()[1];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Association"), source, target, 4001, dropRequest.getLocation(), semanticLink));
		}
		if(endtypes.size() > 2) {
			MultiAssociationHelper associationHelper = new MultiAssociationHelper(getEditingDomain());
			return associationHelper.dropMutliAssociation((Association)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
		}
		return UnexecutableCommand.INSTANCE;

	}

	/**
	 * this method send a Command that create views for associationClass
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visualid
	 * 
	 * @return the command
	 */
	protected Command dropAssociationClass(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		AssociationClassHelper associationClassHelper = new AssociationClassHelper(getEditingDomain());
		return associationClassHelper.dropAssociationClass((AssociationClass)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
	}

	/**
	 * this method send a command to create views to display
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visualid
	 * 
	 * @return the command
	 */
	protected Command dropDependency(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		Collection sources = ClassLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection targets = ClassLinkMappingHelper.getInstance().getTarget(semanticLink);
		if(sources.size() == 1 && targets.size() == 1) {
			Element source = (Element)sources.toArray()[0];
			Element target = (Element)targets.toArray()[0];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Association"), source, target, 4008, dropRequest.getLocation(), semanticLink));
		}
		if(sources.size() > 1 || targets.size() > 1) {
			MultiDependencyHelper dependencyHelper = new MultiDependencyHelper(getEditingDomain());
			return dependencyHelper.dropMutliDependency((Dependency)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected Command outlineDropContainedClass(DropObjectsRequest dropRequest, Element semanticObject, int nodeVISUALID) {
		ContainmentHelper containmentHelper = new ContainmentHelper(getEditingDomain());
		return containmentHelper.outlineDropContainedClass((Class)semanticObject, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
	}

	protected Command compartmentDropContainedClass(DropObjectsRequest dropRequest, Element semanticObject, int nodeVISUALID) {
		ContainmentHelper containmentHelper = new ContainmentHelper(getEditingDomain());
		CompositeCommand cc = new CompositeCommand("compartmentDropContainedClass");
		Point location = dropRequest.getLocation().getCopy();
		((GraphicalEditPart)getHost()).getContentPane().translateToRelative(location);
		((GraphicalEditPart)getHost()).getContentPane().translateFromParent(location);
		location.translate(((GraphicalEditPart)getHost()).getContentPane().getClientArea().getLocation().getNegated());
		cc = getDefaultDropNodeCommand(nodeVISUALID, location, semanticObject);
		GraphicalEditPart owner = null;
		Collection<EditPart> editPartSet = getViewer().getEditPartRegistry().values();
		Iterator<EditPart> editPartIterator = editPartSet.iterator();
		while(editPartIterator.hasNext()) {
			EditPart currentEditPart = editPartIterator.next();
			if(currentEditPart instanceof ClassEditPart) {
				if(((GraphicalEditPart)currentEditPart).resolveSemanticElement().equals(semanticObject)) {
					cc.add(new DeleteCommand(getEditingDomain(), (View)((GraphicalEditPart)currentEditPart).getModel()));

				}
				if(((GraphicalEditPart)currentEditPart).resolveSemanticElement().equals(semanticObject.getOwner())) {
					owner = (GraphicalEditPart)currentEditPart;
					Collection<EditPart> ownereditPartSet = owner.getViewer().getEditPartRegistry().values();
					Iterator<EditPart> ownereditPartIterator = ownereditPartSet.iterator();
					while(ownereditPartIterator.hasNext()) {
						EditPart ownercurrentEditPart = ownereditPartIterator.next();
						if(ownercurrentEditPart instanceof ContainmentCircleEditPart) {
							ContainmentCircleEditPart containmentcircleeditpart = (ContainmentCircleEditPart)ownercurrentEditPart;
							if(containmentcircleeditpart.getSourceConnections().size() == 1) {
								cc.add(new DeleteCommand(getEditingDomain(), (View)ownercurrentEditPart.getModel()));
							}
						}
					}

				}
			}
		}

		return new ICommandProxy(cc);
	}

	/**
	 * {@inheritedDoc}
	 */
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID, int linkVISUALID) {
		switch(nodeVISUALID) {
		case 2014:
			return dropDependency(dropRequest, semanticLink, nodeVISUALID);
		case 2013:
			return dropAssociationClass(dropRequest, semanticLink, nodeVISUALID);
		case 2015:
			return dropAssociation(dropRequest, semanticLink, nodeVISUALID);
		case 3014:
			return compartmentDropContainedClass(dropRequest, semanticLink, nodeVISUALID);
		case 2008:
			return outlineDropContainedClass(dropRequest, semanticLink, nodeVISUALID);
		default:
			return UnexecutableCommand.INSTANCE;
		}
	}

}
