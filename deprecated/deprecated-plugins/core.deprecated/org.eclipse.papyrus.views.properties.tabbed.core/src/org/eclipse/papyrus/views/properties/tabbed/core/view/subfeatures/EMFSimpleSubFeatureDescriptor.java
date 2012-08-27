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
package org.eclipse.papyrus.views.properties.tabbed.core.view.subfeatures;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.swt.graphics.Image;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * Simple sub feature descriptor for emf objects. It only looks in a given feature of the list of given EObjects
 */
public class EMFSimpleSubFeatureDescriptor extends SubFeatureDescriptor {

	/** name of the feature to edit */
	protected final String featureNameToEdit;

	/**
	 * Creates a new EMFSimpleSubFeatureDescriptor.
	 * 
	 * @param featureName
	 *        the name of the feature to edit
	 */
	public EMFSimpleSubFeatureDescriptor(String featureName) {
		this.featureNameToEdit = featureName;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getSubElementsToEdit(List<Object> editedObjects) {
		List<Object> results = new ArrayList<Object>();
		for(Object object : editedObjects) {
			if(object instanceof EObject) {
				EStructuralFeature feature = ((EObject)object).eClass().getEStructuralFeature(featureNameToEdit);
				if(feature != null) {
					Object values = ((EObject)object).eGet(feature);
					if(values instanceof List<?>) {
						results.addAll((List<Object>)values);
					} else if(values != null) {
						results.add(values);
					}
				} else {
					Activator.log.error("Impossible to find the feature [" + featureNameToEdit + "] for object: " + object, null);
				}
			}
		}
		return results;
	}

	/**
	 * Returns the name of the feature to edit
	 * 
	 * @return the name of the feature to edit
	 */
	public String getFeatureNameToEdit() {
		return featureNameToEdit;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "EMF Feature: " + featureNameToEdit;
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return org.eclipse.papyrus.views.properties.tabbed.core.Activator.getImage("/icons/EMFFeatureDescriptor.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public EMFSimpleSubFeatureDescriptorState createState(boolean readOnly) {
		return new EMFSimpleSubFeatureDescriptorState(this, readOnly);
	}

	/**
	 * State for {@link EMFSimpleSubFeatureDescriptor}
	 */
	public class EMFSimpleSubFeatureDescriptorState extends SubFeatureDescriptorState {

		/** change support for this bean */
		private PropertyChangeSupport changeSupport;

		/** name of the feature to edit */
		private String featureNameState;

		/**
		 * Creates a new EMFSimpleSubFeatureDescriptorState.
		 * 
		 * @param emfSimpleSubFeatureDescriptor
		 *        the descriptor to customize
		 * @param readOnly
		 *        read only mode of this state
		 */
		public EMFSimpleSubFeatureDescriptorState(EMFSimpleSubFeatureDescriptor emfSimpleSubFeatureDescriptor, boolean readOnly) {
			super(emfSimpleSubFeatureDescriptor, readOnly);

			featureNameState = emfSimpleSubFeatureDescriptor.getFeatureNameToEdit();

			// register change support
			changeSupport = new PropertyChangeSupport(this);
		}

		/**
		 * {@inheritDoc}
		 */
		public EMFSimpleSubFeatureDescriptor getDescriptor() {
			return (EMFSimpleSubFeatureDescriptor)super.getDescriptor();
		}

		/**
		 * {@inheritDoc}
		 */
		public String getText() {
			return "EMF Feature: " + featureNameState;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getEditionDialogId() {
			return "EMFSimpleSubFeatureDescriptorStateDialog";
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
		 * customizes the featureNameState
		 * 
		 * @param featureNameState
		 *        the featureNameState to set
		 */
		public void setFeatureNameState(String featureNameState) {
			String oldFeatureName = this.featureNameState;
			this.featureNameState = featureNameState;

			changeSupport.firePropertyChange("featureNameState", oldFeatureName, this.featureNameState);
		}

		/**
		 * Returns the customized feature Name
		 * 
		 * @return the customized feature Name
		 */
		public String getFeatureNameState() {
			return featureNameState;
		}

		/**
		 * {@inheritDoc}
		 */
		public Node generateNode(Document document) {
			//<subFeatureDescriptor featureName="memberEnd">
			//</subFeatureDescriptor>
			Element node = document.createElement("subFeatureDescriptor");
			node.setAttribute("featureName", getFeatureNameState());
			return node;
		}
	}
}
