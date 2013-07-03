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
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.AssociationClassHelper;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.ClassLinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.ContainmentHelper;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.InstanceSpecificationLinkHelper;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.MultiAssociationHelper;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.MultiDependencyHelper;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationLinkEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.NestedClassForClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.RedefinableTemplateSignatureEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.SubstitutionEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.OldCommonDiagramDragDropEditPolicy;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * The Class ClassDiagramDragDropEditPolicy.
 */
public class ClassDiagramDragDropEditPolicy extends OldCommonDiagramDragDropEditPolicy {

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
		droppableElementsVisualID.add(DependencyNodeEditPart.VISUAL_ID);
		droppableElementsVisualID.add(AssociationEditPart.VISUAL_ID);
		droppableElementsVisualID.add(AssociationClassEditPart.VISUAL_ID);
		droppableElementsVisualID.add(AssociationNodeEditPart.VISUAL_ID);

		droppableElementsVisualID.add(NestedClassForClassEditPart.VISUAL_ID);
		droppableElementsVisualID.add(ClassEditPartCN.VISUAL_ID);
		droppableElementsVisualID.add(PackageEditPartCN.VISUAL_ID);
		droppableElementsVisualID.add(ModelEditPartCN.VISUAL_ID);


		droppableElementsVisualID.add(ModelEditPartTN.VISUAL_ID);
		droppableElementsVisualID.add(ClassEditPart.VISUAL_ID);
		droppableElementsVisualID.add(PackageEditPart.VISUAL_ID);
		droppableElementsVisualID.add(InstanceSpecificationEditPart.VISUAL_ID);
		droppableElementsVisualID.add(InstanceSpecificationLinkEditPart.VISUAL_ID);

