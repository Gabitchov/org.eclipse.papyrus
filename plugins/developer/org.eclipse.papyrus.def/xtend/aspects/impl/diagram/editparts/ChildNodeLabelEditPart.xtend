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
package aspects.impl.diagram.editparts

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import xpt.diagram.editparts.Common

/**
 * Revisit: [MG]: @Inject extension same-named-api-class -> template extends api-class?
 */
@Singleton class ChildNodeLabelEditPart extends impl.diagram.editparts.ChildNodeLabelEditPart {
	@Inject extension Common;

	override handleNotificationEventBody(GenChildLabelNode it) '''
			Object feature = event.getFeature();
	«handleText(it)»
	«IF labelElementIcon»
		if(event.getNewValue() instanceof org.eclipse.emf.ecore.EAnnotation && org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants.DISPLAY_NAMELABELICON.equals(((org.eclipse.emf.ecore.EAnnotation)event.getNewValue()).getSource())){	
			refreshLabel();
		}
	«ENDIF»
	if (org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getFeature_IsStatic().equals(feature)) {
			refreshUnderline();
	}
	super.handleNotificationEvent(event);
	'''

}
