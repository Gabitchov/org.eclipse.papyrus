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
import org.eclipse.papyrus.properties.constraints.Constraint;
import org.eclipse.papyrus.properties.contexts.ConfigProperty;
import org.eclipse.papyrus.properties.contexts.ConstraintDescriptor;
import org.eclipse.papyrus.properties.contexts.ValueProperty;
import org.eclipse.papyrus.properties.util.EMFHelper;
import org.eclipse.papyrus.properties.util.UMLUtil;
import org.eclipse.uml2.uml.Element;

public class UmlInstanceOfConstraint extends AbstractConstraint {

	private String umlClassName;

	public UmlInstanceOfConstraint() {
	}

	@Override
	public void setConstraintDescriptor(ConstraintDescriptor descriptor) {
		for(ConfigProperty property : descriptor.getProperties()) {
			if(property.getName().equals("umlClassName")) { //$NON-NLS-1$
				if(property instanceof ValueProperty) {
					umlClassName = ((ValueProperty)property).getValue();
				}
			}
		}
		super.setConstraintDescriptor(descriptor);
	}

	public boolean match(Object selection) {
		Element umlSemantic = UMLUtil.resolveUMLElement(selection);
		if(umlSemantic != null) {
			return EMFHelper.isSubclass(umlSemantic, umlClassName, UMLUtil.getUMLMetamodel());
		}

		return false;
	}

	/**
	 * A class constraint overrides its superclass constraints
	 * e.g. : instanceOf(Class) overrides instanceOf(Classifier)
	 */
	@Override
	public boolean overrides(Constraint constraint) {
		if(!(constraint instanceof UmlInstanceOfConstraint)) {
			return false;
		}

		UmlInstanceOfConstraint umlConstraint = (UmlInstanceOfConstraint)constraint;
		boolean result = (!umlClassName.equals(umlConstraint.umlClassName)) && UMLUtil.isSubClass(umlClassName, umlConstraint.umlClassName);

		return result || super.overrides(constraint);
	}

	@Override
	public String toString() {
		return "UMLInstanceOf " + umlClassName + " (" + (getView().getElementMultiplicity() == 1 ? "Single" : "Multiple") + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((umlClassName == null) ? 0 : umlClassName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof UmlInstanceOfConstraint))
			return false;
		UmlInstanceOfConstraint other = (UmlInstanceOfConstraint)obj;
		if(umlClassName == null) {
			if(other.umlClassName != null)
				return false;
		} else if(!umlClassName.equals(other.umlClassName))
			return false;
		return true;
	}
}
