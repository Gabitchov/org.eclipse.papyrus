package org.eclipse.papyrus.palette.customization.widgets;

import org.eclipse.papyrus.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.widgets.Composite;


public class AspectActionPropertyEditor extends AbstractPropertyEditor {

	protected AspectActionEditor editor;

	public AspectActionPropertyEditor(Composite parent, int style) {
		editor = new AspectActionEditor(parent, style);
		setEditor(editor);
	}
}
