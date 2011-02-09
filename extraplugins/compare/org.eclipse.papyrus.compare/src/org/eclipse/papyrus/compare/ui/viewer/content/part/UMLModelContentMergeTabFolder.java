package org.eclipse.papyrus.compare.ui.viewer.content.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.IModelContentMergeViewerTab;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.ui.viewer.content.part.property.ModelContentMergePropertyTab;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.papyrus.compare.ui.PapyrusLabelProvider;
import org.eclipse.papyrus.compare.ui.viewer.content.UMLModelContentMergeContentProvider.RootObject;
import org.eclipse.papyrus.compare.ui.viewer.content.part.diff.UMLModelContentMergeDiffTab;
import org.eclipse.papyrus.compare.ui.viewer.content.part.property.UMLPropertyContentProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLReflectiveItemProviderAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLResourceItemProviderAdapterFactory;


public class UMLModelContentMergeTabFolder extends ModelContentMergeTabFolder {


	public UMLModelContentMergeTabFolder(ModelContentMergeViewer viewer, Composite composite, int side) {
		super(viewer, composite, side);
	}

	protected IModelContentMergeViewerTab createModelContentMergeDiffTab(Composite parent) {
		UMLModelContentMergeDiffTab diffTab = new UMLModelContentMergeDiffTab(parent, partSide, this);
		diffTab.setContentProvider(createDiffTabContentProvider());
		diffTab.setLabelProvider(new PapyrusLabelProvider());
		return diffTab;

	}

	protected IContentProvider createDiffTabContentProvider() {
		List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new UMLResourceItemProviderAdapterFactory());
		factories.add(new UMLItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new UMLReflectiveItemProviderAdapterFactory());

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(factories);
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


	protected IModelContentMergeViewerTab createModelContentMergeViewerTab(Composite parent) {
		ModelContentMergePropertyTab propertyTab = new ModelContentMergePropertyTab(parent, partSide, this);
		propertyTab.setContentProvider(new UMLPropertyContentProvider());
		return propertyTab;
	}




}
