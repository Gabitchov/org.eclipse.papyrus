/**
 * Copyright (c) 2006-2013 Borland Software Corporation and others
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
import metamodel.MetaModel
import org.eclipse.emf.common.util.EList
import org.eclipse.gmf.codegen.gmfgen.GenChildNode
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import org.eclipse.papyrus.papyrusgmfgenextension.ConstrainedByReferenceCompartmentItemSemanticEditPolicy
import xpt.Common

@Singleton class CompartmentItemSemanticEditPolicy extends xpt.diagram.editpolicies.CompartmentItemSemanticEditPolicy {
	@Inject extension Common;
	@Inject extension MetaModel

	@Inject childContainerCreateCommand xptChildContainerCreateCommand;
	@Inject BaseItemSemanticEditPolicy xptBaseItemSemanticEditPolicy;


	override CompartmentItemSemanticEditPolicy(GenCompartment it) '''
		«copyright(getDiagram().editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment()»
		public class «className(it)» extends «xptBaseItemSemanticEditPolicy.qualifiedClassName(getDiagram())» {
		
		«_constructor(it)»
	
		«xptChildContainerCreateCommand.childContainerCreateCommand( it.childNodes)»
		
		«additions(it)»
		
		««« Papyrus REM : 
		««« Test if this compartment edit policy should used a referenced constraint for the move command.

		«IF it.eResource.allContents.filter(typeof (ConstrainedByReferenceCompartmentItemSemanticEditPolicy)).filter[v | v.genView.contains(it)].size != 0»
		«getChildNodeReference(childNodes)»
			
			«isCorrectCompartment(it)»
			
			«constraintedMoveCommand(it)»
		
		«ENDIF»
		}
	'''

def getChildNodeReference (EList<GenChildNode> it) '''
	«IF !(it.isEmpty)»
	«generatedMemberComment»
	private static Set<EReference> compartmentReferences;
	
	«generatedMemberComment»
	static {
		«««	compartmentReferences = new HashSet<EReference>(«it.modelFacet->size()»);
		compartmentReferences = new HashSet<EReference>();
		
		«FOR n : it»
				«childRef(n.modelFacet,n)»
		«ENDFOR»
	}
	«generatedMemberComment»
	protected Iterable<EReference> getCompartmentReferences() {
		return compartmentReferences;
	}
«ENDIF»

'''

def childRef(TypeModelFacet it ,GenNode node) '''
	compartmentReferences.add(«MetaFeature (node.modelFacet.containmentMetaFeature)»);
'''


def  isCorrectCompartment (GenCompartment it)'''
	«generatedMemberComment»
	protected boolean isMovedIntoCorrectCompartment(MoveRequest req){
		for(Object entry : req.getElementsToMove().entrySet()) {
			if(entry instanceof Map.Entry<?, ?>) {
				Map.Entry<?, ?> mapEntry = (Map.Entry<?, ?>)entry;
				Object key = mapEntry.getKey();
				if(key instanceof EObject) {
					EObject dropppedObject = (EObject)key;
					EObject semanticHost = ((IGraphicalEditPart)getHost()).resolveSemanticElement();
					boolean foundERefrences = false;
					if(semanticHost != null) {
						for(EReference ref : getCompartmentReferences()) {
							if(ref.isContainment()) {
								foundERefrences = PackageUtil.canContain(semanticHost.eClass(), ref, dropppedObject.eClass(), false);
							} else {
								foundERefrences = PackageUtil.canReference(semanticHost.eClass(), ref, dropppedObject.eClass());
							}
							if(foundERefrences) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
'''

def  constraintedMoveCommand (GenCompartment it)'''
	«generatedMemberComment»
	@Override
	protected Command getMoveCommand(MoveRequest req) {
		if (isMovedIntoCorrectCompartment(req)){			
			return super.getMoveCommand(req);
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}
'''
}
