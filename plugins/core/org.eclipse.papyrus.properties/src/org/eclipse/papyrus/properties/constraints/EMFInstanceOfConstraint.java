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
package org.eclipse.papyrus.properties.constraints;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.properties.contexts.ConfigProperty;
import org.eclipse.papyrus.properties.contexts.ConstraintDescriptor;
import org.eclipse.papyrus.properties.contexts.ValueProperty;
import org.eclipse.papyrus.properties.util.EMFHelper;
import org.eclipse.papyrus.service.edit.Activator;

/**
 * A constraint testing if a Selection is an EObject, instance of the given
 * EClass. The EClass is identified by its nsURI and name.
 * 
 * @author Camille Letavernier
 * 
 */
public class EMFInstanceOfConstraint extends AbstractConstraint {

	private String className;

	private String nsUri;

	private EPackage metamodel;

	@Override
	public void setConstraintDescriptor(ConstraintDescriptor descriptor) {
		for(ConfigProperty property : descriptor.getProperties()) {
			if(property.getName().equals("className")) { //$NON-NLS-1$
				if(property instanceof ValueProperty) {
					className = ((ValueProperty)property).getValue();
				}
			} else if(property.getName().equals("nsUri")) { //$NON-NLS-1$
				if(property instanceof ValueProperty) {
					nsUri = ((ValueProperty)property).getValue();
					metamodel = EPackage.Registry.INSTANCE.getEPackage(nsUri);
					if(metamodel == null) {
						Activator.log.warn("Metamodel with nsUri " + nsUri + " not found"); //$NON-NLS-1$ //$NON-NLS-2$
					}
				}
			}
		}
		super.setConstraintDescriptor(descriptor);
	}

	/**
	 * A class constraint overrides its superclass constraints
	 * e.g. : instanceOf(Class) overrides instanceOf(Classifier)
	 */
	@Override
	public boolean overrides(Constraint otherConstraint) {
		if(!(otherConstraint instanceof EMFInstanceOfConstraint)) {
			return false;
		}

		EMFInstanceOfConstraint constraint = (EMFInstanceOfConstraint)otherConstraint;
		EClass thisClass = EMFHelper.getEClass(nsUri, className);
		EClass otherClass = EMFHelper.getEClass(constraint.nsUri, constraint.className);
		boolean result = (!equals(constraint)) && EMFHelper.isSubclass(thisClass, otherClass);

		return result || super.overrides(constraint);
	}

	public boolean match(Object selection) {
		EObject selectedItem = EMFHelper.getEObject(selection);

		if(selectedItem != null) {
			return EMFHelper.isSubclass(selectedItem, className, metamodel);
		}
		return false;
	}

	@Override
	public String toString() {
		return "EMFInstanceOfConstraint (" + nsUri + "/" + className + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((nsUri == null) ? 0 : nsUri.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof EMFInstanceOfConstraint))
			return false;
		EMFInstanceOfConstraint other = (EMFInstanceOfConstraint)obj;
		if(className == null) {
			if(other.className != null)
				return false;
		} else if(!className.equals(other.className))
			return false;
		if(nsUri == null) {
			if(other.nsUri != null)
				return false;
		} else if(!nsUri.equals(other.nsUri))
			return false;
		return true;
	}

}
