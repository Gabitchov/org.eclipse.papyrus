/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.SwitchLifelineCommand;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class SwitchLifelineAction implements IObjectActionDelegate {

	public final static String ID = "org.eclipse.papyrus.uml.diagram.timing.custom.SwitchLifelineActionID"; //$NON-NLS-1$

	public void run(final IAction action) {
		final SwitchLifelineCommand handler = new SwitchLifelineCommand();
		try {
			handler.execute(null);
		} catch (final ExecutionException e) {
			Activator.log.error("Error switching lifeline", e); //$NON-NLS-1$
		}

	}

	public void selectionChanged(final IAction action, final ISelection selection) {
		// nothing

	}

	public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {
		// nothing
	}

}
