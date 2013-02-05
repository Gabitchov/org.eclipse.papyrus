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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.subelement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.MatchElement;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.uml2.match.UML2MatchEngine;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.compare.diff.services.nested.UMLMatchEngine;
import org.eclipse.papyrus.uml.compare.diff.services.standalone.StandaloneMergeUtils;
import org.eclipse.papyrus.uml.compare.diff.services.standalone.UMLStandaloneMatchEngine;
import org.eclipse.papyrus.uml.compare.subelement.Activator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * 
 * This match engine is used to compare 2 elements of 2 models
 * 
 */
public class SubElementUMLMatchEngine extends UMLMatchEngine {


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.compare.diff.services.nested.UMLMatchEngine#contentMatch(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject, java.util.Map)
	 * 
	 * @param leftObject
	 * @param rightObject
	 * @param optionMap
	 * @return
	 */
	@Override
	public MatchModel contentMatch(final EObject leftObject, final EObject rightObject, Map<String, Object> optionMap) {
		MatchModel matchModel = super.contentMatch(leftObject, rightObject, optionMap);
		fillDifferencesBetweenStereotypesApplication(matchModel);
		return matchModel;
	}

	protected void fillDifferencesBetweenStereotypesApplication(final MatchModel matchModel) {
		//we do a diff to find the differences between the applied stereotypes
		UML2MatchEngine engine = new UMLStandaloneMatchEngine();
		try {
			EObject leftRoot = leftObject;
			EObject rightRoot = rightObject;
			while(leftRoot.eContainer() != null) {
				leftRoot = leftRoot.eContainer();
			}
			while(rightRoot.eContainer() != null) {
				rightRoot = rightRoot.eContainer();
			}

			final MatchModel match = engine.resourceMatch(leftObject.eResource(), rightObject.eResource(), StandaloneMergeUtils.getMergeOptions(null, leftRoot, rightRoot));

			if(match != null) {
				if(match.getMatchedElements().size() == 1) {//it seems that we get only one
					MatchElement rootMatch = match.getMatchedElements().get(0);
					List<MatchElement> toAdd = new ArrayList<MatchElement>();
					for(final MatchElement element : rootMatch.getSubMatchElements()) {
						if(element instanceof Match2Elements) {
							EObject left = ((Match2Elements)element).getLeftElement();
							EObject right = ((Match2Elements)element).getRightElement();
							Element baseL = UMLUtil.getBaseElement(left);
							Element baseR = UMLUtil.getBaseElement(right);
							if(baseL != null && baseR != null && isRequiredByTheDiff((Element)leftObject, baseL) && isRequiredByTheDiff((Element)rightObject, baseR)) {
								toAdd.add(element);
							}
						}
					}
					//we compute the initial match model with the required stereotype application
					matchModel.getMatchedElements().get(0).getSubMatchElements().addAll(toAdd);

				}
			}
		} catch (InterruptedException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * 
	 * @param sourceElement
	 *        a uml element
	 * @param stereotypedElement
	 *        a stereotyped element
	 * @return
	 *         <code>true</code> if the stereotyped element is a subelement of the uml element
	 */
	private boolean isRequiredByTheDiff(final Element sourceElement, Element stereotypedElement) {
		EObject container = stereotypedElement;
		while(container != null) {
			if(container == sourceElement) {
				return true;
			}
			container = container.eContainer();
		}
		return false;
	}
}
