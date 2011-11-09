/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.Elkouhen@cea.fr 
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.decoration.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.WordUtils;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.services.decoration.Activator;
import org.eclipse.papyrus.infra.services.decoration.DecorationService;


// TODO: Auto-generated Javadoc
/**
 * The Class DecorationUtils.
 */
public class DecorationUtils {

	/** Current element. */
	private Object element;

	/** current eobject. */
	private EObject eObject;

	/**
	 * The Enum MarkChildren.
	 */

	public enum MarkChildren {

		/** The NO. */
		NO,
		/** The DIRECT. */
		DIRECT,
		/** The ALL. */
		ALL
	};

	/**
	 * Instantiates a new decoration utils.
	 * 
	 * @param element
	 *        the element
	 */
	public DecorationUtils(Object element) {
		this.element = element;
		setEObject((EObject)Platform.getAdapterManager().getAdapter(element, EObject.class));
	}


	/**
	 * Instantiates a new decoration utils.
	 * 
	 * @param eObject
	 *        the e object
	 */
	public DecorationUtils(EObject eObject) {
		setEObject(eObject);
	}

	/**
	 * Instantiates a new decoration utils.
	 * 
	 * @param view
	 *        the view
	 */
	public DecorationUtils(View view) {
		setEObject(view.getElement());
	}

	/**
	 * Try child if empty.
	 */
	public void tryChildIfEmpty() {
		// element has no eObject. try parent
		if(getEObject() == null) {
			// TODO: is it possible to access the children in another way (without internal access?)
			if(element instanceof LinkItem) {
				List<?> items = ((LinkItem)element).getChildrenElements();
				if(items.size() > 0 && items.get(0) instanceof EObject) {
					// element = items[0];
					setEObject((EObject)items.get(0));
				}
			}
		}
	}

	/**
	 * Gets the e object.
	 * 
	 * @return the e object
	 */
	public EObject getEObject() {
		return eObject;
	}


	/**
	 * Sets the e object.
	 * 
	 * @param eObject
	 *        the new e object
	 */
	public void setEObject(EObject eObject) {
		this.eObject = eObject;
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
	 * Gets the hierarchical markers.
	 * 
	 * @return the hierarchical markers
	 */
	public MarkChildren getHierarchicalMarkers() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String choice = store.getString(Activator.getDefault().HIERARCHICAL_MARKERS);
		if(choice.equals("NO")) {
			return MarkChildren.NO;
		} else if(choice.equals("DIRECT")) {
			return MarkChildren.DIRECT;
		} else {
			return MarkChildren.ALL;
		}
	}

	/**
	 * Gets the decoration severity.
	 * 
	 * @param decorationService
	 *        the decoration service
	 * @param navigateToParents
	 *        the navigate to parents
	 * @return the decoration severity
	 */
	public int getDecorationSeverity(DecorationService decorationService, boolean navigateToParents) {
		Map<String, Decoration> decorations = getDecorations(decorationService);
		MarkChildren markChildren = getHierarchicalMarkers();
		int severity = 0;
		if(decorations != null) {
			Iterator it = decorations.entrySet().iterator();
			while(it.hasNext()) {
				Map.Entry pairs = (Map.Entry)it.next();
				Decoration decoration = (Decoration)pairs.getValue();
				EObject eObjectOfDecorator = decoration.getElement();
				boolean first = true;
				while(eObjectOfDecorator != null) {
					if(eObjectOfDecorator == getEObject()) {
						int severityI = decoration.getSeverity();
						if(severityI > severity) {
							severity = severityI;
						}
					}
					if(!navigateToParents)
						break;
					// navigate to parents, since parent folder is contaminated as well
					eObjectOfDecorator = eObjectOfDecorator.eContainer();
					if(markChildren != MarkChildren.ALL) {
						if((!first) || (markChildren == MarkChildren.NO)) {
							break;
						}
					}
					first = false;
				}
			}
		}
		return severity;
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
			Iterator it = decorations.entrySet().iterator();
			while(it.hasNext()) {
				Map.Entry pairs = (Map.Entry)it.next();
				Decoration decoration = (Decoration)pairs.getValue();
				EObject eObjectOfDecorator = decoration.getElement();
				if(eObjectOfDecorator == getEObject()) {
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


	/**
	 * Gets the decoration.
	 * 
	 * @param decorationService
	 *        the decoration service
	 * @param navigateToParents
	 *        the navigate to parents
	 * @return the decoration
	 */
	public Decoration getDecoration(DecorationService decorationService, boolean navigateToParents) {
		return new Decoration(getEObject().toString(), getDecorationSeverity(decorationService, navigateToParents), getDecorationMessage(decorationService), getEObject());
	}

}
