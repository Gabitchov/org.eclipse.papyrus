package org.eclipse.papyrus.infra.table.efacet.queries;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;

/** Return the path to the icon of the corresponding table */
public class GetTableIcon extends AbstractGetEditorIconQuery implements IJavaModelQuery<PapyrusTable, String> {

	/**
	 * {@inheritDoc}
	 */
	public String evaluate(final PapyrusTable context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		return "/" + getEditorRegistry().getEditorURLIcon(context); //$NON-NLS-1$
	}
}
