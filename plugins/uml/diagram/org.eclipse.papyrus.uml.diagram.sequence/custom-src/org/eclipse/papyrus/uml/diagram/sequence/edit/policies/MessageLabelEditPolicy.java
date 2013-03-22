package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractMaskManagedEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypedElementLabelHelper;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.preferences.MessagePreferencePage;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.ParameterUtil;
import org.eclipse.papyrus.uml.tools.utils.PropertyUtil;
import org.eclipse.papyrus.uml.tools.utils.TypeUtil;
import org.eclipse.papyrus.uml.tools.utils.TypedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;


public class MessageLabelEditPolicy extends AbstractMaskManagedEditPolicy {
	
	public static interface ICustomMessageLabel{
		
	}

	private DefaultValueListener defaultValueListener;
	
	/**
	 * Refreshes the display of the edit part
	 */
	@Override
	public void refreshDisplay() {
		// calls the helper for this edit Part
		ConnectionEditPart lp = (ConnectionEditPart)getHost();
		List children = lp.getChildren();
		for(Object p : children)
			if(p instanceof ICustomMessageLabel){
				MessageLabelHelper.getInstance().refreshEditPartDisplay((GraphicalEditPart)p);
			}
	}
	
	public int getCurrentDisplayValue() {
		EAnnotation customeDisplayAnnotation = ((View)getHost().getModel()).getEAnnotation(VisualInformationPapyrusConstants.CUSTOM_APPEARENCE_ANNOTATION);
		int displayValue = getDefaultDisplayValue();
		if(customeDisplayAnnotation != null) {
			displayValue = Integer.parseInt(customeDisplayAnnotation.getDetails().get(VisualInformationPapyrusConstants.CUSTOM_APPEARANCE_MASK_VALUE));
		} else {
			// no specific information => look in preferences
			IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
			int displayValueTemp = store.getInt(MessagePreferencePage.LABEL_DISPLAY_PREFERENCE);
			if(displayValueTemp != 0) {
				displayValue = displayValueTemp;
			}
		}
		return displayValue;
	}

	public int getDefaultDisplayValue() {
		return MessagePreferencePage.DEFAULT_LABEL_DISPLAY;
	}

	public String getMaskLabel(int value) {
		return MessageLabelHelper.getInstance().getMaskLabel(value);
	}

	public Collection<String> getMaskLabels() {
		return MessageLabelHelper.getInstance().getMaskLabels();
	}

	public Map<Integer, String> getMasks() {
		return MessageLabelHelper.getInstance().getMasks();
	}

	public Collection<Integer> getMaskValues() {
		return MessageLabelHelper.getInstance().getMaskValues();
	}
	
	public String getPreferencePageID() {
		return "org.eclipse.papyrus.uml.diagram.sequence.preferences.MessagePreferencePage";
	}
	
	@Override
	public Message getUMLElement() {
		if(hostSemanticElement instanceof Message)
			return ((Message)hostSemanticElement);
		return null;
	}
	
	@Override
	public void addAdditionalListeners() {
		super.addAdditionalListeners();
		this.defaultValueListener = new DefaultValueListener();
		Message e = getUMLElement();
		// check host semantic element is not null
		if(e == null || e.getSignature() == null) {
			return;
		}
		hookMessageSignature(e.getSignature());
		
		EList<ValueSpecification> argments = e.getArguments();
		for(ValueSpecification v : argments)
			if(v instanceof EObject) {
				getDiagramEventBroker().addNotificationListener((EObject)v, this);
			}
	}

