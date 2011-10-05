package org.eclipse.papyrus.uml.modelexplorer.recipetest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;

/** getAllDependencies */
public class GetAllDependencies implements IJavaModelQuery<Package, Collection<Dependency>> {
	public Collection<Dependency> evaluate(final Package context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		ArrayList<Dependency> result= new ArrayList<Dependency>();
		Iterator<PackageableElement> iter= context.getPackagedElements().iterator();
		while(iter.hasNext()){
			PackageableElement currentElement= iter.next();
			if( currentElement instanceof Dependency){
				result.add((Dependency)currentElement);
			}
		}
		return result;
	}
}
