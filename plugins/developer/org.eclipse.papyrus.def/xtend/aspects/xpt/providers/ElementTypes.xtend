/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.providers

import com.google.inject.Inject
import xpt.diagram.Utils_qvto
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common

@Singleton class ElementTypes extends xpt.providers.ElementTypes {

	@Inject extension Common;
	@Inject extension Utils_qvto;

	override def getElement(GenDiagram it) '''
		«generatedMemberComment('Returns \'type\' of the ecore object associated with the hint.\n')»
		public static synchronized org.eclipse.emf.ecore.ENamedElement getElement(org.eclipse.core.runtime.IAdaptable hint) {
			Object type = hint.getAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType.class);
			if (elements == null) {
				elements = new java.util.IdentityHashMap<org.eclipse.gmf.runtime.emf.type.core.IElementType, org.eclipse.emf.ecore.ENamedElement>();
				«IF domainDiagramElement != null»«bindUniqueIdentifierToNamedElement(domainDiagramElement, getUniqueIdentifier())»«ENDIF»
				«FOR node : getAllNodes()»
					«IF node.modelFacet != null»«bindUniqueIdentifierToNamedElement(node.modelFacet, node.getUniqueIdentifier())»«ENDIF»
				«ENDFOR»
				«FOR link : it.links»
					«IF link.modelFacet != null»«bindUniqueIdentifierToNamedElement(link.modelFacet, link.getUniqueIdentifier())»«ENDIF»
				«ENDFOR»
			}
			return (org.eclipse.emf.ecore.ENamedElement) elements.get(type);
		}
	'''
	
	override def isKnownElementType(GenDiagram it) '''
		«generatedMemberComment»
		public static synchronized boolean isKnownElementType(org.eclipse.gmf.runtime.emf.type.core.IElementType elementType) {
			if (KNOWN_ELEMENT_TYPES == null) {
				KNOWN_ELEMENT_TYPES = new java.util.HashSet<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
				«FOR e : it.getAllTypedElements()»
					«addKnownElementType(e)»
				«ENDFOR»
			}
			return KNOWN_ELEMENT_TYPES.contains(elementType);
		}
	'''

}
