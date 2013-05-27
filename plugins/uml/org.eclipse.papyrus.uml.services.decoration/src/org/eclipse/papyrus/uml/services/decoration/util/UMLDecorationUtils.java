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
 * Patrick Tessier (CEA LIST)- initial implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.services.decoration.util;


import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.services.decoration.DecorationService;
import org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions;
import org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions.MarkChildren;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration;
import org.eclipse.papyrus.infra.services.decoration.util.DecorationSpecificFunctions;
import org.eclipse.papyrus.infra.services.decoration.util.DecorationUtils;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.uml2.uml.Element;


/**
 * overload the Generic decoration service to take in account validation on stereotyped element
 *
 */
public class UMLDecorationUtils extends DecorationUtils {

	public UMLDecorationUtils(Object object) {
		super(object);
	}

	
	/**
	 * Returns a list of decorations for a given UML element. It is a list, since there might be
	 * more than one decoration (e.g. a validation marker and a tracepoint) for this element.
	 * 
	 * If current element is a folder or link-item, decorations from childs are propagated.
	 * 
	 * @param decorationService
	 *        the decoration service
	 * @param navigateToParents
	 *        the navigate to parents
	 * @return the decoration severity
	 */
	public EList<IPapyrusDecoration> getDecorations(DecorationService decorationService, boolean navigateToParents) {
		Map<String, Decoration> decorations = getDecorations(decorationService);
		// child decorations are organized in a map indexed by the decoration type
		EList<IPapyrusDecoration> foundDecorations = new BasicEList<IPapyrusDecoration>();
		Map<String, EList<IPapyrusDecoration>> childDecorationMap = new HashMap<String, EList<IPapyrusDecoration>>();
		if(decorations != null) {
			for(Decoration decoration : decorations.values()) {
				EObject eObjectOfDecorator = decoration.getElement();
				if(getEObjects().contains(eObjectOfDecorator)) {
					// decoration is for this element
					if(decoration.getMessage() == null) {
						decoration.setMessage(""); //$NON-NLS-1$
					}
					foundDecorations.add(decoration);
				}

				// check whether a decoration is for an applied stereotype of a selected element
				for (EObject eObj : getEObjects()) {
					if (eObj instanceof Element) {
						for (EObject sterepApplication : ((Element) eObj).getStereotypeApplications()) {
							if (eObjectOfDecorator == sterepApplication) {
								foundDecorations.add(decoration);
							}                       
						}
					}
				}

				// check whether a decoration can be found in one the children
				// (technically, we check the parents of a decoration)
				IDecorationSpecificFunctions decoUtil = DecorationSpecificFunctions.getDecorationInterface(decoration.getType());


				if(navigateToParents && (decoUtil != null) && decoUtil.supportsMarkerPropagation() != MarkChildren.NO) {
					MarkChildren markChildren = decoUtil.supportsMarkerPropagation();
					boolean first = true;

					eObjectOfDecorator = eObjectOfDecorator.eContainer();
					while(eObjectOfDecorator != null) {
						if(getEObjects().contains(eObjectOfDecorator)) {
							String type = decoration.getType();
							EList<IPapyrusDecoration> childDecorations = childDecorationMap.get(type);
							if(childDecorations == null) {
								// does not exist yet => create
								childDecorations = new BasicEList<IPapyrusDecoration>();
								childDecorationMap.put(type, childDecorations);
							}
							childDecorations.add(decoration);
						}
						// navigate to parents, since parent folder is concerned by error as well
						eObjectOfDecorator = eObjectOfDecorator.eContainer();
						if(markChildren != MarkChildren.ALL) {
							if(!first) {
								break;
							}
						}
						first = false;
					}
				}
			}
		}

		// now process map of children
		for(String type : childDecorationMap.keySet()) {
			EList<IPapyrusDecoration> childDecorations = childDecorationMap.get(type);
			if(childDecorations != null) {
				IDecorationSpecificFunctions decoUtil = DecorationSpecificFunctions.getDecorationInterface(type);
				IPapyrusDecoration propagatedDecoration = decoUtil.markerPropagation(childDecorations);
				if(propagatedDecoration != null) {
					foundDecorations.add(propagatedDecoration);
				}
			}
		}

		return foundDecorations;
	}

}
