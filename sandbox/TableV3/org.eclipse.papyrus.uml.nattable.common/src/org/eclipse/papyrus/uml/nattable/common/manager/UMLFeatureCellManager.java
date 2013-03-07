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
package org.eclipse.papyrus.uml.nattable.common.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.IdAxis;
import org.eclipse.papyrus.infra.nattable.solver.CellFeatureValueManager;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.nattable.celleditor.utils.UMLTableUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * @author Vincent Lorenzo
 *         This cell manager allows to display properties of stereotypes and execute the set value command
 */
public class UMLFeatureCellManager extends CellFeatureValueManager {

	/**
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 *         2 objects if this manager is able to manage it : the first one is the edited EObject, the 2nd one is the edited feature (or a string
	 *         representing it)
	 */
	protected List<Object> organizeUMLObject(Object obj1, Object obj2) {
		final List<Object> objects = new ArrayList<Object>();
		if(obj2 instanceof Element) {
			objects.add(obj2);
			objects.add(obj1);
		} else if(obj1 instanceof Element) {
			objects.add(obj1);
			objects.add(obj2);
		}

		final Object property = objects.get(1);
		String id = "";
		if(property instanceof IdAxis) {
			id = ((IdAxis)property).getElement();
			objects.remove(property);
			objects.add(id);
		} else if(property instanceof String) {
			id = (String)property;
		}
		if(!id.startsWith(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX)) {
			return Collections.emptyList();
		}
		return objects;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.solver.CellFeatureValueManager#handles(java.lang.Object, java.lang.Object)
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	@Override
	public boolean handles(Object obj1, Object obj2) {
		final List<EObject> objects = organizeObject(obj1, obj2);
		if(objects.size() == 2) {
			final EStructuralFeature feature = (EStructuralFeature)objects.get(1);
			final EObject featureContainer = feature.eContainer();
			if(UMLPackage.eINSTANCE.eContents().contains(featureContainer)) {
				return true;
			}
		}
		return organizeUMLObject(obj1, obj2).size() == 2;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.solver.CellFeatureValueManager#handlersAxisElement(java.lang.Object)
	 * 
	 * @param obj
	 * @return
	 */
	@Override
	public boolean handlersAxisElement(Object obj) {
		if(super.handlersAxisElement(obj)) {
			final EStructuralFeature feature = (EStructuralFeature)obj;
			EObject featureContainer = feature.eContainer();
			if(UMLPackage.eINSTANCE.eContents().contains(featureContainer)) {
				return true;
			}
		}
		return false;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.solver.CellFeatureValueManager#getValue(java.lang.Object, java.lang.Object)
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	@Override
	public Object getValue(Object obj1, Object obj2) {
		if(super.handles(obj1, obj2)) {
			return super.getValue(obj1, obj2);
		} else {
			final List<Object> umlObjects = organizeUMLObject(obj1, obj2);
			if(umlObjects.size() == 2) {
				final Element el = (Element)umlObjects.get(0);
				final String id = (String)umlObjects.get(1);
				final Property prop = UMLTableUtils.getRealStereotypeProperty(el, id);
				final List<Stereotype> stereotypesWithThisProperty = UMLTableUtils.getAppliedSteretoypesWithThisProperty(el, id);
				if(stereotypesWithThisProperty.size() == 1) {
					return el.getValue(stereotypesWithThisProperty.get(0), prop.getName());
				} else if(stereotypesWithThisProperty.size() > 1) {
					return "Several stereotypes with this feature are applied -> not yet managed";
				}
			}
		}
		return NOT_AVALAIBLE;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.solver.CellFeatureValueManager#setValue(org.eclipse.emf.edit.domain.EditingDomain, java.lang.Object,
	 *      java.lang.Object, java.lang.Object)
	 * 
	 * @param domain
	 * @param obj1
	 * @param obj2
	 * @param newValue
	 */
	@Override
	public void setValue(EditingDomain domain, Object obj1, Object obj2, Object newValue) {
		if(super.handles(obj1, obj2)) {
			super.setValue(domain, obj1, obj2, newValue);
		} else {
			final Command cmd = getSetValueCommand(domain, obj1, obj2, newValue);
			if(cmd != null) {
				domain.getCommandStack().execute(cmd);
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.solver.CellFeatureValueManager#getSetValueCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object)
	 * 
	 * @param domain
	 * @param obj1
	 * @param obj2
	 * @param newValue
	 * @return
	 */
	public Command getSetValueCommand(EditingDomain domain, Object obj1, Object obj2, Object newValue) {
		if(super.handles(obj1, obj2)) {
			return super.getSetValueCommand(domain, obj1, obj2, newValue);
		} else {
			final List<Object> umlObjects = organizeUMLObject(obj1, obj2);
			final Element el = (Element)umlObjects.get(0);
			final String id = (String)umlObjects.get(1);
			final Property prop = UMLTableUtils.getRealStereotypeProperty(el, id);
			List<Stereotype> stereotypes = UMLTableUtils.getAppliedSteretoypesWithThisProperty(el, id);
			if(prop != null) {
				if(stereotypes.size() == 1) {
					final EObject stereotypeApplication = el.getStereotypeApplication(stereotypes.get(0));
					final EStructuralFeature steApFeature = stereotypeApplication.eClass().getEStructuralFeature(prop.getName());
					final AbstractEditCommandRequest request = new SetRequest((TransactionalEditingDomain)domain, stereotypeApplication, steApFeature, newValue);
					final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(stereotypeApplication);
					final ICommand editCommand = provider.getEditCommand(request);
					//					boolean canExecute = editCommand.canExecute();
					return new GMFtoEMFCommandWrapper(editCommand);
				} else {
					//FIXME : not yet managed
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.solver.CellFeatureValueManager#isCellEditable(java.lang.Object, java.lang.Object)
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 *         if the edited feature is an EMF feature -> see {@link CellFeatureValueManager} else if the edited feature is a stereotype property :
	 *         return true if the stereotype is applied on the edited element AND if only one stereotype with this property is applied on the element
	 */
	@Override
	public boolean isCellEditable(Object obj1, Object obj2) {
		if(super.handles(obj1, obj2)) {
			return super.isCellEditable(obj1, obj2);
		} else {
			final List<Object> umlObjects = organizeUMLObject(obj1, obj2);
			final Element el = (Element)umlObjects.get(0);
			final String id = (String)umlObjects.get(1);
			switch(UMLTableUtils.getAppliedSteretoypesWithThisProperty(el, id).size()) {
			case 1:
				final Property prop = UMLTableUtils.getRealStereotypeProperty(el, id);
				return prop.isDerived();
			}
		}
		return false;
	}
}
