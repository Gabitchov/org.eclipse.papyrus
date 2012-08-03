package org.eclipse.papyrus.infra.table.efacet.queries;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;

/** Return the name for the table */
public class GetTableName implements IJavaModelQuery<PapyrusTable, String> {

	public String evaluate(final PapyrusTable context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		return context.getName() + " (new)";
	}
}
