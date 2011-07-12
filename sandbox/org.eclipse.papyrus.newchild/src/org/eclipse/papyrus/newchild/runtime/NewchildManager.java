package org.eclipse.papyrus.newchild.runtime;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.constraints.runtime.ConstraintEngine;
import org.eclipse.papyrus.newchild.Activator;
import org.eclipse.papyrus.newchild.MenuRoot;
import org.eclipse.papyrus.newchild.NewchildConfiguration;
import org.eclipse.papyrus.newchild.menu.FillElement;
import org.eclipse.papyrus.newchild.menu.FillerFactory;
import org.eclipse.papyrus.newchild.util.EMFHelper;


public class NewchildManager {

	public static final String TOP = "top"; //$NON-NLS-1$
	public static NewchildManager instance = new NewchildManager();

	private NewchildManager() {
	}

	public void fillMenu(IMenuManager menuManager, IStructuredSelection selection) {
		Set<MenuRoot> roots = findRootsFor(selection);
		if(roots.isEmpty()) {
			return;
		}

		for(MenuRoot root : roots) {
			Object selectedObject = selection.getFirstElement();
			FillElement filler = FillerFactory.instance.getFiller(root, selectedObject);
			filler.fill(menuManager);
		}
	}

	private Set<MenuRoot> findRootsFor(IStructuredSelection selection) {
		try {
			NewchildConfiguration configuration = (NewchildConfiguration)EMFHelper.loadEMFModel(null, URI.createPlatformPluginURI("org.eclipse.papyrus.newchild/Model/NewchildConfiguration.xmi", true));
			ConstraintEngine<MenuRoot> constraintEngine = new MenuConstraintEngine();
			for(MenuRoot root : configuration.getRoots()) {
				for (ConstraintDescriptor descriptor : root.getConstraints()){
					constraintEngine.addConstraint(descriptor);
				}
			}

			Set<MenuRoot> roots = constraintEngine.getDisplayUnits(selection);
			return roots;
		} catch (IOException ex) {
			Activator.log.error(ex);
		}

		return Collections.EMPTY_SET;
	}
}
