/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.table.modelexplorer.queries;

import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistryExtended;
import org.eclipse.papyrus.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.queries.AbstractGetEditorIconQuery;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.gmf.runtime.notation.Diagram;

/** Return the path to the icon of the corresponding table */
public class GetTableIcon extends AbstractGetEditorIconQuery implements IJavaModelQuery<PapyrusTableInstance, String> {

	/**
	 * {@inheritDoc}
	 */
	public String evaluate(final PapyrusTableInstance context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		return "/" + ((IPageIconsRegistryExtended)getEditorRegistry()).getEditorURLIcon(context); //$NON-NLS-1$
	}
}
