package org.eclipse.papyrus.uml.modelexplorer.recipetest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

/** get all without ports from a classifier */
public class GetAllWithoutPorts implements IJavaModelQuery<Classifier, Collection<Property>> {
	public Collection<Property> evaluate(final Classifier context, final ParameterValueList parameterValues){
	ArrayList<Property> result= new ArrayList<Property>();
	Iterator<Property> iter= context.getAllAttributes().iterator();
	while(iter.hasNext()){
		Property currentElement= iter.next();
		if( !(currentElement instanceof Port)){
			result.add(currentElement);
		}
	}
	return result;
	}
}
