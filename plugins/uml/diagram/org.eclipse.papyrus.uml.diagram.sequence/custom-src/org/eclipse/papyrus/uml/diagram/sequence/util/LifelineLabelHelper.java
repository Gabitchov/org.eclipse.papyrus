package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypedElementLabelHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.preferences.CustomLifelinePreferencePage;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Type;

public class LifelineLabelHelper extends StereotypedElementLabelHelper {

	public static final String SHOW_REPRESENT_NAME = "representsName";

	public static final String SHOW_REPRESENT_TYPE = "representsType";

	public static final String SHOW_UNDEFINED_TYPE = "undefinedType";

	public static final String SHOW_LIFELINE_NAME = "lifelineName";

	public static final Collection<String> DEFAULT_LABEL_DISPLAY = Arrays.asList(SHOW_REPRESENT_NAME, SHOW_REPRESENT_TYPE);

	/**
	 * singelton instance
	 */
	private static LifelineLabelHelper labelHelper;

	/**
	 * Returns the singleton instance of this class
	 * 
	 * @return the singleton instance.
	 */
	public static LifelineLabelHelper getInstance() {
		if(labelHelper == null) {
			labelHelper = new LifelineLabelHelper();
		}
		return labelHelper;
	}

	/** Map for masks */
	protected final Map<String, String> masks = new HashMap<String, String>();

	/**
	 * Creates a new Operation label helper.
	 */
	protected LifelineLabelHelper() {
		// initialize the map
		masks.put(SHOW_REPRESENT_NAME, "Show represent name");
		masks.put(SHOW_REPRESENT_TYPE, "Show represent type");
		masks.put(SHOW_UNDEFINED_TYPE, "Always show undefined type");
		masks.put(SHOW_LIFELINE_NAME, "Always show lifeline name");
	}

	/**
	 * Returns the map of masks used to display
	 * 
	 * @return the map of masks used to display
	 */
	public Map<String, String> getMasks() {
		return masks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Lifeline getUMLElement(GraphicalEditPart editPart) {
		return (Lifeline)UMLUtil.resolveUMLElement(editPart);
	}

	@Override
	protected String elementLabel(GraphicalEditPart editPart) {
		if(editPart instanceof LifelineNameEditPart) {
			editPart = (GraphicalEditPart)editPart.getParent();
		}
		Collection<String> displayValue = DEFAULT_LABEL_DISPLAY;
		IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy)editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if(policy != null) {
			displayValue = policy.getCurrentDisplayValue();
		}
		return getCustomLabel(getUMLElement(editPart), displayValue);
	}

	private static final String UNAMED = "<Unnamed>";

	private static final String UNDEFINED = "<Undefined>";

	//https://bugs.eclipse.org/bugs/show_bug.cgi?id=383722
	private String getCustomLabel(Lifeline lifeline, Collection<String> displayValue) {
		StringBuilder sb = new StringBuilder();
		appendName(lifeline, displayValue, sb);
		boolean displayType = displayValue.contains(CustomLifelinePreferencePage.SHOW_REPRESENT_TYPE);
		if(lifeline.getRepresents() == null || displayValue.contains(CustomLifelinePreferencePage.SHOW_LIFELINE_NAME)) {
			displayType = false;
		}
		if(displayType) {
			// handle represent type label
			appendType(lifeline, displayValue, sb);
		}
		return sb.toString();
	}

	protected void appendName(Lifeline lifeline, Collection<String> displayValue, StringBuilder sb) {
		ConnectableElement element = lifeline.getRepresents();
		String lifelineName = lifeline.getName();
		if(element == null || displayValue.contains(CustomLifelinePreferencePage.SHOW_LIFELINE_NAME)) {
			appendString(sb, lifelineName, UNAMED);
			return;
		} else {
			// represents is not null
			if(displayValue.contains(CustomLifelinePreferencePage.SHOW_REPRESENT_NAME)) {
				appendString(sb, element.getName(), UNAMED);
			}
			//  if neither <1> or <2> are checked, show lifeline name (or <unnamed> when the lifeline has no name)
			else if(!displayValue.contains(CustomLifelinePreferencePage.SHOW_REPRESENT_TYPE)) {
				appendString(sb, lifelineName, UNAMED);
			}
		}
	}

	protected void appendType(Lifeline lifeline, Collection<String> displayValue, StringBuilder sb) {
		ConnectableElement element = lifeline.getRepresents();
		if(element == null) {
			return;
		}
		Type type = element.getType();
		if(displayValue.contains(CustomLifelinePreferencePage.SHOW_REPRESENT_TYPE)) {
			if(type == null) {
				if(displayValue.contains(CustomLifelinePreferencePage.SHOW_UNDEFINED_TYPE)) {
					sb.append(":").append(UNDEFINED);
				}
			} else {
				appendString(sb.append(":"), type.getName(), UNAMED);
			}
		}
	}

	private void appendString(StringBuilder sb, String str, String defaultValue) {
		if(str != null) {
			sb.append(str);
		} else {
			sb.append(defaultValue);
		}
	}

}
