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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.nattable.manager.cell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFStringValueConverter;
import org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem;
import org.eclipse.papyrus.infra.nattable.paste.IValueSetter;
import org.eclipse.papyrus.infra.nattable.paste.ReferenceValueSetter;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.CellHelper;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter;
import org.eclipse.papyrus.infra.tools.converter.ConvertedValueContainer;
import org.eclipse.swt.widgets.Display;

/**
 * Cell Manager which allows to get the value of an {@link EStructuralFeature} for an {@link EObject}
 * 
 * @author Vincent Lorenzo
 * 
 */
public class EMFFeatureValueCellManager extends AbstractCellManager {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#handles(java.lang.Object, java.lang.Object)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean handles(final Object columnElement, final Object rowElement) {
		return organizeAndResolvedObjects(columnElement, rowElement, null) != null;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager#doGetValue(java.lang.Object, java.lang.Object,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @param tableManager
	 * @return
	 */
	@Override
	protected Object doGetValue(Object columnElement, Object rowElement, INattableModelManager tableManager) {
		final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement, null);
		final EObject eobject = (EObject)objects.get(0);
		final EStructuralFeature feature = (EStructuralFeature)objects.get(1);
		if(eobject.eClass().getEAllStructuralFeatures().contains(feature)) {
			return eobject.eGet(feature);
		}
		return NOT_AVALAIBLE;
	}

	/**
	 * 
	 * @param columnElement
	 *        the column element
	 * @param rowElement
	 *        the row element
	 * @param sharedMap
	 *        a map with interesting informations
	 * @return
	 *         <code>null</code> or a list of 2 objects.
	 *         <ul>
	 *         <li>the first element is the edited EObject</li>
	 *         <li>the second one is the edited feature</li>
	 *         </ul>
	 */
	protected List<Object> organizeAndResolvedObjects(final Object columnElement, final Object rowElement, Map<?, ?> sharedMap) {
		List<Object> objects = null;
		final Object row = AxisUtils.getRepresentedElement(rowElement);
		final Object column = AxisUtils.getRepresentedElement(columnElement);
		if(row instanceof EObject && column instanceof EStructuralFeature) {
			objects = new ArrayList<Object>();
			objects.add(row);
			objects.add(column);
		} else if(column instanceof EObject && row instanceof EStructuralFeature) {
			objects = new ArrayList<Object>();
			objects.add(column);
			objects.add(row);
		}
		return objects;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#isCellEditable(java.lang.Object, java.lang.Object)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean isCellEditable(final Object columnElement, final Object rowElement) {
		final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement, null);
		final EObject object = (EObject)objects.get(0);
		final EStructuralFeature feature = (EStructuralFeature)objects.get(1);
		if(object.eClass().getEAllStructuralFeatures().contains(feature)) {
			if(!feature.isDerived()) {
				return feature.isChangeable();
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager#getSetValueCommand(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object, org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 * 
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param tableManager
	 * @return
	 */
	@Override
	public Command getSetValueCommand(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final Object newValue, final INattableModelManager tableManager) {
		final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement, null);
		return getSetValueCommand(domain, (EObject)objects.get(0), (EStructuralFeature)objects.get(1), newValue, columnElement, rowElement, tableManager);
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param elementToEdit
	 *        the element to edit
	 * @param featureToEdit
	 *        the feature to edit
	 * @param newValue
	 *        the new value
	 * @return
	 *         the command to set the value
	 */
	protected Command getSetValueCommand(final TransactionalEditingDomain domain, final EObject elementToEdit, final EStructuralFeature featureToEdit, final Object newValue, final Object columnElement, final Object rowElement, final INattableModelManager tableManager) {
		final CompositeCommand result = new CompositeCommand("Set Value Command"); //$NON-NLS-1$
		
		//we need to destroy associated cell problem, if any.
		final Cell cell = tableManager.getCell(columnElement, rowElement);
		StringResolutionProblem stringPb = null;//we assume that there is only one string resolution problem for a cell
		if(cell != null && cell.getProblems().size() > 0) {
			for(final Problem current : cell.getProblems()) {
				if(current instanceof StringResolutionProblem) {
					stringPb = (StringResolutionProblem)current;
					break;
				}
			}
		}
		if(stringPb != null) {
			final DestroyElementRequest destroyRequest = new DestroyElementRequest(domain, stringPb, false);
			final IElementEditService commandProvider2 = ElementEditServiceUtils.getCommandProvider(stringPb);
			result.add(commandProvider2.getEditCommand(destroyRequest));
		}
		
		//426731: [Table 2] Opening then closing cells editors without modifying values execute a command in the stack
		//https://bugs.eclipse.org/bugs/show_bug.cgi?id=426731
		//1. we verify that the new value is not the same as the current value
		final Object currentValue = elementToEdit.eGet(featureToEdit);
		if((newValue == null && currentValue != null) || (newValue != null && !newValue.equals(currentValue))) {
    		//2. if not we do the job
    		final AbstractEditCommandRequest request = new SetRequest(domain, elementToEdit, featureToEdit, newValue);
    		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToEdit);
    		final ICommand cmd = provider.getEditCommand(request);
    		ICommand returnedCommand = cmd;
    		if(cmd.canExecute() && featureToEdit instanceof EReference) {
    			boolean shouldOpenDialog = false;
    			final EReference editedReference = (EReference)featureToEdit;
    
    			//we are editing a containment feature
    			if(editedReference.isContainment()) {
    				if(newValue instanceof Collection<?>) {
    					if(!editedReference.isMany()) {
    						return UnexecutableCommand.INSTANCE;
    					} else {
    						final Collection<?> currentValues = new ArrayList<Object>((Collection<?>)elementToEdit.eGet(editedReference));
    						final Collection<?> addedValues = new ArrayList<Object>((Collection<?>)newValue);
    						addedValues.removeAll((Collection<?>)currentValues);
    						//we need to test the added values
    						final Iterator<?> iter = ((Collection<?>)addedValues).iterator();
    						while(iter.hasNext() && !shouldOpenDialog) {
    							final Object current = iter.next();
    							if(current instanceof EObject) {
    								if(elementToEdit == current) {
    									//an element can be owned by itself
    									return UnexecutableCommand.INSTANCE;
    								} else {
    									shouldOpenDialog = ((EObject)current).eContainer() != elementToEdit;
    								}
    							}
    						}
    					}
    				} else if(elementToEdit == newValue) {
    					//an element cannot be owned by itself
    					return UnexecutableCommand.INSTANCE;
    				} else if(newValue instanceof EObject) {
    					shouldOpenDialog = ((EObject)newValue).eContainer() != elementToEdit;
    				}
    
    				if(shouldOpenDialog) {
    					returnedCommand = getOpenConfirmChangeContainmentDialogCommand(domain, returnedCommand, editedReference.isMany());
    				}
    
    			}
    		}
    		result.add(returnedCommand);
		}
		return result.isEmpty() ? null : new GMFtoEMFCommandWrapper(result);
	}


	protected final ICommand getOpenConfirmChangeContainmentDialogCommand(final TransactionalEditingDomain domain, final ICommand defaultCommand, final boolean isMany) {
		final String messageDialog;
		if(isMany) {
			messageDialog = "Your are setting a value in a containment feature. This action will change the owner of the dropped element(s).\nContinue?";
		} else {
			messageDialog = "Your are setting a value in a containment feature. The previous value will be erased and the owner of the dropped element(s) will be changed.\nContinue?";
		}
		final ICommand cmd = new AbstractTransactionalCommand(domain, "Set Value Command Dialog", null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final boolean result = MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Set Containment Value", messageDialog);
				if(result) {
					defaultCommand.execute(monitor, info);
					return CommandResult.newOKCommandResult();
				} else {
					return CommandResult.newCancelledCommandResult();
				}
			}
		};
		return cmd;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#getSetStringValueCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      EObject, java.lang.Object, java.lang.Object, java.lang.String, java.util.Map)
	 * 
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param stringResolvers
	 * @return
	 */
	@Override
	public Command getSetStringValueCommand(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final String newValue, final AbstractStringValueConverter valueSolver, final INattableModelManager tableManager) {
		final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement, null);
		final EObject editedObject = (EObject)objects.get(0);
		final EStructuralFeature editedFeature = (EStructuralFeature)objects.get(1);
		ConvertedValueContainer<?> solvedValue = valueSolver.deduceValueFromString(editedFeature, newValue);
		final CompositeCommand cmd = new CompositeCommand("Set Value As String Command"); //$NON-NLS-1$
		Object convertedValue = solvedValue.getConvertedValue();
		Command setValueCommand = getSetValueCommand(domain, editedObject, editedFeature, convertedValue, columnElement, rowElement, tableManager);
		if(setValueCommand != null) {
			cmd.add(new EMFtoGMFCommandWrapper(setValueCommand));
		}
		final Command createProblemCommand = getCreateStringResolutionProblemCommand(domain, tableManager, columnElement, rowElement, newValue, solvedValue);
		if(createProblemCommand != null) {
			cmd.add(new EMFtoGMFCommandWrapper(createProblemCommand));
		} else {
			//we need to destroy associated cell problem 
			final Cell cell = tableManager.getCell(columnElement, rowElement);
			StringResolutionProblem stringPb = null;//we assume that there is only one string resolution problem for a cell
			if(cell != null && cell.getProblems().size() > 0) {
				for(final Problem current : cell.getProblems()) {
					if(current instanceof StringResolutionProblem) {
						stringPb = (StringResolutionProblem)current;
						break;
					}
				}
			}
			if(stringPb != null) {
				final DestroyElementRequest destroyRequest = new DestroyElementRequest(domain, stringPb, false);
				final IElementEditService commandProvider2 = ElementEditServiceUtils.getCommandProvider(stringPb);
				cmd.add(commandProvider2.getEditCommand(destroyRequest));
			}
		}
		return cmd.isEmpty() ? null : new GMFtoEMFCommandWrapper(cmd);
	}


	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param tableManager
	 *        the table manager
	 * @param rowElement
	 *        the row element
	 * @param columnElement
	 *        the column element
	 * @param pastedText
	 *        the pasted text
	 * @param valueContainer
	 *        the converted value
	 * @return
	 *         the command to create a String resolution Problem
	 */
	@Deprecated
	//use CellHelper.getCreateStringResolutionProblemCommand(
	protected Command getCreateStringResolutionProblemCommand(final TransactionalEditingDomain domain, final INattableModelManager tableManager, final Object columnElement, final Object rowElement, final String pastedText, final ConvertedValueContainer<?> valueContainer) {
		return CellHelper.getCreateStringResolutionProblemCommand(domain, tableManager, columnElement, rowElement, pastedText, valueContainer);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager#getOrCreateStringValueConverterClass(org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager,
	 *      java.util.Map, java.lang.String)
	 * 
	 * @param tableManager
	 * @param existingConverters
	 * @param multiValueSeparator
	 * @return
	 */
	@Override
	public AbstractStringValueConverter getOrCreateStringValueConverterClass(INattableModelManager tableManager, Map<Class<? extends AbstractStringValueConverter>, AbstractStringValueConverter> existingConverters, final String multiValueSeparator) {
		AbstractStringValueConverter converter = existingConverters.get(EMFStringValueConverter.class);
		if(converter == null) {
			converter = new EMFStringValueConverter(tableManager.getTable().getContext(), multiValueSeparator);
			existingConverters.put(EMFStringValueConverter.class, converter);
		}
		return converter;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager#setValue(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object, org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 * 
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param tableManager
	 */
	@Override
	public void setValue(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final Object newValue, final INattableModelManager tableManager) {
		if(domain == null) {
			final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement, null);
			final EObject elementToEdit = (EObject)objects.get(0);
			final EStructuralFeature editedFeature = (EStructuralFeature)objects.get(1);
			elementToEdit.eSet(editedFeature, newValue);
		} else {
			super.setValue(domain, columnElement, rowElement, newValue, tableManager);
		}
	}

	/**
	 * Create the string problems if required
	 * 
	 * @param tableManager
	 * @param columnElement
	 * @param rowElement
	 * @param pastedText
	 * @param valueContainer
	 * @param sharedMap
	 */
	@Deprecated
	//use 	CellHelper.createStringResolutionProblem
	protected void createStringResolutionProblem(final INattableModelManager tableManager, final Object columnElement, final Object rowElement, final String pastedText, final ConvertedValueContainer<?> valueContainer, final Map<?, ?> sharedMap) {
		CellHelper.createStringResolutionProblem(tableManager, columnElement, rowElement, pastedText, valueContainer, sharedMap);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#setStringValue(java.lang.Object, java.lang.Object, java.lang.String,
	 *      org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager, java.util.Map)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @param valueAsString
	 * @param valueConverter
	 * @param tableManager
	 * @param sharedMap
	 */
	@Override
	public void setStringValue(final Object columnElement, final Object rowElement, final String valueAsString, final AbstractStringValueConverter valueConverter, final INattableModelManager tableManager, final Map<?, ?> sharedMap) {
		final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement, sharedMap);
		final EObject editedObject = (EObject)objects.get(0);
		final EStructuralFeature editedFeature = (EStructuralFeature)objects.get(1);
		ConvertedValueContainer<?> solvedValue = valueConverter.deduceValueFromString(editedFeature, valueAsString);
		if(editedFeature instanceof EReference) {
			@SuppressWarnings("unchecked")
			final List<IValueSetter> references = (List<IValueSetter>)sharedMap.get(Constants.REFERENCES_TO_SET_KEY);
			final ReferenceValueSetter structure = new ReferenceValueSetter(editedObject, (EReference)editedFeature, solvedValue.getConvertedValue());
			references.add(structure);
		} else {
			editedObject.eSet(editedFeature, solvedValue.getConvertedValue());
		}

		createStringResolutionProblem(tableManager, columnElement, rowElement, valueAsString, solvedValue, sharedMap);
	}
}
