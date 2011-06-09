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
package org.eclipse.papyrus.table.common.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.core.AbstractModelQuery;
import org.eclipse.emf.facet.infra.query.core.ModelQuerySetCatalog;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryException;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryResult;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.Column;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.DefaultLabelColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.EContainerColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.MetaClassColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.internal.NatTableWidgetInternalUtils;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.ServiceUtils;
import org.eclipse.papyrus.table.common.internal.IPapyrusNatTableWidget;
import org.eclipse.papyrus.table.common.internal.TableEditorInput;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrustableinstancePackage;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

/**
 * Abstract class for TableEditor
 * 
 * 
 * 
 */
public abstract class AbstractNattableEditor extends org.eclipse.papyrus.table.common.internal.NatTableEditor {

	/** the service registry */
	protected ServicesRegistry servicesRegistry;

	/** the table instance */
	protected PapyrusTableInstance rawModel;

	/**
	 * we listen the table to know when the following properties changes :
	 * 	<ul> 
	 *  <li> isSynchronized</li>
	 *  <li> fillingQueries</li>
	 * </ul>
	 */
	protected AdapterImpl tableListener = new AdapterImpl() {

		@Override
		public void notifyChanged(final Notification msg) {
			if(msg.getNotifier()==AbstractNattableEditor.this.rawModel){
				Object feature = msg.getFeature();
				if(feature instanceof EAttribute){
					if(((EAttribute)feature).getName().equals("isSynchronized")){ //$NON-NLS-1$
						if(msg.getNewBooleanValue()){
							executeQueries();
							return;
						}
					}
				}else if(feature instanceof EReference){
					if(((EReference)feature).getName().equals("fillingQueries")){ //$NON-NLS-1$
						if(AbstractNattableEditor.this.rawModel.isIsSynchronized()){
							executeQueries();
						}
					}
				}
			}
		}
	};

	/**
	 * We listen the context to know if new elements are created in the context of the table
	 */
	protected AdapterImpl contextListener = new AdapterImpl(){

		@Override
		public void notifyChanged(final Notification msg) {
			if(msg.getNotifier()==AbstractNattableEditor.this.rawModel.getTable().getContext()){
				int eventType = msg.getEventType();
				switch(eventType){
				case Notification.ADD : 
				case Notification.ADD_MANY:
					//we execute the queries
					executeQueries();
					break;
				case Notification.MOVE:
					//TODO something to do?
					break;
				case Notification.REMOVE:
				case Notification.REMOVE_MANY:
					List<EObject> elementsToDelete = new ArrayList<EObject>();
					Object objectToRemove = msg.getOldValue();
					if(objectToRemove instanceof EObject){
						elementsToDelete.add((EObject)objectToRemove);
					}else if(objectToRemove instanceof Collection<?>){
						for(Object current : (Collection<?>)objectToRemove){
							if(current instanceof EObject){
								elementsToDelete.add((EObject)current);
							}
						}
					}
					if(!elementsToDelete.isEmpty()){
						//TODO : currently the Nattable API doesn't allow to delete lines programmatically
						//						((INatTableWidget2)AbstractNattableEditor.this.natTableWidget).removeRows(elementsToDelete);
						if(AbstractNattableEditor.this.natTableWidget instanceof IPapyrusNatTableWidget){
							((IPapyrusNatTableWidget)AbstractNattableEditor.this.natTableWidget).removeRowsOutOfCommandStack(elementsToDelete);
						}
					}
				}
			}
		}	
	};


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
		this.rawModel.eAdapters().add(this.tableListener);
		this.rawModel.getTable().getContext().eAdapters().add(this.contextListener);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.table.common.internal.NatTableEditor#dispose()
	 *
	 *  {@inheritDoc}
	 */
	@Override
	public void dispose() {
		this.rawModel.eAdapters().remove(this.tableListener);
		this.rawModel.getTable().getContext().eAdapters().remove(this.contextListener);
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
	protected void executeQueries(){
		if(this.rawModel.isIsSynchronized()){
			TableInstance table = this.rawModel.getTable();
			EObject context = table.getContext();
			List<EObject> elementsToAdd = new ArrayList<EObject>();
			for(ModelQuery query : this.rawModel.getFillingQueries()){
				ModelQuerySetCatalog catalog = ModelQuerySetCatalog.getSingleton();
				AbstractModelQuery impl=null;
				try {
					impl = catalog.getModelQueryImpl(query);
				} catch (ModelQueryException e) {
					e.printStackTrace();
				}
				if(impl!=null){
					ModelQueryResult result = impl.evaluate(context);
					Object value = result.getValue();
					if(value instanceof Collection<?>){
						for(Object currentObject : (Collection<?>)value){
							if(currentObject instanceof EObject && !table.getElements().contains(currentObject)){
								elementsToAdd.add((EObject)currentObject);
							}
						}

					}else{
						//nothing to do for the moment
					}
				}
			}
			if(!elementsToAdd.isEmpty()){
				//				this.natTableWidget.addRows(elementsToAdd);
				if(this.natTableWidget instanceof IPapyrusNatTableWidget){
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
