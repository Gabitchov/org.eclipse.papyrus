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

package org.eclipse.papyrus.editor;

import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;


/**
 * Papyrus main MultiEditor.
 * This class add GMF adaptation dedicated to Papyrus.
 * TODO : move GMF dependencies into this plugin.
 * 
 * @author dumoulin
 * 
 */
public class PapyrusMultiDiagramEditor extends CoreMultiDiagramEditor {

	/**
	 * The Papyrus Editor ID
	 */
	public static final String EDITOR_ID = "org.eclipse.papyrus.infra.core.papyrusEditor"; //$NON-NLS-1$
}
