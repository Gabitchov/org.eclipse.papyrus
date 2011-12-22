package org.eclipse.papyrus.infra.constraints.runtime;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.constraints.Activator;
import org.eclipse.papyrus.infra.constraints.environment.ConstraintEnvironment;
import org.eclipse.papyrus.infra.constraints.environment.ConstraintType;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;


public class ConstraintsManager {

	public final static String EXTENSION_ID = Activator.PLUGIN_ID + ".ConstraintEnvironment"; //$NON-NLS-1$

	private ResourceSet resourceSet;

	private final Set<ConstraintEnvironment> environments;

	private ConstraintsManager() {
		environments = new HashSet<ConstraintEnvironment>();
		resourceSet = new ResourceSetImpl();
		loadExtensionPoint();
	}

	private void loadExtensionPoint() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			final String environmentResource = e.getAttribute("environmentModel"); //$NON-NLS-1$
			URI uri = URI.createURI("platform:/plugin/" + e.getContributor().getName() + "/" + environmentResource); //$NON-NLS-1$ //$NON-NLS-2$
			try {
				addEnvironment(uri);
			} catch (IOException ex) {
				Activator.log.error("The plugin " + e.getContributor() + " contributed an invalid " + "extension for " + EXTENSION_ID, ex); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
			}
		}
	}

	public void addEnvironment(URI uri) throws IOException {
		EObject model = EMFHelper.loadEMFModel(resourceSet, uri);
		if(model instanceof ConstraintEnvironment) {
			addEnvironment((ConstraintEnvironment)model);
		}
	}

	public void addEnvironment(ConstraintEnvironment environment) {
		environments.add(environment);
	}

	public static ConstraintsManager instance = new ConstraintsManager();

	public Collection<ConstraintType> getConstraintTypes() {
		Collection<ConstraintType> constraintTypes = new HashSet<ConstraintType>();
		for(ConstraintEnvironment environment : environments) {
			constraintTypes.addAll(environment.getConstraintTypes());
		}
		return constraintTypes;
	}
}
