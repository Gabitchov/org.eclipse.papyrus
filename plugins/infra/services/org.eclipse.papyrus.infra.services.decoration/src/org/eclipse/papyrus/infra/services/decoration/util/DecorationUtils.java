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
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.Elkouhen@cea.fr
 *  Ansgar Radermacher (CEA LIST) - ansgar.radermacher@cea.fr 
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.decoration.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.WordUtils;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.papyrus.infra.services.decoration.DecorationService;
import org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions;
import org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions.MarkChildren;


/**
 * The class DecorationUtils.
 */
public class DecorationUtils {

	/**
	 * Current element.
	 */
	protected Object element;

	/**
	 * List of eObjects to evaluate. Either a single object or a list of objects
	 * in case of a link item
	 */
	protected EList<EObject> eObjects;

	/**
	 * Create instance of class DecorationUtils.
	 * 
	 * @param element
	 *        the element
	 */
	public DecorationUtils(Object element) {
		if(element == null) {
			throw new IllegalArgumentException("The decorated element shall not be null");
		}

		EObject eObject = (EObject)Platform.getAdapterManager().getAdapter(element, EObject.class);
		eObjects = new BasicEList<EObject>();

		this.element = element;
		if(eObject != null) {
			eObjects.add(eObject);
		}
		else if(element instanceof LinkItem) {
			// for bug 391676
			for(Object child : ((LinkItem)element).getChildrenElements()) {
				if(child instanceof EObject) {
					eObjects.add((EObject)child);
				}
			}
		}
	}


	/**
	 * Instantiates a new decoration utils.
	 * 
	 * @param eObject
	 *        the e object
	 */
	public DecorationUtils(EObject eObject) {
		if(eObject == null) {
			throw new IllegalArgumentException("The decorated EObject shall not be null");
		}
		eObjects = new BasicEList<EObject>();
		eObjects.add(eObject);
	}

	/**
	 * Gets the list of eObjects associated with the selected elements.
	 */
	public EList<EObject> getEObjects() {
		return eObjects;
	}

	/**
	 * Gets the decorations.
	 * 
	 * @param decorationService
	 *        the decoration service
	 * @return the decorations
	 */
	public Map<String, Decoration> getDecorations(DecorationService decorationService) {
		return decorationService.getDecorations();
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
						decoration.setMessage("");
					}
					foundDecorations.add(decoration);
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

	/**
	 * Gets the decoration message.
	 * 
	 * @param decorationService
	 *        the decoration service
	 * @return the decoration message
	 */
	public String getDecorationMessage(DecorationService decorationService) {

		Map<String, Decoration> decorations = getDecorations(decorationService);
		if(decorations != null) {
			String message = "";
			for(Decoration decoration : decorations.values()) {
				EObject eObjectOfDecorator = decoration.getElement();
				if(getEObjects().contains(eObjectOfDecorator)) {
					if(message.length() > 0) {
						message += "\n";
					}
					message += "- " + WordUtils.wrap(decoration.getMessage(), 100, "\n  ", true);
				}
			}
			return (message.length() > 0) ? message : null;
		}
		return null;
	}
}
