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

package org.eclipse.papyrus.compare.diff.merge;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.merge.EMFCompareEObjectCopier;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * 
 * This implementation of Copier allows to copy correctly the StereotypeApplication.
 * Before to execute the copy, we reference the Element (on left and right) on which stereotypes are applied.
 * 
 */
public class StereotypeApplicationCopier extends EMFCompareEObjectCopier {

	/**
	 * the UID of the class
	 */
	private static final long serialVersionUID = -7851622832685318311L;

	/**
	 * the name of the structural feature base_Class
	 */
	public static final String BASE_CLASS = "base_Class";
	/**
	 * 
	 * Constructor.
	 * 
	 * @param diff
	 */
	public StereotypeApplicationCopier(DiffModel diff) {
		super(diff);
		initMapForCopy();
	}

	/**
	 * init the map before the copy, with couples of stereotyped elements
	 */
	protected void initMapForCopy() {
		EList<EObject> leftRoot = getDiffModel().getLeftRoots();
		EList<EObject> rightRoot = getDiffModel().getRightRoots();

		//we are working with UML files
		Assert.isTrue(leftRoot.size() != 0);
		Assert.isTrue(rightRoot.size() != 0);
		Resource leftResource = leftRoot.get(0).eResource();
		Resource rightResource = rightRoot.get(0).eResource();
		registerStereotypeApplication(rightResource, leftRoot);
		registerStereotypeApplication(leftResource, rightRoot);
	}

	/**
	 * The element and the resource should be opposite
	 * 
	 * @param resource
	 *        a resource (right resource or left resource)
	 * @param elements
	 *        elements (left elements or right elements)
	 */
	private void registerStereotypeApplication(Resource resource, List<EObject> elements) {
		for(EObject eObject : elements) {
			if(UMLCompareUtils.isStereotypeApplication(eObject)) {
				Element el = UMLUtil.getBaseElement(eObject);
				Resource resTmp = el.eResource();
				String uriFragment = null;
				if(resTmp != null) {
					uriFragment = resTmp.getURIFragment(el);
				}


				EObject stereotypedElement = resource.getEObject(uriFragment);
				if(stereotypedElement != null) {
					put(el, stereotypedElement);
				}
			}
		};
	}

	/**
	 * We override this method because :  
	 * <ul> 
	 * <li> the stereotype application is not yet in a resource here, so we add it to the resource before  (DONE)</li>
	 * </ul>
	 *
	 */
	@Override
	public void copyXMIIDs() {
		for(final Map.Entry<EObject, EObject> entry : entrySet()) {
			final EObject original = entry.getKey();
			final EObject copy = entry.getValue();
			if(UMLCompareUtils.isStereotypeApplication(original)) { //this test doesn't work with the copy!
				Resource copyEResource = copy.eResource();
				if(copyEResource == null) {
					EStructuralFeature feature = copy.eClass().getEStructuralFeature(BASE_CLASS);
					EObject value = (EObject)copy.eGet(feature);
					copyEResource = value.eResource();
					copyEResource.getContents().add(copy);
				}
			}
		}
		super.copyXMIIDs();
	}


}
