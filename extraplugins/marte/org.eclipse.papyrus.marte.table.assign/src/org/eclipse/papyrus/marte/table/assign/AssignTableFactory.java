/*****************************************************************************
 * Copyright (c) 2012 ATOS
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Mélois (ATOS) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.table.assign;

import org.eclipse.papyrus.marte.table.assign.editor.AssignTableEditor;
import org.eclipse.papyrus.table.common.factory.AbstractNattableEditorFactory;

/**
 * the factory for the AssignTable
 */
public class AssignTableFactory extends AbstractNattableEditorFactory {

	public AssignTableFactory() {
		super(AssignTableEditor.class, AssignTableEditor.EDITOR_TYPE);
	}

}
