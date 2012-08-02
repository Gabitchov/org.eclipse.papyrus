package org.eclipse.papyrus.infra.table.efacet.queries;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TablePackage;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;

import com.google.common.base.Predicate;

/** Returns true if the element contains a Table */
//FIXME this query is declared using Element in the querySet -> change into EObject when the EMF-Facet bug will be corrected 365744
//FIXME : remove the dependencies on the ModelExplorer
public class IsTableEFacetContainer extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Boolean> {

	/**
	 * {@inheritDoc}
	 */
	public Boolean evaluate(final EObject context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		final Predicate<Setting> p = new Predicate<Setting>() {

			public boolean apply(final Setting arg0) {
				return arg0.getEObject() instanceof Table && arg0.getEStructuralFeature() == TablePackage.Literals.TABLE__CONTEXT;
			}
		};
		return NavigatorUtils.find(context, p);
	}
}
