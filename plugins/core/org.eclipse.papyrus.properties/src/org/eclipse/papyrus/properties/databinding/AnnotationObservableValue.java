package org.eclipse.papyrus.properties.databinding;

import java.util.Map.Entry;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public class AnnotationObservableValue extends AbstractObservableValue {

	protected EModelElement source;

	protected EditingDomain domain;

	protected String annotationName;

	protected String key;

	protected EAnnotation annotation;

	public AnnotationObservableValue(EModelElement source, EditingDomain domain, String annotationName, String key) {
		this.source = source;
		this.domain = domain;
		this.annotationName = annotationName;
		this.key = key;
		annotation = source.getEAnnotation(annotationName);
	}

	public Object getValueType() {
		return String.class;
	}

	@Override
	protected Object doGetValue() {
		if(annotation == null) {
			return null;
		}

		return annotation.getDetails().get(key);
	}

	@Override
	protected void doSetValue(Object value) {
		if(!(value instanceof String)) {
			return;
		}

		CompoundCommand emfCommand = new CompoundCommand("Set " + key);

		if(annotation == null) {
			annotation = EcoreFactory.eINSTANCE.createEAnnotation();
			SetCommand command = new SetCommand(domain, annotation, EcorePackage.eINSTANCE.getEAnnotation_Source(), source);
			emfCommand.append(command);
		}

		EMap<String, String> details = new BasicEMap<String, String>();
		for(Entry<String, String> entry : annotation.getDetails().entrySet()) {
			details.put(entry.getKey(), entry.getValue());
		}

		details.put(key, (String)value);

		SetCommand command = new SetCommand(domain, annotation, EcorePackage.eINSTANCE.getEAnnotation_Details(), details);
		emfCommand.append(command);

		domain.getCommandStack().execute(emfCommand);
	}

}
