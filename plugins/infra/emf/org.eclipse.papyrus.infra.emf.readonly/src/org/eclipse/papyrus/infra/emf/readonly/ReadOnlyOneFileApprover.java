/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.operations.IOperationApprover2;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.common.core.internal.command.ICommandWithSettableResult;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;

import com.google.common.base.Optional;

public class ReadOnlyOneFileApprover implements IOperationApprover2 {

	public IStatus proceedRedoing(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
		return proceedExecuting(operation, history, info);
	}

	public IStatus proceedUndoing(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
		return proceedExecuting(operation, history, info);
	}

	public IStatus proceedExecuting(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
		HashSet<URI> filesToCheckForLock = new HashSet<URI>();

		if(operation instanceof ICommand) {
			ICommand command = (ICommand)operation;
			List<IFile> affectedFiles = command.getAffectedFiles();

			for(IFile affectedFile : affectedFiles) {
				if(affectedFile == null)
					continue;

				if(affectedFile.exists()) {
					// the file is in the workspace
					IPapyrusFile papFile = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(affectedFile);
					for (IFile f : OneFileUtils.getAssociatedFiles(papFile)) {
						filesToCheckForLock.add(URI.createPlatformResourceURI(f.getFullPath().toString(), true));
					}
				} else {
					// the file is not in the workspace
					IPath path = affectedFile.getRawLocation();
					if(path == null) {
						// cancel if we can't find the file
						setCommandResult(command, Status.CANCEL_STATUS);
						return Status.CANCEL_STATUS;
					}
					File file = path.toFile();
					if(file != null && file.exists() && !file.canWrite()) {
						// cancel if we find a read-only file outside the
						// workspace
						setCommandResult(command, Status.CANCEL_STATUS);
						return Status.CANCEL_STATUS;
					}
				}
			}
		}
		
		EditingDomain editingDomain = getEditingDomain(operation);

		URI[] filesToCheckForLockArray = filesToCheckForLock.toArray(new URI[filesToCheckForLock.size()]);
		if(ReadOnlyManager.getInstance().anyReadOnly(filesToCheckForLockArray, editingDomain).get()) {
			Optional<Boolean> ok = ReadOnlyManager.getInstance().makeWritable(filesToCheckForLockArray, editingDomain);
			if(!ok.get()) {
				return Status.CANCEL_STATUS;
			}
		}

		return Status.OK_STATUS;
	}
	
	protected EditingDomain getEditingDomain(IUndoableOperation command) {
		EditingDomain editingDomain = null;
		if (command instanceof AbstractEMFOperation) {
			editingDomain = ((AbstractEMFOperation)command).getEditingDomain();
		}

		if (editingDomain == null && command instanceof ICompositeCommand) {
			Iterator it = ((ICompositeCommand)command).iterator();
			while (editingDomain == null && it.hasNext()) {
				IUndoableOperation c = (IUndoableOperation)it.next();
				editingDomain = getEditingDomain(c);
			}
		}
		return editingDomain;
	}

	/**
	 * Sets the command result of the specified command to a CommandResult
	 * having the specified status.
	 * 
	 * @param command
	 *        ICommand to set the CommandResult for
	 * @param status
	 *        IStatus of the CommandResult that will be set on the
	 *        command
	 */
	protected void setCommandResult(ICommand command, IStatus status) {
		if(command instanceof ICommandWithSettableResult) {
			((ICommandWithSettableResult)command).internalSetResult(new CommandResult(status));
		}
	}

}
