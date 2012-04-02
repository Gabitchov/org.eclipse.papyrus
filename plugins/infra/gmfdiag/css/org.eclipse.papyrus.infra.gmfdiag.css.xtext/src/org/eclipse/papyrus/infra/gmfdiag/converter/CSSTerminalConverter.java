package org.eclipse.papyrus.infra.gmfdiag.converter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;


public class CSSTerminalConverter extends DefaultTerminalConverters {

	@ValueConverter(rule = "HASH")
	public IValueConverter<String> HASH() {
		return new AbstractNullSafeConverter<String>() {

			@Override
			protected String internalToString(String value) {
				return '#' + value;
			}

			@Override
			protected String internalToValue(String string, INode node) throws ValueConverterException {
				return string.substring(1);
			}

		};
	}

	@ValueConverter(rule = "T_CLASS")
	public IValueConverter<String> T_CLASS() {
		return new AbstractNullSafeConverter<String>() {

			@Override
			protected String internalToString(String value) {
				return '.' + value;
			}

			@Override
			protected String internalToValue(String string, INode node) throws ValueConverterException {
				return string.substring(1);
			}

		};
	}

	@Override
	@ValueConverter(rule = "ID")
	public IValueConverter<String> ID() {
		return new AbstractNullSafeConverter<String>() {

			@Override
			protected String internalToString(String value) {
				return value;
			}

			@Override
			protected String internalToValue(String string, INode node) throws ValueConverterException {
				return string;
			}

		};
	}
}
