package org.eclipse.papyrus.uml.compare.content.viewer;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.IModelContentMergeViewerTab;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.content.viewer.PapyrusModelContentMergeTabFolder;
import org.eclipse.papyrus.uml.compare.utils.RootObject;
import org.eclipse.swt.widgets.Composite;


public class UMLModelContentMergeTabFolder extends PapyrusModelContentMergeTabFolder {

	public UMLModelContentMergeTabFolder(ModelContentMergeViewer viewer, Composite composite, int side) {
		super(viewer, composite, side);
	}

	/**
	 * 
	 * @returnZ
	 */
	protected IContentProvider createDiffTabContentProvider() {
		return new UMLModelContentMergeDiffTabContentProvider(AdapterUtils.getAdapterFactory());
	}


	@Override
	protected IModelContentMergeViewerTab createModelContentMergeDiffTab(Composite parent) {
		diffTab = new UMLModelContentMergeDiffTab(parent, partSide, this);
		diffTab.setContentProvider(createDiffTabContentProvider());
		return diffTab;
	}

	public class UMLModelContentMergeDiffTabContentProvider extends ModelContentMergeDiffTabContentProvider {

		public UMLModelContentMergeDiffTabContentProvider(AdapterFactory factory) {
			super(factory);
		}

		@Override
		public Object[] getElements(Object object) {
			if(object instanceof RootObject) {
				Object[] result = new Object[1];
				result[0] = ((RootObject)object).getRepresentedObject();
				return result;
			}
			return super.getElements(object);
		}

	}
}
