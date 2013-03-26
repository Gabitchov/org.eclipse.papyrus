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
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;


/**
 * This is the AbstractContextStorageProvider type. Enjoy.
 */
public abstract class AbstractContextStorageProvider implements IContextStorageProvider {

	private final CopyOnWriteArrayList<IContextStorageProviderListener> listeners = new CopyOnWriteArrayList<IContextStorageProviderListener>();

	public AbstractContextStorageProvider() {
		super();
	}

	public void initialize(ResourceSet resourceSet) throws CoreException {
		// pass
	}

	public void dispose() {
		listeners.clear();
	}

	public void refreshContext(Context context) throws CoreException {
		// pass
	}

	public void addContextStorageProviderListener(IContextStorageProviderListener listener) {
		listeners.addIfAbsent(listener);
	}

	public void removeContextStorageProviderListener(IContextStorageProviderListener listener) {
		listeners.remove(listener);
	}

	protected void fireContextsAdded(Collection<? extends Context> contexts) {
		if(!listeners.isEmpty() && !contexts.isEmpty()) {
			contexts = Collections.unmodifiableCollection(contexts);

			for(IContextStorageProviderListener next : listeners) {
				try {
					next.contextsAdded(contexts);
				} catch (Exception e) {
					Activator.log.error("Uncaught exception in context storage provider listener.", e);
				}
			}
		}
	}

	protected void fireContextsChanged(Collection<? extends Context> contexts) {
		if(!listeners.isEmpty() && !contexts.isEmpty()) {
			contexts = Collections.unmodifiableCollection(contexts);

			for(IContextStorageProviderListener next : listeners) {
				try {
					next.contextsChanged(contexts);
				} catch (Exception e) {
					Activator.log.error("Uncaught exception in context storage provider listener.", e);
				}
			}
		}
	}

	protected void fireContextsRemoved(Collection<? extends Context> contexts) {
		if(!listeners.isEmpty() && !contexts.isEmpty()) {
			contexts = Collections.unmodifiableCollection(contexts);

			for(IContextStorageProviderListener next : listeners) {
				try {
					next.contextsRemoved(contexts);
				} catch (Exception e) {
					Activator.log.error("Uncaught exception in context storage provider listener.", e);
				}
			}
		}
	}
}
