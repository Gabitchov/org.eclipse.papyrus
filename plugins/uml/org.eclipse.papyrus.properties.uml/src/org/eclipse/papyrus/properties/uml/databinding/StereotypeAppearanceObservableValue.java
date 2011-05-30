package org.eclipse.papyrus.properties.uml.databinding;

import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.DISPLAY_PLACE;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.HORIZONTAL;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.ICON;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.SHAPE;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.STEREOTYPE_DISPLAY;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.TEXT;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.TEXT_ALIGNMENT;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.TEXT_AND_ICON;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.VERTICAL;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.properties.uml.Activator;
import org.eclipse.papyrus.umlutils.ElementUtil;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


public class StereotypeAppearanceObservableValue extends AbstractObservableValue {

	protected String propertyPath;

	protected Element element;

	protected EModelElement diagramElement;

	protected TransactionalEditingDomain domain;

	public StereotypeAppearanceObservableValue(EModelElement diagramElement, Element element, String propertyPath, EditingDomain domain) {
		this.propertyPath = propertyPath;
		this.diagramElement = diagramElement;
		this.element = element;
		this.domain = (TransactionalEditingDomain)domain;
	}

	public Object getValueType() {
		return String.class;
	}

	@Override
	protected String doGetValue() {
		if(propertyPath.equals(STEREOTYPE_DISPLAY)) {
			return getStereotypeDisplayValue();
		} else if(propertyPath.equals(TEXT_ALIGNMENT)) {
			return getTextAlignmentValue();
		} else if(propertyPath.equals(DISPLAY_PLACE)) {
			return getDisplayPlaceValue();
		}

		return null;
	}

	private String getStereotypeDisplayValue() {
		final String stereotypePresentation = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);

		if(stereotypePresentation != null) {

			Element element = (Element)((View)(diagramElement)).getElement();
			// get the first displayed stereotype
			Stereotype stereotype = AppliedStereotypeHelper.getFirstDisplayedStereotype(diagramElement, element);

			boolean hasIcons = ElementUtil.hasIcons(element, stereotype);
			boolean hasShapes = ElementUtil.hasShapes(element, stereotype);
			if(stereotypePresentation.equals(VisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION) && hasIcons) {
				return ICON;
			} else if(stereotypePresentation.equals(VisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION) && hasIcons) {
				return TEXT_AND_ICON;
			} else if(stereotypePresentation.equals(VisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION) && hasShapes) {
				return SHAPE;
			} else {
				return TEXT;
			}

		} else {
			return TEXT;
		}
	}

	private String getTextAlignmentValue() {
		final String stereotypePresentation = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);

		if(stereotypePresentation != null) {
			if(stereotypePresentation.equals(VisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION)) {
				return HORIZONTAL;
			} else if(stereotypePresentation.equals(VisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION)) {
				return VERTICAL;
			} else {
				return HORIZONTAL;
			}

		} else {
			return HORIZONTAL;
		}
	}

	private String getDisplayPlaceValue() {
		if(diagramElement != null) {
			return AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization(diagramElement);
		} else {
			return null;
		}
	}

	@Override
	protected void doSetValue(Object value) {
		if(value instanceof String) {
			String stringValue = (String)value;

			if(propertyPath.equals(STEREOTYPE_DISPLAY)) { //Edition of the stereotypeDisplay property
				setStereotypeDisplayValue(stringValue);
			} else if(propertyPath.equals(TEXT_ALIGNMENT)) { //Edition of the textAlignment property
				setTextAlignmentValue(stringValue);
			} else if(propertyPath.equals(DISPLAY_PLACE)) { //Edition of the displayPlace property
				setDisplayPlaceValue(stringValue);
			}
		} else {
			Activator.log.warn("The value " + value + " is invalid for property " + propertyPath); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	private void setStereotypeDisplayValue(String stereotypeAppearance) {
		// get the first displayed stereotype
		Stereotype stereotype = AppliedStereotypeHelper.getFirstDisplayedStereotype(diagramElement, element);
		boolean hasIcons = ElementUtil.hasIcons(element, stereotype);
		boolean hasShapes = ElementUtil.hasShapes(element, stereotype);
		String appliedStereotypeKind = VisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;

		if(stereotypeAppearance.equals(TEXT)) {
			appliedStereotypeKind = VisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;
		} else if(stereotypeAppearance.equals(ICON) && hasIcons) {
			appliedStereotypeKind = VisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION;
		} else if(stereotypeAppearance.equals(TEXT_AND_ICON) && hasIcons) {
			appliedStereotypeKind = VisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION;
		} else if(stereotypeAppearance.equals(SHAPE) && hasShapes) {
			appliedStereotypeKind = VisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION;
		}


		String stereotypetoDisplay = AppliedStereotypeHelper.getStereotypesToDisplay(diagramElement);
		RecordingCommand command = AppliedStereotypeHelper.getAppliedStereotypeToDisplayCommand(domain, diagramElement, stereotypetoDisplay, appliedStereotypeKind);
		domain.getCommandStack().execute(command);

	}

	private void setTextAlignmentValue(String alignment) {
		String appliedStereotypeKind = VisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;
		if(alignment.equals(HORIZONTAL)) {
			appliedStereotypeKind = VisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;
		} else if(alignment.equals(VERTICAL)) {
			appliedStereotypeKind = VisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION;
		}


		String stereotypetoDisplay = AppliedStereotypeHelper.getStereotypesToDisplay(diagramElement);
		RecordingCommand command = AppliedStereotypeHelper.getAppliedStereotypeToDisplayCommand(domain, diagramElement, stereotypetoDisplay, appliedStereotypeKind);
		domain.getCommandStack().execute(command);

	}

	private void setDisplayPlaceValue(String stereotypePlacePresentation) {
		RecordingCommand command = AppliedStereotypeHelper.getSetAppliedStereotypePropertiesLocalizationCommand(domain, diagramElement, stereotypePlacePresentation);
		domain.getCommandStack().execute(command);
	}

}
