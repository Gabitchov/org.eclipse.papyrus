/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.efacet.common.listener;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.IFacetManagerFactory;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactoriesRegistry;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactory;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.ui.command.ITableCommandFactory;
import org.eclipse.emf.facet.widgets.table.ui.command.ITableCommandFactoryFactory;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.TableWidgetUtils;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;

/**
 * 
 * This abstract classes provides the commands to synchronize the tables
 * 
 */
public abstract class AbstractSynchronizedTableListener extends TriggerListener {

	/**
	 * the table on which we are working
	 */
	protected PapyrusTable table;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 */
	public AbstractSynchronizedTableListener(final PapyrusTable table) {
		this.table = table;
	}

	@Override
	protected final Command trigger(final TransactionalEditingDomain domain, final Notification notification) {
		System.out.println(notification);
		if(isManagedNotification(notification)) {
			return getSynchronizationCommand(domain, notification);
		}
		return null;
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain used for the command
	 * @return
	 */
	public Command getSynchronizationCommand(final TransactionalEditingDomain domain, final Notification notification) {
		List<EObject> toAdd = null;
		List<EObject> toRemove = null;
		if(this.table.isUsingContextFeature()) {
			final EReference ref = this.table.getContextFeature();
			if(!ref.isDerived()) {
				//TODO verify that the query to define accepted elements in a table is already called
				final List<EObject>[] addRemove = getElementToAddRemoveUsingContextFeature(this.table);
				toAdd = addRemove[0];
				toRemove = addRemove[1];
			} else {
				//TODO verify that the query to define accepted elements in a table is already called
				final List<EObject>[] addRemove = getElementToAddRemoveUsingContextFeature(this.table);
				toAdd = addRemove[0];
				toRemove = addRemove[1];
			}
		} else if(this.table.isUsingQueries()) {
			final List<EObject>[] addRemove = getElementToAddRemoveUsingQueries();
			toAdd = addRemove[0];
			toRemove = addRemove[1];
		}

		if(!toAdd.isEmpty() || !toRemove.isEmpty()) {
			final ITableCommandFactory factory = getTableCmdFactory(domain, AbstractSynchronizedTableListener.this.table.getTable().eResource().getResourceSet(), AbstractSynchronizedTableListener.this.table.getTable());
			final CompoundCommand cmd = new CompoundCommand("Table Synchronization Command"); //$NON-NLS-1$

			if(!toRemove.isEmpty()) {//it is better to do the remove before the add, because the remove use the position of the row!
				//				final ITableCommandFactory factory = getTableCmdFactory(domain, AbstractSynchronizedTableListener.this.table.getTable().eResource().getResourceSet(), AbstractSynchronizedTableListener.this.table.getTable());
				//				final Command cmd2 = factory.createRemoveRowByEObjectCommand(toRemove);
				//				System.out.println("--------------------------------------------------------------canExecute : " + cmd2.canExecute());
				//				cmd.append(cmd2);
				final List<EObject> elementsToRemove = new ArrayList<EObject>(toRemove);
				//TODO try to remove this GMF command (keep a trace of the already deleted rows?)
				final ICommand tmp = new AbstractTransactionalCommand(domain, "Remove elements of the table", null) { //$NON-NLS-1$

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {

						final Command cmd2 = factory.createRemoveRowByEObjectCommand(elementsToRemove);
						cmd2.execute();
						return CommandResult.newOKCommandResult();
					}
				};
				cmd.append(new GMFtoEMFCommandWrapper(tmp));
			}

			if(!toAdd.isEmpty()) {
				final List<EObject> elementsToAdd = new ArrayList<EObject>(toAdd);
				final ICommand tmp = new AbstractTransactionalCommand(domain, "Add elements of the table", null) { //$NON-NLS-1$

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						final List<EObject> currentContent = TableWidgetUtils.getElements(AbstractSynchronizedTableListener.this.table.getTable());
						if(!currentContent.containsAll(elementsToAdd)) {
							final List<EObject> elToAdd = new ArrayList<EObject>();
							//we redo the calculus of the elements to add, because we can catch several notification for the "same" event
							for(final EObject current : elementsToAdd) {
								if(!currentContent.contains(current)) {
									elToAdd.add(current);
								}
							}

							//duplicated code of the widget
							//CompoundCommand addRowCommand = TableInstanceCommandFactory.createAddRowsCommand(elToAdd, controller);
							//							final CompoundCommand addRowCommand = PapyrusTableEfacetCommandFactory.createAddRowsCommand(domain, AbstractSynchronizedTableListener.this.table.getTable(), elToAdd);
							//							try {
							//								final Command setFacetsCommand = PapyrusTableEfacetCommandFactory.createSetFacetsCommand(domain, AbstractSynchronizedTableListener.this.table.getTable(), AbstractSynchronizedTableListener.this.table.getTable().getFacetSets(), elementsToAdd);
							//								if(setFacetsCommand != null && setFacetsCommand.canExecute()) {
							//									addRowCommand.append(setFacetsCommand);
							//								}
							//							} catch (final CoreException e) {
							//								Activator.log.error(e);
							//							}
							//
							//							if(addRowCommand.canExecute()) {
							//								addRowCommand.execute();
							//							}

							final CompoundCommand addRows = new CompoundCommand("Add rows");
							addRows.append(factory.createAddRowsCommand(elToAdd));
							addRows.append(factory.createSetFacetSetsCommand(AbstractSynchronizedTableListener.this.table.getTable().getFacetSets()));
							//							final CompoundCommand addRowCommand = PapyrusTableEfacetCommandFactory.createAddRowsCommand(domain, AbstractSynchronizedTableListener.this.table.getTable(), elToAdd);
							//							try {
							//								final Command setFacetsCommand = PapyrusTableEfacetCommandFactory.createSetFacetsCommand(domain, AbstractSynchronizedTableListener.this.table.getTable(), AbstractSynchronizedTableListener.this.table.getTable().getFacetSets(), elementsToAdd);
							//								if(setFacetsCommand != null && setFacetsCommand.canExecute()) {
							//									addRowCommand.append(setFacetsCommand);
							//								}
							//							} catch (final CoreException e) {
							//								Activator.log.error(e);
							//							}
							//
							//							if(addRowCommand.canExecute()) {
							//								addRowCommand.execute();
							//							}

							if(addRows.canExecute()) {
								addRows.execute();
							}
						}
						return CommandResult.newOKCommandResult();
					}

				};

				cmd.append(new GMFtoEMFCommandWrapper(tmp));
			}
			//			if(cmd.canExecute()) {
			return cmd;
			//			} else {
			//				Activator.log.warn("The command to add/remove elements to the table is not executable"); //$NON-NLS-1$
			//			}
		}
		return null;
	}


