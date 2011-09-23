package org.eclipse.papyrus.palette.customization.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.papyrus.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.properties.modelelement.AbstractModelElement;


public class AspectActionModelElement extends AbstractModelElement {

	protected IAspectAction action;

	public AspectActionModelElement(IAspectAction action) {
		this.action = action;
	}

	@Override
	protected IObservable doGetObservable(String propertyPath) {
		return new AbstractObservableValue() {

			public Object getValueType() {
				return IAspectAction.class;
			}

			@Override
			protected Object doGetValue() {
				return action;
			}

		};
	}

}
