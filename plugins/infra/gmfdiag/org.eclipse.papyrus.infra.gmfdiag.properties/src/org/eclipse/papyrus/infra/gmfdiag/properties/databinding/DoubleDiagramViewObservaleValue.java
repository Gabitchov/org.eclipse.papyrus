package org.eclipse.papyrus.infra.gmfdiag.properties.databinding;

import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * 
 * Class used to edit double preferences
 * 
 */
public class DoubleDiagramViewObservaleValue extends AbstractDiagramPreferencesObservableValue {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param diagram
	 *        the edited diagram
	 * @param preferenceName
	 *        the edited preference
	 * @param store
	 *        the edited preference store
	 */
	public DoubleDiagramViewObservaleValue(final Diagram diagram, final String preferenceName, final IPreferenceStore store) {
		super(diagram, preferenceName, store);
	}

	/**
	 * 
	 * @see org.eclipse.core.databinding.observable.value.IObservableValue#getValueType()
	 * 
	 * @return
	 */
	public final Object getValueType() {
		return EcorePackage.eINSTANCE.getEFloat();
	}

	/**
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doGetValue()
	 * 
	 * @return
	 */
	@Override
	protected Object doGetValue() {
		final IPreferenceStore wsPreferenceStore = getEditedPreferenceStore();
		return wsPreferenceStore.getDouble(getEditedPreference());
	}

	/**
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doSetValue(java.lang.Object)
	 * 
	 * @param value
	 */
	@Override
	protected void doSetValue(final Object value) {
		if(value instanceof Float) {
			final IPreferenceStore wsPreferenceStore = getEditedPreferenceStore();
			final double oldValue = (Double)doGetValue();
			wsPreferenceStore.setValue(getEditedPreference(), ((Float)value).doubleValue());
			final ValueDiff diff = new ValueDiff() {

				@Override
				public Object getOldValue() {
					return oldValue;
				}

				@Override
				public Object getNewValue() {
					return ((Float)value).doubleValue();
				}
			};
			fireValueChange(diff);
		}
	}




}
