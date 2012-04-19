package org.eclipse.papyrus.uml.compare.utils;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.papyrus.infra.emf.compare.common.utils.PapyrusModelCompareEditorInput;
import org.eclipse.papyrus.uml.compare.content.viewer.UMLTransactionalModelContentMergeViewer;
import org.eclipse.ui.IEditorPart;


public class UMLModelCompareEditorInput extends PapyrusModelCompareEditorInput {

	public UMLModelCompareEditorInput(final ComparisonSnapshot snapshot, final IEditorPart editor) {
		super(snapshot, editor);
	}

	@Override
	protected ModelContentMergeViewer createMergeViewer(final CompareViewerPane pane, final CompareConfiguration config) {
		return new UMLTransactionalModelContentMergeViewer(pane, config, editor);
	}
}
