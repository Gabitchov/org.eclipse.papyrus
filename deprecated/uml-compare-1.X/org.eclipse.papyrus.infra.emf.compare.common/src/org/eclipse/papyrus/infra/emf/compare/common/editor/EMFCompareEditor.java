/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.common.editor;

import org.eclipse.compare.CompareEditorInput;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.commands.NotifyingWorkspaceCommandStack;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.compare.common.Activator;
import org.eclipse.papyrus.infra.emf.compare.common.editor.listener.CloseEditorTriggerListener;
import org.eclipse.papyrus.infra.emf.compare.common.messages.Messages;
import org.eclipse.papyrus.infra.emf.compare.common.utils.EMFCompareUtils;
import org.eclipse.papyrus.infra.emf.compare.common.utils.PapyrusModelCompareEditorInput;
import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.ISaveablesLifecycleListener;
import org.eclipse.ui.ISaveablesSource;
import org.eclipse.ui.PartInitException;

/**
 * 
 * This class provides an EMF-Compare Editor for Papyrus. This Editor has been created to be embedded in the Papyrus SashEditor
 * 
 */
public class EMFCompareEditor extends AbstractPapyrusCompareEditor implements IReusableEditor, ISaveablesSource, IPropertyChangeListener, ISaveablesLifecycleListener {

	/** the service registry */
	protected ServicesRegistry servicesRegistry;

	private CloseEditorTriggerListener closeListener;

	protected PapyrusEMFCompareInstance rawModel;


	/**
	 * The compare editor input
	 */
	private CompareEditorInput input;//TODO move it in the supper class?

	private PartNameSynchronizer synchronizer;

	/**
	 * 
	 * @see org.eclipse.compare.internal.CompareEditor#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
	 * 
	 * @param event
	 */
	@Override
	public void propertyChange(final PropertyChangeEvent event) {
		if(event.getSource() == IAction.class && event.getProperty() == CompareEditorInput.PROP_TITLE) {
			//the CustomizationAction of the viewer sent this refresh
			setPartName(EMFCompareUtils.getCompareEditorTitle(EMFCompareEditor.this, rawModel));
		} else {
			super.propertyChange(event);
		}
	}


	/**
	 * @param servicesRegistry
	 *        the service registry
	 * @param rawModel
	 *        the raw model
	 * 
	 */
	public EMFCompareEditor(final ServicesRegistry servicesRegistry, final PapyrusEMFCompareInstance rawModel) {
		this.servicesRegistry = servicesRegistry;
		this.rawModel = rawModel;
		this.synchronizer = new PartNameSynchronizer(rawModel);
		this.input = getCompareInput(rawModel.getLeft(), rawModel.getRight());
		addListeners();
	}


	protected EMFCompareEditor() {
		//FIXME, used by the compare UMl File Editor, try to merge code	
		super();
	}



	@Override
	protected void addListeners() {
		addUndoRedoListeners();
		if(EMFCompareEditor.this.servicesRegistry != null) {//we are in papyrus
			TransactionalEditingDomain domain = null;
			try {
				domain = EMFCompareEditor.this.servicesRegistry.getService(TransactionalEditingDomain.class);
			} catch (ServiceException e) {
				Activator.log.error(e);
			}

			closeListener = new CloseEditorTriggerListener(this.rawModel, this.servicesRegistry);
			domain.addResourceSetListener(closeListener);
		}
	}

	/**
	 * Remove the listener
	 */
	protected void removeListeners() {
		removeUndoRedoListener();
		//done by the CloseTriggerlistener. Here, it is too early to remove it
		//		if(EMFCompareEditor.this.servicesRegistry != null) {//we are in papyrus
		//			TransactionalEditingDomain domain = null;
		//			try {
		//				domain = EMFCompareEditor.this.servicesRegistry.getService(TransactionalEditingDomain.class);
		//			} catch (ServiceException e) {
		//				Activator.log.error(e);
		//			}
		//
		//			domain.removeResourceSetListener(closeListener);
		//		}
	}

	protected ISashWindowsContainer getISashWindowsContainer() {
		ISashWindowsContainer container = null;
		if(EMFCompareEditor.this.servicesRegistry != null) {//we are in papyrus
			try {
				container = ServiceUtils.getInstance().getISashWindowsContainer(this.servicesRegistry);
			} catch (ServiceException e) {
				Activator.log.error("I can't get the  ISashWindowsContainer to add a listener on it", e); //$NON-NLS-1$
			}
		}
		return container;
	}



	/**
	 * 
	 * @see org.eclipse.ui.IEditorPart#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 * 
	 * @param site
	 * @param input
	 * @throws PartInitException
	 */
	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		if(input instanceof CompareEditorInput) {
			super.init(site, input);
		} else {
			super.init(site, this.input);
		}

	}

	@Override
	public void dispose() {
		removeListeners();
		super.dispose();
	}

	/**
	 * 
	 * A class taking in charge the synchronization of the partName and the right/left elements.
	 * When a name change, the other is automatically updated.
	 * 
	 * @author vincent lorenzo
	 *         adapted class from UmlGmfDiagramEditor
	 */
	public class PartNameSynchronizer {

		/** the papyrus table */
		private PapyrusEMFCompareInstance compareInstance;

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
				setPartName(EMFCompareUtils.getCompareEditorTitle(EMFCompareEditor.this, rawModel));
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
		public PartNameSynchronizer(final PapyrusEMFCompareInstance compareInstance) {
			setCompare(compareInstance);
		}

		/**
		 * Change the associated diagram.
		 * 
		 * @param papyrusTable
		 */
		public void setCompare(final PapyrusEMFCompareInstance compareInstance) {
			// Remove from old diagram, if any
			if(this.compareInstance != null) {
				compareInstance.getLeft().eAdapters().remove(this.tableNameListener);
				compareInstance.getRight().eAdapters().remove(this.tableNameListener);
			}
			// Set new table
			this.compareInstance = compareInstance;

			// Listen to name change
			compareInstance.getLeft().eAdapters().add(this.tableNameListener);
			compareInstance.getRight().eAdapters().add(this.tableNameListener);

		}
	}

	@Override
	protected void configureInput(final PapyrusModelCompareEditorInput input) {
		//not useful for the moment
	}


	@Override
	protected IOperationHistory getIOperationHistory() {
		return ((NotifyingWorkspaceCommandStack)getEditingDomain().getCommandStack()).getOperationHistory();
	}


	@Override
	protected void resetInput() {
		final TreeViewer viewer = ((PapyrusModelCompareEditorInput)this.input).getStructureMergeViewer();
		final PapyrusModelCompareEditorInput input = (PapyrusModelCompareEditorInput)getCompareInput(rawModel.getLeft(), rawModel.getRight());
		final ModelCompareInput input2 = input.getpreparedModelCompareInput();
		viewer.setInput(input2);
	}


	public EditingDomain getEditingDomain() {
		return (EditingDomain)getAdapter(TransactionalEditingDomain.class);
	}

	@Override
	public Object getAdapter(Class adapter) {
		if(adapter.equals(TransactionalEditingDomain.class)) {
			TransactionalEditingDomain domain = null;
			try {
				domain = servicesRegistry.getService(adapter);
			} catch (ServiceException e) {
				Activator.log.error(Messages.EMFCompareEditor_EditingDomainNotFound, e);
			}
			return domain;
		}
		return super.getAdapter(adapter);
	}
}
