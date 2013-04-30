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
import org.eclipse.papyrus.uml.tools.commands.SetMultiplicityCommand;
import org.eclipse.papyrus.uml.tools.util.MultiplicityParser;
import org.eclipse.papyrus.views.properties.table.custom.MultiplicityHandler;
import org.eclipse.uml2.uml.MultiplicityElement;


public class DerivedUMLPropertiesCellManager extends AbstractCellManager implements ICellManager {

	public final static String CELL_MANAGER_ID = "org.eclipse.papyrus.uml.nattable.derived.features.cell.manager"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	public boolean handles(Object obj1, Object obj2) {
		return getMultiplicityElement(obj1, obj2) != null && getMultiplicityHandler(obj1, obj2) != null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean handlersAxisElement(Object obj) {
		return obj == MultiplicityHandler.getInstance();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getValue(Object axisElement1, Object axisElement2) {
		MultiplicityElement element = getMultiplicityElement(axisElement1, axisElement2);
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
	public boolean isCellEditable(Object obj1, Object obj2) {
		return getMultiplicityElement(obj1, obj2) != null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Command getSetValueCommand(EditingDomain domain, Object obj1, Object obj2, Object newValue) {

		MultiplicityElement element = getMultiplicityElement(obj1, obj2);

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

	private MultiplicityHandler getMultiplicityHandler(Object obj1, Object obj2) {
		if(obj1 == MultiplicityHandler.getInstance()) {
			return (MultiplicityHandler)obj1;
		}
		if(obj2 == MultiplicityHandler.getInstance()) {
			return (MultiplicityHandler)obj2;
		}

		return null;
	}

	protected Command getSetValueCommand(MultiplicityElement element, String newValue) {
		return new SetMultiplicityCommand(element, newValue);
	}

}
