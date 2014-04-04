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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.TagSpecificationRule;
import org.eclipse.papyrus.marte.vsl.scoping.VSLScopeProvider;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class StereotypeApplicationWithVSLScopeProvider extends VSLScopeProvider {

	/* ****************************************************************
	 * 
	 * Custom scoping for StereotypeApplicationRule_stereotype
	 * 
	 * ***************************************************************
	 */

	public IScope scope_StereotypeApplicationRule_stereotype(StereotypeApplicationRule ctx, EReference ref) {
		return create___StereotypeApplicationRule_stereotype___Scope(ctx);
	}

	private IScope create___StereotypeApplicationRule_stereotype___Scope(StereotypeApplicationRule ctx) {
		Element element = (Element)ContextElementUtil.getContextElement(ctx.eResource());
		if(element == null) {
			return null;
		}
		List<Stereotype> applicableStereotypes = element.getApplicableStereotypes();
		Iterable<IEObjectDescription> visibleStereotypes = Scopes.scopedElementsFor(applicableStereotypes);
		return new SimpleScope(visibleStereotypes);
	}

	/* ****************************************************************
	 * 
	 * Custom scoping for StereotypeApplicationRule_stereotype
	 * 
	 * ***************************************************************
	 */

	public IScope scope_TagSpecificationRule_property(TagSpecificationRule ctx, EReference ref) {
		EObject context = ctx;
		while(context != null && !(context instanceof StereotypeApplicationRule)) {
			context = context.eContainer();
		}
		if(context == null || !(context instanceof StereotypeApplicationRule) || ((StereotypeApplicationRule)context).getStereotype() == null) {
			return null;
		}

		return create___TagSpecificationRule_property___Scope((((StereotypeApplicationRule)context).getStereotype()));
	}

	private IScope create___TagSpecificationRule_property___Scope(Stereotype stereotype) {
		IScope result = null;

		// build the stereotype inheritance hierarchy

		List<Property> visibleProperties = new ArrayList<Property>();
		visibleProperties.addAll(stereotype.getAllAttributes());

		// removes derived properties or those which name starts with "base_"
		List<Property> filteredList = new ArrayList<Property>(stereotype.getAllAttributes());
		for(Property p : filteredList) {
			if(p.getName() == null || p.getName().startsWith("base_") || p.isDerived()) {
				visibleProperties.remove(p);
			}
		}

		//		List<List<Stereotype>> inheritanceStructure = new ArrayList<List<Stereotype>>() ;
		//		List<Stereotype> tmpList = new ArrayList<Stereotype>() ;
		// 		tmpList.add(stereotype) ;
		//
		//		do {
		//			inheritanceStructure.add(tmpList) ;
		//			List<Stereotype> localStereotypeList = new ArrayList<Stereotype>() ;
		//			for (Stereotype currentStereotype : tmpList) {
		//				for (Classifier general : currentStereotype.getGenerals()) {
		//					if (general instanceof Stereotype)
		//						localStereotypeList.add((Stereotype)general) ;
		//				}
		//			}
		//			tmpList = new ArrayList<Stereotype>() ;
		//			tmpList.addAll(localStereotypeList) ;
		//		} while (!tmpList.isEmpty());
		//
		//		// builds the nested scope
		//
		//		if (! inheritanceStructure.isEmpty()) {
		//			List<Property> visibleProperties = new ArrayList<Property>() ;
		//			List<Property> filteredProperties = new ArrayList<Property>() ;
		//			List<Stereotype> currentList = inheritanceStructure.get(inheritanceStructure.size() - 1) ;
		//			for (Stereotype currentStereotype : currentList) {
		//				visibleProperties.addAll(currentStereotype.getOwnedAttributes()) ;
		//				filteredProperties.addAll(currentStereotype.getOwnedAttributes()) ;
		//				for (Property p : filteredProperties) {
		//					if (p.getName() == null ||
		//						p.getName().startsWith("base_") ||
		//						p.isDerived())
		//						visibleProperties.remove(p) ;
		//				}
		//			}
		Iterable<IEObjectDescription> visiblePropertiesIterable = Scopes.scopedElementsFor(visibleProperties);
		result = new SimpleScope(visiblePropertiesIterable);
		//			for (int i = inheritanceStructure.size() - 2 ; i >= 0 ; i--) {
		//				visibleProperties = new ArrayList<Property>() ;
		//				currentList = inheritanceStructure.get(i) ;
		//				filteredProperties = new ArrayList<Property>() ;
		//				for (Stereotype currentStereotype : currentList) {
		//					visibleProperties.addAll(currentStereotype.getOwnedAttributes()) ;
		//					filteredProperties.addAll(currentStereotype.getOwnedAttributes()) ;
		//				}
		//				for (Property p : filteredProperties) {
		//					if (p.getName() == null ||
		//						p.getName().startsWith("base_") ||
		//						p.isDerived())
		//						visibleProperties.remove(p) ;
		//				}
		//				visiblePropertiesIterable =
		//					Scopes.scopedElementsFor(visibleProperties) ;
		//				result = new SimpleScope(result, visiblePropertiesIterable) ;
		//			}
		//		}

		return result;
	}
}
