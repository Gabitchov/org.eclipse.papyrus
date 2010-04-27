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
package org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;


/**
 * Basic configuration for property editors
 */
public class PropertyEditorDescriptor implements IPropertyEditorDescriptor {

	/** the label position of the property editor */
	private int labelPosition = 0;

	/** the icon descriptor for the label */
	private ImageDescriptor imageDescriptor = null;

	/** the label of the property editor */
	private String label = null;

	/** id of the editor configured by this descriptor */
	private String editorID;

	/**
	 * Creates a new PropertyEditorDescriptor.
	 */
	public PropertyEditorDescriptor(String editorID, String label) {
		this(editorID, label, SWT.LEFT, null);
	}

	/**
	 * Creates a new PropertyEditorDescriptor.
	 */
	public PropertyEditorDescriptor(String editorID, String label, int labelPosition, ImageDescriptor imageDescriptor) {
		this.label = label;
		this.labelPosition = labelPosition;
		this.imageDescriptor = imageDescriptor;
		this.editorID = editorID;
	}

	/**
	 * {@inheritDoc}
	 */
	public ImageDescriptor getLabelImageDescriptor() {
		return imageDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getLabelPosition() {
		return labelPosition;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditorId() {
		return editorID;
	}

}
