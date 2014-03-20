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
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel
import org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference
import xpt.Common

@Singleton class LinkLabelEditPart extends diagram.editparts.LinkLabelEditPart{
	@Inject extension Common;


	override implementsList(GenLinkLabel it) '''
	implements org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart
	«««	BEGIN: PapyrusGenCode
	«IF it.eResource.allContents.filter(typeof (LabelVisibilityPreference)).filter[v |v.externalNodeLabels.contains(it)].size != 0»
	, org.eclipse.papyrus.uml.diagram.common.editparts.ILabelRoleProvider
	«ENDIF»
	«««	END: PapyrusGenCode
	'''


	override additions(GenLinkLabel it) '''
	«««	BEGIN: PapyrusGenCode
	«IF it.eResource.allContents.filter(typeof (LabelVisibilityPreference)).filter[v | v.externalNodeLabels.contains(it)].size != 0»
		«generatedClassComment»
		public String getLabelRole(){
		return "«it.eResource.allContents.filter(typeof (LabelVisibilityPreference)).filter[v |v.externalNodeLabels.contains(it)].head.role»";//$NON-NLS-1$
		}
		
		«generatedClassComment»
		public String getIconPathRole(){
		return "«it.eResource.allContents.filter(typeof (LabelVisibilityPreference)).filter[v |v.externalNodeLabels.contains(it)].head.iconPathRole»";//$NON-NLS-1$
		}
	«ENDIF»
	«««	END: PapyrusGenCode
	'''
	
	override extendsList(GenLinkLabel it) '''extends org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusLabelEditPart'''
}
