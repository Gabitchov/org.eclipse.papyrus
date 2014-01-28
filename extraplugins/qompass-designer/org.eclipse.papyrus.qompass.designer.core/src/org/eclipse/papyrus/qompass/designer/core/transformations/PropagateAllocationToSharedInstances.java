/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.transformations;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.deployment.AllocUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;


/**
 * Propagate allocation to shared instances: if a class references another instance
 * via sharing, the shared instance must be allocated on the node of the referencing
 * class as well.
 *
 */
public class PropagateAllocationToSharedInstances {
	public static void propagateAllocation(InstanceSpecification instance) {
		propagateAllocation(instance, new UniqueEList<InstanceSpecification>());
	}
	
	public static void propagateAllocation(InstanceSpecification instance, EList<InstanceSpecification> nodes) {
		// create copy of node (otherwise, more and more nodes get aggregated. 
		UniqueEList<InstanceSpecification> nodesCopy = new UniqueEList<InstanceSpecification>();
		nodesCopy.addAll(nodes);
		nodesCopy.addAll(AllocUtils.getNodes(instance));
		for (Slot slot : instance.getSlots()) {
			InstanceSpecification subInstance = DepUtils.getInstance(slot);
			if (subInstance != null) {
				if (DepUtils.isShared(slot)) {
					for (InstanceSpecification node : nodesCopy) {
						Log.log(Status.INFO, Log.DEPLOYMENT, String.format("Propagate node allocation: %s to %s", subInstance.getName(), node.getName())); //$NON-NLS-1$
						AllocUtils.allocate(subInstance, node);
					}
				}
				else {
					propagateAllocation(subInstance, nodesCopy);
				}
			}
		}
	}
}
