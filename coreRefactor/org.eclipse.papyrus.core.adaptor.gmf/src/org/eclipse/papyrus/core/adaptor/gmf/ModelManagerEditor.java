/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.core.adaptor.gmf;

import java.beans.PropertyChangeSupport;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.MEditingDomainElement;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.l10n.EditorMessages;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.osgi.framework.Bundle;

/**
 * This class is used as an model manager for regular GMF Editor.  All editor capabilities are neutralize, except the model load and save
 * capabilities.
 * 
 * @author dumoulin
 *
 */
public class ModelManagerEditor {

	public static final String DIAGRAM_ADDED = "DIAGRAM_ADDED"; //$NON-NLS-1$

	public static final String DIAGRAM_MOVED = "DIAGRAM_MOVED"; //$NON-NLS-1$

	public static final String DIAGRAM_REMOVED = "DIAGRAM_REMOVED"; //$NON-NLS-1$
	
	/**
	 * The underlying document provider.
	 */
	protected IDocumentProvider documentProvider;
	
	/**
	 * EditorInput provided when the editor is created.
	 */
	protected IEditorInput editorInput;
	
	protected IEditorSite site;

	/**
	 * Listener on diagram added/removed.
	 */
	private PropertyChangeSupport diagramListListener = new PropertyChangeSupport(this);
	
	/**
	 * Adapter listening to diagram addition/remove events
	 */
	private Adapter adapter = new Adapter() {

		Notifier notifier;
		
		public Notifier getTarget() {
			return notifier;
		}

		public boolean isAdapterForType(Object type) {
			// TODO Auto-generated method stub
			return false;
		}

		 /**
		   * Notifies that a change to some feature has occurred.
		   * @param notification a description of the change.
		   */
		public void notifyChanged(Notification notification) {
//			System.out.println("notifyChanged("+ notification +")");
//			System.out.println("getEventType=" + notification.getEventType() );
//			System.out.println("getFeature=" + notification.getFeature() );
//			System.out.println("getNotifier=" + notification.getNotifier() );
			
			int eventType = notification.getEventType();
			if( eventType == Notification.ADD )
			{
				Object newValue = notification.getNewValue();
				if(newValue instanceof Diagram)
				  diagramListListener.firePropertyChange(DIAGRAM_ADDED, null, newValue);
			}
			else if(eventType == Notification.MOVE)
			{
				Object newValue = notification.getNewValue();
				if(newValue instanceof Diagram)
				  diagramListListener.firePropertyChange(DIAGRAM_MOVED, null, newValue);
				
			}
			else if(eventType == Notification.REMOVE)
			{
				Object newValue = notification.getNewValue();
				if(newValue==null)
					System.out.println( getClass().getName() + "- Warning: can't get removed object."); //$NON-NLS-1$
				
				if(newValue instanceof Diagram)
				  diagramListListener.firePropertyChange(DIAGRAM_REMOVED, null, newValue);
			}
		}

		public void setTarget(Notifier newTarget) {
			notifier = newTarget;
			
		}
		
	};

	
	/**
	 * @param hasFlyoutPalette
	 */
	public ModelManagerEditor(IDocumentProvider documentProvider) {
		this.documentProvider = documentProvider;
	}

	
	public IDocumentProvider getDocumentProvider() {
		return documentProvider;
	}
	
	/**
	 * 
	 */
	public TransactionalEditingDomain getEditingDomain() {
		IDocument document = getEditorInput() != null ? getDocumentProvider().getDocument(getEditorInput()) : null;
		if (document instanceof IDiagramDocument) {
			return ((IDiagramDocument) document).getEditingDomain();
		}
        return getEditorInput() instanceof MEditingDomainElement ? ((MEditingDomainElement)getEditorInput()).getEditingDomain() : null;
	}

