/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.services.internal;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.EditorLifecycleEventListener;
import org.eclipse.papyrus.infra.core.services.EditorLifecycleManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;


public class EditorLifecycleManagerImpl implements EditorLifecycleManager, InternalEditorLifecycleManager {

	private final Set<EditorLifecycleEventListener> listeners = new HashSet<EditorLifecycleEventListener>();

	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		//Nothing
	}

	public void startService() throws ServiceException {
		//Nothing
	}

	public void disposeService() throws ServiceException {
		listeners.clear();
	}

	public void addEditorLifecycleEventsListener(EditorLifecycleEventListener listener) {
		listeners.add(listener);
	}

	public void removeEditorLifecycleEventsListener(EditorLifecycleEventListener listener) {
		listeners.remove(listener);
	}

	public void firePostInit(final IMultiDiagramEditor editor) {
		for(final EditorLifecycleEventListener listener : listeners) {
			SafeRunner.run(new ISafeRunnable() {

				public void run() throws Exception {
					listener.postInit(editor);
				}

				public void handleException(Throwable exception) {
					//Already logged by the SafeRunner
				}
			});
		}
	}

	public void firePostDisplay(final IMultiDiagramEditor editor) {
		for(final EditorLifecycleEventListener listener : listeners) {
			SafeRunner.run(new ISafeRunnable() {

				public void run() throws Exception {
					listener.postDisplay(editor);
				}

				public void handleException(Throwable exception) {
					//Already logged by the SafeRunner
				}
			});
		}
	}

	public void fireBeforeClose(final IMultiDiagramEditor editor) {
		for(final EditorLifecycleEventListener listener : listeners) {
			SafeRunner.run(new ISafeRunnable() {

				public void run() throws Exception {
					listener.beforeClose(editor);
				}

				public void handleException(Throwable exception) {
					//Already logged by the SafeRunner
				}
			});
		}
	}

}
