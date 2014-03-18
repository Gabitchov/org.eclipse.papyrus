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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * It is used to refresh the label of all parameter element
 */
public class TemplateParamaterDisplayEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	public static String TEMPLATE_PARAMETER_DISPLAY = "TEMPLATE_PARAMETER_DISPLAY";

	/**
	 * Stores the semantic element related to the edit policy. If resolveSemanticElement is used, there are problems when the edit part is getting
	 * destroyed, i.e. the link to the semantic element is removed, but the listeners should still be removed
	 */
	protected Element hostSemanticElement;

	/**
	 * Returns the view controlled by the host edit part
	 * 
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View) getHost().getModel();
	}

	/**
	 * Sets the semantic element which is linked to the edit policy
	 * 
	 * @return the element linked to the edit policy
	 */
	protected Element initSemanticElement() {
		return (Element) getView().getElement();
	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if (view == null) {
			return;
		}
		hostSemanticElement = initSemanticElement();
		if (hostSemanticElement != null) {
			// adds a listener on the view and the element controlled by the editpart
			getDiagramEventBroker().addNotificationListener(view, this);
			getDiagramEventBroker().addNotificationListener(hostSemanticElement, this);
			if (((TemplateParameter) hostSemanticElement).getParameteredElement() != null) {
				getDiagramEventBroker().addNotificationListener(((TemplateParameter) hostSemanticElement).getParameteredElement(), this);
			}
			if (((TemplateParameter) hostSemanticElement).getDefault() != null) {
				getDiagramEventBroker().addNotificationListener(((TemplateParameter) hostSemanticElement).getDefault(), this);
			}
			refreshDisplay();
		} else {
			Activator.log.error("No semantic element was found during activation of the mask managed label edit policy", null);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if (view == null) {
			return;
		}
		// remove notification on element and view
		getDiagramEventBroker().removeNotificationListener(view, this);
		if (hostSemanticElement != null) {
			getDiagramEventBroker().removeNotificationListener(hostSemanticElement, this);

			if (((TemplateParameter) hostSemanticElement).getParameteredElement() != null) {
				getDiagramEventBroker().removeNotificationListener(((TemplateParameter) hostSemanticElement).getParameteredElement(), this);
			}
			if (((TemplateParameter) hostSemanticElement).getDefault() != null) {
				getDiagramEventBroker().removeNotificationListener(((TemplateParameter) hostSemanticElement).getDefault(), this);
			}
		}
		// removes the reference to the semantic element
		hostSemanticElement = null;
	}

	protected void refreshDisplay() {
		getHost().refresh();
	}

	public void notifyChanged(Notification notification) {
		if (notification.getEventType() == Notification.SET) {
			if (notification.getFeature().equals(UMLPackage.eINSTANCE.getTemplateParameter_ParameteredElement())) {
				// add a listener
				getDiagramEventBroker().addNotificationListener(((TemplateParameter) hostSemanticElement).getParameteredElement(), this);
			}
			if (notification.getFeature().equals(UMLPackage.eINSTANCE.getTemplateParameter_Default())) {
				getDiagramEventBroker().addNotificationListener(((TemplateParameter) hostSemanticElement).getDefault(), this);
			}
		}
		refreshDisplay();
	}
}
