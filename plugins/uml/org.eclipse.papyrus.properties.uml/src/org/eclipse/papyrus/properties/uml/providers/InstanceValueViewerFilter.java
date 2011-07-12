package org.eclipse.papyrus.properties.uml.providers;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.properties.uml.util.UMLUtil;
import org.eclipse.papyrus.uml.modelexplorer.widgets.UMLHierarchicViewerFilter;
import org.eclipse.papyrus.widgets.providers.IHierarchicContentProvider;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Type;


public class InstanceValueViewerFilter extends UMLHierarchicViewerFilter {

	private InstanceValue source;

	public InstanceValueViewerFilter(IHierarchicContentProvider contentProvider, InstanceValue source) {
		super(contentProvider);
		this.source = source;
	}

	@Override
	public boolean isVisible(Viewer viewer, Object parentElement, Object element) {
		if(!super.isVisible(viewer, parentElement, element)) {
			return false;
		}

		if(source.getType() == null) {
			return true;
		}

		Type type = source.getType();

		InstanceSpecification instance = (InstanceSpecification)UMLUtil.resolveUMLElement(element);

		if(type instanceof Enumeration) {
			return ((Enumeration)type).getOwnedLiterals().contains(instance);
		} else if (type instanceof Classifier){
			Classifier classifier = (Classifier)type;
			if(instance.getClassifiers().contains(classifier)) {
				return true;
			}

			for(Classifier implementedClassifier : instance.getClassifiers()) {
				if(implementedClassifier.conformsTo(classifier)) {
					return true;
				}
			}
			return false;
		}

		return true;
	}

}
