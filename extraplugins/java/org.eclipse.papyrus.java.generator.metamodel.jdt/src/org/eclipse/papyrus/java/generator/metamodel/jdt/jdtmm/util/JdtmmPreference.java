package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.util;

public class JdtmmPreference {

	private static String classMultiValue = "List";

	/**
	 * Set value of class used for the MultiValue
	 * 
	 * @param classMultiValue
	 */
	public static void setClassMultiValue(String classMultiValue) {
		JdtmmPreference.classMultiValue = classMultiValue;
	}

	/**
	 * get value of class used for the MultiValue
	 * 
	 * @param classMultiValue
	 */
	public static String getMultiValued(String typeName) {
		return classMultiValue + "<" + getPrimiveTypeClass(typeName) + ">";
	}

	/**
	 * return the Class of a primitive type (ex : int => Integer)
	 * 
	 * @param typename
	 * @return true if typename is a primive type
	 */
	private static String getPrimiveTypeClass(String typename) {
		if(typename.equals("byte"))
			return "Byte";
		if(typename.equals("char"))
			return "Character";
		if(typename.equals("double"))
			return "Double";
		if(typename.equals("float"))
			return "Float";
		if(typename.equals("int"))
			return "Integer";
		if(typename.equals("long"))
			return "Long";
		if(typename.equals("short"))
			return "Short";
		if(typename.equals("boolean"))
			return "Boolean";
		return typename;
	}
}
