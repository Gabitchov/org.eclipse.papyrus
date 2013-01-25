package org.eclipse.papyrus.uml.nattable.common.solver;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.common.solver.IPathResolver;
import org.eclipse.papyrus.uml.nattable.common.utils.Constants;


public class StereotypePathResolver implements IPathResolver {

	public boolean handles(final String path) {
		return path.startsWith(Constants.PROPERTY_OF_STEREOTYPE_PREFIX);
	}

	public Object getRealObject(final String path, final EObject context) {
		// TODO Auto-generated method stub
		return null;
	}



}
