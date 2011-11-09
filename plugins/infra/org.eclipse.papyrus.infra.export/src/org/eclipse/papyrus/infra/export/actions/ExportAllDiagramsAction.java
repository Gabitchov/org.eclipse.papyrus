/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 * Anass RADOUANI (AtoS) - add verification of the selection if it is 
 * a papyrus file or not
 ******************************************************************************/
package org.eclipse.papyrus.infra.export.actions;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.export.ExportAllDiagrams;
import org.eclipse.papyrus.infra.export.internal.Activator;
import org.eclipse.ui.handlers.HandlerUtil;

public class ExportAllDiagramsAction extends AbstractHandler {

	/**
	 * Try to retrieve the selected file from the given selection
	 * 
	 * @param sel
	 *        the selection
	 * @return the selected file
	 */
	private IFile convertSelection2File(ISelection sel) {
		// get the selected diagrams file
		if(sel instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection)sel;
			// Only one file should be selected
			if(!ssel.isEmpty() && ssel.size() == 1) {
				Object selectedObj = ssel.getFirstElement();
				return getIFile(selectedObj);
			}
		}
		return null;
	}

	public static IFile getIFile(Object selectedObj) {
		IFile result = null;
		if(selectedObj instanceof IFile) {
			result = (IFile)selectedObj;
		}
		// Try to adapt
		if(result == null && selectedObj instanceof IAdaptable) {
			result = (IFile)((IAdaptable)selectedObj).getAdapter(IFile.class);
		}
		// adapt in ifile
		if(result == null) {
			result = (IFile)Platform.getAdapterManager().getAdapter(selectedObj, IFile.class);
		}
		if(result == null) {
			// try to check if it is a collection
			Collection<?> collec = (Collection<?>)Platform.getAdapterManager().getAdapter(selectedObj, Collection.class);
			if(collec != null) {
				for(Object o : collec) {
					if(o instanceof IFile) {
						IFile f = (IFile)o;
						if("di".equals(f.getFileExtension())) {
							result = f;
							break;
						}
					}
				}
			}
		}
		return result != null && "di".equals(result.getFileExtension()) ? result : null;
	}


	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		ExportAllDiagramsDialog exportPopup = new ExportAllDiagramsDialog(Activator.getActiveWorkbenchShell(), convertSelection2File(selection));
		if(exportPopup.open() == Window.OK) {
			final IFile file = convertSelection2File(selection);
			ExportAllDiagrams exportAllDiagrams;
			exportAllDiagrams = new ExportAllDiagrams(file, exportPopup.getOutputDirectory().getLocation().toString(), exportPopup.getExporter(), exportPopup.getQualifiedName());
			exportAllDiagrams.exportDiagramsToImages();
		}
		return null;
	}

}
