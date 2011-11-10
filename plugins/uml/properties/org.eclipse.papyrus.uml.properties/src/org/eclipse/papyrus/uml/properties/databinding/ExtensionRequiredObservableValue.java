package org.eclipse.papyrus.uml.properties.databinding;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.uml2.uml.Extension;


public class ExtensionRequiredObservableValue extends AbstractObservableValue implements IChangeListener {

	private Extension extension;

	private MultiplicityObservableValue observable;

	private boolean currentValue;

	public ExtensionRequiredObservableValue(Extension extension, EditingDomain domain) {
		this.extension = extension;
		if(!this.extension.getOwnedEnds().isEmpty()) {
			observable = new MultiplicityObservableValue(this.extension.getOwnedEnds().get(0), domain);
			observable.addChangeListener(this);
		}
		currentValue = extension.isRequired();
	}

	public Object getValueType() {
		return Boolean.class;
	}

	@Override
	protected Boolean doGetValue() {
		return extension.isRequired();
	}

	@Override
	protected void doSetValue(Object value) {
		if(!(value instanceof Boolean)) {
			return;
		}

		Boolean required = (Boolean)value;

		if(extension.getOwnedEnds().isEmpty()) {
			Activator.log.warn("Unable to change the extension \"isRequired\" property");
		}

		observable.setValue(required ? MultiplicityObservableValue.ONE : MultiplicityObservableValue.OPTIONAL);
		currentValue = required;
	}

	@Override
	public void dispose() {
		observable.removeChangeListener(this);
		observable.dispose();
		observable = null;
		super.dispose();
	}

	public void handleChange(ChangeEvent event) {
		final boolean oldValue = currentValue;
		final boolean newValue = doGetValue();
		currentValue = newValue;
		fireValueChange(new ValueDiff() {

			@Override
			public Object getOldValue() {
				return oldValue;
			}

			@Override
			public Object getNewValue() {
				return newValue;
			}
		});
	}

}
