package org.eclipse.papyrus.properties.widgets;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * A Property Editor for editing a String with an editable combo.
 * The combo proposes a set of default values.
 * 
 * @author Camille Letavernier
 */
public class StringCombo extends AbstractPropertyEditor {

	protected org.eclipse.papyrus.widgets.editors.StringCombo editor;

	public StringCombo(Composite parent, int style) {
		editor = new org.eclipse.papyrus.widgets.editors.StringCombo(parent, style);
		super.setEditor(editor);
	}

	@Override
	public void doBinding() {
		IStaticContentProvider contentProvider = input.getContentProvider(propertyPath);
		editor.setContentProvider(contentProvider);

		ILabelProvider labelProvider = input.getLabelProvider(propertyPath);
		if(labelProvider != null) {
			editor.setLabelProvider(labelProvider);
		}
		super.doBinding();
	}
}
