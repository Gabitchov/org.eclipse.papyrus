/**
 * Copyright (c) 2006, 2009 Borland Software Corporation
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
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import xpt.diagram.editparts.Common

//DOCUMENTATION: PapyrusGenCode
//Overload only the creation of editPolicies in order to add the paste edit policy
@Singleton class CompartmentEditPart extends impl.diagram.editparts.CompartmentEditPart {

	@Inject Common xptEditpartsCommon;



		override createDefaultEditPoliciesBody(GenCompartment it) '''
		super.createDefaultEditPolicies();
		«IF canCollapse»
			installEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy());
		«ENDIF»
		«xptEditpartsCommon.installSemanticEditPolicy(it)»
		«IF ! childNodes.empty»
			installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CREATION_ROLE, new org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy());
			installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.DRAG_DROP_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy());
			installEditPolicy(org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy.PASTE_ROLE, new org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy());
		«ENDIF»
		«xptEditpartsCommon.installCanonicalEditPolicy(it)»
		«xptEditpartsCommon.behaviour(it)»
	'''

}
