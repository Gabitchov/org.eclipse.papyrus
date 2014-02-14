/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.custom.sdk.ui.internal.util.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public final class Utils {

	private Utils() {
		// Must not be used
	}

	public static EditingDomain getEditingDomain(final ExecutionEvent event) {
		final IWorkbenchPart part = getPart(event);
		IEditingDomainProvider edProvider = null;
		if (part instanceof IEditingDomainProvider) {
			edProvider = (IEditingDomainProvider) part;
		} else {
			edProvider = (IEditingDomainProvider) part
					.getAdapter(IEditingDomainProvider.class);
		}
		EditingDomain editingDomain = null;
		if (edProvider != null) {
			editingDomain = edProvider.getEditingDomain();
		}
		return editingDomain;
	}

	private static IWorkbenchPart getPart(final ExecutionEvent event) {
		IWorkbenchPart part = null;
		if (event.getApplicationContext() instanceof IEvaluationContext) {
			final IEvaluationContext evalContext = (IEvaluationContext) event
					.getApplicationContext();
			part = (IWorkbenchPart) evalContext.getVariable("activePart"); //$NON-NLS-1$
		} else {
			final IWorkbench workbench = PlatformUI.getWorkbench();
			final IWorkbenchWindow window = workbench
					.getActiveWorkbenchWindow();
			if (window != null) {
				final IWorkbenchPage page = window.getActivePage();
				if (page != null) {
					part = page.getActivePart();
				}
			}
		}
		return part;
	}

	public static Display getDisplay(final ExecutionEvent execEvent) {
		Display display = null;
		if (execEvent.getTrigger() instanceof Event) {
			final Event event = (Event) execEvent.getTrigger();
			display = event.display;
		} else {
			display = PlatformUI.getWorkbench().getDisplay();
		}
		return display;
	}
}
