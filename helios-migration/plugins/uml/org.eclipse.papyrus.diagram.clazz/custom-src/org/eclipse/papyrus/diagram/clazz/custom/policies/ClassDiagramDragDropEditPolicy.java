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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.helper.AssociationClassHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.ClassLinkMappingHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.ContainmentHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiAssociationHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiDependencyHelper;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;

/**
 * The Class ClassDiagramDragDropEditPolicy.
 */
public class ClassDiagramDragDropEditPolicy extends CustomDiagramDragDropEditPolicy {

	public static final String CONTAINED_CLASS_DROP_TO_COMPARTMENT = "ContainedClassDropToCompartment";

	/** The specific drop node. */
	public int[] secificDropNode = { 2014, 2013, 2015, 3014, 2008, 2007 };


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

	/**
	 * Use to drop a class from the outline to the diagram
	 * 
	 * @param dropRequest
	 *        is the request for the drop, never be null
	 * @param semanticObject
	 *        is the class dropped
	 * @param nodeVISUALID
	 *        is the visual ID of the class
	 * @return a command to execute
	 */

	protected Command outlineDropContainedClass(DropObjectsRequest dropRequest, Element semanticObject, int nodeVISUALID) {
		ContainmentHelper containmentHelper = new ContainmentHelper(getEditingDomain());
		Element owner = (Element)semanticObject.getOwner();
		GraphicalEditPart ownerGraphicalEditPart = null;
		Collection<EditPart> editPartSet = getViewer().getEditPartRegistry().values();
		Iterator<EditPart> editPartIterator = editPartSet.iterator();
		while(editPartIterator.hasNext()) {
			EditPart currentEditPart = editPartIterator.next();
			if((currentEditPart instanceof ClassEditPart) || currentEditPart instanceof PackageEditPart) {
				if(((GraphicalEditPart)currentEditPart).resolveSemanticElement().equals(owner)) {
					ownerGraphicalEditPart = (GraphicalEditPart)currentEditPart;
				}
			}
		}

		if(ownerGraphicalEditPart != null) {
			return containmentHelper.outlineDropContainedClass((PackageableElement)semanticObject, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
		} else {
			return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, dropRequest.getLocation(), semanticObject));
		}

	}

	/**
	 * Use to drop a class from the diagram to the nestedClassifierCompartment
	 * 
	 * @param dropRequest
	 *        is the request for the drop, never be null
	 * @param droppedElement
	 *        is the class dropped
	 * @param nodeVISUALID
	 *        is the visual ID of the class
	 * @return a command to execute
	 */
	protected Command compartmentDropContainedClass(DropObjectsRequest dropRequest, Element droppedElement, int nodeVISUALID) {
		CompositeCommand cc = new CompositeCommand(CONTAINED_CLASS_DROP_TO_COMPARTMENT);

		// Get the location of the dropped element
		Point location = dropRequest.getLocation().getCopy();
		((GraphicalEditPart)getHost()).getContentPane().translateToRelative(location);
		((GraphicalEditPart)getHost()).getContentPane().translateFromParent(location);
		location.translate(((GraphicalEditPart)getHost()).getContentPane().getClientArea().getLocation().getNegated());

		// Drop the element to the class compartment
		cc = getDefaultDropNodeCommand(nodeVISUALID, location, droppedElement);

		// look for the dropped element existing outside the compartment in the current diagram and his containment connection
		Collection<EditPart> editPartSet = getViewer().getEditPartRegistry().values();
		Iterator<EditPart> editPartIterator = editPartSet.iterator();
		while(editPartIterator.hasNext()) {
			EditPart currentEditPart = editPartIterator.next();
			if(currentEditPart instanceof ClassEditPart || currentEditPart instanceof PackageEditPart) {
				if(((GraphicalEditPart)currentEditPart).resolveSemanticElement().equals(droppedElement)) {
					View view = (View)currentEditPart.getModel();

					// look for the containment connection
					EList<Connector> listlink = view.getTargetEdges();
					Iterator<Connector> addedlinkIterator = listlink.iterator();
					while(addedlinkIterator.hasNext()) {
						Connector currentconnector = addedlinkIterator.next();
						Shape containmenetshape = (Shape)((Edge)currentconnector).getSource();
						if(((View)containmenetshape).getType().equals(Integer.toString(ContainmentCircleEditPart.VISUAL_ID))) {
							/* The containment circle node is deleted only if any other link is connected */
							if(((View)containmenetshape).getSourceEdges().size() == 1) {
								// Delete the containment circle
								cc.compose(new DeleteCommand(getEditingDomain(), (View)containmenetshape));

							}
						}
					}
					// Delete the dropped element existing outside the compartment
					cc.add(new DeleteCommand(getEditingDomain(), view));


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
		case 2007:
			return outlineDropContainedClass(dropRequest, semanticLink, nodeVISUALID);
		default:
			return UnexecutableCommand.INSTANCE;
		}
	}

}
