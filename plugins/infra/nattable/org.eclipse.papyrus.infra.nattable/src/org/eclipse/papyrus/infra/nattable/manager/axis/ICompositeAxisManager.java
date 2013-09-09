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
package org.eclipse.papyrus.infra.nattable.manager.axis;

import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.ui.NatEventData;


/**
 * 
 * This interfaces provides the methods for the CompositeAxisManager
 * 
 */
public interface ICompositeAxisManager extends IAxisManager {

	/**
	 * 
	 * @param subAxisManager
	 *        the managed axis manager
	 */
	public void setSubAxisManager(final List<IAxisManager> subAxisManager);

	/**
	 * update the contents of the list representing the managed axis
	 */
	public void updateAxisContents();

	/**
	 * 
	 * @param alpabeticOrder
	 *        <code>true</code> if we sort the axis by alphabetic order, <code>false</code> if not
	 * @param iConfigRegistry
	 *        the config registry used to find the label provider
	 */
	public void sortAxisByName(final boolean alpabeticOrder, IConfigRegistry iConfigRegistry);

	public boolean canEditAxisHeader(NatEventData evaluationContext);

	/**
	 * 
	 * @return
	 *         <code>true</code> if the axis managed by this manager are sorted
	 */
	public boolean isInSortedState();

	/**
	 * 
	 * @param comp
	 *        the comparator to use to sort the axis. this comparator may be null
	 */
	public void setAxisComparator(final Comparator<Object> comp);

	/**
	 * 
	 * @param newOrder
	 *        the new order for the objects : the objects can be IAxis or objects, or objects represented by IAxis in the model
	 * @return
	 *         the command to use to set this new order
	 */
	public Command getSetNewAxisOrderCommand(final List<Object> newOrder);


}
