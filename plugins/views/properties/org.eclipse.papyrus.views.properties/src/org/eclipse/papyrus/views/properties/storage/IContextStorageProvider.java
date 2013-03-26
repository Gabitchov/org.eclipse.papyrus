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
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.views.properties.contexts.Context;


/**
 * A provider of storage for custom Properties View {@link Context}s, registered
 * on the <tt>org.eclipse.papyrus.customization.properties.contextStorage</tt> extension point.
 */
public interface IContextStorageProvider {

	IContextStorageProvider NULL = new Null();

	/**
	 * Initializes me. This is called before I am requested to {@linkplain #loadContexts() provide any contexts}.
	 * If I throw, then I will be removed from the set of active providers and will not be invoked again.
	 * 
	 * @param resourceSet
	 *        the resource set in which I must load my custom context models
	 * 
	 * @throws CoreException
	 *         if I am not able and never will be able to provide custom context models
	 */
	void initialize(ResourceSet resourceSet) throws CoreException;

	/**
	 * Cleans up when I am no longer needed.
	 */
	void dispose();

	/**
	 * Queries whether I provide edit and delete actions for the a {@code context}.
	 * 
	 * @param context
	 *        a context selected by the user to act on
	 * 
	 * @return whether I provide actions for it
	 */
	boolean providesFor(Context context);

	/**
	 * Load the contexts available in my persistent storage.
	 * 
	 * @return the available contexts
	 * 
	 * @throws CoreException
	 *         if I absolutely cannot provide any contexts because of some fault
	 */
	Collection<? extends Context> loadContexts() throws CoreException;

	/**
	 * Called before a context is re-loaded from persistent storage. This gives the provider
	 * an opportunity to prepare in whatever way is required to ensure a clean re-load.
	 * 
	 * @param context
	 *        the context to be re-loaded. Note that this may be a separate copy
	 *        of the context in some other resource set, perhaps in an editor
	 * @throws CoreException
	 *         on failure to prepare the storage for re-load of the {@code context}
	 */
	void refreshContext(Context context) throws CoreException;

	/**
	 * Adds a listener for notification of dynamic changes in the available {@link Context}s
	 * in my domain.
	 * 
	 * @param listener
	 *        the listener to add
	 */
	void addContextStorageProviderListener(IContextStorageProviderListener listener);

	/**
	 * Removes a listener that is no longer interested in notification of dynamic changes
	 * in the available {@link Context}s in my domain.
	 * 
	 * @param listener
	 *        the listener to remove
	 */
	void removeContextStorageProviderListener(IContextStorageProviderListener listener);

	//
	// Nested types
	//

	class Null extends AbstractContextStorageProvider {

		public boolean providesFor(Context context) {
			// I am the final fall-back that provides no editing capability, so I always return false
			return false;
		}

		public Collection<? extends Context> loadContexts() throws CoreException {
			return Collections.emptyList();
		}
	}
}
