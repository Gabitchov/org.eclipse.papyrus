package org.eclipse.papyrus.uml.nattable.common.handlers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.common.editor.handler.AbstractCreateNattableEditorHandler;
import org.eclipse.uml2.uml.Element;


public abstract class AbstractCreateUMLNattableEditorHandler extends AbstractCreateNattableEditorHandler {

	public AbstractCreateUMLNattableEditorHandler(final String editorType, final String defaultName) {
		super(editorType, defaultName);
	}

	@Override
	public boolean isEnabled() {
		if(super.isEnabled()) {
			final List<EObject> selection = getSelection();
			return selection.size() == 1 && selection.get(0) instanceof Element;
		}
		return false;
	}
}
