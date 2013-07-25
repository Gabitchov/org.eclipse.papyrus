/*****************************************************************************
 * Copyright (c) 2013 INTEMPORA S.A.
 *
 * This software is a computer program whose purpose is to transform RobotML models
 * into RTMaps diagrams and RTMaps components via source code generation techniques.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nicolas DU LAC (INTEMPORA) - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.robotml.generators.intempora.rtmaps;

import org.eclipse.papyrus.robotml.generators.common.mmqueries.ArchitectureQueries;

public class RTMapsDataTypeQueries {

	public String getNbElementsInVector(String type_name, String ioelt_name, String return_value_name) {
		if(type_name.compareTo("Bool") == 0 || type_name.compareTo("Int8") == 0 || type_name.compareTo("UInt8") == 0 || type_name.compareTo("Int16") == 0 || type_name.compareTo("UInt16") == 0 || type_name.compareTo("Int32") == 0 || type_name.compareTo("Byte") == 0 || type_name.compareTo("Char") == 0 || type_name.compareTo("UInt32") == 0 || type_name.compareTo("Int64") == 0 || type_name.compareTo("UInt64") == 0 || type_name.compareTo("Time") == 0 || type_name.compareTo("Duration") == 0 || type_name.compareTo("Float32") == 0 || type_name.compareTo("Float64") == 0)

		{
			return "int " + return_value_name + " = " + ioelt_name + "->VectorSize();";
		} else if(type_name.compareTo("String") == 0) {
			return "[Strings are not supported yet.]";
		} else {
			return "int " + return_value_name + " = " + ioelt_name + "->VectorSize() / sizeof(" + type_name + ");";
		}
	}

	public String setVectorSizeForVector(String type_name, int nb_elements, String ioelt_name) {
		if(type_name.compareTo("Bool") == 0 || type_name.compareTo("Int8") == 0 || type_name.compareTo("UInt8") == 0 || type_name.compareTo("Int16") == 0 || type_name.compareTo("UInt16") == 0 || type_name.compareTo("Int32") == 0 || type_name.compareTo("Byte") == 0 || type_name.compareTo("Char") == 0 || type_name.compareTo("UInt32") == 0 || type_name.compareTo("Int64") == 0 || type_name.compareTo("UInt64") == 0 || type_name.compareTo("Time") == 0 || type_name.compareTo("Duration") == 0 || type_name.compareTo("Float32") == 0 || type_name.compareTo("Float64") == 0)

		{
			return ioelt_name + "->VectorSize() = " + nb_elements + ";";
		} else if(type_name.compareTo("String") == 0) {
			return "[Strings are not supported yet.]";
		} else {
			return ioelt_name + "->VectorSize() = " + nb_elements + " * sizeof(" + type_name + ");";
		}
	}

	public String getMAPSIOEltAccessFunction(String type_name, String ioelt_name, String return_var_name) {
		if(type_name.compareTo("Bool") == 0 || type_name.compareTo("Int8") == 0 || type_name.compareTo("UInt8") == 0 || type_name.compareTo("Int16") == 0 || type_name.compareTo("UInt16") == 0 || type_name.compareTo("Int32") == 0) {
			return "MAPSInt32* " + return_var_name + " = &" + ioelt_name + "->Integer32();";
		} else if(type_name.compareTo("Byte") == 0 || type_name.compareTo("Char") == 0) {
			return "char* " + return_var_name + " = " + ioelt_name + "->Stream8();";
		} else if(type_name.compareTo("UInt32") == 0 || type_name.compareTo("Int64") == 0 || type_name.compareTo("UInt64") == 0 || type_name.compareTo("Time") == 0 || type_name.compareTo("Duration") == 0) {
			return "MAPSInt64* " + return_var_name + " = &" + ioelt_name + "->Integer64();";
		} else if(type_name.compareTo("Float32") == 0) {
			return "MAPSFloat32* " + return_var_name + " = &" + ioelt_name + "->Float32();";
		} else if(type_name.compareTo("Float64") == 0) {
			return "MAPSFloat64* " + return_var_name + " = &" + ioelt_name + "->Float64();";
		} else if(type_name.compareTo("String") == 0) {
			return "[Strings are not supported yet.]";
		} else {
			return type_name + "* " + return_var_name + " = (" + type_name + "*)" + ioelt_name + "->Data();";
		}
	}

	public String getMAPSIOEltReturnType(String type_name) {
		if(type_name.compareTo("Bool") == 0 || type_name.compareTo("Int8") == 0 || type_name.compareTo("UInt8") == 0 || type_name.compareTo("Int16") == 0 || type_name.compareTo("UInt16") == 0 || type_name.compareTo("Int32") == 0) {
			return "MAPSInt32*";
		} else if(type_name.compareTo("Byte") == 0 || type_name.compareTo("Char") == 0) {
			return "MAPSUInt8*";
		} else if(type_name.compareTo("UInt32") == 0 || type_name.compareTo("Int64") == 0 || type_name.compareTo("UInt64") == 0 || type_name.compareTo("Time") == 0 || type_name.compareTo("Duration") == 0) {
			return "MAPSInt64*";
		} else if(type_name.compareTo("Float32") == 0) {
			return "MAPSFloat32* ";
		} else if(type_name.compareTo("Float64") == 0) {
			return "MAPSFloat64*";
		} else if(type_name.compareTo("String") == 0) {
			return "MAPSRobotMLString*";
		} else {
			return type_name + "*";
		}

	}

	public String getRTMapsOutputDefForPrimitiveType(String output_name, String type_name, int multiplicity) {
		String s = "MAPS_OUTPUT(\"" + output_name + "\",";
		if(type_name.compareTo("Bool") == 0 || type_name.compareTo("Int8") == 0 || type_name.compareTo("UInt8") == 0 || type_name.compareTo("Int16") == 0 || type_name.compareTo("UInt16") == 0 || type_name.compareTo("Int32") == 0) {
			s += "MAPS::Integer32";
		} else if(type_name.compareTo("Byte") == 0 || type_name.compareTo("Char") == 0) {
			s += "MAPS::Stream8";
		} else if(type_name.compareTo("UInt32") == 0 || type_name.compareTo("Int64") == 0 || type_name.compareTo("UInt64") == 0 || type_name.compareTo("Time") == 0 || type_name.compareTo("Duration") == 0) {
			s += "MAPS::Integer64";
		} else if(type_name.compareTo("Float32") == 0) {
			s += "MAPS::Float32";
		} else if(type_name.compareTo("Float64") == 0) {
			s += "MAPS::Float64";
		} else if(type_name.compareTo("String") == 0) {
			return "MAPS_OUTPUT_USER_STRUCTURE(" + output_name + ",MAPSRobotMLString)";
		}
		s += ",NULL,NULL,";
		if(multiplicity <= 0)
			s += "DEFAULT_MAX_OUTPUT_VECTOR_SIZE";
		else
			s += multiplicity;
		s += ")";
		return s;
	}

	public String getRTMapsInputDefForPrimitiveType(String input_name, String type_name) {
		String s = "MAPS_INPUT(\"" + input_name + "\",";
		if(type_name.compareTo("Bool") == 0 || type_name.compareTo("Int8") == 0 || type_name.compareTo("UInt8") == 0 || type_name.compareTo("Int16") == 0 || type_name.compareTo("UInt16") == 0 || type_name.compareTo("Int32") == 0) {
			s += "MAPS::FilterInteger32";
		} else if(type_name.compareTo("Byte") == 0 || type_name.compareTo("Char") == 0) {
			s += "MAPS::FilterStream8";
		} else if(type_name.compareTo("UInt32") == 0 || type_name.compareTo("Int64") == 0 || type_name.compareTo("UInt64") == 0 || type_name.compareTo("Time") == 0 || type_name.compareTo("Duration") == 0) {
			s += "MAPS::FilterInteger64";
		} else if(type_name.compareTo("Float32") == 0) {
			s += "MAPS::FilterFloat32";
		} else if(type_name.compareTo("Float64") == 0) {
			s += "MAPS::FilterFloat64";
		} else if(type_name.compareTo("String") == 0) {
			s += "MAPSFilterRobotMLString";
		}
		s += ",MAPS::FifoReader)";
		return s;
	}

	public String getPckOutputDir(String dummy) {
		String os = System.getProperty("os.name");
		if(os.toLowerCase().startsWith("linux"))
			return "packages/linux_x86/";
		else
			return "packages/";
	}

	public boolean hasRTMapsNativeImplementation(org.eclipse.uml2.uml.Class c) {
		if(ArchitectureQueries.hasNativeImplementation(c)) {
			if(getRTMapsNativeLibraryPathFromGenericAttribute(c) != null && getRTMapsNativeComponentNameFromGenericAttribute(c) != null) {
				return true;
			}
		}
		return false;
	}

	public String getRTMapsNativeLibraryPathFromGenericAttribute(org.eclipse.uml2.uml.Class c) {
		if(ArchitectureQueries.hasNativeImplementation(c)) {
			String native_libs = ArchitectureQueries.getNativeLibraryPathForComponent(c);
			if(native_libs == null)
				return null;
			return getRTMapsSpecificValueFromStringAttribute(native_libs);
		}
		return null;
	}

	public String getRTMapsNativeComponentNameFromGenericAttribute(org.eclipse.uml2.uml.Class c) {
		if(ArchitectureQueries.hasNativeImplementation(c)) {
			String native_comps = ArchitectureQueries.getNativeComponentNameForComponent(c);
			if(native_comps == null)
				return null;
			return getRTMapsSpecificValueFromStringAttribute(native_comps);
		}
		return null;
	}

	public String getRTMapsSpecificValueFromStringAttribute(String attribute) {
		String[] sections = attribute.split(";");
		for(int i = 0; i < sections.length; i++) {
			String[] key_value = sections[i].split("=");
			if(key_value[0].equalsIgnoreCase("rtmaps")) {
				return key_value[1];
			}
		}
		return null;
	}

}
