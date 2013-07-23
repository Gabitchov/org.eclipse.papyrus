package org.eclipse.papyrus.uml.modelrepair.ui.providers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.uml.modelrepair.readonly.ReadOnlyHelper;


public class ResourceLinksContentProvider implements ITreeContentProvider {

	protected TreeViewer viewer;

	protected ResourceSet input;

	protected Map<Resource, Set<URI>> allLinks;

	public void dispose() {
		allLinks = null;
		input = null;
		viewer = null;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (TreeViewer)viewer;
		if(newInput instanceof ResourceSet) {
			this.input = (ResourceSet)newInput;
		} else {
			this.input = null;
		}

		allLinks = null;
	}

	public Object[] getElements(Object inputElement) {
		return allLinks().keySet().toArray();
	}

	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof Resource) {
			Set<URI> uris = allLinks.get(parentElement);
			if(uris == null) {
				return new Object[0];
			}
			return uris.toArray();
		}

		return new Object[0];
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		if(element instanceof Resource) {
			Resource resource = (Resource)element;
			if(ReadOnlyHelper.isReadOnly(resource)) {
				return false;
			}
		}
		return getChildren(element).length > 0;
	}

	protected Map<Resource, Set<URI>> allLinks() {
		//Do not cache, to recompute the dependencies after a refresh
		//This may be expensive. TODO: Manually clean the cache before refresh.

		//		if(allLinks != null) {
		//			return allLinks;
		//		}

		allLinks = new HashMap<Resource, Set<URI>>();

		if(input == null) {
			return allLinks;
		}

		for(Resource resource : input.getResources()) {

			Set<URI> allReferencedURIs = new HashSet<URI>();
			allLinks.put(resource, allReferencedURIs);

			Iterator<EObject> allContents = resource.getAllContents();

			while(allContents.hasNext()) {
				EObject nextElement = allContents.next();
				//				Optional<Boolean> isReadOnly = readOnlyHandler.isReadOnly(nextElement);
				//				if(isReadOnly.isPresent() && isReadOnly.get()) {
				//					continue;
				//				}

				List<EObject> allReferencedEObjects = nextElement.eCrossReferences();
				EContentsEList.FeatureIterator<EObject> iterator = (EContentsEList.FeatureIterator<EObject>)allReferencedEObjects.iterator();
				while(iterator.hasNext()) {
					EObject referencedEObject = iterator.next();
					if(referencedEObject.eIsProxy()) {
						allReferencedURIs.add(EcoreUtil.getURI(referencedEObject));
					} else {
						if(referencedEObject.eResource() == null) {
							continue;
						}

						//Exclude local references
						if(referencedEObject.eResource() != resource) {
							if(iterator.feature().isTransient()) {
								continue;
							}

							allReferencedURIs.add(referencedEObject.eResource().getURI());
						}
					}
				}
			}
		}

		Iterator<Resource> removeEmptyLinks = allLinks.keySet().iterator();
		while(removeEmptyLinks.hasNext()) {
			Resource current = removeEmptyLinks.next();
			if(allLinks.get(current).isEmpty()) {
				removeEmptyLinks.remove();
			}
		}

		return allLinks;
	}
}
