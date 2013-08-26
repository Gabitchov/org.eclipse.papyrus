/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  (with the help of examining table support from Vincent Lorenzo)
 *
 *****************************************************************************/
package org.eclipse.papyrus.texteditor.modelexplorer.queries;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel;
import org.eclipse.papyrus.views.modelexplorer.queries.AbstractGetEditorIconQuery;

/** Return the path to the icon of the corresponding table */
public class GetTextEditorIcon extends AbstractGetEditorIconQuery implements IJavaModelQuery<TextEditorModel, String> {

	/**
	 * {@inheritDoc}
	 */
	public String evaluate(final TextEditorModel textInstance, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		return "/" + getEditorRegistry(textInstance).getEditorURLIcon(textInstance); //$NON-NLS-1$
	}
}
