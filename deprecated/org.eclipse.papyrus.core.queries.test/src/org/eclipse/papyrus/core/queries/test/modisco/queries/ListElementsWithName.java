package org.eclipse.papyrus.core.queries.test.modisco.queries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/** test - return a list of named elements for whicv name contains basic */
public class ListElementsWithName implements IJavaModelQuery<Package, Collection<NamedElement>> {

	/**
	 * {@inheritDoc}
	 */
	public Collection<NamedElement> evaluate(final Package context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {

		String containedString = (String)parameterValues.getValueByParameterName("containedString");
		
		Collection<Object> namedElements = EcoreUtil.getObjectsByType(context.allOwnedElements(), UMLPackage.eINSTANCE.getNamedElement());
		List<NamedElement> elements = new ArrayList<NamedElement>();
		

		// add the element  itself if required
		if(context instanceof NamedElement) {
			String name = ((NamedElement)context).getName();
			if(name != null && name.indexOf(containedString) != -1) {
				elements.add((NamedElement)context);
			}
		}

		// check all contained elements
		for(Object namedElement : namedElements) {
			String name  =  ((NamedElement)namedElement).getName();
			if(name != null && name.indexOf(containedString) != -1) {
				elements.add((NamedElement)namedElement);
			}
		}
		return elements;
	}
}
