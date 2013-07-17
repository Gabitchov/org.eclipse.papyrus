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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.validator;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

/**
 * 
 * Interface to implement to have a specific content validator. It is used to select only the elements that will be used to find patterns.
 * 
 */
public interface IParticipantValidator {

	/**
	 * Return the elements that will participate (i.e. the participants) in the search query based on a list of types
	 * 
	 * @param root
	 *        all the children and itself will be check against the list of types
	 * @param participantsTypes
	 *        the types of the wanted participants
	 * @return
	 *         the elements that are of wanted types
	 */
	public Collection<? extends Object> getParticipants(EObject root, Object[] participantsTypes);
}
