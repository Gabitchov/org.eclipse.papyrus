package org.eclipse.papyrus.properties.uml.modelelement;

import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.DISPLAY_PLACE;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.HORIZONTAL;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.ICON;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.SHAPE;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.STEREOTYPE_DISPLAY;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.TEXT;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.TEXT_ALIGNMENT;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.TEXT_AND_ICON;
import static org.eclipse.papyrus.properties.uml.util.StereotypeAppearanceConstants.VERTICAL;
import static org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant.STEREOTYPE_BRACE_LOCATION;
import static org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant.STEREOTYPE_COMMENT_LOCATION;
import static org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.properties.modelelement.AbstractModelElement;
import org.eclipse.papyrus.properties.modelelement.ModelElement;
import org.eclipse.papyrus.properties.uml.Activator;
import org.eclipse.papyrus.properties.uml.databinding.StereotypeAppearanceObservableValue;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.widgets.providers.StaticContentProvider;
import org.eclipse.uml2.uml.Element;

/**
 * A ModelElement for manipulating the stereotype appearance properties :
 * - stereotypeDisplay
 * - textAlignment
 * - displayPlace
 * 
 * @author Camille Letavernier
 * 
 */
public class StereotypeAppearanceModelElement extends AbstractModelElement implements ModelElement {

	/**
	 * The current UML Element
	 */
	protected Element umlSource;

	/**
	 * The editing domain on which the commands will be called
	 */
	protected EditingDomain domain;

	/**
	 * The GMF EModelElement
	 */
	protected EModelElement diagramElement;

	public StereotypeAppearanceModelElement(Element umlSource, EditingDomain domain, EModelElement diagramElement) {
		this.umlSource = umlSource;
		this.domain = domain;
		this.diagramElement = diagramElement;
	}

	public IObservable getObservable(String propertyPath) {
		if(propertyPath.equals(STEREOTYPE_DISPLAY) || propertyPath.equals(TEXT_ALIGNMENT) || propertyPath.equals(DISPLAY_PLACE)) {
			return new StereotypeAppearanceObservableValue(diagramElement, umlSource, propertyPath, domain);
		}

		Activator.log.warn("Unknown property : " + propertyPath);
		return null;
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		if(propertyPath.equals(STEREOTYPE_DISPLAY)) {
			return new StaticContentProvider(new String[]{ TEXT, ICON, TEXT_AND_ICON, SHAPE });
		} else if(propertyPath.equals(TEXT_ALIGNMENT)) {
			return new StaticContentProvider(new String[]{ HORIZONTAL, VERTICAL });
		} else if(propertyPath.equals(DISPLAY_PLACE)) {
			return new StaticContentProvider(new String[]{ STEREOTYPE_COMPARTMENT_LOCATION, STEREOTYPE_COMMENT_LOCATION, STEREOTYPE_BRACE_LOCATION });
		}

		return null;
	}

}
