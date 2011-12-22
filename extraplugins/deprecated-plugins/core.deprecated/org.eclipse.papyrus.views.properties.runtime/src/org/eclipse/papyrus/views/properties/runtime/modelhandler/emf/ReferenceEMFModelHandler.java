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
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.modelhandler.emf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.DisplayUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.Messages;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;


/**
 * Model Handler for References
 */
public class ReferenceEMFModelHandler extends EMFFeatureModelHandler {

	/**
	 * Creates a new ReferenceEMFModelHandler.
	 * 
	 * @param featureName
	 *        the name of the feature to edit
	 */
	public ReferenceEMFModelHandler(String featureName) {
		super(featureName);
	}

	/** identifier fot this model handler */
	public static final String ID = "Reference"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValueInModel(EObject objectToEdit, Object newValue) {
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return;
		}
		if(newValue instanceof EObject || newValue == null) {
			objectToEdit.eSet(featureToEdit, newValue);
		} else if(newValue instanceof List<?>) {
			objectToEdit.eSet(featureToEdit, newValue);
		} else {
			Activator.log.error("impossible to set the new value", null); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<? extends EObject> objectToEdit) {
	}

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IUndoableOperation> getCreateValueOperations(final List<? extends EObject> objectsToEdit, Composite parent) {
		// checks the containment feature
		EObject eObject = objectsToEdit.get(0);
		EStructuralFeature feature = getFeatureByName(eObject);
		if(!(feature instanceof EReference)) {
			return new ArrayList<IUndoableOperation>();
		}
		// check containment feature

		boolean isContainment = ((EReference)feature).isContainment();
		if(isContainment) {
			// retrieve the Eclass of the elements to edit
			List<IUndoableOperation> undoableOperations = new ArrayList<IUndoableOperation>();
			EClass eClass = eObject.eClass();
			if(eClass == null) {
				return undoableOperations;
			}
			// Use edit service and look for element types that are possible types of the selected EReference
			List<IElementEditService> featureTypeServices;
			try {
				featureTypeServices = ElementEditServiceUtils.getEditServiceProvider().getContainedTypeEditServices(eObject, (EReference)feature);
			} catch (ServiceException e) {
				e.printStackTrace();
				return undoableOperations;
			}

			for(IElementEditService featureTypeService : featureTypeServices) {
				CreateElementRequest request = new CreateElementRequest(EMFUtils.getTransactionalEditingDomain(objectsToEdit), eObject, (IElementType)featureTypeService.getAdapter(IElementType.class), (EReference)feature);
				request.setLabel(Messages.bind(Messages.EMFTEReferenceController_CreationOperationMenuLabel, featureTypeService.getDisplayName()));
				ICommand command = featureTypeService.getEditCommand(request);
				if(command.canExecute()) {
					// adds it to the list of command that can be
					// executed
					undoableOperations.add(command);
				}
			}

			return undoableOperations;
		} else {

			//			IUndoableOperation operation = new FindReferenceCommand(EMFUtils.getTransactionalEditingDomain(objectsToEdit), "Find and Add references", objectsToEdit);
			IUndoableOperation operation = getFindReferenceCommand(EMFUtils.getTransactionalEditingDomain(objectsToEdit), "Find and Add references", objectsToEdit); //$NON-NLS-1$
			return Arrays.asList(operation);
		}
	}

	/**
	 * Returns the command to find the reference
	 * 
	 * @param transactionalEditingDomain
	 *        the editing domain
	 * @param string
	 *        the name of the command
	 * @param objectsToEdit
	 *        the lists of objects to edit
	 * @return
	 *         the command to find the reference
	 */
	public IUndoableOperation getFindReferenceCommand(TransactionalEditingDomain transactionalEditingDomain, String string, List<? extends EObject> objectsToEdit) {
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(transactionalEditingDomain, string);
		// checks the containment feature
		EObject eObject = objectsToEdit.get(0);
		EStructuralFeature feature = getFeatureByName(eObject);
		if(!(feature instanceof EReference)) {
			return command;
		}

		// pops up a window to ask for a new reference
		Display display = Display.getCurrent();
		if(display == null && PlatformUI.isWorkbenchRunning()) {
			display = PlatformUI.getWorkbench().getDisplay();
		}
		display = (display != null) ? display : Display.getDefault();
		EClassifier eclassifier = feature.getEType();
		Object availableValues = getAvailableValues(eObject);
		List<?> values = new ArrayList<Object>();
		if(availableValues instanceof List<?>) {
			values = (List<?>)availableValues;
		} else if(availableValues instanceof Object[]) {
			values = Arrays.asList(availableValues);
		} else {
			values = Arrays.asList(availableValues);
		}

		@SuppressWarnings("unchecked")
		FeatureEditorDialog dialog = new FeatureEditorDialog(display.getActiveShell(), DisplayUtils.getLabelProvider(), eObject, eclassifier, (List<EObject>)eObject.eGet(feature), Messages.ReferenceEMFModelHandler_Select_Values, values, false, feature.isOrdered(), feature.isUnique());
		// should select the current value by default
		if(Dialog.OK == dialog.open()) {
			@SuppressWarnings("unchecked")
			List<EObject> currentValues = (List<EObject>)dialog.getResult();
			SetRequest[] requests = getSetRequest(transactionalEditingDomain, eObject, currentValues);
			if(requests != null) {

				org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(eObject);
				if(provider != null) {

					ICommand editCommand = null;
					for(SetRequest current : requests) {
						editCommand = provider.getEditCommand(current);

						if(editCommand != null && editCommand.canExecute()) {
							command.add(editCommand);
						}
					}
				}
			}
			return command;
		}

		return command;
	}

