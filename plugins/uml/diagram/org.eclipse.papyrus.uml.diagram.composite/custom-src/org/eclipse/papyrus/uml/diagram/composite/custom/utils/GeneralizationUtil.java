/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.utils;

import java.util.HashSet;
import java.util.Set;

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

		// If the View element is owned by its graphical owner bypass the tests
		if((Element)view.getElement().eContainer() != graphicalOwner) {

			if(graphicalOwner instanceof Classifier) {
				if(graphicalOwner != null && generalization != null) {
					isConcerned = getAllGeneralization((Classifier)graphicalOwner, null).contains(generalization);
				}
			} else if(graphicalOwner instanceof Property) {
				Type type = ((Property)graphicalOwner).getType();
				if(type instanceof Classifier) {
					isConcerned = getAllGeneralization((Classifier)type, null).contains(generalization);
				}
			}

			if(isConcerned && existsAnotherInheritanceWay((Element)view.getElement(), generalization, graphicalOwner, null)) {
				isConcerned = false;
			}

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
	protected boolean existsAnotherInheritanceWay(Element inheritedElement, Generalization forbiddenPath, NamedElement el, Set<Element> ignoredGeneralizations) {

		Set<Generalization> generalizations = new HashSet<Generalization>();

		Classifier _classifier = null;
		if(el instanceof Property) {
			Type type = ((Property)el).getType();
			if(type instanceof Classifier) {
				_classifier = (Classifier)type;
			}
		} else if(el instanceof Classifier) {
			_classifier = (Classifier)el;
		}

		// List Generalization that have already been tested to avoid loop issues
		// in case of Generalization cycles (such cycle creation should be avoided)
		Set<Element> ignoredGeneralizationsTmp = new HashSet<Element>();
		if(ignoredGeneralizations != null) {
			ignoredGeneralizationsTmp.addAll(ignoredGeneralizations);
		}

		if(el != null) {
			generalizations.addAll(_classifier.getGeneralizations());

			for(Generalization generalization : generalizations) {
				if((generalization != forbiddenPath) && (!ignoredGeneralizationsTmp.contains(generalization))) {

					Classifier general = generalization.getGeneral();
					if(general != null) {
						ignoredGeneralizationsTmp.add(generalization);

						if(general.getOwnedMembers().contains(inheritedElement)) {
							return true;

						} else if(existsAnotherInheritanceWay(inheritedElement, forbiddenPath, general, ignoredGeneralizationsTmp)) {
							return true;
						}
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
	protected Set<Generalization> getAllGeneralization(Classifier classifier, Set<Classifier> alreadyParsedClassifiers) {

		Set<Generalization> generalizations = new HashSet<Generalization>();

		// Keep track of already parsed Classifiers to avoid loop in case 
		// of Generalization cycle.
		Set<Classifier> parsedClassifiers = new HashSet<Classifier>();
		if(alreadyParsedClassifiers != null) {
			parsedClassifiers.addAll(alreadyParsedClassifiers);
		}

		Set<Generalization> generalizationsTmp = new HashSet<Generalization>();
		if(classifier != null) {
			generalizations.addAll(classifier.getGeneralizations());

			if(!parsedClassifiers.contains(classifier)) {
				parsedClassifiers.add(classifier);
				for(Generalization generalization : generalizations) {
					generalizationsTmp.addAll(getAllGeneralization(generalization.getGeneral(), parsedClassifiers));
				}
			}
		}

		generalizations.addAll(generalizationsTmp);

		return generalizations;
	}
}
