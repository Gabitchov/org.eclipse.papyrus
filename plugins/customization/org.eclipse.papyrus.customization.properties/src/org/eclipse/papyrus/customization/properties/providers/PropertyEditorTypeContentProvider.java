package org.eclipse.papyrus.customization.properties.providers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.BooleanToggle;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.providers.IGraphicalContentProvider;
import org.eclipse.papyrus.views.properties.environment.EnvironmentPackage;
import org.eclipse.papyrus.views.properties.environment.PropertyEditorType;
import org.eclipse.papyrus.views.properties.environment.Type;
import org.eclipse.papyrus.views.properties.ui.PropertyEditor;
import org.eclipse.papyrus.views.properties.widgets.layout.PropertiesLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


public class PropertyEditorTypeContentProvider extends EnvironmentContentProvider implements IGraphicalContentProvider, ICommitListener {

	private PropertyEditor source;

	private Viewer viewer;

	private boolean filter = true;

	private BooleanToggle filterButton;

	public PropertyEditorTypeContentProvider(PropertyEditor source) {
		super(EnvironmentPackage.eINSTANCE.getEnvironment_PropertyEditorTypes());
		this.source = source;
	}

	@Override
	public void createBefore(Composite parent) {
		Composite self = new Composite(parent, SWT.NONE);
		self.setLayout(new PropertiesLayout());

		filterButton = new BooleanToggle(self);
		filterButton.setText("Filter");
		filterButton.setValue(this.filter);
		filterButton.addCommitListener(this);
		super.createBefore(self);
	}

	@Override
	public Object[] getElements() {
		Object[] elements = super.getElements();
		if(!filter || source.getProperty() == null) {
			return elements;
		}

		Type type = source.getProperty().getType();
		boolean isPropertyMultiple = source.getProperty().getMultiplicity() != 1;
		List<Object> filteredElements = new LinkedList<Object>();
		for(Object element : elements) {
			PropertyEditorType editorType = (PropertyEditorType)element;
			boolean isElementMultiple = editorType.getMultiplicity() != 1;
			if(editorType.getType() == type && isPropertyMultiple == isElementMultiple) {
				filteredElements.add(element);
			}
		}

		return filteredElements.toArray();
	}

	public void commit(AbstractEditor editor) {
		filter = filterButton.getValue();
		if(super.viewer != null) {
			super.viewer.refresh();
		}
	}

}
