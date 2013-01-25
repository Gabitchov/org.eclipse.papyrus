package org.eclipse.papyrus.infra.nattable.common.solver;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;


public class CrossValueSolverFactory {

	public static final String CLASS_MANAGER = "solver";

	public static final String SOLVER_ID = "id";

	//	private final Map<String, Class<IAxisManager>> map;

	private final Collection<ICrossValueSolver> solvers;

	private static final String EXTENSION_ID = "org.eclipse.papyrus.infra.nattable.common.crossvaluesolver";

	public static final CrossValueSolverFactory INSTANCE = new CrossValueSolverFactory();

	private CrossValueSolverFactory() {
		this.solvers = new ArrayList<ICrossValueSolver>();

		final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(final IConfigurationElement iConfigurationElement : configElements) {

			final String id = iConfigurationElement.getAttribute(SOLVER_ID);
			try {

				//to avoid pb when the provided class in not this plugin!
				final ICrossValueSolver solver = (ICrossValueSolver)iConfigurationElement.createExecutableExtension(CLASS_MANAGER);
				this.solvers.add(solver);
			} catch (final CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Object getCrossValue(final Object obj1, final Object obj2) {
		for(final ICrossValueSolver current : this.solvers) {
			if(current.handles(obj1, obj2)) {
				return current.getValue(obj1, obj2);
			}
		}
		//FIXME should return a specific error or a message?
		return null;
	}


}
