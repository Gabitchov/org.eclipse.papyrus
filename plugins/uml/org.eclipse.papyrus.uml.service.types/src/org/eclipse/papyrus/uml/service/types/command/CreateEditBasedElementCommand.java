/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 431109
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
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

	/** Shadow the base class's element-to-edit because we need direct access. */
	private EObject elementToEdit;
	
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
		
		EObject container = request.getContainer();
		if((container != null) && container.eClass().getEAllContainments().contains(request.getContainmentFeature())) {
			setElementToEdit(container);
		}
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
		// The superclass implementation can short-circuit the effort of preparing the operation
		return super.canExecute() && prepareOperation().canExecute();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IUndoableOperation operation = prepareOperation();
		
		IStatus compositeStatus = operation.execute(monitor, info);
        return (compositeStatus == null) ? 
        		CommandResult.newOKCommandResult(newElement) : 
        		new CommandResult(compositeStatus, newElement);
	}
	
	protected IUndoableOperation prepareOperation() {
		if (compositeEMFOperation == null) {
			compositeEMFOperation = new CompositeEMFOperation(getEditingDomain(), "Create Element");
			// creates the basic element
			AbstractTransactionalCommand createTransactionalCommand = new AbstractTransactionalCommand(getEditingDomain(), "Create basic element", getAffectedFiles()) {
	
				/** emf command */
				private Command command;
	
				@Override
				public boolean canExecute() {
					// Optimistically enable if the request would have to create the container, because
					// we can't do that in a read-only context (when not actually executing)
					return canCreateChild() && (!hasElementToEdit() || prepareCommand().canExecute());
				}
				
				/**
				 * {@inheritDoc}
				 */
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					Command command = prepareCommand();
					
					if(command.canExecute()) {
						
						// create an IUndoableOperation => undo is relying on the execution of this command
						command.execute();
						return CommandResult.newOKCommandResult(newElement);
					}
					
					return CommandResult.newErrorCommandResult("Impossible to create Element");
				}
				
				/**
				 * Prepares the EMF command to which we delegate execution, if it has not already been
				 * created.  This is not safe to do in a read-only context if our request does not
				 * {@link CreateEditBasedElementCommand#hasElementToEdit() have a container}, because
				 * this would attempt to create that container.
				 * 
				 * @see CreateEditBasedElementCommand#hasElementToEdit()
				 */
				protected Command prepareCommand() {
					if (command == null) {
						 // Do the default element creation
						EReference containment = getContainmentFeature();
						EClass eClass = getElementType().getEClass();
		
						if(containment != null) {
							EObject element = getElementToEdit();
		
							if(element != null) {
		
								newElement = eClass.getEPackage().getEFactoryInstance().create(eClass);
								IEditingDomainItemProvider editingDomainItemProvider = AdapterFactoryEditingDomain.getEditingDomainItemProviderFor(element);
								command = editingDomainItemProvider.createCommand(element, getEditingDomain(), CreateChildCommand.class, new CommandParameter(element, containment, new CommandParameter(null, containment, newElement)));
							}
						}
						
						if (command == null) {
							// Couldn't create a useful command
							command = UnexecutableCommand.INSTANCE;
						}
					}
					
					return command;
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
		}
		
		return compositeEMFOperation;
	}
	
	protected boolean isPrepared() {
		return compositeEMFOperation != null;
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
	
	/**
	 * Queries whether I know my element to edit, yet.
	 * 
	 * @return whether I have an element to edit
	 */
	protected boolean hasElementToEdit() {
		return elementToEdit != null;
	}
	
	@Override
	protected void setElementToEdit(EObject element) {
		this.elementToEdit = element;
		super.setElementToEdit(element);
	}
	
	/**
	 * An enablement filter heuristically determining whether we think we will be able to create the child element.
	 * 
	 * @return whether we can create the new child element
	 */
	protected boolean canCreateChild() {
		// Assume we can unless we think we can't
		boolean result = true;

		// This is an additional constraint in the EMF CreateChildCommand that we use, that the GMF CreateElementCommand doesn't apply
		Object context = getRequest().getEditHelperContext();
		if(context instanceof EObject) {
			EObject owner = (EObject)context;
			EReference reference = getContainmentFeature();
			
			// The context may not have this reference if some intermediate container is to be created by the edit-helper.
			// But, then, we can only optimistically report that we can create the child
			if((reference != null) && !reference.isMany() && (owner.eClass().getEAllReferences().contains(reference))) {
				// Don't replace an existing value
				result = ((EObject)context).eGet(reference) == null;
			}
		}

		return result;
	}
	
	@Override
	public void dispose() {
		if(isPrepared()) {
			compositeEMFOperation.dispose();
			compositeEMFOperation = null;
		}
		
		super.dispose();
	}
}