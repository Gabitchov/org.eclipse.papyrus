/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sasheditor.eclipsecopy;

import org.eclipse.ui.IEditorPart;

/**
 * Marker to mark a EditorPart as a MultiPartEditor. Provides methods needed by classes like MultiPageActionBarContributor and MultiPageSelectionProvider.
 */
public interface IMultiPageEditorPart {

	IEditorPart getActiveEditor();

}
