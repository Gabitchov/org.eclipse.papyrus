package org.eclipse.papyrus.infra.gmfdiag.css.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;


public class ModelStyleSheetsModelElement extends EMFModelElement implements ModelElement {

	public ModelStyleSheetsModelElement(EObject source) {
		super(source);
	}

	public ModelStyleSheetsModelElement(EObject source, EditingDomain domain) {
		super(source, domain);
	}

	@Override
	public IObservable getObservable(String propertyPath) {
		return new ModelStyleSheetsObservableValue(source, propertyPath);
	}

}
