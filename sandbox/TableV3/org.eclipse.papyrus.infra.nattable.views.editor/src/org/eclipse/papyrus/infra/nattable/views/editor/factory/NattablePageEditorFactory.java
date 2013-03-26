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

package org.eclipse.papyrus.infra.nattable.views.editor.factory;

import org.eclipse.papyrus.infra.nattable.common.factory.AbstractNattableEditorFactory;
import org.eclipse.papyrus.infra.nattable.views.editor.NattablePageEditor;




public class NattablePageEditorFactory extends AbstractNattableEditorFactory {


	/**
	 * Constructor.
	 * 
	 * @param diagramClass
	 * @param expectedType
	 */
	public NattablePageEditorFactory() {
		super(NattablePageEditor.class, NattablePageEditor.EDITOR_TYPE);
	}


}
