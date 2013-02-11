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
package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;


public class CompositeAxisManager extends AbstractAxisManager {

	/**
	 * the id of this manager
	 */
	public static final String MANAGER_ID = "org.eclipse.papyrus.infra.nattable.common.composite.axis.manager";

	/**
	 * the managed managers
	 */
	protected List<IAxisManager> managers;

	/**
	 * Setter for {@link #managers}
	 *
	 * @param managers
	 *        the managers managed by this one
	 */
	public void setAxisManager(final List<IAxisManager> managers) {
		this.managers = managers;
		updateAxisContents();
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#dispose()
	 *
	 */
	@Override
	public void dispose() {
		for(final IAxisManager current : this.managers) {
			current.dispose();
		}
		this.managers.clear();
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#getManagerId()
	 *
	 * @return
	 */
	@Override
	public String getManagerId() {
		return MANAGER_ID;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#canBeUsedHorizontally()
	 *
	 * @return
	 */
	@Override
	public boolean canBeUsedHorizontally() {
		boolean answer = true;
		final Iterator<IAxisManager> iter = this.managers.iterator();
		while(iter.hasNext() && answer) {
			answer = iter.next().canBeUsedHorizontally();
		}
		return answer;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#canBeUsedVertically()
	 *
	 * @return
	 */
	@Override
	public boolean canBeUsedVertically() {
		boolean answer = true;
		final Iterator<IAxisManager> iter = this.managers.iterator();
		while(iter.hasNext() && answer) {
			answer = iter.next().canBeUsedVertically();
		}
		return answer;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#getAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 *
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		final CompoundCommand cmd = new CompoundCommand("Add Axis Command");
		for(final IAxisManager current : this.managers) {
			final Command tmp = current.getAddAxisCommand(domain, objectToAdd);
			if(tmp != null) {
				cmd.append(tmp);
			}
		}
		if(cmd.isEmpty()) {
			return null;
		}
		return cmd;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#getComplementaryAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 *
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		final CompoundCommand cmd = new CompoundCommand("Add Axis Command");
		for(final IAxisManager current : this.managers) {
			final Command tmp = current.getComplementaryAddAxisCommand(domain, objectToAdd);
			if(tmp != null) {
				cmd.append(tmp);
			}
		}
		if(cmd.isEmpty()) {
			return null;
		}
		return cmd;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#updateAxisContents()
	 *
	 */
	@Override
	public synchronized void updateAxisContents() {
		if(this.managers != null) {
			for(final IAxisManager current : this.managers) {
				current.updateAxisContents();
			}
		}
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#isAllowedContents(java.lang.Object)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public boolean isAllowedContents(Object object) {
		for(final IAxisManager current : this.managers) {
			if(current.isAllowedContents(object)) {
				return true;
			}
		}
		return false;
	}
}
