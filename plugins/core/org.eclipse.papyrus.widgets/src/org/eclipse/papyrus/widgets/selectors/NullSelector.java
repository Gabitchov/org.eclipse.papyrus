/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.selectors;

import org.eclipse.papyrus.widgets.editors.IElementSelectionListener;
import org.eclipse.papyrus.widgets.editors.IElementSelector;
import org.eclipse.swt.widgets.Composite;

/**
 * A Null implementation of the IElementSelector interface
 * 
 * @author Camille Letavernier
 * 
 */
public class NullSelector implements IElementSelector {

	private NullSelector() {

	}

	public Object[] getSelectedElements() {
		return new Object[0];
	}

	public void setSelectedElements(Object[] elements) {
		//Nothing
	}

	public Object[] getAllElements() {
		return new Object[0];
	}

	public void createControls(Composite parent) {
		//Nothing
	}

	public void newObjectCreated(Object newObject) {
		//Nothing
	}

	public void clearTemporaryElements() {
		//Nothing
	}

	public void addElementSelectionListener(IElementSelectionListener listener) {
		//Nothing
	}

	public final static NullSelector instance = new NullSelector();

}
