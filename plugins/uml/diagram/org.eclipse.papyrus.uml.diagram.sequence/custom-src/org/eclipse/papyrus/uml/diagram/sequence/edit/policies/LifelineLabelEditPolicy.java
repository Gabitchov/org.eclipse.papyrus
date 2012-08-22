package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractMaskManagedEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.preferences.LifelinePreferencePage;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineLabelHelper;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;


public class LifelineLabelEditPolicy  extends AbstractMaskManagedEditPolicy {

	private IPropertyChangeListener preferenceListener;

	@Override
	public void addAdditionalListeners() {
		super.addAdditionalListeners();
		
		if(preferenceListener == null){
			preferenceListener = new IPropertyChangeListener() {

				public void propertyChange(PropertyChangeEvent event) {
					handlePreferenceChange(event);
				}				
			};
			IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
			store.addPropertyChangeListener(this.preferenceListener);
		}

		Lifeline lifeline = getUMLElement();
		// check host semantic element is not null
		if(lifeline == null) {
			return;
		}
		// adds a listener to the element itself, and to linked elements, like Type
		getDiagramEventBroker().addNotificationListener(lifeline, this);
	}
	
	protected void handlePreferenceChange(PropertyChangeEvent event) {
		EditPart part = getHost();
		if(part == null || part.getParent() == null)
			return;
		
		String key = event.getProperty();
		if(key.equals(LifelinePreferencePage.LABEL_DISPLAY_PREFERENCE)){
			refreshDisplay();
		}
	}

	@Override
	protected void removeAdditionalListeners() {
		super.removeAdditionalListeners();
		Lifeline lifeline = getUMLElement();
		// check host semantic element is not null
		if(lifeline == null) {
			return;
		}
		getDiagramEventBroker().removeNotificationListener(lifeline, this);
	}
	
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);

		Object object = notification.getNotifier();
		if(object == null) {
			return;
		}
		
		if(notification.getFeature().equals(UMLPackage.eINSTANCE.getNamedElement_Name())) {
			refreshDisplay();
		} else if(notification.getFeature().equals(UMLPackage.Literals.LIFELINE__REPRESENTS)) {
			refreshDisplay();
		}

		if(isMaskManagedAnnotation(object)) {
			refreshDisplay();
		}

		if(isRemovedMaskManagedLabelAnnotation(object, notification)) {
			refreshDisplay();
		}
	}

	
	public void refreshDisplay() {
		// calls the helper for this edit Part
		LifelineEditPart lp = (LifelineEditPart)getHost();
		List children = lp.getChildren();
		for(Object p : children)
			if(p  instanceof LifelineNameEditPart)
				LifelineLabelHelper.getInstance().refreshEditPartDisplay((GraphicalEditPart)p);
	}	

	public int getCurrentDisplayValue() {
		EAnnotation customeDisplayAnnotation = ((View)getHost().getModel()).getEAnnotation(VisualInformationPapyrusConstants.CUSTOM_APPEARENCE_ANNOTATION);
		int displayValue = getDefaultDisplayValue();
		if(customeDisplayAnnotation != null && customeDisplayAnnotation.getDetails().get(VisualInformationPapyrusConstants.CUSTOM_APPEARANCE_MASK_VALUE) != null) {
			displayValue = Integer.parseInt(customeDisplayAnnotation.getDetails().get(VisualInformationPapyrusConstants.CUSTOM_APPEARANCE_MASK_VALUE));
		} else {
			// no specific information => look in preferences
			IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
			int displayValueTemp = store.getInt(LifelinePreferencePage.LABEL_DISPLAY_PREFERENCE);
			if(displayValueTemp != 0) {
				displayValue = displayValueTemp;
			}
		}
		return displayValue;
	}

	public int getDefaultDisplayValue() {
		return LifelinePreferencePage.DEFAULT_LABEL_DISPLAY;
	}

	public String getMaskLabel(int value) {
		return LifelineLabelHelper.getInstance().getMaskLabel(value);
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<String> getMaskLabels() {
		return LifelineLabelHelper.getInstance().getMaskLabels();
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<Integer, String> getMasks() {
		return LifelineLabelHelper.getInstance().getMasks();
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<Integer> getMaskValues() {
		return LifelineLabelHelper.getInstance().getMaskValues();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPreferencePageID() {
		return "org.eclipse.papyrus.uml.diagram.sequence.preferences.LifelinePreferencePage";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Lifeline getUMLElement() {
		return (Lifeline)hostSemanticElement;
	}	
	
}
