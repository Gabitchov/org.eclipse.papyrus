/*******************************************************************************
 * Copyright (c) 2008-2010 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.qompass.designer.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.papyrus.FCM.ConfigurationProperty;
import org.eclipse.papyrus.qompass.designer.core.StUtils;

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
