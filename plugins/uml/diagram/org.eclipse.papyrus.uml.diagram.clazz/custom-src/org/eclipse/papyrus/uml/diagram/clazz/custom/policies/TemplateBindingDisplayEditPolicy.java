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

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * It is used to refresh the label of substitution element
 */
public class TemplateBindingDisplayEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	public static String TEMPLATE_PARAMETER_DISPLAY = "TEMPLATE_SUBSTITUION_DISPLAY";

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
			if (((TemplateBinding) hostSemanticElement).getParameterSubstitutions().size() > 0) {
				Iterator<TemplateParameterSubstitution> iter = ((TemplateBinding) hostSemanticElement).getParameterSubstitutions().iterator();
				while (iter.hasNext()) {
					TemplateParameterSubstitution substitution = iter.next();
					// add a listener on the substitution and its references in order to have a correct refresh
					getDiagramEventBroker().addNotificationListener(substitution, this);
					if (substitution.getFormal() != null && substitution.getFormal().getParameteredElement() instanceof NamedElement) {
						getDiagramEventBroker().addNotificationListener(((NamedElement) substitution.getFormal().getParameteredElement()), this);
					}
					if (substitution.getActual() instanceof NamedElement) {
						getDiagramEventBroker().addNotificationListener(substitution.getActual(), this);
					}
				}
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
		getDiagramEventBroker().removeNotificationListener(hostSemanticElement, this);
		if (((TemplateBinding) hostSemanticElement).getParameterSubstitutions().size() > 0) {
			Iterator<TemplateParameterSubstitution> iter = ((TemplateBinding) hostSemanticElement).getParameterSubstitutions().iterator();
			while (iter.hasNext()) {
				TemplateParameterSubstitution substitution = iter.next();
				getDiagramEventBroker().removeNotificationListener(substitution, this);
			}
		}
		// removes the reference to the semantic element
		hostSemanticElement = null;
	}

	protected void refreshDisplay() {
		getHost().refresh();
	}

	public void notifyChanged(Notification notification) {
		if (notification.getEventType() == Notification.SET && notification.getNotifier() instanceof TemplateParameterSubstitution) {
			if (notification.getFeature().equals(UMLPackage.eINSTANCE.getTemplateParameterSubstitution_Actual())) {
				getDiagramEventBroker().addNotificationListener((EObject) notification.getNewValue(), this);
			}
			if (notification.getFeature().equals(UMLPackage.eINSTANCE.getTemplateParameterSubstitution_Formal())) {
				getDiagramEventBroker().addNotificationListener(((TemplateParameter) notification.getNewValue()).getParameteredElement(), this);
			}
		}
		if (notification.getEventType() == Notification.ADD) {
			if (notification.getFeature().equals(UMLPackage.eINSTANCE.getTemplateBinding_ParameterSubstitution())) {
				// add a listener on the substitution and its references in order to have a correct refresh
				TemplateParameterSubstitution substitution = (TemplateParameterSubstitution) notification.getNewValue();
				getDiagramEventBroker().addNotificationListener(substitution, this);
				if (substitution.getFormal() != null && substitution.getFormal().getParameteredElement() instanceof NamedElement) {
					getDiagramEventBroker().addNotificationListener(((NamedElement) substitution.getFormal().getParameteredElement()), this);
				}
				if (substitution.getActual() instanceof NamedElement) {
					getDiagramEventBroker().addNotificationListener(substitution.getActual(), this);
				}
			}
		}
		if (notification.getEventType() == Notification.REMOVE) {
			if (notification.getFeature().equals(UMLPackage.eINSTANCE.getTemplateBinding_ParameterSubstitution())) {
				// add a listener
				TemplateParameterSubstitution substitution = (TemplateParameterSubstitution) notification.getNewValue();
				getDiagramEventBroker().removeNotificationListener(substitution, this);
				if (substitution.getFormal() != null && substitution.getFormal().getParameteredElement() instanceof NamedElement) {
					getDiagramEventBroker().removeNotificationListener(((NamedElement) substitution.getFormal().getParameteredElement()), this);
				}
				if (substitution.getActual() instanceof NamedElement) {
					getDiagramEventBroker().removeNotificationListener(substitution.getActual(), this);
				}
			}
		}
		refreshDisplay();
	}
}
