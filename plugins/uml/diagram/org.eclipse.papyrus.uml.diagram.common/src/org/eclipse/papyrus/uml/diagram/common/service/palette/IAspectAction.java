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
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.gef.EditPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.uml.Profile;
import org.w3c.dom.Node;

/**
 * Interface implemented by actions run after or before palette creation
 */
public interface IAspectAction {

	/**
	 * Initializes the action with some elements
	 * 
	 * @param configurationNode
	 *        the configuration {@link Node} that initialize the action
	 */
	public void init(Node configurationNode, IAspectActionProvider factory);

	/**
	 * action performed by this class
	 * 
	 * @param editPart
	 *        the edit part on which the action occurs
	 */
	public void run(EditPart editPart);

	/**
	 * Runs post condition tests before runnning the action
	 * 
	 * @return the status corresponding to the check
	 */
	public IStatus checkPreCondition();

	/**
	 * Runs post condition tests after runnning the action
	 * 
	 * @return the status corresponding to the check
	 */
	public IStatus checkPostCondition();

	/**
	 * Returns the label displayed by this action
	 * 
	 * @return the label displayed by this action
	 */
	public String getLabel();

	/**
	 * Returns the image displayed by this action
	 * 
	 * @return the image displayed by this action
	 */
	public Image getImage();

	/**
	 * Creates the control where the action can be configured
	 * 
	 * @param parent
	 *        the composite parent of the created element(s)
	 * @return the control where the action can be configured
	 */
	public Control createConfigurationComposite(Composite parent, IPaletteEntryProxy entryProxy, List<Profile> appliedProfiles);

	/**
	 * Serializes the current action configuration
	 * 
	 * @param parentNode
	 *        the configuration node where to place values
	 */
	public void save(Node parentNode);

	/**
	 * Returns the id of the factory in charge of the creation of this action
	 * 
	 * @return the id of the factory in charge of the creation of this action
	 */
	public String getFactoryId();

}
