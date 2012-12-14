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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profilefacet.listener;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profilefacet.utils.ProfileFacetSetDestroyer;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;

/**
 * 
 * This trigger listener listen the profile application to manage the existing {@link ProfileFacetSet} in the model
 * 
 */
public class ReapplyProfileTriggerListener extends TriggerListener {

	/**
	 * 
	 * @see org.eclipse.emf.transaction.TriggerListener#trigger(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param domain
	 * @param notification
	 * @return
	 */
	@Override
	protected Command trigger(final TransactionalEditingDomain domain, final Notification notification) {
		final int eventType = notification.getEventType();
		final Object notifier = notification.getNotifier();
		final Object newValue = notification.getNewValue();

		if(eventType == Notification.SET && newValue instanceof EPackage && notifier instanceof EAnnotation) {
			Profile appliedProfile = getAppliedProfile((EAnnotation)notifier);
			while(appliedProfile.eContainer() != null) {
				appliedProfile = (Profile)appliedProfile.eContainer();
			}
			if(appliedProfile != null) {
				return getUpdateFacetSetCommand(appliedProfile);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param profile
	 *        a profile
	 * @return
	 *         the command to update the ProfileFacetSets which references this profile or <code>null</code>
	 */
	protected Command getUpdateFacetSetCommand(final Profile profile) {
		final ProfileFacetSetDestroyer updater = new ProfileFacetSetDestroyer(profile);
		final Command cmd = updater.getDestroyFacetSetCommand();
		if(cmd != null && cmd.canExecute()) {
			return cmd;
		}
		return null;
	}

	/**
	 * 
	 * @param annotation
	 *        an eannotation
	 * @return
	 *         the profile referenced by the eannotation or <code>null</code>
	 */
	protected Profile getAppliedProfile(final EAnnotation annotation) {
		final EObject container = annotation.eContainer();
		if(container instanceof ProfileApplication) {
			return ((ProfileApplication)container).getAppliedProfile();
		}
		return null;
	}

}
