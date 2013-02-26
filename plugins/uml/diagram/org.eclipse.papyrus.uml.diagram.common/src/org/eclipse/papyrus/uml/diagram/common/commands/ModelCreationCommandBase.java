/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.extension.commands.IModelCreationCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;

/**
 * The Class ModelCreationCommandBase.
 */
public abstract class ModelCreationCommandBase implements IModelCreationCommand {

	/**
	 * @see org.eclipse.papyrus.infra.core.extension.commands.IModelCreationCommand#createModel(org.eclipse.papyrus.infra.core.utils.DiResourceSet)
	 * 
	 * @param diResourceSet
	 */
	public void createModel(final ModelSet modelSet) {
		runAsTransaction(modelSet);
	}

	/**
	 * Run as transaction.
	 * 
	 * @param diResourceSet
	 *        the di resource set
	 */
	protected void runAsTransaction(final ModelSet modelSet) {
		// Get the uml element to which the newly created diagram will be
		// attached.
		// Create the diagram
		final Resource modelResource = UmlUtils.getUmlResource(modelSet);
		TransactionalEditingDomain editingDomain = modelSet.getTransactionalEditingDomain();

		AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, "Initialize model", Collections.EMPTY_LIST) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				EObject model = getRootElement(modelResource);
				attachModelToResource(model, modelResource);

				initializeModel(model);
				return CommandResult.newOKCommandResult();

			}
		};
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
	}

	/**
	 * Initialize model.
	 * 
	 * @param owner
	 *        the owner
	 */
	protected void initializeModel(EObject owner) {

	}

	/**
	 * Get the root element associated with canvas.
	 * 
	 * @param modelResource
	 *        the model resource
	 * @return the root element
	 */
	protected EObject getRootElement(Resource modelResource) {
		EObject rootElement = null;
		if(modelResource != null && modelResource.getContents() != null && modelResource.getContents().size() > 0) {
			Object root = modelResource.getContents().get(0);
			if(root instanceof EObject) {
				rootElement = (EObject)root;
			}
		} else {
			rootElement = createRootElement();
		}
		return rootElement;
	}

	/**
	 * Store model element in the resource.
	 */
	protected void attachModelToResource(EObject root, Resource resource) {
		resource.getContents().add(root);
	}

	/**
	 * Create the root element of an EMF model
	 * 
	 * @return the root element
	 */
	protected abstract EObject createRootElement();

}
