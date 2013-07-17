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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.table.cell;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager;
import org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.FeatureIdAxis;
import org.eclipse.papyrus.uml.tools.commands.SetMultiplicityCommand;
import org.eclipse.papyrus.uml.tools.util.MultiplicityParser;
import org.eclipse.papyrus.views.properties.table.axis.DerivedUMLPropertiesAxisManager;
import org.eclipse.uml2.uml.MultiplicityElement;


public class DerivedUMLPropertiesCellManager extends AbstractCellManager implements ICellManager {

	public final static String CELL_MANAGER_ID = "org.eclipse.papyrus.uml.nattable.derived.features.cell.manager"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	public boolean handles(Object columnElement, Object rowElement) {
		return getMultiplicityElement(columnElement, rowElement) != null && getMultiplicityHandler(columnElement, rowElement) != null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean handlesAxisElement(Object obj) {
		return DerivedUMLPropertiesAxisManager.MULTIPLICITY.equals(obj);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object doGetValue(Object columnElement, Object rowElement, INattableModelManager tableManager) {
		MultiplicityElement element = getMultiplicityElement(columnElement, rowElement);
		if(element == null) {
			return null;
		}

		return getValue(element);
	}

	protected Object getValue(MultiplicityElement multiplicityElement) {
		int lower = multiplicityElement.getLower(), upper = multiplicityElement.getUpper();
		return MultiplicityParser.getMultiplicity(lower, upper);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isCellEditable(Object columnElement, Object rowElement) {
		return getMultiplicityElement(columnElement, rowElement) != null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Command getSetValueCommand(EditingDomain domain, Object columnElement, Object rowElemenet, Object newValue) {

		MultiplicityElement element = getMultiplicityElement(columnElement, rowElemenet);

		if(element == null) {
			return null;
		}

		if(newValue == null || newValue instanceof String) {
			return getSetValueCommand(element, (String)newValue);
		}

		return null;
	}

	protected MultiplicityElement getMultiplicityElement(Object obj1, Object obj2) {
		if(obj1 instanceof MultiplicityElement) {
			return (MultiplicityElement)obj1;
		}
		if(obj2 instanceof MultiplicityElement) {
			return (MultiplicityElement)obj2;
		}

		return null;
	}

	private String getMultiplicityHandler(Object obj1, Object obj2) {
		String featureId = getFeatureId(obj1);
		if(featureId != null) {
			return featureId;
		}

		featureId = getFeatureId(obj2);
		if(featureId != null) {
			return featureId;
		}
		return null;
	}

	private String getFeatureId(Object object) {
		if(object instanceof FeatureIdAxis) {
			FeatureIdAxis idAxis = (FeatureIdAxis)object;
			if(DerivedUMLPropertiesAxisManager.MULTIPLICITY.equals(idAxis.getElement())) {
				return DerivedUMLPropertiesAxisManager.MULTIPLICITY;
			}
		}
		return null;
	}

	protected Command getSetValueCommand(MultiplicityElement element, String newValue) {
		return new SetMultiplicityCommand(element, newValue);
	}

}
