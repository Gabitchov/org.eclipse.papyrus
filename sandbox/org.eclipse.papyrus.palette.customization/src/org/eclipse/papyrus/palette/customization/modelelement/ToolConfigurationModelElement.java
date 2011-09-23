package org.eclipse.papyrus.palette.customization.modelelement;

import java.util.LinkedList;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.palette.customization.creation.AspectActionEditionFactory;
import org.eclipse.papyrus.paletteconfiguration.ToolConfiguration;
import org.eclipse.papyrus.properties.modelelement.AbstractModelElement;
import org.eclipse.papyrus.widgets.creation.ReferenceValueFactory;
import org.eclipse.swt.graphics.Image;


public class ToolConfigurationModelElement extends AbstractModelElement {

	/**
	 * The aspectActions property
	 */
	public static final String ASPECT_ACTIONS = "aspectActions";

	/**
	 * The ToolConfiguration on which the IAspectActions are applied
	 */
	private ToolConfiguration toolConfiguration;

	public ToolConfigurationModelElement(ToolConfiguration toolConfiguration) {
		this.toolConfiguration = toolConfiguration;
	}

	@Override
	protected IObservable doGetObservable(String propertyPath) {
		if(propertyPath.equals(ASPECT_ACTIONS)) {
			//TODO : Retrieve the list of IAspectActions
			return new WritableList(new LinkedList<IAspectAction>(), IAspectAction.class);
		}

		//Unknown property
		return null;
	}

	@Override
	public boolean isOrdered(String propertyPath) {
		return propertyPath.equals(ASPECT_ACTIONS);
	}

	@Override
	public boolean isUnique(String propertyPath) {
		return false;
	}

	@Override
	public boolean getDirectCreation(String propertyPath) {
		return propertyPath.equals(ASPECT_ACTIONS);
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		return new LabelProvider() {

			@Override
			public String getText(Object element) {
				if(element instanceof IAspectAction) {
					return ((IAspectAction)element).getLabel();
				}
				return super.getText(element);
			}

			@Override
			public Image getImage(Object element) {
				if(element instanceof IAspectAction) {
					return ((IAspectAction)element).getImage();
				}
				return super.getImage(element);
			}
		};
	}

	@Override
	public ReferenceValueFactory getValueFactory(String propertyPath) {
		if(propertyPath.equals(ASPECT_ACTIONS)) {
			return new AspectActionEditionFactory();
		}

		return super.getValueFactory(propertyPath);
	}

}
