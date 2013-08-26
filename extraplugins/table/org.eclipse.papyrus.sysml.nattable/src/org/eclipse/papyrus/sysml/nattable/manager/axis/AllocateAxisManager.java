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
package org.eclipse.papyrus.sysml.nattable.manager.axis;

import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.papyrus.sysml.allocations.Allocate;
import org.eclipse.papyrus.sysml.allocations.AllocationsPackage;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Axis Manager for Allocate
 * 
 * @author vl222926
 * 
 */
public class AllocateAxisManager extends AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager<Allocate> {


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#canCreateAxisElement(java.lang.String)
	 * 
	 * @param elementId
	 * @return
	 */
	@Override
	public boolean canCreateAxisElement(final String elementId) {
		return ((ISpecializationType)SysMLElementTypes.ALLOCATE).getId().equals(elementId);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#isInstanceOfRequiredStereotypeApplication(java.lang.Object)
	 * 
	 * @param object
	 * @return
	 */
	@Override
	protected boolean isInstanceOfRequiredStereotypeApplication(Object object) {
		return object instanceof Allocate;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#getStereotypeApplication(org.eclipse.uml2.uml.Element)
	 * 
	 * @param el
	 * @return
	 */
	@Override
	protected Allocate getStereotypeApplication(final Element el) {
		return UMLUtil.getStereotypeApplication(el, Allocate.class);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#getStereotypeBaseElement(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param stereotypeApplication
	 * @return
	 */
	@Override
	protected Element getStereotypeBaseElement(final Allocate stereotypeApplication) {
		return stereotypeApplication.getBase_Abstraction();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#getStereotypeApplicationBasePropertyName()
	 * 
	 * @return
	 */
	@Override
	protected String getStereotypeApplicationBasePropertyName() {
		return AllocationsPackage.eINSTANCE.getAllocate_Base_Abstraction().getName();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#isAllowedAsBaseElement(org.eclipse.uml2.uml.Element)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	protected boolean isAllowedAsBaseElement(Element element) {
		return element instanceof Abstraction;
	}


}
