package org.eclipse.papyrus.views.properties.runtime;

import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.constraints.runtime.ConstraintEngine;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.View;


public interface ViewConstraintEngine extends ConstraintEngine<View> {

	public Set<View> getViews(final ISelection forSelection);

	public void addContext(final Context context);
}
