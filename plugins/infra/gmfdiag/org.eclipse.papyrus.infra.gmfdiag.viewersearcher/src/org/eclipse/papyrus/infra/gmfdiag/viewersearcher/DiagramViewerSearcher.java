/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 426732
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.viewersearcher;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.viewersearch.impl.AbstractViewerSearcher;

/**
 * 
 * Contributes to the viewersearchservice by providing the ability to search viewers in GMF diagrams
 * 
 */
public class DiagramViewerSearcher extends AbstractViewerSearcher {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.services.viewersearch.impl.AbstractViewerSearcher#getViewers(java.util.Collection, java.util.Collection)
	 * 
	 * @param modelElements
	 * @param modelSets
	 * @return
	 */
	@Override
	public Map<Object, Map<Object, Object>> getViewers(Collection<Object> modelElements, Collection<ModelSet> modelSets) {

		Map<Object, Map<Object, Object>> results = new HashMap<Object, Map<Object, Object>>();

		for(ModelSet modelSet : modelSets) {

			Map<EObject, Collection<Setting>> references = crossReference(modelElements, modelSet);

			for(Object semanticElement : references.keySet()) {
				for(Setting setting : references.get(semanticElement)) {
					if(setting.getEObject() instanceof View) {
						//Diagram diagram = ((View)setting.getEObject()).getDiagram();
						Map<Object, Object> viewMappings;

						if(results.containsKey(modelSet)) {
							viewMappings = results.get(modelSet);
						} else {
							viewMappings = new HashMap<Object, Object>();
						}
						viewMappings.put(setting.getEObject(), semanticElement);

						results.put(modelSet, viewMappings);
					}
				}
			}
		}

		return results;
	}
	
	private Map<EObject, Collection<Setting>> crossReference(Collection<?> modelElements, ModelSet modelSet) {
		Map<EObject, Collection<Setting>> result;
		
		final ECrossReferenceAdapter xrefs = ECrossReferenceAdapter.getCrossReferenceAdapter(modelSet);
		if (xrefs == null) {
			// one-off usage cross referencer
			result = EcoreUtil.UsageCrossReferencer.findAll(modelElements, modelSet);
		} else {
			result = new HashMap<EObject, Collection<Setting>>();
			for(Object next : modelElements) {
				if (next instanceof EObject) {
					EObject eObject = (EObject)next;
					result.put(eObject, xrefs.getInverseReferences(eObject));
				}
			}
		}
		
		return result;
	}
}
