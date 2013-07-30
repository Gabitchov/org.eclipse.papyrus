package org.eclipse.papyrus.uml.search.ui.providers;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.uml.tools.model.UmlModel;


public class OCLContextContentProvider implements ITreeContentProvider {

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	public Object[] getElements(Object inputElement) {
		ArrayList result = new ArrayList();
		if(inputElement instanceof ModelSet) {
			UmlModel root = (UmlModel)((ModelSet)inputElement).getModel(UmlModel.MODEL_ID);
			try {
				result.add(root.lookupRoot());
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result.toArray();
	}

	public Object[] getChildren(Object parentElement) {
		ArrayList result = new ArrayList();
		if(parentElement instanceof EObject) {
			result.addAll(((EObject)parentElement).eContents());
		}

		return result.toArray();
	}

	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length == 0 ? false : true;

	}

}
