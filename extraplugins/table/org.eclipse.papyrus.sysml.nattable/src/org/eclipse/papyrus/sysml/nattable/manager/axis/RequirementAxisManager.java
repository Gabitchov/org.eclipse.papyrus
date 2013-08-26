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
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;



/**
 * AxisManager for SysML Requirements
 * 
 * @author Vincent Lorenzo
 * 
 */
public class RequirementAxisManager extends AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager<Requirement> {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#canCreateAxisElement(java.lang.String)
	 * 
	 * @param elementId
	 * @return
	 */
	@Override
	public boolean canCreateAxisElement(String elementId) {
		return ((ISpecializationType)SysMLElementTypes.REQUIREMENT).getId().equals(elementId);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#getStereotypeApplication(org.eclipse.uml2.uml.Element)
	 * 
	 * @param el
	 * @return
	 */
	@Override
	protected Requirement getStereotypeApplication(Element el) {
		return UMLUtil.getStereotypeApplication(el, Requirement.class);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#isInstanceOfRequiredStereotypeApplication(java.lang.Object)
	 * 
	 * @param object
	 * @return
	 */
	@Override
	protected boolean isInstanceOfRequiredStereotypeApplication(final Object object) {
		return object instanceof Requirement;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#getStereotypeBaseElement(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param stereotypeApplication
	 * @return
	 */
	@Override
	protected Element getStereotypeBaseElement(final Requirement stereotypeApplication) {
		return stereotypeApplication.getBase_Class();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#isAllowedAsBaseElement(org.eclipse.uml2.uml.Element)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	protected boolean isAllowedAsBaseElement(final Element element) {
		return element instanceof Class;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager#getStereotypeApplicationBasePropertyName()
	 * 
	 * @return
	 */
	@Override
	protected String getStereotypeApplicationBasePropertyName() {
		return RequirementsPackage.eINSTANCE.getRequirement_Base_Class().getName();
	}

}
