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
package org.eclipse.papyrus.views.properties.runtime.state;

import java.beans.PropertyChangeListener;

import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;
import org.eclipse.swt.graphics.Image;
import org.w3c.dom.Document;
import org.w3c.dom.Node;


/**
 * Common interface to all states
 */
public interface IState {

	/**
	 * returns the label displayed by this state
	 * 
	 * @return the label displayed by this state
	 */
	public String getText();

	/**
	 * returns the image displayed by this state
	 * 
	 * @return the image displayed by this state
	 */
	public Image getImage();

	/**
	 * Returns the descriptor managed by this state
	 * 
	 * @return the descriptor managed by this state
	 */
	public IConfigurableDescriptor getDescriptor();

	/**
	 * Returns the identifier of the dialog used to edit this element
	 * 
	 * @return the identifier of the dialog used to edit this element
	 */
	public String getEditionDialogId();

	/**
	 * Adds a property change listener to this class
	 * 
	 * @param listener
	 *        the listener to add
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener);

	/**
	 * Removes a property change listener from this class
	 * 
	 * @param listener
	 *        the listener to remove
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener);

	/**
	 * Serializes the state under the form of an xml node
	 * 
	 * @param document
	 *        the document used to create elements
	 * @return the generate node
	 */
	public Node generateNode(Document document);

	/**
	 * Indicates if the state is in read only mode
	 * 
	 * @return <code>true</code> if the state should be unmodifiable
	 */
	public boolean isReadOnly();
}
