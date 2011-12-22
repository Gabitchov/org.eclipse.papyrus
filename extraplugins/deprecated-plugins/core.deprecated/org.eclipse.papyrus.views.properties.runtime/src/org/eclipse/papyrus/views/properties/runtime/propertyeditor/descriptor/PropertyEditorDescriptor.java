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
import org.eclipse.papyrus.views.properties.runtime.state.IState;
import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;


/**
 * Basic configuration for property editors
 */
public class PropertyEditorDescriptor implements IPropertyEditorDescriptor, IConfigurableDescriptor {

	/** the label position of the property editor */
	private int labelPosition = 0;

	/** the icon descriptor for the label */
	private ImageDescriptor imageDescriptor = null;

	/** the label of the property editor */
	private String label = null;

	/** id of the editor configured by this descriptor */
	private String editorID;

	/** id of the editor configured by this descriptor */
	private String tooltipText;

	/**
	 * Creates a new PropertyEditorDescriptor.
	 * 
	 * @param editorID
	 *        the id of the editor described
	 * @param label
	 *        the label of the described editor
	 * @param tooltipText
	 *        the tooltip text for this property editor
	 */
	public PropertyEditorDescriptor(String editorID, String label, String tooltipText) {
		this(editorID, label, SWT.LEFT, tooltipText, null);
	}

	/**
	 * Creates a new PropertyEditorDescriptor.
	 * 
	 * @param editorID
	 *        the id of the described editor
	 * @param label
	 *        the label of the described editor
	 * @param labelPosition
	 *        the label position relative to the edition area (see {@link SWT#LEFT})
	 * @param tooltipText
	 *        the tooltip text for this property editor
	 * @param imageDescriptor
	 *        the image descriptor for the icon of the property editor
	 */
	public PropertyEditorDescriptor(String editorID, String label, int labelPosition, String tooltipText, ImageDescriptor imageDescriptor) {
		this.label = label;
		this.labelPosition = labelPosition;
		this.imageDescriptor = imageDescriptor;
		this.editorID = editorID;
		this.tooltipText = tooltipText;
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

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "editor";
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public IState createState(boolean readOnly) {
		return new PropertyEditorDescriptorState(this, readOnly);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTooltipText() {
		return tooltipText;
	}

}
