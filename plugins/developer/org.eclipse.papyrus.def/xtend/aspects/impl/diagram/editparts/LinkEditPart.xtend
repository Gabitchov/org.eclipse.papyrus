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
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *	  Remi Schnekenburger (CEA LIST) - modification for Papyrus MDT
 */
package aspects.impl.diagram.editparts

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.ModeledViewmap
import org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView
import xpt.Common

/**
 * Revisit: [MG]: @Inject extension same-named-api-class -> template extends api-class?
 */
@Singleton class LinkEditPart extends impl.diagram.editparts.LinkEditPart {
	@Inject extension Common;

	
	//BEGIN: PapyrusGenCode
	//computes super type of the link edit part in case the edit part manages a representation of a UML element
	def extendsListContents(GenLink it)'''
	«IF it.eResource.allContents.filter(typeof (ExtendedGenView)).filter[v |(v.genView.contains(it) && v.superOwnedEditPart!=null)].size != 0»
	«FOR extendedObject : it.eResource.allContents.filter(typeof (ExtendedGenView)).filter[v |(v.genView.contains(it) && v.superOwnedEditPart!=null)].toIterable»
	«specifyInheritance(extendedObject)»
	«ENDFOR»
	«ELSE»
	org.eclipse.papyrus.infra.gmfdiag.common.editpart.ConnectionEditPart
	«ENDIF»
	'''
	//END: BEGIN: PapyrusGenCode
	
	//BEGIN: PapyrusGenCode
	//definition of the inheritance
	def specifyInheritance (ExtendedGenView it)'''«superOwnedEditPart»'''
	//END: PapyrusGenCode

	override addFixedChild (GenLink it)'''
	«IF labels.size > 0»
		«generatedMemberComment»
		protected boolean addFixedChild(org.eclipse.gef.EditPart childEditPart) {
			«FOR label : labels»
				«addLabel(label.viewmap,label)»
			«ENDFOR»
			return false;
		}
	«ENDIF»
'''

	override removeFixedChild(GenLink it) '''
	«IF ! labels.empty»
		«generatedMemberComment»
		protected boolean removeFixedChild(org.eclipse.gef.EditPart childEditPart) {
			«FOR label : labels»
				«removeLabel(label.viewmap, label)»
			«ENDFOR»
			return false;
		}
	«ENDIF»
	'''

	override addChildVisual(GenLink it) '''
	«IF ! labels.empty»
		«generatedMemberComment»
		protected void addChildVisual(org.eclipse.gef.EditPart childEditPart, int index) {
			if (addFixedChild(childEditPart)) {
				return;
			}
			super.addChildVisual(childEditPart, -1);
		}
	«ENDIF»
	'''

	override removeChildVisual(GenLink it) '''
	«IF ! labels.empty»
		«generatedMemberComment»
		protected void removeChildVisual(org.eclipse.gef.EditPart childEditPart) {
			if (removeFixedChild(childEditPart)) {
				return;
			}
			super.removeChildVisual(childEditPart);
		}
	«ENDIF»
	'''
	
	override dispatch createLinkFigure(ModeledViewmap it, GenLink link) '''
«««		«generatedMemberComment»
«««		protected org.eclipse.draw2d.Connection createConnectionFigure() {
«««			return new «modeledViewmapFigureFQN(it)»();
«««		}
«««		
«««		«generatedMemberComment»
«««		public «modeledViewmapFigureFQN(it)» getPrimaryShape() {
«««			return («modeledViewmapFigureFQN(it)») getFigure();
«««		}
«««		
«««		«xptModeledViewmapProducer.viewmapClassBody(it)»
	'''
	
	override modeledViewmapFigureFQN(ModeledViewmap it) '''
«««	«xptModeledViewmapProducer.viewmapFigureFQN(it)»
	'''

}



