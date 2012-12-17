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

package org.eclipse.papyrus.infra.table.common.handlers;

import java.util.ArrayList;
import java.util.Collection;
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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.facet.FacetAttribute;
import org.eclipse.emf.facet.infra.facet.FacetReference;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.ModelQuerySet;
import org.eclipse.emf.facet.infra.query.core.AbstractModelQuery;
import org.eclipse.emf.facet.infra.query.core.ModelQuerySetCatalog;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryException;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryResult;
import org.eclipse.emf.facet.widgets.nattable.NatTableWidgetUtils;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.AttributeColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.Column;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FacetAttributeColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FacetReferenceColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.FeatureColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.ReferenceColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstanceFactory;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.emf.facet.widgets.nattable.internal.NatTableWidgetInternalUtils;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration.TableConfiguration;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration2.TableConfiguration2;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.table.common.Activator;
import org.eclipse.papyrus.infra.table.common.dialog.TwoInputDialog;
import org.eclipse.papyrus.infra.table.common.messages.Messages;
import org.eclipse.papyrus.infra.table.common.modelresource.EMFFacetNattableModel;
import org.eclipse.papyrus.infra.table.common.modelresource.PapyrusNattableModel;
import org.eclipse.papyrus.infra.table.common.util.QueryRepresentation;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstanceFactory;
import org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;


/**
 * @author dumoulin
 * 
 */
public abstract class AbstractCreateNattableEditorCommand extends AbstractHandler {


	/** the default name for the table */
	private final String defaultName;

	/** the default description for the table */
	private final String defaultDescription = "Table Description"; //$NON-NLS-1$

	/** the description for the table */
	private String description;

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
	public AbstractCreateNattableEditorCommand(final String editorType, final String defaultName) {
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
		EObject context = getTableContext();
		return context instanceof Element;
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
			name = dialog.getValue();
			description = dialog.getValue_2();

			final ServicesRegistry serviceRegistry = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry();
			TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);

