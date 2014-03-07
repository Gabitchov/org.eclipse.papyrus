/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 402525
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.resource;

import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.cdo.eresource.EresourcePackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.papyrus.commands.NestingNotifyingWorkspaceCommandStack;

import com.google.common.collect.Sets;


/**
 * A CDO-specific command-stack that attaches undo contexts describing object-level
 * details of the scope of a change.
 */
public class CDOAwareCommandStack extends NestingNotifyingWorkspaceCommandStack {

	public CDOAwareCommandStack(IOperationHistory history) {
		super(history);
	}

	protected CDOAwareCommandStack(boolean nested, IOperationHistory history) {
		super(nested, history);
	}

	@Override
	protected NestingNotifyingWorkspaceCommandStack createNestedCommandStack(IOperationHistory history) {
		return new CDOAwareCommandStack(true, history);
	}

	@Override
	protected void hookUndoContexts(IUndoableOperation operation, ResourceSetChangeEvent event) {
		super.hookUndoContexts(operation, event);

		Set<EObject> affectedObjects = Sets.newHashSet();
		for(Notification next : event.getNotifications()) {
			Object notifier = next.getNotifier();

			// don't exclude CDOResources, which are EObjects as well as Resources, unless the change
			// is in some other property than the contents
			if(notifier instanceof EObject) {
				EObject object = (EObject)notifier;
				if(object.eClass() != EresourcePackage.Literals.CDO_RESOURCE) {
					affectedObjects.add(object);
				} else if(next.getFeature() == EresourcePackage.Literals.CDO_RESOURCE__CONTENTS) {
					affectedObjects.add(object);
				}
			}
		}

		if(!affectedObjects.isEmpty()) {
			operation.addContext(new CDOUndoContext(affectedObjects));
		}
	}
}
