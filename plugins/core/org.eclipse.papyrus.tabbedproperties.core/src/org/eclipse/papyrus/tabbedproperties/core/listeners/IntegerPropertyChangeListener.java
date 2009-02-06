/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.listeners;

import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;

/**
 * A listener used to listen to boolean property change in the editor.
 */
public interface IntegerPropertyChangeListener {

	/**
	 * @param editor
	 * @param newValue
	 */
	public void propertyChanged(PropertyEditor editor, int newValue);
}
