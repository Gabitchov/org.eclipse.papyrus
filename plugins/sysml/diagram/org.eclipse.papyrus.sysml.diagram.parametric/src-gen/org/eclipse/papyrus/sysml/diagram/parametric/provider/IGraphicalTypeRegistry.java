package org.eclipse.papyrus.sysml.diagram.parametric.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * This interface provides an API for accessing the local graphical type registry.
 * This registry provides a graphical type for existing model elements.
 */
public interface IGraphicalTypeRegistry {

	/** Constant for undefined graphical type */
	public static final String UNDEFINED_TYPE = "undefined_type";

	/**
	 * Get a valid edge graphical type for the domain element.
	 * 
	 * @param domainElement
	 *        the domain element.
	 * @return the domain element graphical type.
	 */
	public String getEdgeGraphicalType(EObject domainElement);
	
	/**
	 * Get a valid edge graphical type for the element type.
	 * 
	 * @param elementType
	 *        the element type.
	 * @param containerType
	 *        the type of the graphical owner of the domain element.
	 * @return the domain element graphical type.
	 */
	public String getEdgeGraphicalType(IElementType elementType);
	
	/**
	 * Get a valid edge graphical type for the proposed type.
	 * 
	 * @param proposedType
	 *        the proposed type.
	 * @param containerType
	 *        the type of the graphical owner of the domain element.
	 * @return the domain element graphical type.
	 */
	public String getEdgeGraphicalType(String proposedType);
	
	/**
	 * Get a valid node graphical type for the domain element.
	 * 
	 * @param domainElement
	 *        the domain element.
	 * @param containerType
	 *        the type of the graphical owner of the domain element.
	 * @return the domain element graphical type.
	 */
	public String getNodeGraphicalType(EObject domainElement, String containerType);
	
	/**
	 * Get a valid node graphical type for the element type.
	 * 
	 * @param elementType
	 *        the element type.
	 * @param containerType
	 *        the type of the graphical owner of the domain element.
	 * @return the domain element graphical type.
	 */
	public String getNodeGraphicalType(IElementType elementType, String containerType);
	
	/**
	 * Get a valid node graphical type for the proposed type.
	 * 
	 * @param proposedType
	 *        the proposed type.
	 * @param containerType
	 *        the type of the graphical owner of the domain element.
	 * @return the domain element graphical type.
	 */
	public String getNodeGraphicalType(String proposedType, String containerType);
	
	/**
	 * Test if the type is a known edge graphical type in this diagram
	 * 
	 * @param type
	 *        the type to test
	 * @return true if the type is known
	 */
	public boolean isKnownEdgeType(String type);
	
	/**
	 * Test if the type is a known node graphical type in this diagram
	 * 
	 * @param type
	 *        the type to test
	 * @return true if the type is known
	 */
	public boolean isKnownNodeType(String type);

}
