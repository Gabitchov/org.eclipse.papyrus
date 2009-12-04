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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.MoveArguments;
import org.eclipse.ltk.core.refactoring.participants.MoveParticipant;
import org.eclipse.ltk.core.refactoring.resource.MoveResourceChange;
import org.eclipse.papyrus.core.utils.DiResourceSet;

/**
 * Participant that is aware of model deletion.
 * 
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 * 
 */
public class MoveModelParticipant extends MoveParticipant implements IModelParticipantConstants {

	private List<IFile> filesToMove = new ArrayList<IFile>();

	private IContainer destination;

	/**
	 * Overrides checkConditions.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#checkConditions(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext)
	 */
	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws OperationCanceledException {
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
		Change[] changes = new Change[filesToMove.size()];
		int i = 0;
		for(IFile path : filesToMove) {
			changes[i++] = new MoveResourceChange(path, destination);
		}
		return new CompositeChange(getName(), changes);
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
		return "Papyrus Model Move";
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
		IFile file = (IFile)element;
		String ext = file.getFileExtension();
		if(DiResourceSet.DI_FILE_EXTENSION.equals(ext) || DiResourceSet.MODEL_FILE_EXTENSION.equals(ext)
				|| DiResourceSet.NOTATION_FILE_EXTENSION.equals(ext)) {
			IContainer parent = file.getParent();
			IPath resourcePath = file.getFullPath().removeFileExtension();
			MoveArguments args = getArguments();
			if(!(args.getDestination() instanceof IContainer)) {
				return false;
			}
			destination = (IContainer)args.getDestination();

			IPath path;
			for(String pathExt : MODEL_EXTENSIONS) {
				path = resourcePath.addFileExtension(pathExt);
				// Only add the change if the resource exists
				// Note: the current file is already marked as deleted... so do not add it here!
				IFile childFile = parent.getFile(path.makeRelativeTo(parent.getFullPath()));
				if(!path.equals(file.getFullPath()) && childFile.exists()) {
					filesToMove.add(childFile);
				}
			}
			return filesToMove.size() > 0;
		}
		return false;
	}
}
