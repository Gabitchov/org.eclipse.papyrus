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
package org.eclipse.papyrus.infra.table.efacet.common.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.tableconfiguration.TableConfiguration;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.TableWidgetUtils;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.table.efacet.common.Activator;
import org.eclipse.papyrus.infra.table.efacet.common.modelresource.PapyrusTableModelResource;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustableFactory;
import org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public abstract class AbstractCreateTableEditorHandler extends AbstractHandler {

	/** the default name for the table */
	private final String defaultName;

	/** the name for the table */
	private String name;

	/** the editor type */
	private final String editorType;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editorType
	 *        the type of the editor
	 * @param defaultName
	 *        the default name for this editor
	 */
	public AbstractCreateTableEditorHandler(final String editorType, final String defaultName) {
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
		final EObject context = getTableContext();
		return context instanceof EObject;
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

			runAsTransaction();
		} catch (final ServiceException e) {
			throw new ExecutionException("Can't create TableEditor", e); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 
	 * @return <code>true</code> to open the name dialog
	 */
	protected boolean shouldOpenNameDialog() {
		return true;
	}

	/**
	 * Run the command as a transaction. Create a Transaction and delegate the
	 * command to {@link #doExecute(ServicesRegistry)}.
	 * 
	 * @throws ServiceException
	 * 
	 */
	public void runAsTransaction() throws ServiceException {
		// default Value
		this.name = this.defaultName;

		if(shouldOpenNameDialog()) {// this test is used to allow the JUnit
									// test without ui!
			final InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), "Create new table", "Table Name", this.name, null); //$NON-NLS-1$ //$NON-NLS-2$
			if(dialog.open() == Dialog.OK) {
				// get the name and the description for the table
				this.name = dialog.getValue();
			} else {
				return;
			}
		}
		final ServicesRegistry serviceRegistry = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry();
		final TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);

		// Create the transactional command
		final AbstractEMFOperation command = new AbstractEMFOperation(domain, "Create " + this.editorType) { //$NON-NLS-1$

			@Override
			protected IStatus doExecute(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				try {
					AbstractCreateTableEditorHandler.this.doExecute(serviceRegistry);
				} catch (final ServiceException e) {
					Activator.log.error(e);
					return Status.CANCEL_STATUS;
				} catch (final NotFoundException e) {
					Activator.log.error(e);
					return Status.CANCEL_STATUS;
				}
				return Status.OK_STATUS;
			}
		};

		// Execute the command
		try {
			CheckedOperationHistory.getInstance().execute(command, new NullProgressMonitor(), null); 
		} catch (final ExecutionException e) {
			Activator.log.error("Can't create Table Editor", e); //$NON-NLS-1$
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

		final Object editorModel = createEditorModel(serviceRegistry);
		// Get the mngr allowing to add/open new editor.
		final IPageMngr pageMngr = ServiceUtils.getInstance().getIPageMngr(serviceRegistry);
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
	protected Object createEditorModel(final ServicesRegistry serviceRegistry) throws ServiceException, NotFoundException {
		final PapyrusTable papyrusTable = PapyrustableFactory.eINSTANCE.createPapyrusTable();
		papyrusTable.setName(this.name);
		papyrusTable.setType(this.editorType);
		final PapyrusTableModelResource papyrusModel = (PapyrusTableModelResource)ServiceUtils.getInstance().getModelSet(serviceRegistry).getModelChecked(PapyrusTableModelResource.MODEL_ID);
		papyrusModel.addPapyrusTable(papyrusTable);

		final PapyrusTableConfiguration configuration = getPapyrusTableConfiguration();
		if(configuration != null) {
			papyrusTable.setFillingMode(configuration.getFillingMode());
			papyrusTable.setContextFeature(configuration.getListenContextFeature());
			papyrusTable.getQueries().addAll(configuration.getFillingQueries());
		}

		final EObject context = getTableContext();
		Assert.isNotNull(context);

		final String description = null;
		TableConfiguration tableConfiguration = null;
		if(configuration != null) {
			tableConfiguration = configuration.getTableConfiguration();
		}
		final Object parameter = null;
		final Table table = TableWidgetUtils.createTableInstance(Collections.EMPTY_LIST, description, tableConfiguration, context, parameter);

		papyrusTable.setTable(table);

		return papyrusTable;
	}

	/**
	 * 
	 * @return the configuration to use for the table. This method can return <code>null</code>
	 */
	protected final PapyrusTableConfiguration getPapyrusTableConfiguration() {
		PapyrusTableConfiguration configuration = null;
		final ResourceSet resourceSet = getTableContext().eResource().getResourceSet();

		final URI uri = getPapyrusTableConfigurationURI();
		if(uri != null) {
			final Resource resource = resourceSet.getResource(uri, true);
			EcoreUtil.resolveAll(resource);
			if(resource.getContents().get(0) instanceof PapyrusTableConfiguration) {
				configuration = (PapyrusTableConfiguration)resource.getContents().get(0);
			}
		}
		return configuration;
	}

	/**
	 * 
	 * @return the URI of the Papyrus Table Configuration
	 */
	protected URI getPapyrusTableConfigurationURI() {
		return null;
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
	 * @return the context used to create the table or <code>null</code> if not
	 *         found
	 * @throws ServiceException
	 */
	protected EObject getTableContext() {
		final List<EObject> selection = getSelection();

		if(!selection.isEmpty()) {
			return selection.get(0);
		}

		// we shouldn't try to find a valid context when the selection is not
		// valid!
		ModelSet modelSet = null;
		ServicesRegistry serviceRegistry;
		try {
			serviceRegistry = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry();
			modelSet = ServiceUtils.getInstance().getModelSet(serviceRegistry);
		} catch (final NullPointerException npe) {
			//
		} catch (final ServiceException exception) {

		}

		if(modelSet != null) {
			final IModel model = modelSet.getModel(org.eclipse.papyrus.infra.core.resource.uml.UmlModel.MODEL_ID);

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
		final List<EObject> selectedElements = new ArrayList<EObject>();
		final ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
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
