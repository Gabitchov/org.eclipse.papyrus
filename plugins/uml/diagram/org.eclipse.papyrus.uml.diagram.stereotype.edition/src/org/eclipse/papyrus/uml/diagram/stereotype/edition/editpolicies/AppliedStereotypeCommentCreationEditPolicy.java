/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.command.CreateAppliedStereotypeCommentViewCommand;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypesCommentLinkEditPart;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.widgets.Display;

/**
 * This editpolicy has in charge to :
 * - create or destroy the appliedStereotypesCommentEditpart
 * - adapt the information about stereotype display into appliedstereotypeCommentEditPart
 * by using eannotation existing mechanism
 * 
 */
public class AppliedStereotypeCommentCreationEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {


	/** constant for this edit policy role */
	public final static String APPLIED_STEREOTYPE_COMMENT = "Applied_Stereotype_Comment";


	/**
	 * This method has in charge to refresh the presence of the view that represent the comment
	 */
	protected void updateAppliedStereotypeCommentShape() {
		String stereotypeLocalizationToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization((View)getHost().getModel());
		String stereotypePropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay((View)getHost().getModel());
		//look for the AppliedStereotypesCommentEditPart
		if(getAppliedStereotypeCommentNode() == null && (!stereotypePropertiesToDisplay.trim().equals(""))) {
			//test if stereotype has to be display as a comment
			if(stereotypeLocalizationToDisplay.equals(UMLVisualInformationPapyrusConstant.STEREOTYPE_COMMENT_LOCATION)) {

				if(getHost() instanceof ConnectionEditPart) {
					executeAppliedStereotypeCommentCreation((ConnectionEditPart)getHost(), ((ConnectionEditPart)getHost()).getEditingDomain(), ((ConnectionEditPart)getHost()).resolveSemanticElement());
				}

				if(getHost() instanceof GraphicalEditPart) {
					executeAppliedStereotypeCommentCreation((GraphicalEditPart)getHost(), ((GraphicalEditPart)getHost()).getEditingDomain(), ((GraphicalEditPart)getHost()).resolveSemanticElement());
				}
			}
		}
		
		//test if the comment has to be removed
		if(getAppliedStereotypeCommentNode() != null) {
			View commentNode = getAppliedStereotypeCommentNode();
			
			//1. the  display is not comment
			if(!stereotypeLocalizationToDisplay.equals(UMLVisualInformationPapyrusConstant.STEREOTYPE_COMMENT_LOCATION) ) {
				final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(commentNode);
				executeAppliedStereotypeCommentDeletion(domain, commentNode);
			}
			
			//the result of properties to display is null so no compartment will be created
			String todisplay = StereotypeUtil.getPropertiesValues(stereotypePropertiesToDisplay, getUMLElement()); 
			if("".equals(todisplay.trim())) {
				final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(commentNode);
				executeAppliedStereotypeCommentDeletion(domain, commentNode);
			}
		}

	}

	/**
	 * return the number of visible compartment that represent a stereotype
	 * @param view the container view
	 * @param eobject the eobject that represent the container
	 * @return the number of visible stereotype compartment
	 */
	protected int getvisisbleAppliedStereotypeCompartment(View view, EObject eobject) {
		int nbVisibleCompartment = 0;
		@SuppressWarnings("unchecked")
		Iterator<View> iteratorView = view.getChildren().iterator();
		while(iteratorView.hasNext()) {
			View subview = (View)iteratorView.next();
			if(subview.getElement() != null && !subview.getElement().equals(eobject)) {
				nbVisibleCompartment++;
			}
		}
		return nbVisibleCompartment;
	}
/**
 * this method is use to copy all eAnnotation from the view to the comment in order to display properties of stereotype
 */
	protected void delegateEAnnotationInCommentShape() {
		final Node appliedStereotypeComment = getAppliedStereotypeCommentNode();

		if(appliedStereotypeComment != null) {
			View originView = getView();
			final EAnnotation stereotypeAnnotation = originView.getEAnnotation(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);

			final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(originView);
			final RecordingCommand cmd = new RecordingCommand(domain, "EannotationDelegation") {

				@Override
				protected void doExecute() {
					EAnnotation stereotypeAnnotationCopy = EcoreUtil.copy(stereotypeAnnotation);
					appliedStereotypeComment.getEAnnotations().clear();
					appliedStereotypeComment.getEAnnotations().add(stereotypeAnnotationCopy);
					RecordingCommand cmd = AppliedStereotypeHelper.getSetAppliedStereotypePropertiesLocalizationCommand(domain, appliedStereotypeComment, UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION);
					cmd.execute();
					String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(getView());
					cmd = AppliedStereotypeHelper.getRemoveAppliedStereotypeCommand(domain, appliedStereotypeComment, AppliedStereotypeHelper.getStereotypesToDisplay(appliedStereotypeComment), presentationKind);
					cmd.execute();
				}
			};
			
			Display.getCurrent().syncExec(new Runnable() {

				public void run() {
					//use to avoid to put it in the command stack
					try {
						GMFUnsafe.write(domain, cmd);
					} catch (Exception e) {
						Activator.log.error(e);
					}
				}
			});
		}
	}

