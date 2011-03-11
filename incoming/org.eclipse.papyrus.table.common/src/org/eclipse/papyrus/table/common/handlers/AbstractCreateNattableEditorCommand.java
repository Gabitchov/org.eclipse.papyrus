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
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/

package org.eclipse.papyrus.table.common.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.ModelQuerySet;
import org.eclipse.emf.facet.infra.query.core.ModelQuerySetCatalog;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstanceFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.core.utils.ServiceUtils;
import org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrustableinstanceFactory;
import org.eclipse.papyrus.resource.AbstractBaseModel;
import org.eclipse.papyrus.resource.IModel;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.NotFoundException;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.table.common.dialog.TwoInputDialog;
import org.eclipse.papyrus.table.common.messages.Messages;
import org.eclipse.papyrus.table.common.modelresource.EMFFacetNattableModel;
import org.eclipse.papyrus.table.common.modelresource.PapyrusNattableModel;
import org.eclipse.papyrus.table.common.util.QueryRepresentation;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;


/**
 * @author dumoulin
 * 
 */
public abstract class AbstractCreateNattableEditorCommand extends AbstractHandler {


	/** the default name for the table */
	private String defaultName;

	/** the default description for the table */
	private String defaultDescription = "Table Description"; //$NON-NLS-1$

	/** the description for the table */
	private String description;

	/** the name for the table */
	private String name;

	/** the editor type */
	private String editorType;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editorType
	 *        the type of the editor
	 * @param defaultName
	 *        the default name for this editor
	 */
	public AbstractCreateNattableEditorCommand(String editorType, String defaultName) {
		Assert.isNotNull(editorType != null);
		this.editorType = editorType;
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
		//		try {
		//			if(getTableContext() != null) {
		//				return true;
		//			}
		//		} catch (ServiceException e) {
		//			// TODO Auto-generated catch block
		//			Activator.getDefault().logError("Context for table is null", e); //$NON-NLS-1$
		//
		//		}
		//		return false;
		return getTableContext() != null;
	}

