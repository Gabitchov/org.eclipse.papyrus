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
package org.eclipse.papyrus.table.common.editor;

import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.papyrus.core.services.ServicesRegistry;


/**
 * A TextEditor that can be used as Tab of a sashes window.
 * 
 * @author dumoulin
 */
public class DefaultNattableEditor extends AbstractNattableEditor {


	/** the type of the editor */
	public static final String EDITOR_TYPE = "PapyrusDefaultTable";

	/** the default name for this table */
	public static final String DEFAULT_NAME = "DefaultTable";

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public DefaultNattableEditor(ServicesRegistry servicesRegistry, TableInstance rawModel) {
		super(servicesRegistry, rawModel);
	}

}
