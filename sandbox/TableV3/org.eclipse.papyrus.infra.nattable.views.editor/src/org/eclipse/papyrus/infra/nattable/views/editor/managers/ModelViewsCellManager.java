package org.eclipse.papyrus.infra.nattable.views.editor.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.nattable.manager.ICellManager;

public class ModelViewsCellManager implements ICellManager {

	public static final String STEREOTYPE_PREFIX = "nattable_editor_pages:/";

	public ModelViewsCellManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	protected List<Object> organizeObject(final Object obj1, final Object obj2) {
		final List<Object> objects = new ArrayList<Object>();
		if (obj1 instanceof String
				&& ((String) obj1).startsWith(STEREOTYPE_PREFIX)) {
			objects.add(obj2);
			objects.add(obj1);
		} else if (obj2 instanceof String
				&& ((String) obj2).startsWith(STEREOTYPE_PREFIX)) {
			objects.add(obj1);
			objects.add(obj2);
		}
		final Object first = objects.get(0);
		if (first instanceof EObject) {
			IPageManager mngr = null;
			try {
				mngr = ServiceUtilsForResource.getInstance()
						.getIPageManager(((EObject) first).eResource());
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (mngr != null && !mngr.allPages().contains(first)) {
				return Collections.emptyList();
			}
		}

		return objects;
	}

	public boolean handles(Object obj1, Object obj2) {
		return organizeObject(obj1, obj2).size() == 2;
	}

	public boolean handlersAxisElement(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getValue(Object obj1, Object obj2) {
		final List<Object> objects = organizeObject(obj1, obj2);
		final String featureName = ((String) objects.get(1)).replace(STEREOTYPE_PREFIX,
				"");
		if(featureName.equals("isOpen")){
			IPageManager mngr = null;
			try {
				mngr = ServiceUtilsForResource.getInstance()
						.getIPageManager(((EObject) objects.get(0)).eResource());
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mngr.isOpen(objects.get(0));
		}
		return ((EObject) objects.get(0)).eGet(((EObject) objects.get(0)).eClass()
				.getEStructuralFeature(featureName));
	}

	public void setValue(EditingDomain domain, Object obj1, Object obj2,
			Object newValue) {
		// TODO Auto-generated method stub

	}

	public boolean isCellEditable(Object obj1, Object obj2) {
		return true;
	}

	public Command getSetValueCommand(EditingDomain domain, Object obj1,
			Object obj2, Object newValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
