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
import org.eclipse.papyrus.FCM.DerivedElement;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;

/**
 * Check whether an element within a package template is referenced via a type from the outside, i.e. an element that is not
 * within this package template. This reference is only valid in the context of a template binding.
 * (within Qompass, binding is done implicitly via stereotypes - which was perhaps not the best way of doing it)
 * 
 * The rule has been made specific to Qompass by checking whether FCM is applied (check DerivedElement stereotype).
 *
 */
public class TemplateRefWithoutBinding extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		TypedElement te = (TypedElement)ctx.getTarget();
		Type type = te.getType();
		if (type != null) {
			Element owner = type.getNearestPackage();
			while (owner != null) {
				if (owner instanceof Package) {
					Package pkg = (Package) owner;
					if (TemplateUtils.getSignatureDirect(pkg) != null) {
						if (StereotypeUtil.isApplicable(pkg, DerivedElement.class) && !isWithin(pkg, te)) {
							// the type of an element is defined within a package template (pkg), but the typed element (te) itself
							// is defined outside of this package
							return ctx.createFailureStatus("This element is typed with '" + type.getQualifiedName() + "', but defined outside the package template '" + //$NON-NLS-1$ //$NON-NLS-2$
									pkg.getQualifiedName() + "'"); //$NON-NLS-1$
						}
					}
				}
				owner = owner.getOwner();
			}
		}
		
		return ctx.createSuccessStatus();
	}
	
	/**
	 * @param pkg A UML package  
	 * @param e an element that is eventually part of the package
	 * @return if passed element is part of the given package
	 */
	public boolean isWithin(Package pkg, Element e) {
		Element owner = e;
		while (owner != null) {
			owner = owner.getOwner();
			if (owner == pkg) {
				return true;
			}
		}
		return false;
	}
}
