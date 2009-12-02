/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a> - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigator.internal.ltk;

import org.eclipse.papyrus.core.utils.DiResourceSet;

/**
 * Constants used by participants.
 * 
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 * 
 */
public interface IModelParticipantConstants {

	/** Extensions that are used with the participants. */
	String[] MODEL_EXTENSIONS = { DiResourceSet.DI_FILE_EXTENSION, DiResourceSet.MODEL_FILE_EXTENSION,
			DiResourceSet.NOTATION_FILE_EXTENSION };

}
