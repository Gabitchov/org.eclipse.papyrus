/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.constraints;

import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * A constraint to test if the given object is a UML Element and
 * has the given Stereotype
 * 
 * @author Camille Letavernier
 */
public class HasStereotypeConstraint extends AbstractConstraint {

	/**
	 * The name of the stereotype to look for
	 */
	protected String stereotypeName;

	/**
	 * The UML element on which the stereotype may be applied
	 */
	protected Element umlElement;

	@Override
	public boolean match(Object selection) {
		umlElement = UMLUtil.resolveUMLElement(selection);
		if(umlElement == null) {
			return false;
		}

		Stereotype stereotype = UMLUtil.getAppliedStereotype(umlElement, stereotypeName, false);
		return stereotype != null;
	}

	@Override
	public void setDescriptor(SimpleConstraint descriptor) {
		stereotypeName = getValue("stereotypeName"); //$NON-NLS-1$
	}

	@Override
	public boolean overrides(Constraint constraint) {
		boolean overrides = false;

		if(constraint instanceof HasStereotypeConstraint) {
			HasStereotypeConstraint stereotypeConstraint = (HasStereotypeConstraint)constraint;
			if(!stereotypeName.equals(stereotypeConstraint.stereotypeName)) {
				Stereotype thisStereotype = umlElement.getApplicableStereotype(stereotypeName);

				//The otherStereotype can match the constraint without being applicable (e.g. abstract stereotype...)
				//We can't rely on "getApplicableStereotype"
				Stereotype otherStereotype = UMLUtil.findStereotype(umlElement, stereotypeConstraint.stereotypeName);
				//Stereotype otherStereotype = umlElement.getApplicableStereotype(stereotypeConstraint.stereotypeName);
				if(UMLUtil.getAllSuperStereotypes(thisStereotype).contains(otherStereotype)) {
					overrides = true;
				}
			}
		}

		return overrides || super.overrides(constraint);
	}

	@Override
	public String toString() {
		return String.format("HasStereotype %s (%s)", stereotypeName, getDisplayUnit().getElementMultiplicity() == 1 ? "Single" : "Multiple"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Override
	protected boolean equivalent(Constraint constraint) {
		if(this == constraint) {
			return true;
		}
		if(constraint == null) {
			return false;
		}
		if(!(constraint instanceof HasStereotypeConstraint)) {
			return false;
		}
		HasStereotypeConstraint other = (HasStereotypeConstraint)constraint;
		if(stereotypeName == null) {
			if(other.stereotypeName != null) {
				return false;
			}
		} else if(!stereotypeName.equals(other.stereotypeName)) {
			return false;
		}
		return true;
	}
}
