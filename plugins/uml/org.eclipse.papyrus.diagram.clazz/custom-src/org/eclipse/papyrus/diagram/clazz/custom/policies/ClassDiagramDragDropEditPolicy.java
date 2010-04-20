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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.helper.AssociationClassHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.ClassLinkMappingHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.ContainmentHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiAssociationHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiDependencyHelper;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * The Class ClassDiagramDragDropEditPolicy.
 */
public class ClassDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	public static final String CONTAINED_CLASS_DROP_TO_COMPARTMENT = "ContainedClassDropToCompartment";

	/**
	 * Instantiates a new class diagram drag drop edit policy.
	 */
	public ClassDiagramDragDropEditPolicy() {
		super(ClassLinkMappingHelper.getInstance());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		Set<Integer> droppableElementsVisualID = new HashSet<Integer>();
		
		droppableElementsVisualID.add(Dependency2EditPart.VISUAL_ID);
		droppableElementsVisualID.add(AssociationClassEditPart.VISUAL_ID);
		droppableElementsVisualID.add(AssociationNodeEditPart.VISUAL_ID);
		droppableElementsVisualID.add(ClassEditPart.VISUAL_ID);
		droppableElementsVisualID.add(PackageEditPart.VISUAL_ID);
		droppableElementsVisualID.add(ModelEditPartTN.VISUAL_ID);
		droppableElementsVisualID.add(PackageEditPartCN.VISUAL_ID);
		droppableElementsVisualID.add(Class5EditPart.VISUAL_ID);
		droppableElementsVisualID.add(ModelEditPartCN.VISUAL_ID);
		
		return droppableElementsVisualID;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
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
			if((currentEditPart instanceof ClassEditPart) || currentEditPart instanceof PackageEditPart || currentEditPart instanceof ModelEditPartTN) {
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
			if(currentEditPart instanceof ClassEditPart || currentEditPart instanceof PackageEditPartCN || currentEditPart instanceof PackageEditPart || currentEditPart instanceof ModelEditPartTN || currentEditPart instanceof ModelEditPartCN) {
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
	 * gets a drop command
	 * 
	 * @param request
	 *        the request
	 * @return command
	 */
	protected Command getDropCommand(ChangeBoundsRequest request) {
		ChangeBoundsRequest req = new ChangeBoundsRequest(REQ_ADD);
		req.setEditParts(request.getEditParts());
		req.setMoveDelta(request.getMoveDelta());
		req.setSizeDelta(request.getSizeDelta());
		req.setLocation(request.getLocation());
		req.setResizeDirection(request.getResizeDirection());
		Command cmd = getHost().getCommand(req);

		if(getHost() instanceof PackagePackageableElementCompartment2EditPart || getHost() instanceof PackagePackageableElementCompartmentEditPart || getHost() instanceof ModelEditPart || getHost() instanceof ModelPackageableElementCompartmentEditPart || getHost() instanceof ModelPackageableElementCompartment2EditPart) {
			Iterator<EditPart> droppedEditPartIterator = request.getEditParts().iterator();
			while(droppedEditPartIterator.hasNext()) {
				EditPart editPart = (EditPart)droppedEditPartIterator.next();
				if(((GraphicalEditPart)editPart).resolveSemanticElement() instanceof Package && (((View)editPart.getModel()).getElement().eContainer() instanceof Package)) {
					cmd.chain(getDropObjectsCommand(castToDropObjectsRequest(request)));
				}
			}
		}
		if(cmd == null || !cmd.canExecute()) {
			return getDropObjectsCommand(castToDropObjectsRequest(request));
		}

		return cmd;
	}

	/**
	 * {@inheritedDoc}
	 */
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID, int linkVISUALID) {
		switch(nodeVISUALID) {
		case Dependency2EditPart.VISUAL_ID:
			return dropDependency(dropRequest, semanticLink, nodeVISUALID);
		case AssociationClassEditPart.VISUAL_ID:
			return dropAssociationClass(dropRequest, semanticLink, nodeVISUALID);
		case AssociationNodeEditPart.VISUAL_ID:
			return dropAssociation(dropRequest, semanticLink, nodeVISUALID);
		case Class5EditPart.VISUAL_ID:
		case PackageEditPartCN.VISUAL_ID:
		case ModelEditPartCN.VISUAL_ID:
			return compartmentDropContainedClass(dropRequest, semanticLink, nodeVISUALID);
		case ModelEditPartTN.VISUAL_ID:
		case ClassEditPart.VISUAL_ID:
		case PackageEditPart.VISUAL_ID:
			return outlineDropContainedClass(dropRequest, semanticLink, nodeVISUALID);
		default:
			return UnexecutableCommand.INSTANCE;
		}
	}

	

}
