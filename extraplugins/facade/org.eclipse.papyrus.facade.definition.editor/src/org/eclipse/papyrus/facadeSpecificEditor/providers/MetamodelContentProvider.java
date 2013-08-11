package org.eclipse.papyrus.facadeSpecificEditor.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facadeSpecificEditor.metamodel.MetamodelUtils;

public class MetamodelContentProvider implements ITreeContentProvider {


	public void dispose() {
		// TODO Auto-generated method stub

	}


	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}


	public Object[] getElements(Object inputElement) {

		List<VirtualElement> elements = new ArrayList<VirtualElement>();

		if(inputElement instanceof Facade) {
			elements.addAll(MetamodelUtils.getElements((Facade)inputElement));
		}

		return elements.toArray();
	}


	public Object[] getChildren(Object parentElement) {
		List<VirtualMetaclass> children = new ArrayList<VirtualMetaclass>();

		if(parentElement instanceof VirtualMetaclass)
			for(VirtualClassifier classifier : ((VirtualMetaclass)parentElement).getMetamodel().getVirtualClassifiers()) {

				if(classifier instanceof VirtualMetaclass)

					if(((VirtualMetaclass)classifier).getParents().contains(parentElement)) {
						children.add((VirtualMetaclass)classifier);
					}

			}

		return children.toArray();
	}


	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean hasChildren(Object element) {

		if(getChildren(element).length == 0) {
			return false;
		} else {
			return true;
		}
		// return true;
	}
}
