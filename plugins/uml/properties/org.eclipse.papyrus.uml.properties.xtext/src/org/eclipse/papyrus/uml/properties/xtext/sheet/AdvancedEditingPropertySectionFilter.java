package org.eclipse.papyrus.uml.properties.xtext.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;

public class AdvancedEditingPropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		EObject semanticElement = null;
		if (toTest instanceof IAdaptable) {
			semanticElement = (EObject) ((IAdaptable) toTest).getAdapter(EObject.class);
		}
		else if (toTest instanceof GraphicalEditPart) {
			GraphicalEditPart part = (GraphicalEditPart) toTest;
			semanticElement = part.resolveSemanticElement();
		}
		if (semanticElement != null) {
			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
			String key = IDirectEditorsIds.EDITOR_FOR_ELEMENT
					+ semanticElement.eClass().getInstanceClassName();
			
			String languagePreferred = store.getString(key);
			
			if (languagePreferred != null && !languagePreferred.equals("")) {
				IDirectEditorConfiguration configuration = DirectEditorsUtil.findEditorConfiguration(
						languagePreferred, semanticElement.eClass()
								.getInstanceClassName());
				return configuration instanceof ICustomDirectEditorConfiguration;
			}
		}
		return false;
	}
}