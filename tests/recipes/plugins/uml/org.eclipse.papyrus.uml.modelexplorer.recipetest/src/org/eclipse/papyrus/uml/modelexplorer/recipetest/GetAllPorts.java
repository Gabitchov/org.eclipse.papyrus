package org.eclipse.papyrus.uml.modelexplorer.recipetest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;

/** get all ports from a classifier */
public class GetAllPorts implements IJavaModelQuery<Classifier, Collection<Property>> {
	public Collection<Property> evaluate(final Classifier context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		ArrayList<Property> result= new ArrayList<Property>();
		Iterator<Property> iter= context.getAllAttributes().iterator();
		while(iter.hasNext()){
			Property currentElement= iter.next();
			if( currentElement instanceof Port){
				result.add((Port)currentElement);
			}
		}
		return result;
	}
}
