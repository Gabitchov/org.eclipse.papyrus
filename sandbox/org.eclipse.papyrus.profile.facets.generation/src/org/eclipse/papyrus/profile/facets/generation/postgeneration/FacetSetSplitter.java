package org.eclipse.papyrus.profile.facets.generation.postgeneration;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.facet.infra.facet.FacetSet;


public class FacetSetSplitter {

	public static FacetSetSplitter instance = new FacetSetSplitter();

	private FacetSetSplitter() {

	}

	public Set<Resource> splitFacetSet(FacetSet facetSet) {
		return splitFacetSet(facetSet, true);
	}

	public Set<Resource> splitFacetSet(FacetSet facetSet, boolean removeEmptySets) {
		return splitFacetSet(facetSet, true, facetSet.eResource().getURI());
	}

	public Set<Resource> splitFacetSet(FacetSet facetSet, boolean removeEmptySets, URI baseURI) {
		Set<Resource> result = new HashSet<Resource>();
		ResourceSet rs = new ResourceSetImpl();

		Iterator<EPackage> iterator = facetSet.getESubpackages().iterator();
		while(iterator.hasNext()) {
			EPackage ePackage = iterator.next();
			if(ePackage instanceof FacetSet) {
				result.addAll(splitFacetSet((FacetSet)ePackage, removeEmptySets));
				iterator.remove();
			}
		}

		if(!(removeEmptySets && facetSet.getFacets().isEmpty())) {
			Resource resource = rs.createResource(URI.createURI(facetSet.getName() + ".facetSet").resolve(baseURI));
			resource.getContents().add(facetSet);
			result.add(resource);

			try {
				resource.save(null);
			} catch (IOException ex) {
				ex.printStackTrace(System.err);
			}
		}

		return result;
	}
}
