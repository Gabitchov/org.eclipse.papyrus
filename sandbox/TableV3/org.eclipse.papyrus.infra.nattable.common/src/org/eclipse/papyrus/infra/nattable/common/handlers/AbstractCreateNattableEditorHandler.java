/*****************************************************************************
 * Copyright (c) 2011 LIFL & CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.common.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.EditorNameInitializer;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.common.modelresource.PapyrusNattableModel;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.TableHelper;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * 
 */
public abstract class AbstractCreateNattableEditorHandler extends AbstractHandler {

	/** the default name for the table */
	private final String defaultName;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editorType
	 *        the type of the editor
	 * @param defaultName
	 *        the default name for this editor
	 */
	public AbstractCreateNattableEditorHandler(final String editorType, final String defaultName) {//FIXME : remove editorType
		this.defaultName = defaultName;
	}

	/**
	 * Should be overridden in order to restrict creation
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			runAsTransaction(event);
		} catch (final ServiceException e) {
			throw new ExecutionException("Can't create TableEditor", e); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * Run the command as a transaction. Create a Transaction and delegate the
	 * command to {@link #doExecute(ServicesRegistry)}.
	 * 
	 * @throws ServiceException
	 * 
	 */
	public void runAsTransaction(final ExecutionEvent event) throws ServiceException {
		// default Value
		final String name;
		final String nameWithIncrement = EditorNameInitializer.getNameWithIncrement(NattablePackage.eINSTANCE.getTable(), NattablePackage.eINSTANCE.getTable_Name(), this.defaultName, getTableContext());
		final InputDialog dialog = new InputDialog(Display.getDefault().getActiveShell(), Messages.AbstractCreateNattableEditorHandler_PapyrusTableCreation, Messages.AbstractCreateNattableEditorHandler_EnterTheNameForTheNewTable, nameWithIncrement, null);
		if(dialog.open() == Dialog.OK) {
			name = dialog.getValue();
			final ServicesRegistry serviceRegistry = ServiceUtilsForHandlers.getInstance().getServiceRegistry(event);
			final TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);
			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					try {
						AbstractCreateNattableEditorHandler.this.doExecute(serviceRegistry, name, this.description);
					} catch (final NotFoundException e) {
						Activator.log.error(e);
					} catch (final ServiceException e) {
						Activator.log.error(e);
					}

				}
			});
		}

	}

	/**
	 * Do the execution of the command.
	 * 
	 * @param serviceRegistry
	 * @throws ServiceException
	 * @throws NotFoundException
	 */
	public void doExecute(final ServicesRegistry serviceRegistry, String name, String description) throws ServiceException, NotFoundException {

		final Object editorModel = createEditorModel(serviceRegistry, name, description);
		// Get the mngr allowing to add/open new editor.
		final IPageManager pageMngr = ServiceUtils.getInstance().getIPageManager(serviceRegistry);
		// add the new editor model to the sash.
		pageMngr.openPage(editorModel);

	}

	/**
	 * Create a model identifying the editor. This model will be saved with the
	 * sash
	 * 
	 * @return
	 * @throws ServiceException
	 * @throws NotFoundException
	 *         The model where to save the TableInstance is not found.
	 */
	protected Object createEditorModel(final ServicesRegistry serviceRegistry, String name, String description) throws ServiceException, NotFoundException {
		final TableEditorConfiguration configuration = getDefaultTableEditorConfiguration();
		assert configuration != null;

		final Table table = TableHelper.createTable(configuration, getTableContext(), name, description);
		// Save the model in the associated resource
		final PapyrusNattableModel model = (PapyrusNattableModel)ServiceUtils.getInstance().getModelSet(serviceRegistry).getModelChecked(PapyrusNattableModel.MODEL_ID);
		model.addPapyrusTable(table);
		return table;
	}


	/**
	 * 
	 * @return
	 *         the configuration to use for the new table
	 */
	protected TableEditorConfiguration getDefaultTableEditorConfiguration() {
		final EObject current = getSelection().get(0);
		final ResourceSet resourceSet = current.eResource().getResourceSet();
		final Resource resource = resourceSet.getResource(getTableEditorConfigurationURI(), true);
		TableEditorConfiguration tableConfiguration = null;
		if(resource.getContents().get(0) instanceof TableEditorConfiguration) {
			tableConfiguration = (TableEditorConfiguration)resource.getContents().get(0);
		}
		return tableConfiguration;
	}


	protected abstract URI getTableEditorConfigurationURI();

	/**
	 * Get the current MultiDiagramEditor.
	 * 
	 * @return
	 * @throws BackboneException
	 */
	protected IMultiDiagramEditor getMultiDiagramEditor() throws BackboneException {
		return EditorUtils.getMultiDiagramEditorChecked();
	}

	/**
	 * Returns the context used to create the table
	 * 
	 * @return
	 *         the context used to create the table or <code>null</code> if not found
	 * @throws ServiceException
	 */
	//FIXME: This method introduces a dependency to UML. Use the semantic service instead.
	protected EObject getTableContext() {
		final List<EObject> selection = getSelection();

		if(!selection.isEmpty()) {
			return selection.get(0);
		}
		//FIXME
		//
		//		//we shouldn't try to find a valid context when the selection is not valid!
		//		ModelSet modelSet = null;
		//		ServicesRegistry serviceRegistry;
		//		try {
		//			serviceRegistry = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry();
		//			modelSet = ServiceUtils.getInstance().getModelSet(serviceRegistry);
		//		} catch (NullPointerException npe) {
		//			//
		//		} catch (ServiceException exception) {
		//
		//		}
		//
		//
		//		if(modelSet != null) {
		//			IModel model = modelSet.getModel(org.eclipse.papyrus.uml.tools.model.UmlModel.MODEL_ID);
		//
		//			if(model instanceof AbstractBaseModel) {
		//				return getRootElement(((AbstractBaseModel)model).getResource());
		//			}
		//		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	protected List<EObject> getSelection() {
		final List<EObject> selectedElements = new ArrayList<EObject>();
		final IWorkbenchWindow ww = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(ww != null) {
			final ISelection selection = ww.getSelectionService().getSelection();
			if(selection instanceof IStructuredSelection) {

				final IStructuredSelection structuredSelection = (IStructuredSelection)selection;

				final Iterator<?> it = structuredSelection.iterator();
				while(it.hasNext()) {
					final Object object = it.next();
					if(object instanceof IAdaptable) {
						final EObject currentEObject = (EObject)((IAdaptable)object).getAdapter(EObject.class);

						if(currentEObject != null) {
							selectedElements.add(currentEObject);
						}
					}

				}
			}
		}
		return selectedElements;
	}

	/**
	 * Get the root element associated with canvas.
	 */
	protected EObject getRootElement(final Resource modelResource) {
		EObject rootElement = null;
		if(modelResource != null && modelResource.getContents() != null && modelResource.getContents().size() > 0) {
			final Object root = modelResource.getContents().get(0);
			if(root instanceof EObject) {
				rootElement = (EObject)root;
			}
		}
		return rootElement;
	}

}
