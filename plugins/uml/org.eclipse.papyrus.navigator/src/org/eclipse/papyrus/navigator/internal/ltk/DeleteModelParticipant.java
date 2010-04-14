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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteParticipant;
import org.eclipse.ltk.core.refactoring.resource.DeleteResourceChange;

/**
 * The participant that is aware of file deletion.
 * 
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 * 
 */
public class DeleteModelParticipant extends DeleteParticipant {

	private List<IFile> filesToRemove;

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
		List<Change> changes = new ArrayList<Change>(filesToRemove.size());
		for(IFile file : filesToRemove) {
			if(file.exists()) {
				changes.add(new InternalDeleteResourceChange(file.getFullPath(), true));
			}
		}
		if(changes.isEmpty()) {
			return new NullChange();
		} else {
			return new CompositeChange(getName(), changes.toArray(new Change[changes.size()]));
		}
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
		return "Papyrus Model Deletion";
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

		filesToRemove = ModelParticipantHelpers.getRelatedFiles(file);
		return filesToRemove.size() > 0;
	}



	private class InternalDeleteResourceChange extends DeleteResourceChange {

		/**
		 * Constructor.
		 * 
		 * @param resourcePath
		 *        The file to delete.
		 * @param forceOutOfSync
		 *        Delete even if out of sync
		 */
		public InternalDeleteResourceChange(IPath resourcePath, boolean forceOutOfSync) {
			super(resourcePath, forceOutOfSync);
		}

		/**
		 * @see org.eclipse.ltk.core.refactoring.resource.DeleteResourceChange#perform(org.eclipse.core.runtime.IProgressMonitor)
		 * 
		 * @param pm
		 * @return
		 * @throws CoreException
		 */

		@Override
		public Change perform(IProgressMonitor pm) throws CoreException {
			IResource resource = getModifiedResource();
			// If the user selects the 3 resources, the delete fails.
			if(resource == null || !resource.exists()) {
				return new NullChange();
			}
			return super.perform(pm);
		}
	}
}
