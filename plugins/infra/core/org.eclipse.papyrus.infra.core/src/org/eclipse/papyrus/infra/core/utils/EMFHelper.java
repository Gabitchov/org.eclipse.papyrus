/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - filter out EObjects that are Resources (CDO)
 *  Christian W. Damus (CEA) - Support read-only state at object level (CDO)
 *  Christian W. Damus (CEA) - bug 426732
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.utils;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

/**
 * @deprecated Please use {@link org.eclipse.papyrus.infra.emf.utils.EMFHelper} instead
 *             (which inherit this one) for architectural reason.
 */
@Deprecated
public class EMFHelper {

	/**
	 * Gets the usages.
	 *
	 * @param source
	 *        the source
	 *
	 * @return the usages or null if there is no usages
	 */
	public static Collection<Setting> getUsages(EObject source) {
		if(source == null) {
			return Collections.emptyList();
		}

		ECrossReferenceAdapter crossReferencer = ECrossReferenceAdapter.getCrossReferenceAdapter(source);
		if(crossReferencer == null) {
			// try to register a cross referencer at the highest level
			crossReferencer = new ECrossReferenceAdapter();
			Resource resource = source.eResource();
			if(resource != null) {
				if(resource.getResourceSet() != null) {
					resource.getResourceSet().eAdapters().add(crossReferencer);
				} else {
					resource.eAdapters().add(crossReferencer);
				}
			} else {
				source.eAdapters().add(crossReferencer);
			}
		}

		return crossReferencer.getInverseReferences(source, false);
	}

}
