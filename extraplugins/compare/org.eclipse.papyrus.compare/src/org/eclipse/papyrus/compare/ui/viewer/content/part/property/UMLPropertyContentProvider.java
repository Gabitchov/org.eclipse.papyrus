/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare.ui.viewer.content.part.property;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.ui.viewer.content.part.property.PropertyContentProvider;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.compare.ui.viewer.content.part.UMLModelContentMergeTabFolder.Match2ElementsWithDiff;


public class UMLPropertyContentProvider extends PropertyContentProvider {


	@Override
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof Match2ElementsWithDiff) {
			return getElementsForDiff((Match2ElementsWithDiff)inputElement);
		}
		Object[] elements = super.getElements(inputElement);
		return elements;
	}

	protected Object[] getElementsForDiff(Match2ElementsWithDiff element) {
		List<Object> result = new ArrayList<Object>();
		Object[] elements = super.getElements(element);
		EStructuralFeature feature = getFeature(element.getDiffElement());
		if(feature != null) {
			List<Object> row = findRowFor(elements, feature);
			if(row != null) {
				result.add(row);
			}
		}
		return result.toArray(new Object[result.size()]);
	}

	protected EStructuralFeature getFeature(DiffElement diffElement) {
		if(diffElement instanceof AttributeChange) {
			return ((AttributeChange)diffElement).getAttribute();
		}
		if(diffElement instanceof ReferenceChange) {
			return ((ReferenceChange)diffElement).getReference();
		}
		return null;
	}


	protected List<Object> findRowFor(Object[] elements, EStructuralFeature feature) {
		for(Object nextRow : elements) {
			List<Object> row = (List<Object>)nextRow;
			if(feature.equals(row.get(0))) {
				return row;
			}
		}
		return null;
	}

}
