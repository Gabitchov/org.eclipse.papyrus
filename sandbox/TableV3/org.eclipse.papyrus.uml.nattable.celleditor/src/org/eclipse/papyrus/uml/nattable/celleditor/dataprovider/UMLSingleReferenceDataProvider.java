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
package org.eclipse.papyrus.uml.nattable.celleditor.dataprovider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.edit.editor.IComboBoxDataProvider;
import org.eclipse.papyrus.infra.nattable.common.manager.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.widgets.providers.HierarchicToFlatContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.TreeToFlatContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.uml2.uml.Element;


public class UMLSingleReferenceDataProvider implements IComboBoxDataProvider {

	private ITableAxisElementProvider elementProvider;

	private EStructuralFeature editedFeature;

	public UMLSingleReferenceDataProvider(final EStructuralFeature feature, final ITableAxisElementProvider elementProvider) {
		this.elementProvider = elementProvider;
		this.editedFeature = feature;
	}

	public List<?> getValues(int columnIndex, int rowIndex) {
		final Object colElement = elementProvider.getColumnElement(columnIndex);
		final Object rowElement = elementProvider.getRowElement(rowIndex);

		EStructuralFeature feature = (EStructuralFeature)colElement;
		Element el = (Element)rowElement;

		if(colElement == editedFeature) {
			feature = (EStructuralFeature)editedFeature;
			el = (Element)rowElement;
		} else if(rowElement == editedFeature) {
			feature = (EStructuralFeature)editedFeature;
			el = (Element)colElement;
		} else {
			//There is a problem in the declaration of the editor...
		}
		UMLContentProvider provider = new UMLContentProvider(el, feature, null, el.eResource().getResourceSet());
		final TreeToFlatContentProvider flatP = new HierarchicToFlatContentProvider(provider);
		final List<Object> list = Arrays.asList(flatP.getElements());
		final List<EObject> availableValues = new ArrayList<EObject>();
		final Iterator<Object> iter = list.iterator();
		while(iter.hasNext()) {
			final Object current = iter.next();
			if(current instanceof EObject) {
				availableValues.add((EObject)current);
			}
		}
		return availableValues;
	}

	public EObject getEditedEObject(int columnIndex, int rowIndex) {
		final Object colElement = elementProvider.getColumnElement(columnIndex);
		final Object rowElement = elementProvider.getRowElement(rowIndex);

		Element el = (Element)rowElement;

		if(colElement == editedFeature) {
			el = (Element)rowElement;
		} else if(rowElement == editedFeature) {
			el = (Element)colElement;
		} else {
			//There is a problem in the declaration of the editor...
		}
		return el;
	}

	
	public Object getEditedFeature(int columnIndex, int rowIndex) {
		return editedFeature;
	}



}
