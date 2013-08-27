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

package org.eclipse.papyrus.qompass.designer.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.papyrus.FCM.ConfigurationProperty;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;

/**
 * check whether an instance specification for a classifier defines slots for
 * each configuration attribute. This rule is specific to Qompass, since only
 * attributes with the ConfigurationProperty stereotypes are checked.
 */
public class InstanceSpecificationSlotForAllProperties extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		InstanceSpecification is = (InstanceSpecification) ctx.getTarget();

		if (is.getClassifiers().size() > 0) {
			Classifier cl = is.getClassifiers().get(0);
			if (cl instanceof Class) {
				Class class_ = (Class) cl;
			
				for (Property attribute : class_.getOwnedAttributes ()) {
					boolean foundAttribute = false;
					if (StUtils.isApplied(attribute, ConfigurationProperty.class)) {
						for (Slot slot : is.getSlots ()) {
							if (slot.getDefiningFeature () == attribute) {
								foundAttribute = true;
								break;
							}
						}
						if (foundAttribute == false) {
							return ctx.createFailureStatus ("The instance specification '" + is.getName () + "' has no slot for property '" + attribute.getName () + "'");
						}
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
