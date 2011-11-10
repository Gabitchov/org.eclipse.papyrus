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
package org.eclipse.papyrus.views.properties.constraints;

import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.ConfigProperty;
import org.eclipse.papyrus.views.properties.contexts.ConstraintDescriptor;
import org.eclipse.papyrus.views.properties.contexts.DisplayUnit;
import org.eclipse.papyrus.views.properties.contexts.ReferenceProperty;
import org.eclipse.papyrus.views.properties.contexts.SimpleConstraint;
import org.eclipse.papyrus.views.properties.contexts.ValueProperty;
import org.eclipse.papyrus.views.properties.contexts.View;

/**
 * An abstract implementation for the Constraint interface.
 * 
 * @author Camille Letavernier
 * 
 */
public abstract class AbstractConstraint implements Constraint {

	/**
	 * The descriptor used to instantiate this constraint.
	 * Contains some attributes for this constraint
	 */
	protected ConstraintDescriptor descriptor;

	/**
	 * The display unit (Section or View) associated to this constraint
	 */
	protected DisplayUnit display;

	public final void setConstraintDescriptor(ConstraintDescriptor descriptor) {
		this.descriptor = descriptor;
		display = getDisplay(descriptor);
		if(descriptor instanceof SimpleConstraint) {
			setDescriptor((SimpleConstraint)descriptor);
		}
	}

	private DisplayUnit getDisplay(ConstraintDescriptor descriptor) {
		if(descriptor.getDisplay() == null) {
			if(descriptor.eContainer() instanceof ConstraintDescriptor) {
				return getDisplay((ConstraintDescriptor)descriptor.eContainer());
			}
		}
		return descriptor.getDisplay();
	}

	public View getView() {
		if(display instanceof View) {
			return (View)display;
		} else {
			Activator.log.warn("The constraint " + descriptor.getName() + " isn't owned by a View"); //$NON-NLS-1$ //$NON-NLS-2$
			return null;
		}
	}

	/**
	 * A constraint for a Single element (Exactly one) overrides
	 * the same constraint for a multiple element (One or more)
	 */
	public boolean overrides(Constraint constraint) {
		if(equivalent(constraint)) {
			if(getView().getElementMultiplicity() == 1) {
				if(constraint.getView().getElementMultiplicity() != 1) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Tests if two constraints are equivalent.
	 * Two constraints are equivalent if they have the same parameters.
	 * Two equivalent constraints may have different Display units, with
	 * different multiplicities.
	 * 
	 * @param constraint
	 * @return
	 *         True if this object is equivalent to the given constraint
	 */
	protected abstract boolean equivalent(Constraint constraint);

	public ConstraintDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * Returns the ConfigProperty corresponding to the given propertyName
	 * 
	 * @param propertyName
	 *        The name of the property to retrieve
	 * @return
	 *         The ConfigProperty corresponding to the given propertyName
	 */
	protected ConfigProperty getProperty(String propertyName) {
		if(descriptor == null || !(descriptor instanceof SimpleConstraint)) {
			Activator.log.warn("The constraint descriptor has not been set for this constraint : " + this); //$NON-NLS-1$
		} else {
			for(ConfigProperty property : ((SimpleConstraint)descriptor).getProperties()) {
				if(property.getName().equals(propertyName)) {
					return property;
				}
			}
		}

		Activator.log.warn("The property " + propertyName + " has not been set for constraint " + descriptor.getName()); //$NON-NLS-1$ //$NON-NLS-2$

		return null;
	}

	/**
	 * Returns the value associated to the given property
	 * 
	 * @param propertyName
	 *        The name of the property for which we want to retrieve the value
	 *        The name must correspond to a valid ValueProperty
	 * @return
	 *         The value associated to the given property
	 * 
	 * @see #getReferenceValue(String)
	 */
	protected String getValue(String propertyName) {
		ConfigProperty property = getProperty(propertyName);

		if(property instanceof ValueProperty) {
			return ((ValueProperty)property).getValue();
		}

		Activator.log.warn("The property " + propertyName + " is not a ValueProperty (Constraint " + descriptor.getName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		return null;
	}

	/**
	 * Returns the value associated to the given property
	 * 
	 * @param propertyName
	 *        The name of the property for which we want to retrieve the value
	 *        The name must correspond to a valid ReferenceProperty
	 * @return
	 *         The value associated to the given property
	 * 
	 * @see #getValue(String)
	 */
	protected Object getReferenceValue(String propertyName) {
		ConfigProperty property = getProperty(propertyName);
		if(property instanceof ReferenceProperty) {
			return ((ReferenceProperty)property).getValue();
		}

		Activator.log.warn("The property " + propertyName + " is not a ReferenceProperty (Constraint " + descriptor.getName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		return null;
	}

	/**
	 * Sets the Constraint Descriptor for this constraint.
	 * The constraint descriptor may contain some parameters to configure this
	 * constraint.
	 * Implementors may override.
	 * 
	 * @param descriptor
	 *        The constraint descriptor to be associated to this constraint
	 * 
	 * @see #setConstraintDescriptor(ConstraintDescriptor)
	 */
	protected void setDescriptor(SimpleConstraint descriptor) {
		//Implementors may override
	}

}
