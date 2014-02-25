package aspects.xpt.plugin

import aspects.xpt.editor.palette.Utils_qvto
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.AbstractToolEntry
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenPlugin
import org.eclipse.gmf.codegen.gmfgen.ToolEntry
import org.eclipse.gmf.codegen.gmfgen.ToolGroup
import utils.PrefsConstant_qvto
import xpt.Common
import xpt.editor.extensions
import xpt.plugin.pluginUtils

@Singleton class plugin extends xpt.plugin.plugin {

	@Inject extension Common
	@Inject extension pluginUtils
	@Inject extension Utils_qvto
	@Inject extension PrefsConstant_qvto

	@Inject extensions xptEditorExtension
	@Inject xpt.diagram.preferences.extensions xptPreferencesExtension
	@Inject xpt.propsheet.extensions xptPropsheetExtension
	@Inject xpt.navigator.extensions xptNavigatorExtension
	@Inject xpt.application.extensions xptApplicationExtension
	@Inject xpt.diagram.updater.extensions xptUpdaterExtension
	@Inject impl.actions.extensions xptActionExtension
	@Inject xpt.providers.extensions xptProvidersExtension

	override plugin(GenPlugin it) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<?eclipse version="3.0"?>
		«xcopyright(it.editorGen)»
		<plugin>
		««««fileTypes()»
		««««extension_parser()»
		«xptEditorExtension.extensions(it.editorGen)»
		«««global actions handled in the diagram.common plugin
		««««pluginMenu()»
		«validation(it.editorGen.diagram)»
		«IF it.editorGen.metrics != null»«metrics(it.editorGen.metrics)»«ENDIF»
		«««RS: redefine palette generation
		«palettePredefinedEntries(editorGen)»
		«paletteEntries(editorGen)»
		«xptPreferencesExtension.extensions(it.editorGen.diagram)»
		«IF it.editorGen.propertySheet != null»«xptPropsheetExtension.extensions(it.editorGen.propertySheet)»«ENDIF»
		«xptProvidersExtension.extensions(it.editorGen.diagram)»
		«IF it.editorGen.navigator != null»«xptNavigatorExtension.extensions(it.editorGen.navigator)»«ENDIF»
		«IF it.editorGen.application != null»«xptApplicationExtension.extensions(it.editorGen.application)»«ENDIF»
		«extensionsConstraintProviders(it.editorGen)»
		«xptUpdaterExtension.extensions(it.editorGen.diagramUpdater)»
		«xptActionExtension.Main(it.editorGen)»
		«additions(it)»
		</plugin>
	'''

	override additions(GenPlugin it) ''''''

	//	def category(GenDiagram it) '''«getDiagramPreferencePageCategory()».«editorGen.modelID»'''

	//RS: redefine palette generation, using predefined entries
	def palettePredefinedEntries(GenEditorGenerator it) '''
		«xmlGeneratedTag»
		<extension
			id="«plugin.name».palettedefinition"
			name="«plugin.name» Predefined Entries"
			point="org.eclipse.gmf.runtime.diagram.ui.paletteProviders"> 
			
			«xmlGeneratedTag»	
			<paletteProvider class="org.eclipse.gmf.runtime.diagram.ui.providers.DefaultPaletteProvider">
				<Priority name="Lowest"/>
				   		<contribution
				   		    	factoryClass="«it.diagram.palette.packageName».«it.diagram.palette.factoryClassName»">
				   		<predefinedEntry id="standardGroup/noteStack/noteTool" remove="true"/> 
				<predefinedEntry id="standardGroup/noteStack/textTool" remove="true"/> 
				<predefinedEntry id="standardGroup/noteStack/noteattachmentTool" remove="true"/>
				
				«FOR tool : collectTools(diagram.palette)»
					«predefinedEntryDefinition(tool)»
				«ENDFOR»
				
				</contribution>
			</paletteProvider>	
				
		</extension>
	'''

	//RS: redefine palette generation, using predefined entries
	def paletteEntries(GenEditorGenerator it) '''
		«xmlGeneratedTag»
		<extension
			id="«plugin.name».standard"
			name="«plugin.name» Standard Palette"
			point="org.eclipse.gmf.runtime.diagram.ui.paletteProviders"> 
			
			«xmlGeneratedTag»	
			<paletteProvider class="org.eclipse.gmf.runtime.diagram.ui.providers.DefaultPaletteProvider">
				<Priority name="Low"/>
				   		<contribution
				   		    	factoryClass="«it.diagram.palette.packageName».«it.diagram.palette.factoryClassName»">
				   		<predefinedEntry id="standardGroup/noteStack/noteTool" remove="true"/> 
				<predefinedEntry id="standardGroup/noteStack/textTool" remove="true"/> 
				<predefinedEntry id="standardGroup/noteStack/noteattachmentTool" remove="true"/>
				
				«FOR tool : collectGroups(diagram.palette)»
					«groupUsage(tool)»
				«ENDFOR»
				</contribution>
				<editor id="«plugin.ID»"/>
			</paletteProvider>	
				
		</extension>
	'''

	def groupUsage(ToolGroup it) '''
		<entry
		      description="«it.description»"
		      id=«IF isQuoted(id,'"')»«id»«ELSE»"«id»"«ENDIF»
		      kind="drawer"
		      label="«it.title»"
		      large_icon="«largeIconPath»"
		      path="/"
		      small_icon="«smallIconPath»">
		      <expand
		             force="true">
		      </expand>
			</entry>
			««« TODO: call sub entries... 
 	«FOR entry : it.entries»
			«toolUsage(entry as ToolEntry, it)»
		«ENDFOR»
	'''

	def toolUsage(ToolEntry it, ToolGroup group) '''
		<predefinedEntry
		        id=«IF isQuoted(id,'"')»«id»«ELSE»"«id»"«ENDIF»
		        path="«getToolPath(group.id)»">
		  </predefinedEntry>
	'''

	def predefinedEntryDefinition(AbstractToolEntry it) '''
		<entry
		      defineOnly="true"
		      description="«it.description»"
		      id=«IF isQuoted(id,'"')»«id»«ELSE»"«id»"«ENDIF»
		      kind="tool"
		      label="«it.title»"
		      large_icon="«largeIconPath»"
		      path=""
		      small_icon="«smallIconPath»">
			</entry>
	'''
}
