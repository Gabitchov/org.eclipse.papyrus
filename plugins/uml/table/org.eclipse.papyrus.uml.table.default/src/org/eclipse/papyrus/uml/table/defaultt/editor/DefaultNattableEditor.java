/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.defaultt.editor;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.uml.table.common.editor.AbstractUMLTableEditor;


/**
 * A TextEditor that can be used as Tab of a sashes window.
 * 
 * @author dumoulin
 */
public class DefaultNattableEditor extends AbstractUMLTableEditor {



	/** the type of the editor */
	public static final String EDITOR_TYPE = "PapyrusDefaultTable"; //$NON-NLS-1$

	/** the default name for this table */
	public static final String DEFAULT_NAME = "DefaultTable"; //$NON-NLS-1$

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public DefaultNattableEditor(ServicesRegistry servicesRegistry, PapyrusTableInstance rawModel) {
		super(servicesRegistry, rawModel);

	}



}
