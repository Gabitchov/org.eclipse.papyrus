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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.ServiceUtils;
import org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrustableinstancePackage;
import org.eclipse.papyrus.table.common.internal.TableEditorInput;
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
	 * the part name synchronizer
	 */
	private PartNameSynchronizer synchronizer;

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public AbstractNattableEditor(ServicesRegistry servicesRegistry, PapyrusTableInstance rawModel) {
		this.servicesRegistry = servicesRegistry;
		this.rawModel = rawModel;
		synchronizer = new PartNameSynchronizer(rawModel);

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
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		TableEditorInput tableEditorInput = new TableEditorInput(rawModel, getEditingDomain());
		setSite(site);
		setInput(tableEditorInput);

		setPartName(rawModel.getName());
		super.init(site, tableEditorInput);
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor#getEditingDomain()
	 * 
	 * @return
	 */
	@Override
	public EditingDomain getEditingDomain() {
		// TODO Auto-generated method stub
		try {
			return ServiceUtils.getInstance().getTransactionalEditingDomain(servicesRegistry);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param adapter
	 * @return
	 */
	@Override
	public Object getAdapter(final Class adapter) {
		return super.getAdapter(adapter);
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
		private Adapter tableNameListener = new Adapter() {

			/**
			 * 
			 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 * 
			 * @param notification
			 */
			public void notifyChanged(Notification notification) {
				if(notification.getFeatureID(PapyrusTableInstance.class) == PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__NAME && notification.getNotifier() == papyrusTable) {
					setPartName(papyrusTable.getName());
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
			public void setTarget(Notifier newTarget) {
			}

			/**
			 * 
			 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
			 * 
			 * @param type
			 * @return
			 */
			public boolean isAdapterForType(Object type) {
				return false;
			}

		};

		/**
		 * 
		 * Constructor.
		 * 
		 * @param diagram
		 */
		public PartNameSynchronizer(PapyrusTableInstance papyrusTable) {
			setTable(papyrusTable);
		}

		/**
		 * Change the associated diagram.
		 * 
		 * @param papyrusTable
		 */
		public void setTable(PapyrusTableInstance papyrusTable) {
			// Remove from old diagram, if any
			if(this.papyrusTable != null) {
				papyrusTable.eAdapters().remove(tableNameListener);
			}
			// Set new table
			this.papyrusTable = papyrusTable;
			// Set editor name
			setPartName(papyrusTable.getName());
			// Listen to name change
			papyrusTable.eAdapters().add(tableNameListener);
		}
	}
}
