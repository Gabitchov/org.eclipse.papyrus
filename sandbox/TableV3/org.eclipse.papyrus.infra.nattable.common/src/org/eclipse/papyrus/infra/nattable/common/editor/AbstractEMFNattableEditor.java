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
package org.eclipse.papyrus.infra.nattable.common.editor;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.common.utils.TableEditorInput;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;


/**
 * Abstract class for TableEditor
 * 
 * 
 * 
 */
public abstract class AbstractEMFNattableEditor extends EditorPart {

	/** the service registry */
	protected ServicesRegistry servicesRegistry;

	/**
	 * the table manager
	 */
	protected final INattableModelManager tableManager;

	/**
	 * the part name synchronizer
	 */
	private PartNameSynchronizer synchronizer;

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public AbstractEMFNattableEditor(final ServicesRegistry servicesRegistry, final Table rawModel) {
		this.servicesRegistry = servicesRegistry;
		this.tableManager = new NattableModelManager(rawModel);
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
		final TableEditorInput tableEditorInput = new TableEditorInput(this.tableManager.getTable(), getEditingDomain());
		setSite(site);
		setInput(tableEditorInput);
		setPartName(this.tableManager.getTable().getName());
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor#getEditingDomain()
	 * 
	 * @return
	 */
	public EditingDomain getEditingDomain() {
		try {
			return ServiceUtils.getInstance().getTransactionalEditingDomain(this.servicesRegistry);
		} catch (final ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	@Override
	public void createPartControl(final Composite parent) {
		this.tableManager.createNattable(parent, SWT.NONE, getSite());
	}

	@Override
	public Object getAdapter(final Class adapter) {
		if(adapter == INattableModelManager.class) {
			return this.tableManager;
		}
		return super.getAdapter(adapter);
	}

	@Override
	public void dispose() {
		this.tableManager.dispose();
		this.synchronizer.dispose();
		super.dispose();
	}

	/**
	 * A class taking in charge the synchronization of the partName and the table name.
	 * When table name change, the other is automatically updated.
	 * 
	 * 
	 */
	public class PartNameSynchronizer {

		/** the papyrus table */
		private Table papyrusTable;

		/**
		 * Listener on diagram name change.
		 */
		private final Adapter tableNameListener = new AdapterImpl() {

			/**
			 * 
			 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 * 
			 * @param notification
			 */
			@Override
			public void notifyChanged(final Notification notification) {
				if(notification.getFeature() == NattablePackage.eINSTANCE.getTable_Name()) {
					setPartName(PartNameSynchronizer.this.papyrusTable.getName());
				}
			}
		};

		/**
		 * 
		 * Constructor.
		 * 
		 * @param diagram
		 */
		public PartNameSynchronizer(final Table papyrusTable) {
			setTable(papyrusTable);
		}

		public void dispose() {
			this.papyrusTable.eAdapters().remove(this.tableNameListener);
			this.papyrusTable = null;
		}

		/**
		 * Change the associated diagram.
		 * 
		 * @param papyrusTable
		 */
		public void setTable(final Table papyrusTable) {
			// Remove from old table, if any
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
