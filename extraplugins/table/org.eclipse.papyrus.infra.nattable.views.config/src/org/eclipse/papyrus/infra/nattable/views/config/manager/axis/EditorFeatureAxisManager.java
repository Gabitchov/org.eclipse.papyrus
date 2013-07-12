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
package org.eclipse.papyrus.infra.nattable.views.config.manager.axis;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager;

/**
 * The feature axis content provider for the ModelViews table
 * 
 * @author Vincent Lorenzo
 * 
 */
public class EditorFeatureAxisManager extends AbstractAxisManager {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.ISubAxisManager#isDynamic()
	 * 
	 * @return
	 */
	public boolean isDynamic() {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#isSlave()
	 * 
	 * @return
	 */
	public boolean isSlave() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canEditAxisHeader()
	 * 
	 * @return
	 */
	@Override
	public boolean canEditAxisHeader() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canDestroyAxisElement(java.lang.Integer)
	 * 
	 * @param axisPosition
	 * @return
	 */
	@Override
	public boolean canDestroyAxisElement(Integer axisPosition) {
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
	@Override
	public Command getDestroyAxisElementCommand(EditingDomain domain, Integer axisPosition) {
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	public boolean canBeSavedAsConfig() {
		return true;
	}
}
