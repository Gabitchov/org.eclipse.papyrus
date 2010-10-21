package org.eclipse.papyrus.core.utils;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;


public class PapyrusEcoreUtils {

	/**
	 * Gets the usages.
	 * 
	 * @param source
	 *        the source
	 * 
	 * @return the usages or null if there is no usages
	 */
	public static Collection<EStructuralFeature.Setting> getUsages(EObject source) {
		Collection<EStructuralFeature.Setting> collection = null;
		ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(source);
		if(crossReferenceAdapter != null) {
			collection = crossReferenceAdapter.getNonNavigableInverseReferences(source);
		} else {
			collection = EcoreUtil.UsageCrossReferencer.find(source, source.eResource().getResourceSet());
		}
		return collection;
	}
}
