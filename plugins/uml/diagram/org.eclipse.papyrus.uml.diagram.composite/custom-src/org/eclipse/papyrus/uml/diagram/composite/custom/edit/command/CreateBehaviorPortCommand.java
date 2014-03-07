/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.command;

import java.util.ArrayList;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.BehaviorPortEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.BehaviorPortLinkEditPart;

/**
 * create a notation node and the link for the behavior port
 *
 */
public class CreateBehaviorPortCommand extends RecordingCommand {

	protected View owner=null; 
	protected View portView;
	protected Rectangle position=null;
	public CreateBehaviorPortCommand(TransactionalEditingDomain domain, View owner, View portView, Rectangle position) {
		super(domain, "Create Behavior Port");
		this.owner=owner;
		this.portView=portView;
		this.position=position;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doExecute() {
		//create the node
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setVisible(true);
		Bounds bounds=NotationFactory.eINSTANCE.createBounds();
		bounds.setX(position.x);
		bounds.setY(position.y);
		bounds.setWidth(30);
		bounds.setHeight(15);
		node.setLayoutConstraint(bounds);
		TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
		ts.setShowTitle(true);
		node.getStyles().add(ts);
		node.setType(""+BehaviorPortEditPart.VISUAL_ID);
		node.setElement(portView.getElement());

		ViewUtil.insertChildView(owner, node, ViewUtil.APPEND, true);

		//create the link
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView((View)owner.getDiagram(), edge, -1, true);
		edge.setType(""+BehaviorPortLinkEditPart.VISUAL_ID);
		IdentityAnchor anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		edge.setSourceAnchor(anchor);
		anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		edge.setTargetAnchor(anchor);
		edge.setSource(portView);
		edge.setTarget(node);
		edge.setElement(portView.getElement());

	}
}