			//Create the transactional command
			AbstractEMFOperation command = new AbstractEMFOperation(domain, "Create Table Editor") { //$NON-NLS-1$

				@Override
				protected IStatus doExecute(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
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
				CheckedOperationHistory.getInstance().execute(command, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Activator.getDefault().log.error("Can't create Table Editor", e); //$NON-NLS-1$
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
		PapyrusTableInstance papyrusTable = PapyrustableinstanceFactory.eINSTANCE.createPapyrusTableInstance();
		papyrusTable.setName(name);
		papyrusTable.setType(editorType);
		PapyrusNattableModel papyrusModel = (PapyrusNattableModel)ServiceUtils.getInstance().getModelSet(serviceRegistry).getModelChecked(PapyrusNattableModel.MODEL_ID);
		papyrusModel.addPapyrusTableInstance(papyrusTable);

		setFillingQueries(papyrusTable); //should be done before the TableInstance creation
		setSynchronization(papyrusTable); //should be done before the TableInstance creation
		EObject context = getTableContext();
		Assert.isNotNull(context);
		List<EObject> elements = getInitialElement(papyrusTable, context);

		TableInstance2 tableInstance = NatTableWidgetUtils.createTableInstance(elements, defaultDescription, getTableConfiguration2(), getTableContext(), null);
		tableInstance.setDescription(description);

		final PapyrusTableConfiguration papyrusConfiguration = getPapyrusTableConfiguration();
		if(papyrusConfiguration != null) {
			papyrusTable.setPastedElementContainmentFeature(papyrusConfiguration.getPastedElementContainmentFeature());
			papyrusTable.setPastedElementId(papyrusConfiguration.getPastedElementId());

			// Add default column not already added. 
			List<EStructuralFeature> defaultFeatures = papyrusConfiguration.getDefaultColumns();
			for(Column column : tableInstance.getColumns()) {
				if(column instanceof FeatureColumn) {
					defaultFeatures.remove(((FeatureColumn)column).getFeature());
				}
			}
			for(final EStructuralFeature feature : defaultFeatures) {
				if(feature instanceof FacetAttribute) {
					FacetAttributeColumn col = TableinstanceFactory.eINSTANCE.createFacetAttributeColumn();
					col.setAttribute((FacetAttribute)feature);
					tableInstance.getColumns().add(col);
					tableInstance.getFacets2().add((Facet)feature.eContainer());
				} else if(feature instanceof FacetReference) {
					FacetReferenceColumn col = TableinstanceFactory.eINSTANCE.createFacetReferenceColumn();
					col.setReference((FacetReference)feature);
					tableInstance.getColumns().add(col);
					tableInstance.getFacets2().add((Facet)feature.eContainer());
				} else if(feature instanceof EAttribute) {
					AttributeColumn col = TableinstanceFactory.eINSTANCE.createAttributeColumn();
					col.setAttribute((EAttribute)feature);
					tableInstance.getColumns().add(col);
				} else if(feature instanceof EReference) {
					ReferenceColumn col = TableinstanceFactory.eINSTANCE.createReferenceColumn();
					col.setReference((EReference)feature);
					tableInstance.getColumns().add(col);
				}

			}
		}

		// Save the model in the associated resource
		EMFFacetNattableModel model = (EMFFacetNattableModel)ServiceUtils.getInstance().getModelSet(serviceRegistry).getModelChecked(EMFFacetNattableModel.MODEL_ID);
		model.addTableInstance(tableInstance);
		papyrusTable.setTable(tableInstance);

		tableInstance.setContext(context);

		setHiddenColumns(papyrusTable);
		return papyrusTable;
	}

	/**
	 * 
	 * @param papyrusTable
	 *        the papyrus table
	 * @param context
	 * @return the list of the initial element for the table
	 */
	private List<EObject> getInitialElement(PapyrusTableInstance papyrusTable, EObject context) {
		if(papyrusTable.isIsSynchronized() && !papyrusTable.getFillingQueries().isEmpty()) {
			List<EObject> elements = new ArrayList<EObject>();

			for(ModelQuery query : papyrusTable.getFillingQueries()) {
				ModelQuerySetCatalog catalog = ModelQuerySetCatalog.getSingleton();
				AbstractModelQuery impl = null;
				try {
					impl = catalog.getModelQueryImpl(query);
				} catch (ModelQueryException e) {
					Activator.getDefault().log.error(e);
				}
				if(impl != null) {
					ModelQueryResult result = impl.evaluate(context);
					Object value = result.getValue();
					if(value instanceof Collection<?>) {
						// the build the list of the elements to add in the
						// table
						for(Object currentObject : (Collection<?>)value) {
							if(currentObject instanceof EObject) {
								elements.add((EObject)currentObject);
							}
						}

					}
				}
			}
			return elements;
		}
		return Collections.emptyList();
	}

	/**
	 * Allows to hide the columns created by default
	 * 
	 * @param papyrusTable
	 */
	private void setHiddenColumns(final PapyrusTableInstance papyrusTable) {
		List<String> hiddenColumnsName = getHiddenColumnName();
		if(!hiddenColumnsName.isEmpty()) {
			for(Column column : papyrusTable.getTable().getColumns()) {
				String name = NatTableWidgetInternalUtils.getColumnName(column);
				if(hiddenColumnsName.contains(name)) {
					column.setIsHidden(true);
				}
			}
		}
	}

	/**
	 * Returns the list of the columns to hide. Currently, the name can be :
	 * <ul>
	 * <li>[Label]</li>
	 * <li>[Metaclass]</li>
	 * <li>/eContainer</li>
	 * </ul>
	 * 
	 * @return
	 *         the list of the columns to hide
	 */
	protected List<String> getHiddenColumnName() {
		return Collections.emptyList();
	}

	/**
	 * Returns the table configuration for the table
	 * 
	 * {@link Deprecated} // use getTableConfiguration2
	 * 
	 * @return
	 *         the table configuration of the table
	 *         FIXME should be removed in Papyrus 0.9.0
	 * 
	 */
	@Deprecated
	protected TableConfiguration getTableConfiguration() {
		return getTableConfiguration2();
	}

	/**
	 * Returns the table configuration for the table
	 * 
	 * @return
	 *         the table configuration of the table
	 * 
	 */
	protected TableConfiguration2 getTableConfiguration2() {
		final PapyrusTableConfiguration papyrusConfig = getPapyrusTableConfiguration();
		if(papyrusConfig != null) {
			return papyrusConfig.getTableConfiguration();
		}
		return null;
	}

	protected PapyrusTableConfiguration getPapyrusTableConfiguration() {
		return null;
	}

	/**
	 * Set the table synchronization to <code>true</code> if there is filling queries, to <code>false</code> if not
	 * 
	 * @param papyrusTable
	 *        the papyrusTable
	 */
	protected void setSynchronization(final PapyrusTableInstance papyrusTable) {
		papyrusTable.setIsSynchronized(papyrusTable.getFillingQueries().size() != 0);
	}

	/**
	 * Set the queries used to fill Papyrus
	 * 
	 * @param papyrusTable
	 *        the {@link PapyrusTableInstance} to fill with queries
	 */
	protected void setFillingQueries(final PapyrusTableInstance papyrusTable) {
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
	 * Returns the context used to create the table
	 * 
	 * @return
	 *         the context used to create the table or <code>null</code> if not found
	 * @throws ServiceException
	 */
	//FIXME: This method introduces a dependency to UML. Use the semantic service instead.
	protected EObject getTableContext() {
		List<EObject> selection = getSelection();

		if(!selection.isEmpty()) {
			return selection.get(0);
		}

		//we shouldn't try to find a valid context when the selection is not valid!
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
			IModel model = modelSet.getModel(org.eclipse.papyrus.uml.tools.model.UmlModel.MODEL_ID);

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
		final IWorkbenchWindow ww = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(ww != null) {
			ISelection selection = ww.getSelectionService().getSelection();
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
		}
		return selectedElements;
	}

	/**
	 * Get the root element associated with canvas.
	 */
	protected EObject getRootElement(final Resource modelResource) {
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
