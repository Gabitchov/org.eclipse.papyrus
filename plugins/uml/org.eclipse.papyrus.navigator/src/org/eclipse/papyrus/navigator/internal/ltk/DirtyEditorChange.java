/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a> - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigator.internal.ltk;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.widgets.Display;


/**
 * A change that checks if an editor is actually editing the model and if it must be save.
 * 
 * @author tszadel
 * 
 */
public class DirtyEditorChange extends Change {

	private final IFile oldFile;

	private final IFile newFile;

	/**
	 * Constructor.
	 * 
	 * @param resourceSet
	 *        The resource set being changed.
	 * @param oldFile
	 *        The old file.
	 * @param newFile
	 *        The new file.
	 */
	public DirtyEditorChange(IFile oldFile, IFile newFile) {
		this.oldFile = oldFile;
		this.newFile = newFile;
	}

	/**
	 * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
	 * 
	 * @return
	 */

	@Override
	public Object getModifiedElement() {
		return oldFile;
	}

	/**
	 * @see org.eclipse.ltk.core.refactoring.Change#getName()
	 * 
	 * @return
	 */

	@Override
	public String getName() {
		return "Check opened editors";
	}

	/**
	 * @see org.eclipse.ltk.core.refactoring.Change#initializeValidationData(org.eclipse.core.runtime.IProgressMonitor)
	 * 
	 * @param pm
	 */

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
		// Nothing
	}


	private boolean hasDirtyEditors() {
		IMultiDiagramEditor[] list = EditorUtils.getRelatedEditors(oldFile);
		if(list != null && list.length > 0) {
			for(IMultiDiagramEditor editor : list) {
				if(editor.isDirty()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @see org.eclipse.ltk.core.refactoring.Change#isValid(org.eclipse.core.runtime.IProgressMonitor)
	 * 
	 * @param pm
	 *        The progress monitor.
	 * @return The status.
	 * @throws CoreException
	 *         Error.
	 * @throws OperationCanceledException
	 *         Operation canceled.
	 */

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		final RefactoringStatus status = new RefactoringStatus();
		// We need to get the current workbench... so we have to use the UI-Thread!
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				if(hasDirtyEditors()) {
					if(!MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Confirm saving", "The related editor(s) must be saved to continue.")) {
						status.addFatalError("User doesn't want to save the related editor(s)");
					}
				}
			}
		});

		return status;
	}

	/**
	 * @see org.eclipse.ltk.core.refactoring.Change#perform(org.eclipse.core.runtime.IProgressMonitor)
	 * 
	 * @param pm
	 *        The progress monitor.
	 * @return The change used to undo.
	 * @throws CoreException
	 *         Error.
	 */

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		// Nothing to do
		return new DirtyEditorChange(newFile, oldFile);
	}
}
