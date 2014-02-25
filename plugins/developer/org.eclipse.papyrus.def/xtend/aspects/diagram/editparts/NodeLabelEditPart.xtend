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
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel
import xpt.Common

//DOCUMENTATION: PapyrusGenCode
//add in the addition codes in order to refresh the labels
@Singleton class NodeLabelEditPart extends diagram.editparts.NodeLabelEditPart {
	@Inject extension Common;

	@Inject impl.diagram.editparts.NodeLabelEditPart xptNodeLabelEditPart;



//BEGIN: PapyrusGenCode
//Definition of the inheritance
override extendsList (GenNodeLabel it) '''extends org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusCompartmentEditPart'''
//END: PapyrusGenCode

	override handleNotificationEvent(GenNodeLabel it) '''
		«generatedMemberComment»
		protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification event) {
			refreshLabel();
			«xptNodeLabelEditPart.handleNotificationEventBody(it)»
		}
	'''
	
	override additions(GenNodeLabel it) '''
	«««	Code to refresh icon
	
	«generatedMemberComment»
	private static final String ADD_PARENT_MODEL = "AddParentModel";
	
		
	«generatedMemberComment»
		public void activate() {
			super.activate();
			addOwnerElementListeners();
		}
	
		«generatedMemberComment»
		protected void addOwnerElementListeners() {
			addListenerFilter(ADD_PARENT_MODEL, this, ((org.eclipse.gmf.runtime.notation.View) getParent().getModel())); //$NON-NLS-1$
	
		}
	
		«generatedMemberComment»
		public void deactivate() {
			removeOwnerElementListeners();
			super.deactivate();
	
		}
	
	
		«generatedMemberComment»
		protected void removeOwnerElementListeners() {
			removeListenerFilter(ADD_PARENT_MODEL);
	
		}
	
	«««END: PapyrusGenCode
	'''
}
