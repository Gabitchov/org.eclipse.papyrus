/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.common.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.core.AbstractModelQuery;
import org.eclipse.emf.facet.infra.query.core.ModelQuerySetCatalog;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryException;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryResult;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.Column;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.DefaultLabelColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.EContainerColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.MetaClassColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.internal.NatTableWidgetInternalUtils;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.table.common.Activator;
import org.eclipse.papyrus.infra.table.common.internal.IPapyrusNatTableWidget;
import org.eclipse.papyrus.infra.table.common.internal.TableEditorInput;
import org.eclipse.papyrus.infra.table.common.listener.ModelTriggerListener;
import org.eclipse.papyrus.infra.table.common.listener.TableTriggerListener;
import org.eclipse.papyrus.infra.table.common.util.FillingQueriesUtil;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

/**
 * Abstract class for TableEditor
 * 
 * 
 * 
 */
public abstract class AbstractNattableEditor extends org.eclipse.papyrus.infra.table.common.internal.NatTableEditor {

	/** the service registry */
	protected ServicesRegistry servicesRegistry;

	/** the table instance */
	protected PapyrusTableInstance rawModel;

	/** listener on the model for synchronized table */
	protected TriggerListener modelTriggerListener;

	/** listener on the table for synchronized table : listen the properties "isSynchronized" and "fillingQueries" */
	protected TriggerListener tableTriggerListener;

	/**
	 * the part name synchronizer
	 */
	private final PartNameSynchronizer synchronizer;

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public AbstractNattableEditor(final ServicesRegistry servicesRegistry, final PapyrusTableInstance rawModel) {
		this.servicesRegistry = servicesRegistry;
		this.rawModel = rawModel;
		this.synchronizer = new PartNameSynchronizer(rawModel);

	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 * 
	 * @param site
	 * @param input
	 * @throws PartInitException
	 */
	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		TableEditorInput tableEditorInput = new TableEditorInput(this.rawModel, getEditingDomain());
		initHiddenColumn(this.rawModel);
		setSite(site);
		setInput(tableEditorInput);
		setPartName(this.rawModel.getName());
		addListeners();
		super.init(site, tableEditorInput);
	}

	/**
	 * add listeners on the context of the table and on the table itself
	 */
	protected void addListeners() {
		EditingDomain editingDomain = getEditingDomain();
		Assert.isTrue(editingDomain instanceof TransactionalEditingDomain);
		this.modelTriggerListener = new ModelTriggerListener(this.rawModel, (INatTableWidgetProvider)getAdapter(INatTableWidgetProvider.class));
		((TransactionalEditingDomain)editingDomain).addResourceSetListener(this.modelTriggerListener);
		this.tableTriggerListener = new TableTriggerListener(this.rawModel, (INatTableWidgetProvider)getAdapter(INatTableWidgetProvider.class));
		((TransactionalEditingDomain)editingDomain).addResourceSetListener(this.tableTriggerListener);
	}

	/**
	 * {@inheritDoc}
	 * + update the content of the table if the table is synchronized
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		// we update the table
		if (rawModel.isIsSynchronized()) {
			Notification impl = new ENotificationImpl((InternalEObject) rawModel, FillingQueriesUtil.OPEN_TABLE,null, null, null);
			List<Notification> notifications = Collections.singletonList(impl);
			ResourceSetChangeEvent event = new ResourceSetChangeEvent((TransactionalEditingDomain) getEditingDomain(), null,notifications);
			Command cmd = null;
			try {
				cmd = this.modelTriggerListener.transactionAboutToCommit(event);
				if (cmd != null && cmd.canExecute()) {
					cmd.execute();
				}
			} catch (Exception e) {
				Activator.log.error("I can't update the opened table", e);
			}
		}
	}
	
	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.common.internal.NatTableEditor#dispose()
	 *
	 *  {@inheritDoc}
	 */
	@Override
	public void dispose() {
		((TransactionalEditingDomain)getEditingDomain()).removeResourceSetListener(this.modelTriggerListener);
		((TransactionalEditingDomain)getEditingDomain()).removeResourceSetListener(this.tableTriggerListener);
		super.dispose();
	}

