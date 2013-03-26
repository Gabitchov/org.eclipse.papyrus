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
package org.eclipse.papyrus.infra.nattable.manager.table.axis;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.widgets.providers.CompoundFilteredRestrictedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;


public class CompositeAxisManager extends AbstractAxisManager {

	/**
	 * the id of this manager
	 */
	public static final String MANAGER_ID = "org.eclipse.papyrus.infra.nattable.composite.axis.manager"; //$NON-NLS-1$

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
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.axis.AbstractAxisManager#dispose()
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.axis.AbstractAxisManager#getManagerId()
	 * 
	 * @return
	 */
	@Override
	public String getManagerId() {
		return MANAGER_ID;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.axis.AbstractAxisManager#canBeUsedAsRowManager()
	 * 
	 * @return
	 */
	@Override
	public boolean canBeUsedAsRowManager() {
		boolean answer = true;
		final Iterator<IAxisManager> iter = this.managers.iterator();
		while(iter.hasNext() && answer) {
			answer = iter.next().canBeUsedAsRowManager();
		}
		return answer;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.axis.AbstractAxisManager#canBeUsedAsColumnManager()
	 * 
	 * @return
	 */
	@Override
	public boolean canBeUsedAsColumnManager() {
		boolean answer = true;
		final Iterator<IAxisManager> iter = this.managers.iterator();
		while(iter.hasNext() && answer) {
			answer = iter.next().canBeUsedAsColumnManager();
		}
		return answer;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.axis.AbstractAxisManager#getAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		final CompoundCommand cmd = new CompoundCommand(Messages.CompositeAxisManager_AddAxisCommand);
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.axis.AbstractAxisManager#getComplementaryAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		final CompoundCommand cmd = new CompoundCommand(Messages.CompositeAxisManager_AddAxisCommand);
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.axis.AbstractAxisManager#updateAxisContents()
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.axis.AbstractAxisManager#isAllowedContents(java.lang.Object)
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

	@Override
	public boolean canReoderElements() {
		for(final IAxisManager current : this.managers) {
			if(!current.canReoderElements()) {
				return false;
			}
		}
		return true;
	}

	public void sortAxisByName(boolean inverted, final IConfigRegistry configRegistry) {
		super.sortAxisByName(inverted, configRegistry);
	}

	@Override
	public IRestrictedContentProvider createDestroyColumnsContentProvider(boolean isRestricted) {

		CompoundFilteredRestrictedContentProvider compoundContentProvider = new CompoundFilteredRestrictedContentProvider();
		for(final IAxisManager current : managers) {
			IRestrictedContentProvider contentProvider = current.createDestroyColumnsContentProvider(isRestricted);
			compoundContentProvider.add(contentProvider);
		}
		return compoundContentProvider;
	}

	@Override
	public Command getDestroyAxisCommand(EditingDomain domain, Collection<Object> objectToDestroy) {
		final CompoundCommand cmd = new CompoundCommand(Messages.CompositeAxisManager_DestroyAxisCommand);
		for(final IAxisManager current : this.managers) {
			final Command tmp = current.getDestroyAxisCommand(domain, objectToDestroy);
			if(tmp != null) {
				cmd.append(tmp);
			}
		}
		if(cmd.isEmpty()) {
			return null;
		}
		return cmd;
	}

	@Override
	public Collection<Object> getAllExistingAxis() {
		Set<Object> allExistingAxis = new HashSet<Object>();
		for(IAxisManager manager : managers) {
			Collection<Object> managerPossibleElements = manager.getAllExistingAxis();
			if(managerPossibleElements != null) {

				allExistingAxis.addAll(managerPossibleElements);
			}
		}
		return allExistingAxis;
	}
}
