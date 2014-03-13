/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.core.strategy;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;


/**
 * The Class AbstractLockingStrategy.
 * This only give a default implementation to {@link ILockingStrategy#applyOn(Collection)}
 */
public abstract class AbstractLockingStrategy implements ILockingStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.core.strategy.ILockingStrategy#applyOn(java.util.Collection)
	 */
	@Override
	public boolean applyOn(Collection<EObject> target) {
		return !target.isEmpty();
	}

}
