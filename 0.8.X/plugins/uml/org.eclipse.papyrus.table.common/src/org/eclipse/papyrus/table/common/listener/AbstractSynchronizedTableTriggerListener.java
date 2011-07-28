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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.table.common.listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.core.AbstractModelQuery;
import org.eclipse.emf.facet.infra.query.core.ModelQuerySetCatalog;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryException;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryResult;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactoriesRegistry;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactory;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidget;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.emf.facet.widgets.nattable.internal.NatTableWidget;
import org.eclipse.emf.facet.widgets.nattable.internal.TableInstanceCommandFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.core.utils.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.table.common.Activator;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;

/**
 * 
 * This abstract class provides useful method for the TriggerListener used for the table synchronization
 * 
 */
public abstract class AbstractSynchronizedTableTriggerListener extends TriggerListener {

	/**
	 * The Papyrus table
	 */
	final protected  PapyrusTableInstance table;

	/**
	 * the nattable widget provider
	 */
	private INatTableWidgetProvider provider;
	
	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 *        the table
	 * @param provider
	 *        the nattable widget provider
	 */
	public AbstractSynchronizedTableTriggerListener(final PapyrusTableInstance table, final INatTableWidgetProvider provider) {
		this.table = table;
		this.provider = provider;
	}
	
	/**
	 * 
	 * @param domain 
	 * the editing domain
	 * @return
	 * the command to do the synchronization
	 */
	protected CompoundCommand getSynchronizationCommand(final TransactionalEditingDomain domain) {
		CompoundCommand command = new CompoundCommand("Command to synchronize table with its context"); //$NON-NLS-1$
		
		//the list of the elements to add in the table
		final List<EObject> elementsToAdd = new ArrayList<EObject>();
		//the list of the element to remove in the table
		final List<EObject> elementToRemove = new ArrayList<EObject>();
		//a new element has been added to the model
		for(ModelQuery query : this.table.getFillingQueries()) {
			ModelQuerySetCatalog catalog = ModelQuerySetCatalog.getSingleton();
			AbstractModelQuery impl = null;
			try {
				impl = catalog.getModelQueryImpl(query);
			} catch (ModelQueryException e) {
				Activator.getDefault().helper.error(e);
			}
			if(impl != null) {
				ModelQueryResult result = impl.evaluate(this.table.getTable().getContext());
				Object value = result.getValue();
				if(value instanceof Collection<?>) {
					//the build the list of the elements to add in the table 
					for(Object currentObject : (Collection<?>)value) {
						if(currentObject instanceof EObject && !this.table.getTable().getElements().contains(currentObject)) {
							elementsToAdd.add((EObject)currentObject);
						}
					}

					/*
					 * we build the list of the elements to remove from the table
					 */
					for(EObject currentObject : this.table.getTable().getElements()) {
						if(!((Collection<?>)value).contains(currentObject)) {
							elementToRemove.add(currentObject);
						}
					}
				} else {
					//nothing to do for the moment
				}
			}
		}
		if(!elementsToAdd.isEmpty()) {
			/*
			 * The following line is commented because it doesn't work correctly : The same new object is added many times!
			 */
			//command.append(TableInstanceCommandFactory.createAddRowsCommand(elementsToAdd, (NatTableWidget)this.provider.getNatTableWidget()));
			command.append(getAddElementCommand(domain, elementsToAdd, this.provider.getNatTableWidget()));
		}

		if(!elementToRemove.isEmpty()) {
			command.append(getRemoveElementCommand(domain, elementToRemove, this.provider.getNatTableWidget()));
		}
		if(!command.isEmpty()){
			return command;	
		}
		return null;
	}
	/**
	 * 
	 * @param domain
	 *        the domain to do the command
	 * @param elementsToAdd
	 *        the elements to add in the table
	 * @param widget
	 *        the widget
	 * @return
	 *         the command to add the elements in the table
	 */
	protected Command getAddElementCommand(final TransactionalEditingDomain domain, final List<EObject> elementsToAdd, final INatTableWidget widget) {
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				for(EObject current : elementsToAdd) {
					if(!widget.getTableInstance().getElements().contains(current)) {//we re-test during the execution, to avoid the same element will be added many times
						List<EObject> toAdd = new ArrayList<EObject>();
						toAdd.add(current);
						Command command = TableInstanceCommandFactory.createAddRowsCommand(toAdd, (NatTableWidget)widget);
						if(command != null) {
							command.execute();
						}
					}

				}
				return null;
			}
		});
	}

	/**
	 * 
	 * @param domain
	 *        the domain for the command
	 * @param elementsToRemove
	 *        the element to remove
	 * @param widget
	 *        the widget
	 * @return
	 */
	protected Command getRemoveElementCommand(final TransactionalEditingDomain domain, final List<EObject> elementsToRemove, final INatTableWidget widget) {
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				for(EObject current : elementsToRemove) {
					if(widget.getTableInstance().getElements().contains(current)) {//we re-test to avoid to remove the same element many times
						List<EObject> toRemove = new ArrayList<EObject>();
						toRemove.add(current);
						Command command = createRemoveRowsCommand(domain, toRemove, widget);
						if(command != null) {
							command.execute();
						}
					}

				}
				return null;
			}
		});
	}



	/**
	 * TODO : this method should be provided by the TableInstanceCommandFactory
	 * 
	 * @param domain
	 *        the domain
	 * @param toRemove
	 *        the list of the elements to remove
	 * @param widget
	 *        the widget
	 * @return
	 *         the command to remove the elements
	 */
	private Command createRemoveRowsCommand(final TransactionalEditingDomain domain, final List<EObject> toRemove, final INatTableWidget widget) {
		ICommandFactory commandFactory = ICommandFactoriesRegistry.INSTANCE.getCommandFactoryFor(domain);
		CompoundCommand compoundCommand = new CompoundCommand();
		for(int i = 0; i < widget.getTableInstance().getRows().size(); i++) {
			if(toRemove.contains(widget.getTableInstance().getRows().get(i).getElement())) {
				Command removeRowCommand = commandFactory.createRemoveCommand(domain, widget.getTableInstance(), TableinstancePackage.eINSTANCE.getTableInstance_Rows(), widget.getTableInstance().getRows().get(i));
				compoundCommand.append(removeRowCommand);
			}
		}
		if(!compoundCommand.isEmpty()) {
			return compoundCommand;
		}
		return null;
	}

}
