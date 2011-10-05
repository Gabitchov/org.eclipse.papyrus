package org.eclipse.papyrus.uml.modelexplorer.recipetest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;

/** get All without Dependencies */
public class GetAllWithoutDependencies implements IJavaModelQuery<Package, Collection<PackageableElement>> {
	public Collection<PackageableElement> evaluate(final Package context, final ParameterValueList parameterValues){
	ArrayList<PackageableElement> result= new ArrayList<PackageableElement>();
	Iterator<PackageableElement> iter= context.getPackagedElements().iterator();
	while(iter.hasNext()){
		PackageableElement currentElement= iter.next();
		if( !(currentElement instanceof Dependency)){
			result.add(currentElement);
		}
	}
	return result;
	}
}
