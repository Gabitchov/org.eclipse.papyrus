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
import org.eclipse.swt.graphics.RGB;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Dependency;
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
		if (self instanceof Generalization )
			return true;
		else return false;
	}
	
	
	@Operation(contextual=true)
	public static boolean isAssociation(Element self)
	{
		if (self instanceof Association )
			return true;
		else 
			return false;
	}
	@Operation(contextual=true)
	public static boolean isRealization(Element self)
	{
		if (self instanceof  Realization )
			return true;
		else 
			return false;
	}
	@Operation(contextual=true)
	public static boolean isDependency(Element self)
	{
		if (self instanceof Dependency )
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
			return self.green;
		else
			return 0;
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