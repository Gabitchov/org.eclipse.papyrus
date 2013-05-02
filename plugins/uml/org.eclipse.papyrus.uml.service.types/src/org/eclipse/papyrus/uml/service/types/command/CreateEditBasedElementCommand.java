/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.workspace.CompositeEMFOperation;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.service.types.Activator;


/**
 * Creation command based on the metamodel.edit framework instead of relying on the defaut GMF creation mechanism.
 * <P>
 * So the creation of elements is similar to the creation customized in the metamodel itself, which can be interesting for metamodels like UML. This can avoid specific code for example for Activity.createNode() list of commands.
 * </P> 
 * <P>
 * The implementation relies on a composite command that delegates first the basic creation of the element to the metamodel.edit service.<BR/>
 * A second operation computes during execution the list of additional commands to configure the newly created element. For example, the name of the new element can be set in configure commands. 
 * Note: the configure command needs the newly created command, so the list of operations to perform is unknown until the composite operation is executed. The executability of the 2nd set of commands can be hard to test.
 * </P>
 */
public class CreateEditBasedElementCommand extends CreateElementCommand {

	/** newly created element */
	protected EObject newElement;
	
	/** composite operation in charge of listing and executing all performed operations */
	protected CompositeEMFOperation compositeEMFOperation;

	/**
	 * Constructor.
	 * 
	 * @param request
	 *        create element request creating this command
	 */
	public CreateEditBasedElementCommand(CreateElementRequest request) {
		super(request);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(compositeEMFOperation !=null && compositeEMFOperation.canUndo()) {
			return compositeEMFOperation.undo(monitor, info);
		}
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "imposible to undo the command");
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(compositeEMFOperation !=null && compositeEMFOperation.canRedo()) {
			return compositeEMFOperation.redo(monitor, info);
		}
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "imposible to redo the command");
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		return super.canExecute();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		
		compositeEMFOperation = new CompositeEMFOperation(getEditingDomain(), "Create Element");
		// creates the basic element
		AbstractTransactionalCommand createTransactionalCommand = new AbstractTransactionalCommand(getEditingDomain(), "Create basic element", getAffectedFiles()) {

			/** emf command */
			private Command command;

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				 // Do the default element creation
				EReference containment = getContainmentFeature();
				EClass eClass = getElementType().getEClass();

				if(containment != null) {
					EObject element = getElementToEdit();

					if(element != null) {

						newElement = eClass.getEPackage().getEFactoryInstance().create(eClass);
						IEditingDomainItemProvider editingDomainItemProvider = AdapterFactoryEditingDomain.getEditingDomainItemProviderFor(element);
						command = editingDomainItemProvider.createCommand(element, getEditingDomain(), CreateChildCommand.class, new CommandParameter(element, containment, new CommandParameter(null, containment, newElement)));
						if(command.canExecute()) {
							
							// create an IUndoableOperation => undo is relying on the execution of this command
							command.execute();
							return CommandResult.newOKCommandResult(newElement);
						}
					}
				}
				return CommandResult.newErrorCommandResult("Impossible to create Element");
			}
			
			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean canUndo() {
				return command.canUndo();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				command.undo();
				return Status.OK_STATUS;
			}
			
			/**
			 * {@inheritDoc}
			 */
			@Override
			protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				command.redo();
				return Status.OK_STATUS;
			}
		};
		compositeEMFOperation.add(createTransactionalCommand);
		
		AbstractTransactionalCommand configureTransactionalCommand = new AbstractTransactionalCommand(getEditingDomain(), "Configure element", getAffectedFiles()) {
			
			/**
			 * {@inheritDoc}ondre 
			 */
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				 // Configure the new element
		        ConfigureRequest configureRequest = createConfigureRequest();

		        ICommand configureCommand = getElementType().getEditCommand(configureRequest);
		        
		        IStatus configureStatus = null;
		        
		        if (configureCommand != null && configureCommand.canExecute()) {
		        	configureStatus = configureCommand.execute(monitor, info);
		        }

		        // Put the newly created element in the request so that the
		        // 'after' commands have access to it. 
		        getCreateRequest().setNewElement(newElement);

		        return (configureStatus == null) ? 
		        		CommandResult.newOKCommandResult(newElement) : 
		        		new CommandResult(configureStatus, newElement);
			}
		};
		
		// executes the command and then adds it to the list 
		compositeEMFOperation.add(configureTransactionalCommand); // add before execution
		
		IStatus compositeStatus = compositeEMFOperation.execute(monitor, info);
        return (compositeStatus == null) ? 
        		CommandResult.newOKCommandResult(newElement) : 
        		new CommandResult(compositeStatus, newElement);
	}

	/**
	 * Creates the request to configure the new element.
	 * 
	 * @return the request
	 */
	protected ConfigureRequest createConfigureRequest() {

		ConfigureRequest configureRequest = new ConfigureRequest(
            getEditingDomain(), newElement, getElementType());
        
		// pass along the client context
		configureRequest.setClientContext(getCreateRequest().getClientContext());
		
        configureRequest.addParameters(getRequest().getParameters());

		return configureRequest;
	}
	
}