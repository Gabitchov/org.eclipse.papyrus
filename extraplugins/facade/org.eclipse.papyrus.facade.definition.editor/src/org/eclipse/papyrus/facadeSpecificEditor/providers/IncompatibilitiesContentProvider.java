package org.eclipse.papyrus.facadeSpecificEditor.providers;

import java.util.HashSet;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.Combination;

public class IncompatibilitiesContentProvider implements IStructuredContentProvider {


	public void dispose() {
		// TODO Auto-generated method stub

	}


	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}


	public Object[] getElements(Object inputElement) {

		HashSet<Combination> output = new HashSet<Combination>();
		if(inputElement instanceof BaseMetaclass) {
			// output.addAll(((BaseMetaclass) inputElement).getIncompatibleStereotypes());

			// output.addAll(ProfileUtils.getPossibleCombinaisons((BaseMetaclass) inputElement));
			output.addAll(((BaseMetaclass)inputElement).getIncompatibleStereotypes());
			output.addAll(((BaseMetaclass)inputElement).getCompatibleStereotypes());

		}
		return output.toArray();

	}

}
