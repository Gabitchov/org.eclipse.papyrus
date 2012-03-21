/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.customization.query;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.customization.editor.actions.ToggleDataContextAction;

/**
 * A Query to test if the DataContextElements should be displayed in the UIEditor
 * 
 * @author Camille Letavernier
 */
public class ShowContextQuery implements IJavaModelQuery<Context, Boolean> {

	public Boolean evaluate(Context context, ParameterValueList parameters) throws ModelQueryExecutionException {
		Boolean result = ToggleDataContextAction.showDataContext;
		return result;
	}

}