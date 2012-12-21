package org.eclipse.papyrus.qompass.designer.core.transformations.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Class;

import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.sync.CompImplSync;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;

/**
 * Synchronize derived realizations (after copying). If re-synchronization is not done, the
 * relationship would point to wrong interface, if it is derived and depending on a formal parameter
 * (e.g. derived push interface with formal parameter T would be at wrong location).
 * => TODO: incomplete explication, re-think about location of derived interface
 * 
 * @author ansgar
 * 
 */
public class FixTemplateSync implements CopyListener {

	public static FixTemplateSync getInstance() {
		if(instance == null) {
			instance = new FixTemplateSync();
		}
		return instance;
	}

	public EObject copyEObject(Copy copy, EObject targetEObj) {
		// if (copy.get(sourceEObj) isWithinTemplate)
		if((targetEObj instanceof Class) && Utils.isCompImpl((Class)targetEObj)) {
			CompImplSync.syncRealizations((Class)targetEObj);
		}
		return targetEObj;
	}

	private static FixTemplateSync instance = null;
}
