/*****************************************************************************
 * Copyright (c) 2010, 2013 LIFL & CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Don't make editor dirty on empty ResourceSetChangeEvent
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.lifecycleevents;

import static org.eclipse.papyrus.infra.core.Activator.log;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;

/**
 * A Papyrus Service allowing to perform save and saveAs on Papyrus Models. The
 * service also allows to listen on the dirty state of the Models. <br>
 * The service implements the {@link ISaveablePart} interface, and can be used
 * directly in part requiring such interface of adapter.
 * 
 * <br>
 * This class allows nested editors to register themselves as nested {@link ISaveablePart}. In this case, the registered part will be notified
 * each time a save or saveAs is performed. Also, the nested part will be asked
 * for its dirtyState.
 * 
 * TODO : Improve the implementation by registering the isDirty flag value, and
 * firing events only if the value really change. Actually, the event is fired
 * every time the model is modified, even if the virtual value of the flag
 * hasn't changed.
 * 
 * @author cedric dumoulin
 * 
 */
public class SaveAndDirtyService extends LifeCycleEventsProvider implements ISaveablePart, IService, ISaveAndDirtyService {

	/**
	 * Class used to propagate life cycle events. This class can be retrieved as
	 * a service using {@link ILifeCycleEventsProvider}.class. This class
	 * extends LifeCycleEventsProvider, so the local variable is set with
	 * ourself (historical reasons). TODO : remove this local variable.
	 */
	protected LifeCycleEventsProvider lifeCycleEventsProvider = this;

	/**
	 * Cached event that can be reused.
	 */
	protected DoSaveEvent lifeCycleEvent;

	/**
	 * Model set managing models.
	 */
	private ModelSet resourceSet;

	/**
	 * 
	 */
	private TransactionalEditingDomain transactionalEditingDomain;

	/**
	 * The serviceRegistry.
	 */
	//	private ServicesRegistry servicesRegistry;

	/**
	 * Associated editor. Needed by saveAs to synchronize editor input.
	 */
	private IMultiDiagramEditor multiDiagramEditor;

	/**
	 * List of registered {@link ISaveablePart}. This are usually nested
	 * editors.
	 */
	private ISaveablePartList registeredIsaveablePart;

	/**
	 * List of listeners on input changed event after a call to saveAs.
	 */
	private List<IEditorInputChangedListener> inputChangedListeners;

	/**
	 * Listener on commandStack changes.
	 */
	private final CommandStackListener commandStackListener = new CommandStackListener() {

		public void commandStackChanged(EventObject event) {

			fireIsDirtyChanged();
		};
	};

