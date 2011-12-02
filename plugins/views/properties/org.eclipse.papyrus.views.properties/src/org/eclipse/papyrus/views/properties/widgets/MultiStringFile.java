package org.eclipse.papyrus.views.properties.widgets;

import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.MultipleStringFileEditor;
import org.eclipse.swt.widgets.Composite;


public class MultiStringFile extends AbstractPropertyEditor {

	public MultipleStringFileEditor editor;

	public MultiStringFile(Composite parent, int style) {
		editor = new MultipleStringFileEditor(parent, style);
		setEditor(editor);
	}

	@Override
	protected void doBinding() {
		editor.setOrdered(input.isOrdered(propertyPath));
		editor.setUnique(input.isUnique(propertyPath));

		if(getInputObservableList() instanceof ICommitListener) {
			editor.addCommitListener((ICommitListener)getInputObservableList());
		}

		super.doBinding();
	}
}
