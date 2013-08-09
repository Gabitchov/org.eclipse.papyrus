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
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance;
import org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrustextinstanceFactory;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Transition;


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
			if(o instanceof Class || o instanceof Operation || o instanceof Transition) {
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
			runAsTransaction();
		} catch (ServiceException e) {
			throw new ExecutionException("I can't create a CDT editor", e); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * Run the command as a transaction.
	 * Create a Transaction and delegate the command to {@link #doExecute(ServicesRegistry)}.
	 * 
	 * @throws ServiceException
	 * 
	 */
	public void runAsTransaction() throws ServiceException {
		final ServicesRegistry serviceRegistry = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry();
		TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);

		//Create the transactional command
		AbstractEMFOperation command = new AbstractEMFOperation(domain, "Create CDT editor") { //$NON-NLS-1$

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
		try {
			CheckedOperationHistory.getInstance().execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Activator.log.error("I can't create a CDT editor", e); //$NON-NLS-1$
		}

	}


	/**
	 * Do the execution of the command.
	 * 
	 * @param serviceRegistry
	 * @throws ServiceException
	 * @throws NotFoundException
	 */
	public void doExecute(final ServicesRegistry serviceRegistry) throws ServiceException, NotFoundException {
		Object editorModel = createEditorModel(serviceRegistry);
		// Get the mngr allowing to add/open new editor.
		IPageMngr pageMngr = ServiceUtils.getInstance().getIPageMngr(serviceRegistry);
		// add the new editor model to the sash.
		pageMngr.openPage(editorModel);

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
			editorModel.setName("CDT " + ((NamedElement)editedObject).getName());
		}
		else {
			editorModel.setName(PapyrusCDTEditor.EDITOR_DEFAULT_NAME);
		}
		TextEditorModelSharedResource model = (TextEditorModelSharedResource)
			ServiceUtils.getInstance().getModelSet(serviceRegistry).getModelChecked(TextEditorModelSharedResource.MODEL_ID);
		model.addPapyrusTextInstance(editorModel);

		return editorModel;
	}
}
