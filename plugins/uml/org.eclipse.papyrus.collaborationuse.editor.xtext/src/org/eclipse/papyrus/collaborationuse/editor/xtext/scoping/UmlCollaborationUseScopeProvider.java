/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.collaborationuse.editor.xtext.scoping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse.TypeRule;
import org.eclipse.papyrus.collaborationuse.editor.xtext.validation.UmlCollaborationUseJavaValidator;
import org.eclipse.papyrus.common.editor.xtext.umlCommon.QualifiedName;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.xtext.gmf.glue.edit.part.PopupXtextEditorHelper;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 * 
 */
public class UmlCollaborationUseScopeProvider extends AbstractDeclarativeScopeProvider {

	/**
	 * Rule for computing the scope of PropertyRule
	 * 
	 * @param ctx
	 * 
	 * @param ref
	 * @return
	 */
	public IScope scope_TypeRule_type(TypeRule ctx, EReference ref) {
		return create___TypeRule_type___Scope(ctx);
	}

	/**
	 * Returns a {@link IScope} owning the possible Element for the Type
	 * 
	 * @param ctx
	 *        the {@link TypeRule}
	 * @return
	 *         a {@link IScope} owning the possible Element for the Type
	 */
	private IScope create___TypeRule_type___Scope(TypeRule ctx) {
		if(ctx.getPath() == null) {
			Iterator<EObject> i = PopupXtextEditorHelper.context.eResource().getAllContents();
			List<EObject> allContent = new ArrayList<EObject>();
			while(i.hasNext()) {
				EObject object = i.next();
				if(object instanceof Collaboration)
					allContent.add(object);
			}
			Iterable<IEObjectDescription> visibleParameterBoxes = Scopes.scopedElementsFor(allContent);
			return new SimpleScope(visibleParameterBoxes);
		} else {
			// In the case where a path (qualified name prefix) has been specified,
			// retrieves visible elements from this name space
			List<Element> tmpVisibleElementsFromPath = new ArrayList<Element>();
			if(ctx.getPath() != null) {
				org.eclipse.papyrus.common.editor.xtext.umlCommon.QualifiedName qualifiedName = ctx.getPath();
				while(qualifiedName.getRemaining() != null) {
					qualifiedName = qualifiedName.getRemaining();
				}
				Namespace nearestNamespace = qualifiedName.getPath();
				if(nearestNamespace != null) {
					List<Element> tmpVisiblePropertiesFromPath = new ArrayList<Element>();
					tmpVisiblePropertiesFromPath.addAll(new Visitor_GetOwnedAndImportedCollaboration().visit(nearestNamespace));
					for(Element e : tmpVisiblePropertiesFromPath) {
						tmpVisibleElementsFromPath.add(e);
					}
				}
			}

			// builds the nested scope base on hierarchy and then inheritance
			SimpleScope resultScope = null;

			Iterable<IEObjectDescription> iterableIEobjectDescriptions;
			if(!tmpVisibleElementsFromPath.isEmpty()) {
				iterableIEobjectDescriptions = Scopes.scopedElementsFor(tmpVisibleElementsFromPath);
				resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
			}

			return resultScope != null ? resultScope : new SimpleScope(Scopes.scopedElementsFor(new ArrayList<Element>()));
		}
	}

	/**
	 * @param ctx
	 * @param ref
	 * @return
	 */
	public IScope scope_QualifiedName_path(QualifiedName ctx, EReference ref) {
		List<Namespace> visibleNamespaces = new ArrayList<Namespace>();
		if(ctx != null && ctx.eContainer() != null && ctx.eContainer() instanceof QualifiedName) {
			Namespace parentNameSpace = ((QualifiedName)ctx.eContainer()).getPath();
			visibleNamespaces.addAll(new Visitor_GetOwnedNamespacesAndImportedNamespaces().visit(parentNameSpace));
		} else {
			visibleNamespaces.add(UmlCollaborationUseJavaValidator.getInstance().getModel());
			visibleNamespaces.addAll(new Visitor_GetImportedNamespaces().visit(UmlCollaborationUseJavaValidator.getInstance().getModel()));
		}
		Iterable<IEObjectDescription> iterableIEobjectDescription = Scopes.scopedElementsFor(visibleNamespaces);
		return new SimpleScope(iterableIEobjectDescription);
	}

	/**
	 * 
	 * This class provides a method to get the imported {@link Namespace}
	 * 
	 */
	private class Visitor_GetImportedNamespaces {

		/**
		 * Returns the list of the imported {@link Namespace}
		 * 
		 * @param visited
		 *        the visited {@link Namespace}
		 * @return
		 *         the list of the imported {@link Namespace}
		 */
		public List<Namespace> visit(Namespace visited) {
			List<Namespace> namespaces = new ArrayList<Namespace>();

			// retrieves imported namespaces
			for(PackageImport pImport : visited.getPackageImports()) {
				namespaces.add(pImport.getImportedPackage());
			}
			for(ElementImport eImport : visited.getElementImports()) {
				if(eImport.getImportedElement() instanceof Namespace)
					namespaces.add((Namespace)eImport.getImportedElement());
			}

			return namespaces;
		}
	}

	/**
	 * 
	 * This class provides a method to explore the owned and included {@link Namespace} in a {@link Namespace}
	 * 
	 */
	private class Visitor_GetOwnedNamespacesAndImportedNamespaces extends Visitor_GetImportedNamespaces {

		/**
		 * 
		 * @see org.eclipse.papyrus.collaborationuse.editor.xtext.scoping.UmlCollaborationUseScopeProvider.Visitor_GetImportedNamespaces#visit(org.eclipse.uml2.uml.Namespace)
		 * 
		 * @param visited
		 * @return
		 */
		@Override
		public List<Namespace> visit(Namespace visited) {
			List<Namespace> namespaces = new ArrayList<Namespace>();
			// first retrieves imported namespaces
			namespaces.addAll(super.visit(visited));
			// 	then retrieves owned namespaces
			for(NamedElement n : visited.getOwnedMembers()) {
				if(n instanceof Namespace)
					namespaces.add((Namespace)n);
			}
			return namespaces;
		}
	}

	/**
	 * 
	 * This class provides a method to explore a {@link Namespace}
	 * 
	 */
	private class Visitor_GetOwnedAndImportedCollaboration {

		/**
		 * Returns the {@link Collaboration} owned by the {@link Namespace}
		 * 
		 * @param visited
		 *        the visited {@link Namespace}
		 * @return
		 *         the {@link Collaboration} owned by the {@link Namespace}
		 */
		public List<Element> visit(Namespace visited) {
			List<Element> visibleElements = new ArrayList<Element>();
			// first retrieves imported properties
			for(ElementImport eImport : visited.getElementImports()) {
				if(eImport.getImportedElement() instanceof Collaboration)
					visibleElements.add(eImport.getImportedElement());
			}
			// then retrieves owned properties
			for(NamedElement n : visited.getOwnedMembers()) {
				if(n instanceof Collaboration)
					visibleElements.add(n);
				if(n instanceof Namespace) {
					visibleElements.addAll(visit((Namespace)n));
				}
			}

			return visibleElements;
		}

	}
}
