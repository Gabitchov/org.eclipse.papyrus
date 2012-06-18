package org.eclipse.papyrus.infra.widgets.databinding;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.widgets.providers.UnchangedObject;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;


/**
 * An ObservableValue for Text field, with support for AggregatedObservable
 * 
 * @author Camille Letavernier
 */
public class TextObservableValue extends AbstractObservableValue implements Listener {

	private Text text;

	private int eventType;

	private Object currentValue;

	/**
	 * If the Text field may represent more than one value,
	 * use an AggregatedObservable
	 * 
	 * May be null
	 */
	protected AggregatedObservable modelProperty;

	/**
	 * Constructor
	 * 
	 * @param text
	 *        The Text field to observe
	 * @param modelProperty
	 *        The model IObservableValue
	 * @param eventType
	 *        The eventType to listen to. When the event is fired by the Text
	 *        widget, this IObservableValue will fire a ChangeEvent
	 */
	public TextObservableValue(Text text, IObservableValue modelProperty, int eventType) {
		this.text = text;
		this.eventType = eventType;
		if(modelProperty instanceof AggregatedObservable) {
			this.modelProperty = (AggregatedObservable)modelProperty;
		}
		this.text.addListener(eventType, this);
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
	protected void doSetValue(Object value) {
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
