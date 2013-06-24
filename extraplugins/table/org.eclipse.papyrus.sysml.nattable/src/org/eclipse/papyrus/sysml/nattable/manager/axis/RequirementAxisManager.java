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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EObjectAxis;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.sysml.service.types.matcher.RequirementMatcher;
import org.eclipse.papyrus.uml.nattable.manager.axis.AbstractUMLSynchronizedOnFeatureAxisManager;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * AxisManager for SysML Requirements
 * 
 * @author Vincent Lorenzo
 * 
 */
public class RequirementAxisManager extends AbstractUMLSynchronizedOnFeatureAxisManager{//AbstractSynchronizedOnFeatureAxisManager {//FIXME must inherits from EObjectAxisManager when the listen feature is typed by an EObejct...

	//	/**
	//	 * 
	//	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager#addContextFeatureValueListener()
	//	 * 
	//	 */
	//	@Override
	//	protected void addContextFeatureValueListener() {
	//		this.featureListener = new AdapterImpl() {
	//
	//			@Override
	//			public void notifyChanged(Notification msg) {
	//				if(msg.getFeature() == RequirementAxisManager.this.listenFeatures || msg.getFeature() == UMLPackage.eINSTANCE.getPackage_PackagedElement()) {
	//					getTableManager().updateAxisContents(getRepresentedContentProvider());
	//				}
	//			}
	//		};
	//		getTableContext().eAdapters().add(this.featureListener);
	//	}

	//	/**
	//	 * 
	//	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager#dispose()
	//	 * 
	//	 */
	//	@Override
	//	public void dispose() {
	//		getTableContext().eAdapters().remove(this.featureListener);
	//		super.dispose();
	//	}


	@Override
	public boolean canCreateAxisElement(String elementId) {
		return ((ISpecializationType)SysMLElementTypes.REQUIREMENT).getId().equals(elementId);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager#filterObject(java.util.List)
	 * 
	 * @param objects
	 * @return
	 */
	@Override
	protected List<Object> filterObject(final List<Object> objects) {
		final List<Object> interestingObjects = new ArrayList<Object>();
		final RequirementMatcher matcher = new RequirementMatcher();
		for(Object object : objects) {
			if(object instanceof EObject) {
				if(matcher.matches((EObject)object)) {
					interestingObjects.add(object);
				}
			}
		}
		return interestingObjects;
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
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getDestroyAxisElementCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Integer)
	 * 
	 * @param domain
	 * @param axisPosition
	 * @return
	 */
	public Command getDestroyAxisElementCommand(EditingDomain domain, Integer axisPosition) {
		final Object current = getElements().get(axisPosition);
		if(current instanceof EObjectAxis) {
			final EObject element = ((EObjectAxis)current).getElement();
			final DestroyElementRequest request = new DestroyElementRequest((TransactionalEditingDomain)getContextEditingDomain(), element, false);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(element);
			return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
		}
		return null;
	}


}
