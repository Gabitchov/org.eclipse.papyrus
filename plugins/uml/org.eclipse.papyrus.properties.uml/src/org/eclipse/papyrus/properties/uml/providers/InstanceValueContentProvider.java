package org.eclipse.papyrus.properties.uml.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.uml.modelexplorer.widgets.ServiceEditFilteredUMLContentProvider;
import org.eclipse.uml2.uml.InstanceValue;


public class InstanceValueContentProvider extends ServiceEditFilteredUMLContentProvider {

	private InstanceValue source;

	public InstanceValueContentProvider(InstanceValue source, EStructuralFeature feature, EObject semanticRoot) {
		super(source, feature, semanticRoot);
		this.source = source;
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		if(this.viewer != null) {
			this.viewer.setFilters(new ViewerFilter[]{ new InstanceValueViewerFilter(this, source) });
		}
	}

}
