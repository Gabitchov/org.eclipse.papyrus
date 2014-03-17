/**
 * Copyright (c) 2007, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.editpolicies

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import org.eclipse.papyrus.papyrusgmfgenextension.GenerateUsingElementTypeCreationCommand
import xpt.Common
import xpt.providers.ElementTypes
import metamodel.MetaModel

@Singleton class childContainerCreateCommand extends xpt.diagram.editpolicies.childContainerCreateCommand{
	
	@Inject extension Common;
	
	@Inject extension ElementTypes;
	
	@Inject extension MetaModel;

 
 	override CharSequence childContainerCreateCommand(Iterable<? extends GenNode> nodes) '''
	«IF ! nodes.empty»

	«generatedMemberComment()»
	protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req) {
				org.eclipse.gmf.runtime.emf.type.core.IElementType requestElementType = req.getElementType();
		if(requestElementType == null) {
			return super.getCreateCommand(req);
		}
		org.eclipse.gmf.runtime.emf.type.core.IElementType baseElementType = requestElementType;
		boolean isExtendedType = false;
		if(requestElementType instanceof org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType) {
			baseElementType = org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils.getClosestDiagramType(requestElementType);
			if(baseElementType != null) {
				isExtendedType = true;
			} else {
				// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
				baseElementType = org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils.findClosestNonExtendedElementType((org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType)requestElementType);
				isExtendedType = true;
			}
		}

	«FOR n : nodes»
		«IF !n.sansDomain»
			«childNodeCreateCommand(n.modelFacet, n)»
		«ENDIF»
	«ENDFOR»
		return super.getCreateCommand(req);
	}
	«ENDIF»
	'''

def childNodeCreateCommand(TypeModelFacet it,GenNode node)'''
if («accessElementType(node)» == baseElementType) {
	«IF it.eResource.allContents.filter(typeof (GenerateUsingElementTypeCreationCommand)).size>0»
	// adjust the containment feature
	org.eclipse.emf.ecore.EReference containmentFeature = «MetaFeature(it.childMetaFeature)»;
	req.setContainmentFeature(containmentFeature);
	«ENDIF»
	if(isExtendedType) {
		return getExtendedTypeCreationCommand(req, (org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType)requestElementType);
	}
	«IF it.eResource.allContents.filter(typeof (GenerateUsingElementTypeCreationCommand)).size>0»
	return getGEFWrapper(getSemanticCreationCommand(req));
	«ELSE»
	return getGEFWrapper(new «node.getCreateCommandQualifiedClassName()»(req, org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils.getDiagramFrom(getHost())));
	«ENDIF»
	
}
'''

}