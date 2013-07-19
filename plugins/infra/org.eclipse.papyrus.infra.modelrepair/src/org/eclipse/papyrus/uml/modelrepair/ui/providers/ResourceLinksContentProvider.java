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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;
import org.eclipse.papyrus.infra.emf.readonly.ReadOnlyManager;

import com.google.common.base.Optional;


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
		return getChildren(element).length > 0;
	}

	protected Map<Resource, Set<URI>> allLinks() {
		if(allLinks != null) {
			return allLinks;
		}

		allLinks = new HashMap<Resource, Set<URI>>();

		if(input == null) {
			return allLinks;
		}

		EditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(input);
		if(input instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider)input).getEditingDomain();
		}
		IReadOnlyHandler readOnlyHandler = ReadOnlyManager.getReadOnlyHandler(domain);


		for(Resource resource : input.getResources()) {

			Set<URI> allReferencedURIs = new HashSet<URI>();
			allLinks.put(resource, allReferencedURIs);

			Iterator<EObject> allContents = resource.getAllContents();

			while(allContents.hasNext()) {
				EObject nextElement = allContents.next();
				Optional<Boolean> isReadOnly = readOnlyHandler.isReadOnly(nextElement);
				if(isReadOnly.isPresent() && isReadOnly.get()) {
					continue;
				}

				List<EObject> allReferencedEObjects = nextElement.eCrossReferences();
				for(EObject referencedEObject : allReferencedEObjects) {
					if(referencedEObject.eIsProxy()) {
						allReferencedURIs.add(EcoreUtil.getURI(referencedEObject));
					} else {
						if(referencedEObject.eResource() == null) {
							continue;
						}

						//Exclude local references
						if(referencedEObject.eResource() != resource) {
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
