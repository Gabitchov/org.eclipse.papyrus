package org.eclipse.papyrus.qompass.designer.core.deployment;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Class;

import org.eclipse.papyrus.qompass.designer.core.extensions.ILangSupport;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;

/**
 * Gather configuration data for a code generation project
 * In particular, a class might be stereotyped to provide additional information
 * about required compilation options (in case of C++ include paths, libraries, ...)
 * 
 * @author ansgar
 */
public class GatherConfigData implements CopyListener {

	/**
	 * Gather configuration data for a code generation project
	 * Constructor.
	 * 
	 * @param langSupport
	 *        A reference to a class providing the language support interface
	 */
	public GatherConfigData(ILangSupport langSupport) {
		this.langSupport = langSupport;
	}

	public EObject copyEObject(Copy copy, EObject sourceEObj) {
		if(sourceEObj instanceof Class) {
			langSupport.gatherConfigData((Class)sourceEObj);
		}
		return sourceEObj;
	}

	private ILangSupport langSupport;
}
