/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.editors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.widgets.selectors.ReferenceSelector;
import org.eclipse.swt.widgets.Composite;

/**
 * An editor for multivalued references. This editor should be used when
 * there is enough vertical space available. If the vertical space is limited,
 * CompactMultipleReferenceEditor should be used instead.
 * 
 * @author Camille Letavernier
 * 
 */
public class MultipleReferenceEditor extends MultipleValueEditor {

	/**
	 * The element selector for the available values
	 */
	protected ReferenceSelector selector;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which this editor is created
	 * @param style
	 *        The style for this editor's list
	 * @param ordered
	 *        True if the list should be ordered
	 * @param unique
	 *        True if the list values should be unique
	 * @param label
	 *        The label for this editor
	 */
	public MultipleReferenceEditor(Composite parent, int style, boolean ordered, boolean unique, String label) {
		super(parent, style, new ReferenceSelector(unique), ordered, unique, label);
		this.selector = (ReferenceSelector)super.selector;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which this editor is created
	 * @param style
	 *        The style for this editor's list
	 * @param label
	 *        The label for this editor
	 */
	public MultipleReferenceEditor(Composite parent, int style, String label) {
		this(parent, style, false, false, label);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which this editor is created
	 * @param style
	 *        The style for this editor's list
	 */
	public MultipleReferenceEditor(Composite parent, int style) {
		this(parent, style, false, false, null);
	}

	/**
	 * Sets the Content and Label providers for this editor
	 * 
	 * @param contentProvider
	 *        The content provider describing the elements that can be selected
	 * @param labelProvider
	 *        The label provider for the elements
	 */
	public void setProviders(IStaticContentProvider contentProvider, ILabelProvider labelProvider) {
		Assert.isNotNull(contentProvider, "The content provider should be defined"); //$NON-NLS-1$

		selector.setContentProvider(contentProvider);

		if(labelProvider != null) {
			selector.setLabelProvider(labelProvider);
			super.setLabelProvider(labelProvider);
		}
	}
}
