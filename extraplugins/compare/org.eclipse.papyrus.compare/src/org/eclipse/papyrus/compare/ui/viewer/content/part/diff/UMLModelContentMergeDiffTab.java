package org.eclipse.papyrus.compare.ui.viewer.content.part.diff;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.ui.viewer.content.part.diff.ModelContentMergeDiffTab;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.util.UMLUtil;


public class UMLModelContentMergeDiffTab extends ModelContentMergeDiffTab {


	public UMLModelContentMergeDiffTab(Composite parentComposite, int side, ModelContentMergeTabFolder parentFolder) {
		super(parentComposite, side, parentFolder);
	}

	@Override
	protected void setSelectionToWidget(List l, boolean reveal) {
		// tfesenko filter stereotype applications
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
		// tfesenko 336361 - [UML Compare] Compare two elements: show right element as root
		if (object instanceof EObject) {
			clearCaches();
			// tfesenko default implementation sets object.eResource here
			setInput(object);
			setupCaches();
			needsRedraw = true;
		}
		super.setReflectiveInput(object);
	}


}