	/**
	 * 
	 * @param rawModel2
	 */
	private void initHiddenColumn(final PapyrusTableInstance rawModel2) {
		for(Column current : rawModel2.getTable().getColumns()) {
			if(current instanceof DefaultLabelColumn || current instanceof MetaClassColumn || current instanceof EContainerColumn){
				String name = NatTableWidgetInternalUtils.getColumnName(current);
				if(getInitialHiddenColumns().contains(name)) {
					current.setIsHidden(true);
				}
			}
		}
	}

	/**
	 * 
	 * @return
	 * a list of the names of the columns to hide by default
	 */
	protected List<String> getInitialHiddenColumns() {
		return Collections.emptyList();
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor#getEditingDomain()
	 * 
	 * @return
	 */
	@Override
	public EditingDomain getEditingDomain() {
		try {
			return ServiceUtils.getInstance().getTransactionalEditingDomain(this.servicesRegistry);
		} catch (ServiceException e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * This method execute the filling queries
	 */
	@Deprecated
	protected void executeQueries() {
		if(this.rawModel.isIsSynchronized()) {
			TableInstance table = this.rawModel.getTable();
			EObject context = table.getContext();
			List<EObject> elementsToAdd = new ArrayList<EObject>();
			for(ModelQuery query : this.rawModel.getFillingQueries()) {
				ModelQuerySetCatalog catalog = ModelQuerySetCatalog.getSingleton();
				AbstractModelQuery impl = null;
				try {
					impl = catalog.getModelQueryImpl(query);
				} catch (ModelQueryException e) {
					e.printStackTrace();
				}
				if(impl != null) {
					ModelQueryResult result = impl.evaluate(context);
					Object value = result.getValue();
					if(value instanceof Collection<?>) {
						for(Object currentObject : (Collection<?>)value) {
							if(currentObject instanceof EObject && !table.getElements().contains(currentObject)) {
								elementsToAdd.add((EObject)currentObject);
							}
						}

					} else {
						//nothing to do for the moment
					}
				}
			}
			if(!elementsToAdd.isEmpty()) {
				//				this.natTableWidget.addRows(elementsToAdd);
				if(this.natTableWidget instanceof IPapyrusNatTableWidget) {
					((IPapyrusNatTableWidget)this.natTableWidget).addRowsOutOfCommandStack(elementsToAdd);
				}
			}
		}

	}

	/**
	 * A class taking in charge the synchronization of the partName and the diagram name.
	 * When diagram name change, the other is automatically updated.
	 * 
	 * @author vincent lorenzo
	 *         adapted class from UmlGmfDiagramEditor
	 */
	public class PartNameSynchronizer {

		/** the papyrus table */
		private PapyrusTableInstance papyrusTable;

		/**
		 * Listener on diagram name change.
		 */
		private final Adapter tableNameListener = new Adapter() {

			/**
			 * 
			 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 * 
			 * @param notification
			 */
			public void notifyChanged(final Notification notification) {
				if(notification.getFeatureID(PapyrusTableInstance.class) == PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__NAME && notification.getNotifier() == PartNameSynchronizer.this.papyrusTable) {
					setPartName(PartNameSynchronizer.this.papyrusTable.getName());
				}
			}

			/**
			 * 
			 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
			 * 
			 * @return
			 */
			public Notifier getTarget() {
				return null;
			}

			/**
			 * 
			 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
			 * 
			 * @param newTarget
			 */
			public void setTarget(final Notifier newTarget) {
			}

			/**
			 * 
			 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
			 * 
			 * @param type
			 * @return
			 */
			public boolean isAdapterForType(final Object type) {
				return false;
			}

		};

		/**
		 * 
		 * Constructor.
		 * 
		 * @param diagram
		 */
		public PartNameSynchronizer(final PapyrusTableInstance papyrusTable) {
			setTable(papyrusTable);
		}

		/**
		 * Change the associated diagram.
		 * 
		 * @param papyrusTable
		 */
		public void setTable(final PapyrusTableInstance papyrusTable) {
			// Remove from old diagram, if any
			if(this.papyrusTable != null) {
				papyrusTable.eAdapters().remove(this.tableNameListener);
			}
			// Set new table
			this.papyrusTable = papyrusTable;
			// Set editor name
			setPartName(papyrusTable.getName());
			// Listen to name change
			papyrusTable.eAdapters().add(this.tableNameListener);
		}
	}
}
