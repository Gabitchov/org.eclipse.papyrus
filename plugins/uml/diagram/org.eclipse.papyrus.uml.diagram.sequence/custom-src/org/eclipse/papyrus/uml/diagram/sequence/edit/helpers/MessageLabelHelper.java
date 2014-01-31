package org.eclipse.papyrus.uml.diagram.sequence.edit.helpers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.infra.tools.util.StringHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypedElementLabelHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.OperationUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.SignalUtil;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.papyrus.uml.tools.utils.TypedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.ValueSpecification;

public class MessageLabelHelper extends StereotypedElementLabelHelper {

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
		masks.put(ICustomAppearence.DISP_MODIFIERS, "Modifiers");
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

	@Override
	public Message getUMLElement(GraphicalEditPart editPart) {
		EObject e = ((View)editPart.getModel()).getElement();
		if(e instanceof Message) {
			return ((Message)e);
		}
		return null;
	}

	@Override
	protected String elementLabel(GraphicalEditPart editPart) {
		if(editPart instanceof LabelEditPart) {
			editPart = (GraphicalEditPart)editPart.getParent();
		}
		int displayValue = CustomMessagePreferencePage.DEFAULT_LABEL_DISPLAY;
		IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy)editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if(policy != null) {
			displayValue = policy.getCurrentDisplayValue();
		}
		Message e = getUMLElement(editPart);
		if(e == null) {
			return null;
		}
		NamedElement signature = e.getSignature();
		if(signature instanceof Operation) {
			return OperationUtil.getCustomLabel(e, (Operation)signature, displayValue);
		} else if(signature instanceof Signal) {
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
		if(arguments.size() > 0 && (style & ICustomAppearence.DISP_PARAMETER_NAME) != 0 || (style & ICustomAppearence.DISP_DERIVE) != 0) {
			buffer.append("(");
			for(int i = 0; i < arguments.size(); i++) {
				if(i > 0) {
					buffer.append(", ");
				}
				ValueSpecification arg = arguments.get(i);
				//type
				if((style & ICustomAppearence.DISP_PARAMETER_TYPE) != 0) {
					String type = TypedElementUtil.getTypeAsString(arg);
					if(type != null) {
						buffer.append(type);
					}
				}
				boolean showEqualMark = false;
				// name
				if((style & ICustomAppearence.DISP_PARAMETER_NAME) != 0) {
					buffer.append(" ");
					String name = StringHelper.trimToEmpty(arg.getName());
					buffer.append(name);
					if(name.trim().length() > 0) {
						showEqualMark = true;
					}
				}
				// value
				if((style & ICustomAppearence.DISP_DERIVE) != 0) {
					String value = ValueSpecificationUtil.getSpecificationValue(arg);
					if(value != null) {
						if(showEqualMark) {
							buffer.append(" = ");
						}
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

	@Override
	public Map<Integer, String> getMasks() {
		return masks;
	}

	public Set<Integer> getMaskValues() {
		return masks.keySet();
	}

	@Override
	public int getDefaultValue() {
		return CustomMessagePreferencePage.DEFAULT_LABEL_DISPLAY;
	}
}
