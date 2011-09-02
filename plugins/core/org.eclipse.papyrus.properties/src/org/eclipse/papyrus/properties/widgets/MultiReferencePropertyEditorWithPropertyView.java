package org.eclipse.papyrus.properties.widgets;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.widgets.editors.ICommitListener;
import org.eclipse.swt.widgets.Composite;


public class MultiReferencePropertyEditorWithPropertyView extends AbstractPropertyEditor {

	protected MultiReferenceEditorWithPropertyView editor;

	public MultiReferencePropertyEditorWithPropertyView(Composite parent, int style){
		editor = new MultiReferenceEditorWithPropertyView(parent, style);
		setEditor(editor);
	}

	@Override
	protected void doBinding() {
		//		IStaticContentProvider contentProvider = input.getContentProvider(propertyPath);
		ILabelProvider labelProvider = input.getLabelProvider(propertyPath);

		if(getInputObservableList() instanceof ICommitListener) {
			editor.addCommitListener((ICommitListener)getInputObservableList());
		}

		editor.setLabelProvider(labelProvider);

		editor.setOrdered(input.isOrdered(propertyPath));
		editor.setUnique(input.isUnique(propertyPath));

		editor.setFactory(input.getValueFactory(propertyPath));
		editor.setDirectCreation(input.getDirectCreation(propertyPath));

		super.doBinding();
	}
}
