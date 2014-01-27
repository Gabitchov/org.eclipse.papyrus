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
package org.eclipse.papyrus.uml.table.common.editor;

import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.table.common.editor.AbstractNattableEditor;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.uml.table.common.messages.Messages;
import org.eclipse.uml2.uml.Element;


public abstract class AbstractUMLTableEditor extends AbstractNattableEditor {

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public AbstractUMLTableEditor(final ServicesRegistry servicesRegistry, final PapyrusTableInstance rawModel) {
		super(servicesRegistry, rawModel);
		if(!(rawModel.getTable().getContext() instanceof Element)) {
			throw new UnsupportedOperationException(NLS.bind(Messages.AbstractUMLTableEFacetEditor_UMLTableCreationErrorMessage, rawModel.getTable().getContext()));
		}
	}

}
