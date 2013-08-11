package org.eclipse.papyrus.facadeSpecificEditor.providers;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;

public class PropertiesContentProvider implements IStructuredContentProvider {


	public void dispose() {
		// TODO Auto-generated method stub

	}


	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}


	public Object[] getElements(Object inputElement) {
		ArrayList<VirtualElement> output = new ArrayList<VirtualElement>();
		if(inputElement instanceof VirtualMetaclass) {
			output.addAll(((VirtualMetaclass)inputElement).getProperties());
			output.addAll(((VirtualMetaclass)inputElement).getOperations());
		}
		if(inputElement instanceof VirtualEnum) {
			output.addAll(((VirtualEnum)inputElement).getLiterals());
		}

		return output.toArray();
	}

}
