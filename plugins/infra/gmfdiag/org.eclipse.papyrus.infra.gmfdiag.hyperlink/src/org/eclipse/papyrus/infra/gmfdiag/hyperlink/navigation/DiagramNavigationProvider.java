/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 430726
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.navigation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.infra.services.navigation.service.NavigableElement;
import org.eclipse.papyrus.infra.services.navigation.service.NavigationContributor;


public class DiagramNavigationProvider implements NavigationContributor {

	public List<NavigableElement> getNavigableElements(Object fromElement) {
		if(fromElement != null) {
			//Find pages under the element (isPageContainer)
			//Alt1: Find diagrams under the element (+ all Tables in a separate provider)

			List<NavigableElement> navigableElements = new LinkedList<NavigableElement>();


			for(Diagram diagram : getOwnedDiagrams(fromElement)) {
				navigableElements.add(new DiagramNavigableElement(diagram));
			}
			return navigableElements;
		}
		return Collections.emptyList();
	}

	protected List<Diagram> getOwnedDiagrams(Object fromElement) {
		EObject eObject = EMFHelper.getEObject(fromElement); //Should not be null (Otherwise, return=)
		View currentView = NotationHelper.findView(fromElement); //May be null (e.g. Selection from the ModelExplorer)
		if(eObject instanceof View || eObject == null) {
			return Collections.emptyList();
		}

		try {
			List<Diagram> ownedDiagrams = new LinkedList<Diagram>();

			IPageManager pageManager = ServiceUtilsForEObject.getInstance().getIPageManager(eObject);
			for(Object pageObject : pageManager.allPages()) {
				if(pageObject instanceof Diagram) {
					Diagram diagram = (Diagram)pageObject;

					//Avoid navigation to the current diagram
					if(currentView != null && currentView.getDiagram() == diagram) {
						continue;
					}

					if(diagram.getElement() == eObject) {
						ownedDiagrams.add(diagram);
					}
				}
			}

			return ownedDiagrams;
		} catch (ServiceException ex) {
			return Collections.emptyList();
		}
	}

}
