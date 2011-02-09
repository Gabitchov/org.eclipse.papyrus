package org.eclipse.papyrus.compare.ui.viewer.content.part.diff;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.ui.viewer.content.part.diff.ModelContentMergeDiffTab;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.util.UMLUtil;


public class UMLModelContentMergeDiffTab extends ModelContentMergeDiffTab {


	public UMLModelContentMergeDiffTab(Composite parentComposite, int side, ModelContentMergeTabFolder parentFolder) {
		super(parentComposite, side, parentFolder);
	}

	@Override
	protected void setSelectionToWidget(List l, boolean reveal) {
		List result = new ArrayList();
		for(Object next : l) {
			if(next instanceof EObject && UMLCompareUtils.isStereotypeApplication((EObject)next)) {
				EObject stereotypeApplication = (EObject)next;
				result.add(UMLUtil.getBaseElement(stereotypeApplication));
			} else {
				result.add(next);
			}
		}
		super.setSelectionToWidget(result, reveal);
	}

	@Override
	public void setReflectiveInput(Object object) {
		// We *need* to invalidate the cache here since setInput() would try to
		// use it otherwise
		clearCaches();

		// setLabelProvider(createLabelProvider()); // already set in constructor
		if(object instanceof EObject) {
			setInput(object);
		} else {
			// may be invoked with a resourceSet, a list of resources, or a single resource
			assert object instanceof Resource || object instanceof List;
			if(object instanceof List) {
				for(Object item : (List)object) {
					assert item instanceof Resource;
				}
			}
			setInput(object);
		}

		setupCaches();
		needsRedraw = true;
	}


}
