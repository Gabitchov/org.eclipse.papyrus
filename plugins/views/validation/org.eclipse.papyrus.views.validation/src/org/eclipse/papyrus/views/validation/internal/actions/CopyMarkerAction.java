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

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

/**
 * This is the CopyMarkerAction type. Enjoy.
 */
public class CopyMarkerAction
		extends AbstractMarkerAction {

	public CopyMarkerAction(IWorkbenchSite site) {
		super(site, "Copy");

		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
			.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		setDisabledImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
			.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
		setActionDefinitionId(ActionFactory.COPY.getCommandId());
	}

	@Override
	public void run() {
		ISelectionProvider selectionProvider = getSite().getSelectionProvider();
		if (selectionProvider instanceof TableViewer) {
			TableViewer viewer = (TableViewer) selectionProvider;
			String text = copy(viewer);

			Clipboard clipboard = new Clipboard(viewer.getControl()
				.getDisplay());
			try {
				clipboard.setContents(new Object[]{text},
					new Transfer[]{TextTransfer.getInstance()});
			} finally {
				clipboard.dispose();
			}
		}
	}

	private String copy(TableViewer viewer) {
		final String recordSep = System.getProperty("line.separator");
		final String fieldSep = "\t";
		StringBuilder result = new StringBuilder();

		// header record
		result.append("Severity").append(fieldSep);
		result.append("Description").append(fieldSep);
		result.append("Element").append(fieldSep);
		result.append("Parent").append(fieldSep);
		result.append("Type").append(recordSep);

		final int startIndex = 1; // the Severity column has no label
		final int columnCount = viewer.getTable().getColumnCount();
		CellLabelProvider[] labelProviders = new CellLabelProvider[columnCount
			- startIndex];
		for (int i = startIndex; i < columnCount; i++) {
			labelProviders[i - startIndex] = viewer.getLabelProvider(i);
		}

		for (IPapyrusMarker next : getMarkers()) {
			result.append(getSeverity(next));

			for (int i = 0; i < labelProviders.length; i++) {
				result.append(fieldSep);
				result.append(labelProviders[i].getToolTipText(next));
			}

			result.append(recordSep);
		}

		return result.toString();
	}

	private static String getSeverity(IPapyrusMarker marker) {
		String result;

		switch (marker.getAttribute(IPapyrusMarker.SEVERITY,
			IPapyrusMarker.SEVERITY_ERROR)) {

			case IPapyrusMarker.SEVERITY_INFO :
				result = "Info";
				break;
			case IPapyrusMarker.SEVERITY_WARNING :
				result = "Warning";
				break;
			default :
				result = "Error";
		}

		return result;
	}
}