	/*
	 * Listener on ResourceSet
	 */
	private final ResourceSetListener resourceSetListener = new ResourceSetListener() {

		public NotificationFilter getFilter() {
			return null;
		}

		public boolean isAggregatePrecommitListener() {
			return false;
		}

		public boolean isPostcommitOnly() {
			return true;
		}

		public boolean isPrecommitOnly() {
			return false;
		}

		public void resourceSetChanged(ResourceSetChangeEvent event) {
			if(event.getTransaction() != null && event.getTransaction().getStatus().isOK() && madePersistableChanges(event)) {
				fireIsDirtyChanged();
			}
		}

		private boolean madePersistableChanges(ResourceSetChangeEvent event) {
			return !event.getNotifications().isEmpty() && !isUnprotected(event.getTransaction());
		}

		private boolean isUnprotected(Transaction transaction) {
			return !Boolean.TRUE.equals(transaction.getOptions().get(Transaction.OPTION_UNPROTECTED));
		}
		
		public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
			return null;
		}

	};

	/**
	 * Constructor.
	 * 
	 */
	public SaveAndDirtyService() {
		registeredIsaveablePart = new ISaveablePartList();
		inputChangedListeners = new ArrayList<IEditorInputChangedListener>();
	}

	/**
	 * Initialize the service. Retrieve other required services (ModelSet,
	 * CoreEditor).
	 * 
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 * 
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {

		//		this.servicesRegistry = servicesRegistry;

		// Retrieve required services.
		resourceSet = servicesRegistry.getService(ModelSet.class);
		multiDiagramEditor = servicesRegistry.getService(IMultiDiagramEditor.class);
		transactionalEditingDomain = ServiceUtils.getInstance().getTransactionalEditingDomain(servicesRegistry);

		// Initialize and register the ILifeCycleEventsProvider service (which
		// is ourself).
		// This mean that the ILifeCycleEventsProvider is not available until we
		// are started.
		lifeCycleEvent = new DoSaveEvent(servicesRegistry, multiDiagramEditor);
		// servicesRegistry.add(ILifeCycleEventsProvider.class, 1,
		// lifeCycleEventsProvider);

	}

	/**
	 * Do nothing.
	 * 
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 * 
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {

		// Listen to the modifications of the EMF model
		transactionalEditingDomain.getCommandStack().addCommandStackListener(commandStackListener);

		// Let's listen to the resource set change
		transactionalEditingDomain.addResourceSetListener(resourceSetListener);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 * 
	 * @throws ServiceException
	 */
	public void disposeService() throws ServiceException {
		if(transactionalEditingDomain != null) {
			// Check if commandStack is null (meaning that transactionalEditingDomain 
			// is disposed
			CommandStack commandStack = transactionalEditingDomain.getCommandStack();
			if(commandStack != null) {
				transactionalEditingDomain.getCommandStack().removeCommandStackListener(commandStackListener);
			}
			transactionalEditingDomain.removeResourceSetListener(resourceSetListener);
			//			resourceSetListener = null;
		}

		// clean properties in order to help GC
		inputChangedListeners.clear();
		inputChangedListeners = null;
		multiDiagramEditor = null;
		//		servicesRegistry = null;
		transactionalEditingDomain = null;
		resourceSet = null;
		lifeCycleEvent = null;

		postSaveListeners.clear();
		saveListeners.clear();
		preSaveListeners.clear();


	}

	/**
	 * Save the Models
	 * 
	 * @see org.eclipse.ui.ISaveablePart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 * 
	 * @param monitor
	 */
	public void doSave(IProgressMonitor monitor) {
		// Sent pre doSave event
		lifeCycleEventsProvider.fireAboutToDoSaveEvent(lifeCycleEvent);

		// sent doSaveEvent
		lifeCycleEventsProvider.fireDoSaveEvent(lifeCycleEvent);
		// Perform local doSave
		// TODO : put it in a listener ?
		try {
			// Save each associated resource
			resourceSet.save(monitor);
			// notify registered IsaveablePart
			registeredIsaveablePart.doSave(monitor);
			markSaveLocation();
		} catch (IOException e) {
			log.error("Error during save", e);
		}

		// Sent post Events
		lifeCycleEventsProvider.firePostDoSaveEvent(lifeCycleEvent);

	}

	/**
	 * @see org.eclipse.ui.ISaveablePart#doSaveAs()
	 * 
	 */
	public void doSaveAs() {
		// Sent pre doSave event
		lifeCycleEventsProvider.fireAboutToDoSaveAsEvent(lifeCycleEvent);

		// sent doSaveEvent
		lifeCycleEventsProvider.fireDoSaveAsEvent(lifeCycleEvent);
		// Perform local doSaveAs

		// Show a SaveAs dialog
		Shell shell = multiDiagramEditor.getEditorSite().getWorkbenchWindow().getShell();
		SaveAsDialog dialog = new SaveAsDialog(shell);
		dialog.setOriginalFile(((IFileEditorInput)multiDiagramEditor.getEditorInput()).getFile());
		dialog.open();
		final IPath path = dialog.getResult();
		if(path != null) {
			// try to save the editor's contents under a different file name
			final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			try {
				new ProgressMonitorDialog(shell).run(false, // don't fork
					false, // can't cancel
					new WorkspaceModifyOperation() { // run this operation

						@Override
						public void execute(final IProgressMonitor monitor) {
							try {
								//to event bad redirection after the saveAs
								//see bug 319023
								EcoreUtil.resolveAll(resourceSet);
								resourceSet.saveAs(path);
								// notify registered IsaveablePart
								registeredIsaveablePart.doSave(monitor);
							} catch (IOException e) {
								log.error("Unable to saveAs the resource set", e);
							}
						}
					});
				// set input to the new file
				fireEditorInputChanged(new FileEditorInput(file));
				markSaveLocation();
			} catch (InterruptedException e) {
				// should not happen, since the monitor dialog is not cancelable
				log.error(e);
			} catch (InvocationTargetException e) {
				log.error(e);
			}
		}

		// sent doSaveEvent
		lifeCycleEventsProvider.firePostDoSaveAsEvent(lifeCycleEvent);
	}

	/**
	 * Change the input of the underlying editor.
	 * 
	 * @param fileEditorInput
	 */
	private void fireEditorInputChanged(FileEditorInput fileEditorInput) {

		for(IEditorInputChangedListener listener : inputChangedListeners) {
			try {
				listener.editorInputChanged(fileEditorInput);
			} catch (Exception e) {
				log.error("Can't set input for '" + listener + "'", e);
			}
		}

	}

	/**
	 * Fire a PropertyChanged event to registered {@link IEditorInputChangedListener}.
	 * 
	 * @param propertyId
	 */
	private void fireIsDirtyChanged() {

		for(IEditorInputChangedListener listener : inputChangedListeners) {
			try {
				listener.isDirtyChanged();
			} catch (Exception e) {
				log.error("Can't call listener '" + listener + "'", e);
			}
		}

	}

	/**
	 * Return true if the multiEditor is dirty, false otherwise. The dirty state
	 * is compute as follow:
	 * <ul>
	 * <li>The {@link TransactionalEditingDomain} commandStack is checked</li>
	 * <li>and each registered nested Isaveable.isDirty() state is checked</li>
	 * <li></li>
	 * <li></li>
	 * <li></li>
	 * <li></li>
	 * </ul>
	 * If one of these states is false, the returned value is false. <br>
	 * If all of these states are true, the returned value is true.
	 * 
	 * @see org.eclipse.ui.ISaveablePart#isDirty()
	 * 
	 * @return
	 */
	public boolean isDirty() {
		// First, look if the model part (EMF) is dirty, else look at the
		// Graphical part (GEF/GMF)
		return ((BasicCommandStack)transactionalEditingDomain.getCommandStack()).isSaveNeeded() || registeredIsaveablePart.isDirty();
	}

	/**
	 * @see org.eclipse.ui.ISaveablePart#isSaveAsAllowed()
	 * 
	 * @return
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * @see org.eclipse.ui.ISaveablePart#isSaveOnCloseNeeded()
	 * 
	 * @return
	 */
	public boolean isSaveOnCloseNeeded() {
		return isDirty();
	}

	/**
	 * Mark the command stack of all sub-editors. Default implementation do
	 * nothing.
	 */
	protected void markSaveLocation() {
		((BasicCommandStack)transactionalEditingDomain.getCommandStack()).saveIsDone();
		fireIsDirtyChanged();
	}

	/**
	 * Register a nested {@link ISaveablePart} as a listener that will be
	 * notified each time a {@link #doSave(IProgressMonitor)} or {@link #doSaveAs()} is performed. Also, it will be asked for the
	 * dirtyState.
	 * 
	 * @param saveablePart
	 */
	public void registerIsaveablePart(ISaveablePart saveablePart) {
		registeredIsaveablePart.add(saveablePart);
	}

	/**
	 * Remove the specified {@link ISaveablePart} from the list of listeners.
	 * 
	 * @param saveablePart
	 */
	public void removeIsaveablePart(ISaveablePart saveablePart) {
		registeredIsaveablePart.remove(saveablePart);
	}

	/**
	 * Add a listeners on input changed event.
	 * 
	 * @param inputChangedListener
	 */
	public void addInputChangedListener(IEditorInputChangedListener inputChangedListener) {
		inputChangedListeners.add(inputChangedListener);
	}

	/**
	 * Remove a listeners on input changed event.
	 * 
	 * @param inputChangedListener
	 */
	public void removeInputChangedListener(IEditorInputChangedListener inputChangedListener) {
		inputChangedListeners.remove(inputChangedListener);
	}

	/**
	 * A list of {@link ISaveablePart}.
	 * 
	 * @author dumoulin
	 * 
	 */
	public class ISaveablePartList extends ArrayList<ISaveablePart> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Return true if one of the part is dirty, false if all part are not
		 * dirty.
		 * 
		 * @return
		 */
		public boolean isDirty() {
			for(ISaveablePart part : this) {
				if(part.isDirty()) {
					return true;
				}
			}

			return false;
		}

		/**
		 * Call doSave on each registered {@link ISaveablePart}.
		 * 
		 * @param monitor
		 */
		public void doSave(IProgressMonitor monitor) {
			for(ISaveablePart part : this) {

				try {
					part.doSave(monitor);
				} catch (Exception e) {
					log.error("Can't save ISaveablePart '" + part + "'", e);
				}
			}

		}

		/**
		 * Call doSaveAs on each registered {@link ISaveablePart}.
		 * 
		 * @param monitor
		 */
		public void doSaveAs() {
			for(ISaveablePart part : this) {
				try {
					part.doSaveAs();
				} catch (Exception e) {
					log.error("Can't save ISaveablePart '" + part + "'", e);
				}
			}

		}
	}
}
