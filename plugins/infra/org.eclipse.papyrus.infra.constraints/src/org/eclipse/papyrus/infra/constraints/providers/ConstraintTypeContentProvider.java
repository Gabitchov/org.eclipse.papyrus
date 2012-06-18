package org.eclipse.papyrus.infra.constraints.providers;

import org.eclipse.papyrus.infra.constraints.runtime.ConstraintsManager;
import org.eclipse.papyrus.infra.widgets.providers.AbstractFilteredContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

//TODO : Move that to customization.constraints
/**
 * A ContentProvider which returns Constraint types
 * 
 * 
 * @author Camille Letavernier
 */
public class ConstraintTypeContentProvider extends AbstractFilteredContentProvider implements IStaticContentProvider {

	public Object[] getElements() {
		return ConstraintsManager.instance.getConstraintTypes().toArray();
	}

	public Object[] getElements(Object inputElement) {
		return getElements();
	}
}
