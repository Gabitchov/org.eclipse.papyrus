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

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.cdo.internal.ui.Activator;

/**
 * This is the LockObjectsHandler type. Enjoy.
 */
public class LockObjectsHandler
		extends AbstractHandler {

	public Object execute(ExecutionEvent event)
			throws ExecutionException {
		
		List<Object> selected = UIHandlerUtil.getSelection(event);
		Activator.getActiveDawnEditor().getDawnEditorSupport()
			.lockObjects(selected);

		return null;
	}
}
