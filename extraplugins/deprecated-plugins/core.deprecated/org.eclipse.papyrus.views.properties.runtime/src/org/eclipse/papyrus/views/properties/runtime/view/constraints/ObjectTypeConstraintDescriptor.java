/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.view.constraints;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;
import org.eclipse.swt.graphics.Image;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * Descriptor for a constraint based on the type of object
 */
public class ObjectTypeConstraintDescriptor implements IConstraintDescriptor, IConfigurableDescriptor {

	/** class of the edited element */
	protected final Class<?> elementClass;

	/**
	 * Creates a new ObjectTypeConstraintDescriptor.
	 * 
	 * @param elementClass
	 *        class of the element to edit
	 */
	public ObjectTypeConstraintDescriptor(Class<?> elementClass) {
		this.elementClass = elementClass;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean select(Object objectToTest) {
		if(objectToTest == null) {
			return false;
		} else if((elementClass.isAssignableFrom(objectToTest.getClass()))) {
			return true;
		}
		return false;
	}


	/**
	 * Returns the element class for this constraint descriptor, i.e the class that each object in the selection must be compliant (the same or
	 * inherited one)
	 * 
	 * @return the element class for this constraint descriptor
	 */
	public Class<?> getElementClass() {
		return elementClass;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "Object Type Constraint: " + getElementClass().getCanonicalName();
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/ObjectTypeConstraint.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public ConstraintDescriptorState createState(boolean readOnly) {
		return new ObjectTypeConstraintDescriptorState(this, readOnly);
	}

	/**
	 * State for the {@link ObjectTypeConstraintDescriptor}, used for customization
	 */
	public class ObjectTypeConstraintDescriptorState extends ConstraintDescriptorState {

		/** change support for this bean */
		private PropertyChangeSupport changeSupport;

		/** class constraint */
		private Class<?> elementClassState;

		/**
		 * Creates a new ObjectTypeConstraintDescriptorState.
		 * 
		 * @param objectTypeConstraintDescriptor
		 *        the descriptor to manage
		 * @param readOnly
		 *        the read only mode of this state
		 */
		public ObjectTypeConstraintDescriptorState(ObjectTypeConstraintDescriptor objectTypeConstraintDescriptor, boolean readOnly) {
			super(objectTypeConstraintDescriptor, readOnly);

			elementClassState = objectTypeConstraintDescriptor.getElementClass();

			// register change support
			changeSupport = new PropertyChangeSupport(this);
		}

		/**
		 * Sets the element class for the descriptor
		 * 
		 * @param elementClass
		 *        the element class for the descriptor
		 */
		public void setElementClass(Class<?> elementClass) {
			Class<?> oldClass = this.elementClassState;
			this.elementClassState = elementClass;

			changeSupport.firePropertyChange("elementClass", oldClass, this.elementClassState);
		}

		/**
		 * {@inheritDoc}
		 */
		public void addPropertyChangeListener(PropertyChangeListener listener) {
			changeSupport.addPropertyChangeListener(listener);
		}

		/**
		 * {@inheritDoc}
		 */
		public void removePropertyChangeListener(PropertyChangeListener listener) {
			changeSupport.removePropertyChangeListener(listener);
		}

		/**
		 * {@inheritDoc}
		 */
		public Node generateNode(Document document) {
			Element node = document.createElement("elementClass");
			node.setAttribute("name", elementClassState.getName());
			return node;
		}

		/**
		 * Returns the elementClassState
		 * 
		 * @return the elementClassState
		 */
		public Class<?> getElementClassState() {
			return elementClassState;
		}
	}

}
