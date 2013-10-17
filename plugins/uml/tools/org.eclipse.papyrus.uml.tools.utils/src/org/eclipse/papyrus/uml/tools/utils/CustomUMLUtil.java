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
package org.eclipse.papyrus.uml.tools.utils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Provides methods for stereotypes application outside of a resource
 * 
 * @author vl222926
 * 
 */
public class CustomUMLUtil extends UMLUtil {

	/**
	 * The StereotypeApplicationHelper can be overridden to change the default
	 * location of applied stereotypes.
	 * Typically, stereotype applications are placed in the same location as
	 * the element to which the stereotype is applied, however, stereotype
	 * applications may be placed in other resources.
	 * 
	 * @since 3.0
	 */
	public static class StereotypeApplicationHelper extends UMLUtil.StereotypeApplicationHelper {

		public static final StereotypeApplicationHelper INSTANCE = createStereotypeApplicationHelper();

		private static StereotypeApplicationHelper createStereotypeApplicationHelper() {
			StereotypeApplicationHelper stereotypeApplicationHelper = UML2Util.loadClassFromSystemProperty("org.eclipse.uml2.uml.util.UMLUtil$StereotypeApplicationHelper.INSTANCE"); //$NON-NLS-1$

			if(stereotypeApplicationHelper != null) {
				return stereotypeApplicationHelper;
			}

			return new StereotypeApplicationHelper();
		}


		public EObject applyStereotype(Element element, EClass definition) {
			EObject stereotypeApplication = EcoreUtil.create(definition);

			CacheAdapter.getInstance().adapt(stereotypeApplication);

			//			addToContainmentList(element, stereotypeApplication);
			setBaseElement(stereotypeApplication, element);

			return stereotypeApplication;
		}

		/**
		 * Sets the base element for the specified stereotype application to the
		 * specified element.
		 * 
		 * @param stereotypeApplication
		 *        The stereotype application.
		 * @param element
		 *        The new base element.
		 */
		public static void setBaseElement(EObject stereotypeApplication, Element element) {

			if(stereotypeApplication != null) {
				EClass eClass = stereotypeApplication.eClass();
				//				if(getStereotype(eClass, stereotypeApplication) != null) {

				for(EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {

					if(eStructuralFeature.getName().startsWith(Extension.METACLASS_ROLE_PREFIX) && (element == null || eStructuralFeature.getEType().isInstance(element))) {

						stereotypeApplication.eSet(eStructuralFeature, element);
					}
				}
				//				}
			}
		}

	}
}
