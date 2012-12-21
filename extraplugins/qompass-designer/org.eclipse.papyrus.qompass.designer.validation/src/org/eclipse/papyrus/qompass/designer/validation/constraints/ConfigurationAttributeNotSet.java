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
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;

import FCM.ConfigurationProperty;

import org.eclipse.papyrus.qompass.designer.core.StUtils;

/**
 * Verify if all configuration attribute have a (user-provided) value.
 * @author ansgar
 *
 * TODO: implementation assumes that at least the slot exists
 */
public class ConfigurationAttributeNotSet extends AbstractModelConstraint {
	
	@Override
	public IStatus validate (IValidationContext ctx)
	{
		Slot slot = (Slot) ctx.getTarget();
		StructuralFeature feature = slot.getDefiningFeature ();
		if ((feature != null) && (StUtils.isApplied (feature, ConfigurationProperty.class))) {
			if (slot.getValues ().size () == 0) {
				return ctx.createFailureStatus ("The attribute '" + feature.getName () + "' is tagged as a configuration property, but the associated slot has no value.");
			}
		}
		return ctx.createSuccessStatus();
	}
}
