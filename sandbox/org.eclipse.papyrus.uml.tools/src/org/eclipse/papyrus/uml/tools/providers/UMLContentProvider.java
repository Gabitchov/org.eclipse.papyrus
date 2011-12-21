package org.eclipse.papyrus.uml.tools.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class UMLContentProvider extends ServiceEditFilteredUMLContentProvider {

	public UMLContentProvider(EObject editedObject, EStructuralFeature feature) {
		this(editedObject, feature, null);
	}

	public UMLContentProvider(EObject editedObject, EStructuralFeature feature, EObject semanticRoot) {
		super(editedObject, feature, semanticRoot);
	}

}
