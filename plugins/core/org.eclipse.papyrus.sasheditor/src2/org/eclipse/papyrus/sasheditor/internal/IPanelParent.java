/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
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
package org.eclipse.papyrus.sasheditor.internal;

import org.eclipse.swt.widgets.Composite;

/**
 * Interface implemented by Part that can be parent of a Panel (Sashes or Folders). The interface
 * allows to restrict the classes that can be parent of a Panel. For now, only {@link RootPart} and
 * {@link SashPanelPart} can be parent of a Panel.
 * 
 * @author dumoulin
 */
public interface IPanelParent {

	/**
	 * Get the {@link SashWindowsContainer}.
	 * 
	 * @return
	 */
	public SashWindowsContainer getSashWindowContainer();

	/**
	 * Get the parent SWT control.
	 * 
	 * @return
	 */
	public Composite getControl();

}
