package org.eclipse.papyrus.modelexplorer.widgets;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;


public class EditServiceValidator {

	private EObject editedEObject;

	private EStructuralFeature editedFeature;

	private IElementEditService editingService;

	public EditServiceValidator(EObject editedEObject, EStructuralFeature editedFeature) {
		this.editedEObject = editedEObject;
		this.editedFeature = editedFeature;

		if(editedEObject != null) {
			this.editingService = ElementEditServiceUtils.getCommandProvider(editedEObject);
		}

		if(this.editingService == null) {
			// log error service not found...
			System.err.println("Could not create service for " + EMFCoreUtil.getQualifiedName(editedEObject, true));
		}
	}

	public boolean isValidValue(Object element) {
		// Get semantic element
		EObject semanticElement = getSemanticElement(element);
		if((semanticElement == null) && (element != null)) {
			return false;
		}

		// Test editing command...
		SetRequest req = new SetRequest(editedEObject, editedFeature, semanticElement);
		if((editingService != null) && (editingService.canEdit(req))) {
			return true;
		}

		return false;
	}

	private EObject getSemanticElement(Object object) {
		EObject adapted = null;

		if(object instanceof EObject) {
			adapted = (EObject)object;

		} else if(object instanceof IAdaptable) {
			adapted = (EObject)((IAdaptable)object).getAdapter(EObject.class);

		}

		return adapted;
	}
}
