/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Nizar GUEDIDI (CEA LIST) - Update getUMLElement()
 *   
 */
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.uml.diagram.clazz.custom.preferences.IPapyrusInstancePreferencesConstant;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractMaskManagedEditPolicy;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.papyrus.uml.tools.utils.InstanceSpecificationUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The Class InstanceSpecificationNameLabelEditPolicy.
 */
public class InstanceSpecificationNameLabelEditPolicy extends AbstractMaskManagedEditPolicy {

	protected final Map<Integer, String> masks = new HashMap<Integer, String>(7);

	public InstanceSpecificationNameLabelEditPolicy() {
		super();
		masks.put(ICustomAppearence.DISP_NAME, "Name");
		masks.put(ICustomAppearence.DISP_TYPE, "Type");
	}

	@Override
	protected void addAdditionalListeners() {
		// TODO Auto-generated method stub
		super.addAdditionalListeners();
		Iterator<Classifier> iterator = getUMLElement().getClassifiers().iterator();
		while(iterator.hasNext()) {
			Classifier type = iterator.next();
			getDiagramEventBroker().addNotificationListener(type, this);
		}
	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub
		if(getUMLElement() != null) {
			Iterator<Classifier> iterator = getUMLElement().getClassifiers().iterator();
			while(iterator.hasNext()) {
				Classifier type = iterator.next();
				getDiagramEventBroker().removeNotificationListener(type, this);
			}
		}
		super.deactivate();
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy#getMaskLabel(int)
	 * 
	 * @param value
	 * @return
	 */
	public String getMaskLabel(int value) {
		return masks.get(value);
	}

	@Override
	public InstanceSpecification getUMLElement() {
		EObject element = super.getUMLElement();
		if(element instanceof InstanceSpecification) {
			return (InstanceSpecification)element;
		}
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy#getMaskLabels()
	 * 
	 * @return
	 */
	public Collection<String> getMaskLabels() {
		return masks.values();
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy#getMaskValues()
	 * 
	 * @return
	 */
	public Collection<Integer> getMaskValues() {
		return masks.keySet();
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy#getMasks()
	 * 
	 * @return
	 */
	public Map<Integer, String> getMasks() {
		return masks;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy#getCurrentDisplayValue()
	 * 
	 * @return
	 */
	public int getCurrentDisplayValue() {
		EAnnotation instanceDisplay = ((View)getHost().getModel()).getEAnnotation(VisualInformationPapyrusConstants.CUSTOM_APPEARENCE_ANNOTATION);
		int displayValue = getDefaultDisplayValue();
		if(instanceDisplay != null) {
			displayValue = Integer.parseInt(instanceDisplay.getDetails().get(VisualInformationPapyrusConstants.CUSTOM_APPEARANCE_MASK_VALUE));
		} else {
			// no specific information => look in preferences
			IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
			int displayValueTemp = store.getInt(IPapyrusInstancePreferencesConstant.INSTANCESPECIFICATION_LABEL_DISPLAY_PREFERENCE);
			if(displayValueTemp != 0) {
				displayValue = displayValueTemp;
			}
		}
		return displayValue;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy#getDefaultDisplayValue()
	 * 
	 * @return
	 */
	public int getDefaultDisplayValue() {
		return ICustomAppearence.DEFAULT_UML_INSTANCESPECIFICATION;
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		// change the label of the figure managed by the host edit part (managed by the parent edit
		// part in general...)
		// it must be changed only if:
		// - the annotation corresponding to the display of the stereotype changes
		// - the stereotype application list has changed
		Object object = notification.getNotifier();
		InstanceSpecification instance = getUMLElement();
		if(notification.getEventType() == Notification.ADD) {
			if(notification.getFeature().equals(UMLPackage.eINSTANCE.getInstanceSpecification_Classifier())) {
				getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), this);
			}
		}
		if(notification.getEventType() == Notification.REMOVE) {
			if(notification.getFeature().equals(UMLPackage.eINSTANCE.getInstanceSpecification_Classifier())) {
				getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
			}
		}
		if(object == null) {
			return;
		}
		if(notification.getFeature().equals(UMLPackage.eINSTANCE.getNamedElement_Name())) {
			refreshDisplay();
		} else if(notification.getFeature().equals(UMLPackage.eINSTANCE.getInstanceSpecification_Classifier())) {
			refreshDisplay();
		}
		if(isMaskManagedAnnotation(object)) {
			refreshDisplay();
		}
		if(isRemovedMaskManagedLabelAnnotation(object, notification)) {
			refreshDisplay();
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy#getPreferencePageID()
	 * 
	 * @return
	 */
	public String getPreferencePageID() {
		return "org.eclipse.papyrus.uml.diagram.clazz.custom.preferences.InstanceSpecificationPreferencePage";
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractMaskManagedEditPolicy#refreshDisplay()
	 * 
	 */
	@Override
	public void refreshDisplay() {
		// calls the helper for this edit Part
		if(getUMLElement() != null) {
			((WrappingLabel)((GraphicalEditPart)getHost()).getFigure()).setText(InstanceSpecificationUtil.getCustomLabel(getUMLElement(), getCurrentDisplayValue()));
			((WrappingLabel)((GraphicalEditPart)getHost()).getFigure()).setTextUnderline(true);
		}
	}
}
