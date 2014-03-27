/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.editor.palette

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.AbstractToolEntry
import org.eclipse.gmf.codegen.gmfgen.Palette
import org.eclipse.gmf.codegen.gmfgen.ToolEntry
import xpt.Common
import xpt.Common_qvto
import xpt.providers.ElementTypes

@Singleton class PaletteFactory extends xpt.editor.palette.PaletteFactory {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension Utils_qvto;

	@Inject ElementTypes xptElementTypes;


	override PaletteFactory(Palette it) '''
		«copyright(diagram.editorGen)»
		package «packageName»;
		
		«generatedClassComment»
		public class «factoryClassName» extends org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory.Adapter {
			//RS: New Palette generation
		
		//Generates the ID for the tool elements
		//Generate the tool factory (if(ID) createtool...)
		«FOR tool : collectTools(it)»
			«generateIDAttribute(tool)»
		«ENDFOR»
		
		«««Generates the default constructor
		«generatedMemberComment»
			public «factoryClassName»() {
			
			}
			
		«««Generates the main method to create tool
		«generateCreateTool(it)»
		
		«««Generates the main method to create template
		«generateGetTemplate(it)»
		
		«««Generates each method for tool creation
		
		«FOR tool : collectTools(it)»
			«createTool(tool)»
		«ENDFOR»
		
		}
	'''

	def generateCreateTool(Palette it) '''
		«generatedMemberComment»
			public org.eclipse.gef.Tool createTool(String toolId) {
				«FOR tool : collectTools(it)»
					«checkToolID(tool)»
			«ENDFOR»
			// default return: null
			return null;
			}
	'''

	def checkToolID(AbstractToolEntry it) '''
		if (toolId.equals(«getConstantIDName(id)»)) {
			return «createMethodName»();
		}
	'''

	def generateGetTemplate(Palette it) '''
		«generatedMemberComment»
			public Object getTemplate(String templateId) {
				
				// default return: null
				return null;
			}
	'''

	def generateIDAttribute(AbstractToolEntry it) '''
		«generatedMemberComment»
		private final static String «getConstantIDName(id)» = «id»;«IF isQuoted(id,'"')»«nonNLS»«ENDIF»
	'''

	def createTool(AbstractToolEntry it) '''
		«generatedMemberComment»
		private org.eclipse.gef.Tool «createMethodName»() {
			«newTool(it as ToolEntry, 'entry')»
		}
	'''

	def newTool(ToolEntry it, String toolVarName) '''
		«IF elements.isEmpty()»
			«ERROR('no elements for tool generation (Palette)')»
		«ELSE»
			java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>(«elements.size»);
				«FOR e : elements»
					types.add(«xptElementTypes.accessElementType(e)»);
				«ENDFOR»
				«««	RS: modified tool creation to have stereotypes-aware tools
		org.eclipse.gef.Tool tool = new org.eclipse.papyrus.uml.diagram.common.service.«IF it.genNodes.isEmpty()»AspectUnspecifiedTypeConnectionTool«ELSE»AspectUnspecifiedTypeCreationTool«ENDIF»(types);
			return tool;
		«ENDIF»
	'''

}