		return droppableElementsVisualID;
	}

	/**
	 * {@inheritedDoc}
	 */
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID, int linkVISUALID) {

		//respecify for enumeration because this is also an instancespecification
		if(nodeVISUALID == EnumerationLiteralEditPart.VISUAL_ID) {
			return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, dropRequest.getLocation(), semanticLink));
		}

		if(nodeVISUALID == InstanceSpecificationEditPart.VISUAL_ID || linkVISUALID == InstanceSpecificationLinkEditPart.VISUAL_ID) {
			return dropInstanceSpecification(dropRequest, semanticLink, linkVISUALID);
		}

		if(linkVISUALID == SubstitutionEditPart.VISUAL_ID) {
			return dropAsNormalBinaryLink(dropRequest, semanticLink, linkVISUALID);
		}
		if(linkVISUALID == InterfaceRealizationEditPart.VISUAL_ID) {
			return dropAsNormalBinaryLink(dropRequest, semanticLink, linkVISUALID);
		}
		if(linkVISUALID == AssociationEditPart.VISUAL_ID) {
			return dropAssociation(dropRequest, semanticLink, linkVISUALID);
		}
		switch(nodeVISUALID) {
		case DependencyNodeEditPart.VISUAL_ID:
			return dropDependency(dropRequest, semanticLink, nodeVISUALID);
		case AssociationClassEditPart.VISUAL_ID:
			return dropAssociationClass(dropRequest, semanticLink, nodeVISUALID);
		case AssociationNodeEditPart.VISUAL_ID:
			return dropAssociation(dropRequest, semanticLink, nodeVISUALID);
		case NestedClassForClassEditPart.VISUAL_ID:
		case ClassEditPartCN.VISUAL_ID:
		case PackageEditPartCN.VISUAL_ID:
		case ModelEditPartCN.VISUAL_ID:
			return dropChildNodeWithContainmentLink(dropRequest, semanticLink, nodeVISUALID);
		case ModelEditPartTN.VISUAL_ID:
		case ClassEditPart.VISUAL_ID:
		case PackageEditPart.VISUAL_ID:
			return dropTopLevelNodeWithContainmentLink(dropRequest, semanticLink, nodeVISUALID);
		default:
			return UnexecutableCommand.INSTANCE;
		}
	}


	/**
	 * drop a instance specification as a link or as a node
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the element
	 * @param linkVISUALID
	 *        the visualID
	 * @return the command in charge of the drop
	 */
	protected Command dropInstanceSpecification(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		if(semanticLink instanceof InstanceSpecification) {
			if(((InstanceSpecification)semanticLink).getClassifiers().size() > 0) {
				if(((InstanceSpecification)semanticLink).getClassifiers().get(0) instanceof Association) {
					//DROP AS LINK
					ArrayList<InstanceSpecification> endTypes = InstanceSpecificationLinkHelper.getEnds(((InstanceSpecification)semanticLink));
					if(endTypes.size() > 0) {
						Element source = endTypes.get(0);
						Element target = endTypes.get(1);
						return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Instance"), source, target, InstanceSpecificationLinkEditPart.VISUAL_ID, dropRequest.getLocation(), semanticLink));
					}
				}

			}
			//DROP AS A NODE
			EObject graphicalParent = ((GraphicalEditPart)getHost()).resolveSemanticElement();
			// Restrict the default node creation to the following cases:
			// . Take the containment relationship into consideration
			// . Release the constraint when GraphicalParent is a diagram
			//drop into diagram
			if(getHost().getModel() instanceof Diagram) {
				return new ICommandProxy(getDefaultDropNodeCommand(InstanceSpecificationEditPart.VISUAL_ID, dropRequest.getLocation(), semanticLink));
				//drop into another editpart
			} else if((graphicalParent instanceof Element) && ((Element)graphicalParent).getOwnedElements().contains(semanticLink)) {
				return new ICommandProxy(getDefaultDropNodeCommand(InstanceSpecificationEditPartCN.VISUAL_ID, dropRequest.getLocation(), semanticLink));

			}

		}
		return UnexecutableCommand.INSTANCE;
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
		if(endtypes.size() == 1) {
			Element source = (Element)endtypes.toArray()[0];
			Element target = (Element)endtypes.toArray()[0];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Association"), source, target, 4001, dropRequest.getLocation(), semanticLink));
		}

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

	protected Command dropTopLevelNodeWithContainmentLink(DropObjectsRequest dropRequest, Element semanticObject, int nodeVISUALID) {
		ContainmentHelper containmentHelper = new ContainmentHelper(getEditingDomain());

		Element owner = (Element)semanticObject.getOwner();
		if(owner == null) {
			return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, dropRequest.getLocation(), semanticObject));
		}
		EditPart ownerEditPart = containmentHelper.findEditPartFor(getViewer().getEditPartRegistry(), owner);
		if(ownerEditPart != null) {
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
	protected Command dropChildNodeWithContainmentLink(DropObjectsRequest dropRequest, Element droppedElement, int nodeVISUALID) {
		ContainmentHelper containmentHelper = new ContainmentHelper(getEditingDomain());
		CompositeCommand cc = new CompositeCommand(CONTAINED_CLASS_DROP_TO_COMPARTMENT);
		cc.add(getDefaultDropNodeCommand(nodeVISUALID, dropRequest.getLocation(), droppedElement));

		EObject graphicalParent = ((GraphicalEditPart)getHost()).resolveSemanticElement();
		if(!((droppedElement instanceof Element) && ((Element)graphicalParent).getOwnedElements().contains(droppedElement))) {
			return UnexecutableCommand.INSTANCE;
		}
		if(containmentHelper.findEditPartFor(getViewer().getEditPartRegistry(), droppedElement) != null) {
			EditPart editpart = containmentHelper.findEditPartFor(getViewer().getEditPartRegistry(), droppedElement);
			View droppedView = (View)(editpart.getModel());

			containmentHelper.deleteIncomingContainmentLinksFor(cc, droppedView);

			// Delete the dropped element existing outside the compartment
			cc.add(new DeleteCommand(getEditingDomain(), droppedView));
		}
		return new ICommandProxy(cc);
	}



	/**
	 * call the mechanism to drop a binary link without specific type
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the element that is the interfaceRealization
	 * @param linkVISUALID
	 *        the visualID of the interfaceRealization
	 * @return the command containing the creation of the view ffor a link
	 */
	protected Command dropAsNormalBinaryLink(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> sources = linkmappingHelper.getSource(semanticLink);
		Collection<?> targets = linkmappingHelper.getTarget(semanticLink);
		if(sources.size() == 0 || targets.size() == 0) {
			return UnexecutableCommand.INSTANCE;
		}

		Element source = (Element)sources.toArray()[0];
		Element target = (Element)targets.toArray()[0];
		CompositeCommand cc = new CompositeCommand("");
		dropBinaryLink(cc, source, target, linkVISUALID, dropRequest.getLocation(), semanticLink);
		return new ICommandProxy(cc);
	}




	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy#getDropCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 * 
	 */
	protected Command getDropCommand(ChangeBoundsRequest request) {
		//this is a drop done by user internal to the diagram
		//prevent from the drop intra diagram of a template signature into the diagram
		Iterator editPartsIter = request.getEditParts().iterator();
		while(editPartsIter.hasNext()) {
			if(editPartsIter.next() instanceof RedefinableTemplateSignatureEditPart) {
				return UnexecutableCommand.INSTANCE;
			}
		}

		// in the case of labelEditPart the command add can launch null pointer exception
		editPartsIter = request.getEditParts().iterator();
		boolean containsLabelEditpart = false;
		while(editPartsIter.hasNext() && !containsLabelEditpart) {
			EditPart currentEditPart = (EditPart)editPartsIter.next();
			if(currentEditPart instanceof ITextAwareEditPart && currentEditPart instanceof IPrimaryEditPart) {
				containsLabelEditpart = true;
			}
		}

		//the addCommand of a label edit part into the diagram raises an null pointer exception.
		//it is due to the label has not constraint, used during the AddCommand
		if(containsLabelEditpart && getHost() instanceof DiagramEditPart) {
			return UnexecutableCommand.INSTANCE;
		} else {
			//normal case
			ChangeBoundsRequest req = new ChangeBoundsRequest(REQ_ADD);
			req.setEditParts(request.getEditParts());
			req.setMoveDelta(request.getMoveDelta());
			req.setSizeDelta(request.getSizeDelta());
			req.setLocation(request.getLocation());
			req.setResizeDirection(request.getResizeDirection());
			Command cmd = getHost().getCommand(req);
			if(cmd == null || !cmd.canExecute()) {
				return getDropObjectsCommand(castToDropObjectsRequest(request));
			}
			return cmd;
		}
	}

}
