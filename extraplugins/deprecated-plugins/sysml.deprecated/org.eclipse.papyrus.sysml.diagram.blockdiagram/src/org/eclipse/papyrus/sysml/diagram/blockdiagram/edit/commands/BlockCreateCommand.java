/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.resource.Resource;
import org.eclipse.papyrus.resource.util.ResourceUtil;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.blocks.BlocksFactory;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.providers.ElementInitializers;

/**
 * @generated
 */
public class BlockCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private EClass eClass = null;

	/**
	 * @generated
	 */
	private EObject eObject = null;

	/**
	 * @generated
	 */
	public BlockCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static BlockCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new BlockCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public BlockCreateCommand(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	/**
	 * FIXME: replace with setElementToEdit()
	 * 
	 * @generated
	 */
	protected EObject getElementToEdit() {

		EObject container = ((CreateElementRequest)getRequest()).getContainer();
		if(container instanceof View) {
			container = ((View)container).getElement();
		}
		if(container != null) {
			return container;
		}
		return eObject;
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {

		return true;

	}

	/**
	 * @generated NOT
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		Resource owner = ResourceUtil.getResource(getElementToEdit());

		if(owner == null) {
			return CommandResult.newErrorCommandResult("No resource found"); //$NON-NLS-1$
		}

		EObject eObject = getElementToEdit();
		if(eObject instanceof org.eclipse.uml2.uml.Package) {
			org.eclipse.uml2.uml.Package pack = (org.eclipse.uml2.uml.Package)eObject;

			// Create the base class in the package
			org.eclipse.uml2.uml.Class clazz = pack.createOwnedClass("", false);

			// Create the block
			Block block = BlocksFactory.eINSTANCE.createBlock();

			// add the block to the resource
			owner.getEobjects().add(block);

			// Set the base class
			block.setBase_Class(clazz);

			doConfigure(block, monitor, info);

			// Init the name
			ElementInitializers.init_NamedElement(clazz, "block");

			((CreateElementRequest)getRequest()).setNewElement(block);
			return CommandResult.newOKCommandResult(block);
		}
		return CommandResult.newErrorCommandResult("The container is not a package element"); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	protected void doConfigure(Block newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

}
