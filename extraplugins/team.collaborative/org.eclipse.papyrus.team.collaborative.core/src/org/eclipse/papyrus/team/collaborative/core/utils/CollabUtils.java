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
package org.eclipse.papyrus.team.collaborative.core.utils;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.team.collaborative.core.ICollaborativeManager;
import org.eclipse.papyrus.team.collaborative.core.utils.funtions.EObjectToExtendedURI;


/**
 * The Class CollabUtils.
 * Util class for collaborative work
 */
public class CollabUtils {


	/**
	 * Instantiates a new collab utils.
	 */
	CollabUtils() {
	}

	/**
	 * Checks if an {@link EObject} can be used in the collaborative framework.
	 * 
	 * @param input
	 *        the input
	 * @return true, if is collab
	 */
	public static boolean isCollab(EObject input) {
		return ICollaborativeManager.INSTANCE.isCollab(Collections.singleton(EObjectToExtendedURI.getInstance().apply(input)), input.eResource().getResourceSet());
	}



}
