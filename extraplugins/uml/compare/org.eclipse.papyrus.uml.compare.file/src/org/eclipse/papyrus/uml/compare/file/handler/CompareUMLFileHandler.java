/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.file.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.compare.file.Activator;
import org.eclipse.papyrus.uml.compare.file.editor.CompareUMLFileEditor;
import org.eclipse.papyrus.uml.compare.file.messages.Messages;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * The handler which allows to open the PapyrusUMLFileCompareEditor
 * 
 */
public class CompareUMLFileHandler extends AbstractHandler implements IObjectActionDelegate {

	/** The uml file extension */
	public static final String UML_EXTENSION = "uml"; //$NON-NLS-1$

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<IFile> selectedFiles = getSelection();
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorInput input = new CompareUMLFileInput(selectedFiles);//.get(0), selectedFiles.get(1));
		try {
			//we open the compare editor
			page.openEditor(input, CompareUMLFileEditor.COMPARE_UML_FILE_EDITOR_ID, true);
		} catch (PartInitException e) {
			Activator.log.error(Messages.CompareUMLFileHandler_ICantOpenThePapyrusCompareEdito, e);
		}
		return null;
	}


	/**
	 * 
	 * @return
	 *         a list owning the selected files
	 */
	protected List<IFile> getSelection() {
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		List<IFile> currentSelection = new ArrayList<IFile>();
		Iterator<?> iter = ((IStructuredSelection)selection).iterator();
		while(iter.hasNext()) {
			Object current = iter.next();
			if(current instanceof IAdaptable) {
				IFile file = (IFile)((IAdaptable)current).getAdapter(IFile.class);
				if(file != null) {
					currentSelection.add(file);
				}
			}
		}
		return currentSelection;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		List<?> selectedElement = getSelection();
		if(selectedElement.size() != 2) {
			return false;
		}
		Iterator<?> iter = selectedElement.iterator();
		while(iter.hasNext()) {
			Object current = iter.next();
			if(current instanceof IFile) {
				String extension = ((IFile)current).getFileExtension();
				if(!extension.equals(UML_EXTENSION)) {
					return false;
				}
			}
		}
		return super.isEnabled();
	}

	/**
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 * 
	 * @param action
	 */
	public void run(IAction action) {
		if(isEnabled()) {
			try {
				execute(new ExecutionEvent());
			} catch (ExecutionException e) {
				Activator.log.error(e);
			}
		}

	}

	public void selectionChanged(IAction action, ISelection selection) {
		//nothing to do

	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		//nothing to do
	}


}
