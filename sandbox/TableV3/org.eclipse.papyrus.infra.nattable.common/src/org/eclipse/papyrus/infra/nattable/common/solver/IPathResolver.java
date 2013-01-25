package org.eclipse.papyrus.infra.nattable.common.solver;

import org.eclipse.emf.ecore.EObject;


public interface IPathResolver {

	public boolean handles(final String path);

	public Object getRealObject(final String path, final EObject context);
}