	/**
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {

			runAsTransaction();
		} catch (ServiceException e) {
			throw new ExecutionException("Can't create TableEditor", e); //$NON-NLS-1$
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
		//default Value
		name = defaultName;
		description = defaultDescription;
		TwoInputDialog dialog = new TwoInputDialog(Display.getCurrent().getActiveShell(), Messages.AbstractCreateNattableEditorCommand_CreateNewTableDialogTitle, Messages.AbstractCreateNattableEditorCommand_CreateNewTableDialog_TableNameMessage, Messages.AbstractCreateNattableEditorCommand_CreateNewTableDialog_TableDescriptionMessage, defaultName, defaultDescription, null);
		if(dialog.open() == Dialog.OK) {
			//get the name and the description for the table
			this.name = dialog.getValue();
			this.description = dialog.getValue_2();

			final ServicesRegistry serviceRegistry = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry();
			TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);

			//Create the transactional command
			AbstractEMFOperation command = new AbstractEMFOperation(domain, "Create Table Editor") { //$NON-NLS-1$

				@Override
				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					try {
						AbstractCreateNattableEditorCommand.this.doExecute(serviceRegistry);
					} catch (ServiceException e) {
						e.printStackTrace();
						return Status.CANCEL_STATUS;
					} catch (NotFoundException e) {
						e.printStackTrace();
						return Status.CANCEL_STATUS;
					}
					return Status.OK_STATUS;
				}
			};

			// Execute the command
			try {
				OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				e.printStackTrace();
				Activator.getDefault().logError("Can't create Table Editor", e); //$NON-NLS-1$
			}

		}
	}

	/**
	 * Do the execution of the command.
	 * 
	 * @param serviceRegistry
	 * @throws ServiceException
	 * @throws NotFoundException
	 */
	public void doExecute(ServicesRegistry serviceRegistry) throws ServiceException, NotFoundException {

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
	protected Object createEditorModel(ServicesRegistry serviceRegistry) throws ServiceException, NotFoundException {
		PapyrusTableInstance papyrusTable = PapyrustableinstanceFactory.eINSTANCE.createPapyrusTableInstance();
		papyrusTable.setName(name);
		papyrusTable.setType(editorType);
		PapyrusNattableModel papyrusModel = (PapyrusNattableModel)ServiceUtils.getInstance().getModelSet(serviceRegistry).getModelChecked(PapyrusNattableModel.MODEL_ID);
		papyrusModel.addPapyrusTableInstance(papyrusTable);

		TableInstance tableInstance = TableinstanceFactory.eINSTANCE.createTableInstance();
		tableInstance.setDescription(description);

		// Save the model in the associated resource
		EMFFacetNattableModel model = (EMFFacetNattableModel)ServiceUtils.getInstance().getModelSet(serviceRegistry).getModelChecked(EMFFacetNattableModel.MODEL_ID);
		model.addTableInstance(tableInstance);
		papyrusTable.setTable(tableInstance);

		EObject context = getTableContext();
		Assert.isNotNull(context);
		tableInstance.setContext(context);

		setFillingQueries(papyrusTable);
		setSynchronization(papyrusTable);
		return papyrusTable;
	}

	/**
	 * Set the table synchronization to <code>true</code> if there is filling queries, to <code>false</code> if not
	 * 
	 * @param papyrusTable
	 *        the papyrusTable
	 */
	protected void setSynchronization(PapyrusTableInstance papyrusTable) {
		papyrusTable.setIsSynchronized(papyrusTable.getFillingQueries().size() != 0);
	}

	/**
	 * Set the queries used to fill Papyrus
	 * 
	 * @param papyrusTable
	 *        the {@link PapyrusTableInstance} to fill with queries
	 */
	protected void setFillingQueries(PapyrusTableInstance papyrusTable) {
		ModelQuerySetCatalog catalog = ModelQuerySetCatalog.getSingleton();
		for(QueryRepresentation rep : getQueryRepresentations()) {
			ModelQuerySet querySet = catalog.getModelQuerySet(rep.getQuerySetName());
			if(querySet != null) {
				ModelQuery query = querySet.getQuery(rep.getQueryName());
				if(query != null) {
					papyrusTable.getFillingQueries().add(query);
				}
			}
		}
	}

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
	protected EObject getTableContext() {
		List<EObject> selection = getSelection();

		if(!selection.isEmpty()) {
			return selection.get(0);
		}
		ModelSet modelSet = null;
		ServicesRegistry serviceRegistry;
		try {
			serviceRegistry = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry();
			modelSet = ServiceUtils.getInstance().getModelSet(serviceRegistry);
		} catch (NullPointerException npe) {
			//
		} catch (ServiceException exception) {

		}
		if(modelSet != null) {
			IModel model = modelSet.getModel(org.eclipse.papyrus.resource.uml.UmlModel.MODEL_ID);

			if(model instanceof AbstractBaseModel) {
				return getRootElement(((AbstractBaseModel)model).getResource());
			}
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	protected List<EObject> getSelection() {
		List<EObject> selectedElements = new ArrayList<EObject>();
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {

			IStructuredSelection structuredSelection = (IStructuredSelection)selection;

			Iterator<?> it = structuredSelection.iterator();
			while(it.hasNext()) {
				Object object = it.next();
				if(object instanceof IAdaptable) {
					EObject currentEObject = (EObject)((IAdaptable)object).getAdapter(EObject.class);

					if(currentEObject != null) {
						selectedElements.add(currentEObject);
					}
				}

			}
		}
		return selectedElements;
	}

	/**
	 * Get the root element associated with canvas.
	 */
	protected EObject getRootElement(Resource modelResource) {
		EObject rootElement = null;
		if(modelResource != null && modelResource.getContents() != null && modelResource.getContents().size() > 0) {
			Object root = modelResource.getContents().get(0);
			if(root instanceof EObject) {
				rootElement = (EObject)root;
			}
		}
		return rootElement;
	}

	/**
	 * This method should be overridden by the user, if he wants provide filling queries
	 * The list of the queries used to fill the table, identified by their querySet name and query name.
	 * 
	 * 
	 * @return
	 *         The list of the queries used to fill the table, identified by their querySet name and query name.
	 * 
	 */
	protected List<QueryRepresentation> getQueryRepresentations() {
		List<QueryRepresentation> list = new ArrayList<QueryRepresentation>();
		return list;
	}


}
