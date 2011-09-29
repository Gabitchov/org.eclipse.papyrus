package org.eclipse.papyrus.readonly;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.utils.BusinessModelResolver;

public class ReadOnlyTester extends PropertyTester {

	public static final String IS_READ_ONLY = "isReadOnly"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_READ_ONLY.equals(property) && receiver instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection)receiver;

			Iterator<?> it = selection.iterator();
			while(it.hasNext()) {
				Object obj = it.next();
				Object businessObject = BusinessModelResolver.getInstance().getBusinessModel(obj);
				if(businessObject instanceof EObject) {
					Resource resource = ((EObject)businessObject).eResource();
					IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resource.getURI().toPlatformString(true)));
					if(ReadOnlyManager.isReadOnly(file)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
