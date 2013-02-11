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
package org.eclipse.papyrus.uml.nattable.generic.editor;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.nattable.common.editor.AbstractEMFNattableEditor;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

public class GenericUMLNattableEditor extends AbstractEMFNattableEditor {

	/** the type of the editor */
	public static final String EDITOR_TYPE = "PapyruGenericNattable"; //$NON-NLS-1$

	/** the default name for this table */
	public static final String DEFAULT_NAME = "GenericUMLTable"; //$NON-NLS-1$

	public GenericUMLNattableEditor(ServicesRegistry servicesRegistry, final Table rawModel) {
		super(servicesRegistry, rawModel);
	}



}
