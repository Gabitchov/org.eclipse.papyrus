/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.core.utils.DisplayUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.Messages;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.EMFFeatureModelHandler;
import org.eclipse.swt.widgets.Shell;

/**
 * Controller for EReferences controller
 */
public class EMFTEReferenceController extends EMFTStructuralFeatureController implements IBoundedValuesController, IWizardPropertyEditorController {

	/** identifier for this controller */
	public final static String ID = "emftEReferenceController"; //$NON-NLS-1$

	/** factory used by EMF objects */
	protected AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/** label provider for EMF objects */
	protected ILabelProvider labelProvider = initLabelProvider();

	/**
	 * {@inheritDoc}
	 */
	public Object getAvailableValues() {
		return getModelHandler().getAvailableValues(getObjectsToEdit().get(0));
	}

	/**
	 * Creates and return the label provider for this controller
	 * 
	 * @return the label provider for this controller
	 */
	protected ILabelProvider initLabelProvider() {
		final ILabelProvider provider = DisplayUtils.getLabelProvider();
		if(provider != null) {
			return provider;
		}
		Activator.log.warn("Impossible to find the label provider from the service registry"); //$NON-NLS-1$
		// adapter factory used by EMF objects
		return new AdapterFactoryLabelProvider(factory) {

			/**
			 * This implements {@link ILabelProvider}.getText by forwarding it
			 * to an object that implements {@link IItemLabelProvider#getText
			 * IItemLabelProvider.getText}
			 */
			public String getText(Object object) {
				// Get the adapter from the factory.
				//
				IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(object, IItemLabelProvider.class);
				if(object instanceof EObject) {
					if(((EObject)object).eIsProxy()) {
						return "Proxy - " + object; //$NON-NLS-1$
					}
				}
				return itemLabelProvider != null ? itemLabelProvider.getText(object) : object == null ? "" : object.toString(); //$NON-NLS-1$
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getCurrentValues() {
		// look only for first element
		EObject eObject = getObjectsToEdit().get(0);
		Object values = getModelHandler().getValueToEdit(eObject);
		if(values instanceof Object[]) {
			return (Object[])values;
		} else if(values instanceof List<?>) {
			return ((List<?>)values).toArray();
		} else if(values instanceof Object) {
			return Arrays.asList(values).toArray();
		}
		return new Object[]{ values };
	}

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getBrowserLabelProvider() {
		return labelProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getEditorLabelProvider() {
		return labelProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ViewerFilter> getViewerFilters() {
		List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
		ViewerFilter typeFilter = new ViewerFilter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				// return containsValidElements(element,
				// getFeatureToEdit().getEType().getInstanceClass());
				return true;
			}
		};
		filters.add(typeFilter);
		return filters;
	}

	/**
	 * {@inheritDoc}
	 */
	public IStructuredContentProvider getContentProvider() {
		return new AdapterFactoryContentProvider(factory) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public Object[] getElements(Object inputElement) {
				if(inputElement instanceof ResourceSet) {
					ResourceSet resourceSet = (ResourceSet)inputElement;

					ArrayList<EObject> contents = new ArrayList<EObject>();
					for(Resource resource : resourceSet.getResources()) {
						contents.addAll(resource.getContents());
					}
					return contents.toArray();
				}
				return super.getElements(inputElement);
			}
		};
	}

	/**
	 * Returns <code>true</code> if the element contains valid elements
	 * 
	 * @param element
	 *        the element to check
	 * @param typeClass
	 *        the type of element to check
	 * @return <code>true</code> if the element contains valid elements
	 */
	protected static boolean containsValidElements(Object element, Class<?> typeClass) {
		if(element instanceof Resource) {
			TreeIterator<EObject> iter = (((Resource)element)).getAllContents();
			while(iter.hasNext()) {
				if(containsValidElements(iter.next(), typeClass))
					return true;
			}
		}
		if(element instanceof EObject) {
			EObject eObject = (EObject)element;
			if(typeClass.isAssignableFrom(eObject.getClass())) {
				return true;
			}

			for(EObject content : eObject.eContents()) {
				if(containsValidElements(content, typeClass)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IUndoableOperation> getAvailableCreationOperations() {
		// retrieve the Eclass of the elements to edit
		List<IUndoableOperation> undoableOperations = new ArrayList<IUndoableOperation>();
		EClass eClass = retrieveEClass();
		if(eClass == null || getObjectsToEdit() == null || getObjectsToEdit().size() == 0 || !(getModelHandler() instanceof EMFFeatureModelHandler)) {
			return undoableOperations;
		}
		EObject eObject = getObjectsToEdit().get(0);
		EStructuralFeature feature = ((EMFFeatureModelHandler)getModelHandler()).getFeatureByName(eObject);
		if(!(feature instanceof EReference)) {
			return undoableOperations;
		}
		//IClientContext context;
		try {
			//context = UMLTypeContext.getContext();



			// Use UML service creation context and look for element types that are possible types of 
			// the selected EReference
			List<IElementEditService> containedTypeServices = ElementEditServiceUtils.getEditServiceProvider().getContainedTypeEditServices(eObject, (EReference)feature);
			for(IElementEditService service : containedTypeServices) {
				CreateElementRequest request = new CreateElementRequest(getEditingDomain(), eObject, (IElementType)service.getAdapter(IElementType.class), (EReference)feature);
				request.setLabel(Messages.bind(Messages.EMFTEReferenceController_CreationOperationMenuLabel, service.getDisplayName()));
				ICommand command = service.getEditCommand(request);
				if(command.canExecute()) {
					// adds it to the list of command that can be
					// executed
					undoableOperations.add(command);
				}
			}

		} catch (Exception e) {
			Activator.log.error(e);
		}
		return undoableOperations;
	}

	/**
	 * Retrieves the common metaclass for all selected objects
	 * 
	 * @return the selected metaclass
	 * 
	 */
	protected EClass retrieveEClass() {
		@SuppressWarnings("unchecked")
		List<EObject> eObjects = (List<EObject>)getObjectsToEdit();
		if(eObjects == null) {
			return null;
		} else if(eObjects.size() > 0) {
			return eObjects.get(0).eClass();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public int openPostCreationDialog(Shell shell) {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getDeleteOperation(List<Object> objectsToDelete) {
		CompositeTransactionalCommand undoableOperation = new CompositeTransactionalCommand(getEditingDomain(), Messages.EMFTEReferenceController_DeleteElement_OperationLabel);
		EClass eClass = retrieveEClass();
		if(eClass == null || getObjectsToEdit() == null || getObjectsToEdit().size() == 0 || !(getModelHandler() instanceof EMFFeatureModelHandler)) {
			return undoableOperation;
		}
		for(Object objectToDelete : objectsToDelete) {
			if(objectToDelete instanceof EObject) {
				DestroyElementRequest request = new DestroyElementRequest(getEditingDomain(), (EObject)objectToDelete, false);
				IUndoableOperation operation = ElementEditServiceUtils.getCommandProvider(objectToDelete).getEditCommand(request);
				if(operation != null && operation.canExecute()) {
					undoableOperation.add(operation);
				}
			} else {
				Activator.log.debug("the object to delete was not an EObject: " + objectToDelete);
			}
		}

		return undoableOperation.reduce();
	}
}
