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
package org.eclipse.papyrus.uml.table.common.provider;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.emf.facet.infra.facet.FacetStructuralFeature;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.emf.utils.ENamedElementComparator;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Feature;

/**
 * A Content Provider which allows to sort the provided elements
 * 
 * 
 * 
 */
public class SortedFeaturesContentProvider implements ITreeContentProvider {

	/** the comparator used to sort the element */
	private final Comparator<ENamedElement> comparator = new ENamedElementComparator();

	private final Comparator<StereotypePropertyElement> stereotypePropertyElement = new Comparator<StereotypePropertyElement>() {

		public int compare(StereotypePropertyElement namedElement1, StereotypePropertyElement namedElement2) {
			if(namedElement1 == null) {
				return namedElement2 == null ? 0 : -1;
			}

			return Collator.getInstance().compare(namedElement1.getPropertyQualifiedName(), namedElement2.getPropertyQualifiedName());
		}
	};

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 * 
	 */
	public void dispose() {
		// Nothing to do
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 * 
	 * @param inputElement
	 * @return
	 */
	public Object[] getElements(final Object inputElement) {
		if(inputElement instanceof Set<?>) {
			return ((Collection<?>)inputElement).toArray();
		}
		return new Object[0];
	}



	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 * 
	 * @param parentElement
	 * @return
	 */
	public Object[] getChildren(final Object parentElement) {
		if(parentElement instanceof StereotypeFacet) {
			final Set<StereotypePropertyElement> facetElements = new TreeSet<StereotypePropertyElement>(stereotypePropertyElement);
			facetElements.addAll(((StereotypeFacet)parentElement).getStereotypePropertyElements());
			return facetElements.toArray();
		}
		if(parentElement instanceof EStructuralFeature) {
			return new Object[0];
		}
		if(parentElement instanceof Facet) {
			final Set<ENamedElement> facetElements = new TreeSet<ENamedElement>(comparator);
			for(final Object current : ((Facet)parentElement).getEStructuralFeatures()) {
				if(current instanceof ENamedElement) {
					facetElements.add((ENamedElement)current);
				}

			}
			return facetElements.toArray();
		}

		if(parentElement instanceof ProfileFacetSet) {
			ProfileFacetSet set = (ProfileFacetSet)parentElement;
			final Set<ENamedElement> subFacetSet = new TreeSet<ENamedElement>(comparator);
			subFacetSet.addAll(set.getSubProfileFacetSet());
			final Set<ENamedElement> subFacets = new TreeSet<ENamedElement>(new ENamedElementComparator());
			subFacets.addAll(set.getStereotypeFacets());
			final List<ENamedElement> contents = new ArrayList<ENamedElement>();
			contents.addAll(subFacets);
			contents.addAll(subFacetSet);
			return contents.toArray();
		}

		if(parentElement instanceof FacetSet) {
			final FacetSet facetSet = (FacetSet)parentElement;
			final Set<ENamedElement> subFacetSet = new TreeSet<ENamedElement>(comparator);
			subFacetSet.addAll(facetSet.getESubpackages());
			final Set<ENamedElement> subFacets = new TreeSet<ENamedElement>(new ENamedElementComparator());
			subFacets.addAll(((FacetSet)parentElement).getEClassifiers());
			final List<ENamedElement> contents = new ArrayList<ENamedElement>();
			contents.addAll(subFacets);
			contents.addAll(subFacetSet);
			return contents.toArray();
		}
		return new Object[0];
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public Object getParent(final Object element) {
		if(element instanceof StereotypePropertyElement) {
			return ((StereotypePropertyElement)element).eContainer();
		}
		if(element instanceof StereotypeFacet) {
			return ((StereotypeFacet)element).eContainer();
		}
		if(element instanceof ProfileFacetSet) {
			return ((ProfileFacetSet)element).eContainer();
		}
		if(element instanceof Facet) {
			return ((Facet)element).eContainer();
		}
		if(element instanceof FacetSet) {
			return null;
		}
		if(element instanceof FacetStructuralFeature) {
			return ((FacetStructuralFeature)element).eContainer();
		}
		//FIXME
		//		if(element instanceof Element) {
		//			return ((Element)element).eContainer();
		//		} else if(element instanceof FacetElement) {
		//			return ((FacetElement)element).eContainer();
		//		} else if(element instanceof Facet) {
		//			return ((Facet)element).eContainer();
		//		} else if(element instanceof FacetSet) {
		//			FacetSet set = (FacetSet)element;
		//			EObject container = set.eContainer();
		//			if(container instanceof FacetSet) {
		//				if(!AdditionalContentsFacetSetUtils.ADDITIONAL_CONTENTS_FACET_SET_NS_URI.equals(((FacetSet)container).getNsURI())) {
		//					return container;
		//				}
		//			}
		//		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public boolean hasChildren(final Object element) {
		return getChildren(element).length != 0;
	}


	/**
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 * 
	 * @param viewer
	 * @param oldInput
	 * @param newInput
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//nothing to do
	}

}
