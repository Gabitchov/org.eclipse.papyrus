/**
 * 
 *  Copyright (c) 2011 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Vincent Lorenzo(CEA LIST) - initial API and implementation
 */
package org.eclipse.papyrus.compare.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.AddStereotypeApplication;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.RemoveStereotypeApplication;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * This class provides some useful methods for the Papyrus Comparator
 * 
 */
public class Utils {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	private Utils() {

	}

	/**
	 * 
	 * @param diff
	 *        a DiffElement
	 * @return
	 *         the represented element
	 */
	public static final EObject getRepresentedElement(DiffElement diff) {
		EObject representedElement = null;
		if(diff instanceof ModelElementChangeLeftTarget) {
			representedElement = ((ModelElementChangeLeftTarget)diff).getLeftElement();
		} else if(diff instanceof ModelElementChangeRightTarget) {
			representedElement = ((ModelElementChangeRightTarget)diff).getRightElement();
		}
		return representedElement;
	}

	/**
	 * 
	 * @param allDiffElements
	 *        the list of all available DiffElement
	 * @param obj
	 *        the selected object
	 * @return
	 *         all elements which hav to been selected with the current object
	 */
	public static final List<DiffElement> getAllAssociatedElement(List<DiffElement> allDiffElements, Object obj) {
		List<DiffElement> selection = new ArrayList<DiffElement>();
		if(obj instanceof Element) {
			Element el = (Element)obj;


			EList<Stereotype> appliedStereotypes = el.getAppliedStereotypes();
			for(Stereotype stereotype : appliedStereotypes) {
				//we select the required profile application
				DiffElement profileApplication = getProfileApplicationFor(allDiffElements, el, stereotype);
				if(profileApplication != null) {
					selection.add(profileApplication);
				}
				//we select the required stereotype application	
				DiffElement stereotypeApplication = getStereotypeApplicationFor(allDiffElements, el, stereotype);
				if(stereotypeApplication != null) {
					selection.add(stereotypeApplication);
				}
			}
		}
		return selection;
	}

	/**
	 * 
	 * @param diffElements
	 *        the list of the diff elements
	 * @param element
	 *        the element on which the stereotype is applied
	 * @param stereotype
	 *        the stereotype
	 * @return
	 *         the {@link DiffElement} corresponding to the ProfileApplication, or <code>null</code> if not found. (That is to say, the
	 *         ProfileApplication exists in the 2 compared files)
	 */
	private static final DiffElement getProfileApplicationFor(List<DiffElement> diffElements, final Element element, final Stereotype stereotype) {
		DiffElement diff = null;
		ProfileApplication profileApplication = Util.getNearestProfileApplicationFor(element, stereotype);
		Iterator<DiffElement> iter = diffElements.iterator();
		while(diff == null == iter.hasNext()) {
			DiffElement current = iter.next();
			if(profileApplication.equals(Utils.getRepresentedElement(current))) {
				diff = current;
			}
		}
		return diff;
	}

	/**
	 * 
	 * @param diffElements
	 *        the list of the diff elements
	 * @param element
	 *        the element on which the stereotype is applied
	 * @param stereotype
	 *        the stereotype
	 * @return
	 *         the DiffElement representing the stereotype application
	 */
	private static final DiffElement getStereotypeApplicationFor(List<DiffElement> diffElements, final Element element, final Stereotype stereotype) {
		DiffElement diff = null;
		EObject stereotypeApplication = element.getStereotypeApplication(stereotype);
		Iterator<DiffElement> iter = diffElements.iterator();
		while(diff == null && iter.hasNext()) {
			DiffElement current = iter.next();
			if(current instanceof RemoveStereotypeApplication || current instanceof AddStereotypeApplication) {
				if(stereotypeApplication.equals(Utils.getRepresentedElement(current))) {
					diff = current;
				}
			}
		}
		return diff;
	}


}
