/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.databinding;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.uml2.uml.Element;

/**
 * An Abstract implementation of a stereotype application listener.
 * This object will listener on
 * 
 * @author Camille Letavernier
 * 
 */
public abstract class AbstractStereotypeListener implements Adapter {

	private Element umlElement;

	private Notifier target;

	/**
	 * Constructors
	 * 
	 * Adds a Stereotype application listener to the given UML Element
	 * 
	 * @param umlElement
	 *        The observed UML Element
	 */
	public AbstractStereotypeListener(Element umlElement) {
		this.umlElement = umlElement;
		umlElement.eAdapters().add(this);
		for(EObject eObject : umlElement.getStereotypeApplications()) {
			eObject.eAdapters().add(this);
		}
	}

	public void notifyChanged(Notification notification) {
		final int eventType = notification.getEventType();

		if(eventType == PapyrusStereotypeListener.APPLIED_STEREOTYPE) {
			// a stereotype was applied to the notifier
			// then a new listener should be added to the stereotype application
			((EObject)notification.getNewValue()).eAdapters().add(this);
			handleAppliedStereotype((EObject)notification.getNewValue());
		} else if(eventType == PapyrusStereotypeListener.UNAPPLIED_STEREOTYPE) {
			((EObject)notification.getNewValue()).eAdapters().remove(this);
			handleUnappliedStereotype((EObject)notification.getNewValue());
		}
	}

	/**
	 * Notifies this listener that a stereotype has been unapplied from
	 * the observed UML Element
	 * 
	 * @param unappliedStereotype
	 *        The stereotype which has been unapplied
	 */
	protected abstract void handleUnappliedStereotype(EObject unappliedStereotype);

	/**
	 * Notifies this listener that a stereotype has been applied from
	 * the observed UML Element
	 * 
	 * @param appliedStereotype
	 *        The new applied stereotype
	 */
	protected abstract void handleAppliedStereotype(EObject appliedStereotype);

	public Notifier getTarget() {
		return target;
	}

	public void setTarget(Notifier newTarget) {
		this.target = newTarget;
	}

	public boolean isAdapterForType(Object type) {
		return false;
	}

	/**
	 * Disposes this stereotype application listener
	 */
	public void dispose() {
		umlElement.eAdapters().remove(this);
		for(EObject eObject : umlElement.getStereotypeApplications()) {
			eObject.eAdapters().remove(this);
		}
	}
}