	//	/**
	//	 * Command to create references.
	//	 * Two cases:
	//	 * - This is a containment reference, should create element.
	//	 * - This is a simple reference, should only browse the model to get other elements
	//	 */
	//	protected class FindReferenceCommand extends AbstractTransactionalCommand {
	//
	//		/** list of objects to edit */
	//		protected final List<? extends EObject> objectsToEdit;
	//
	//		/**
	//		 * Creates a new FindReferenceCommand.
	//		 * 
	//		 * @param domain
	//		 *        editing domain used to create or manipulate elements
	//		 * @param label
	//		 *        the label of the command, used by UI.
	//		 * @param objectsToEdit
	//		 *        the list of objects to edit
	//		 */
	//		public FindReferenceCommand(TransactionalEditingDomain domain, String label, List<? extends EObject> objectsToEdit) {
	//			super(domain, label, null);
	//			this.objectsToEdit = objectsToEdit;
	//		}
	//
	//		/**
	//		 * {@inheritDoc}
	//		 */
	//		@Override
	//		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
	//
	//			// checks the containment feature
	//			EObject eObject = objectsToEdit.get(0);
	//			EStructuralFeature feature = getFeatureByName(eObject);
	//			if(!(feature instanceof EReference)) {
	//				return CommandResult.newErrorCommandResult("the feature " + getFeatureName() + " is not a reference");
	//			}
	//
	//			// pops up a window to ask for a new reference
	//			Display display = Display.getCurrent();
	//			if(display == null && PlatformUI.isWorkbenchRunning()) {
	//				display = PlatformUI.getWorkbench().getDisplay();
	//			}
	//			display = (display != null) ? display : Display.getDefault();
	//			EClassifier eclassifier = feature.getEType();
	//			Object availableValues = getAvailableValues(eObject);
	//			List<?> values = new ArrayList<Object>();
	//			if(availableValues instanceof List<?>) {
	//				values = (List<?>)availableValues;
	//			} else if(availableValues instanceof Object[]) {
	//				values = Arrays.asList(availableValues);
	//			} else {
	//				values = Arrays.asList(availableValues);
	//			}
	//
	//			@SuppressWarnings("unchecked")
	//			FeatureEditorDialog dialog = new FeatureEditorDialog(display.getActiveShell(), DisplayUtils.getLabelProvider(), eObject, eclassifier, (List<EObject>)eObject.eGet(feature), "Select Values", values, false, feature.isOrdered(), feature.isUnique());
	//			// should select the current value by default
	//			if(Dialog.OK == dialog.open()) {
	//				@SuppressWarnings("unchecked")
	//				List<EObject> currentValues = (List<EObject>)dialog.getResult();
	//				eObject.eSet(feature, currentValues);
	//			}
	//			return CommandResult.newOKCommandResult();
	//		}
	//	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandler#getSetRequest(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      org.eclipse.emf.ecore.EObject, java.lang.Object)
	 * 
	 * @param domain
	 * @param objectToEdit
	 * @param newValue
	 * @return
	 */
	public SetRequest[] getSetRequest(TransactionalEditingDomain domain, EObject objectToEdit, Object newValue) {

		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return null;
		}
		if(newValue instanceof EObject || newValue == null) {
			return new SetRequest[]{ new SetRequest(domain, objectToEdit, featureToEdit, newValue) };
		} else if(newValue instanceof List<?>) {
			return new SetRequest[]{ new SetRequest(domain, objectToEdit, featureToEdit, newValue) };
		} else {
			Activator.log.error("impossible to set the new value", null); //$NON-NLS-1$
		}
		return null;
	}
}
