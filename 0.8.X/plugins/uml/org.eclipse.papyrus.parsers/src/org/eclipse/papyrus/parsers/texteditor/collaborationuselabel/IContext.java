/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for CollaborationUse
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.collaborationuselabel;

/**
 * Definitions for the parsing context.
 */
public abstract interface IContext {

	/** Default position */
	public static final int DEFAULT = 0;

	/** Parsing Visibility */
	public static final int VISIBILITY = 1;

	/** Parsing Name */
	public static final int NAME = 2;

	/** Parsing before CollaborationUse type */
	public static final int AFTER_COLON = 3;

	/** Parsing CollaborationUse type */
	public static final int COLLABORATION_USE_TYPE = 4;

}
