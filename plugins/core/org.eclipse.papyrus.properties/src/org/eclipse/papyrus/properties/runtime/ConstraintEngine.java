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
package org.eclipse.papyrus.properties.runtime;

import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.View;

public interface ConstraintEngine {

	/**
	 * 
	 * @param selection
	 */
	public void setSelection(ISelection selection);

	/**
	 * Tests if the current selection is matched by this Engine
	 * 
	 * @return true if the current selection is matched
	 */
	public boolean match();

	/**
	 * @return The Views to display if this selection is matched
	 */
	public Set<View> getViews();

	/**
	 * 
	 * @param context
	 */
	public void addContext(Context context);

	public void contextChanged();

}
