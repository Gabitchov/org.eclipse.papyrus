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
package org.eclipse.papyrus.uml.table.efacet.common.editor;

import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.table.efacet.common.editor.AbstractSynchronizedTableEditor;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.uml.table.efacet.common.messages.Messages;
import org.eclipse.uml2.uml.Element;


public abstract class AbstractUMLTableEFacetEditor extends AbstractSynchronizedTableEditor {

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public AbstractUMLTableEFacetEditor(final ServicesRegistry servicesRegistry, final PapyrusTable rawModel) {
		super(servicesRegistry, rawModel);
		if(!(rawModel.getTable().getContext() instanceof Element)) {
			throw new UnsupportedOperationException(NLS.bind(Messages.AbstractUMLTableEFacetEditor_UMLTableCreationErrorMessage, rawModel.getTable().getContext()));
		}
	}

}
