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
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;


/**
 * The Interface ILockingStrategy.
 * A locking strategy is used to build a set of business object using the defined strategy
 */
public interface ILockingStrategy {

	/**
	 * Get the business object define by this strategy
	 * 
	 * @param eOjbect
	 *        the e ojbect
	 * @return the object to lock
	 */
	Set<IExtendedURI> getBusinessObject(Collection<EObject> eOjbect);

	/**
	 * Return true if this strategy apply on the selected objects
	 * 
	 * @param target
	 *        the target
	 * @return true, if successful
	 */
	public boolean applyOn(Collection<EObject> target);

	/**
	 * The Class Descriptor.
	 */
	public class Descriptor {

		/** The strategy. */
		private ILockingStrategy strategy;

		/** The name. */
		private String name;


		/**
		 * Gets the strategy.
		 * 
		 * @return the strategy
		 */
		public ILockingStrategy getStrategy() {
			return strategy;
		}


		/**
		 * Gets the name.
		 * 
		 * @return the name
		 */
		public String getName() {
			return name;
		}


		/**
		 * Instantiates a new descriptor.
		 * 
		 * @param strategy
		 *        the strategy
		 * @param name
		 *        the name
		 */
		public Descriptor(ILockingStrategy strategy, String name) {
			super();
			this.strategy = strategy;
			this.name = name;
		}





	}

}
