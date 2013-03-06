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
package org.eclipse.papyrus.cdo.internal.ui.editors;

import org.eclipse.emf.cdo.dawn.editors.IDawnEditor;
import org.eclipse.emf.cdo.dawn.gmf.notifications.impl.DawnGMFLockingHandler;
import org.eclipse.emf.cdo.view.CDOViewLocksChangedEvent;
import org.eclipse.papyrus.cdo.internal.ui.util.UIUtil;

/**
 * This is the PapyrusGMFLockingHandler type. Enjoy.
 */
public class PapyrusGMFLockingHandler
		extends DawnGMFLockingHandler {

	public PapyrusGMFLockingHandler(IDawnEditor editor) {
		super(editor);
	}

	@Override
	public void handleLocksChangedEvent(CDOViewLocksChangedEvent event) {
		if (UIUtil.ensureUIThread(this, event)) {
			super.handleLocksChangedEvent(event);
		}
	}
}
