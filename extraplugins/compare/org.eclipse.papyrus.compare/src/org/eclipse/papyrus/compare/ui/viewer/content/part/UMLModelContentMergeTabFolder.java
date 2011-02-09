package org.eclipse.papyrus.compare.ui.viewer.content.part;

import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.IModelContentMergeViewerTab;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.ui.viewer.content.part.property.ModelContentMergePropertyTab;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.papyrus.compare.ui.PapyrusLabelProvider;
import org.eclipse.papyrus.compare.ui.viewer.content.UMLModelContentMergeContentProvider.RootObject;
import org.eclipse.papyrus.compare.ui.viewer.content.part.diff.UMLModelContentMergeDiffTab;
import org.eclipse.papyrus.compare.ui.viewer.content.part.property.UMLPropertyContentProvider;
import org.eclipse.swt.widgets.Composite;


public class UMLModelContentMergeTabFolder extends ModelContentMergeTabFolder {


	public UMLModelContentMergeTabFolder(ModelContentMergeViewer viewer, Composite composite, int side) {
		super(viewer, composite, side);
	}

	@Override
	protected IModelContentMergeViewerTab createModelContentMergeDiffTab(Composite parent) {
		UMLModelContentMergeDiffTab diffTab = new UMLModelContentMergeDiffTab(parent, partSide, this);
		diffTab.setContentProvider(createDiffTabContentProvider());
		diffTab.setLabelProvider(UMLCompareUtils.getInstance().getPapyrusLabelProvider());
		return diffTab;

	}

	protected IContentProvider createDiffTabContentProvider() {
		ComposedAdapterFactory adapterFactory = new UMLAdapterFactory();
		AdapterFactoryContentProvider result = new AdapterFactoryContentProvider(adapterFactory) {

			@Override
			public Object[] getElements(Object object) {
				if(object instanceof RootObject) {
					return new Object[]{ ((RootObject)object).object };
				}
				return super.getElements(object);
			}
		};

		return result;
	}


	@Override
	protected IModelContentMergeViewerTab createModelContentMergeViewerTab(Composite parent) {
		ModelContentMergePropertyTab propertyTab = new ModelContentMergePropertyTab(parent, partSide, this);
		propertyTab.setContentProvider(new UMLPropertyContentProvider());
		return propertyTab;
	}

}
