package org.eclipse.papyrus.uml.properties.xtext.sheet;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;

public class AdvancedEditingPropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		if (toTest instanceof IGraphicalEditPart) {
			IGraphicalEditPart part = (IGraphicalEditPart) toTest;
			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
			String key = IDirectEditorsIds.EDITOR_FOR_ELEMENT
					+ part.resolveSemanticElement().eClass().getInstanceClassName();
			String languagePreferred = store.getString(key);
			
			if (languagePreferred != null && !languagePreferred.equals("")) {
				IDirectEditorConfiguration configuration = DirectEditorsUtil.findEditorConfiguration(
						languagePreferred, part.resolveSemanticElement().eClass()
								.getInstanceClassName());
				return configuration instanceof ICustomDirectEditorConfiguration;
			}

		}
		return false;
	}
}