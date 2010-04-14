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

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;

/**
 * Participant that is aware of the renaming of a model.
 * 
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 * 
 */
public class RenameModelParticipant extends RenameParticipant {

	private IFile fileToRename;

	private IFile newFile;

	/**
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#createPreChange(org.eclipse.core.runtime.IProgressMonitor)
	 * 
	 * @param pm
	 *        The progress monitor.
	 * @return The change.
	 * @throws CoreException
	 * @throws OperationCanceledException
	 */

	@Override
	public Change createPreChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return new DirtyEditorChange(fileToRename, newFile);
	}

	/**
	 * Overrides checkConditions.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#checkConditions(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext)
	 */
	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context) throws OperationCanceledException {
		return new RefactoringStatus();
	}

	/**
	 * Overrides createChange.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#createChange(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return new RenameModelChange(fileToRename, newFile);
	}

	/**
	 * Overrides getName.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#getName()
	 */
	@Override
	public String getName() {
		return "Papyrus Model Renaming";
	}

	/**
	 * Overrides initialize.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#initialize(java.lang.Object)
	 */
	@Override
	protected boolean initialize(Object element) {
		if(!(element instanceof IFile)) {
			return false;
		}
		fileToRename = (IFile)element;
		String ext = fileToRename.getFileExtension();
		
			IContainer parent = fileToRename.getParent();
			String newName = getArguments().getNewName();
			int idx = newName.lastIndexOf('.');
			if(idx > 0) {
				newName = newName.substring(0, idx);
			} else {
				newName = newName + '.' + ext; // Always append the extension
			}
			IPath path;
			IPath resourcePath = fileToRename.getFullPath().removeFileExtension();
			boolean otherFiles = false;
			for(IFile file : ModelParticipantHelpers.getRelatedFiles(fileToRename)) {
				path = resourcePath.addFileExtension(file.getFileExtension());
				// Only add the change if the resource exists
				IFile renFile = parent.getFile(path.makeRelativeTo(parent.getFullPath()));
				if(!path.equals(fileToRename.getFullPath()) && renFile.exists()) {
					otherFiles = true;
					break;
				}
			}
			if(otherFiles) {
				// Get the new file
				IPath newDiPath = fileToRename.getFullPath().removeLastSegments(1);
				newDiPath = newDiPath.append(newName).addFileExtension(ext);
				newFile = parent.getFile(newDiPath.makeRelativeTo(parent.getFullPath()));
			return true;
		} else {
			return false;
		}
		
	}
}
