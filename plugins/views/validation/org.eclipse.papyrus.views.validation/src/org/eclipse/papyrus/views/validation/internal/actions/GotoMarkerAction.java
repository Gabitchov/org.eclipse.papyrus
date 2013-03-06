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
package org.eclipse.papyrus.views.validation.internal.actions;

import java.util.Collections;

import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.papyrus.views.validation.internal.Activator;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchSite;

/**
 * This is the GotoMarkerAction type. Enjoy.
 */
public class GotoMarkerAction
		extends AbstractMarkerAction {

	public GotoMarkerAction(IWorkbenchSite site) {
		super(site, "Go To");

		setImageDescriptor(Activator.getDefault().getImageRegistry()
			.getDescriptor(Activator.ICON_GOTO_MARKER));
	}

	@Override
	public void run() {
		if (getMarker() != null) {
			gotoMarker();
		}
	}

	private void gotoMarker() {
		IRevealSemanticElement revealer = null;

		if (getMarker().getEObject() != null) {
			for (IViewReference next : getSite().getPage().getViewReferences()) {
				IViewPart part = next.getView(false);
				if (part instanceof IRevealSemanticElement) {
					revealer = (IRevealSemanticElement) part;
					break;
				} else if (part != null) {
					revealer = (IRevealSemanticElement) part
						.getAdapter(IRevealSemanticElement.class);
					if (revealer != null) {
						break;
					}
				}
			}

			if (revealer != null) {
				revealer.revealSemanticElement(Collections
					.singletonList(getMarker().getEObject()));
			}
		}
	}
}