	private void hookMessageSignature(NamedElement sig) {
		if (sig == null){
			return;
		}
		if(sig instanceof Operation){
			Operation operation = (Operation)sig;	
			getDiagramEventBroker().addNotificationListener(operation, this);
			// adds a listener to the element itself, and to linked elements, like Type
			for(Parameter parameter : operation.getOwnedParameters()) {
				getDiagramEventBroker().addNotificationListener(parameter, this);
				getDiagramEventBroker().addNotificationListener(parameter.getDefaultValue(), defaultValueListener);
				
				// should also add this element as a listener of parameter type
				getDiagramEventBroker().addNotificationListener(parameter.getType(), this);
			}
		}else if(sig instanceof Signal){
			Signal signal = (Signal)sig;
			getDiagramEventBroker().addNotificationListener(signal, this);
			for(Property property : signal.getOwnedAttributes()) {
				getDiagramEventBroker().addNotificationListener(property, this);
				getDiagramEventBroker().addNotificationListener(property.getDefaultValue(), defaultValueListener);
				
				// should also add this element as a listener of parameter type
				getDiagramEventBroker().addNotificationListener(property.getType(), this);
			}
		}
	}
	
	@Override
	protected void removeAdditionalListeners() {
		super.removeAdditionalListeners();
		Message e = getUMLElement();
		// check host semantic element is not null
		if(e == null || e.getSignature() == null) {
			return;
		}
		unhookMessageSignature(e.getSignature());
		
		EList<ValueSpecification> argments = e.getArguments();
		for(ValueSpecification v : argments)
			if(v instanceof EObject) {
				getDiagramEventBroker().removeNotificationListener((EObject)v, this);
			}
	}

	private void unhookMessageSignature(NamedElement sig) {
		if (sig == null){
			return;
		}
		if(sig instanceof Operation){
			Operation operation = (Operation)sig;	
			getDiagramEventBroker().removeNotificationListener(operation, this);
			for(Parameter parameter : operation.getOwnedParameters()) {
				getDiagramEventBroker().removeNotificationListener(parameter, this);
				getDiagramEventBroker().removeNotificationListener(parameter.getDefaultValue(), defaultValueListener);
				
				// remove parameter type listener
				getDiagramEventBroker().removeNotificationListener(parameter.getType(), this);
			}
		}else if(sig instanceof Signal){
			Signal signal = (Signal)sig;
			getDiagramEventBroker().removeNotificationListener(signal, this);
			for(Property property : signal.getOwnedAttributes()) {
				getDiagramEventBroker().removeNotificationListener(property, this);
				getDiagramEventBroker().removeNotificationListener(property.getDefaultValue(), defaultValueListener);
				
				// remove parameter type listener
				getDiagramEventBroker().removeNotificationListener(property.getType(), this);
			}
		}
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		final Object object = notification.getNotifier();
		Message e = getUMLElement();
		// check host semantic element is not null
		if(e == null) {
			return;
		}
		if(UMLPackage.Literals.MESSAGE__ARGUMENT.equals( notification.getFeature())){
			parameterListChange(notification);
			return;
		}else if(e.getArguments().contains(object)){
			refreshDisplay();
			return;
		}
		
		NamedElement sig = e.getSignature();
		if(sig instanceof Operation){
			Operation operation = (Operation)sig;	
	 
			if(object.equals(operation)) {
				notifyOperationChanged(operation, notification);
			} else if(isParameter(object, operation)) {
				notifyParameterChanged(notification);
			} else if(isParameterType(object, operation)) {
				notifyTypeChanged(notification);
			}
		}else if(sig instanceof Signal){
			Signal signal = (Signal)sig;
			if(object.equals(signal)) {
				notifySignalChanged(signal, notification);
			}else if(isProperty(object, signal)) {
				notifyPropertyChanged(notification);
			}else if(isPropertyType(object, signal)) {
				notifyTypeChanged(notification);
			}else if(object instanceof ValueSpecification){
				Element own = ((ValueSpecification)object).getOwner();
				if(isProperty(own, signal)){
					refreshDisplay();  // may be default value
				}
			}
		}

		if(isMaskManagedAnnotation(object) ){
			refreshDisplay();
		}else if(isRemovedMaskManagedLabelAnnotation(object, notification)) {
			refreshDisplay();
		}else if(sig == null && object instanceof Message && notification.getFeature().equals(UMLPackage.eINSTANCE.getNamedElement_Name())){
			refreshDisplay();
		}
		//Try to update label when signature of message changed.
		else if (UMLPackage.eINSTANCE.getMessage_Signature() == notification.getFeature()){
			Object oldValue = notification.getOldValue();
			if(oldValue instanceof NamedElement) {
				unhookMessageSignature((NamedElement)oldValue);
			}
			Object newValue = notification.getNewValue();
			if(newValue instanceof NamedElement) {
				hookMessageSignature((NamedElement)newValue);
			}
			refreshDisplay();
		}
	}
	
