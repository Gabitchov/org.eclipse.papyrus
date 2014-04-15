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
package org.eclipse.papyrus.infra.constraints.constraints;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.infra.constraints.Activator;
import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

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
	protected void setDescriptor(SimpleConstraint descriptor) {
		className = getValue("className"); //$NON-NLS-1$
		nsUri = getValue("nsUri"); //$NON-NLS-1$
		metamodel = EPackage.Registry.INSTANCE.getEPackage(nsUri);
		if(metamodel == null) {
			Activator.log.warn("Metamodel with nsUri " + nsUri + " not found"); //$NON-NLS-1$ //$NON-NLS-2$
		}
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
		boolean result = (!equals(constraint)) && EMFHelper.isSubclass(thisClass, otherClass) && thisClass != otherClass;

		return result || super.overrides(constraint);
	}

	@Override
	public boolean match(Object selection) {
		if(className == null || nsUri == null) {
			return false;
		}

		EObject selectedItem = EMFHelper.getEObject(selection);

		if(selectedItem != null) {
			if(metamodel == null) { //This may be a dynamic, local (non-registered) EPackage
				return EMFHelper.isInstance(selectedItem, className, nsUri);
			} else {
				return EMFHelper.isInstance(selectedItem, className, metamodel);
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return "EMFInstanceOfConstraint (" + nsUri + "/" + className + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Override
	protected boolean equivalent(Constraint constraint) {
		if(this == constraint) {
			return true;
		}
		if(constraint == null) {
			return false;
		}
		if(!(constraint instanceof EMFInstanceOfConstraint)) {
			return false;
		}
		EMFInstanceOfConstraint other = (EMFInstanceOfConstraint)constraint;
		if(className == null) {
			if(other.className != null) {
				return false;
			}
		} else if(!className.equals(other.className)) {
			return false;
		}
		if(nsUri == null) {
			if(other.nsUri != null) {
				return false;
			}
		} else if(!nsUri.equals(other.nsUri)) {
			return false;
		}
		return true;
	}

}
