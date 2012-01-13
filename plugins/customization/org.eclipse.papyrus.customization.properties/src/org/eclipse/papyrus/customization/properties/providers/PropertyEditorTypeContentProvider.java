package org.eclipse.papyrus.customization.properties.providers;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.emf.providers.EMFGraphicalContentProvider;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.BooleanToggle;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.providers.AbstractTreeFilter;
import org.eclipse.papyrus.views.properties.environment.PropertyEditorType;
import org.eclipse.papyrus.views.properties.ui.PropertyEditor;
import org.eclipse.papyrus.views.properties.widgets.layout.PropertiesLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


public class PropertyEditorTypeContentProvider extends EMFGraphicalContentProvider implements ICommitListener {

	private PropertyEditor source;

	private BooleanToggle filterButton;

	private PropertyEditorTypeViewerFilter currentFilter;

	public PropertyEditorTypeContentProvider(IStructuredContentProvider semanticProvider, PropertyEditor source) {
		super(semanticProvider, source.eResource().getResourceSet(), getHistoryId(source));
		this.source = source;
		this.currentFilter = new PropertyEditorTypeViewerFilter();
	}

	private static String getHistoryId(PropertyEditor source) {
		return "history_propertyEditorType_" + source.eResource().getURI();
	}

	@Override
	public void createBefore(Composite parent) {
		Composite self = new Composite(parent, SWT.NONE);
		self.setLayout(new PropertiesLayout());

		filterButton = new BooleanToggle(self);
		filterButton.setText("Filter");
		filterButton.setValue(currentFilter.getFilter());
		filterButton.addCommitListener(this);
		super.createBefore(self);
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if(super.viewer != null) {
			super.viewer.removeFilter(currentFilter);
		}
		super.inputChanged(viewer, oldInput, newInput);
		super.viewer.addFilter(currentFilter);
	}

	@Override
	public void commit(AbstractEditor editor) {
		currentFilter.setFilter(filterButton.getValue());
		if(super.viewer != null) {
			super.viewer.refresh();
		}
	}

	private class PropertyEditorTypeViewerFilter extends AbstractTreeFilter {

		private boolean filter = true;

		@Override
		public boolean isVisible(Viewer viewer, Object parentElement, Object element) {
			if(!filter) {
				return true;
			}

			Object adaptedValue = getAdaptedValue(element);
			if(adaptedValue instanceof PropertyEditorType) {
				PropertyEditorType editorType = (PropertyEditorType)adaptedValue;
				if(source.getProperty() == null) {
					return true;
				}
				return editorType.getType() == source.getProperty().getType();
			}

			return false;
		}

		public boolean getFilter() {
			return filter;
		}

		public void setFilter(boolean filter) {
			this.filter = filter;
			clearCache();
		}

	}

}
