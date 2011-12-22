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

/**
 * Descriptor specific to the Simple reference property editor
 */
public class SimpleReferencePropertyEditorDescriptor extends PropertyEditorDescriptor {

	/**
	 * Creates a new ComboPropertyEditorDescriptor.
	 * 
	 * @param editorId
	 *        the unique identifier for this editor factory
	 * @param label
	 *        the label for this property editor
	 * @param tooltipText
	 *        the tooltip text for this property editor
	 */
	public SimpleReferencePropertyEditorDescriptor(String editorId, String label, String tooltipText) {
		super(editorId, label, tooltipText);
	}

	/**
	 * Creates a new ComboPropertyEditorDescriptor.
	 * 
	 * @param editorId
	 *        the unique identifier for this editor factory
	 * @param label
	 *        the label for this property editor
	 * @param labelPosition
	 *        the label position for this property editor
	 * @param tooltipText
	 *        the tooltip text for this property editor
	 * @param imageDescriptor
	 *        the icon for this property editor
	 */
	public SimpleReferencePropertyEditorDescriptor(String editorId, String label, int labelPosition, String tooltipText, ImageDescriptor imageDescriptor) {
		super(editorId, label, labelPosition, tooltipText, imageDescriptor);
	}

}
