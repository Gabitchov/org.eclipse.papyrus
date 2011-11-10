/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.resourceupdate;

import org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent;
import org.eclipse.papyrus.infra.core.lifecycleevents.ISaveEventListener;
import org.eclipse.swt.widgets.Display;

/**
 * A listener for save actions. The goal is to track te editors save operations
 * in order to distinguish external resource modifications and those triggered
 * by the save operation
 * 
 * @author Ansgar Radermacher (CEA LIST)
 */
public class SaveListener {

	public SaveListener() {
		preSaveListener = new PreSaveListener();
		postSaveListener = new PreSaveListener();
		postSaveRunnable = new PostSaveRunnable();
	}

	class PreSaveListener implements ISaveEventListener {

		public void doSaveAs(DoSaveEvent event) {
			saveActive = true;
		}

		public void doSave(DoSaveEvent event) {
			saveActive = true;
		}

	};

	class PostSaveListener implements ISaveEventListener {

		public void doSaveAs(DoSaveEvent event) {
			// do not reset saveActive directly to avoid eventual race
			// conditions (avoid that the
			// resource change listener executes after the flag has been reset)
			Display.getDefault().asyncExec(postSaveRunnable);
		}

		public void doSave(DoSaveEvent event) {
			Display.getDefault().asyncExec(postSaveRunnable);
		}
	};

	class PostSaveRunnable implements Runnable {

		public void run() {
			saveActive = false;
		};
	}

	public boolean isSaveActive() {
		return saveActive;
	}

	private boolean saveActive;

	ISaveEventListener preSaveListener;

	ISaveEventListener postSaveListener;

	Runnable postSaveRunnable;
};
