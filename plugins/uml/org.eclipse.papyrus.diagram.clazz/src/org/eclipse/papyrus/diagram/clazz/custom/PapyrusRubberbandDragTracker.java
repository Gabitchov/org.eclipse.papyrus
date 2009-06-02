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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.clazz.custom;

import org.eclipse.gmf.runtime.diagram.ui.internal.tools.RubberbandDragTracker;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

//tempory class
// example to get the event.
public class PapyrusRubberbandDragTracker extends RubberbandDragTracker {

	protected boolean handleButtonDown(int button) {
		System.err.println("PapyrusRubberbandDragTracker click detected "
				+ button);
		if ((PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage() != null)
				&& (PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().getActiveEditor() != null)) {

			IEditorPart editorPart = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();

			if (editorPart instanceof CoreMultiDiagramEditor) {
				CoreMultiDiagramEditor multiEditorPart = (CoreMultiDiagramEditor) editorPart;
				// multiEditorPart.refreshTabs();
			}
		}

		return super.handleButtonDown(button);
	}
}
