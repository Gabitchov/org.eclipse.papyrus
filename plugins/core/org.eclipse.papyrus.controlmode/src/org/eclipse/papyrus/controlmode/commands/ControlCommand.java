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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.controlmode.commands;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.EditingDomainUndoContext;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.NotationUtils;
import org.eclipse.papyrus.navigator.internal.utils.NavigatorUtils;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.papyrus.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.sashwindows.di.exception.SashEditorException;
import org.eclipse.papyrus.sashwindows.di.util.DiUtils;
import org.eclipse.ui.PlatformUI;

/**
 * @author eperico
 */
public class ControlCommand extends AbstractTransactionalCommand {

	private EObject eObject;

	private DiResourceSet diResourceSet;

	private Resource controlledModel;

	private Resource controlledNotation;

	private Resource controlledDI;

	/**
	 * Instantiates a new control command.
	 * 
	 * @param domain
	 * @param label
	 * @param affectedFiles
	 */
	@SuppressWarnings("unchecked")
	public ControlCommand(TransactionalEditingDomain domain, Resource model, EObject selectedObject, String label,
			List affectedFiles) {
		super(domain, label, affectedFiles);
		this.eObject = selectedObject;
		this.controlledModel = model;
		// Add an undo context to allow the editor to react to that change
		addContext(new EditingDomainUndoContext(domain));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		doRedo(monitor, info);
		return CommandResult.newOKCommandResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// execute uncontrol command
		try {
			UncontrolCommand transactionalCommand = new UncontrolCommand(diResourceSet.getTransactionalEditingDomain(),
					eObject, "Uncontrol", null);
			OperationHistoryFactory.getOperationHistory()
					.execute(transactionalCommand, new NullProgressMonitor(), null);
			return Status.OK_STATUS;
		} catch (ExecutionException e) {
			EMFEditUIPlugin.INSTANCE.log(e);
			return Status.CANCEL_STATUS;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// get the parent notation resource
		this.diResourceSet = NavigatorUtils.getDiResourceSet();
		final Resource notationResource = diResourceSet.getNotationResource();

		// Create the URI from models that will be created
		final URI newNotationURI = URI.createURI(controlledModel.getURI().trimFileExtension().appendFileExtension(
				DiResourceSet.NOTATION_FILE_EXTENSION).toString());
		this.controlledNotation = getResource(newNotationURI);

		final Resource diResource = diResourceSet.getDiResource();
		final URI newDiURI = URI.createURI(controlledModel.getURI().trimFileExtension().appendFileExtension(
				DiResourceSet.DI_FILE_EXTENSION).toString());
		this.controlledDI = getResource(newDiURI);

		CompoundCommand compoundCommand = new CompoundCommand();
		// === Control the Model
		compoundCommand.append(new AddCommand(getEditingDomain(), controlledModel.getContents(), eObject));

		// === Control the Notation model
		final List<Diagram> diagrams = NotationUtils.getDiagrams(notationResource, eObject);
		compoundCommand.append(new AddCommand(getEditingDomain(), controlledNotation.getContents(), diagrams));

		// === Control the DI model
		// Create a new SashWindowManager
		SashWindowsMngr windowsMngr = DiUtils.createDefaultSashWindowsMngr();

		// add pages to the page list
		for (Diagram diagram : diagrams) {
			PageRef pageRef = DiUtils.getPageRef(diResource, diagram);
			windowsMngr.getPageList().addPage(pageRef.getPageIdentifier());

			// add a tab folder
			try {
				DiUtils.addPageToTabFolder(windowsMngr, pageRef);
			} catch (SashEditorException exception) {
				EMFEditUIPlugin.INSTANCE.log(exception);
				return Status.CANCEL_STATUS;
			}
		}
		compoundCommand.append(new AddCommand(getEditingDomain(), controlledDI.getContents(), windowsMngr));

		// Ensure that all proxies are resolved so that references into the controlled object will
		// be saved to reference the new resource
		EcoreUtil.resolveAll(getEditingDomain().getResourceSet());

		compoundCommand.execute();
		saveResources();
		return Status.OK_STATUS;
	}

	/**
	 * Gets the resource from the URI, create it if not exists
	 * 
	 * @param uri
	 * 
	 * @return the resource
	 */
	private Resource getResource(URI uri) {
		Resource res = getEditingDomain().getResourceSet().getResource(uri, false);
		if (res == null) {
			res = getEditingDomain().getResourceSet().createResource(uri);
		}
		return res;
	}

	/**
	 * Save resources.
	 */
	private void saveResources() {
		try {
			controlledModel.save(null);
			controlledNotation.save(null);
			controlledDI.save(null);

			// TODO save parent resources, check if it is useful
			// diResourceSet.save(new NullProgressMonitor());
		} catch (IOException exception) {
			if (getEditingDomain().getCommandStack().canUndo()) {
				getEditingDomain().getCommandStack().undo();
			}
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					EMFEditUIPlugin.INSTANCE.getString("_UI_InvalidURI_label"), EMFEditUIPlugin.INSTANCE
							.getString("_WARN_CannotCreateResource"));
			EMFEditUIPlugin.INSTANCE.log(exception);
		}
	}

}
