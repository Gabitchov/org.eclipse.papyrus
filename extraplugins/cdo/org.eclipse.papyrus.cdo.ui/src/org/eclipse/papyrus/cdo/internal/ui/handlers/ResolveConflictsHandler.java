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
package org.eclipse.papyrus.cdo.internal.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.cdo.dawn.editors.IDawnEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This is the ResolveConflictsHandler type. Enjoy.
 */
public class ResolveConflictsHandler
		extends AbstractHandler {

	public Object execute(ExecutionEvent event)
			throws ExecutionException {
		IDawnEditor activeEditor = Activator.getActiveDawnEditor();

		if (activeEditor != null) {
			// TODO: Implement real conflict resolution

			if (MessageDialog
				.openQuestion(HandlerUtil.getActiveShellChecked(event),
					Messages.ResolveConflictsHandler_0,
					Messages.ResolveConflictsHandler_1)) {
				activeEditor.getDawnEditorSupport().rollback();
			}
		}
		
		return null;
	}
}
