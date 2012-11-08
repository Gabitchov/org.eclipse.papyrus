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
package org.eclipse.papyrus.uml.table.efacet.common.listener;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * This listener allows us to update the ProfileFacetSet when a profile has changes
 * 
 */
public class ApplyProfileTriggerListener extends TriggerListener {

	@Override
	protected Command trigger(TransactionalEditingDomain domain, Notification notification) {
		if(notification.getFeature() == UMLPackage.eINSTANCE.getProfileApplication_AppliedProfile()) {
			//TODO
		}
		return null;
	}
}
