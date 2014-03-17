/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
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
package aspects.xpt.navigator

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorChildReference
import xpt.editor.VisualIDRegistry
import xpt.navigator.NavigatorGroup
import xpt.navigator.NavigatorItem

@Singleton class NavigatorLinkHelper extends xpt.navigator.NavigatorLinkHelper {

	@Inject NavigatorGroup navigatorGroup;
	@Inject NavigatorItem xptNavigatorItem;
	


	/**
	 * Linking with editor currently supported only for the navigators conteining top
	 * reference to the diagram. In this case diagram node will be selected in navigator.
 	*/
	override getDiagramSelection(GenNavigatorChildReference it) '''
		«IF it != null»
		«IF navigator != null»
		«IF navigator.editorGen != null»
		«getDiagram(navigator.editorGen)»
		if (diagram == null || diagram.eResource() == null) {
			return org.eclipse.jface.viewers.StructuredSelection.EMPTY;
		}
		org.eclipse.core.resources.IFile file = org.eclipse.emf.workspace.util.WorkspaceSynchronizer.getFile(diagram.eResource());
		if (file != null) {
			«IF isInsideGroup()»
				«navigatorGroup.qualifiedClassName(navigator)» parentGroup = new «navigatorGroup.
				qualifiedClassName(navigator)»("«groupName»", "«groupIcon»", «VisualIDRegistry::modelID(
			navigator.editorGen.diagram)», file);
			«ENDIF»
			«xptNavigatorItem.qualifiedClassName(navigator)» item = new «xptNavigatorItem.qualifiedClassName(navigator)»(diagram, «IF isInsideGroup()»parentGroup«ELSE»file«ENDIF», false);
			«IF isInsideGroup()»
				parentGroup.addChild(item);
			«ENDIF»
			return new org.eclipse.jface.viewers.StructuredSelection(«IF isInsideGroup()»parentGroup«ELSE»item«ENDIF»);
		}
		«ENDIF»
		«ENDIF»
		«ENDIF»
	'''

	

}
