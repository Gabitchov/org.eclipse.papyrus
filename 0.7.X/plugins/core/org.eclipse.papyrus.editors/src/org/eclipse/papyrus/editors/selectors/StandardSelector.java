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
package org.eclipse.papyrus.editors.selectors;

import java.lang.reflect.Constructor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.papyrus.editors.AbstractValueEditor;
import org.eclipse.papyrus.editors.Activator;
import org.eclipse.papyrus.editors.IElementSelector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * Creates an element selector from an AbstractValueEditor. This class is a
 * generic implementation for element selectors.
 * 
 * @author Camille Letavernier
 * 
 */
public class StandardSelector implements IElementSelector {

	/**
	 * The AbstractValueEditor class used for instantiating this selector
	 */
	private Class<? extends AbstractValueEditor> editorClass;

	/**
	 * The AbstractValueEditor used by this selecotr
	 */
	private AbstractValueEditor editor;

	/**
	 * Instantiates this selector, using the specified editor class
	 * 
	 * @param editorClass
	 *        The AbstractValueEditor Class used to instantiate this selector
	 */
	public StandardSelector(Class<? extends AbstractValueEditor> editorClass) {
		Assert.isNotNull(editorClass, "The StandardSelector editor class should not be null"); //$NON-NLS-1$
		this.editorClass = editorClass;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getSelectedElements() {
		Object value = editor.getValue();
		if(value == null)
			return new Object[]{};

		return new Object[]{ value };
	}

	/**
	 * Ignored. The generic selectors can't be filtered.
	 */
	public void setSelectedElements(Object[] elements) {
		//Ignored
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getAllElements() {
		return getSelectedElements();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * The control for this selector is obtained by instantiating the generic class with a parent
	 * composite and a default style
	 */
	public void createControls(Composite parent) {
		try {
			Constructor<? extends AbstractValueEditor> construct = editorClass.getDeclaredConstructor(Composite.class, Integer.TYPE);
			editor = construct.newInstance(parent, SWT.BORDER);
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

}