	/**
	 * return the comment nodes that represent stereotype properties
	 * 
	 * @return may be null if nothing is founded
	 */
	protected Node getAppliedStereotypeCommentNode() {
		View SemanticView = (View)getHost().getModel();

		Edge appliedStereotypeLink = null;
		//look for all links with the id AppliedStereotypesCommentLinkEditPart.ID
		@SuppressWarnings("unchecked")
		Iterator<Edge> edgeIterator = SemanticView.getSourceEdges().iterator();
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

	/**
	 * the goal of this method is to execute the a command to create a notation node for applied stereotype
	 * as "Comment" shape
	 * 
	 * @param editPart
	 *        the semantic Editpart
	 * @param appliedstereotype
	 *        the stereotype application
	 */
	protected void executeAppliedStereotypeCommentCreation(final EditPart editPart, final TransactionalEditingDomain domain, final EObject semanticElement) {
		Display.getCurrent().syncExec(new Runnable() {

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
				if(editPart instanceof BorderedBorderItemEditPart) {
					isBorderElement = true;
				}
				if(getAppliedStereotypeCommentNode() == null) {
					CreateAppliedStereotypeCommentViewCommand command = new CreateAppliedStereotypeCommentViewCommand(domain, (View)editPart.getModel(), x, y, semanticElement, isBorderElement);
					//use to avoid to put it in the command stack
					try {
						GMFUnsafe.write(domain, command);
					} catch (Exception e) {
						Activator.log.error(e);
					}
				}
			}

		});
	}
	/**
	 * method in oder to delete the comment
	 * @param domain the transactional editing domain
	 * @param commentNode the view that represent the comment of stereotype
	 */

	protected void executeAppliedStereotypeCommentDeletion(final TransactionalEditingDomain domain, final View commentNode) {
		Display.getCurrent().syncExec(new Runnable() {

			public void run() {
				//because it is asynchrone the comment node maybe become s null
				if(commentNode != null && TransactionUtil.getEditingDomain(commentNode) != null) {
					DeleteCommand command = new DeleteCommand(commentNode);
					//use to avoid to put it in the command stack
					try {
						GMFUnsafe.write(domain, command);
					} catch (Exception e) {
						Activator.log.error(e);
					}
				}
			}
		});
	}

	/**
	 * 
	 * {@inheritedDoc}
	 */
	@Override
	public void notifyChanged(Notification notification) {
		// change the label of the figure managed by the host edit part (managed
		// by the parent edit
		// part in general...)
		// it must be changed only if:
		// - the annotation corresponding to the display of the stereotype
		// changes
		// - the stereotype application list has changed
		final int eventType = notification.getEventType();
		if(eventType == PapyrusStereotypeListener.APPLIED_STEREOTYPE) {
			// a stereotype was applied to the notifier
			// then a new listener should be added to the stereotype application
			getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), this);
			//createAppliedStereotypeCompartment((EObject)notification.getNewValue());
		} else if(eventType == PapyrusStereotypeListener.UNAPPLIED_STEREOTYPE) {
			getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
			cleanStereotypeDisplayInEAnnotation();
			updateAppliedStereotypeCommentShape();

		}
		// if element that has changed is a stereotype => refresh the label.
		if(notification.getNotifier() instanceof View && (notification.getEventType() == Notification.ADD) && (notification.getNewValue() instanceof EAnnotation)) {
			if(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION == ((EAnnotation)notification.getNewValue()).getSource()) {
				// stereotype annotation has changed => refresh label display
				updateAppliedStereotypeCommentShape();
				delegateEAnnotationInCommentShape();
				//refreshDisplay();
			}
		}
		// if element that has changed is a stereotype => refresh the label.
		if(notification.getNotifier() instanceof EAnnotation && (notification.getEventType() == Notification.ADD)) {
			if(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION == ((EAnnotation)notification.getNotifier()).getSource()) {
				// stereotype annotation has changed => refresh label display
				updateAppliedStereotypeCommentShape();
				delegateEAnnotationInCommentShape();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refreshDisplay() {
		//do nothing
		//refreshStereotypeDisplay();
	}

}
