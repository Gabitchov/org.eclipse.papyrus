/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnaud Cuccuru (CEA LIST) - Initial API and implementation
 *  Vincent Lorenzo   (CEA LIST)
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.resource.UMLResource;


public class NameResolutionHelper {

	protected Namespace scope;

	protected EClass filter;

	protected Map<String, List<NamedElement>> allNames;

	public NameResolutionHelper(Namespace scope, EClass filter) {
		this.scope = scope;
		this.filter = filter;
	}

	public List<NamedElement> getNamedElements(String name) {
		if(this.allNames == null) {
			this.allNames = new HashMap<String, List<NamedElement>>();
			this.computeAllNames();
		}
		List<NamedElement> namedElements = this.allNames.get(name);
		return namedElements != null ? namedElements : new ArrayList<NamedElement>();
	}

	/**
	 * TODO
	 */
	protected void computeAllNames() {

		// compute names directly available in the scope 
		computeNames("", scope, true);

		// compute names related to enclosing namepaces of scope		
		Namespace enclosingNamespace = scope.getNamespace();
		String prefix = "";
		while(enclosingNamespace != null) {
//			prefix += enclosingNamespace.getName() + NamedElementUtil.QUALIFIED_NAME_SEPARATOR;
			prefix="";
			computeNames(prefix, enclosingNamespace, false);
			enclosingNamespace = enclosingNamespace.getNamespace();
		}

		// Compute names related to the root context model
		Namespace model = scope.getModel();
		if(model==null){
			model  = scope;
		}
		if(filter != null) {
			if(filter.isSuperTypeOf(model.eClass())) {
				List<NamedElement> l = this.allNames.get(model.getName());
				if(l == null) { // i.e. no names have already been resolved in enclosed namespaces
					l = new ArrayList<NamedElement>();
					l.add(model);
					this.allNames.put(model.getName(), l);
				}
			}
		} else {
			List<NamedElement> l = this.allNames.get(model.getName());
			if(l == null) { // i.e. no names have already been resolved in enclosed namespaces
				l = new ArrayList<NamedElement>();
				l.add(model);
				this.allNames.put(model.getName(), l);
			}
		}
		computeNames(model.getName() + "::", model, false);

		// Build names corresponding to other available UML resources in the workspace 
		List<Resource> resources = scope.eResource().getResourceSet().getResources();
		for(Resource resource : resources) {
			if(resource != scope.eResource() && resource instanceof UMLResource) {
				UMLResource umlResource = (UMLResource)resource;
				Model root = null;
				for(Iterator<EObject> i = umlResource.getAllContents(); i.hasNext() && root == null;) {
					EObject next = i.next();
					if(next instanceof Model)
						root = (Model)next;
				}
				if(root != null) {
					if(filter != null) {
						if(filter.isSuperTypeOf(root.eClass())) {
							List<NamedElement> l = this.allNames.get(root.getName());
							if(l == null) { // i.e. no names have already been resolved in enclosed namespaces
								l = new ArrayList<NamedElement>();
								l.add(root);
								this.allNames.put(root.getName(), l);
							}
						}
					} else {
						List<NamedElement> l = this.allNames.get(root.getName());
						if(l == null) { // i.e. no names have already been resolved in enclosed namespaces
							l = new ArrayList<NamedElement>();
							l.add(root);
							this.allNames.put(root.getName(), l);
						}
					}
					computeNames(root.getName() + NamedElementUtil.QUALIFIED_NAME_SEPARATOR, root, false);
				}
			}
		}
	}


	/**
	 * TODO
	 */
	protected void computeNames(String prefix, Namespace scope, boolean ignoreAlreadyFoundNames) {
		Set<String> preExistingKeys;
		if(ignoreAlreadyFoundNames)
			preExistingKeys = new HashSet<String>();
		else
			preExistingKeys = this.allNames.keySet();
		// iterates members of the scope
		for(NamedElement member : scope.getMembers()) {
			List<String> memberNames = scope.getNamesOfMember(member);
			// iterates other names given to the current member in the context of this scope
			for(String memberName : memberNames) {
				// Checks if the name must be considered or not
				if(!preExistingKeys.contains(prefix + memberName)) {
					List<NamedElement> l = this.getNamedElements(prefix + memberName);
					l.add(member);
					this.allNames.put(prefix + memberName, l);
				}
				if(member instanceof Namespace) { // Recursive call on the current member
					computeNames(prefix + memberName + NamedElementUtil.QUALIFIED_NAME_SEPARATOR, (Namespace)member, true);
				}
			}
		}
	}
}