	class DefaultValueListener implements NotificationListener{

		public void notifyChanged(Notification notification) {
			refreshDisplay();
		}
	}

	private void notifyPropertyChanged(Notification notification) {
		switch(notification.getFeatureID(Property.class)) {
		case UMLPackage.PROPERTY__DEFAULT_VALUE: // set or unset default value		
			if(notification.getOldValue() instanceof EObject)
				getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), defaultValueListener);
			if(notification.getNewValue() instanceof EObject)
				getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), defaultValueListener);
			refreshDisplay();
			break;
		case UMLPackage.PROPERTY__NAME:
		case UMLPackage.PROPERTY__IS_ORDERED:
		case UMLPackage.PROPERTY__LOWER:
		case UMLPackage.PROPERTY__UPPER:
		case UMLPackage.PROPERTY__LOWER_VALUE:
		case UMLPackage.PROPERTY__UPPER_VALUE:
			refreshDisplay();
			break;
		case UMLPackage.PROPERTY__TYPE:
			parameterListChange(notification);

			break;
		default:
			// does nothing in other cases
			break;
		}
	}

	/**
	 * notifies that a parameter of the operation has changed.
	 * 
	 * @param parameter
	 *        the {@link Parameter} that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyParameterChanged(Notification notification) {
		switch(notification.getFeatureID(Parameter.class)) {
		case UMLPackage.PARAMETER__DEFAULT_VALUE:
			if(notification.getOldValue() instanceof EObject)
				getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), defaultValueListener);
			if(notification.getNewValue() instanceof EObject)
				getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), defaultValueListener);
			refreshDisplay();
			break;
		case UMLPackage.PARAMETER__NAME:
		case UMLPackage.PARAMETER__DIRECTION:
		case UMLPackage.PARAMETER__IS_STREAM:
		case UMLPackage.PARAMETER__IS_ORDERED:
		case UMLPackage.PARAMETER__LOWER:
		case UMLPackage.PARAMETER__UPPER:
		case UMLPackage.PARAMETER__LOWER_VALUE:
		case UMLPackage.PARAMETER__UPPER_VALUE:
			refreshDisplay();
			break;
		case UMLPackage.PARAMETER__TYPE:
			parameterListChange(notification);

			break;
		default:
			// does nothing in other cases
			break;
		}
	}

	protected void parameterListChange(Notification notification) {
		switch(notification.getEventType()) {
		// if it is added => adds listener to the type element
		case Notification.ADD:
			getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), this);
			refreshDisplay();
			// if it is removed => removes listener from the type element
			break;
		case Notification.ADD_MANY: 
			if(notification.getNewValue() instanceof List<?>) {
				List<?> addedElements = (List<?>)notification.getNewValue();
				for(Object addedElement : addedElements) {
					if(addedElement instanceof EObject) {
						getDiagramEventBroker().addNotificationListener((EObject)addedElement, this);
					}
				}
			}
			refreshDisplay();
			break;
		case Notification.REMOVE:
			getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
			refreshDisplay();
			break;
		case Notification.REMOVE_MANY: 
			if(notification.getOldValue() instanceof List<?>) {
				List<?> removedElements = (List<?>)notification.getOldValue();
				for(Object removedElement : removedElements) {
					if(removedElement instanceof EObject) {
						getDiagramEventBroker().removeNotificationListener((EObject)removedElement, this);
					}
				}
			}
			refreshDisplay();
			break;
		// if it is set, remove the old one and adds the new one. this is the method use when
		// the type is set or removed...
		case Notification.SET:
			if(notification.getNewValue() != null) {
				getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), this);
			}
			if(notification.getOldValue() != null) {
				getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
			}
			refreshDisplay();

		default:
			break;

		}
	}

	/**
	 * notifies that a parameter of the operation has changed.
	 * 
	 * @param parameter
	 *        the {@link Parameter} that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyTypeChanged(Notification notification) {
		// should be type.class, but seems to be a bug if this is put instead.
		switch(notification.getFeatureID(notification.getNotifier().getClass())) {
		case UMLPackage.TYPE__NAME:
		case UMLPackage.TYPE__TEMPLATE_PARAMETER:
		case UMLPackage.TYPE__VISIBILITY:
			refreshDisplay();
			break;
		default:
			// does nothing in other cases
			break;
		}
	}

	/**
	 * notifies that the the property has changed.
	 * 
	 * @param operation
	 *        the operation that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyOperationChanged(Operation operation, Notification notification) {
		switch(notification.getFeatureID(Operation.class)) {
		case UMLPackage.OPERATION__NAME:
		case UMLPackage.OPERATION__VISIBILITY:
		case UMLPackage.OPERATION__IS_UNIQUE:
		case UMLPackage.OPERATION__REDEFINED_OPERATION:
		case UMLPackage.OPERATION__IS_ORDERED:
		case UMLPackage.OPERATION__LOWER:
		case UMLPackage.OPERATION__UPPER:
		case UMLPackage.OPERATION__IS_STATIC:
			refreshDisplay();
			break;
		case UMLPackage.OPERATION__OWNED_PARAMETER:
			parameterListChange(notification);
			break;
		default:
			// does nothing in other cases
			break;
		}
	}
	

	private void notifySignalChanged(Signal signal, Notification notification) {
		switch(notification.getFeatureID(Signal.class)) {
		case UMLPackage.SIGNAL__NAME:
		case UMLPackage.SIGNAL__VISIBILITY:
			refreshDisplay();
			break;
		case UMLPackage.SIGNAL__OWNED_ATTRIBUTE:
			parameterListChange(notification);
			break;
		default:
			// does nothing in other cases
			break;
		}
	}

	/**
	 * Checks if the given object is one of the parameter type of the operation
	 * 
	 * @param object
	 *        the object to test
	 * @param operation 
	 * @return <code>true</code> if the object corresponds to the type of a parameter of the
	 *         operation
	 */
	protected boolean isParameterType(Object object, Operation operation) {
		if(!(object instanceof Type)) {
			return false;
		}

		for(Parameter parameter : operation.getOwnedParameters()) {
			if(object.equals(parameter.getType())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the given object is one of the parameter of the operation
	 * 
	 * @param object
	 *        the object to test
	 * @param operation 
	 * @return <code>true</code> if the object is a parameter of the operation
	 */
	protected boolean isParameter(Object object, Operation operation) {
		if(!(object instanceof Parameter)) {
			return false;
		}

		return operation.getOwnedParameters().contains(object);
	}
	
	private boolean isPropertyType(Object object, Signal signal) {
		if(!(object instanceof Type)) {
			return false;
		}

		for(Property property :signal.getOwnedAttributes()) {
			if(object.equals(property.getType())) {
				return true;
			}
		}
		return false;
	}

	private boolean isProperty(Object object, Signal signal) {
		if(!(object instanceof Property)) {
			return false;
		}

		return signal.getOwnedAttributes().contains(object);
	}

	static class MessageLabelHelper extends StereotypedElementLabelHelper{
		/**
		 * singelton instance
		 */
		private static MessageLabelHelper labelHelper;
		
		/** Map for masks */
		protected final Map<Integer, String> masks = new HashMap<Integer, String>(11);
		
		protected MessageLabelHelper() {
			// initialize the map
			masks.put(ICustomAppearence.DISP_VISIBILITY, "Visibility");  
			masks.put(ICustomAppearence.DISP_NAME, "Name");
			masks.put(ICustomAppearence.DISP_PARAMETER_NAME, "Parameters Name");
			masks.put(ICustomAppearence.DISP_PARAMETER_DIRECTION, "Parameters Direction");
			masks.put(ICustomAppearence.DISP_PARAMETER_TYPE, "Parameters Type");
			masks.put(ICustomAppearence.DISP_RT_TYPE, "Return Type");
			masks.put(ICustomAppearence.DISP_PARAMETER_MULTIPLICITY, "Parameters Multiplicity");
			masks.put(ICustomAppearence.DISP_PARAMETER_DEFAULT, "Parameters Default Value");
			masks.put(ICustomAppearence.DISP_DERIVE, "Parameters Value");
			masks.put(ICustomAppearence.DISP_PARAMETER_MODIFIERS, "Parameters Modifiers");
			masks.put(ICustomAppearence.DISP_MOFIFIERS, "Modifiers");
			
		}

		/**
		 * Returns the singleton instance of this class
		 * 
		 * @return the singleton instance.
		 */
		public static MessageLabelHelper getInstance() {
			if(labelHelper == null) {
				labelHelper = new MessageLabelHelper();
			}
			return labelHelper;
		}
		
		public Message getUMLElement(GraphicalEditPart editPart) {
			EObject e = ((View)editPart.getModel()).getElement();
			if(e instanceof Message)
				return ((Message)e);
			return null;
		}

		protected String elementLabel(GraphicalEditPart editPart) {
			if(editPart instanceof LabelEditPart)
				editPart = (GraphicalEditPart)editPart.getParent();
			
			int displayValue = MessagePreferencePage.DEFAULT_LABEL_DISPLAY;

			IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy)editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
			if(policy != null) {
				displayValue = policy.getCurrentDisplayValue();
			}
			Message e = getUMLElement(editPart);
			if (e == null){
				return null;
			}
			NamedElement signature = e.getSignature();

			if(signature instanceof Operation) {
				return OperationUtil.getCustomLabel(e, (Operation)signature, displayValue);
			}else if(signature instanceof Signal) {
				return SignalUtil.getCustomLabel(e, (Signal)signature, displayValue);
			} else if(signature != null) {
				return signature.getName();
			}

			// signature is null
			return getMessageLabel(e, displayValue);
		}
		
		private String getMessageLabel(Message e, int style) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(e.getName());
			
			// parameters : '(' parameter-list ')'
			EList<ValueSpecification> arguments = e.getArguments();
			if(arguments.size() > 0 && (style & ICustomAppearence.DISP_PARAMETER_NAME) != 0 || (style & ICustomAppearence.DISP_DERIVE) != 0){
				buffer.append("(");
				for(int i = 0 ;i < arguments.size(); i ++){					
					if(i > 0)
						buffer.append(", ");
					
					ValueSpecification arg = arguments.get(i);
					//type
					if ((style & ICustomAppearence.DISP_PARAMETER_TYPE) != 0){
						String type = TypedElementUtil.getTypeAsString(arg);
						if (type != null){
							buffer.append(type);
						}
					}
					boolean showEqualMark = false;
					// name
					if((style & ICustomAppearence.DISP_PARAMETER_NAME) != 0) {
						buffer.append(" ");
						String name = trimToEmpty(arg.getName());
						buffer.append(name);
						if(name.trim().length() > 0)
							showEqualMark = true;
					}
					
					// value
					if((style & ICustomAppearence.DISP_DERIVE) != 0) {
						String value = ValueSpecificationUtil.getSpecificationValue(arg);
						if(value != null){
							if(showEqualMark)
								buffer.append(" = ");
							buffer.append(value);
						} 
					}										
				}
				buffer.append(")");			
			}
			return buffer.toString();
		}

		public String getMaskLabel(int value) {
			return masks.get(value);
		}

		public Collection<String> getMaskLabels() {
			return masks.values();
		}

		public Map<Integer, String> getMasks() {
			return masks;
		}

		public Set<Integer> getMaskValues() {
			return masks.keySet();
		}
	}
	
	static public class SignalUtil {
		private static String getCustomPropertyLabel(Message e, Property property, int style) {
			StringBuffer buffer = new StringBuffer();
			// visibility

			buffer.append(" ");
			if((style & ICustomAppearence.DISP_VISIBILITY) != 0) {
				buffer.append(NamedElementUtil.getVisibilityAsSign(property));
			}

			// derived property
			if((style & ICustomAppearence.DISP_DERIVE) != 0) {
				if(property.isDerived()) {
					buffer.append("/");
				}
			}
			
			boolean showEqualMark = false;
			// name
			if((style & ICustomAppearence.DISP_PARAMETER_NAME) != 0) {
				buffer.append(" ");
				String name = trimToEmpty(property.getName());
				if(name.trim().length() > 0)
					showEqualMark = true;
				buffer.append(name);
			}

			if((style & ICustomAppearence.DISP_PARAMETER_TYPE) != 0) {
				// type
				if(property.getType() != null) {
					buffer.append(": " + trimToEmpty(property.getType().getName()));
				} else {
					buffer.append(": " + TypeUtil.UNDEFINED_TYPE_NAME);
				}
				showEqualMark = true;
			}

			if((style & ICustomAppearence.DISP_MULTIPLICITY) != 0) {
				// multiplicity -> do not display [1]
				String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(property);
				buffer.append(multiplicity);
			}
			
			if((style & ICustomAppearence.DISP_DERIVE) != 0) {
				String value = getValue(e, property);
				if(value != null){
					if(showEqualMark)
						buffer.append(" = ");
					buffer.append(value);
				} 
			}else if((style & ICustomAppearence.DISP_PARAMETER_DEFAULT) != 0) {
				 // default value
				if(property.getDefault() != null) {
					if(showEqualMark)
						buffer.append(" = ");
					buffer.append(property.getDefault());
				}
			}

			if((style & ICustomAppearence.DISP_MOFIFIERS) != 0) {
				boolean multiLine = ((style & ICustomAppearence.DISP_MULTI_LINE) != 0);
				// property modifiers
				String modifiers = PropertyUtil.getModifiersAsString(property, multiLine);
				if(!modifiers.equals("")) {
					if(multiLine) {
						buffer.append("\n");
					}
					
					if (!buffer.toString().endsWith(" ")){					
						buffer.append(" ");
					}
					
					buffer.append(modifiers);
				}
			}
			return buffer.toString();
		}

		private static String getValue(Message e, Property property) {
			try {
				Signal signal = (Signal)property.getOwner();
				int index = signal.getOwnedAttributes().indexOf(property);
				EList<ValueSpecification> arguments = e.getArguments();
				if(arguments.size() > index){
					return ValueSpecificationUtil.getSpecificationValue( arguments.get(index) );
				}
			} catch (Exception e1) {
			}
			return null;
		}

		/**
		 * return the custom label of the signal, given UML2 specification and a custom style.
		 * @param e 
		 * 
		 * @param style
		 *        the integer representing the style of the label
		 * 
		 * @return the string corresponding to the label of the signal
		 */
		public static String getCustomLabel(Message e, Signal signal, int style) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(" "); // adds " " first for correct display considerations

			// visibility
			if((style & ICustomAppearence.DISP_VISIBILITY) != 0) {
				buffer.append(NamedElementUtil.getVisibilityAsSign(signal));
			}

			// name
			if((style & ICustomAppearence.DISP_NAME) != 0) {
				buffer.append(" ");
				buffer.append(trimToEmpty(signal.getName()));
			}

			// 
			// parameters : '(' parameter-list ')'
			buffer.append("(");
			buffer.append(getPropertiesAsString(e, signal, style));
			buffer.append(")");

			return buffer.toString();
		}

		/**
		 * Returns signal properties as a string, the label is customized using a bit mask
		 * 
		 * @return a string containing all properties separated by commas
		 */
		private static String getPropertiesAsString(Message e, Signal signal, int style) {			
			StringBuffer propertiesString = new StringBuffer();
			boolean firstProperty = true;
			for(Property property : signal.getOwnedAttributes()) {
				// get the label for this property
				String propertyString = getCustomPropertyLabel(e, property, style).trim();
				if(!propertyString.equals("")) {
					if(!firstProperty) {
						propertiesString.append(", ");
					}
					propertiesString.append(propertyString);
					firstProperty = false;
				}
			}
			return propertiesString.toString();
		}
	}
	
	static class OperationUtil {
		public static String getCustomLabel(Message e, int paramIndex, Parameter parameter, int style) {
			StringBuffer buffer = new StringBuffer();
			// visibility
			buffer.append(" ");
			if((style & ICustomAppearence.DISP_VISIBILITY) != 0) {
				buffer.append(NamedElementUtil.getVisibilityAsSign(parameter));
			}

			// direction property
			if((style & ICustomAppearence.DISP_PARAMETER_DIRECTION) != 0) {
				buffer.append(" ");
				buffer.append(parameter.getDirection().getLiteral());
			}

			boolean showEqualMark = false;
			// name
			if((style & ICustomAppearence.DISP_PARAMETER_NAME) != 0) {
				buffer.append(" ");
				String name = trimToEmpty(parameter.getName());
				if(name.trim().length() > 0)
					showEqualMark = true;
				buffer.append(name);
			}

			if((style & ICustomAppearence.DISP_PARAMETER_TYPE) != 0) {
				// type
				if(parameter.getType() != null) {
					buffer.append(": " + trimToEmpty(parameter.getType().getName()));
				} else {
					buffer.append(": " + TypeUtil.UNDEFINED_TYPE_NAME);
				}
				showEqualMark = true;
			}

			if((style & ICustomAppearence.DISP_PARAMETER_MULTIPLICITY) != 0) {
				// multiplicity -> do not display [1]
				String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(parameter);
				buffer.append(multiplicity);
			}
			
			if((style & ICustomAppearence.DISP_DERIVE) != 0) {
				String value = getValue(e, paramIndex, parameter);
				if(value != null){
					if(showEqualMark)
						buffer.append(" = ");
					buffer.append(value);
				} 
			}else if((style & ICustomAppearence.DISP_PARAMETER_DEFAULT) != 0) {
				 // default value
				 if(parameter.getDefault() != null) {
					if(showEqualMark)
						buffer.append(" = ");
					buffer.append(parameter.getDefault());
				}
			}

			if((style & ICustomAppearence.DISP_MOFIFIERS) != 0) {
				boolean multiLine = ((style & ICustomAppearence.DISP_MULTI_LINE) != 0);
				// property modifiers
				String modifiers = ParameterUtil.getModifiersAsString(parameter, multiLine);
				if(!modifiers.equals("")) {
					if(multiLine) {
						buffer.append("\n");
					}
					buffer.append(modifiers);
				}
			}
			return buffer.toString();
		}
		
		private static String getValue(Message e, int paramIndex, Parameter parameter) {
			try {
				EList<ValueSpecification> arguments = e.getArguments();
				if(arguments.size() > paramIndex){
					return ValueSpecificationUtil.getSpecificationValue( arguments.get(paramIndex) );
				}
			} catch (Exception e1) {
			}
			return null;
		}

		public static String getCustomLabel(Message e, Operation operation, int style) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(" "); // adds " " first for correct display considerations

			// visibility
			if((style & ICustomAppearence.DISP_VISIBILITY) != 0) {
				buffer.append(NamedElementUtil.getVisibilityAsSign(operation));
			}

			// name
			if((style & ICustomAppearence.DISP_NAME) != 0) {
				buffer.append(" ");
				buffer.append(trimToEmpty(operation.getName()));
			}

			// 
			// parameters : '(' parameter-list ')'
			buffer.append("(");
			buffer.append(getParametersAsString(e, operation, style));
			buffer.append(")");

			// return type
			if((style & ICustomAppearence.DISP_RT_TYPE) != 0) {
				buffer.append(getReturnTypeAsString(operation, style));
			}

			// modifiers
			if((style & ICustomAppearence.DISP_MOFIFIERS) != 0) {
				String modifiers = getModifiersAsString(operation);
				if(!modifiers.equals("")) {
					buffer.append("{");
					buffer.append(modifiers);
					buffer.append("}");
				}
			}
			return buffer.toString();
		}

		/**
		 * Returns operation modifiers as string, separated with comma.
		 * 
		 * @return a string containing the modifiers
		 */
		private static String getModifiersAsString(Operation operation) {
			StringBuffer buffer = new StringBuffer();
			boolean needsComma = false;

			// Return parameter modifiers
			Parameter returnParameter = OperationUtil.getReturnParameter(operation);
			if(returnParameter != null) {
				// non unique parameter
				if(!returnParameter.isUnique()) {
					buffer.append("nonunique");
					needsComma = true;
				}

				// return parameter has ordered values
				if(returnParameter.isOrdered()) {
					if(needsComma) {
						buffer.append(", ");
					}
					buffer.append("ordered");
					needsComma = true;
				}
			}

			// is the operation a query ?
			if(operation.isQuery()) {
				if(needsComma) {
					buffer.append(", ");
				}
				buffer.append("query");
				needsComma = true;
			}

			// is the operation redefining another operation ?
			Iterator<Operation> it = operation.getRedefinedOperations().iterator();
			while(it.hasNext()) {
				Operation currentOperation = it.next();
				if(needsComma) {
					buffer.append(", ");
				}
				buffer.append("redefines ");
				buffer.append(currentOperation.getName());
				needsComma = true;
			}

			// has the operation a constraint ?
			Iterator<Constraint> it2 = operation.getOwnedRules().iterator();
			while(it2.hasNext()) {
				Constraint constraint = it2.next();
				if(needsComma) {
					buffer.append(", ");
				}
				if(constraint.getSpecification() != null) {
					buffer.append(constraint.getSpecification().stringValue());
				}
				needsComma = true;
			}

			return buffer.toString();
		}

		/**
		 * Returns return parameter label as a string, string parametrized with a style mask.
		 * 
		 * @param style
		 *        the mask that indicates which element to display
		 * @return a string containing the return parameter type
		 */
		private static String getReturnTypeAsString(Operation operation, int style) {
			boolean displayType = ((style & ICustomAppearence.DISP_RT_TYPE) != 0);
			boolean displayMultiplicity = ((style & ICustomAppearence.DISP_RT_MULTIPLICITY) != 0);
			StringBuffer label = new StringBuffer("");

			// Retrieve the return parameter (assume to be unique if defined)
			Parameter returnParameter = getReturnParameter(operation);
			// Create the string for the return type
			if(returnParameter == null) {
				// no-operation: label = ""

			} else if(!displayType && !displayMultiplicity) {
				// no-operation: label = ""

			} else {
				label.append(": ");
				if(displayType) {
					label.append(TypedElementUtil.getTypeAsString(returnParameter));
				}

				if(displayMultiplicity) {
					label.append(MultiplicityElementUtil.getMultiplicityAsString(returnParameter));
				}
			}
			return label.toString();
		}

		/**
		 * Gives the return parameter for this operation, or <code>null</code> if none exists.
		 * 
		 * @return the return parameter of the operation or <code>null</code>
		 */
		private static Parameter getReturnParameter(Operation operation) {
			// Retrieve the return parameter (assume to be unique if defined)
			Parameter returnParameter = null;

			Iterator<Parameter> it = operation.getOwnedParameters().iterator();
			while((returnParameter == null) && (it.hasNext())) {
				Parameter parameter = it.next();
				if(parameter.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL)) {
					returnParameter = parameter;
				}
			}
			return returnParameter;
		}
		
		/**
		 * Returns operation parameters as a string, the label is customized using a bit mask
		 * @param e 
		 * 
		 * @return a string containing all parameters separated by commas
		 */
		private static String getParametersAsString(Message e, Operation operation, int style) {
			StringBuffer paramString = new StringBuffer();
			Iterator<Parameter> paramIterator = operation.getOwnedParameters().iterator();
			boolean firstParameter = true;
			int paramIndex = 0;
			while(paramIterator.hasNext()) {
				Parameter parameter = paramIterator.next();
				// Do not include return parameters
				if(!parameter.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL)) {
					// get the label for this parameter
					String parameterString = getCustomLabel(e, paramIndex, parameter, style).trim();
					paramIndex ++;
					if (!parameterString.equals("")) {
						if (!firstParameter) {
							paramString.append(", ");
						}
						paramString.append(parameterString);
						firstParameter = false;
					}
				}
			}
			return paramString.toString();
		}
	}
	
	static String trimToEmpty(String str){
		return str == null? "" : str;
	}
}
