package org.eclipse.papyrus.uml.modelexplorer.widgets;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.modelexplorer.widgets.EditServiceValidator;
import org.eclipse.papyrus.service.edit.service.IElementEditService;

public class ServiceEditFilteredUMLContentProvider extends UMLElementMEBContentProvider {

	private EObject editedEObject;

	private IElementEditService editingService;

	private EStructuralFeature editedEReference;

	private EditServiceValidator validator;

	public ServiceEditFilteredUMLContentProvider(EObject editedObject, EStructuralFeature feature, EObject semanticRoot) {
		super(semanticRoot);
		validator = new EditServiceValidator(editedObject, feature);
	}

	@Override
	public boolean isValidValue(Object element) {
		return super.isValidValue(element) && validator.isValidValue(element);
	}

}
