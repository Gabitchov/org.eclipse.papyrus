package org.eclipse.papyrus.uml.compare.content.viewer;

import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.ui.viewer.content.part.diff.ModelContentMergeDiffTab;
import org.eclipse.papyrus.uml.compare.utils.RootObject;
import org.eclipse.swt.widgets.Composite;


public class UMLModelContentMergeDiffTab extends ModelContentMergeDiffTab {

	public UMLModelContentMergeDiffTab(final Composite parentComposite, final int side, final ModelContentMergeTabFolder parentFolder) {
		super(parentComposite, side, parentFolder);
	}

	@Override
	public void setReflectiveInput(final Object object) {
		if(object instanceof RootObject) {
			clearCaches();
			setInput(object);
			setupCaches();
			needsRedraw = true;
		} else {
			super.setReflectiveInput(object);
		}
	}
}
