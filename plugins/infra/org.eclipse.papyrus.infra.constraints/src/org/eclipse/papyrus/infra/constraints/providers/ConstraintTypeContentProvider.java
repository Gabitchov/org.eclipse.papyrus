package org.eclipse.papyrus.infra.constraints.providers;

import org.eclipse.papyrus.infra.constraints.runtime.ConstraintsManager;
import org.eclipse.papyrus.infra.widgets.providers.AbstractFilteredContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

//TODO : Move that to customization.constraints
public class ConstraintTypeContentProvider extends AbstractFilteredContentProvider implements IStaticContentProvider {

	public ConstraintTypeContentProvider() {

	}

	public Object[] getElements() {
		return ConstraintsManager.instance.getConstraintTypes().toArray();
	}
}
