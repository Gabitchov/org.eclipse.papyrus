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
import org.eclipse.papyrus.qompass.designer.core.extensions.InstanceConfigurator;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;


/**
 * Apply instance configurators
 *
 */
public class ApplyInstanceConfigurators {
	public static void applyInstanceConfigurators(InstanceSpecification instance) {
		for (Slot slot : instance.getSlots()) {
			InstanceSpecification subInstance = DepUtils.getInstance(slot);
			if (!DepUtils.isShared(slot) && (subInstance != null)) {
				if (slot.getDefiningFeature() instanceof Property) {
					InstanceConfigurator.configureInstance(subInstance, (Property) slot.getDefiningFeature(), instance);
				}
				applyInstanceConfigurators(subInstance);
			}
		}
	}
}
