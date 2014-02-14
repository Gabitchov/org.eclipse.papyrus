/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.modelexplorer.queries;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
//TODO: EMF-FACET update query
public class IsTableContainer {/*extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Boolean> {
*/
	/**
	 * Return true if the element is a Diagram Container
	 */
	/*@Override
	public Boolean evaluate(final EObject context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Iterator<EObject> roots = NavigatorUtils.getNotationRoots(context);
		if(roots == null) {
			return false;
		}
		while(roots.hasNext()) {
			EObject root = roots.next();
			if(root instanceof Table) {
				if(EcoreUtil.equals(((Table)root).getContext(), context)) {
					return true;
				}
			}
		}
		return false;
	}*/
}
