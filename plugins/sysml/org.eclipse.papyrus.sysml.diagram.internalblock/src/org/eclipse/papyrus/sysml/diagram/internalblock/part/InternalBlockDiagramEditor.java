package org.eclipse.papyrus.sysml.diagram.internalblock.part;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sysml.diagram.internalblock.Activator;


public class InternalBlockDiagramEditor extends org.eclipse.papyrus.diagram.composite.part.UMLDiagramEditor {

	public InternalBlockDiagramEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws ServiceException {
		super(servicesRegistry, diagram);
	}

	@Override
	public String getContributorId() {
		return Activator.PLUGIN_ID;
	}

	@Override
	protected PreferencesHint getPreferencesHint() {
		return Activator.DIAGRAM_PREFERENCES_HINT;
	}
}
