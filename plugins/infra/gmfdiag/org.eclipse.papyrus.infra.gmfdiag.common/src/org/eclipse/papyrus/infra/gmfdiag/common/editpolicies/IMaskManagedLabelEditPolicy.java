/*****************************************************************************
 * Copyright (c) 2008, 2009 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import java.util.Collection;
import java.util.Map;

/**
 * Interface for all edit policies that manage the label of a {@link GraphicalEditPart}. The label must be controlled by a system of mask,
 * i.e. the label shows or not some part of the string.
 */
public interface IMaskManagedLabelEditPolicy {

	/** key for this edit policy */
	public String MASK_MANAGED_LABEL_EDIT_POLICY = "MaskManagedLabelPolicy";

	/**
	 * Returns the {@link Map} of masks. The key is the mask ID, the value is the mask Label
	 * 
	 * @return the {@link Map} of masks
	 */
	public Map<String, String> getMasks();

	/**
	 * Retrieve the current display Value for the current host edit part.
	 * 
	 * @return the current display Value for the current host edit part.
	 */
	public Collection<String> getCurrentDisplayValue();

	/**
	 * Refreshes the display of the edit part
	 */
	public void refreshDisplay();

	/**
	 * Sets the new Value for the element that manages the mask value
	 */
	public void updateDisplayValue(Collection<String> newValue);

	/**
	 * Sets the default display value for the edit part
	 */
	public void setDefaultDisplayValue();

	/**
	 * returns the preference page ID
	 * 
	 * @return
	 */
	public String getPreferencePageID();
}
