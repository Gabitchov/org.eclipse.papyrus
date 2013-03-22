package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypedElementLabelHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.preferences.LifelinePreferencePage;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Type;


public class LifelineLabelHelper extends StereotypedElementLabelHelper {

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
	protected final Map<Integer, String> masks = new HashMap<Integer, String>(7);

	/**
	 * Creates a new Operation label helper.
	 */
	protected LifelineLabelHelper() {
		// initialize the map
		masks.put(LifelinePreferencePage.SHOW_REPRESENT_NAME, "Show represent name");
		masks.put(LifelinePreferencePage.SHOW_REPRESENT_TYPE, "Show represent type");
		masks.put(LifelinePreferencePage.SHOW_UNDEFINED_TYPE, "Always show undefined type");
		masks.put(LifelinePreferencePage.SHOW_LIFELINE_NAME, "Always show lifeline name");	
	}
	

	/**
	 * Returns the mask name given the value of the mask
	 * 
	 * @return the mask name or <code>null</code> if no masks has been found
	 */
	public String getMaskLabel(int value) {
		return masks.get(value);
	}

	/**
	 * Returns the collection of mask names
	 * 
	 * @return the collection of mask names
	 */
	public Collection<String> getMaskLabels() {
		return masks.values();
	}

	/**
	 * Returns the map of masks used to display 
	 * 
	 * @return the map of masks used to display
	 */
	public Map<Integer, String> getMasks() {
		return masks;
	}

	/**
	 * Returns the collection of mask values
	 * 
	 * @return the collection of mask values
	 */
	public Set<Integer> getMaskValues() {
		return masks.keySet();
	}

	/**
	 * {@inheritDoc}
	 */
	public Lifeline getUMLElement(GraphicalEditPart editPart) {
		return (Lifeline)((View)editPart.getModel()).getElement();
	}

	protected String elementLabel(GraphicalEditPart editPart) {
		if(editPart instanceof LifelineNameEditPart)
			editPart = (GraphicalEditPart)editPart.getParent();
		int displayValue = LifelinePreferencePage.DEFAULT_LABEL_DISPLAY;

		IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy)editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if(policy != null) {
			displayValue = policy.getCurrentDisplayValue();
		}
		return getCustomLabel(getUMLElement(editPart), displayValue);
	}

	private static final String UNAMED = "<Unnamed>";
	private static final String UNDEFINED = "<Undefined>";
	
	//https://bugs.eclipse.org/bugs/show_bug.cgi?id=383722
	private String getCustomLabel(Lifeline lifeline, int displayValue) {
		StringBuilder sb = new StringBuilder();		
		appendName(lifeline, displayValue, sb);
		boolean displayType = isCheck(displayValue , LifelinePreferencePage.SHOW_REPRESENT_TYPE );
		if( lifeline.getRepresents() == null || isCheck(displayValue , LifelinePreferencePage.SHOW_LIFELINE_NAME ) ){
			displayType = false;
		}
		if(displayType){
			// handle represent type label
			appendType(lifeline, displayValue, sb);
		}
		return sb.toString();
	}


	protected void appendName(Lifeline lifeline, int displayValue, StringBuilder sb) {
		ConnectableElement element = lifeline.getRepresents();		
		String lifelineName = lifeline.getName(); 
		if( element == null || isCheck(displayValue , LifelinePreferencePage.SHOW_LIFELINE_NAME ) ){
			appendString(sb, lifelineName, UNAMED);
			return;
		}else{
			// represents is not null
			if(isCheck(displayValue , LifelinePreferencePage.SHOW_REPRESENT_NAME )){
				appendString(sb, element.getName(), UNAMED);				
			}
			//  if neither <1> or <2> are checked, show lifeline name (or <unnamed> when the lifeline has no name)
			else if(!isCheck(displayValue , LifelinePreferencePage.SHOW_REPRESENT_TYPE ))
				appendString(sb, lifelineName, UNAMED);
		}
	}
	
	protected void appendType(Lifeline lifeline, int displayValue, StringBuilder sb) {
		ConnectableElement element = lifeline.getRepresents();		
		if(element == null)
			return;
		
		Type type = element.getType();
		if(isCheck(displayValue , LifelinePreferencePage.SHOW_REPRESENT_TYPE )){
			if(type == null ){
				if(isCheck(displayValue , LifelinePreferencePage.SHOW_UNDEFINED_TYPE ))
					sb.append(":").append(UNDEFINED);						
			}else{
				appendString(sb.append(":") , type.getName(), UNAMED);
			}
		}		
	}

	private static boolean isCheck(int value, int mask){
		return (value & mask) != 0;
	}

	private void appendString(StringBuilder sb, String str, String defaultValue) {
		if(str != null)
			sb.append(str);
		else
			sb.append(defaultValue);
	}
}
