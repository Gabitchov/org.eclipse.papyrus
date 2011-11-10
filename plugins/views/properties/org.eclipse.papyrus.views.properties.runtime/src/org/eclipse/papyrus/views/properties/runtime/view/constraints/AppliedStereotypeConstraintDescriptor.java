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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * Descriptor for constraints based on stereotype application
 */
public class AppliedStereotypeConstraintDescriptor implements IConstraintDescriptor, IConfigurableDescriptor {

	/** list of stereotype qualified names to be applied */
	private final List<String> stereotypeQualifiedNames;

	/**
	 * Creates a new AppliedStereotypeConstraintDescriptor.
	 * 
	 * @param stereotypeQualifiedNames
	 *        list of stereotype qualified names to be applied
	 */
	public AppliedStereotypeConstraintDescriptor(List<String> stereotypeQualifiedNames) {
		this.stereotypeQualifiedNames = stereotypeQualifiedNames;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean select(Object objectToTest) {
		// object should be a UML element 
		if(objectToTest instanceof Element) {
			Element elementToTest = (Element)objectToTest;

			// each stereotype in the list should be present
			for(String stQualifiedName : getStereotypeQualifiedNames()) {
				Stereotype st = elementToTest.getAppliedStereotype(stQualifiedName);
				if(st == null) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Returns the list of stereotype Qualified Names
	 * 
	 * @return the list of stereotype Qualified Names
	 */
	public List<String> getStereotypeQualifiedNames() {
		return stereotypeQualifiedNames;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "Stereotypes Constraint: " + getStereotypeQualifiedNames();
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/StereotypeConstraint.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public AppliedStereotypeConstraintDescriptorState createState(boolean readOnly) {
		return new AppliedStereotypeConstraintDescriptorState(this, readOnly);
	}

	/**
	 * State for the {@link AppliedStereotypeConstraintDescriptor}, used for customization
	 */
	public class AppliedStereotypeConstraintDescriptorState extends ConstraintDescriptorState {

		/** change support for this bean */
		private PropertyChangeSupport changeSupport;

		/** list of stereotypes to be applied */
		private List<String> stereotypesToApply = new ArrayList<String>();

		/**
		 * Creates a new AppliedStereotypeConstraintDescriptorState.
		 * 
		 * @param descriptor
		 *        the descriptor to manage by this state
		 * @param readOnly
		 *        the read only mode of this state
		 * 
		 */
		public AppliedStereotypeConstraintDescriptorState(AppliedStereotypeConstraintDescriptor descriptor, boolean readOnly) {
			super(descriptor, readOnly);

			// initialize the list of stereotypes
			stereotypesToApply.addAll(descriptor.getStereotypeQualifiedNames());

			// register change support
			changeSupport = new PropertyChangeSupport(this);
		}

		/**
		 * Returns the stereotypesToApply
		 * 
		 * @return the stereotypesToApply
		 */
		public List<String> getStereotypesToApply() {
			return stereotypesToApply;
		}

		/**
		 * Adds a stereotype to the list of required stereotypes
		 * 
		 * @param qualifiedName
		 *        the qualified name of the stereotype to apply
		 */
		public void addStereotypeToApply(String qualifiedName) {
			stereotypesToApply.add(qualifiedName);

			// fire changes event
			changeSupport.firePropertyChange(PROPERTY_ADD_CHILD, null, stereotypesToApply);
		}

		/**
		 * Removes a stereotype from the list of required stereotypes
		 * 
		 * @param qualifiedName
		 *        the qualified name of the stereotype to remove
		 */
		public void removeStereotypeToApply(String qualifiedName) {
			stereotypesToApply.remove(qualifiedName);

			// fire changes event
			changeSupport.firePropertyChange(PROPERTY_REMOVE_CHILD, null, stereotypesToApply);
		}

		/**
		 * {@inheritDoc}
		 */
		public String getEditionDialogId() {
			// FIXME add a configuration dialog identifier  
			return "";
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
			Node node = document.createElement("appliedStereotypes");

			// generate for each stereotype required
			for(String qualifiedName : stereotypesToApply) {
				org.w3c.dom.Element subNode = document.createElement("appliedStereotype");
				subNode.setAttribute("qualifiedName", qualifiedName);
				node.appendChild(subNode);
			}

			return node;
		}
	}
}
