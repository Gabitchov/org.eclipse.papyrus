package org.eclipse.papyrus.uml.compare.merger.utils;

import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IMultiPageEditorPart;
import org.eclipse.papyrus.infra.tools.util.EditorHelper;
import org.eclipse.ui.IEditorPart;

public class MergerUtils {

	private MergerUtils() {
		//nothing to do
	}

	public static boolean usePapyrusMerger() {
		return getEditingDomain()!=null;
	}

	public static TransactionalEditingDomain getEditingDomain() {
		IEditorPart editor = EditorHelper.getCurrentEditor();
		if(editor instanceof IMultiPageEditorPart) {
			editor = ((IMultiPageEditorPart)editor).getActiveEditor();
		}
		if(editor instanceof IEditingDomainProvider) {
			return (TransactionalEditingDomain)((IEditingDomainProvider)editor).getEditingDomain();
		}
		return null;
	}
}
