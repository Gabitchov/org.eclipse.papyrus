/**
 * Copyright (c) 2013 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 406570 - Handlers to Save and SaveAs EMF resources
 */
package org.eclipse.emf.facet.util.emf.ui.internal.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.util.emf.ui.internal.ResourceUiUtils;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

public class SaveHandler implements IHandler {

	public void addHandlerListener(final IHandlerListener handlerListener) {
		// Nothing to do
	}

	public void dispose() {
		// Nothing to do
	}

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final Shell shell = HandlerUtil.getActiveShell(event);
		for (Object object : getSelection()) {
			if (object instanceof Resource) {
				final Resource resource = (Resource) object;
				ResourceUiUtils.save(resource, shell);
			} else if (object instanceof IAdaptable) {
				final IAdaptable adaptable = (IAdaptable) object;
				final Resource resource = (Resource) adaptable
						.getAdapter(Resource.class);
				if (resource != null) {
					ResourceUiUtils.save(resource, shell);
				}
			}
		}
		return null;
	}

	public boolean isEnabled() {
		return true;
	}

	public boolean isHandled() {
		return isEnabled();
	}

	public void removeHandlerListener(final IHandlerListener handlerListener) {
		// Nothing to do
	}

	private static <E> List<E> getSelection() {
		final List<E> result = new ArrayList<E>();
		final IWorkbenchWindow wWindow = getActiveWindow();
		final ISelectionService selectService = wWindow.getSelectionService();
		wWindow.getActivePage().getActivePart();
		final ISelection selection = selectService.getSelection();
		if (selection instanceof StructuredSelection) {
			final StructuredSelection structS = (StructuredSelection) selection;
			@SuppressWarnings("unchecked")
			// @SuppressWarnings This cast is unsafe but the framework does not
			// provide other way to do
			final List<E> list = structS.toList();
			result.addAll(list);
		}
		return result;
	}

	private static IWorkbenchWindow getActiveWindow() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		return workbench.getActiveWorkbenchWindow();
	}

}