	private static ITableCommandFactory getTableCmdFactory(final TransactionalEditingDomain editingDomain, final ResourceSet resourceSet, final Table table) {
		final IFacetManager facetManager = IFacetManagerFactory.DEFAULT.getOrCreateFacetManager(resourceSet);
		final ICommandFactory commandFactory = ICommandFactoriesRegistry.INSTANCE.getCommandFactoryFor(editingDomain);
		final ITableCommandFactory tableCmdFactory = ITableCommandFactoryFactory.DEFAULT.createTableCommandFactory(table, editingDomain, commandFactory, facetManager);
		return tableCmdFactory;
	}

	/**
	 * 
	 * 
	 * 
	 * @param notification
	 *        the notification
	 * @return
	 *         <code>true</code> if we should do something with this notification
	 */
	protected abstract boolean isManagedNotification(final Notification notification);


	/**
	 * 
	 * @return
	 *         an array of lists. the first list contains the elements to add and the second list contains the elements to remove
	 */
	@SuppressWarnings("unchecked")
	private final List<EObject>[] getElementToAddRemoveUsingQueries() {
		final List<?>[] addRemove = new List<?>[2];
		final List<EObject> toAdd = new ArrayList<EObject>();
		final List<EObject> toRemove = new ArrayList<EObject>();
		addRemove[0] = toAdd;
		addRemove[1] = toRemove;
		//TODO
		return (List<EObject>[])addRemove;
	}


	/**
	 * 
	 * @return
	 *         an array of lists. the first list contains the elements to add and the second list contains the elements to remove
	 */
	@SuppressWarnings("unchecked")
	private final List<EObject>[] getElementToAddRemoveUsingContextFeature(final PapyrusTable papyrusTable) {
		final List<?>[] addRemove = new List<?>[2];
		final List<EObject> toAdd = new ArrayList<EObject>();
		final List<EObject> toRemove = new ArrayList<EObject>();
		addRemove[0] = toAdd;
		addRemove[1] = toRemove;


		final List<EObject> currentContent = TableWidgetUtils.getElements(papyrusTable.getTable());
		final Object value = papyrusTable.getTable().getContext().eGet(papyrusTable.getContextFeature());
		if(value instanceof List<?>) {
			final ArrayList<EObject> newValue = new ArrayList<EObject>((List<EObject>)value);
			//fill the add list
			//			newValue.removeAll(currentContent);
			toAdd.addAll(newValue);
			toAdd.removeAll(currentContent);
			//fill the removeList
			currentContent.removeAll(newValue);
			toRemove.addAll(currentContent);
		} else {
			//we do nothing 	
		}
		return (List<EObject>[])addRemove;
	}

}
