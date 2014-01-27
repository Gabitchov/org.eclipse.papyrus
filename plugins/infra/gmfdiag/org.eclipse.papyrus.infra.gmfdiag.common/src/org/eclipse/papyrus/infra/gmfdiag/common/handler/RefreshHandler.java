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

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
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

	/**
	 * The registry of refresh handler parts that are NOT specific to an editor
	 * We use weak references so that we do not block the garbage collection of objects
	 */
	private static Collection<WeakReference<IRefreshHandlerPart>> PARTS = new LinkedList<WeakReference<IRefreshHandlerPart>>();
	
	/**
	 * Register a refresher part that is not attached to any editor
	 * 
	 * @param refresher
	 *            The refresher part
	 */
	public static synchronized void register(IRefreshHandlerPart refresher) {
		PARTS.add(new WeakReference<IRefreshHandlerPart>(refresher));
	}
	
	/**
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart activeEditor;
		try {
			activeEditor = ServiceUtilsForHandlers.getInstance().getService(IMultiDiagramEditor.class, event);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}

		// Refresh the base GMF objects
		DiagramHelper.refresh(activeEditor);

		// Call the relevant hooks
		callRefresherHooks(activeEditor);

		return null;
	}
	
	private synchronized void callRefresherHooks(IEditorPart activeEditor) {
		Iterator<WeakReference<IRefreshHandlerPart>> iterator = PARTS.iterator();
		while (iterator.hasNext()) {
			WeakReference<IRefreshHandlerPart> wr = iterator.next();
			IRefreshHandlerPart part = wr.get();
			if (part != null) {
				part.refresh(activeEditor);
			} else {
				iterator.remove();
			}
		}
	}
}
