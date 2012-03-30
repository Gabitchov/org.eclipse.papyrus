/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Mario Cervera Ubeda (Prodevelop)
 *
 ******************************************************************************/
package org.eclipse.papyrus.commands.wrappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

// TODO: Auto-generated Javadoc
/**
 * A GMF Command that wraps an EMF command. Each method is redirected to the EMF one.
 */
public class EMFtoGMFCommandWrapper extends AbstractCommand {

	/**
	 * The wrapped EMF Command. Package-level visibility so that the command stack wrapper can
	 * access the field.
	 */
	private final Command emfCommand;

	/**
	 * Constructor.
	 * 
	 * @param emfCommand
	 *        the emf command
	 */
	public EMFtoGMFCommandWrapper(Command emfCommand) {
		super(emfCommand.getLabel());
		this.emfCommand = emfCommand;
	}

	/**
	 * Returns the wrapped EMF command.
	 * 
	 * @return the EMF command
	 */
	// @unused
	public org.eclipse.emf.common.command.Command getEMFCommand() {
		return emfCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.common.core.command.AbstractCommand#
	 * doExecuteWithResult(org.eclipse .core.runtime.IProgressMonitor,
	 * org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		if(canExecute()) {
			emfCommand.execute();
		}

		return CommandResult.newOKCommandResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doRedoWithResult
	 * (org.eclipse. core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		emfCommand.redo();

		return CommandResult.newOKCommandResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doUndoWithResult
	 * (org.eclipse. core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		if(canUndo()) {
			emfCommand.undo();
		}

		return CommandResult.newOKCommandResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return emfCommand.canExecute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#dispose()
	 */
	@Override
	public void dispose() {
		emfCommand.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return emfCommand.canUndo();
	}

	@Override
	public List getAffectedFiles() {
		ArrayList affectedFiles = new ArrayList();
		Collection<?> affectedObjects = emfCommand.getAffectedObjects();
		if (affectedObjects != null) {
			for (Object o : affectedObjects) {
				if (o instanceof IFile) {
					affectedFiles.add(o);
				} else if (o instanceof EObject) {
					Resource res = ((EObject)o).eResource();
					if (res != null) {
						IFile file = WorkspaceSynchronizer.getFile(res);
						if (file != null) {
							affectedFiles.add(file);
						}
					}
				}
			}
		}
		return affectedFiles;
	}

	@Override
	public CommandResult getCommandResult() {
		Collection<?> res = emfCommand.getResult();
		if (res != null && !res.isEmpty()) {
			if (res.size() == 1) {
				return CommandResult.newOKCommandResult(res.iterator().next());
			}
			return CommandResult.newOKCommandResult(res);
		}
		return CommandResult.newOKCommandResult();
	}
}
