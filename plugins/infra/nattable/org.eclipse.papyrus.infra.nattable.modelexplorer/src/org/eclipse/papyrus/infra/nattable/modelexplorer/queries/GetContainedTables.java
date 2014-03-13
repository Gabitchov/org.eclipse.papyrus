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

//TODO: EMF-FACET update query
/** Get the collection of all contained tables */
public class GetContainedTables {/*
	extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Collection<Table>> {


	@Override
	public Collection<Table> evaluate(final EObject context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		List<Table> result = new ArrayList<Table>();
		Iterator<EObject> roots = NavigatorUtils.getNotationRoots(context);
		if(roots == null) {
			return result;
		}

		while(roots.hasNext()) {
			EObject root = roots.next();
			if(root instanceof Table) {
				if(EcoreUtil.equals(((Table)root).getContext(), context)) {
					result.add((Table)root);
				}
			}
		}
		return result;
	}**/
}
