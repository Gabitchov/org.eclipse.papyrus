/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   Vincent Lorenzo (CEA-LIST) - bug 337326 - Show/Hide Column : Sort the columns by name
 *   Gregoire Dupe (Mia-Software) - Bug 366804 - [Restructuring] Table widget upgrade
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.menu.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Column;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.internal.impl.StereotypeImpl;

/**
 * A Content Provider which allows to sort the provided elements
 * 
 * 
 * 
 */
public class SortedColumnContentProvider implements ITreeContentProvider {

	/** boolean to know if the returned content should be sorted or not */
	private boolean isSorted = true;

	/** the initial content */
	private List<Column> initialList = new ArrayList<Column>();

	/** the comparator used to sort the element */
	private Comparator<Column> comparator = null;

	public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		if(newInput instanceof List) {
			for(Object object : (List<?>)newInput) {
				if(object instanceof Column) {
					Column column = (Column)object;
					this.initialList.add(column);
				}
			}
		}
	}

	public void dispose() {
		// Nothing
	}

	public Object[] getElements(final Object inputElement) {
		if(inputElement instanceof Map<?, ?>) {//should be deleted
			return ((Map)inputElement).keySet().toArray();
		} else if(inputElement instanceof Collection<?>) {
			return ((Collection)inputElement).toArray();
		}
		return new Object[0];
	}

	/**
	 * Setter for {@link #comparator}
	 * 
	 * @param comparator
	 *        the comparator used to sort the element
	 */
	public void setComparator(final Comparator<Column> comparator) {
		this.comparator = comparator;
	}

	/**
	 * Setter for {@link #isSorted}
	 * 
	 * @param newValue
	 * 
	 */
	public void setIsSorted(final boolean newValue) {
		this.isSorted = newValue;
	}

	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof EClass) {
			return ((EClass)parentElement).getEAllStructuralFeatures().toArray();
		}
		if(parentElement instanceof Set<?>) {
			return ((Set)parentElement).toArray();
		}
		if(parentElement instanceof EStructuralFeature) {
			return new Object[0];
		} else if(parentElement instanceof Stereotype) {
			EList<EStructuralFeature> allRef = ((Stereotype)parentElement).eClass().getEAllStructuralFeatures();
			List<Feature> features = new ArrayList(((Stereotype)parentElement).allFeatures());
			Collections.sort(features, new UMLFeatureComparator());
			return features.toArray();
		}
		if(parentElement instanceof Facet){
			return ((Facet)parentElement).getFacetElements().toArray();
		}
		return new Object[0];
	}

	public Object getParent(Object element) {
		if(element instanceof Element){
			return ((Element)element).eContainer();
		}else if(element instanceof FacetElement){
			return ((FacetElement)element).eContainer();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length != 0;
	}

	public class EcoreFeatureComparator implements Comparator<EStructuralFeature> {

		public int compare(EStructuralFeature o1, EStructuralFeature o2) {
			return o1.getName().compareToIgnoreCase(o2.getName());
		}

	}

	public class UMLFeatureComparator implements Comparator<Feature> {

		public int compare(Feature o1, Feature o2) {
			return o1.getName().compareToIgnoreCase(o2.getName());
		}

	}

}
