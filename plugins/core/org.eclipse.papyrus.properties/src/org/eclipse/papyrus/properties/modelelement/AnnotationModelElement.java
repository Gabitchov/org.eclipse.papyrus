package org.eclipse.papyrus.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.properties.databinding.AnnotationObservableValue;


public class AnnotationModelElement extends AbstractModelElement {

	protected EModelElement source;

	protected EditingDomain domain;

	protected String annotationName;

	public AnnotationModelElement(EModelElement source, EditingDomain domain, String annotationName) {
		this.source = source;
		this.domain = domain;
		this.annotationName = annotationName;
	}

	public IObservable getObservable(String propertyPath) {
		return new AnnotationObservableValue(source, domain, annotationName, propertyPath);
	}

}
