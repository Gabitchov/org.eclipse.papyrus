/*****************************************************************************
 * Copyright (c) 2011 LIFL & CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/

package org.eclipse.papyrus.table.common.factory;

import org.eclipse.papyrus.table.common.editor.DefaultNattableEditor;


/**
 * @author dumoulin
 * 
 */
public class NattableEditorFactory extends AbstractNattableEditorFactory {


	/**
	 * Constructor.
	 * 
	 * @param diagramClass
	 * @param expectedType
	 */
	public NattableEditorFactory() {
		super(DefaultNattableEditor.class, DefaultNattableEditor.EDITOR_TYPE);
	}
}
