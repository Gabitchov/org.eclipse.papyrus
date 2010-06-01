/**
 * 
 */
package org.eclipse.papyrus.core.resourceloading;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.ModelsReader;
import org.eclipse.papyrus.resource.notation.NotationUtils;
import org.eclipse.papyrus.resource.sasheditor.SashModelUtils;
import org.eclipse.papyrus.resource.uml.UmlUtils;


/**
 * A {@link ModelSet} allowing to load models on demand.
 * Also, this implementation allows to have loading strategies.
 * 
 * TODO extends {@link ModelSet} rather than {@link DiResourceSet}. This can be done once 
 * DiResourceSet is not referenced anyware.
 * 
 * @author cedric dumoulin
 * @author emilien perico
 *
 */
public class OnDemandLoadingModelSet extends DiResourceSet {

	/** Set that enables to always load the uri with any strategy. */
	private Set<URI> uriLoading = new HashSet<URI>();
	/** 
	 * The proxy manager that loads the model according to a specific strategy. 
	 */
	private ProxyManager proxyManager;

	/**
	 * 
	 * Constructor.
	 *
	 */
	public OnDemandLoadingModelSet() {
		super();
		// Register declared models
//		ModelsReader reader = new ModelsReader();
//		reader.readModel(this);
		
		proxyManager = new ProxyManager(this);
	}
	
	/**
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceSetImpl#getEObject(org.eclipse.emf.common.util.URI, boolean)
	 */
	@Override
	public EObject getEObject(URI uri, boolean loadOnDemand) {
		//return super.getEObject(uri, loadOnDemand);
		
		URI resourceURI = uri.trimFragment();
		// for performance reasons, we check the three initial resources first
		if(resourceURI.equals(UmlUtils.getUmlModel(this).getResourceURI()) || resourceURI.equals(NotationUtils.getNotationModel(this).getResourceURI()) 
			|| resourceURI.equals(SashModelUtils.getSashModel(this).getResourceURI()) || uriLoading.contains(resourceURI)) {
			// do not manage eObject of the current resources
			return super.getEObject(uri, loadOnDemand);
		} else if(loadOnDemand) {
			return proxyManager.getEObjectFromStrategy(uri);
		} else {
			return null;
		}			
	}

	/**
	 * Enables to add an URI that will be always loaded.
	 * It is not listening at the current loading strategy and always load the specified URI if needed.
	 *
	 * @param alwaysLoadedUri the always loaded uri
	 */
	public void forceUriLoading(URI alwaysLoadedUri) {
		uriLoading.add(alwaysLoadedUri);
	}

}
