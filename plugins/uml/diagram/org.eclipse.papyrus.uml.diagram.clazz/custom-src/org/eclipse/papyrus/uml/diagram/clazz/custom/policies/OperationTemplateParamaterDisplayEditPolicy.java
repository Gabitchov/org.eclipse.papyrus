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
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * It is used to refresh the label of all operation parameter element
 */
public class OperationTemplateParamaterDisplayEditPolicy extends TemplateParamaterDisplayEditPolicy {

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
		hostSemanticElement = initSemanticElement();
		if(hostSemanticElement != null) {
			// adds a listener on the view and the element controlled by the editpart
			getDiagramEventBroker().addNotificationListener(view, this);
			getDiagramEventBroker().addNotificationListener(hostSemanticElement, this);
			if(((TemplateParameter)hostSemanticElement).getParameteredElement() != null) {
				getDiagramEventBroker().addNotificationListener(((TemplateParameter)hostSemanticElement).getParameteredElement(), this);
			}
			if(((TemplateParameter)hostSemanticElement).getDefault() != null) {
				getDiagramEventBroker().addNotificationListener(((TemplateParameter)hostSemanticElement).getDefault(), this);
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
		if(view == null) {
			return;
		}
		// remove notification on element and view
		getDiagramEventBroker().removeNotificationListener(view, this);
		if(hostSemanticElement != null) {
			getDiagramEventBroker().removeNotificationListener(hostSemanticElement, this);
		}
		if(((TemplateParameter)hostSemanticElement).getParameteredElement() != null) {
			getDiagramEventBroker().removeNotificationListener(((TemplateParameter)hostSemanticElement).getParameteredElement(), this);
			if(((TemplateParameter)hostSemanticElement).getParameteredElement() instanceof Operation) {
				Operation op = (Operation)((TemplateParameter)hostSemanticElement).getParameteredElement();
				Iterator<Parameter> iter = op.getOwnedParameters().iterator();
				while(iter.hasNext()) {
					Parameter param = iter.next();
					getDiagramEventBroker().removeNotificationListener(param, this);
				}
			}
		}
		if(((TemplateParameter)hostSemanticElement).getDefault() != null) {
			getDiagramEventBroker().removeNotificationListener(((TemplateParameter)hostSemanticElement).getDefault(), this);
			if(((TemplateParameter)hostSemanticElement).getDefault() instanceof Operation) {
				Operation op = (Operation)((TemplateParameter)hostSemanticElement).getDefault();
				Iterator<Parameter> iter = op.getOwnedParameters().iterator();
				while(iter.hasNext()) {
					Parameter param = iter.next();
					getDiagramEventBroker().removeNotificationListener(param, this);
				}
			}
		}
		// removes the reference to the semantic element
		hostSemanticElement = null;
	}

	public void notifyChanged(Notification notification) {
		if(notification.getEventType() == Notification.SET) {
			if(notification.getFeature().equals(UMLPackage.eINSTANCE.getTemplateParameter_ParameteredElement())) {
				//add a listener
				getDiagramEventBroker().addNotificationListener(((TemplateParameter)hostSemanticElement).getParameteredElement(), this);
				if(((TemplateParameter)hostSemanticElement).getParameteredElement() instanceof Operation) {
					Operation op = (Operation)((TemplateParameter)hostSemanticElement).getParameteredElement();
					Iterator<Parameter> iter = op.getOwnedParameters().iterator();
					while(iter.hasNext()) {
						Parameter param = iter.next();
						getDiagramEventBroker().addNotificationListener(param, this);
					}
				}
			}
			if(notification.getFeature().equals(UMLPackage.eINSTANCE.getTemplateParameter_Default())) {
				getDiagramEventBroker().addNotificationListener(((TemplateParameter)hostSemanticElement).getDefault(), this);
				if(((TemplateParameter)hostSemanticElement).getDefault() instanceof Operation) {
					Operation op = (Operation)((TemplateParameter)hostSemanticElement).getDefault();
					Iterator<Parameter> iter = op.getOwnedParameters().iterator();
					while(iter.hasNext()) {
						Parameter param = iter.next();
						getDiagramEventBroker().addNotificationListener(param, this);
					}
				}
			}
			if(notification.getFeature().equals(UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter())) {
				if(notification.getNewValue() != null) {
					getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), this);
				} else {
					getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
				}
			}
		}
		if(notification.getEventType() == Notification.REMOVE) {
			if(notification.getFeature().equals(UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter())) {
				getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
			}
		}
		refreshDisplay();
	}
}
