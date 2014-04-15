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
import org.eclipse.gmf.codegen.gmfgen.GenNavigator
import xpt.Common
import xpt.navigator.Utils_qvto

@Singleton class NavigatorLinkHelper extends xpt.navigator.NavigatorLinkHelper {
	@Inject extension Common;
	@Inject extension Utils_qvto;

	
	override findSelection(GenNavigator it) '''
		«generatedMemberComment()»
		public org.eclipse.jface.viewers.IStructuredSelection findSelection(org.eclipse.ui.IEditorInput anInput) {
			«IF getDiagramTopReference(it) !=null»
			«defineDiagramDocument(editorGen.plugin)»
			«ENDIF»
			«findSelectionBody(it)»
		}
	'''
	
	override findSelectionBody(GenNavigator it) '''
		«IF getDiagramTopReference(it) !=null»
		«getDiagramSelection(getDiagramTopReference(it))»
		«ENDIF»
		return org.eclipse.jface.viewers.StructuredSelection.EMPTY;
	'''
}
