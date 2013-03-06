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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This is the AbstractMarkerAction type. Enjoy.
 */
public class AbstractMarkerAction
		extends BaseSelectionListenerAction {

	private IWorkbenchSite site;

	private Collection<IPapyrusMarker> markers;

	public AbstractMarkerAction(IWorkbenchSite site, String label) {
		super(label);

		this.site = site;
		
		setEnabled(false);
	}

	protected IWorkbenchSite getSite() {
		return site;
	}

	protected IPapyrusMarker getMarker() {
		return Iterables.getFirst(markers, null);
	}

	protected Collection<IPapyrusMarker> getMarkers() {
		return markers;
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		markers = selection.isEmpty()
			? Collections.<IPapyrusMarker> emptyList()
			: Lists.newArrayList(Iterables.filter(selection.toList(),
				IPapyrusMarker.class));

		return !markers.isEmpty() && super.updateSelection(selection);
	}
}
