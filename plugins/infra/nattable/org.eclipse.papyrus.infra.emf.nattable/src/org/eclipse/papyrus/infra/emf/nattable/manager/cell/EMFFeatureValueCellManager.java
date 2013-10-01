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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFStringValueConverter;
import org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.paste.IValueSetter;
import org.eclipse.papyrus.infra.nattable.paste.ReferenceValueSetter;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.CellHelper;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter;
import org.eclipse.papyrus.infra.tools.converter.ConvertedValueContainer;

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
		return getSetValueCommand(domain, (EObject)objects.get(0), (EStructuralFeature)objects.get(1), newValue);
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
	protected Command getSetValueCommand(final TransactionalEditingDomain domain, final EObject elementToEdit, final EStructuralFeature featureToEdit, final Object newValue) {
		final AbstractEditCommandRequest request = new SetRequest(domain, elementToEdit, featureToEdit, newValue);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToEdit);
		return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
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
		Command setValueCommand = getSetValueCommand(domain, editedObject, editedFeature, convertedValue);
		if(setValueCommand != null) {
			cmd.add(new EMFtoGMFCommandWrapper(setValueCommand));
		}
		final Command createProblemCommand = getCreateStringResolutionProblemCommand(domain, tableManager, columnElement, rowElement, newValue, solvedValue);
		if(createProblemCommand != null) {
			cmd.add(new EMFtoGMFCommandWrapper(createProblemCommand));
		}
		if(cmd.isEmpty()) {
			return null;
		}
		return new GMFtoEMFCommandWrapper(cmd);
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
