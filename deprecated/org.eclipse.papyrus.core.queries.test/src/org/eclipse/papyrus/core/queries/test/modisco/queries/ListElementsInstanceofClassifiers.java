package org.eclipse.papyrus.core.queries.test.modisco.queries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;

/** test - list the elements given as parameters that are instanceof Classifiers */
public class ListElementsInstanceofClassifiers implements IJavaModelQuery<EObject, Collection<Classifier>> {

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public Collection<Classifier> evaluate(final EObject context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		// retrieve the list of elements 
		List<NamedElement> elements = (List<NamedElement>)parameterValues.getValueByParameterName("elementList");

		List<Classifier> classifiers = new ArrayList<Classifier>();
		for(NamedElement element : elements) {
			if(element instanceof Classifier) {
				classifiers.add((Classifier)element);
			}
		}
		return classifiers;
	}
}
