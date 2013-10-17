/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.command;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.EObjectValueStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLViewProvider;
import org.eclipse.uml2.uml.Interface;

/**
 * this class is used to create the lollipop interface from a port
 *
 */
public class CreateLollipopPortCommand extends RecordingCommand {

	protected  ArrayList<Interface> providedInterface= new ArrayList<Interface>();
	protected  ArrayList<Interface> requiredInterface= new ArrayList<Interface>();
	protected PortEditPart porteditPart=null;

	
	/**
	 * 
	 * Constructor.
	 *
	 * @param domain the transactional editing domain 
	 * @param provided a list of provided interface to display
	 * @param required a list of required interface to display
	 * @param portEditpart the port editpart form which interfaces will be displayed
	 */
	public CreateLollipopPortCommand(TransactionalEditingDomain domain, Collection<Interface> provided, Collection<Interface> required, PortEditPart portEditpart ) {
		super(domain,"Creation of lollipop for ports");
		providedInterface.addAll(provided);
		requiredInterface.addAll(required);
		this.porteditPart= portEditpart;
	}

	@Override
	protected void doExecute() {
		UMLViewProvider umlViewProvider= new UMLViewProvider();
		//get the position of the port around its container...
		IFigure parentFigure=((GraphicalEditPart)porteditPart.getParent()).getFigure();


		Rectangle bounds = parentFigure.getBounds();

		Rectangle insideRect = bounds.getCopy().shrink(new Insets(30));
		int position = insideRect.getPosition(porteditPart.getLocation());
		//take the great parent of the port
		EditPart componentEditPart=porteditPart.getParent();
		EditPart container= componentEditPart.getParent();
		for(Interface currentRequired : requiredInterface) {
			Node node = createInterfacenode(umlViewProvider, container, currentRequired);
			setPositionNode(node, position);
			String kind="REQUIRED";
			createEdge(umlViewProvider, node, kind);

		}

		for(Interface currentprovided : providedInterface) {
			Node node = createInterfacenode(umlViewProvider, container, currentprovided);
			setPositionNode(node, position);
			String kind="PROVIDED";
			createEdge(umlViewProvider, node, kind);

		}
	}
/**
 * creation of the edge form the port to the interface
 * @param umlViewProvider
 * @param node the node that represent the interface
 * @param kind kind of the interface REQUIRED or PROVIDED
 */
	protected void createEdge(UMLViewProvider umlViewProvider, Node node, String kind) {
		Edge edge=umlViewProvider.createLink_4018(((View)porteditPart.getModel()).getDiagram(), -1, true, porteditPart.getDiagramPreferencesHint());

		IdentityAnchor anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		edge.setSourceAnchor(anchor);
		anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		edge.setTargetAnchor(anchor);
		edge.setSource((View)porteditPart.getModel());
		edge.setTarget(node);
		edge.setElement(null);
		EObjectValueStyle eObjectValueStyle = (EObjectValueStyle)edge.createStyle(NotationPackage.eINSTANCE.getEObjectValueStyle());
		eObjectValueStyle.setName(kind);
	}

	/**
	 * create the interface node
	 * @param umlViewProvider
	 * @param container the container of the interface node
	 * @param currentInterface the interface
	 * @return the node
	 */
	protected Node createInterfacenode(UMLViewProvider umlViewProvider, EditPart container, Interface currentInterface) {
		Node node=umlViewProvider.createNamedElement_2003(currentInterface,(View) container.getModel(), -1, true, porteditPart.getDiagramPreferencesHint());
		((Bounds)node.getLayoutConstraint()).setWidth(20);
		((Bounds)node.getLayoutConstraint()).setHeight(20);
		return node;
	}
	
	/**
	 * use to place the interface node around the component form the port
	 * @param node the interface node
	 * @param position the position where is the port NORTH SOUTH, EAST, WEST
	 */
	protected void setPositionNode(Node node, int position){
		((Bounds)node.getLayoutConstraint()).setX(porteditPart.getLocation().x);
		((Bounds)node.getLayoutConstraint()).setY(porteditPart.getLocation().y);
		int distance=60;
		if (position == PositionConstants.SOUTH) {
			((Bounds)node.getLayoutConstraint()).setY(((Bounds)node.getLayoutConstraint()).getY()+distance);
		}
		else if (position == PositionConstants.NORTH) {
			((Bounds)node.getLayoutConstraint()).setY(((Bounds)node.getLayoutConstraint()).getY()-distance);
		}

		else if (position == PositionConstants.EAST) {
			((Bounds)node.getLayoutConstraint()).setX(((Bounds)node.getLayoutConstraint()).getX()+distance);
		}

		else if (position == PositionConstants.WEST) {
			((Bounds)node.getLayoutConstraint()).setX(((Bounds)node.getLayoutConstraint()).getX()-distance);
		}
	}
}