	/**
	 * @cdm
	 */
	public void setInput(IEditorInput input) {
		System.out.println(this + ".setInput(IEditorInput input)"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @param site
	 * @param input
	 * @throws PartInitException
	 */
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
//		System.out.println(this + ".init(IEditorSite site, IEditorInput input)");
		this.editorInput = input;
		this.site = site;
		try {
			getDocumentProvider().connect(input);
		} catch (CoreException x) {
			// code from DiagramDocumentEditor.setInput(IEditorInput)
			String title= EditorMessages.Editor_error_setinput_title;
			String msg= EditorMessages.Editor_error_setinput_message;
			Shell shell= site.getShell();
			ErrorDialog.openError(shell, title, msg, x.getStatus());
		}
	}	
	
	/**
	 * Returns diagram list listener.
	 * This listener send event whenever a diagram is added or removed to the eResource.
	 * @return the listener
	 */
	public PropertyChangeSupport getDiagramListListener(){
		return diagramListListener;
	}

	/**
	 * Called when the editor should be activated.
	 * Subclass should implements this method to register listeners to the model.
	 *
	 */
	public void activate()
	  {
		getNotationModelEResource().eAdapters().add(adapter);	

	  }
	
	/**
	 * Called when the editor is deactivated.
	 *
	 */
	public void deactivate()
	{
		getNotationModelEResource().eAdapters().remove(adapter);	
	}
	
	private Resource getNotationModelEResource()
	{
		// Get the default diagram document
		DiagramDocument document = (DiagramDocument)getDocumentProvider().getDocument(getEditorInput());
		Diagram diagram = document.getDiagram();
		
		return diagram.eResource();	
	}
	
	/**
	 * Get the resource for notation model.
	 * @return
	 */
	public Resource getNotationResource()
	{
		return getNotationModelEResource();
	}
	
	/**
	 * Get the resource for the domain model.
	 * @return
	 */
	public Resource getDomainResource()
	{
		// Get the default diagram document
		DiagramDocument document = (DiagramDocument)getDocumentProvider().getDocument(getEditorInput());
		Diagram diagram = document.getDiagram();
		
		EObject rootObject = diagram.getElement();
		return rootObject.eResource();
	}


	/**
	 * @return the editorInput
	 */
	public IEditorInput getEditorInput() {
		return editorInput;
	}
	
	/**
	 * The <code>AbstractDiagramEditor</code> implementation of this
	 * <code>IEditorPart</code> method may be extended by subclasses.
	 *
	 * @param progressMonitor the progress monitor for communicating result state or <code>null</code>
	 */
	public void doSave(IProgressMonitor progressMonitor) {

		IDocumentProvider p= getDocumentProvider();
		if (p == null)
			return;

		if (p.isDeleted(getEditorInput())) {

			if (isSaveAsAllowed()) {

				/*
				 * 1GEUSSR: ITPUI:ALL - User should never loose changes made in the editors.
				 * Changed Behavior to make sure that if called inside a regular save (because
				 * of deletion of input element) there is a way to report back to the caller.
				 */
				performSaveAs(progressMonitor);

			} else {

				Shell shell= getSite().getShell();
				String title= EditorMessages.Editor_error_save_deleted_title;
				String msg= EditorMessages.Editor_error_save_deleted_message;
				MessageDialog.openError(shell, title, msg);
			}

		} else {
			updateState(getEditorInput());
			validateState(getEditorInput());
			performSave(false, progressMonitor);
		}
	}
	
	/**
	 * Updates the state of the given editor input such as read-only flag.
	 *
	 * @param input the input to be validated
	 * 
	 */
	protected void updateState(IEditorInput input) {
		IDocumentProvider provider= getDocumentProvider();
		try {

			provider.updateStateCache(input);

//			if (getDiagramEditPart() != null) {
//				if(isEditable())
//					getDiagramEditPart().enableEditMode();
//				else
//					getDiagramEditPart().disableEditMode();
//			}

		} catch (CoreException x) {
			Bundle bundle= Platform.getBundle(PlatformUI.PLUGIN_ID);
			ILog log= Platform.getLog(bundle);
			log.log(x.getStatus());
		}
	}

	/**
	 * Validates the state of the given editor input. The predominate intent
	 * of this method is to take any action probably necessary to ensure that
	 * the input can persistently be changed.
	 *
	 * @param input the input to be validated
	 * 
	 */
	protected void validateState(IEditorInput input) {

		IDocumentProvider provider= getDocumentProvider();

		try {

			provider.validateState(input, getSite().getShell());

		} catch (CoreException x) {
			IStatus status= x.getStatus();
			if (status == null || status.getSeverity() != IStatus.CANCEL) {
				Bundle bundle= Platform.getBundle(PlatformUI.PLUGIN_ID);
				ILog log= Platform.getLog(bundle);
				log.log(x.getStatus());

				Shell shell= getSite().getShell();
				String title= EditorMessages.Editor_error_validateEdit_title;
				String msg= EditorMessages.Editor_error_validateEdit_message;
				ErrorDialog.openError(shell, title, msg, x.getStatus());
			}
			return;
		}

		
//		if (getDiagramEditPart() != null) {
//			if(isEditable())
//				getDiagramEditPart().enableEditMode();
//			else
//				getDiagramEditPart().disableEditMode();
//		}
		
	}

	/**
	 * @generated
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * @generated
	 */
	public void doSaveAs() {
		performSaveAs(new NullProgressMonitor());
	}

	/**
	 * Performs the save and handles errors appropriately.
	 *
	 * @param overwrite indicates whether or not overwriting is allowed
	 * @param progressMonitor the monitor in which to run the operation
	 * 
	 */
	protected void performSave(boolean overwrite, IProgressMonitor progressMonitor) {

		IDocumentProvider provider= getDocumentProvider();
		if (provider == null)
			return;

		try {

			provider.aboutToChange(getEditorInput());
			IEditorInput input= getEditorInput();
			provider.saveDocument(progressMonitor, input, getDocumentProvider().getDocument(input), overwrite);
//			editorSaved();

		} catch (CoreException x) {
			IStatus status= x.getStatus();
			if (status == null || status.getSeverity() != IStatus.CANCEL)
				handleExceptionOnSave(x, progressMonitor);
		} finally {
			provider.changed(getEditorInput());
		}
	}

	/**
	 * @generated
	 */
	protected void performSaveAs(IProgressMonitor progressMonitor) {
		Shell shell = getSite().getShell();
		IEditorInput input = getEditorInput();
		SaveAsDialog dialog = new SaveAsDialog(shell);
		IFile original = input instanceof IFileEditorInput ? ((IFileEditorInput) input).getFile() : null;
		if (original != null) {
			dialog.setOriginalFile(original);
		}
		dialog.create();
		IDocumentProvider provider = getDocumentProvider();
		if (provider == null) {
			// editor has been programmatically closed while the dialog was open
			return;
		}
		if (provider.isDeleted(input) && original != null) {
			String message = NLS.bind(Messages.ModelManagerEditor_SavingDeletedFile, original.getName());
			dialog.setErrorMessage(null);
			dialog.setMessage(message, IMessageProvider.WARNING);
		}
		if (dialog.open() == Window.CANCEL) {
			if (progressMonitor != null) {
				progressMonitor.setCanceled(true);
			}
			return;
		}
		IPath filePath = dialog.getResult();
		if (filePath == null) {
			if (progressMonitor != null) {
				progressMonitor.setCanceled(true);
			}
			return;
		}
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = workspaceRoot.getFile(filePath);
		final IEditorInput newInput = new FileEditorInput(file);
		// Check if the editor is already open
		IEditorMatchingStrategy matchingStrategy = getEditorDescriptor().getEditorMatchingStrategy();
		IEditorReference[] editorRefs = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
		for (int i = 0; i < editorRefs.length; i++) {
			if (matchingStrategy.matches(editorRefs[i], newInput)) {
				MessageDialog.openWarning(shell, Messages.ModelManagerEditor_SaveAsErrorTitle, Messages.ModelManagerEditor_SaveAsErrorMessage);
				return;
			}
		}
		boolean success = false;
		try {
			provider.aboutToChange(newInput);
//			getDocumentProvider(newInput).saveDocument(progressMonitor, newInput, getDocumentProvider().getDocument(getEditorInput()), true);
			getDocumentProvider().saveDocument(progressMonitor, newInput, getDocumentProvider().getDocument(getEditorInput()), true);
			success = true;
		} catch (CoreException x) {
			IStatus status = x.getStatus();
			if (status == null || status.getSeverity() != IStatus.CANCEL) {
				ErrorDialog.openError(shell, Messages.ModelManagerEditor_SaveErrorTitle, Messages.ModelManagerEditor_SaveErrorMessage, x.getStatus());
			}
		} finally {
			provider.changed(newInput);
			if (success) {
				setInput(newInput);
			}
		}
		if (progressMonitor != null) {
			progressMonitor.setCanceled(!success);
		}
	}

	/**
	 * Retrieves the descriptor for this editor
	 * 
	 * @return the editor descriptor
	 */
	final protected IEditorDescriptor getEditorDescriptor() {
		IEditorRegistry editorRegistry= PlatformUI.getWorkbench().getEditorRegistry();
		IEditorDescriptor editorDesc= editorRegistry.findEditor(getSite().getId());
		return editorDesc;
	}

	/**
	 * The number of re-entrances into error correction code while saving.
	 * 
	 */
	private int fErrorCorrectionOnSave;

	/**
	 * Handles the given exception. If the exception reports an out-of-sync
	 * situation, this is reported to the user. Otherwise, the exception
	 * is generically reported.
	 *
	 * @param exception the exception to handle
	 * @param progressMonitor the progress monitor
	 */
	protected void handleExceptionOnSave(CoreException exception, IProgressMonitor progressMonitor) {

		try {
			++ fErrorCorrectionOnSave;

			Shell shell= getSite().getShell();

			boolean isSynchronized= false;
			IDocumentProvider p= getDocumentProvider();

			isSynchronized= p.isSynchronized(getEditorInput());

			if (isNotSynchronizedException(exception) && fErrorCorrectionOnSave == 1 && !isSynchronized) {
				String title= EditorMessages.Editor_error_save_outofsync_title;
				String msg= EditorMessages.Editor_error_save_outofsync_message;

				if (MessageDialog.openQuestion(shell, title, msg))
					performSave(true, progressMonitor);
				else {
					/*
					 * 1GEUPKR: ITPJUI:ALL - Loosing work with simultaneous edits
					 * Set progress monitor to canceled in order to report back
					 * to enclosing operations.
					 */
					if (progressMonitor != null)
						progressMonitor.setCanceled(true);
				}
			} else {
				String title= EditorMessages.Editor_error_save_title;
				String msg= EditorMessages.Editor_error_save_message;
				ErrorDialog.openError(shell, title, msg, exception.getStatus());

				/*
				 * 1GEUPKR: ITPJUI:ALL - Loosing work with simultaneous edits
				 * Set progress monitor to canceled in order to report back
				 * to enclosing operations.
				 */
				if (progressMonitor != null)
					progressMonitor.setCanceled(true);
			}
		} finally {
			-- fErrorCorrectionOnSave;
		}
	}
	
	/**
	 * Tells whether the given core exception is exactly the
	 * exception which is thrown for a non-synchronized element.
	 * <p>
	 * XXX: After 3.1 this method must be delegated to the document provider
	 * 		see 
	 * </p>
	 * 
	 * @param ex the core exception
	 * @return <code>true</code> iff the given core exception is exactly the
	 *			exception which is thrown for a non-synchronized element
	 * 
	 */
	private boolean isNotSynchronizedException(CoreException ex) {
		if (ex == null)
			return false;
		
		IStatus status= ex.getStatus(); 
		if (status == null || status instanceof MultiStatus)
			return false;
		
		if (status.getException() != null)
			return false;
		
		// Can't access IResourceStatus.OUT_OF_SYNC_LOCAL, using value: 274
		return status.getCode() == 274;
	}

	

	/**
	 * @return the site
	 */
	public IEditorSite getSite() {
		return site;
	}


}
