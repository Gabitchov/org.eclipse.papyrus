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
package org.eclipse.papyrus.uml.nattable.dataprovider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.edit.editor.IComboBoxDataProvider;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.widgets.providers.HierarchicToFlatContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.TreeToFlatContentProvider;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * @author Vincent Lorenzo
 *         This class provides the contents to display for single reference in the combobox
 */
public class UMLSingleReferenceComboBoxDataProvider implements IComboBoxDataProvider {

	/**
	 * The table axis element provider
	 */
	private ITableAxisElementProvider elementProvider;

	/**
	 * the axis element on which the combobox is declared
	 */
	private Object axisElement;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param axisElement
	 *        the axis element on which the combobox is declared
	 * @param elementProvider
	 *        The table axis element provider
	 */
	public UMLSingleReferenceComboBoxDataProvider(final Object axisElement, final ITableAxisElementProvider elementProvider) {
		this.elementProvider = elementProvider;
		this.axisElement = axisElement;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.IComboBoxDataProvider#getValues(int, int)
	 * 
	 * @param columnIndex
	 * @param rowIndex
	 * @return
	 */
	public List<?> getValues(int columnIndex, int rowIndex) {
		Object colElement = this.elementProvider.getColumnElement(columnIndex);
		Object rowElement = this.elementProvider.getRowElement(rowIndex);

		colElement = AxisUtils.getRepresentedElement(colElement);
		rowElement = AxisUtils.getRepresentedElement(rowElement);
		Element editedElement = null;
		Object axis = null;
		if(colElement == this.axisElement && rowElement instanceof EObject) {
			editedElement = (Element)rowElement;
			axis = colElement;
		} else if(colElement instanceof EObject && rowElement == this.axisElement) {
			editedElement = (Element)colElement;
			axis = rowElement;
		}

		if(editedElement != null && axis != null) {
			if(axis instanceof EReference) {
				return getPossibleValues(editedElement, (EReference)axis);
			} else {
				final String id = AxisUtils.getPropertyId(this.axisElement);
				return getPossibleValuesForStereotypeProperty(editedElement, id);
			}
		}
		return Collections.emptyList();
	}

	/**
	 * FIXME : should be merge with the specific method for stereotype property
	 * FIXME : this method should be stored in another plugin specific for UML
	 * 
	 * @param element
	 *        the edited element
	 * @param feature
	 *        the edited feature
	 * @return
	 *         the list of the possible values for this element
	 */
	private List<EObject> getPossibleValues(final EObject element, final EReference feature) {
		final List<EObject> availableValues = new ArrayList<EObject>();
		UMLContentProvider provider = new UMLContentProvider(element, feature, null, element.eResource().getResourceSet());
		final TreeToFlatContentProvider flatP = new HierarchicToFlatContentProvider(provider);
		final List<Object> list = Arrays.asList(flatP.getElements());
		final Iterator<Object> iter = list.iterator();
		while(iter.hasNext()) {
			final Object current = iter.next();
			if(current instanceof EObject) {
				availableValues.add((EObject)current);
			}
		}
		return availableValues;
	}

	/**
	 * 
	 * @param element
	 *        the element which are editing
	 * @param id
	 *        the id of the stereotype property
	 * @return
	 *         the list of the possible values for this element
	 */
	private List<EObject> getPossibleValuesForStereotypeProperty(final Element element, final String id) {
		final List<EObject> availableValues = new ArrayList<EObject>();
		Property prop = UMLTableUtils.getRealStereotypeProperty(element, id);
		final List<Stereotype> stereotypes = UMLTableUtils.getAppliedSteretoypesWithThisProperty(element, id);
		EObject steAppl = element.getStereotypeApplication(stereotypes.get(0));
		EStructuralFeature stereotypePropertyFeature = steAppl.eClass().getEStructuralFeature(prop.getName());
		final Stereotype ste = stereotypes.get(0);
		EObject container = prop.eContainer();
		assert container instanceof Stereotype;
		UMLContentProvider provider = new UMLContentProvider(steAppl, stereotypePropertyFeature, ste, element.eResource().getResourceSet());
		final TreeToFlatContentProvider flatP = new HierarchicToFlatContentProvider(provider);
		final List<Object> list = Arrays.asList(flatP.getElements());
		final Iterator<Object> iter = list.iterator();
		while(iter.hasNext()) {
			final Object current = iter.next();
			if(current instanceof EObject) {
				availableValues.add((EObject)current);
			}
		}

		return availableValues;
	}


	/**
	 * 
	 * @param columnIndex
	 *        the column index
	 * @param rowIndex
	 *        the rowindex
	 * @return
	 *         the edited object located at this place
	 */
	//	FIXME : try to remove this method, improving the ComboAction...
	public EObject getEditedEObject(int columnIndex, int rowIndex) {
		Object colElement = this.elementProvider.getColumnElement(columnIndex);
		Object rowElement = this.elementProvider.getRowElement(rowIndex);
		colElement = AxisUtils.getRepresentedElement(colElement);
		rowElement = AxisUtils.getRepresentedElement(rowElement);
		Element el = (Element)rowElement;

		if(colElement == this.axisElement) {
			el = (Element)rowElement;
		} else if(rowElement == this.axisElement) {
			el = (Element)colElement;
		} else {
			//There is a problem in the declaration of the editor...
		}
		return el;
	}

	/**
	 * 
	 * @param columnIndex
	 *        the column index
	 * @param rowIndex
	 *        the row index
	 * @return
	 *         the edited feature located at this place
	 */
	//FIXME : try to remove this method, improving the ComboAction...
	public Object getEditedFeature(int columnIndex, int rowIndex) {
		return this.axisElement;
	}



}
