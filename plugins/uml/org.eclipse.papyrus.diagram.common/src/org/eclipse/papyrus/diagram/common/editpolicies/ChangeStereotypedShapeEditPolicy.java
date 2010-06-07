/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.diagram.common.editpolicies;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.diagram.common.editparts.AbstractShapeEditPart;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.uml2.uml.Element;


public abstract class ChangeStereotypedShapeEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {


	/** constant for this edit policy role */
	public final static String CHANGE_SHAPE_POLICY = "CHANGE_SHAPE_POLICY";

	/** host semantic element */
	protected Element hostSemanticElement;

	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public ChangeStereotypedShapeEditPolicy() {
		super();
	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * Returns the uml element controlled by the host edit part
	 * 
	 * @return the uml element controlled by the host edit part
	 */
	protected Element getUMLElement() {
		return (Element)getView().getElement();
	}

	/**
	 * Returns the view controlled by the host edit part
	 * 
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View)getHost().getModel();
	}

	/**
	 * 
	 * {@inheritedDoc}
	 */
	public void notifyChanged(Notification notification) {
		// change the label of the figure managed by the host edit part (managed by the parent edit
		// part in general...)
		// it must be changed only if:
		// - the annotation corresponding to the display of the stereotype changes
		// - the stereotype application list has changed
	

		// if element that has changed is a stereotype => refresh the label.
		if(notification.getNotifier() instanceof EAnnotation) {
			if(VisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION == ((EAnnotation)notification.getNotifier()).getSource()) {
				// stereotype annotation has changed => refresh label display
				//add a test about kind old value 
				if (!(getHost() instanceof AbstractShapeEditPart) &&AppliedStereotypeHelper.getAppliedStereotypePresentationKind(getView())== VisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION){
					if(notification.getNewValue() instanceof Map.Entry<?, ?>){
						if(((Map.Entry<?, ?>)notification.getNewValue()).getKey().equals(VisualInformationPapyrusConstant.STEREOTYPE_PRESENTATION_KIND)){
							transformIntoShape(getHost());
						}
					}
				}
				if ((getHost() instanceof AbstractShapeEditPart) && AppliedStereotypeHelper.getAppliedStereotypePresentationKind(getView())!= VisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION){
					if(notification.getNewValue() instanceof Map.Entry<?, ?>){
						if(((Map.Entry<?, ?>)notification.getNewValue()).getKey().equals(VisualInformationPapyrusConstant.STEREOTYPE_PRESENTATION_KIND)){
							transformIntoNormalShape(getHost());
						}
					}
				}
			}
		}
	}
	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}
		hostSemanticElement = getUMLElement();

		// adds a listener on the view and the element controlled by the editpart
		getDiagramEventBroker().addNotificationListener(view, this);

		if(hostSemanticElement == null) {
			return;
		}
		getDiagramEventBroker().addNotificationListener(hostSemanticElement, this);

		// adds the listener for stereotype application and applied stereotypes
		// add listener to react to the application and remove of a stereotype

		// add a lister to each already applied stereotyped
		for(EObject stereotypeApplication : hostSemanticElement.getStereotypeApplications()) {
			getDiagramEventBroker().addNotificationListener(stereotypeApplication, this);
		}


	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}

		getDiagramEventBroker().removeNotificationListener(view, this);

		if(hostSemanticElement == null) {
			return;
		}
		// remove listeners to applied stereotyped
		for(EObject stereotypeApplication : hostSemanticElement.getStereotypeApplications()) {
			getDiagramEventBroker().removeNotificationListener(stereotypeApplication, this);
		}
		// remove notification on element
		getDiagramEventBroker().removeNotificationListener(hostSemanticElement, this);

		// removes the reference to the semantic element
		hostSemanticElement = null;
	}
	/**
	 * implementation to transform this editpart into shape from the stereotype
	 * @param part the graphical editpart to change
	 */
	public  abstract void transformIntoShape(EditPart part);
	
	
	/**
	 * implementation to transform a shape editpart into normal editpart
	 * @param part the graphical editpart to change
	 */
	public abstract void transformIntoNormalShape(EditPart part);
}
