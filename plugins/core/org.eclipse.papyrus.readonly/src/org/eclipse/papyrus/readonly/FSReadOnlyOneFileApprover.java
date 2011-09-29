package org.eclipse.papyrus.readonly;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
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
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.internal.command.ICommandWithSettableResult;
import org.eclipse.papyrus.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.onefile.utils.OneFileUtils;

public class FSReadOnlyOneFileApprover implements IOperationApprover2 {

	public IStatus proceedRedoing(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
		return proceedExecuting(operation, history, info);
	}

	public IStatus proceedUndoing(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
		return proceedExecuting(operation, history, info);
	}

	public IStatus proceedExecuting(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {

		if(operation instanceof ICommand) {
			ICommand command = (ICommand)operation;
			List<IFile> affectedFiles = command.getAffectedFiles();

			HashSet<IFile> filesToCheckForLock = new HashSet<IFile>();

			for(IFile affectedFile : affectedFiles) {
				if(affectedFile == null)
					continue;

				if(affectedFile.exists()) {
					// the file is in the workspace
					IPapyrusFile papFile = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(affectedFile);
					filesToCheckForLock.addAll(Arrays.asList(OneFileUtils.getAssociatedFiles(papFile)));

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

			for(IFile file : affectedFiles) {
				URI.createPlatformResourceURI(file.getFullPath().toString(), true);

			}
			if(filesToCheckForLock.size() > 0) {
				IFile[] filesToCheckForLockArray = filesToCheckForLock.toArray(new IFile[filesToCheckForLock.size()]);
				if(ReadOnlyManager.isReadOnly(filesToCheckForLock.toArray(filesToCheckForLockArray))) {
					boolean ok = ReadOnlyManager.enableWrite(filesToCheckForLockArray);
					if(!ok) {
						return Status.CANCEL_STATUS;
					}
				}
			}
		}

		return Status.OK_STATUS;
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
	public static void setCommandResult(ICommand command, IStatus status) {
		if(command instanceof ICommandWithSettableResult) {
			((ICommandWithSettableResult)command).internalSetResult(new CommandResult(status));
		}
	}

}
