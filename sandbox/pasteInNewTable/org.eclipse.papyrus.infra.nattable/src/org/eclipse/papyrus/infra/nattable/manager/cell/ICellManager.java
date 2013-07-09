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
package org.eclipse.papyrus.infra.nattable.manager.cell;

import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.infra.emf.utils.EMFStringValueConverter;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

/**
 * The interface to implements for a cell manager
 * 
 * @author Vincent Lorenzo
 * 
 */
public interface ICellManager {

	/**
	 * The string displayed for Not_AVAILABLE
	 */
	public static final String NOT_AVALAIBLE = Messages.ICellManager_NotAvailable;


	public boolean handles(final Object obj1, final Object obj2);//FIXME : add the table as parameter

	public boolean handlesAxisElement(final Object obj);

	/**
	 * 
	 * @param axisElement1
	 *        one of the axis
	 * @param axisElement2
	 *        the other axis
	 * @return
	 *         the value of the cell or {@value #NOT_AVALAIBLE} if the cell is meaningless for the couple of parameters
	 * 
	 *         THIS METHOD MUST NOT BE USED IN REPLACEMENT OF A SPECIFIC LABEL PROVIDER
	 */
	public Object getValue(final Object axisElement1, final Object axisElement2);

	/**
	 * Set the newValue to the intersection of the 2 objects
	 * 
	 * @param domain
	 *        the editing domain
	 * @param obj1
	 *        the first object
	 * @param obj2
	 *        the second object
	 * @param newValue
	 *        the new value
	 */
	public void setValue(final EditingDomain domain, final Object obj1, final Object obj2, final Object newValue);


	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param tableContext
	 *        TODO
	 * @param obj1
	 *        the first object
	 * @param obj2
	 *        the second object
	 * @param newValue
	 *        the newValue, represented by a String
	 * @param valueSolver
	 *        the solver used to resolve values
	 */
	//FIXME : remove EMF dependency for the solver!
	//FIXME : remove tableContext
	public ICommand getSetStringValueCommand(final EditingDomain domain, final Table table, EObject tableContext, final Object obj1, final Object obj2, final String newValue, final EMFStringValueConverter valueSolver);

	/**
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 *         <code>true</code> if the intersection of the 2 objects is editable
	 */
	public boolean isCellEditable(final Object obj1, final Object obj2);

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param obj1
	 *        the first object
	 * @param obj2
	 *        the second object
	 * @param newValue
	 *        the new value to set to the intersection of these 2 objects
	 * @return
	 *         the command to set the value
	 */
	public Command getSetValueCommand(final EditingDomain domain, final Object obj1, final Object obj2, final Object newValue);
}
