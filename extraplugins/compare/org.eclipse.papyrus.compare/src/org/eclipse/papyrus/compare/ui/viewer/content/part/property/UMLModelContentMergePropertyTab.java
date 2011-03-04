package org.eclipse.papyrus.compare.ui.viewer.content.part.property;

import java.util.List;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.IModelContentMergeViewerTab;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabItem;
import org.eclipse.emf.compare.ui.viewer.content.part.property.ModelContentMergePropertyTab;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.papyrus.compare.ui.viewer.content.UMLModelContentMergeViewer;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;


public class UMLModelContentMergePropertyTab implements IModelContentMergeViewerTab {
	private final ModelContentMergePropertyTab delegate;
	private final ModelContentMergeViewer parentViewer;
	
	public UMLModelContentMergePropertyTab(ModelContentMergePropertyTab delegate, ModelContentMergeViewer parentViewer) {
		this.delegate = delegate;
		this.parentViewer = parentViewer;
	}
	
	protected boolean isShowAllProperties() {
		return ((UMLModelContentMergeViewer)parentViewer).isShowAllProperties();
	}

	public void showItems(List<DiffElement> items) {
		if (isShowAllProperties()) {
			
		}
		delegate.showItems(items);
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		delegate.addSelectionChangedListener(listener);
	}

	public void dispose() {
		delegate.dispose();
	}

	public Control getControl() {
		return delegate.getControl();
	}

	public List<? extends Item> getSelectedElements() {
		return delegate.getSelectedElements();
	}

	public ModelContentMergeTabItem getUIItem(EObject data) {
		return delegate.getUIItem(data);
	}

	public List<ModelContentMergeTabItem> getVisibleElements() {
		return delegate.getVisibleElements();
	}

	public void redraw() {
		delegate.redraw();
	}

	public void setReflectiveInput(Object input) {
		delegate.setReflectiveInput(input);
	}

}
