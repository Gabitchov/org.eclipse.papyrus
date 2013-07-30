/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.adapter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.search.ui.ISearchPageScoreComputer;

/**
 * Computes the search page score for the Papyrus Search Page
 * 
 * @author Camille Letavernier
 */
public class PapyrusSearchPageScoreComputer implements ISearchPageScoreComputer {

	public int computeScore(String pageId, Object input) {
		if("org.eclipse.papyrus.search.ui.pages.PapyrusSearchPage".equals(pageId)) { //$NON-NLS-1$
			EObject currentEObject = EMFHelper.getEObject(input);
			if(currentEObject != null) {
				try {
					ServicesRegistry registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(currentEObject);
					if(registry != null) {
						return 99;
					}
				} catch (Exception ex) {
					//Nothing
				}
			}
		}
		return UNKNOWN;
	}

}
