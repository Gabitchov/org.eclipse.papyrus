package org.eclipse.papyrus.infra.widgets.databinding;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.papyrus.infra.widgets.providers.UnchangedObject;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;


public class TextObservableValue extends AbstractObservableValue implements Listener {

	private Text text;

	private int eventType;

	private Object currentValue;

	protected AggregatedObservable modelProperty;

	public TextObservableValue(Text text, IObservableValue modelProperty, int eventType) {
		this.text = text;
		this.eventType = eventType;
		if(modelProperty instanceof AggregatedObservable) {
			this.modelProperty = (AggregatedObservable)modelProperty;
		}
		this.text.addListener(eventType, this);
	}

	public TextObservableValue(Realm realm) {
		super(realm);
	}

	public Object getValueType() {
		return String.class;
	}

	@Override
	protected Object doGetValue() {
		if(UnchangedObject.instance.toString().equals(text.getText())) {
			return null;
		} else {
			return text.getText();
		}
	}

	@Override
	protected void doSetValue(Object value){
		if(modelProperty != null && modelProperty.hasDifferentValues()) {
			this.text.setText(UnchangedObject.instance.toString());
			this.currentValue = UnchangedObject.instance;
		} else {
			if(value instanceof String) {
				this.text.setText((String)value);
				this.currentValue = value;
			} else if(value == null) {
				this.text.setText(""); //$NON-NLS-1$
				this.currentValue = null;
			}
		}
	}

	public void handleEvent(Event event) {

		final Object oldValue = currentValue;
		final Object newValue = getValue();
		if(newValue == null) {
			return;
		}
		currentValue = newValue;

		if((eventType & event.type) != 0) {
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

}
