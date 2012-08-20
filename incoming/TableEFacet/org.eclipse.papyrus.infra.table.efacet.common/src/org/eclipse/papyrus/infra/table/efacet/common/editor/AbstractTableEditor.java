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
package org.eclipse.papyrus.infra.table.efacet.common.editor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.table.efacet.common.Activator;
import org.eclipse.papyrus.infra.table.efacet.common.input.PapyrusTableEditorInput;
import org.eclipse.papyrus.infra.table.efacet.common.listener.FillingListener;
import org.eclipse.papyrus.infra.table.efacet.common.listener.MoveTableLineListener;
import org.eclipse.papyrus.infra.table.efacet.common.listener.TableFillingModeListener;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.contexts.IContextService;

public abstract class AbstractTableEditor extends NatTableEditor2 {

	/** the service registry */
	protected ServicesRegistry servicesRegistry;

	/** the table instance */
	protected PapyrusTable rawModel;

	/** listener on the model for synchronized table */
	private TriggerListener fillingListener;

	/** listener on the filling mode */
	private TriggerListener fillingModeListener;

	/** to listen moving lines in the table */
	private TriggerListener moveLineListener;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param servicesRegistry
	 *        the service registry
	 * @param rawModel
	 *        the raw model
	 */
	public AbstractTableEditor(final ServicesRegistry servicesRegistry, final PapyrusTable rawModel) {
		this.servicesRegistry = servicesRegistry;
		this.rawModel = rawModel;
		new PartNameSynchronizer(rawModel);
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
		final PapyrusTableEditorInput tableEditorInput = new PapyrusTableEditorInput(this.rawModel, getEditingDomain());
		setSite(site);
		setInput(tableEditorInput);
		setPartName(this.rawModel.getName());
		super.init(site, tableEditorInput);
	}


	/**
	 * add listeners on the context of the table and on the table itself
	 */
	protected void addListeners() {
		final EditingDomain editingDomain = getEditingDomain();
		Assert.isTrue(editingDomain instanceof TransactionalEditingDomain);

		this.fillingListener = new FillingListener(this.rawModel);
		((TransactionalEditingDomain)editingDomain).addResourceSetListener(this.fillingListener);

		this.fillingModeListener = new TableFillingModeListener(this.rawModel);
		((TransactionalEditingDomain)editingDomain).addResourceSetListener(this.fillingModeListener);

		this.moveLineListener = new MoveTableLineListener(this.rawModel);
		((TransactionalEditingDomain)editingDomain).addResourceSetListener(this.moveLineListener);
	}

	@Override
	public void createPartControl(final Composite parent) {
		final IContextService contextService = (IContextService)getSite().getService(IContextService.class);
		//FIXME : before Eclipse Juno, this line was not necessary
		//see bug 367816 and bug 382218
		contextService.activateContext("org.eclipse.papyrus.infra.table.efacet.common.context"); //$NON-NLS-1$
		super.createPartControl(parent);
		addListeners();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.common.internal.NatTableEditor#dispose()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public void dispose() {
		((TransactionalEditingDomain)getEditingDomain()).removeResourceSetListener(this.fillingListener);
		((TransactionalEditingDomain)getEditingDomain()).removeResourceSetListener(this.fillingModeListener);
		((TransactionalEditingDomain)getEditingDomain()).removeResourceSetListener(this.moveLineListener);
		super.dispose();
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
		} catch (final ServiceException e) {
			Activator.log.error(e);
		}
		return null;
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
		private PapyrusTable papyrusTable;

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
				if(notification.getFeatureID(PapyrusTable.class) == PapyrustablePackage.PAPYRUS_TABLE__NAME && notification.getNotifier() == PartNameSynchronizer.this.papyrusTable) {
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
		public PartNameSynchronizer(final PapyrusTable papyrusTable) {
			setTable(papyrusTable);
		}

		/**
		 * Change the associated diagram.
		 * 
		 * @param papyrusTable
		 */
		public void setTable(final PapyrusTable papyrusTable) {
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
