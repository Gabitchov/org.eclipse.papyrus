package org.eclipse.papyrus.dev.project.management.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.dev.project.management.Activator;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkingSet;


public class Utils {

	private Utils() {
		//to prevent instanciation
	}

	public static final String FEATURE_NATURE = "org.eclipse.pde.FeatureNature";

	public static final String PLUGIN_NATURE = "org.eclipse.pde.PluginNature";

	/**
	 * 
	 * @return
	 *         the list of opened feature project
	 */
	public static List<IProject> getOpenedFeatureProject() {
		final List<IProject> featureProject = new ArrayList<IProject>();
		final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for(final IProject current : projects) {
			try {
				if(current.isOpen() && current.hasNature(FEATURE_NATURE)) {
					featureProject.add(current);
				}
			} catch (final CoreException e) {
				Activator.log.error(e);
			}
		}
		return featureProject;
	}

	public static Collection<IProject> getSelectedOpenProject() {
		final Set<IProject> selectedProject = new HashSet<IProject>();
		final ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		Assert.isTrue(selection instanceof IStructuredSelection);
		final Iterator<?> iter = ((IStructuredSelection)selection).iterator();
		while(iter.hasNext()) {
			final Object current = iter.next();
			if((current instanceof IProject) && ((IProject)current).isOpen()) {
				selectedProject.add((IProject)current);
			} else if(current instanceof WorkingSet) {
				for(final IAdaptable curr : ((WorkingSet)current).getElements()) {
					if((curr instanceof IProject) && ((IProject)curr).isOpen()) {
						selectedProject.add((IProject)curr);
					}
				}
			}
		}
		return selectedProject;
	}
}
