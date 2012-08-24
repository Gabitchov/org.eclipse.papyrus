/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.nestededitor.editor;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.table.efacet.common.editor.AbstractSynchronizedTableEditor;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;


public class NestedEditorTableEditor extends AbstractSynchronizedTableEditor {

	/** the type of the editor */
	public static final String EDITOR_TYPE = "PapyrusNestedEditorTable"; //$NON-NLS-1$

	/** the default name for this table */
	public static final String DEFAULT_NAME = "NestedEditorTable"; //$NON-NLS-1$

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public NestedEditorTableEditor(final ServicesRegistry servicesRegistry, final PapyrusTable rawModel) {
		super(servicesRegistry, rawModel);
	}


}
