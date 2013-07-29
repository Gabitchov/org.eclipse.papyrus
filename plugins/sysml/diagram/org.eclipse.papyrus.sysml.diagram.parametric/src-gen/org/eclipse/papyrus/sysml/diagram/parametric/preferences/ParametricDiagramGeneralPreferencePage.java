package org.eclipse.papyrus.sysml.diagram.parametric.preferences;

import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.DiagramPreferencePage;
import org.eclipse.papyrus.sysml.diagram.parametric.Activator;

public class ParametricDiagramGeneralPreferencePage extends DiagramPreferencePage {

	public ParametricDiagramGeneralPreferencePage() {
		setPreferenceStore(Activator.getInstance().getPreferenceStore());
	}
}
