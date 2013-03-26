/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.storage;

import java.util.Collection;

import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;


/**
 * A listener protocol for notification of dynamic changes in the
 * available {@link Context}s in a storage provider.
 */
public interface IContextStorageProviderListener {

	/**
	 * Reports one or more {@code contexts} that have become available to activate.
	 * 
	 * @param contexts one or more contexts have that come on-line
	 */
	void contextsAdded(Collection<? extends Context> contexts);
	
	/**
	 * Reports one or more {@code contexts} that have changed in my persistent
	 * storage and should be {@linkplain ConfigurationManager#refresh(Context) reloaded}.
	 * 
	 * @param contexts one or more contexts have that changed in my persistent storage
	 */
	void contextsChanged(Collection<? extends Context> contexts);

	/**
	 * Reports one or more {@code contexts} that have been deleted from my persistent
	 * storage and need to be deactivated.
	 * 
	 * @param contexts one or more contexts have that gone off-line
	 */
	void contextsRemoved(Collection<? extends Context> contexts);
	
	//
	// Nested types
	//
	
	enum ContextEventType {
		ADDED, CHANGED, REMOVED;
	}
}
