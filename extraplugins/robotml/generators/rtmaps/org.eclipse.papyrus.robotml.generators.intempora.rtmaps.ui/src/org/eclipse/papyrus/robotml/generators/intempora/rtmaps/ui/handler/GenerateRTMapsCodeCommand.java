/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.robotml.generators.intempora.rtmaps.ui.handler;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;


// TODO: Auto-generated Javadoc
/**
 * The Class GenerateRTMapsCodeCommand.
 */
public class GenerateRTMapsCodeCommand extends AbstractTransactionalCommand {

	/** The transactional edition domain. */
	private final TransactionalEditingDomain domain;

	/** The selected element. */
	private final EObject selectedElement;

	/** The rtmaps target folder path. */
	private final String rtmapsTargetFolderPath;


	/**
	 * Instantiates a new generate rt maps code command.
	 * 
	 * @param label
	 *        the label
	 * @param domain
	 *        the domain
	 * @param selectedElement
	 *        the selected element
	 * @param rtmapsTargetFolderPath
	 *        the rtmaps target folder path
	 */
	public GenerateRTMapsCodeCommand(String label, TransactionalEditingDomain domain, EObject selectedElement, String rtmapsTargetFolderPath) {
		super(domain, label, Collections.EMPTY_LIST);
		this.domain = domain;
		this.selectedElement = selectedElement;
		this.rtmapsTargetFolderPath = rtmapsTargetFolderPath;
	}


	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// TODO Auto-generated method stub


		//System.err.println("Model Exlorer generation menu RTMaps");

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		//final ProgressMonitorDialog monitordialog = new ProgressMonitorDialog(shell);
		AcceleoRTMapsCodeGenerator codeGenerator = new AcceleoRTMapsCodeGenerator();
		codeGenerator.runAcceleoTransformation(selectedElement, rtmapsTargetFolderPath);
		/*
		 * try {
		 * 
		 * monitordialog.run(true, true, new IRunnableWithProgress() {
		 * 
		 * 
		 * public void run(IProgressMonitor monitor)
		 * throws InvocationTargetException, InterruptedException {
		 * monitor.beginTask("Generating Acceleo files", 100);
		 * AcceleoRTMapsCodeGenerator codeGenerator = new AcceleoRTMapsCodeGenerator();
		 * codeGenerator.runAcceleoTransformation(selectedElement, rtmapsTargetFolderPath);
		 * monitor.done();
		 * }
		 * 
		 * });
		 * 
		 * } catch (InvocationTargetException e) {
		 * // TODO Auto-generated catch block
		 * e.printStackTrace();
		 * } catch (InterruptedException e) {
		 * // TODO Auto-generated catch block
		 * e.printStackTrace();
		 * }
		 */


		return CommandResult.newOKCommandResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {

		return (selectedElement != null && rtmapsTargetFolderPath != null && domain != null);
	}
}
