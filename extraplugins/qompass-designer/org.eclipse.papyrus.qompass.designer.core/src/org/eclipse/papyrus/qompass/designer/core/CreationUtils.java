package org.eclipse.papyrus.qompass.designer.core;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;

import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;

public class CreationUtils {

	/**
	 * This function returns a Package reference that corresponds to a qualified name.
	 * Packages are created, if not existing yet - the function is thus a bit similar to
	 * the unix mkdir -p command. Note that the main model within the list of name-spaces is
	 * ignored, in order to avoid that a sub-package within a model starts with the name
	 * of the model.
	 * 
	 * Caveat: imported elements must be checked beforehand. In case of a package import,
	 * getMembers (and getImportedMembers) will not return the name of the imported model
	 * but the elements (directly) owned by the imported model.
	 * Example: getMember ("BasicTypes") will return null whereas getMember ("CORBA")
	 * returns a package (CORBA is a package within the model library BasicTypes)
	 * 
	 * @param model
	 *        a model
	 * @param list
	 *        a list of namespace elements (as can be obtained via allNamespaces),
	 *        the top-level element is the last within the list.
	 * @param skipTop
	 *        if true, skip top level namespace element
	 * @return
	 */
	public static Package getAndCreate(Package root, EList<Namespace> list, boolean skipTop) {
		int offset = (skipTop ? 2 : 1);
		for(int i = list.size() - offset; i >= 0; i--) {
			Namespace ns = list.get(i);
			Log.log(Log.INFO_MSG, Log.UTILS, "getAndCreate:" + ns.getName());

			NamedElement pkg = root.getOwnedMember(ns.getName());
			if(pkg == null) {
				// package does not exist => create it.
				pkg = root.createNestedPackage(ns.getName());
				Copy.copyID(ns, pkg);
				// copy stereotype to create package
				StUtils.copyStereotypes(ns, pkg);
			}
			if(!(pkg instanceof Package)) {
				break;
			}
			root = (Package)pkg;
		}
		return root;
	}

	public static Package getAndCreate(Package root, EList<Namespace> list) {
		return getAndCreate(root, list, true);
	}

	public static Package getAndCreate(Package root, String name) {
		NamedElement pkg = root.getMember(name);
		if(pkg == null) {
			pkg = root.createNestedPackage(name);
		}
		return (Package)pkg;
	}
}
