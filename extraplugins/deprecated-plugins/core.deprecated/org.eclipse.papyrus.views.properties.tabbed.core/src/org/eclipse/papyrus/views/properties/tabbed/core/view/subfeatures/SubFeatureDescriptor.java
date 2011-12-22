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

import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;


/**
 * Feature descriptor for sub features of an element
 */
public abstract class SubFeatureDescriptor implements IConfigurableDescriptor {

	/**
	 * Returns the list of sub elements for a given set of objects
	 * 
	 * @param editedObjects
	 *        the list of selected objects
	 * @return the list of sub elements for a given set of objects or an empty list
	 */
	public abstract List<Object> getSubElementsToEdit(List<Object> editedObjects);

	/**
	 * {@inheritDoc}
	 */
	public abstract SubFeatureDescriptorState createState(boolean readOnly);

	/**
	 * State for {@link SubFeatureDescriptor}
	 */
	public abstract class SubFeatureDescriptorState extends AbstractState {

		/** managed descriptor */
		private SubFeatureDescriptor descriptor;

		/**
		 * Creates a new SubFeatureDescriptor.SubFeatureDescriptionState.
		 * 
		 * @param descriptor
		 *        the descriptor to manage
		 * @param readOnly
		 *        read only mode of this state
		 */
		public SubFeatureDescriptorState(SubFeatureDescriptor descriptor, boolean readOnly) {
			super(readOnly);
			this.descriptor = descriptor;
		}

		/**
		 * {@inheritDoc}
		 */
		public SubFeatureDescriptor getDescriptor() {
			return descriptor;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getEditionDialogId() {
			return "";
		}

		/**
		 * {@inheritDoc}
		 */
		public List<? extends ITraversableModelElement> getChildren() {
			return Collections.emptyList();
		}
	}
}
