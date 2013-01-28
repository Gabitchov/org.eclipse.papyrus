package org.eclipse.papyrus.qompass.modellibs.core.acceleo;

import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.acceleo.UMLTool;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationContext;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Type;


public class StateMachineUtil {

	/**
	 * Return the bound package in the context of template instantiation for a given actual.
	 * 
	 * This is required by the state machine template which needs to access operation IDs
	 * provided by the call interceptor.
	 * 
	 * TODO: seems not very clean: why hardcoded operationIDs? precondition: package with suitable
	 * postfix must have been created
	 * 
	 * @param actual
	 * @return
	 */
	public static Package boundPackageRef(Type actual) {
		String suffix = "_" + actual.getName();
		for(Package nestedPkg : Utils.getTop(actual).getNestedPackages()) {
			if(nestedPkg.getName().endsWith(suffix)) {
				return nestedPkg;
			}
		}
		return null;
	}

	/**
	 * Declares a dependency from the current classifier which is produced by template instantiation
	 * to the element "OperationIDs, if found within the passed package.
	 * 
	 * @param pkg
	 * @return
	 */
	public static void declareDependencyToOperationIDs(Package pkg) {
		PackageableElement type = pkg.getPackagedElement("OperationIDs");
		if(type instanceof Type) {
			UMLTool.declareDependency(TransformationContext.classifier, (Type)type);
		}
	}
}
