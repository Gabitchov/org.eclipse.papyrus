/**
 * Copyright (c) 2007-2012 Borland Software Corporation and others
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
package aspects.xpt.diagram.commands

import com.google.inject.Inject
import com.google.inject.Singleton
import metamodel.MetaModel
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import xpt.Common
import xpt.diagram.Utils_qvto

@Singleton class CreateLinkUtils extends xpt.diagram.commands.CreateLinkUtils {
	@Inject extension Common;
	@Inject extension Utils_qvto;

	@Inject MetaModel xptMetaModel;


	/**
	 *	Fields of command that creates link.
	 */
	override dispatch fields(LinkModelFacet it) '''
		«extraLineBreak»
			«generatedMemberComment()» 
			protected final org.eclipse.emf.ecore.EObject source;
		
			«generatedMemberComment()» 
			protected final org.eclipse.emf.ecore.EObject target;
	'''

	override dispatch fields(TypeLinkModelFacet it) ''' 
		«extraLineBreak»
			«generatedMemberComment()» 
			protected final org.eclipse.emf.ecore.EObject source;
		
			«generatedMemberComment()» 
			protected final org.eclipse.emf.ecore.EObject target;
		«IF hasContainerOtherThanSource(it)»
			
			«generatedMemberComment()» 
			protected «xptMetaModel.QualifiedClassName(it.containmentMetaFeature.genClass)» container;
		«ENDIF»
	'''

	override dispatch containerAccessor(TypeLinkModelFacet it) ''' 
		«IF hasContainerOtherThanSource(it)»
			
				«generatedMemberComment()» 
				public «xptMetaModel.QualifiedClassName(it.containmentMetaFeature.genClass)» getContainer() {
					return container;
				}
			
				«generatedMemberComment(
			'Default approach is to traverse ancestors of the source to find instance of container.\n' + 'Modify with appropriate logic.'
		)»
				protected «xptMetaModel.QualifiedClassName(it.containmentMetaFeature.genClass)» deduceContainer(org.eclipse.emf.ecore.EObject source, org.eclipse.emf.ecore.EObject target) {
					// Find container element for the new link.
					// Climb up by containment hierarchy starting from the source
					// and return the first element that is instance of the container class.
					for (org.eclipse.emf.ecore.EObject element = source; element != null; element = element.eContainer()) {
						if («xptMetaModel.IsInstance(containmentMetaFeature.genClass, 'element')») {
							return «xptMetaModel.CastEObject(it.containmentMetaFeature.genClass, 'element')»;
						}
					}
					return null;
				}
		«ENDIF»
		
	'''

}
