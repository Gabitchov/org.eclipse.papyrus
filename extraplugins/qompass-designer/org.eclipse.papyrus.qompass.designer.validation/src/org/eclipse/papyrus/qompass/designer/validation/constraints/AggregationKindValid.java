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
import org.eclipse.papyrus.FCM.ConfigurationProperty;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * Verify that aggregation kinds are used well. General rule:
 * attributes of a components should have aggregation kind "composite" unless
 * (1) the are singletons (implementation property), i.e. there is exactly one instance.
 * 
 * (2) they are *shared*. In this case an enclosing component has to define a property of same type
 * and name (open if "same name" restriction is kept, since it implies an implicit relationship
 * that would break after name changes. But it allows for having multiple shared properties of same type)
 * [it does not make a difference, whether "aggregation" or "none" is used as aggregation kind]
 * Alternative? give user a fine control in the instantiation model? Fractal: no need for a single
 * composed property?
 * 
 * Rule has been made specific to Qompass, since we verify that configurationProperty is applicable (implying that the
 * FCM profile is applied)
 * 
 * @author ansgar
 * 
 */
public class AggregationKindValid extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		Property attribute = (Property)ctx.getTarget();
		Type type = attribute.getType();
		if(type instanceof Class) {
			AggregationKind aggKind = attribute.getAggregation();
			if(aggKind != AggregationKind.COMPOSITE_LITERAL) {
				if (StereotypeUtil.isApplicable(attribute, ConfigurationProperty.class) && !Utils.isSingleton((Class)type)) {
					// no composition, but not singleton: warn user to make up a proper deployment plan
					// validation has been made Qompass specific by checking whether the Configuration attribute is applicable
					
					// first check, if the attribute is referenced by an instance specification (via
					// the defining feature attribute). Otherwise, do not continue, since the warnings might lead to false
					// alerts
					return ctx.createFailureStatus("The attribute '" + attribute.getName() + "' has a non-composition aggregation kind, but the referenced type ('" +
							type.getName() + "') is not a singleton. The associated instance specifications have to be set-up manually");
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
