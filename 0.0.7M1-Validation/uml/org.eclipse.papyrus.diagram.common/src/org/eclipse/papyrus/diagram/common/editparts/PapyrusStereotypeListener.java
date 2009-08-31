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
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.core.listenerservice.IPapyrusListener;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.internal.impl.ElementImpl;

/**
 * Listener for stereotypes application/deapplication
 * 
 * @author remi.schnekenburger@cea.fr
 */
public class PapyrusStereotypeListener implements IPapyrusListener {

	/**
	 * An {@link Notification#getEventType event type} indicating that a stereotype has been applied
	 * to the notifier
	 * 
	 * @see Notification#getEventType
	 */
	public static final int APPLIED_STEREOTYPE = 20;

	/**
	 * An {@link Notification#getEventType event type} indicating that a stereotype has been
	 * unapplied to the notifier
	 * 
	 * @see Notification#getEventType
	 */
	public static final int UNAPPLIED_STEREOTYPE = 21;

	/**
	 * Creates a new PapyrusStereotypeListener.
	 */
	public PapyrusStereotypeListener() {
	}

	/**
	 * {@inheritDoc}
	 */
	public void notifyChanged(Notification notification) {
		// feature should be the base_class feature
		// check this is a EStructuralFeature that is changed. Could be something else ?!
		final EStructuralFeature feature;

		if (notification.getFeature() == null) {
			return;
		}
		if (!(notification.getFeature() instanceof EStructuralFeature)) {
			return;
		}

		feature = (EStructuralFeature) notification.getFeature();

		if (!isBaseElementChanged(feature)) {
			return;
		}

		// if (!notification.getFeature().getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
		//
		// }
		// check the SET base Element for stereotype elements.... if this is this kind of element
		if (Notification.SET != notification.getEventType()) {
			return;
		}

		// should retrieve the element on which modification is done. This should be the new value
		// of the notification
		Object newValue = notification.getNewValue(); // this should be the stereotyped element
		if (!(newValue instanceof Element)) {
			return;
		}

		// check the notifier (stereotype application) is in the list of the stereotype for the
		// element
		boolean isAStereotype = ((Element) newValue).getStereotypeApplications().contains(notification.getNotifier());
		if (!isAStereotype) {
			return;
		}

		// we are sure this is a new stereotype application => the element should yield it has been
		// changed, so its edit parts can react
		StereotypeCustomNotification newNotification = new StereotypeCustomNotification((ElementImpl) newValue,
				APPLIED_STEREOTYPE, feature.getFeatureID(), null, notification.getNotifier());
		((Element) newValue).eNotify(newNotification);
	}

	/**
	 * checks if the notifier modified feature is the feature modified by stereotype applications
	 * 
	 * @return <code>true</code> if the feature of the notification is the "base_XXX" feature, else
	 *         return <code>false</code>.
	 */
	private boolean isBaseElementChanged(EStructuralFeature feature) {
		return feature.getName().startsWith(Extension.METACLASS_ROLE_PREFIX);
		// && (element == null || eStructuralFeature.getEType().isInstance(element))) {
	}

	/**
	 * Specific notification handled by this listener.
	 * <p>
	 * It implements the {@link ENotificationImpl} notification, as it is filtered bye GMF. It
	 * should be possible to further inspect how notification are filtered, and so, do not use
	 * hidden APIs.
	 * </p>
	 */
	public class StereotypeCustomNotification extends ENotificationImpl {

		/**
		 * Creates a new StereotypeCustomeNotification
		 * 
		 * @param notifier
		 *            the notifier that sends this notification
		 * @param eventType
		 *            the type of event
		 * @param featureID
		 *            the kind of feature modified that caused this modification
		 * @param oldValue
		 *            the old value of the modified feature
		 * @param newValue
		 *            the new value of the modified feature
		 */
		public StereotypeCustomNotification(ElementImpl notifier, int eventType, int featureID, Object oldValue,
				Object newValue) {
			super(notifier, eventType, featureID, oldValue, newValue);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isTouch() {
			return false;
		}

	}
}
