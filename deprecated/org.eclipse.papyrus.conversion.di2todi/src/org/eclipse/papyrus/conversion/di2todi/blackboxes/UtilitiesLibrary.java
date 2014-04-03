/**
 * @author: Manel Fredj - CEA
 * This class includes all the operations that are called in the transformation QVTO from java. 
 * These operations are wrapped into a black-box
 */

package org.eclipse.papyrus.conversion.di2todi.blackboxes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.papyrus.conversion.di2.GraphElement;
import org.eclipse.papyrus.conversion.di2.SemanticModelBridge;
import org.eclipse.papyrus.conversion.di2.Uml1SemanticModelBridge;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Realization;

public class UtilitiesLibrary {
	
	@Operation(contextual=true)
	public static String getName(Diagram self) 
	{
		return self.getName();
	}
	
	@Operation(contextual=true)
	public static EObject convertElement(Element self)
	{
		return self;
	}
	
	@Operation(contextual=true)
	public static String getElementType(Element self)
	{
		if (self instanceof Association )
			return "Association";
		if (self instanceof Generalization )
			return "Generalization";
		else return null;
	}
	
	@Operation(contextual=true)
	public static boolean isGeneralization(Element self)
	{
		if (self instanceof Generalization)
			return true;
		else return false;
	}
	
	
	@Operation(contextual=true)
	public static boolean isAssociation(Element self)
	{
		if (self instanceof Association)
			return true;
		else 
			return false;
	}
	
	@Operation(contextual=true)
	public static boolean isRealization(Element self)
	{
		if (self instanceof  Realization)
			return true;
		else 
			return false;
	}
	@Operation(contextual=true)
	public static boolean isDependency(Element self)
	{
		if (self instanceof Dependency)
			return true;
		else 
			return false;
	}
	
	@Operation(contextual=true)
	public static int dimensionGetWidth(Dimension self) 
	{   
		if (self!=null)
			return self.width;
		else
			return 0;
	}
	
	@Operation(contextual=true)
	public static int dimensionGetHeight(Dimension self) 
	{ 
		if (self!=null)
			return self.height;
		else
			return 0;
	}

	@Operation(contextual=true)
	public static int pointGetX(Point self)
	{ 
		if (self!=null)
		{
		
			return self.x;
		}else
			return 0;		
	}
	
	@Operation(contextual=true)
	public static int pointGetY(Point self) 
	{
		if (self!=null)
		{
			return self.y;
		}
		else
			return 0;
	}
	
	@Operation(contextual=true)
	public static String showcoordinates(Point self) 
	{
		if (self!=null)
		{
			return "the x is "+ self.x+ "and the y is "+ self.y;
		}
		else
			return "nothing to display";
	}
	
	@Operation(contextual=true)
	public static int rgb2int(RGB self) 
	{
		if (self!=null)
			return self.blue * 0x10000 + self.green *0x100 + self.red;
		else
			return 0;
	}
	
	@Operation(contextual=true)
	public static Element getElement(Uml1SemanticModelBridge bridge) {
		// difference to using element attribute directly: getElement will try to resolve proxies
		// and thus detects elements referenced by the di2 model that do not exist (anymore) in the
		// uml model
		Element element = bridge.getElement();
		if ((element != null) && element.eIsProxy()) {
			// is still proxy (the getElement implementation of Uml1SemanticModelBridge already tried to
			// resolve) => return null
			return null;
		}
		else {
			return element;
		}
	}

	/**
	 * Return the semantic model for a given di2 element
	 * @param di2Element existing di2 element
	 * @return the associated semantic model or null
	 */
	@Operation(contextual=true)
	public static Uml1SemanticModelBridge getSemanticModel(GraphElement di2Element) {
		SemanticModelBridge semanticModel;
		if (di2Element instanceof org.eclipse.papyrus.conversion.di2.Diagram) {
			semanticModel =((org.eclipse.papyrus.conversion.di2.Diagram) di2Element).getOwner();
		}
		else {
			semanticModel = di2Element.getSemanticModel();
		}
		if (semanticModel instanceof Uml1SemanticModelBridge) {
			return (Uml1SemanticModelBridge) semanticModel;
		}
		return null;
	}
	
	@Operation(contextual=true)
	public static Element getElement(GraphElement di2Element) {
		
		Uml1SemanticModelBridge semanticModel = getSemanticModel(di2Element);
		if (semanticModel != null) {
			return getElement (semanticModel);
		}
		else {
			System.err.println("no bridge found for di2Node" + di2Element);
		}
		return null;
	}
	
	// may be useful for debugging (use it instead of getElement in combination with a breakpoint)
	@Operation(contextual=true)
	public static Element getElementDebug(GraphElement di2Element) {
		
		Element element = getElement(di2Element);
		return element;
	}
	
	/**
	 * Papyrus 1 profile diagrams do not reference meta-class elements directly, but the
	 * associated element imported
	 * @param bridge
	 * @return
	 */
	@Operation(contextual=true)
	public static Element getMetaclassRef(Uml1SemanticModelBridge semanticModel) {
		Element element = getElement (semanticModel);
		if (element != null) {
			if (element instanceof ElementImport) {
				return ((ElementImport) element).getImportedElement();
			}
		}
		else {
			System.err.println("no element found");
		}
		return element;
	}
	
	public Object createBendpoints()
	{
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint(0,0,0,0));
		points.add(new RelativeBendpoint(0,0,0,0));
		bendpoints.setPoints(points);
		return bendpoints;
	}
}