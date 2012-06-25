package org.eclipse.papyrus.uml.compare.content.viewer;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.IMergeViewerContentProvider;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeContentProvider;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.papyrus.infra.emf.compare.ui.content.transactional.viewer.PapyrusTransactionalModelContentMergeViewer;
import org.eclipse.papyrus.uml.compare.utils.RootObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;


public class UMLTransactionalModelContentMergeViewer extends PapyrusTransactionalModelContentMergeViewer {


	public UMLTransactionalModelContentMergeViewer(final Composite parent, final CompareConfiguration config, final IEditorPart editor) {
		super(parent, config, editor);
	}



	@Override
	protected IMergeViewerContentProvider createMergeViewerContentProvider() {
		return new ModelContentMergeContentProvider(configuration) {

			@Override
			public Object getLeftContent(final Object element) {
				if(element != null) {
					return new RootObject(configuration.getProperty(RootObject.LEFT_OBJECT_KEY));
				}
				return null;
			}

			@Override
			public Object getRightContent(final Object element) {
				if(element != null) {
					return new RootObject(configuration.getProperty(RootObject.RIGHT_OBJECT_KEY));
				}
				return null;
			}
		};

	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param composite
	 * @param side
	 * @return
	 */
	@Override
	protected ModelContentMergeTabFolder createModelContentMergeTabFolder(final Composite composite, final int side) {
		return new UMLModelContentMergeTabFolder(this, composite, side);
	}

}
