/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.EObjectValueStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomDurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.command.CreateAppliedStereotypeCommentViewCommand;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypesCommentEditPart;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypesCommentLinkEditPart;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies.AppliedStereotypeCommentCreationEditPolicy;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;


/**
 * Rewrite the CreateAppliedStereotypeCommentViewCommand to create all Comment View on the Interaction, but not the container of current node.
 * 
 * Because we can not add any Node on some container view such as Lifeline.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class AppliedStereotypeCommentCreationEditPolicyEx extends AppliedStereotypeCommentCreationEditPolicy {

	/**
	 * @author Jin Liu (jin.liu@soyatec.com)
	 */
	public class CreateAppliedStereotypeCommentViewCommandEx extends CreateAppliedStereotypeCommentViewCommand {

		/**
		 * Constructor.
		 * 
		 * @param domain
		 * @param owner
		 * @param x
		 * @param y
		 * @param base_Element
		 * @param isABordererElement
		 */
		public CreateAppliedStereotypeCommentViewCommandEx(TransactionalEditingDomain domain, View owner, int x, int y, EObject base_Element, boolean isABordererElement) {
			super(domain, owner, x, y, base_Element, isABordererElement);
		}

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
			View source = owner;
			while(source != null && !(source instanceof Shape || source instanceof Edge)) {
				source = (View)source.eContainer();
			}
			edge.setSource(source);
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
			//			if(owner instanceof Edge) {
			//				View viewSource = ((Edge)owner).getSource();
			//				View viewTarget = ((Edge)owner).getSource();
			//				//list of source parents
			//				ArrayList<View> parentsSource = getParentTree(viewSource);
			//				//list of source targets
			//				ArrayList<View> parentsTarget = getParentTree(viewTarget);
			//				View commonParent = null;
			//				int index = 0;
			//				//find the common
			//				while(commonParent == null && index < parentsSource.size()) {
			//					if(parentsTarget.contains(parentsSource.get(index))) {
			//						commonParent = parentsSource.get(index);
			//						if(!(commonParent instanceof BasicCompartment)) {
			//							commonParent = null;
			//						}
			//					}
			//					index++;
			//				}
			//				// a common has been found
			//				if(commonParent != null) {
			//					((Bounds)commentNode.getLayoutConstraint()).setX(100);
			//					((Bounds)commentNode.getLayoutConstraint()).setY(100);
			//					ViewUtil.insertChildView(commonParent, commentNode, ViewUtil.APPEND, true);
			//					return;
			//				}
			//			}
			//generic case
			View econtainer = (View)owner.eContainer();
			if(owner instanceof Edge) {
				econtainer = (View)((Edge)owner).getSource().eContainer();
				((Bounds)commentNode.getLayoutConstraint()).setX(100);
				((Bounds)commentNode.getLayoutConstraint()).setY(100);
				while(econtainer instanceof Edge) {
					econtainer = (View)((Edge)econtainer).getSource().eContainer();
				}
			}
			//for the case of a port
			if(isBorderedElement) {
				if(econtainer.eContainer() != null) {
					econtainer = (View)econtainer.eContainer();
				}
			}
			//Ignore to create on self container.
			if(ViewUtil.resolveSemanticElement(owner) == ViewUtil.resolveSemanticElement(econtainer)) {
				econtainer = (View)econtainer.eContainer();
			}
			//We should NOT add any child to Lifeline Directly.
			while(econtainer != null && (ViewUtil.resolveSemanticElement(econtainer) instanceof Lifeline || ViewUtil.resolveSemanticElement(econtainer) instanceof CombinedFragment || ViewUtil.resolveSemanticElement(econtainer) instanceof InteractionOperand)) {
				econtainer = (View)econtainer.eContainer();
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

	protected void executeAppliedStereotypeCommentCreation(final EditPart editPart, final TransactionalEditingDomain domain, final EObject semanticElement) {
		try {
			domain.runExclusive(new Runnable() {

				public void run() {
					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							int x = 200;
							int y = 100;
							if(editPart.getModel() instanceof Node) {
								LayoutConstraint constraint = ((Node)editPart.getModel()).getLayoutConstraint();
								if(constraint instanceof Bounds) {
									x = x + ((Bounds)constraint).getX();
									y = ((Bounds)constraint).getY();
								}

							}
							if(editPart.getModel() instanceof Edge && ((((Edge)editPart.getModel()).getSource()) instanceof Node)) {

								LayoutConstraint constraint = ((Node)((Edge)editPart.getModel()).getSource()).getLayoutConstraint();
								if(constraint instanceof Bounds) {
									x = x + ((Bounds)constraint).getX();
									y = ((Bounds)constraint).getY() - 100;
								}

							}
							boolean isBorderElement = false;
							if(!(editPart instanceof CustomDurationConstraintEditPart)) {
								if(editPart instanceof BorderedBorderItemEditPart) {
									isBorderElement = true;
								}
							}
							if(getAppliedStereotypeCommentNode() == null) {
								CreateAppliedStereotypeCommentViewCommandEx command = new CreateAppliedStereotypeCommentViewCommandEx(domain, (View)editPart.getModel(), x, y, semanticElement, isBorderElement);
								//use to avoid to put it in the command stack
								Map<String, Boolean> options = new HashMap<String, Boolean>();
								options.put(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
								try {
									InternalTransaction it = ((InternalTransactionalEditingDomain)domain).startTransaction(false, options);
									command.execute();
									it.commit();
								} catch (Exception e) {
									Activator.log.error(e);
								}
							}
						}

					});
				}
			});
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}

	protected Node getAppliedStereotypeCommentNode() {
		Node node = super.getAppliedStereotypeCommentNode();
		if(node != null) {
			return node;
		}
		View view = (View)getHost().getModel();
		View semanticView = view;
		while(semanticView != null && !(semanticView instanceof Shape || semanticView instanceof Edge)) {
			semanticView = (View)semanticView.eContainer();
		}
		if(semanticView == null) {
			return null;
		}
		Edge appliedStereotypeLink = null;
		//look for all links with the id AppliedStereotypesCommentLinkEditPart.ID
		@SuppressWarnings("unchecked")
		Iterator<Edge> edgeIterator = semanticView.getSourceEdges().iterator();
		while(edgeIterator.hasNext()) {
			Edge edge = (Edge)edgeIterator.next();
			if(edge.getType().equals(AppliedStereotypesCommentLinkEditPart.ID)) {
				appliedStereotypeLink = edge;
			}

		}
		if(appliedStereotypeLink == null) {
			return null;
		}
		return (Node)appliedStereotypeLink.getTarget();

	}
}
