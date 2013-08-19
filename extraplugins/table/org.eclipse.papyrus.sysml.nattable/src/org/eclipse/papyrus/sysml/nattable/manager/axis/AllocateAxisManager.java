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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EObjectAxis;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canDestroyAxisElement(java.lang.Integer)
	 * 
	 * @param axisPosition
	 * @return
	 */
	public boolean canDestroyAxisElement(Integer axisPosition) {
		final Object current = getElements().get(axisPosition);
		if(current instanceof EObjectAxis) {
			return !EMFHelper.isReadOnly(((EObjectAxis)current).getElement());
		} else if(current instanceof EObject) {
			return !EMFHelper.isReadOnly((EObject)current);
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getDestroyAxisElementCommand(TransactionalEditingDomain, java.lang.Integer)
	 * 
	 * @param domain
	 * @param axisPosition
	 * @return
	 */
	public Command getDestroyAxisElementCommand(TransactionalEditingDomain domain, Integer axisPosition) {
		final Object current = getElements().get(axisPosition);
		EObject elementToDestroy = null;
		if(current instanceof EObjectAxis) {
			elementToDestroy = ((EObjectAxis)current).getElement();
		} else if(current instanceof EObject) {
			elementToDestroy = (EObject)current;
		}
		if(elementToDestroy != null) {
			final DestroyElementRequest request = new DestroyElementRequest((TransactionalEditingDomain)getContextEditingDomain(), elementToDestroy, false);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToDestroy);
			return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
		}
		return null;
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
