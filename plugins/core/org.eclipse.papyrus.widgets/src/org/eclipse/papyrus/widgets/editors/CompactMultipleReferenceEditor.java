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

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.widgets.selectors.ReferenceSelector;
import org.eclipse.swt.widgets.Composite;

/**
 * A Property Editor representing a MultipleReference
 * as a label with the selected values. If the list
 * of values is too long, it gets truncated.
 * The values can be edited via a selection dialog.
 * This widget is useful when there is not much vertical space available,
 * and a MultipleReferenceEditor can not be used.
 * 
 * @author Camille Letavernier
 * 
 */
public class CompactMultipleReferenceEditor extends CompactMultipleValueEditor {

	/**
	 * The selector for the available values
	 */
	protected ReferenceSelector selector;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param style
	 * @param ordered
	 * @param unique
	 */
	public CompactMultipleReferenceEditor(Composite parent, int style, boolean ordered, boolean unique) {
		super(parent, style, new ReferenceSelector(unique), ordered, unique);
		this.selector = (ReferenceSelector)super.selector;
	}

	/**
	 * Sets the Content and Label providers for this widget.
	 * 
	 * The label provider is used in each place where the values can
	 * be displayed
	 * The content provider is used to display the items that can be selected
	 * 
	 * @param contentProvider
	 *        The content provider for this widget
	 * @param labelProvider
	 *        The label provider for this widget
	 */
	public void setProviders(IStaticContentProvider contentProvider, ILabelProvider labelProvider) {
		selector.setContentProvider(contentProvider);
		selector.setLabelProvider(labelProvider);
		super.setLabelProvider(labelProvider);
	}

}
