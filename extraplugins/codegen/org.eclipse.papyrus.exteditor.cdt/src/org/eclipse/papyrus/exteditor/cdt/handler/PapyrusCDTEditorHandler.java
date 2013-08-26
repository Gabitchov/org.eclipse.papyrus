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
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.exteditor.cdt.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.exteditor.cdt.Activator;
import org.eclipse.papyrus.exteditor.cdt.editor.PapyrusCDTEditor;
import org.eclipse.papyrus.exteditor.cdt.modelresource.TextEditorModelSharedResource;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance;
import org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrustextinstanceFactory;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;


/**
 * The handler creates a new CDT editor
 */
public class PapyrusCDTEditorHandler extends AbstractHandler {


	public PapyrusCDTEditorHandler() {
	}

	/**
	 * 
	 * @see org.eclipse.infra.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		List<EObject> selected = getSelection();
		if(selected.size() == 1) {
			Object o = selected.get(0);
			if(o instanceof Class || o instanceof Operation || o instanceof DataType) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @return
	 *         the current selection
	 */
	protected List<EObject> getSelection() {
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		List<EObject> currentSelection = new ArrayList<EObject>();
		for(Object current : ((IStructuredSelection)selection).toArray()) {
			if(current instanceof IAdaptable) {
				EObject tmp = (EObject)((IAdaptable)current).getAdapter(EObject.class);
				if(tmp != null) {
					if((tmp instanceof Class) || (tmp instanceof DataType)) {
						currentSelection.add(tmp);
					}
					else if (tmp instanceof Operation) {
						Operation op = (Operation) tmp;
						if (op.getClass_() != null) {
							currentSelection.add(op.getDatatype());
						}
						else if (op.getDatatype() != null) {
							currentSelection.add(op.getDatatype());	
						}
					}
				}
			}
		}
		return currentSelection;
	}

	/**
	 * @see org.eclipse.infra.core.commands.IHandler#execute(org.eclipse.infra.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			final ServicesRegistry serviceRegistry = ServiceUtilsForHandlers.getInstance().getServiceRegistry(event);
			TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);

			//Create the transactional command
			AbstractEMFOperation command = new AbstractEMFOperation(domain, "Create CDT editor") {

				@Override
				protected IStatus doExecute(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					try {
						PapyrusCDTEditorHandler.this.doExecute(serviceRegistry);
					} catch (ServiceException e) {
						Activator.log.error(e);
						return Status.CANCEL_STATUS;
					} catch (NotFoundException e) {
						Activator.log.error(e);
						return Status.CANCEL_STATUS;
					}
					return Status.OK_STATUS;
				}
			};

			// Execute the command
			CheckedOperationHistory.getInstance().execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Activator.log.error("Can't create a CDT editor", e);
		} catch (ServiceException e) {
			Activator.log.error("Service exception during creation of CDT editor", e);
		}
		return null;
	}


	/**
	 * Do the execution of the command.
	 * 
	 * @param serviceRegistry
	 * @throws ServiceException
	 * @throws NotFoundException
	 */
	public void doExecute(final ServicesRegistry serviceRegistry) throws ServiceException, NotFoundException {
		// Get the page manager allowing to add/open an editor.
		IPageManager pageMngr = ServiceUtils.getInstance().getIPageManager(serviceRegistry);

		Object editorModel = getEditorModel(serviceRegistry);
		if (editorModel == null) {
			// no editor exist for the given file => create
			editorModel = createEditorModel(serviceRegistry);
			// add the new editor model to the sash.
		}
		// TODO: editorModel remains in notation, even if editor is closed
		if (pageMngr.isOpen(editorModel)) {	
			// select existing editor
			pageMngr.selectPage(editorModel);
		}
		else {
			pageMngr.openPage(editorModel);
		}
	}

	/**
	 * Create a model identifying the editor. This model will be saved with the sash
	 * 
	 * @return
	 * @throws ServiceException
	 * @throws NotFoundException
	 *         The model where to save the TableInstance is not found.
	 */
	protected Object createEditorModel(final ServicesRegistry serviceRegistry) throws ServiceException, NotFoundException {
		PapyrusTextInstance editorModel = PapyrustextinstanceFactory.eINSTANCE.createPapyrusTextInstance();
		EObject editedObject = getSelection().get(0);
		editorModel.setEditedObject(editedObject);
		editorModel.setType(PapyrusCDTEditor.EDITOR_TYPE);
		if(editedObject instanceof NamedElement) {
			editorModel.setName("CDT " + ((NamedElement)editedObject).getName()); //$NON-NLS-1$
		}
		else {
			editorModel.setName(PapyrusCDTEditor.EDITOR_DEFAULT_NAME);
		}
		TextEditorModelSharedResource model = (TextEditorModelSharedResource)
			ServiceUtils.getInstance().getModelSet(serviceRegistry).getModelChecked(TextEditorModelSharedResource.MODEL_ID);
		model.addPapyrusTextInstance(editorModel);

		return editorModel;
	}
	
	protected Object getEditorModel(final ServicesRegistry serviceRegistry) throws ServiceException, NotFoundException {
		TextEditorModelSharedResource model = (TextEditorModelSharedResource)
			ServiceUtils.getInstance().getModelSet(serviceRegistry).getModelChecked(TextEditorModelSharedResource.MODEL_ID);
		EObject editedObject = getSelection().get(0);
		return model.getPapyrusTextInstance(editedObject);
	}
}
