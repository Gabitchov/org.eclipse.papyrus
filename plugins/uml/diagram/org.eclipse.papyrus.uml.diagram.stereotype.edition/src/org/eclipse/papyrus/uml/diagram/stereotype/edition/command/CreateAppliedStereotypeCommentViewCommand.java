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
package org.eclipse.papyrus.uml.diagram.stereotype.edition.command;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
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
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypesCommentEditPart;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypesCommentLinkEditPart;

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

	protected Boolean isBorderedElement;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 * @param owner
	 * @param StereotypeApplication
	 * @param displayit
	 */
	public CreateAppliedStereotypeCommentViewCommand(TransactionalEditingDomain domain, View owner, int x, int y, EObject base_Element, boolean isABordererElement) {
		super(domain, "CreateAppliedStereotypeCommentView");
		this.owner = owner;
		this.base_element = base_Element;
		this.x = x;
		this.y = y;
		this.domain = domain;
		this.isBorderedElement = isABordererElement;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void doExecute() {

		//create the node
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setVisible(true);
		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setX(x);
		bounds.setY(y);
		node.setLayoutConstraint(bounds);
		TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
		ts.setShowTitle(true);
		node.getStyles().add(ts);
		node.setElement(null);
		node.setType(AppliedStereotypesCommentEditPart.ID);

		connectCommentNode(owner, node);



		EObjectValueStyle eObjectValueStyle = (EObjectValueStyle)node.createStyle(NotationPackage.eINSTANCE.getEObjectValueStyle());
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
		ViewUtil.insertChildView(owner.getDiagram(), edge, -1, true);
		edge.setType(AppliedStereotypesCommentLinkEditPart.ID);
		edge.setElement(base_element);
		IdentityAnchor anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		edge.setSourceAnchor(anchor);
		anchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		edge.setTargetAnchor(anchor);
		edge.setSource(owner);
		edge.setTarget(node);
		edge.setElement(null);
		eObjectValueStyle = (EObjectValueStyle)edge.createStyle(NotationPackage.eINSTANCE.getEObjectValueStyle());
		eObjectValueStyle.setEObjectValue(base_element);
		eObjectValueStyle.setName("BASE_ELEMENT");

		//copy EAnnotation
		final EAnnotation stereotypeAnnotation = owner.getEAnnotation(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		EAnnotation stereotypeAnnotationCopy = EcoreUtil.copy(stereotypeAnnotation);
		node.getEAnnotations().add(stereotypeAnnotationCopy);
		RecordingCommand cmd = AppliedStereotypeHelper.getSetAppliedStereotypePropertiesLocalizationCommand(domain, node, UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION);
		cmd.execute();

		String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(node);
		cmd = AppliedStereotypeHelper.getRemoveAppliedStereotypeCommand(domain, node, AppliedStereotypeHelper.getStereotypesToDisplay(node), presentationKind);
		cmd.execute();
	}

	/**
	 * add the comment node form the owner
	 * 
	 * @param owner
	 *        the view from which we want to display a comment stereotype, cannot be null
	 * @param commentNode
	 *        node that represent the comment , cannot be null
	 */
	private void connectCommentNode(View owner, Node commentNode) {

		//in the case of the edge the comment has to be placed into the common parent of each end
		if(owner instanceof Edge) {
			View viewSource = ((Edge)owner).getSource();
			View viewTarget = ((Edge)owner).getSource();
			//list of source parents
			ArrayList<View> parentsSource = getParentTree(viewSource);
			//list of source targets
			ArrayList<View> parentsTarget = getParentTree(viewTarget);
			View commonParent = null;
			int index = 0;
			//find the common
			while(commonParent == null && index < parentsSource.size()) {
				if(parentsTarget.contains(parentsSource.get(index))) {
					commonParent = parentsSource.get(index);
					if(!(commonParent instanceof BasicCompartment)) {
						commonParent = null;
					}
				}
				index++;
			}
			// a common has been found
			if(commonParent != null) {
				((Bounds)commentNode.getLayoutConstraint()).setX(100);
				((Bounds)commentNode.getLayoutConstraint()).setY(100);
				ViewUtil.insertChildView(commonParent, commentNode, ViewUtil.APPEND, true);
				return;
			}
		}
		//generic case
		View econtainer = (View)owner.eContainer();
		//for the case of a port
		if(isBorderedElement) {
			if(econtainer.eContainer() != null) {
				econtainer = (View)econtainer.eContainer();
			}
		}
		ViewUtil.insertChildView(econtainer, commentNode, ViewUtil.APPEND, true);

	}

	/**
	 * @param view
	 *        the view for which we look for its parents, cannot be null
	 * @return the list of parents of a view
	 */
	private ArrayList<View> getParentTree(View view) {
		ArrayList<View> parents = new ArrayList<View>();
		View currentView = view;
		while(currentView != null) {
			currentView = (View)currentView.eContainer();
			if(currentView != null) {
				if(!(currentView instanceof DecorationNode) && !(currentView instanceof BasicCompartment)) {
					//parents.addAll(currentView.getChildren());
				}
				parents.add(currentView);
			}

		}
		return parents;
	}
}
