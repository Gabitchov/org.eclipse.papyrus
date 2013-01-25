package org.eclipse.papyrus.infra.nattable.common.solver;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;


public class PathResolverFactory {

	public static final String CLASS_MANAGER = "resolver";

	public static final String SOLVER_ID = "id";

	//	private final Map<String, Class<IAxisManager>> map;

	private final Collection<IPathResolver> resolvers;

	private static final String EXTENSION_ID = "org.eclipse.papyrus.infra.nattable.common.pathresolver";

	public static final PathResolverFactory INSTANCE = new PathResolverFactory();

	private PathResolverFactory() {
		this.resolvers = new ArrayList<IPathResolver>();

		final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(final IConfigurationElement iConfigurationElement : configElements) {

			final String id = iConfigurationElement.getAttribute(SOLVER_ID);
			try {

				//to avoid pb when the provided class in not this plugin!
				final IPathResolver solver = (IPathResolver)iConfigurationElement.createExecutableExtension(CLASS_MANAGER);
				this.resolvers.add(solver);
			} catch (final CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Object getRealValue(final String path, final EObject context) {
		for(final IPathResolver current : this.resolvers) {
			if(current.handles(path)) {
				return current.getRealObject(path, context);
			}
		}

		//FIXME should return a specific error or a message?
		return null;
	}


}
