/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.parsers;

import java.util.Arrays;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.diagram.timing.part.Messages;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public abstract class AbstractParser implements IParser {

	/**
	 * @generated
	 */
	protected final EAttribute[] features;

	/**
	 * @generated
	 */
	protected final EAttribute[] editableFeatures;

	/**
	 * @generated
	 */
	private String viewPattern;

	/**
	 * @generated
	 */
	private String editorPattern;

	/**
	 * @generated
	 */
	private String editPattern;

	/**
	 * @generated
	 */
	public AbstractParser(final EAttribute[] features) {
		if (features == null || Arrays.asList(features).contains(null)) {
			throw new IllegalArgumentException();
		}
		this.editableFeatures = this.features = features;
	}

	/**
	 * @generated
	 */
	public AbstractParser(final EAttribute[] features, final EAttribute[] editableFeatures) {
		if (features == null || Arrays.asList(features).contains(null)) {
			throw new IllegalArgumentException();
		}
		this.features = features;
		if (editableFeatures == null || Arrays.asList(editableFeatures).contains(null)) {
			throw new IllegalArgumentException();
		}
		this.editableFeatures = editableFeatures;
	}

	/**
	 * @generated
	 */
	public String getViewPattern() {
		return this.viewPattern;
	}

	/**
	 * @generated
	 */
	public void setViewPattern(final String viewPattern) {
		this.viewPattern = viewPattern;
	}

	/**
	 * @generated
	 */
	public String getEditorPattern() {
		return this.editorPattern;
	}

	/**
	 * @generated
	 */
	public void setEditorPattern(final String editorPattern) {
		this.editorPattern = editorPattern;
	}

	/**
	 * @generated
	 */
	public String getEditPattern() {
		return this.editPattern;
	}

	/**
	 * @generated
	 */
	public void setEditPattern(final String editPattern) {
		this.editPattern = editPattern;
	}

	/**
	 * @generated
	 */
	public boolean isAffectingEvent(final Object event, final int flags) {
		if (event instanceof Notification) {
			return isAffectingFeature(((Notification) event).getFeature());
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean isAffectingFeature(final Object feature) {
		for (final EAttribute feature2 : this.features) {
			if (feature2 == feature) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public IContentAssistProcessor getCompletionProcessor(final IAdaptable element) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Object[] getValues(final EObject element) {
		final Object[] values = new Object[this.features.length];
		for (int i = 0; i < this.features.length; i++) {
			values[i] = getValue(element, this.features[i]);
		}
		return values;
	}

	/**
	 * @generated
	 */
	protected Object[] getEditableValues(final EObject element) {
		final Object[] values = new Object[this.editableFeatures.length];
		for (int i = 0; i < this.editableFeatures.length; i++) {
			values[i] = getValue(element, this.editableFeatures[i]);
		}
		return values;
	}

	/**
	 * @generated
	 */
	protected Object getValue(final EObject element, final EAttribute feature) {
		Object value = element.eGet(feature);
		final Class iClass = feature.getEAttributeType().getInstanceClass();
		if (String.class.equals(iClass)) {
			if (value == null) {
				value = ""; //$NON-NLS-1$
			}
		}
		return value;
	}

	/**
	 * @generated
	 */
	protected ICommand getParseCommand(final IAdaptable adapter, final Object[] values, final int flags) {
		if (values == null || validateNewValues(values).getCode() != IParserEditStatus.EDITABLE) {
			return UnexecutableCommand.INSTANCE;
		}
		final EObject element = (EObject) adapter.getAdapter(EObject.class);
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
		if (editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		final CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Values"); //$NON-NLS-1$
		for (int i = 0; i < values.length; i++) {
			command.compose(getModificationCommand(element, this.editableFeatures[i], values[i]));
		}
		return command;
	}

	/**
	 * @generated
	 */
	protected ICommand getModificationCommand(final EObject element, final EAttribute feature, Object value) {
		value = getValidNewValue(feature, value);
		if (value instanceof InvalidValue) {
			return UnexecutableCommand.INSTANCE;
		}
		final SetRequest request = new SetRequest(element, feature, value);
		return new SetValueCommand(request);
	}

	/**
	 * @generated
	 */
	protected IParserEditStatus validateNewValues(final Object[] values) {
		if (values.length != this.editableFeatures.length) {
			return ParserEditStatus.UNEDITABLE_STATUS;
		}
		for (int i = 0; i < values.length; i++) {
			final Object value = getValidNewValue(this.editableFeatures[i], values[i]);
			if (value instanceof InvalidValue) {
				return new ParserEditStatus(UMLDiagramEditorPlugin.ID, IParserEditStatus.UNEDITABLE, value.toString());
			}
		}
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * @generated
	 */
	protected Object getValidNewValue(final EAttribute feature, Object value) {
		final EClassifier type = feature.getEType();
		if (type instanceof EDataType) {
			final Class iClass = type.getInstanceClass();
			if (Boolean.TYPE.equals(iClass)) {
				if (value instanceof Boolean) {
					// ok
				} else if (value instanceof String) {
					value = Boolean.valueOf((String) value);
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Character.TYPE.equals(iClass)) {
				if (value instanceof Character) {
					// ok
				} else if (value instanceof String) {
					final String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						value = new Character(s.charAt(0));
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Byte.TYPE.equals(iClass)) {
				if (value instanceof Byte) {
					// ok
				} else if (value instanceof Number) {
					value = new Byte(((Number) value).byteValue());
				} else if (value instanceof String) {
					final String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Byte.valueOf(s);
						} catch (final NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Short.TYPE.equals(iClass)) {
				if (value instanceof Short) {
					// ok
				} else if (value instanceof Number) {
					value = new Short(((Number) value).shortValue());
				} else if (value instanceof String) {
					final String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Short.valueOf(s);
						} catch (final NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Integer.TYPE.equals(iClass)) {
				if (value instanceof Integer) {
					// ok
				} else if (value instanceof Number) {
					value = new Integer(((Number) value).intValue());
				} else if (value instanceof String) {
					final String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Integer.valueOf(s);
						} catch (final NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Long.TYPE.equals(iClass)) {
				if (value instanceof Long) {
					// ok
				} else if (value instanceof Number) {
					value = new Long(((Number) value).longValue());
				} else if (value instanceof String) {
					final String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Long.valueOf(s);
						} catch (final NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Float.TYPE.equals(iClass)) {
				if (value instanceof Float) {
					// ok
				} else if (value instanceof Number) {
					value = new Float(((Number) value).floatValue());
				} else if (value instanceof String) {
					final String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Float.valueOf(s);
						} catch (final NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Double.TYPE.equals(iClass)) {
				if (value instanceof Double) {
					// ok
				} else if (value instanceof Number) {
					value = new Double(((Number) value).doubleValue());
				} else if (value instanceof String) {
					final String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Double.valueOf(s);
						} catch (final NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (type instanceof EEnum) {
				if (value instanceof String) {
					final EEnumLiteral literal = ((EEnum) type).getEEnumLiteralByLiteral((String) value);
					if (literal == null) {
						value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnknownLiteral, value));
					} else {
						value = literal.getInstance();
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, String.class.getName()));
				}
			}
		}
		return value;
	}

	/**
	 * @generated
	 */
	protected class InvalidValue {

		/**
		 * @generated
		 */
		private final String description;

		/**
		 * @generated
		 */
		public InvalidValue(final String description) {
			this.description = description;
		}

		/**
		 * @generated
		 */
		@Override
		public String toString() {
			return this.description;
		}
	}
}
