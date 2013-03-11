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
package org.eclipse.papyrus.cdo.internal.ui.dnd;

import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.papyrus.cdo.core.util.CDOFunctions;
import org.eclipse.papyrus.cdo.core.util.CDOPredicates;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.part.PluginTransfer;
import org.eclipse.ui.part.PluginTransferData;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

/**
 * This is the ResourceDragAdapter type. Enjoy.
 */
public class ResourceDragAdapter extends DragSourceAdapter {

	private static final Transfer[] TRANSFERS = { PluginTransfer.getInstance() };

	private final StructuredViewer viewer;

	protected ResourceDragAdapter(StructuredViewer viewer) {
		this.viewer = viewer;
	}

	public static ResourceDragAdapter install(StructuredViewer viewer) {
		ResourceDragAdapter result = new ResourceDragAdapter(viewer);

		viewer.addDragSupport(DND.DROP_MOVE | /* DND.DROP_COPY | */DND.DROP_DEFAULT, TRANSFERS, result);

		return result;
	}

	protected IStructuredSelection getViewerSelection() {
		return (IStructuredSelection)viewer.getSelection();
	}

	@Override
	public void dragStart(DragSourceEvent event) {
		IStructuredSelection selection = getViewerSelection();
		event.doit = acceptSelection(selection.toList());
	}

	protected boolean acceptSelection(List<?> selection) {
		return !selection.isEmpty() && Iterables.all(selection, CDOPredicates.adaptsTo(CDOResourceNode.class));
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		for(Transfer transfer : TRANSFERS) {
			if(transfer.isSupportedType(event.dataType)) {
				if(transfer instanceof LocalSelectionTransfer) {
					// pass the selection along through the event
					event.data = getViewerSelection();
				} else if(transfer instanceof PluginTransfer) {
					CDOResourceURITransferData data = getResourceURIs(getViewerSelection());
					event.data = new PluginTransferData(ResourceDropActionDelegate.DROP_ACTION_ID, data.serialize());
				}
			}
		}
	}

	protected CDOResourceURITransferData getResourceURIs(IStructuredSelection selection) {
		return new CDOResourceURITransferData(Iterables.filter(Iterables.transform((List<?>)selection.toList(), CDOFunctions.adapt(CDOResource.class)), Predicates.notNull()));
	}
}
