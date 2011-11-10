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
package org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;



/**
 * Interface implemented by all editor descriptors. These descriptors are used to configure the property editors. (label, label position, icon, etc.)
 */
public interface IPropertyEditorDescriptor extends IConfigurableDescriptor {

	/**
	 * Returns the tooltip text that should be associated to the property editor
	 * 
	 * @return the tooltip text that should be associated to the property editor
	 */
	public String getTooltipText();

	/**
	 * Returns the icon that should be associated to the label of the property editor
	 * 
	 * @return the icon that should be associated to the label of the property editor
	 */
	public ImageDescriptor getLabelImageDescriptor();

	/**
	 * Returns the label position of the property editor
	 * 
	 * @return the label position of the property editor
	 */
	public int getLabelPosition();

	/**
	 * Returns the label of the property editor
	 * 
	 * @return the label of the property editor
	 */
	public String getLabel();

	/**
	 * Returns the unique identifier of the editor
	 * 
	 * @return the unique identifier of the editor
	 */
	public String getEditorId();

}
