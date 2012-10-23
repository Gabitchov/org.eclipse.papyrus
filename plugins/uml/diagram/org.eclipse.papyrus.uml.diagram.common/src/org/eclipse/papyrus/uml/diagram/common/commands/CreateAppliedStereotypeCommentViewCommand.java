/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.commands;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.EObjectValueStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.editparts.AppliedStereotypesCommentEditPart;
import org.eclipse.papyrus.uml.diagram.common.editparts.AppliedStereotypesCommentLinkEditPart;

/**
 * the goal of this command is to create a comment in the notation that represent a compartment of stereotypes
 *
 */
public class CreateAppliedStereotypeCommentViewCommand extends RecordingCommand {
	
	protected View owner;
	protected EObject base_element;
	protected int x;
	protected int y;
	protected TransactionalEditingDomain domain;
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param domain
	 * @param owner
	 * @param StereotypeApplication
	 * @param displayit
	 */
	public CreateAppliedStereotypeCommentViewCommand(TransactionalEditingDomain domain,View owner,int x, int y, EObject base_Element) {
		super(domain);
		this.owner = owner;
		this.base_element=base_Element;
		this.x=x;
		this.y=y;
		this.domain= domain;
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public void doExecute() {
		
		//create the node
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setVisible(true);
		Bounds bounds=NotationFactory.eINSTANCE.createBounds();
		bounds.setX(x);
		bounds.setY(y);
		node.setLayoutConstraint(bounds);
		TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
		ts.setShowTitle(true);
		node.getStyles().add(ts);
		node.setElement(null);
		node.setType(AppliedStereotypesCommentEditPart.ID);
		ViewUtil.insertChildView((View)owner.eContainer(), node, ViewUtil.APPEND, true);
		
		
		EObjectValueStyle eObjectValueStyle=(EObjectValueStyle)node.createStyle(NotationPackage.eINSTANCE.getEObjectValueStyle());
		eObjectValueStyle.setEObjectValue(base_element);
		eObjectValueStyle.setName("BASE_ELEMENT");
		
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
		edge.setType(AppliedStereotypesCommentLinkEditPart.ID);
		edge.setElement(base_element);
		IdentityAnchor anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		edge.setSourceAnchor(anchor);
		anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		edge.setTargetAnchor(anchor);
		edge.setSource(owner);
		edge.setTarget(node);
		edge.setElement(null);
		eObjectValueStyle=(EObjectValueStyle)edge.createStyle(NotationPackage.eINSTANCE.getEObjectValueStyle());
		eObjectValueStyle.setEObjectValue(base_element);
		eObjectValueStyle.setName("BASE_ELEMENT");
		
		//copy EAnnotation
		final EAnnotation stereotypeAnnotation=owner.getEAnnotation(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		EAnnotation stereotypeAnnotationCopy=EcoreUtil.copy(stereotypeAnnotation);
		node.getEAnnotations().add(stereotypeAnnotationCopy);
		RecordingCommand cmd=AppliedStereotypeHelper.getSetAppliedStereotypePropertiesLocalizationCommand(domain, node, UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION);
		cmd.execute();
		
		String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(node);
		cmd =AppliedStereotypeHelper.getRemoveAppliedStereotypeCommand(domain, node, AppliedStereotypeHelper.getStereotypesToDisplay(node), presentationKind);
		cmd.execute();
	}

}
