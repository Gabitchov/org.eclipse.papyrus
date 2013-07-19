/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.nattable.manager.cell;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.nattable.messages.Messages;
import org.eclipse.papyrus.uml.nattable.utils.Constants;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The cell manager used for Property of stereotypes
 * 
 * @author vl222926
 * 
 */
public class StereotypePropertyCellManager extends UMLFeatureCellManager {

	/**
	 * the error message
	 */
	public static final String SEVERAL_STEREOTYPES_WITH_THIS_FEATURE_ARE_APPLIED = Messages.StereotypePropertyCellManager_SeveralStereotypesWithThisFeatureAreApplied;

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.cell.UMLFeatureCellManager#handles(java.lang.Object, java.lang.Object)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean handles(final Object columnElement, final Object rowElement) {
		return organizeAndResolvedObjects(columnElement, rowElement) != null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#doGetValue(java.lang.Object, java.lang.Object,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @param tableManager
	 * @return
	 */
	@Override
	protected Object doGetValue(final Object columnElement, final Object rowElement, final INattableModelManager tableManager) {
		final List<Object> umlObjects = organizeAndResolvedObjects(columnElement, rowElement);
		if(umlObjects.size() == 2) {
			final Element el = (Element)umlObjects.get(0);
			final String id = (String)umlObjects.get(1);
			final Property prop = UMLTableUtils.getRealStereotypeProperty(el, id);
			final List<Stereotype> stereotypesWithThisProperty = UMLTableUtils.getAppliedSteretoypesWithThisProperty(el, id);
			if(stereotypesWithThisProperty.size() == 1) {
				return el.getValue(stereotypesWithThisProperty.get(0), prop.getName());
			} else if(stereotypesWithThisProperty.size() > 1) {
				return SEVERAL_STEREOTYPES_WITH_THIS_FEATURE_ARE_APPLIED;
			}
		}
		return NOT_AVALAIBLE;
	}

	/**
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 *         a list with 2 elements : the first one is the Element and the second one the string representing the property of stereotypes
	 */
	@Override
	protected List<Object> organizeAndResolvedObjects(final Object columnElement, final Object rowElement) {
		List<Object> objects = null;
		final Object column = AxisUtils.getRepresentedElement(columnElement);
		final Object row = AxisUtils.getRepresentedElement(rowElement);
		if(column instanceof String && ((String)column).startsWith(Constants.PROPERTY_OF_STEREOTYPE_PREFIX) && row instanceof Element) {
			objects = new ArrayList<Object>();
			objects.add(row);
			objects.add(column);
		}
		if(row instanceof String && ((String)row).startsWith(Constants.PROPERTY_OF_STEREOTYPE_PREFIX) && column instanceof Element) {
			objects = new ArrayList<Object>();
			objects.add(column);
			objects.add(row);
		}
		return objects;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.cell.UMLFeatureCellManager#isCellEditable(java.lang.Object, java.lang.Object)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean isCellEditable(final Object columnElement, final Object rowElement) {
		final List<Object> umlObjects = organizeAndResolvedObjects(columnElement, rowElement);
		final Element el = (Element)umlObjects.get(0);
		final String id = (String)umlObjects.get(1);
		switch(UMLTableUtils.getAppliedSteretoypesWithThisProperty(el, id).size()) {
		case 1:
			final Property prop = UMLTableUtils.getRealStereotypeProperty(el, id);
			return !prop.isDerived() && !prop.isReadOnly();
		default:
			return false;
		}

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#getSetValueCommand(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object, org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 * 
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param tableManager
	 * @return
	 */
	@Override
	public Command getSetValueCommand(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final Object newValue, final INattableModelManager tableManager) {
		final List<Object> umlObjects = organizeAndResolvedObjects(columnElement, rowElement);
		final Element el = (Element)umlObjects.get(0);
		final String id = (String)umlObjects.get(1);
		final Property prop = UMLTableUtils.getRealStereotypeProperty(el, id);
		final List<Stereotype> stereotypes = UMLTableUtils.getAppliedSteretoypesWithThisProperty(el, id);
		if(prop != null) {
			if(stereotypes.size() == 1) {
				final EObject stereotypeApplication = el.getStereotypeApplication(stereotypes.get(0));
				final EStructuralFeature steApFeature = stereotypeApplication.eClass().getEStructuralFeature(prop.getName());
				final AbstractEditCommandRequest request = new SetRequest(domain, stereotypeApplication, steApFeature, newValue);
				final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(stereotypeApplication);
				final ICommand editCommand = provider.getEditCommand(request);
				return new GMFtoEMFCommandWrapper(editCommand);
			} else {
				//FIXME : not yet managed
			}
		}
		return null;
	}

}
