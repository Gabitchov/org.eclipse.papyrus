package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractMaskManagedEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.OperationLabelHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypedElementLabelHelper;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.preferences.MessagePreferencePage;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.OperationUtil;
import org.eclipse.papyrus.uml.tools.utils.PropertyUtil;
import org.eclipse.papyrus.uml.tools.utils.TypeUtil;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;


public class MessageLabelEditPolicy extends AbstractMaskManagedEditPolicy {
	
	public static interface ICustomMessageLabel{
		
	}
	
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

		Message e = getUMLElement();
		// check host semantic element is not null
		if(e == null || e.getSignature() == null) {
			return;
		}
		NamedElement sig = e.getSignature();
		if(sig instanceof Operation){
			Operation operation = (Operation)sig;	
			getDiagramEventBroker().addNotificationListener(operation, this);
			// adds a listener to the element itself, and to linked elements, like Type
			for(Parameter parameter : operation.getOwnedParameters()) {
				getDiagramEventBroker().addNotificationListener(parameter, this);
	
				// should also add this element as a listener of parameter type
				if(parameter.getType() != null) {
					getDiagramEventBroker().addNotificationListener(parameter.getType(), this);
				}
			}
		}else if(sig instanceof Signal){
			Signal signal = (Signal)sig;
			getDiagramEventBroker().addNotificationListener(signal, this);
			for(Property property : signal.getOwnedAttributes()) {
				getDiagramEventBroker().addNotificationListener(property, this);
				
				// should also add this element as a listener of parameter type
				if(property.getType() != null) {
					getDiagramEventBroker().addNotificationListener(property.getType(), this);
				}
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
		NamedElement sig = e.getSignature();
		if(sig instanceof Operation){
			Operation operation = (Operation)sig;	
			getDiagramEventBroker().removeNotificationListener(operation, this);
			for(Parameter parameter : operation.getOwnedParameters()) {
				getDiagramEventBroker().removeNotificationListener(parameter, this);
	
				// remove parameter type listener
				if(parameter.getType() != null) {
					getDiagramEventBroker().removeNotificationListener(parameter.getType(), this);
				}
			}
		}else if(sig instanceof Signal){
			Signal signal = (Signal)sig;
			getDiagramEventBroker().removeNotificationListener(signal, this);
			for(Property property : signal.getOwnedAttributes()) {
				getDiagramEventBroker().removeNotificationListener(property, this);
				
				// remove parameter type listener
				if(property.getType() != null) {
					getDiagramEventBroker().removeNotificationListener(property.getType(), this);
				}
			}
		}
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		Object object = notification.getNotifier();
		Message e = getUMLElement();
		// check host semantic element is not null
		if(e == null || e.getSignature() == null) {
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
			} else if(isPropertyType(object, signal)) {
				notifyTypeChanged(notification);
			}
		}

		if(isMaskManagedAnnotation(object)) {
			refreshDisplay();
		}

		if(isRemovedMaskManagedLabelAnnotation(object, notification)) {
			refreshDisplay();
		}
	}
	

	private void notifyPropertyChanged(Notification notification) {
		switch(notification.getFeatureID(Property.class)) {
		case UMLPackage.PROPERTY__NAME:
		case UMLPackage.PROPERTY__DEFAULT_VALUE:
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
		case UMLPackage.PARAMETER__NAME:
		case UMLPackage.PARAMETER__DEFAULT_VALUE:
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
			NamedElement signature = e.getSignature();

			if(signature instanceof Operation) {
				return OperationUtil.getCustomLabel((Operation)signature, displayValue);
			}else if(signature instanceof Signal) {
				return SignalUtil.getCustomLabel((Signal)signature, displayValue);
			} else if(signature != null) {
				return signature.getName();
			}

			return e.getName();
		}
		
		public String getMaskLabel(int value) {
			return OperationLabelHelper.getInstance().getMaskLabel(value);
		}

		public Collection<String> getMaskLabels() {
			return OperationLabelHelper.getInstance().getMaskLabels();
		}

		public Map<Integer, String> getMasks() {
			return OperationLabelHelper.getInstance().getMasks();
		}

		public Set<Integer> getMaskValues() {
			return OperationLabelHelper.getInstance().getMaskValues();
		}
	}
	
	static public class SignalUtil {

		/**
		 * return the custom label of the signal, given UML2 specification and a custom style.
		 * 
		 * @param style
		 *        the integer representing the style of the label
		 * 
		 * @return the string corresponding to the label of the signal
		 */
		public static String getCustomLabel(Signal signal, int style) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(" "); // adds " " first for correct display considerations

			// visibility
			if((style & ICustomAppearence.DISP_VISIBILITY) != 0) {
				buffer.append(NamedElementUtil.getVisibilityAsSign(signal));
			}

			// name
			if((style & ICustomAppearence.DISP_NAME) != 0) {
				buffer.append(" ");
				buffer.append(signal.getName());
			}

			// 
			// parameters : '(' parameter-list ')'
			buffer.append("(");
			buffer.append(getPropertiesAsString(signal, style));
			buffer.append(")");

			return buffer.toString();
		}

		/**
		 * Returns signal properties as a string, the label is customized using a bit mask
		 * 
		 * @return a string containing all properties separated by commas
		 */
		private static String getPropertiesAsString(Signal signal, int style) {
			StringBuffer propertiesString = new StringBuffer();
			boolean firstProperty = true;
			for(Property property : signal.getOwnedAttributes()) {
				// get the label for this property
				String propertyString = getCustomPropertyLabel(property, style);
				if(!propertyString.trim().equals("")) {
					if(!firstProperty) {
						propertiesString.append(", ");
					}
					propertiesString.append(propertyString);
					firstProperty = false;
				}
			}
			return propertiesString.toString();
		}

		private static String getCustomPropertyLabel(Property property, int style) {
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
			// name
			if((style & ICustomAppearence.DISP_PARAMETER_NAME) != 0) {
				buffer.append(" ");
				buffer.append(property.getName());
			}

			if((style & ICustomAppearence.DISP_PARAMETER_TYPE) != 0) {
				// type
				if(property.getType() != null) {
					buffer.append(": " + property.getType().getName());
				} else {
					buffer.append(": " + TypeUtil.UNDEFINED_TYPE_NAME);
				}
			}

			if((style & ICustomAppearence.DISP_MULTIPLICITY) != 0) {
				// multiplicity -> do not display [1]
				String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(property);
				buffer.append(multiplicity);
			}

			if((style & ICustomAppearence.DISP_PARAMETER_DEFAULT) != 0) {
				// default value
				if(property.getDefault() != null) {
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
	}
}
