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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.IFacetManagerFactory;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.efacet.core.exception.FacetManagerException;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactoriesRegistry;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactory;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.ui.command.ITableCommandFactory;
import org.eclipse.emf.facet.widgets.table.ui.command.ITableCommandFactoryFactory;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.TableWidgetUtils;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;
import org.eclipse.papyrus.infra.table.efacet.common.Activator;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.TableContentsUtils;

/**
 * 
 * This listener provides the command to synchronize the table when something changes in the uml file OR when the table is opened
 * 
 */
public class FillingListener extends AbstractTableTriggerListener {

	/**
	 * this set stores the eobjects already managed by an addRow command
	 */
	private final Set<EObject> addedEObjects = new HashSet<EObject>();

	/**
	 * this set stores the eobjects already managed by a deleteRow command
	 */
	private final Set<EObject> deletedEObjects = new HashSet<EObject>();


	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 *        the table to fill
	 * @param natTableWidget
	 */
	public FillingListener(final PapyrusTable table) {
		super(table);
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain used for the command
	 * @return
	 */
	@Override
	public Command getSynchronizationCommand(final TransactionalEditingDomain domain, final Notification notification) {
		//we build the list of the eobjects to add and remove
		List<EObject> toAdd = null;
		List<EObject> toRemove = null;
		CompoundCommand compoundCommand = null;
		if(this.table.isUsingUser()) {
			toAdd = Collections.emptyList();
			toRemove = Collections.emptyList();
		} else if(this.table.isUsingContextFeature()) {
			final EReference ref = this.table.getContextFeature();
			if(!ref.isDerived()) {//TODO improve the usage of the notification in this case
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
			final List<EObject>[] addRemove = getElementToAddRemoveUsingQueries(this.table);
			toAdd = addRemove[0];
			toRemove = addRemove[1];
		}

		//we clean the list (remove eobject already managed)
		toAdd.removeAll(this.addedEObjects);
		toRemove.removeAll(this.deletedEObjects);

		//we update the list of already managed elements
		this.addedEObjects.addAll(toAdd);
		this.deletedEObjects.addAll(toRemove);

		final ITableCommandFactory factory = getTableCmdFactory(domain, this.table.getTable().eResource().getResourceSet(), this.table.getTable());
		final Command removeCommand = createRemoveCommand(domain, factory, toRemove);
		final Command addCommand = createAddCommand(domain, factory, toAdd);

		if(removeCommand != null || addCommand != null) {
			compoundCommand = new CompoundCommand(getCommandName(notification));
			if(removeCommand != null && removeCommand.canExecute()) {
				compoundCommand.append(removeCommand);
			}
			if(addCommand != null && addCommand.canExecute()) {
				compoundCommand.append(addCommand);
			}
		}
		return compoundCommand;
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param factory
	 *        the factory to use to build the command
	 * @param toRemove
	 *        the eobjets to remove
	 * @return
	 *         the command to remove rows
	 */
	private final Command createRemoveCommand(final TransactionalEditingDomain domain, final ITableCommandFactory factory, final List<EObject> toRemove) {
		CompoundCommand cmd = null;
		if(!toRemove.isEmpty()) {
			cmd = new CompoundCommand("Table Synchronization Command (Remove Rows)");
			cmd.append(factory.createRemoveRowByEObjectCommand(toRemove));
			cmd.append(new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Clean the set deletedEObjects", null) {

				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					FillingListener.this.deletedEObjects.removeAll(toRemove);
					return CommandResult.newOKCommandResult();
				}
			}));
		}
		return cmd;
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param factory
	 *        the factory to use to build the command
	 * @param toAdd
	 *        the eobjects to add
	 * @return
	 *         the command to add rows
	 */
	private final Command createAddCommand(final TransactionalEditingDomain domain, final ITableCommandFactory factory, final List<EObject> toAdd) {
		CompoundCommand cmd = null;
		if(!toAdd.isEmpty()) {
			cmd = new CompoundCommand("Table Synchronization Command (Remove Rows)");
			//duplicated code from the widget
			cmd.append(factory.createAddRowsCommand(toAdd));
			cmd.append(factory.createSetFacetSetsCommand(this.table.getTable().getFacetSets()));

			cmd.append(new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Clean the set addedEObjects", null) {

				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					FillingListener.this.addedEObjects.removeAll(toAdd);;
					return CommandResult.newOKCommandResult();
				}
			}));
		}
		return cmd;
	}

	/**
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param resourceSet
	 *        the resource set
	 * @param table
	 *        the table
	 * @return
	 *         the command factory for these parameters
	 */
	private static ITableCommandFactory getTableCmdFactory(final TransactionalEditingDomain editingDomain, final ResourceSet resourceSet, final Table table) {
		final IFacetManager facetManager = IFacetManagerFactory.DEFAULT.getOrCreateFacetManager(resourceSet);
		final ICommandFactory commandFactory = ICommandFactoriesRegistry.INSTANCE.getCommandFactoryFor(editingDomain);
		final ITableCommandFactory tableCmdFactory = ITableCommandFactoryFactory.DEFAULT.createTableCommandFactory(table, editingDomain, commandFactory, facetManager);
		return tableCmdFactory;
	}


	/**
	 * 
	 * @return
	 *         an array of lists. the first list contains the elements to add and the second list contains the elements to remove
	 */
	@SuppressWarnings("unchecked")
	private final List<EObject>[] getElementToAddRemoveUsingQueries(final PapyrusTable papyrusTable) {
		final List<?>[] addRemove = new List<?>[2];
		final List<EObject> toAdd = new ArrayList<EObject>();
		final List<EObject> toRemove = new ArrayList<EObject>();
		final IFacetManager facetManager = IFacetManagerFactory.DEFAULT.getOrCreateFacetManager(papyrusTable.eResource());
		final List<EObject> allElements = new ArrayList<EObject>();
		for(final Query current : papyrusTable.getQueries()){
			EObject container = current.eContainer();
			if(container instanceof FacetReference){
				try {
					List<EObject> res = facetManager.getOrInvokeMultiValued(papyrusTable, (ETypedElement)container,null);
					if(res!=null){
						allElements.addAll(res);
					}
				} catch (FacetManagerException e) {
					Activator.log.equals(e);
				}
			}
		}
		final List<EObject> currentContent = TableContentsUtils.getTableContents(papyrusTable, papyrusTable.getTable().getContext(),false);
		final ArrayList<EObject> newValue = new ArrayList<EObject>((List<EObject>)allElements);
		//fill the add list

		toAdd.addAll(newValue);
		toAdd.removeAll(currentContent);

		//fill the removeList
		currentContent.removeAll(newValue);
		toRemove.addAll(currentContent);

		addRemove[0] = toAdd;
		addRemove[1] = toRemove;
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

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.efacet.common.listener.AbstractSynchronizedTableListener#isManagedNotification(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param notification
	 * @return
	 */
	@Override
	protected boolean isManagedNotification(final Notification notification) {
		return isUsingQueries() || isTableOpening(notification) || isModifyingModel(notification) || isFillingModeChanging(notification);
	}

	/**
	 * 
	 * @return
	 *         <code>true</code> if the table is filled using queries
	 */
	protected boolean isUsingQueries() {
		return this.table.isUsingQueries();
	}

	/**
	 * 
	 * @param notification
	 *        a notification
	 * @return
	 *         <code>true</code> if the filling mode is changing
	 */
	protected boolean isFillingModeChanging(final Notification notification) {
		return (notification.getNotifier() == this.table && notification.getFeature() == PapyrustablePackage.eINSTANCE.getPapyrusTable_FillingMode());
	}

	/**
	 * 
	 * @param notification
	 *        a notification
	 * @return
	 *         <code>true</code> if we are opening a table
	 */
	protected boolean isTableOpening(final Notification notification) {
		final Object notifier = notification.getNotifier();
		if(notifier instanceof EObject) {
			final EObject eobject = (EObject)notifier;
			if(notifier instanceof TabFolder) {
				final Object newValue = notification.getNewValue();
				PageRef ref = null;
				if(newValue instanceof PageRef) {
					ref = (PageRef)newValue;
				}
				if(ref != null && ref.getEmfPageIdentifier() == this.table) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param notification
	 *        a notification
	 * @return
	 *         <code>true</code> if we are modifying the model
	 */
	protected boolean isModifyingModel(final Notification notification) {
		final Object notifier = notification.getNotifier();
		if(notifier instanceof EObject) {
			final EObject eobject = (EObject)notifier;
			if(eobject.eResource() != null && eobject.eResource() == this.table.getTable().getContext().eResource()) { //$NON-NLS-1$
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param notification
	 *        the notification
	 * @return
	 *         the name of the command to use
	 */
	@Override
	protected String getCommandName(final Notification notification) {
		final String commandName;
		if(isUsingQueries()) {
			commandName = "Synchronized Table Command (Contents Changes Using Queries)";
		} else if(isFillingModeChanging(notification)) {
			commandName = "Synchronized Table Command (Filling Mode Changed)";
		} else if(isTableOpening(notification)) {
			commandName = "Synchronized Table Command (Updating Opening Table)";
		} else if(isModifyingModel(notification)) {
			commandName = "Synchronized Table Command (Update for Model Changes)";
		} else {
			commandName = "";
		}
		return commandName;
	}


}
