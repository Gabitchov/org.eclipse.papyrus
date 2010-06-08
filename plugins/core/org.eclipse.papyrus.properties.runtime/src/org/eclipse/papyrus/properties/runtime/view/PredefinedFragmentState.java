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
package org.eclipse.papyrus.properties.runtime.view;

import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.properties.runtime.state.IFragmentDescriptorState;
import org.eclipse.papyrus.properties.runtime.state.ITraversableModelElement;
import org.w3c.dom.Document;
import org.w3c.dom.Node;


/**
 * State for {@link PredefinedFragmentDescriptor}
 */
public class PredefinedFragmentState extends AbstractState implements IFragmentDescriptorState {

	/** the descriptor managed by this state */
	private final PredefinedFragmentDescriptor predefinedFragmentDescriptor;

	/**
	 * Creates a new PredefinedFragmentState.
	 * 
	 * @param predefinedFragmentDescriptor
	 *        the descriptor managed by this state
	 */
	public PredefinedFragmentState(PredefinedFragmentDescriptor predefinedFragmentDescriptor) {
		this.predefinedFragmentDescriptor = predefinedFragmentDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public PredefinedFragmentDescriptor getDescriptor() {
		return predefinedFragmentDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// nothing here
	}

	/**
	 * {@inheritDoc}
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// nothing here
	}

	/**
	 * {@inheritDoc}
	 */
	public Node generateNode(Document document) {
		Activator.log.error("not implemented yet", null);
		return null;
	}

}
