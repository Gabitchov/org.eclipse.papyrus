/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.gmf.editors;

import org.eclipse.papyrus.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.widgets.Composite;


public class XWTAwareFontEditor extends AbstractPropertyEditor {

	private FontEditor editor;

	public XWTAwareFontEditor(Composite parent, int style) {
		editor = new FontEditor(parent, style);
		setEditor(editor);
	}
}
