package org.eclipse.papyrus.infra.widgets.editors;

import java.util.Locale;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.conversion.StringToNumberConverter;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.swt.widgets.Composite;

import com.ibm.icu.text.NumberFormat;

public class LongEditor extends StringEditor {

	private IConverter targetToModelConverter;

	/**
	 * 
	 * Constructs an Editor for a Long value. The widget is a Text field.
	 * 
	 * @param parent
	 *        The Composite in which the editor is created
	 * @param style
	 *        The Text's style
	 */
	public LongEditor(Composite parent, int style) {
		super(parent, style);

		targetToModelConverter = StringToNumberConverter.toLong(NumberFormat.getInstance(Locale.ENGLISH), true);
		setConverters(targetToModelConverter, NumberToStringConverter.fromLong(NumberFormat.getInstance(Locale.ENGLISH), true));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getEditableType() {
		return Long.class;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getValue() {
		try {
			return (Long)targetToModelConverter.convert(super.getValue());
		} catch (Exception ex) {
			Activator.log.error(ex);
			return null;
		}
	}
}
