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

import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.sync.CompImplSync;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;


/**
 * Update derived interfaces of ports. This is required, since the Copier does not follow references
 * that are referenced via a derived attribute. Derived attributes are used for provided and required
 * interfaces in the stereotype attributes of an FCM port. Thus, required (derived) interfaces would be
 * unavailable in the copy, if not explicitly updated.
 * However, the provided interface is not concerned as it appears in an "implements" relation. If the
 * port is connected, the used interface of one port is the provided interface of the port counter part.
 * Thus, the explicit update done by this function is not needed in most cases.
 *
 * see also FixTemplateSync (remove the latter?)
 */
public class UpdateDerivedInterfaces {
	public static void updateIntfs(InstanceSpecification instance) {
		Classifier cl = DepUtils.getClassifier(instance);
		if (cl instanceof Class) {
			Class implementation = (Class) cl;
			CompImplSync.updatePorts(implementation);
			CompImplSync.syncRealizations(implementation);
		}
		for (Slot slot : instance.getSlots()) {
			InstanceSpecification subInstance = DepUtils.getInstance(slot);
			if (!DepUtils.isShared(slot) && (subInstance != null)) {
				updateIntfs(subInstance);
			}
		}
	}
}
