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
package org.eclipse.papyrus.properties.runtime.view.constraints;

import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.properties.runtime.state.ITraversableModelElement;
import org.w3c.dom.Document;
import org.w3c.dom.Node;


/**
 * State for Constraint Descriptors
 */
public abstract class ConstraintDescriptorState extends AbstractState {

	/** constraint managed by this state */
	protected IConstraintDescriptor constraintDescriptor;

	/**
	 * Creates a new ConstraintDescriptorState.
	 * 
	 * @param constraintDescriptor
	 *        the constraint descriptor managed by this state
	 */
	public ConstraintDescriptorState(IConstraintDescriptor constraintDescriptor) {
		this.constraintDescriptor = constraintDescriptor;
	}

	/**
	 * Creates the state for the given descriptor. It delegates to the descriptor itself the creation of the state
	 * 
	 * @param constraintDescriptor
	 *        the constraint descriptor to manage
	 * @return the created state
	 */
	public static ConstraintDescriptorState createState(IConstraintDescriptor constraintDescriptor) {
		return constraintDescriptor.createState();
	}

	/**
	 * {@inheritDoc}
	 */
	public IConstraintDescriptor getDescriptor() {
		return constraintDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return "ConstraintDescriptorStateDialog";
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ITraversableModelElement> getChildren() {
		return Collections.emptyList();
	}

	/**
	 * Serialize the configuration given by this state
	 * 
	 * @param document
	 *        the document used to create XML elements
	 * @return the created xml node
	 */
	public abstract Node generateNode(Document document);

}
