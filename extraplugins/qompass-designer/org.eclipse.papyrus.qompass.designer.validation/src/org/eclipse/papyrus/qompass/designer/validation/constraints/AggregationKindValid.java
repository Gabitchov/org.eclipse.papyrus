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
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import org.eclipse.papyrus.qompass.designer.core.Utils;

/**
 * Verify that aggregation kinds are used well. General rule:
 * attributes of a components should have aggregation kind "composite" unless
 * (1) the are singletons (implementation property), i.e. there is exactly one instance.
 * (2) they are *shared*. In this case an enclosing component has to define a property of same type
 * and name (open if "same name" restriction is kept, since it implies an implicit relationship
 * that would break after name changes. But it allows for having multiple shared properties of same type)
 * [it does not make a difference, whether "aggregation" or "none" is used as aggregation kind]
 * Alternative? give user a fine control in the instantiation model? Fractal: no need for a single
 * composed property?
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
				if(Utils.isSingleton((Class)type)) {
					// no composition, but not singleton: warn user to make up a proper deployment plan
					return ctx.createFailureStatus("The attribute '" + attribute.getName() + "' has a non-composition aggregation kind, but the referenced type ('" + type.getName() + "') is not a singleton. The associated instance specifications have to be set-up manually");
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
