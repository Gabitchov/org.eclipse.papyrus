/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.uml.nattable.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer.MoveDirectionEnum;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelector;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * Abstract Cell Editor for MultiValued properties
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractUMLMultiValueCellEditor extends AbstractDialogCellEditor {

	private Collection<Object> returnedValue;

	/**
	 * the table axis element provider
	 */
	protected ITableAxisElementProvider manager;

	/**
	 * the axis element
	 */
	private Object axisElement;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param axisElement
	 *        the axis element
	 * @param elementProvider
	 *        the table axis element provider
	 */
	protected AbstractUMLMultiValueCellEditor(final Object axisElement, final ITableAxisElementProvider elementProvider) {
		this.manager = elementProvider;
		this.axisElement = axisElement;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor#open()
	 * 
	 * @return
	 */
	@Override
	public int open() {
		return ((MultipleValueSelectorDialog)this.dialog).open();
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor#createDialogInstance()
	 * 
	 * @return
	 */
	@Override
	public Object createDialogInstance() {
		int columnIndex = this.layerCell.getColumnIndex();
		int rowIndex = this.layerCell.getRowIndex();
		Object row = this.manager.getRowElement(rowIndex);
		Object column = this.manager.getColumnElement(columnIndex);
		row = AxisUtils.getRepresentedElement(row);
		column = AxisUtils.getRepresentedElement(column);
		Element editedElement = null;
		Object feature = null;
		if(row instanceof EObject && column == this.axisElement) {
			editedElement = (Element)row;
			feature = column;
		} else {
			editedElement = (Element)column;
			feature = row;
		}

		EStructuralFeature realFeature = null;
		EObject realEditedObject = null;
		Stereotype stereotype = null;
		List<Stereotype> stereotypesWithEditedFeatureAppliedOnElement = null;
		if(feature instanceof EStructuralFeature) {
			realFeature = (EStructuralFeature)feature;
			realEditedObject = editedElement;
		} else {
			final String id = AxisUtils.getPropertyId(this.axisElement);
			stereotypesWithEditedFeatureAppliedOnElement = UMLTableUtils.getAppliedStereotypesWithThisProperty(editedElement, id);
			stereotype = stereotypesWithEditedFeatureAppliedOnElement.get(0);
			realEditedObject = editedElement.getStereotypeApplication(stereotypesWithEditedFeatureAppliedOnElement.get(0));
			Property prop = UMLTableUtils.getRealStereotypeProperty(editedElement, id);
			realFeature = realEditedObject.eClass().getEStructuralFeature(prop.getName());
		}
		if(stereotypesWithEditedFeatureAppliedOnElement != null && stereotypesWithEditedFeatureAppliedOnElement.size() > 1) {
			//TODO : not yet managed
		} else {
			this.dialog = createDialog(realEditedObject, realFeature, stereotype, editedElement.eResource().getResourceSet());
		}
		return this.dialog;
	}

	/**
	 * 
	 * @param realEditedObject
	 *        the real edited object : the stereotype application or the edited Element
	 * @param realFeature
	 *        the real edited feature : the feature of the stereotype application or the the feature of the edited Element
	 * @param stereotype
	 *        the stereotype if we are are editing a stereotype application
	 * @param resourceSet
	 *        the resourceset
	 * @return
	 *         the dialog to edit the property
	 */
	protected Object createDialog(EObject realEditedObject, EStructuralFeature realFeature, Stereotype stereotype, ResourceSet resourceSet) {
		final UMLContentProvider p = new UMLContentProvider(realEditedObject, realFeature, stereotype, resourceSet);
		final String title = realFeature.getName();
		final boolean unique = realFeature.isUnique();
		final boolean ordered = realFeature.isOrdered();
		final int upperBound = realFeature.getUpperBound();
		final Object value = realEditedObject.eGet(realFeature);
		IElementSelector selector = getElementSelector(unique, new UMLLabelProvider(), p);
		final MultipleValueSelectorDialog dialog = new MultipleValueSelectorDialog(Display.getCurrent().getActiveShell(), selector, title, unique, ordered, upperBound) {

			@Override
			protected void okPressed() {
				super.okPressed();
				Collection<Object> newValue = new ArrayList<Object>();
				Object[] result = this.getResult();
				for(Object object : result) {
					newValue.add(object);

				}
				AbstractUMLMultiValueCellEditor.this.returnedValue = newValue;
				AbstractUMLMultiValueCellEditor.this.editHandler.commit(newValue, MoveDirectionEnum.NONE);
			}

		};
		dialog.setLabelProvider(new UMLLabelProvider());
		if(value != null && value instanceof Collection) {
			Collection<?> coll = (Collection<?>)value;
			if(!coll.isEmpty()) {
				dialog.setInitialSelections(coll.toArray());
			}
		}

		ReferenceValueFactory factory = getFactory();
		if(factory != null) {
			dialog.setFactory(factory);
		}

		return dialog;
	}

	/**
	 * 
	 * @return
	 *         the reference factory used to create to element
	 */
	protected abstract ReferenceValueFactory getFactory();

	/**
	 * 
	 * @param isUnique
	 * @param labelProvider
	 * @param contentProvider
	 * @return
	 *         the element selector to use in the dialog
	 */
	protected abstract IElementSelector getElementSelector(final boolean isUnique, final ILabelProvider labelProvider, final IStaticContentProvider contentProvider);

	@Override
	public Object getDialogInstance() {
		return this.dialog;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor#getEditorValue()
	 * 
	 * @return
	 */
	@Override
	public Object getEditorValue() {
		return this.returnedValue;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor#setEditorValue(java.lang.Object)
	 * 
	 * @param value
	 */
	@Override
	public void setEditorValue(Object value) {
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor#close()
	 * 
	 */
	@Override
	public void close() {
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor#isClosed()
	 * 
	 * @return
	 */
	@Override
	public boolean isClosed() {
		return false;
	}

}
