/**
 * Copyright (c) 2006, 2009, 2013 Borland Software Corporation and others
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
 */
package aspects.diagram.editparts

import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView

@Singleton class ChildNodeLabelEditPart extends diagram.editparts.ChildNodeLabelEditPart {



	override extendsList(GenChildLabelNode it) '''
«««BEGIN: PapyrusGenCode
«««Add own extension
«IF it.eResource.allContents.filter(typeof (ExtendedGenView)).filter[v |v.genView.contains(it) && v.superOwnedEditPart!=null].size != 0»
extends «FOR extendedObject : it.eResource.allContents.filter(typeof (ExtendedGenView)).filter[v |v.genView.contains(it) && v.superOwnedEditPart!=null].toIterable»
«specifyInheritance(extendedObject as ExtendedGenView)»
«ENDFOR»
«««END: PapyrusGenCode
«ELSE»
  extends org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart
«ENDIF»
'''

//BEGIN: PapyrusGenCode
//definition of the inheritance
def specifyInheritance (ExtendedGenView it)'''«superOwnedEditPart»'''
//END: PapyrusGenCode

override implementsList(GenChildLabelNode it) '''implements org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart, org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart'''
}
