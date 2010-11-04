/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class GeneralizationUtil {

	/**
	 * Tests <code>true</code> if the classifier has this generalization in its inheritance links (directly or indirectly)
	 * 
	 * @param generalization
	 *        a generalization
	 * @param el
	 *        a {@link Classifier} or a {@link Property}
	 * @return
	 *         <code>true</code> if the classifier has this generalization in its inheritance links (directly or indirectly) <code>false</code> if not
	 */
	public boolean isConcernedByGeneralizationChanges(Generalization generalization, View view) {
		boolean isConcerned = false;
		NamedElement graphicalOwner = getGraphicalOwner(view);

		if(graphicalOwner instanceof Classifier) {
			if(graphicalOwner != null && generalization != null) {
				isConcerned = getAllGeneralization((Classifier)graphicalOwner).contains(generalization);
			}
		}

		if(isConcerned && existsAnotherInheritanceWay((Element)view.getElement(), generalization, graphicalOwner)) {
			isConcerned = false;
		}

		return isConcerned;
	}

	/**
	 * Tests if the classifier owns another way to inherit of the element
	 * 
	 * @param inheritedElement
	 *        the inherited element
	 * @param forbiddenPath
	 *        the generalization that we are destroying
	 * @param el
	 * 
	 * @return
	 *         <code>true</code> if another way exists to inherit of this element <code>false</code> if not
	 */
	protected boolean existsAnotherInheritanceWay(Element inheritedElement, Generalization forbiddenPath, NamedElement el) {
		Classifier _classifier = null;
		if(el instanceof Property) {
			Type type = ((Property)el).getType();
			if(type instanceof Classifier) {
				_classifier = (Classifier)type;
			}
		} else if(el instanceof Classifier) {
			_classifier = (Classifier)el;
		}

		if(el != null) {
			EList<Generalization> generalizations = _classifier.getGeneralizations();
			for(Generalization generalization : generalizations) {
				if(generalization != forbiddenPath) {
					Classifier general = generalization.getGeneral();
					if(general.getOwnedMembers().contains(inheritedElement)) {
						return true;
					} else if(existsAnotherInheritanceWay(inheritedElement, forbiddenPath, general)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Returns the classifier owning the view
	 * 
	 * @param view
	 *        a view
	 * @return
	 *         the Element owning this view
	 *         or <code>null</code> if not found
	 */
	protected NamedElement getGraphicalOwner(View view) {
		//the view is in a compartment
		if(view.eContainer() instanceof View) {
			EObject graphicalParent = ((View)view.eContainer()).getElement();
			if(graphicalParent instanceof Classifier || graphicalParent instanceof Property) {
				return (NamedElement)graphicalParent;
			}
		}
		return null;
	}

	/**
	 * Return all the generalization (direct and indirect) owning by the classifier
	 * 
	 * @param classifier
	 *        a classifier
	 * @return
	 *         all the generalization (direct and indirect) owning by the classifier
	 */
	protected List<Generalization> getAllGeneralization(Classifier classifier) {
		List<Generalization> list = new ArrayList<Generalization>();
		List<Generalization> listTmp = new ArrayList<Generalization>();
		if(classifier != null) {
			list.addAll(classifier.getGeneralizations());
			for(Generalization generalization : list) {
				listTmp.addAll(getAllGeneralization(generalization.getGeneral()));
			}
			list.addAll(listTmp);
		}
		return list;
	}
}
