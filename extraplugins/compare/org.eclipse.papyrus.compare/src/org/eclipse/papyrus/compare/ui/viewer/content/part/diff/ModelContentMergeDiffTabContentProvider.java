package org.eclipse.papyrus.compare.ui.viewer.content.part.diff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.TypedElementWrapper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.uml2.uml.Element;


public class ModelContentMergeDiffTabContentProvider extends AdapterFactoryContentProvider {


	/**
	 * Default constructor. Delegates to the super implementation.
	 * 
	 * @param factory
	 *        Factory to get labels and icons from.
	 */
	public ModelContentMergeDiffTabContentProvider(AdapterFactory factory) {
		super(factory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object[] getElements(Object object) {
		// overwritten to ensure contents of ResourceSets, List<Resource>, and Resource are correclty
		// returned.
		Object[] result = null;
		if(object instanceof ResourceSet) {
			final List<Resource> resources = ((ResourceSet)object).getResources();
			final List<Resource> elements = new ArrayList<Resource>(resources.size());
			for(final Resource resource : resources) {
				if(resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof ComparisonSnapshot)) {
					elements.add(resource);
				}
			}
			result = elements.toArray();
		} else if(object instanceof TypedElementWrapper) {
			result = new Object[]{ ((EObject)object).eResource(), };
		} else if(object instanceof List) {
			// we may also display a list of resources
			result = ((List)object).toArray();
		} else if(object instanceof Resource) {
			// return contents of resource
			return filterStereotypeApplications((Resource)object);
		} else {
			result = super.getElements(object);
		}
		return result;
	}

	private Object[] filterStereotypeApplications(Resource object) {
		EList<EObject> contents = object.getContents();
		List<EObject> result = new ArrayList<EObject>();
		for(int i = 0; i < contents.size(); i++) {
			EObject next = contents.get(i);
			if(!UMLCompareUtils.isStereotypeApplication(next)) {
				result.add(next);
			}
		}
		return result.toArray(new Object[result.size()]);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object object) {
		if(object instanceof Resource) {
			// return ((Resource)object).getContents().toArray();
			return new Object[]{ ((Resource)object).getContents().get(0) };
		}
		ArrayList<Object> result = new ArrayList<Object>();
		result.addAll(Arrays.asList(super.getChildren(object)));
		result.addAll(getStereotypeApplications(object));
		return result.toArray(new Object[result.size()]);
	}

	private List<EObject> getStereotypeApplications(Object eObject) {
		if(eObject instanceof Element) {
			return ((Element)eObject).getStereotypeApplications();
		}
		return Collections.emptyList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object object) {
		return getChildren(object).length > 0;
	}


}
