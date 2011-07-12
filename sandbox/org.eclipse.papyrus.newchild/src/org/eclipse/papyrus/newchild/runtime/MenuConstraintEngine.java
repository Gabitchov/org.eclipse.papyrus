package org.eclipse.papyrus.newchild.runtime;

import org.eclipse.papyrus.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.constraints.runtime.DefaultConstraintEngine;
import org.eclipse.papyrus.newchild.MenuRoot;
import org.eclipse.papyrus.newchild.NewchildConfiguration;


public class MenuConstraintEngine extends DefaultConstraintEngine<MenuRoot> {

	public void addConfiguration(NewchildConfiguration configuration) {
		for(MenuRoot root : configuration.getRoots()) {
			for(ConstraintDescriptor descriptor : root.getConstraints()) {
				addConstraint(descriptor);
			}
		}
	}

	@Override
	public void refresh() {
		constraints.clear();
		//Find all active Configurations
	}
}
