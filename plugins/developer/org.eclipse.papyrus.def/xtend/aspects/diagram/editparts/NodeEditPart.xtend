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

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenNode
import xpt.Common
import xpt.diagram.editparts.Utils_qvto

//DOCUMENTATION: PapyrusGenCode
//add call template in order to generate handlenotification in order to refresh figure by taking account event

@Singleton class NodeEditPart extends diagram.editparts.NodeEditPart {
	@Inject extension Common;
	@Inject extension Utils_qvto;
	
	@Inject impl.diagram.editparts.NodeEditPart xptNodeEditPartImpl;
	@Inject aspects.impl.diagram.editparts.NodeEditPart aspectsNodeEditPartImpl;
	

	
	override Main(GenNode it) '''
	«copyright(diagram.editorGen)»
	package «xptNodeEditPartImpl.packageName(it)»;
	
	«generatedClassComment»
	public class «xptNodeEditPartImpl.className(it)» «extendsList(it)» «implementsList(it)» {
	
		«attributes(it)»
		
		«xptNodeEditPartImpl.constructor(it)»
		
		«createDefaultEditPolicies(it)»
		
		«xptNodeEditPartImpl.createLayoutEditPolicy(it)»
		
«««	BEGIN: PapyrusGenCode
«««	call tamplate to paste code for refresh figure by taking account event
	«aspectsNodeEditPartImpl.specificHandleNotificationEvent(it)»
«««	END: PapyrusGenCode
		
		«xptNodeEditPartImpl.createNodeShape(it.viewmap, it)»
		
	«IF hasFixedChildren(it)»
		«xptNodeEditPartImpl.addFixedChild(it)»
	
		«xptNodeEditPartImpl.removeFixedChild(it)»
	
		«xptNodeEditPartImpl.addChildVisual(it)»
	
		«xptNodeEditPartImpl.removeChildVisual(it)»
	
		«xptNodeEditPartImpl.getContentPaneFor(it)»
	«ENDIF»
	
		«xptNodeEditPartImpl.addBorderItem(it)»
		
		«xptNodeEditPartImpl.createNodePlate(it)»
		
		«xptNodeEditPartImpl.getPrimaryDragEditPolicy(it)»
		
		«xptNodeEditPartImpl.createFigure(it)»
		
		«xptNodeEditPartImpl.setupContentPane(it)»
		
		«xptNodeEditPartImpl.getContentPane(it)»
	
		«xptNodeEditPartImpl.setForegroundColor(it)»
	
«««		«xptNodeEditPartImpl.setBackgroundColor(it)»
	
		«xptNodeEditPartImpl.setLineWidth(it)»
	
		«xptNodeEditPartImpl.setLineStyle(it)»
	
		«xptNodeEditPartImpl.getPrimaryChildEditPart(it)»
		

	
	«IF hasChildrenInListCompartments(it)»
		«xptNodeEditPartImpl.getTargetEditPartMethod(it)»
	«ENDIF»
	
		«handleNotificationEvent(it)»
	
		«xptNodeEditPartImpl.innerClassDeclaration(viewmap)»
		
		«additions(it)»
	}
	'''

	//BEGIN: PapyrusGenCode
	//patches the super type of the node edit part in case the controlled object represents a UML element
	override extendsList (GenNode it)''' extends «aspectsNodeEditPartImpl.extendsListContents(it)»'''
	//END: PapyrusGenCode

	//	override additions(GenNode it) '''
	//	«aspectsNodeEditPartImpl.genPreferredValue(it)»
	//	'''
}