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
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.ui.viewer.content.part.property.PropertyContentProvider;
import org.eclipse.emf.ecore.EStructuralFeature;

public class UMLPropertyContentProvider extends PropertyContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		Object[] elements = super.getElements(inputElement);
		if(inputElement instanceof Match2ElementsWithDiff) {
			DiffElement diffElement = ((Match2ElementsWithDiff)inputElement).getDiffElement();
			return findRowsForFeatures(elements, getChangedFeatures(diffElement));
		}
		return elements;
	}

	protected Object[] findRowsForFeatures(Object[] propertyRows, EStructuralFeature[] features) {
		List<Object> result = new ArrayList<Object>();
		for (EStructuralFeature feature : features) {
			Object row = findPropertyRowFor(propertyRows, feature);
			if(row != null) {
				result.add(row);
			}
		}
		return result.toArray(new Object[result.size()]);
	}

	private EStructuralFeature[] getChangedFeatures(DiffElement diffElement) {
		if(diffElement instanceof AttributeChange) {
			EStructuralFeature feature = ((AttributeChange)diffElement).getAttribute();
			return new EStructuralFeature[]{feature};
		}
		if(diffElement instanceof ReferenceChange) {
			EStructuralFeature feature = ((ReferenceChange)diffElement).getReference();
			return new EStructuralFeature[]{feature};
		}
		if(diffElement instanceof DiffGroup) {
			EList<DiffElement> children = ((DiffGroup)diffElement).getSubDiffElements();
			List<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
			for (DiffElement child: children) {
				result.addAll(Arrays.asList(getChangedFeatures(child)));				
			}
			return result.toArray(new EStructuralFeature[result.size()]);
		}
			return new EStructuralFeature[0];
	}


	private Object findPropertyRowFor(Object[] propertyRows, EStructuralFeature feature) {
		for(Object nextRow : propertyRows) {
			if(isTheSameFeature(feature, getFeatureFromPropertyRow(nextRow))) {
				return nextRow;
			}
		}
		return null;
	}
	
	private EStructuralFeature getFeatureFromPropertyRow(Object propertyRow) {
		List<Object> row = (List<Object>)propertyRow;
		return (EStructuralFeature)row.get(0);
	}

	private boolean isTheSameFeature(EStructuralFeature feature1, EStructuralFeature feature2) {
		return feature1.getFeatureID() == feature2.getFeatureID() && feature1.getName().equals(feature2.getName());
	}

}
