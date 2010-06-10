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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConnectorEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConstraintPropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.PropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.helper.ConnectorLinkMappingHelper;
import org.eclipse.papyrus.sysml.diagram.parametric.part.SysmlVisualIDRegistry;
import org.eclipse.papyrus.sysml.diagram.parametric.providers.SysmlElementTypes;
import org.eclipse.papyrus.sysml.diagram.parametric.utils.PropertyLinkedToClassifier;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

/**
 * This class is used to execute the drag and drop from the outline. It can manage the drop of nodes
 * and binary links. To manage specific drop the method
 * CommonDiagramDragDropEditPolicy.getSpecificDropCommand has to be implemented
 */
public class CustomDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/** The container view where the drop is done */
	private View containerView;

	/**
	 * Instantiates a new custom diagram drag drop edit policy with the right link mapping helper.
	 */
	public CustomDiagramDragDropEditPolicy() {
		super(ConnectorLinkMappingHelper.getInstance());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		Set<Integer> droppableElementsVisualId = new HashSet<Integer>();
		droppableElementsVisualId.add(ConnectorEditPart.VISUAL_ID);
		droppableElementsVisualId.add(ConstraintPropertyEditPart.VISUAL_ID);
		droppableElementsVisualId.add(PropertyEditPart.VISUAL_ID);
		return droppableElementsVisualId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IElementType getUMLElementType(int elementID) {
		return SysmlElementTypes.getElementType(elementID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		this.containerView = containerView;
		if(domainElement instanceof Element) {
			EObject e = getApplication(domainElement);
			if(e != null) {
				if(e instanceof ConstraintProperty) {
					return ConstraintPropertyEditPart.VISUAL_ID;
				}
				// others cases for stereotyped elements
			}
		}
		return SysmlVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return SysmlVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID, int linkVISUALID) {
		if(nodeVISUALID != -1) {
			switch(nodeVISUALID) {
			case ConstraintPropertyEditPart.VISUAL_ID:
				return dropConstraintProperty(dropRequest, semanticLink, nodeVISUALID);
			case PropertyEditPart.VISUAL_ID:
				return dropProperty(dropRequest, semanticLink, nodeVISUALID);
			default:
				return super.getSpecificDropCommand(dropRequest, semanticLink, nodeVISUALID, linkVISUALID);
			}
		} else if(linkVISUALID != -1) {
			switch(linkVISUALID) {
			case ConnectorEditPart.VISUAL_ID:
				return dropConnector(dropRequest, semanticLink, linkVISUALID);
			default:
				return super.getSpecificDropCommand(dropRequest, semanticLink, nodeVISUALID, linkVISUALID);
			}
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

	/**
	 * Specific drop action for connector.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param linkVISUALID
	 *        the link visual Sid
	 * 
	 * @return the command for connector
	 */
	protected Command dropConnector(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> sources = ConnectorLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection<?> targets = ConnectorLinkMappingHelper.getInstance().getTarget(semanticLink);
		if(sources.size() == 1 && targets.size() == 1) {
			ConnectorEnd sourceConnector = (ConnectorEnd)sources.toArray()[0];
			ConnectorEnd targetConnector = (ConnectorEnd)targets.toArray()[0];
			ConnectableElement source = sourceConnector.getRole();
			ConnectableElement target = targetConnector.getRole();
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Connector"), source, target, linkVISUALID, dropRequest.getLocation(), semanticLink));
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

	/**
	 * Specific drop for constraint property.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticElement
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visual id
	 * 
	 * @return the default drop node command for Constraint Property object
	 */
	private Command dropConstraintProperty(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID) {
		CompositeCommand cc = new CompositeCommand("Drop");
		EObject droppedObject = getApplication(semanticElement);
		if(droppedObject != null) {
			cc = getDefaultDropNodeCommand(nodeVISUALID, dropRequest.getLocation(), droppedObject);
			return new ICommandProxy(cc);
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Specific drop for property. Check if the property is linked to the classifier we want to
	 * drag&drop on
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticElement
	 *        the semantic element
	 * @param nodeVISUALID
	 *        the node visual id
	 * 
	 * @return the command
	 */
	private Command dropProperty(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID) {
		EObject eObject = containerView.getElement();
		if(eObject instanceof Classifier) {
			PropertyLinkedToClassifier propertyLinkedToClassifier = new PropertyLinkedToClassifier((Classifier)eObject, (Property)semanticElement);
			if(propertyLinkedToClassifier.isLinkedToClassifier()) {
				CompositeCommand cc = new CompositeCommand("Drop");
				cc = getDefaultDropNodeCommand(nodeVISUALID, dropRequest.getLocation(), semanticElement);
				return new ICommandProxy(cc);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isEditPartTypeSuitableForEClass(Class<? extends GraphicalEditPart> editPartClass, EClass eClass) {
		// avoid selecting a label instead of the activity node
		return !LabelEditPart.class.isAssignableFrom(editPartClass);
	}

	/**
	 * Gets stereotype application element for a specified domain element.
	 * 
	 * @param domainElement
	 *        the domain element
	 * 
	 * @return the stereotype application object
	 */
	private EObject getApplication(EObject domainElement) {
		if(getStereotypeAvailable(domainElement) != null && domainElement instanceof Element) {
			Element element = (Element)domainElement;
			List<EObject> applications = element.getStereotypeApplications();
			for(EObject eObject : applications) {
				if(getStereotypeAvailable(domainElement).equals(eObject.eClass())) {
					return eObject;
				}
			}
		}
		return null;
	}

	/**
	 * Gets the available stereotype EClass for a specified EObject
	 * 
	 * @param eObject
	 *        the e object
	 * 
	 * @return the stereotype available
	 */
	private EClass getStereotypeAvailable(EObject eObject) {
		if(eObject instanceof Property) {
			return ConstraintsPackage.Literals.CONSTRAINT_PROPERTY;
		}
		return null;
	}



}
