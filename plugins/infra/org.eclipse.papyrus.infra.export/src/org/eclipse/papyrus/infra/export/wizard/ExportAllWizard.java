/*******************************************************************************
 * Copyright (c) 2011 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anass RADOUANI (AtoS) 
 *******************************************************************************/

package org.eclipse.papyrus.infra.export.wizard;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.infra.export.ExportAllDiagrams;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

public class ExportAllWizard extends Wizard implements IExportWizard {

	/** wizard page to export all diagram from a Papyrus model */
	private ExportDiagramsPage page;

	/** error wizard page shown when the selected file is incorrect */
	private ExportDiagramsErrorPage pageError;

	/** Selected file */
	private IFile file;

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		file = convertSelection2File(selection);
		if(file != null) {
			page = new ExportDiagramsPage(file);
			addPage(page);
		} else {
			pageError = new ExportDiagramsErrorPage();
			addPage(pageError);
		}

	}

	@Override
	public boolean canFinish() {
		if(file == null) {
			return false;
		}
		return super.canFinish();
	}

	@Override
	public boolean performFinish() {
		if(file == null) {
			return false;
		} else {
			if(!page.getExport().getOutputDirectory().isAccessible()) {
				page.setErrorMessage(Messages.ExportAllWizard_0);
				return false;
			}
			page.setErrorMessage(null);
			new ExportAllDiagrams(file, page.getExport().getOutputDirectory().getLocation().toString(), page.getExport().getExporter(), page.getExport().getQualifiedName()).exportDiagramsToImages();
			return true;
		}
	}

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

	/**
	 * return the IFile corresponding to the selection
	 * 
	 * @param selectedObj
	 *        selected file
	 * @return
	 */
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
						if("di".equals(f.getFileExtension())) { //$NON-NLS-1$
							result = f;
							break;
						}
					}
				}
			}
		}
		return result != null && "di".equals(result.getFileExtension()) ? result //$NON-NLS-1$
		: null;
	}

}
