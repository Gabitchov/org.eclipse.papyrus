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
import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.eclipse.papyrus.views.properties.tabbed.core.Activator;
import org.eclipse.swt.graphics.Image;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * state for {@link SubFeatureContainerDescriptor}
 */
public class SubFeatureContainerDescriptorState extends AbstractState {

	/** descriptor managed by this state */
	protected final SubFeatureContainerDescriptor descriptor;

	/**
	 * Creates a new SubFeatureContainerDescriptorState.
	 * 
	 * @param descriptor
	 *        the descriptor managed by his state
	 * @param readOnly
	 *        <code>true</code> if this state should be in read-only mode
	 */
	public SubFeatureContainerDescriptorState(SubFeatureContainerDescriptor descriptor, boolean readOnly) {
		super(readOnly);
		this.descriptor = descriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public SubFeatureContainerDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
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
		Element node = document.createElement("subFeatureDescriptorContainer");

		generateAttributes(node, document);

		return node;
	}

	/**
	 * Generates the attributes for the root node
	 * 
	 * @param node
	 *        the node for which attributes are set
	 * @param document
	 *        the document used to create elements
	 */
	protected void generateAttributes(Element node, Document document) {
		node.setAttribute("type", "simpleContainer");
	}

	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		return Collections.emptyList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage() {
		return Activator.getImage("/icons/SubFeatureContainer.gif");
	}

}
