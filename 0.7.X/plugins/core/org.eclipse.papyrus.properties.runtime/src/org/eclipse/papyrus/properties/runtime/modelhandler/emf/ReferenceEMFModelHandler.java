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
package org.eclipse.papyrus.properties.runtime.modelhandler.emf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.core.utils.DisplayUtils;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.Messages;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.service.creation.PapyrusClientContextManager;
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
	public static final String ID = "Reference";

	/**
	 * {@inheritDoc}
	 */
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
			Activator.log.error("impossible to set the new value", null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
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
			for(IClientContext clientContext : PapyrusClientContextManager.getAllPapyrusContext()) {
				// Use UML service creation context and look for element types that are possible types of 
				// the selected EReference
				IElementType[] featureTypes = ElementTypeRegistry.getInstance().getContainedTypes(eObject, (EReference)feature, clientContext);
				if(featureTypes != null) {
					for(int i = 0; i < featureTypes.length; i++) {
						IElementType nextFeatureType = featureTypes[i];
						CreateElementRequest request = new CreateElementRequest(EMFUtils.getTransactionalEditingDomain(objectsToEdit), eObject, nextFeatureType, (EReference)feature);
						request.setLabel(Messages.bind(Messages.EMFTEReferenceController_CreationOperationMenuLabel, nextFeatureType.getDisplayName()));
						ICommand command = nextFeatureType.getEditCommand(request);
						if(command.canExecute()) {
							// adds it to the list of command that can be
							// executed
							undoableOperations.add(command);
						}
					}
				}
			}
			return undoableOperations;
		} else {
			IUndoableOperation operation = new FindReferenceCommand(EMFUtils.getTransactionalEditingDomain(objectsToEdit), "Find and Add references", objectsToEdit);
			return Arrays.asList(operation);
		}
	}

	/**
	 * Command to create references.
	 * Two cases:
	 * - This is a containment reference, should create element.
	 * - This is a simple reference, should only browse the model to get other elements
	 */
	protected class FindReferenceCommand extends AbstractTransactionalCommand {

		/** list of objects to edit */
		protected final List<? extends EObject> objectsToEdit;

		/**
		 * Creates a new FindReferenceCommand.
		 * 
		 * @param domain
		 *        editing domain used to create or manipulate elements
		 * @param label
		 *        the label of the command, used by UI.
		 * @param objectsToEdit
		 *        the list of objects to edit
		 */
		public FindReferenceCommand(TransactionalEditingDomain domain, String label, List<? extends EObject> objectsToEdit) {
			super(domain, label, null);
			this.objectsToEdit = objectsToEdit;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			// checks the containment feature
			EObject eObject = objectsToEdit.get(0);
			EStructuralFeature feature = getFeatureByName(eObject);
			if(!(feature instanceof EReference)) {
				return CommandResult.newErrorCommandResult("the feature " + getFeatureName() + " is not a reference");
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
			FeatureEditorDialog dialog = new FeatureEditorDialog(display.getActiveShell(), DisplayUtils.getLabelProvider(), eObject, eclassifier, (List<EObject>)eObject.eGet(feature), "Select Values", values, false, feature.isOrdered(), feature.isUnique());
			// should select the current value by default
			if(Dialog.OK == dialog.open()) {
				@SuppressWarnings("unchecked")
				List<EObject> currentValues = (List<EObject>)dialog.getResult();
				eObject.eSet(feature, currentValues);
			}
			return CommandResult.newOKCommandResult();
		}
	}
}
