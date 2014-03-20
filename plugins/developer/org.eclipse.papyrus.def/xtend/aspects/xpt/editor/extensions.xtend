/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	 Dmitry Stadnik (Borland) - initial API and implementation
 *	 Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.editor

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import xpt.Common

@Singleton class extensions extends xpt.editor.extensions {
	@Inject extension Common;

	override extensions(GenEditorGenerator it) '''
		«extraLineBreak»
		«««		YT (not used): 
		«««		«tripleSpace(1)»<extension point="org.eclipse.ui.editors" id="gmf-editor">
		«««		«tripleSpace(2)»«xmlGeneratedTag()»
		«««		«tripleSpace(2)»<editor
		«««		«tripleSpace(3)»id="«editor.ID»"
		«««		«tripleSpace(3)»name="%editorName"
		«««		«tripleSpace(3)»icon="«editor.iconPathX»"
		«««		«tripleSpace(3)»extensions="«diagramFileExtension»"
		«««		«tripleSpace(3)»default="true"
		«««		«tripleSpace(3)»class="«xptEditor.qualifiedClassName(editor)»"
		«««		«tripleSpace(3)»matchingStrategy="«xptMatching.qualifiedClassName(diagram)»"
		«««		«tripleSpace(3)»contributorClass="«xptActionBarContributor.qualifiedClassName(editor)»">
		«««		«tripleSpace(2)»</editor>
		«««		«tripleSpace(1)»</extension>
		
		«extraLineBreak»«outTab»
		«tripleSpace(1)»<extension point="org.eclipse.ui.contexts" id="ui-context">
		«tripleSpace(2)»«xmlGeneratedTag()»
		«tripleSpace(2)»<context
		«tripleSpace(3)»description="%context.description"
		«tripleSpace(3)»id="«editor.contextID»"
		«tripleSpace(3)»name="%context.name"
		«tripleSpace(3)»parentId="org.eclipse.gmf.runtime.diagram.ui.diagramContext">
		«tripleSpace(2)»</context>
		«tripleSpace(1)»</extension>
		
		«««		YT (not used): 
		«««		«tripleSpace(1)»<extension point="org.eclipse.ui.newWizards" id="creation-wizard">
		«««		«tripleSpace(2)»«xmlGeneratedTag()»
		«««		«tripleSpace(2)»<wizard
		«««		«tripleSpace(3)»name="%newWizardName"
		«««		«tripleSpace(3)»icon="«diagram.creationWizardIconPathX»"
		«««		«tripleSpace(3)»category="«diagram.creationWizardCategoryID»"
		«««		«tripleSpace(3)»class="«xptCreationWizard.qualifiedClassName(diagram)»"
		«««		«tripleSpace(3)»id="«xptCreationWizard.qualifiedClassName(diagram)»ID">
		«««		«tripleSpace(3)»<description>%newWizardDesc</description>  
		«««		«tripleSpace(2)»</wizard>
		«««		«tripleSpace(1)»</extension>
		«««		
		«««		«IF diagram.generateInitDiagramAction()»
		«««			«IF null == application»
		«««				«tripleSpace(1)»<extension point="org.eclipse.ui.popupMenus" id="init-diagram-action">
		«««				«tripleSpace(2)»«xmlGeneratedTag()»
		«««				«tripleSpace(2)»<objectContribution
		«««				«tripleSpace(4)»id="«plugin.ID».InitDiagram"
		«««				«tripleSpace(4)»nameFilter="*.«domainFileExtension»"
		«««				«tripleSpace(4)»objectClass="org.eclipse.core.resources.IFile">
		«««				«tripleSpace(3)»<action
		«««				«tripleSpace(5)»label="%initDiagramActionLabel"
		«««				«tripleSpace(5)»class="«xptInitDiagramFileAction.qualifiedClassName(diagram)»"
		«««				«tripleSpace(5)»menubarPath="additions"
		«««				«tripleSpace(5)»enablesFor="1"
		«««				«tripleSpace(5)»id="«plugin.ID».InitDiagramAction">
		«««				«tripleSpace(3)»</action>
		«««				«tripleSpace(2)»</objectContribution>
		«««				«tripleSpace(1)»</extension>
		«««				«ELSE»
		«««					«tripleSpace(1)»<extension point="org.eclipse.ui.actionSets" id="init-diagram-action">
		«««					«tripleSpace(2)»«xmlGeneratedTag()»
		«««					«tripleSpace(2)»<actionSet
		«««					«tripleSpace(4)»label="%initDiagramActionLabel"
		«««					«tripleSpace(4)»visible="true"
		«««					«tripleSpace(4)»id="«plugin.ID».InitDiagram">
		«««					«tripleSpace(3)»<action
		«««					«tripleSpace(5)»label="%initDiagramActionLabel"
		«««					«tripleSpace(5)»class="«xptInitDiagramFileAction.qualifiedClassName(diagram)»"
		«««					«tripleSpace(5)»menubarPath="file/additions"
		«««					«tripleSpace(5)»id="«plugin.ID».InitDiagramAction">
		«««					«tripleSpace(3)»</action>
		«««					«tripleSpace(2)»</actionSet>
		«««					«tripleSpace(1)»</extension>
		«««				«ENDIF»
		«««			«extraLineBreak» «tripleSpace(1)»
		«««				«ENDIF»
		«««				
			'''

	override outTab() {
		return '	';
	}
}
