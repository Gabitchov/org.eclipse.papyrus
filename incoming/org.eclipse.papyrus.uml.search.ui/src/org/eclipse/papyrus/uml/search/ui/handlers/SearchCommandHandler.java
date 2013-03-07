/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.search.internal.ui.OpenSearchDialogAction;

/**
 * 
 * Handler for findAndReplace that opens the search dialog
 * 
 */
public class SearchCommandHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {

		OpenSearchDialogAction action = new OpenSearchDialogAction();
		action.run();

		return null;
	}

}
