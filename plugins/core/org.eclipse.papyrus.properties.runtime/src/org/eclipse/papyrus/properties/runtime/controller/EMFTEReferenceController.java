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
package org.eclipse.papyrus.properties.runtime.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.core.utils.DisplayUtils;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.Messages;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.EMFFeatureModelHandler;
import org.eclipse.papyrus.uml.service.creation.element.UMLTypeContext;
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
		EClass eClass = retrieveEClass();
		if(eClass == null || getObjectsToEdit() == null || getObjectsToEdit().size() == 0 || !(getModelHandler() instanceof EMFFeatureModelHandler)) {
			Activator.log.debug("problems during initialization, looking for availables values");
			return getEditingDomain().getResourceSet();
		}
		EObject eObject = getObjectsToEdit().get(0);
		EStructuralFeature feature = ((EMFFeatureModelHandler)getModelHandler()).getFeatureByName(eObject);
		if(!(feature instanceof EReference)) {
			Activator.log.debug("feature is not a reference, looking for availables values: " + feature);
			return getEditingDomain().getResourceSet();
		}

		IItemPropertySource itemPropertySource = (IItemPropertySource)factory.adapt(eObject, IItemPropertySource.class);
		if(itemPropertySource == null) {
			return getEditingDomain().getResourceSet();
		}
		IItemPropertyDescriptor itemPropertyDescriptor = itemPropertySource.getPropertyDescriptor(eObject, feature);
		if(itemPropertyDescriptor == null) {
			return getEditingDomain().getResourceSet();
		}
		return itemPropertyDescriptor.getChoiceOfValues(eObject);
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
		List<Object> values = new ArrayList<Object>();
		for(EObject objectToEdit : getObjectsToEdit()) {
			values.add(getModelHandler().getValueToEdit(objectToEdit));
		}
		return values.toArray();
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
		IClientContext context;
		try {
			context = UMLTypeContext.getContext();

			// Use UML service creation context and look for element types that are possible types of 
			// the selected EReference
			IElementType[] featureTypes = ElementTypeRegistry.getInstance().getContainedTypes(eObject, (EReference)feature, context);
			if(featureTypes != null) {
				for(int i = 0; i < featureTypes.length; i++) {
					IElementType nextFeatureType = featureTypes[i];

					CreateElementRequest request = new CreateElementRequest(getEditingDomain(), eObject, nextFeatureType, (EReference)feature);
					request.setLabel(Messages.bind(Messages.EMFTEReferenceController_CreationOperationMenuLabel, nextFeatureType.getDisplayName()));
					ICommand command = nextFeatureType.getEditCommand(request);
					if(command.canExecute()) {
						// adds it to the list of command that can be
						// executed
						undoableOperations.add(command);
					}
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
		List<EObject> eObjects = getObjectsToEdit();
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
		EObject eObject = getObjectsToEdit().get(0);
		IClientContext context;
		try {
			context = UMLTypeContext.getContext();
			IElementType type = ElementTypeRegistry.getInstance().getElementType(eObject, context);
			IEditHelper helper = type.getEditHelper();
			for(Object objectToDelete : objectsToDelete) {
				if(objectToDelete instanceof EObject) {
					DestroyElementRequest request = new DestroyElementRequest(getEditingDomain(), (EObject)objectToDelete, false);
					IUndoableOperation operation = helper.getEditCommand(request);
					if(operation != null && operation.canExecute()) {
						undoableOperation.add(operation);
					}
				} else {
					Activator.log.debug("the object to delete was not an EObject: " + objectToDelete);
				}
			}
		} catch (Exception e) {
			Activator.log.error(e);
		}
		return undoableOperation.reduce();
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getMoveCurrentValuesOperation(List<Object> objects, int move) {
		IUndoableOperation undoableOperation = null;
		EClass eClass = retrieveEClass();
		if(eClass == null || getObjectsToEdit() == null || getObjectsToEdit().size() == 0 || !(getModelHandler() instanceof EMFFeatureModelHandler)) {
			return undoableOperation;
		}
		EObject eObject = getObjectsToEdit().get(0);
		// retrieve the current value (should be a list)
		EStructuralFeature feature = ((EMFFeatureModelHandler)getModelHandler()).getFeatureByName(eObject);
		Object currentValue = eObject.eGet(feature);
		if(currentValue instanceof List<?>) {
			@SuppressWarnings("unchecked")
			List<EObject> values = (List<EObject>)currentValue;
			List<EObject> copy = new ArrayList<EObject>(values);
			// make modification in copy list
			// check indices
			int min = copy.size();
			int max = 0;

			for(Object object : objects) {
				int index = copy.indexOf(object);
				if(index == -1) {
					Activator.log.debug("Impossible to find the index for object :" + object);
				}
				if(index < min) {
					min = index;
				}
				if(index > max) {
					max = index;
				}
			}

			// check that min and max are in the bounds of the list, with the
			// delta applied
			min += move;
			max += move;
			// check the bounds of the list
			if(min < 0) {
				Activator.log.debug("Trying to move up the elements, with a move which will cause an IndexOutOfBound exception");
				return undoableOperation;
			} else if(max >= copy.size()) {
				Activator.log.debug("Trying to move down the elements, with a move which will cause an IndexOutOfBound exception");
				return undoableOperation;
			}

			// now, do the move in the copy
			if(move < 0) {
				moveUpElementsInCollection(copy, objects, move);
			} else {
				moveDownElementsOperation(copy, objects, move);
			}

			// now, apply the new value
			IClientContext context;
			try {
				context = UMLTypeContext.getContext();
				IElementType type = ElementTypeRegistry.getInstance().getElementType(eObject, context);
				IEditHelper helper = type.getEditHelper();

				SetRequest request = new SetRequest(getEditingDomain(), eObject, feature, copy);
				IUndoableOperation operation = helper.getEditCommand(request);
				if(operation != null && operation.canExecute()) {
					undoableOperation = operation;
				}
			} catch (Exception e) {
				Activator.log.error(e);
			}
		}

		return undoableOperation;
	}

	/**
	 * Moves the element in the specified list, when the elements are moved down
	 * in the list
	 * 
	 * @param modifiedElements
	 *        list of elements modified
	 * @param objectsToMove
	 *        list of objects to move
	 * @param move
	 *        delta for the move. should be positive integer
	 */
	protected void moveDownElementsOperation(List<EObject> modifiedElements, List<Object> objectsToMove, int move) {
		// if moving down, starting from the end to move elements, assuming they
		// are in the increasing order by default
		Collections.reverse(objectsToMove);
		for(Object objectToMove : objectsToMove) {
			// retrieve index
			int index = modifiedElements.indexOf(objectToMove);
			// remove element
			modifiedElements.remove(index);
			// change index
			if(index == -1) {
				return;
			}
			index += move;
			// add the element to the new index
			modifiedElements.add(index, (EObject)objectToMove);
		}
	}

	/**
	 * Moves the element in the specified list, when the elements are moved up
	 * in the list
	 * 
	 * @param modifiedElements
	 *        list of elements modified
	 * @param objectsToMove
	 *        list of objects to move
	 * @param move
	 *        delta for the move. should be positive integer
	 */
	protected void moveUpElementsInCollection(List<EObject> modifiedElements, List<Object> objectsToMove, int move) {
		for(Object objectToMove : objectsToMove) {
			// retrieve index
			int index = modifiedElements.indexOf(objectToMove);
			// remove element
			modifiedElements.remove(index);
			// change index
			if(index == -1) {
				return;
			}
			index += move;
			// add the element to the new index
			modifiedElements.add(index, (EObject)objectToMove);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canMoveValues() {
		EClass eClass = retrieveEClass();
		if(eClass == null || getObjectsToEdit() == null || getObjectsToEdit().size() == 0 || !(getModelHandler() instanceof EMFFeatureModelHandler)) {
			return false;
		}
		EObject eObject = getObjectsToEdit().get(0);
		EStructuralFeature feature = ((EMFFeatureModelHandler)getModelHandler()).getFeatureByName(eObject);
		if(feature == null) {
			return false;
		}
		return feature.isOrdered();
	}
}
