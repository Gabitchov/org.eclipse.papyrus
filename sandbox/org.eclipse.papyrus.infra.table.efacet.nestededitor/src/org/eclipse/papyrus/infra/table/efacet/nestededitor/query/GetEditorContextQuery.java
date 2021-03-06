package org.eclipse.papyrus.infra.table.efacet.nestededitor.query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;


public class GetEditorContextQuery extends AbstractNestedEditorQuery<EObject> {

	private static List<String> possibleContextFieldName = null;

	public EObject evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		EObject context = null;
		if(source instanceof PapyrusTable) {
			context = ((PapyrusTable)source).getTable().getContext();
		} else {
			if(possibleContextFieldName == null) {
				initContextFieldName();
			}
			Iterator<String> iter = possibleContextFieldName.iterator();

			while(iter.hasNext() && context == null) {
				final String currentName = iter.next();
				final EStructuralFeature feature = source.eClass().getEStructuralFeature(currentName);
				if(feature != null) {
					context = (EObject)source.eGet(feature);
				}

			}
		}
		return context;
	}

	private static final void initContextFieldName() {
		possibleContextFieldName = new ArrayList<String>();
		possibleContextFieldName.add("context");
		possibleContextFieldName.add("element");
	}

}
