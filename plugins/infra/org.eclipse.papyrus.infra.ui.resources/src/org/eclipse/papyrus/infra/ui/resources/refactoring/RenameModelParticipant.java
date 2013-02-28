/*****************************************************************************
 * Copyright (c) 2009 Atos Origin - CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a> - Initial API and implementation
 *	Camille Letavernier (CEA LIST) camille.letavernier@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.resources.refactoring;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Participant that is aware of the renaming of a model.
 * 
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 * 
 */
public class RenameModelParticipant extends RenameParticipant {

	private IFile fileToRename;

	private IFile newFile;

	private Collection<? extends IResource> impacted;

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
		if(isDiFile(fileToRename) && DiModel.DI_FILE_EXTENSION.equals(newFile.getFileExtension())) {
			Collection<IResource> conflictingFiles = findConflictingFiles();
			if(!conflictingFiles.isEmpty()) {
				//Conflicts have been detected. Warn the user.

				final String[] fileNames = new String[conflictingFiles.size()];

				int i = 0;
				for(IResource resource : conflictingFiles) {
					fileNames[i++] = resource.getName();
				}

				String defaultMessage;

				if(fileNames.length == 1) {
					defaultMessage = "The file " + fileNames[0] + " already exists. Delete it or choose another name";
				} else {
					defaultMessage = "Some files alreay exist. Delete them or choose another name. Files: " + Arrays.deepToString(fileNames);
				}

				Display display = Display.getDefault();
				if(display != null) {

					RunnableWithResult<Boolean> runnable;
					Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl<Boolean>() {

						public void run() {
							setResult(false);
							final Shell shell = Display.getDefault().getActiveShell();
							if(shell != null) {
								String title, message;

								if(fileNames.length == 1) {
									title = "The file " + fileNames[0] + " already exists.";
									message = "The file " + fileNames[0] + " already exists. Do you want to delete it? (Warning: This operation cannot be undone)";
								} else {
									title = "Some files already exist";
									message = "The files " + Arrays.deepToString(fileNames) + " alreay exist. Do you want to delete them? (Warning: This operation cannot be undone)";
								}

								boolean result = MessageDialog.openQuestion(shell, title, message);
								setResult(result);
								setStatus(Status.OK_STATUS);
							}
						}

					});

					if(runnable.getResult()) {
						try {
							for(IResource resource : conflictingFiles) {
								resource.delete(true, new NullProgressMonitor());
								impacted.remove(resource);
							}
						} catch (CoreException ex) {
							//FIXME: Inconsistent state. Use a DeleteResourceChange to allow valid Undo/Redo
							//Use preChange?
							return RefactoringStatus.createFatalErrorStatus(ex.getMessage());
						}
					} else {
						pm.setCanceled(true); //Cancel the refactoring
						return new RefactoringStatus();
					}
				} else {
					return RefactoringStatus.createFatalErrorStatus(defaultMessage);
				}
			}
		}

		return new RefactoringStatus();
	}

	private Collection<IResource> findConflictingFiles() {
		List<IResource> conflictingFiles = new LinkedList<IResource>();

		if(isDiFile(fileToRename)) {
			//Check whether conflicting files exist.
			Collection<IResource> participants = ModelParticipantHelpers.getRelatedFiles(fileToRename);
			participants.add(fileToRename);
			for(IResource participant : participants) {
				IContainer parent = participant.getParent();
				String targetName = newFile.getFullPath().removeFileExtension().addFileExtension(participant.getFileExtension()).lastSegment();
				IFile targetFile = parent.getFile(new Path(targetName));
				if(targetFile.exists()) {
					conflictingFiles.add(targetFile);
				}
			}
		}

		return conflictingFiles;
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
		return new RenameModelChange(fileToRename, newFile, impacted);
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

		if(!isDiFile((IFile)element)) {
			return false;
		}

		fileToRename = (IFile)element;
		String ext = fileToRename.getFileExtension();

		IContainer parent = fileToRename.getParent();
		String newName = getArguments().getNewName();

		int idx = newName.lastIndexOf('.');
		//Do not refactor when the user remove or changes the extension: This is not a valid Papyrus model anymore
		if(idx > 0) {
			String extension = newName.substring(idx + 1);
			if(!DiModel.DI_FILE_EXTENSION.equals(extension)) { //Extension changed
				return false;
			}
			newName = newName.substring(0, idx);
		} else {
			return false; //No extension
		}

		boolean otherFiles = false;
		for(IResource file : ModelParticipantHelpers.getRelatedFiles(fileToRename)) {
			IPath path = file.getFullPath();
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
			impacted = ModelParticipantHelpers.getResourceToFix(fileToRename);
			return true;
		} else {
			return false;
		}

	}

	private boolean isDiFile(IFile file) {
		return DiModel.DI_FILE_EXTENSION.equals(file.getFileExtension());
	}
}
