/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.core.utils;

/**
 * This interface contains all channels to trace papyrus
 * 
 * @author Patrick Tessier
 */
public interface IDebugChannel {

	/**
	 * constant used to trace the core running
	 */
	public static final String PAPYRUS_CORE = "org.eclipse.papyrus.core/debug/core";

	/**
	 * constant used to trace the loading of extension point
	 */
	public static final String PAPYRUS_EXTENSIONPOINT_LOADING = "org.eclipse.papyrus.core/debug/extensionpoint";

}
