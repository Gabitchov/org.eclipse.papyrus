/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.sysml.nattable.requirement.editor;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.uml.nattable.common.editor.AbstractUMLNattableEditor;

public class SysMLRequirementNattableEditor extends AbstractUMLNattableEditor {

	/** the type of the editor */
	public static final String EDITOR_TYPE = "PapyrusSysMLRequirementNattable"; //$NON-NLS-1$

	/** the default name for this table */
	public static final String DEFAULT_NAME = "SysMLRequirementTable"; //$NON-NLS-1$

	public SysMLRequirementNattableEditor(final ServicesRegistry servicesRegistry, final Table rawModel) {
		super(servicesRegistry, rawModel);
	}



}
