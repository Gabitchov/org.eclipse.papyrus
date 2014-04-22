package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.conversion.StringToNumberConverter;

import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.validator.UnlimitedNaturalValidator;

import org.eclipse.swt.widgets.Composite;

public class UnlimitedNaturalEditor extends StringEditor {
	/**
	 * The IConverter for converting data from the widget to the model
	 */
	private IConverter targetToModelConverter;
	
	/**
	 * Constructs an editor for Integer values. The widget is a Text field.
	 * 
	 * @param parent
	 *        The Composite in which this editor is created
	 * @param style
	 *        The Text's style
	 */
	public UnlimitedNaturalEditor(Composite parent, int style) {
		this(parent, style, null);}

	/**
	 * Constructs an editor for Integer values. The widget is a Text field.
	 * 
	 * @param parent
	 *        The Composite in which this editor is created
	 * @param style
	 *        The Text's style
	 * @param label
	 *        The editor's label
	 */
	public UnlimitedNaturalEditor(Composite parent, int style, String label) {
		super(parent, style, label);

		targetValidator = new UnlimitedNaturalValidator();

		targetToModelConverter = new IConverter() {
			
			public Object getToType() {
				return Integer.class;
			}
			
			public Object getFromType() {
				return String.class;
			}
			
			public Integer convert(Object fromObject) {
				if (fromObject instanceof String){
					String newString = ((String)fromObject).replaceAll(" ", ""); //$NON-NLS-1$ //$NON-NLS-2$
					if(newString.equals("*")) return -1; //$NON-NLS-1$
					return (Integer)StringToNumberConverter.toInteger(false).convert(newString);
				}
				return 0;
			}
		};
		
		IConverter integerToString = new IConverter() {
			
			public Object getToType() {
				return String.class;
			}
			
			public Object getFromType() {
				return Integer.class;
			}
			
			public Object convert(Object fromObject) {
				if (fromObject instanceof Integer){
					if(((Integer) fromObject).intValue()==-1){
						return "*"; //$NON-NLS-1$
					}
					return Integer.toString((Integer)fromObject);
				}
				return ""; //$NON-NLS-1$
			}
		};
		setValidateOnDelay(true);

		setConverters(targetToModelConverter, integerToString);
		setTargetAfterGetValidator(targetValidator);

	}
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getEditableType() {
		return Integer.class;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getValue() {
		try {
			
			return (Integer)targetToModelConverter.convert(super.getValue());
		} catch (Exception ex) {
			Activator.log.error(ex);
			return null;
		}
	}
	



}


