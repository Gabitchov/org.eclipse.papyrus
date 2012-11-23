/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.DiagramHelper;
import org.eclipse.ui.IEditorPart;

/**
 * Handles the refresh command on the Papyrus editor (F5)
 * 
 * Refreshes the active diagram
 * 
 * @author Camille Letavernier
 */
//TODO: To be refactored. Move to infra/gmfdiag/menu when the plugin exists
public class RefreshHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart activeEditor;
		try {
			activeEditor = ServiceUtilsForHandlers.getInstance().getNestedActiveIEditorPart(event);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}

		DiagramHelper.refresh(activeEditor);

		return null;
	}
}
