
/*
 * Copyright (c) 2007, 2009 Borland Software Corporation

 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Thibault Landre (Atos Origin) - add Papyrus dependencies to Papyrus GMF diagram*
 *	  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr : add the dependencyorg.eclipse.papyrus.infra.services.edit
 */
package aspects.xpt.plugin

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenPlugin
import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService
import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingReorientService
import xpt.Common

@Singleton class manifest extends xpt.plugin.manifest{

@Inject extension Common

override requireBundle(GenPlugin it)'''
Require-Bundle: org.eclipse.core.runtime,
«IF editorGen.application == null» org.eclipse.core.resources,
«ENDIF»
«IF editorGen.diagram.generateShortcutIcon() || (editorGen.navigator != null && editorGen.navigator.generateDomainModelNavigator)» org.eclipse.core.expressions,
«ENDIF» org.eclipse.jface,
«IF editorGen.application == null» org.eclipse.ui.ide,
«ENDIF» org.eclipse.ui.views,
«IF editorGen.navigator != null» org.eclipse.ui.navigator,
 org.eclipse.ui.navigator.resources,
«ENDIF» org.eclipse.emf.ecore,
 org.eclipse.emf.ecore.xmi,
 org.eclipse.emf.edit.ui,
 org.eclipse.gmf.runtime.emf.core,
 org.eclipse.gmf.runtime.emf.commands.core,
 org.eclipse.gmf.runtime.emf.ui.properties,
 org.eclipse.gmf.runtime.diagram.ui,
 org.eclipse.papyrus.uml.diagram.common,
 org.eclipse.papyrus.infra.gmfdiag.common,
 org.eclipse.papyrus.uml.service.types,
 org.eclipse.papyrus.infra.widgets,
«IF printingEnabled» org.eclipse.gmf.runtime.diagram.ui.printing,
 org.eclipse.gmf.runtime.diagram.ui.printing.render,
«ENDIF»
«IF editorGen.propertySheet != null» org.eclipse.gmf.runtime.diagram.ui.properties,
«ENDIF» org.eclipse.gmf.runtime.diagram.ui.providers,
«IF editorGen.application == null» org.eclipse.gmf.runtime.diagram.ui.providers.ide,
«ENDIF» org.eclipse.gmf.runtime.diagram.ui.render,
 org.eclipse.gmf.runtime.diagram.ui.resources.editor,
«IF editorGen.application == null» org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide,
«ENDIF»
«var reqPlugins = getAllRequiredPlugins()»
«IF !reqPlugins.contains('org.eclipse.gmf.tooling.runtime')»
«var notUsetBooleanVar = reqPlugins.add('org.eclipse.gmf.tooling.runtime')»
«ENDIF»
«FOR reqId : reqPlugins» «reqId»;visibility:=reexport,«extraLineBreak»
«ENDFOR» org.eclipse.gef,
 org.eclipse.papyrus.infra.gmfdiag.preferences,
 «IF it.eResource.allContents.filter(typeof (EditPartUsingDeleteService)).size != 0 || it.eResource.allContents.filter(typeof (EditPartUsingReorientService)).size != 0»,
 org.eclipse.papyrus.extensionpoints.editors,
 org.eclipse.papyrus.infra.services.edit
 «ELSE»
 org.eclipse.papyrus.extensionpoints.editors
«ENDIF»

'''

}