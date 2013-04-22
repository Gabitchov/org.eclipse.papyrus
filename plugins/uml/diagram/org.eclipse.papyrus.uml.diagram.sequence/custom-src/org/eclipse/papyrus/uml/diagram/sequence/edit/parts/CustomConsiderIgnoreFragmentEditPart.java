/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.lang.reflect.Field;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomConsiderIgnoreFragmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.util.NotificationHelper;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomConsiderIgnoreFragmentEditPart extends CustomCombinedFragmentEditPart {

	/**
	 * Notfier for listen and unlistend model element.
	 */
	private NotificationHelper notifier = null;

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomConsiderIgnoreFragmentEditPart(View view) {
		super(view);
	}

	/**
	 * Try to use the notifier from super class, if not exist, create new one.
	 */
	protected NotificationHelper getNotifier() {
		if(notifier == null) {
			try {
				Field f = ConsiderIgnoreFragmentEditPart.class.getDeclaredField("notifier");
				f.setAccessible(true);
				notifier = (NotificationHelper)f.get(this);
			} catch (Exception e) {
				notifier = new NotificationHelper(new UIAdapterImpl() {

					@Override
					protected void safeNotifyChanged(Notification msg) {
						handleNotificationEvent(msg);
					}
				});
			}
		}
		return notifier;
	}

	@Override
	protected NodeFigure createNodePlate() {
		String prefElementId = "ConsiderIgnoreFragment";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.HEIGHT);
		DefaultSizeNodeFigure result = new AnchorHelper.CombinedFragmentNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));
		return result;
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomConsiderIgnoreFragmentItemSemanticEditPolicy());
	}

	/**
	 * Handle for message
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		final NotificationHelper notifier = getNotifier();
		Object feature = notification.getFeature();
		if(UMLPackage.eINSTANCE.getConsiderIgnoreFragment_Message().equals(feature)) {
			// Handle message creation
			Object newValue = notification.getNewValue();
			// TODO Filter NamedElements type for message on higher level
			if(newValue == null || newValue instanceof Operation || newValue instanceof Reception || newValue instanceof Signal) {
				updateHeaderLabel();
				notifier.unlistenObject((Notifier)notification.getOldValue());
				notifier.listenObject((Notifier)notification.getNewValue());
			} else {
				ConsiderIgnoreFragment considerIgnoreFragment = (ConsiderIgnoreFragment)resolveSemanticElement();
				considerIgnoreFragment.getMessages().remove(newValue);
			}
		} else if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature)) {
			// Handle message modification
			updateHeaderLabel();
		}
		super.handleNotificationEvent(notification);
	}

	/**
	 * Update operator kind
	 */
	protected void updateHeaderLabel() {
		ConsiderIgnoreFragment considerIgnoreFragment = (ConsiderIgnoreFragment)resolveSemanticElement();
		StringBuilder operatorKind = new StringBuilder();
		operatorKind.append(considerIgnoreFragment.getInteractionOperator().getName());
		EList<NamedElement> messages = considerIgnoreFragment.getMessages();
		if(messages != null && messages.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < messages.size(); i++) {
				String name = messages.get(i).getName();
				if(name != null) {
					sb.append(name).append(",");
				}
			}
			if(sb.length() > 0) {
				operatorKind.append(" {").append(sb.deleteCharAt(sb.length() - 1).toString()).append("}");
			}
		}
		getPrimaryShape().getHeaderLabel().setText(operatorKind.toString());
	}

	/**
	 * Return true if the InteractionOperatorKind is allowed
	 * 
	 * @param interactionOperatorLiteral
	 *        The InteractionOperator to test
	 * @return true if allowed
	 */
	protected boolean isAllowedInteractionOperator(String interactionOperatorLiteral) {
		return InteractionOperatorKind.CONSIDER_LITERAL.getLiteral().equals(interactionOperatorLiteral) || InteractionOperatorKind.IGNORE_LITERAL.getLiteral().equals(interactionOperatorLiteral);
	}

	/**
	 * Activate a listener for the interactionUse to Handle notification in the refered Interaction
	 */
	@Override
	public void activate() {
		super.activate();
		final NotificationHelper notifier = getNotifier();
		ConsiderIgnoreFragment considerIgnoreFragment = (ConsiderIgnoreFragment)resolveSemanticElement();
		for(NamedElement message : considerIgnoreFragment.getMessages()) {
			notifier.listenObject(message);
		}
	}

	/**
	 * Deactivate a listener for the interactionUse to Handle notification in the refered
	 * Interaction
	 */
	@Override
	public void deactivate() {
		super.deactivate();
		if(notifier != null) {
			notifier.unlistenAll();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeNotify() {
		if(notifier != null) {
			notifier.unlistenAll();
		}
		super.removeNotify();
	}

	public String getTitlePreferenceKey() {
		return "ELEMENT_PapyrusUMLSequenceDiagram_ConsiderIgnoreFragment_CombinedFragmentCompartment.compartment_name.visibility";
	}
}
