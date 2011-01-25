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
package org.eclipse.papyrus.properties.uml.constraints;

import org.eclipse.papyrus.properties.constraints.AbstractConstraint;
import org.eclipse.papyrus.properties.contexts.ConfigProperty;
import org.eclipse.papyrus.properties.contexts.ConstraintDescriptor;
import org.eclipse.papyrus.properties.contexts.ValueProperty;
import org.eclipse.papyrus.properties.util.UMLUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


public class HasStereotypeConstraint extends AbstractConstraint {

	private String stereotypeName;

	public HasStereotypeConstraint() {
	}

	public boolean match(Object selection) {
		Element umlElement = UMLUtil.resolveUMLElement(selection);
		if(umlElement == null)
			return false;

		Stereotype stereotype = umlElement.getAppliedStereotype(stereotypeName);
		return stereotype != null;
	}

	@Override
	public void setConstraintDescriptor(ConstraintDescriptor descriptor) {
		super.setConstraintDescriptor(descriptor);

		for(ConfigProperty property : descriptor.getProperties()) {
			if(property.getName().equals("stereotypeName")) { //$NON-NLS-1$
				stereotypeName = ((ValueProperty)property).getValue();
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stereotypeName == null) ? 0 : stereotypeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof HasStereotypeConstraint))
			return false;
		HasStereotypeConstraint other = (HasStereotypeConstraint)obj;
		if(stereotypeName == null) {
			if(other.stereotypeName != null)
				return false;
		} else if(!stereotypeName.equals(other.stereotypeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HasStereotype " + stereotypeName + " (" + (getView().getElementMultiplicity() == 1 ? "Single" : "Multiple") + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	}
}
