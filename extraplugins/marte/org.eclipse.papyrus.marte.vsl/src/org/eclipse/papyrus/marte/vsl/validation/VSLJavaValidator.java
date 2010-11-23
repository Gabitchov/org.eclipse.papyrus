/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.vsl.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package; 
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil;
import org.eclipse.papyrus.marte.vsl.extensions.VSLTypeInferenceUtil;
import org.eclipse.papyrus.marte.vsl.scoping.VSLScopeProvider;
import org.eclipse.papyrus.marte.vsl.scoping.VSLScopeProvider.ScopingHelper;
import org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression;
import org.eclipse.papyrus.marte.vsl.vSL.AndOrXorExpression;
import org.eclipse.papyrus.marte.vsl.vSL.BooleanLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple;
import org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression;
import org.eclipse.papyrus.marte.vsl.vSL.DateTimeLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.DefaultLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression;
import org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression;
import org.eclipse.papyrus.marte.vsl.vSL.Expression;
import org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression;
import org.eclipse.papyrus.marte.vsl.vSL.IntegerLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.Interval;
import org.eclipse.papyrus.marte.vsl.vSL.MultiplicativeExpression;
import org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall;  
import org.eclipse.papyrus.marte.vsl.vSL.NullLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.PropertyCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.RealLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression;
import org.eclipse.papyrus.marte.vsl.vSL.StringLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.SuffixExpression;
import org.eclipse.papyrus.marte.vsl.vSL.TimeExpression;
import org.eclipse.papyrus.marte.vsl.vSL.Tuple;
import org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.UnlimitedLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;
import org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair;
import org.eclipse.papyrus.marte.vsl.vSL.ValueSpecification;
import org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration;

public class VSLJavaValidator extends AbstractVSLJavaValidator {
	 
	private static Namespace model ;
	private static Element contextElement ;
	private static Type expectedType ;
	
	public static Type _integer ;
	public static Type _unlimitedNatural ;
	public static Type _real ;
	public static Type _datetime ;
	public static Type _boolean ;
	public static Type _string ;
	public static Type _nfp_duration ;
	
	public static Map<String, Type> opSignatures ;
	public static Map<String, Map<Type,List<Type>>> binaryOpTypeBinding ;
	public static Map<String, Type> unaryOpTypeBinding ;
	
	public static void init(Element _contextElement) {
		contextElement = _contextElement ;
		if (contextElement != null) {
			Element elem = contextElement.getOwner() ;
			while (elem.getOwner() != null) {
				elem = elem.getOwner() ;
			}
			model = (Namespace)elem ;
			boolean typesResolved = false ;
			for (Package importedPackage : model.getImportedPackages()) {
				if (!typesResolved)
					typesResolved = initPredefinedTypes(importedPackage) ;
			}
			if (typesResolved) initPredefinedOpSignatures() ;
		}
	}
	
	/**
	 * @param typeLibrary
	 * @return 
	 */
	private static boolean initPredefinedTypes (Package typeLibrary) {
		for (Element elem : typeLibrary.allOwnedElements()) {
			if (elem instanceof Type) {
				Type t = (Type)elem ;
				if (t.getQualifiedName().equals("MARTE_Library::MARTE_PrimitivesTypes::Boolean"))
					_boolean = t ;
				else if (t.getQualifiedName().equals("MARTE_Library::MARTE_PrimitivesTypes::Integer"))
					_integer = t ;
				else if (t.getQualifiedName().equals("MARTE_Library::MARTE_PrimitivesTypes::String"))
					_string = t ;
				else if (t.getQualifiedName().equals("MARTE_Library::MARTE_PrimitivesTypes::UnlimitedNatural"))
					_unlimitedNatural = t ;
				else if (t.getQualifiedName().equals("MARTE_Library::MARTE_PrimitivesTypes::Real"))
					_real = t ;
				else if (t.getQualifiedName().equals("MARTE_Library::MARTE_PrimitivesTypes::DateTime"))
					_datetime = t ;
				else if (t.getQualifiedName().equals("MARTE_Library::BasicNFP_Types::NFP_Duration")) 
					_nfp_duration = t;
			}
		}
		return _integer != null &&
				_unlimitedNatural != null &&
				_real != null &&
				_datetime != null &&
				_boolean != null &&
				_string != null &&
				_nfp_duration != null; 
	}
	
	/**
	 * 
	 */
	private static void initPredefinedOpSignatures() {
		opSignatures = new HashMap<String, Type>();
		unaryOpTypeBinding = new HashMap<String, Type>() ;
		binaryOpTypeBinding = new HashMap<String, Map<Type, List<Type>>>() ;
		
		//unary ops: +, -, not
		unaryOpTypeBinding.put("+", _integer) ;
		unaryOpTypeBinding.put("+", _real) ;
		unaryOpTypeBinding.put("-", _integer) ;
		unaryOpTypeBinding.put("-", _real) ;
		unaryOpTypeBinding.put("not", _boolean) ;
		
		opSignatures.put("+(" + _integer.getName() + ")", _integer) ;		// +(int) : int
		opSignatures.put("+(" + _real.getName() + ")", _real) ;				// +(real) : real
		opSignatures.put("-(" + _integer.getName() + ")", _integer) ;		// -(int) : int
		opSignatures.put("-(" + _real.getName() + ")", _real) ;				// -(real) : real
		opSignatures.put("not(" + _boolean.getName() + ")", _boolean) ;		// not(boolean) : boolean
		
		//binary ops:

		binaryOpTypeBinding.put("and", new HashMap<Type, List<Type>>()) ;
		binaryOpTypeBinding.put("or", new HashMap<Type, List<Type>>()) ;
		binaryOpTypeBinding.put("xor", new HashMap<Type, List<Type>>()) ;
		binaryOpTypeBinding.put("==", new HashMap<Type, List<Type>>()) ;
		binaryOpTypeBinding.put("<>", new HashMap<Type, List<Type>>()) ;
		binaryOpTypeBinding.put("<", new HashMap<Type, List<Type>>()) ;
		binaryOpTypeBinding.put(">", new HashMap<Type, List<Type>>()) ;
		binaryOpTypeBinding.put("<=", new HashMap<Type, List<Type>>()) ;
		binaryOpTypeBinding.put(">=", new HashMap<Type, List<Type>>()) ;
		binaryOpTypeBinding.put("*", new HashMap<Type, List<Type>>()) ;
		binaryOpTypeBinding.put("/", new HashMap<Type, List<Type>>()) ;
		binaryOpTypeBinding.put("mod", new HashMap<Type, List<Type>>()) ;
		binaryOpTypeBinding.put("+", new HashMap<Type, List<Type>>()) ;
		binaryOpTypeBinding.put("-", new HashMap<Type, List<Type>>()) ;
		
		// and, or, xor
		opSignatures.put("and(" + _boolean.getName() + ',' + _boolean.getName() + ")", _boolean) ;// and(boolean, boolean) : boolean
		opSignatures.put("or(" + _boolean.getName() + ',' + _boolean.getName() + ")", _boolean) ;// or(boolean, boolean) : boolean
		opSignatures.put("xor(" + _boolean.getName() + ',' + _boolean.getName() + ")", _boolean) ;// xor(boolean, boolean) : boolean
		binaryOpTypeBinding.get("and").put(_boolean, new ArrayList<Type>()) ; 
		binaryOpTypeBinding.get("or").put(_boolean, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("xor").put(_boolean, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("and").get(_boolean).add(_boolean) ;
		binaryOpTypeBinding.get("or").get(_boolean).add(_boolean) ;
		binaryOpTypeBinding.get("xor").get(_boolean).add(_boolean) ;
		
		// ==, <>
		opSignatures.put("==(" + _integer.getName() + ',' + _integer.getName() + ")", _boolean) ;// ==(int, int) : boolean
		opSignatures.put("==(" + _real.getName() + ',' + _real.getName() + ")", _boolean) ;// ==(real, real) : boolean
		opSignatures.put("==(" + _integer.getName() + ',' + _real.getName() + ")", _boolean) ;// ==(int, real) : boolean
		opSignatures.put("==(" + _real.getName() + ',' + _integer.getName() + ")", _boolean) ;// ==(real, int) : boolean
		opSignatures.put("==(" + _real.getName() + ',' + _nfp_duration.getName() + ")", _boolean) ;// ==(real, nfp_duration) : boolean
		opSignatures.put("==(" + _boolean.getName() + ',' + _boolean.getName() + ")", _boolean) ;// ==(boolean, boolean) : boolean
		opSignatures.put("==(" + _string.getName() + ',' + _string.getName() + ")", _boolean) ;// ==(string, string) : boolean
		opSignatures.put("==(" + _datetime.getName() + ',' + _datetime.getName() + ")", _boolean) ;// ==(datetime, datetime) : boolean
		opSignatures.put("<>(" + _integer.getName() + ',' + _integer.getName() + ")", _boolean) ;// <>(int, int) : boolean
		opSignatures.put("<>(" + _real.getName() + ',' + _real.getName() + ")", _boolean) ;// <>(real, real) : boolean
		opSignatures.put("<>(" + _integer.getName() + ',' + _real.getName() + ")", _boolean) ;// <>(int, real) : boolean
		opSignatures.put("<>(" + _real.getName() + ',' + _integer.getName() + ")", _boolean) ;// <>(real, int) : boolean
		opSignatures.put("<>(" + _real.getName() + ',' + _nfp_duration.getName() + ")", _boolean) ;// ==(real, nfp_duration) : boolean
		opSignatures.put("<>(" + _boolean.getName() + ',' + _boolean.getName() + ")", _boolean) ;// <>(boolean, boolean) : boolean
		opSignatures.put("<>(" + _string.getName() + ',' + _string.getName() + ")", _boolean) ;// <>(string, string) : boolean
		opSignatures.put("<>(" + _datetime.getName() + ',' + _datetime.getName() + ")", _boolean) ;// <>(datetime, datetime) : boolean
		binaryOpTypeBinding.get("==").put(_integer, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("==").put(_real, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("==").put(_boolean, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("==").put(_string, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("==").put(_datetime, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("==").get(_integer).add(_integer) ;
		binaryOpTypeBinding.get("==").get(_integer).add(_real) ;
		binaryOpTypeBinding.get("==").get(_real).add(_real) ;
		binaryOpTypeBinding.get("==").get(_real).add(_integer) ;
		binaryOpTypeBinding.get("==").get(_real).add(_nfp_duration) ;
		binaryOpTypeBinding.get("==").get(_datetime).add(_datetime) ;
		binaryOpTypeBinding.get("==").get(_boolean).add(_boolean) ;
		binaryOpTypeBinding.get("==").get(_string).add(_string) ;
		binaryOpTypeBinding.get("<>").put(_integer, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<>").put(_real, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<>").put(_boolean, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<>").put(_string, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<>").put(_datetime, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<>").get(_integer).add(_integer) ;
		binaryOpTypeBinding.get("<>").get(_integer).add(_real) ;
		binaryOpTypeBinding.get("<>").get(_real).add(_real) ;
		binaryOpTypeBinding.get("<>").get(_real).add(_integer) ;
		binaryOpTypeBinding.get("<>").get(_real).add(_nfp_duration) ;
		binaryOpTypeBinding.get("<>").get(_datetime).add(_datetime) ;
		binaryOpTypeBinding.get("<>").get(_boolean).add(_boolean) ;
		binaryOpTypeBinding.get("<>").get(_string).add(_string) ;
		
		//'<' | '>' | '<=' | '>='
		opSignatures.put("<(" + _integer.getName() + ',' + _integer.getName() + ")", _boolean) ;// <(int, int) : boolean
		opSignatures.put("<(" + _real.getName() + ',' + _real.getName() + ")", _boolean) ;// <(real, real) : boolean
		opSignatures.put("<(" + _integer.getName() + ',' + _real.getName() + ")", _boolean) ;// <(int, real) : boolean
		opSignatures.put("<(" + _real.getName() + ',' + _integer.getName() + ")", _boolean) ;// <(real, int) : boolean
		opSignatures.put("<(" + _string.getName() + ',' + _string.getName() + ")", _boolean) ;// <(string, string) : boolean
		opSignatures.put("<(" + _nfp_duration.getName() + ',' + _nfp_duration.getName() + ")", _boolean) ;// >(nfp_duration, nfp_duration) : boolean
		opSignatures.put("<(" + _real.getName() + ',' + _nfp_duration.getName() + ")", _boolean) ;// <(nfp_duration, nfp_duration) : boolean
		opSignatures.put("<(" + _datetime.getName() + ',' + _datetime.getName() + ")", _boolean) ;// <(date, date) : boolean
		opSignatures.put(">(" + _integer.getName() + ',' + _integer.getName() + ")", _boolean) ;// >(int, int) : boolean
		opSignatures.put(">(" + _real.getName() + ',' + _real.getName() + ")", _boolean) ;// >(real, real) : boolean
		opSignatures.put(">(" + _integer.getName() + ',' + _real.getName() + ")", _boolean) ;// >(int, real) : boolean
		opSignatures.put(">(" + _real.getName() + ',' + _integer.getName() + ")", _boolean) ;// >(real, int) : boolean
		opSignatures.put(">(" + _nfp_duration.getName() + ',' + _nfp_duration.getName() + ")", _boolean) ;// >(nfp_duration, nfp_duration) : boolean
		opSignatures.put(">(" + _real.getName() + ',' + _nfp_duration.getName() + ")", _boolean) ;// >(nfp_duration, nfp_duration) : boolean
		opSignatures.put(">(" + _string.getName() + ',' + _string.getName() + ")", _boolean) ;// >(string, string) : boolean
		opSignatures.put(">(" + _datetime.getName() + ',' + _datetime.getName() + ")", _boolean) ;// >(date, date) : boolean
		opSignatures.put("<=(" + _integer.getName() + ',' + _integer.getName() + ")", _boolean) ;// <=(int, int) : boolean
		opSignatures.put("<=(" + _real.getName() + ',' + _real.getName() + ")", _boolean) ;// <=(real, real) : boolean
		opSignatures.put("<=(" + _integer.getName() + ',' + _real.getName() + ")", _boolean) ;// <=(int, real) : boolean
		opSignatures.put("<=(" + _real.getName() + ',' + _integer.getName() + ")", _boolean) ;// <=(real, int) : boolean
		opSignatures.put("<=(" + _string.getName() + ',' + _string.getName() + ")", _boolean) ;// <=(string, string) : boolean
		opSignatures.put("<=(" + _nfp_duration.getName() + ',' + _nfp_duration.getName() + ")", _boolean) ;// >(nfp_duration, nfp_duration) : boolean
		opSignatures.put("<=(" + _real.getName() + ',' + _nfp_duration.getName() + ")", _boolean) ;// <=(nfp_duration, nfp_duration) : boolean
		opSignatures.put("<=(" + _datetime.getName() + ',' + _datetime.getName() + ")", _boolean) ;// <=(date, date) : boolean
		opSignatures.put(">=(" + _integer.getName() + ',' + _integer.getName() + ")", _boolean) ;// >=(int, int) : boolean
		opSignatures.put(">=(" + _real.getName() + ',' + _real.getName() + ")", _boolean) ;// >=(real, real) : boolean
		opSignatures.put(">=(" + _integer.getName() + ',' + _real.getName() + ")", _boolean) ;// >=(int, real) : boolean
		opSignatures.put(">=(" + _real.getName() + ',' + _integer.getName() + ")", _boolean) ;// >=(real, int) : boolean
		opSignatures.put(">=(" + _string.getName() + ',' + _string.getName() + ")", _boolean) ;// >=(string, string) : boolean
		opSignatures.put(">=(" + _nfp_duration.getName() + ',' + _nfp_duration.getName() + ")", _boolean) ;// >(nfp_duration, nfp_duration) : boolean
		opSignatures.put(">=(" + _real.getName() + ',' + _nfp_duration.getName() + ")", _boolean) ;// >=(nfp_duration, nfp_duration) : boolean
		opSignatures.put(">=(" + _datetime.getName() + ',' + _datetime.getName() + ")", _boolean) ;// >=(date, date) : boolean
		binaryOpTypeBinding.get("<").put(_integer, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<").put(_real, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<").put(_string, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<").put(_nfp_duration, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<").put(_datetime, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<").get(_integer).add(_integer) ;
		binaryOpTypeBinding.get("<").get(_integer).add(_real) ;
		binaryOpTypeBinding.get("<").get(_real).add(_real) ;
		binaryOpTypeBinding.get("<").get(_real).add(_integer) ;
		binaryOpTypeBinding.get("<").get(_real).add(_nfp_duration) ;
		binaryOpTypeBinding.get("<").get(_nfp_duration).add(_nfp_duration) ;
		binaryOpTypeBinding.get("<").get(_string).add(_string) ;
		binaryOpTypeBinding.get("<").get(_datetime).add(_datetime) ;
		binaryOpTypeBinding.get(">").put(_integer, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get(">").put(_real, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get(">").put(_string, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get(">").put(_nfp_duration, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get(">").put(_datetime, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get(">").get(_integer).add(_integer) ;
		binaryOpTypeBinding.get(">").get(_integer).add(_real) ;
		binaryOpTypeBinding.get(">").get(_real).add(_real) ;
		binaryOpTypeBinding.get(">").get(_real).add(_integer) ;
		binaryOpTypeBinding.get(">").get(_real).add(_nfp_duration) ;
		binaryOpTypeBinding.get(">").get(_nfp_duration).add(_nfp_duration) ;
		binaryOpTypeBinding.get(">").get(_string).add(_string) ;
		binaryOpTypeBinding.get(">").get(_datetime).add(_datetime) ;
		binaryOpTypeBinding.get("<=").put(_integer, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<=").put(_real, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<=").put(_string, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<=").put(_nfp_duration, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<=").put(_datetime, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("<=").get(_integer).add(_integer) ;
		binaryOpTypeBinding.get("<=").get(_integer).add(_real) ;
		binaryOpTypeBinding.get("<=").get(_real).add(_real) ;
		binaryOpTypeBinding.get("<=").get(_real).add(_integer) ;
		binaryOpTypeBinding.get("<=").get(_real).add(_nfp_duration) ;
		binaryOpTypeBinding.get("<=").get(_nfp_duration).add(_nfp_duration) ;
		binaryOpTypeBinding.get("<=").get(_string).add(_string) ;
		binaryOpTypeBinding.get("<=").get(_datetime).add(_datetime) ;
		binaryOpTypeBinding.get(">=").put(_integer, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get(">=").put(_real, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get(">=").put(_string, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get(">=").put(_nfp_duration, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get(">=").put(_datetime, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get(">=").get(_integer).add(_integer) ;
		binaryOpTypeBinding.get(">=").get(_integer).add(_real) ;
		binaryOpTypeBinding.get(">=").get(_real).add(_real) ;
		binaryOpTypeBinding.get(">=").get(_real).add(_integer) ;
		binaryOpTypeBinding.get(">=").get(_real).add(_nfp_duration) ;
		binaryOpTypeBinding.get(">=").get(_nfp_duration).add(_nfp_duration) ;
		binaryOpTypeBinding.get(">=").get(_string).add(_string) ;
		binaryOpTypeBinding.get(">=").get(_datetime).add(_datetime) ;
		
		//'*' | '/' | 'mod'
		opSignatures.put("*(" + _integer.getName() + ',' + _integer.getName() + ")", _integer) ;// *(int, int) : int
		opSignatures.put("*(" + _real.getName() + ',' + _real.getName() + ")", _real) ;// *(real, real) : real
		opSignatures.put("*(" + _real.getName() + ',' + _integer.getName() + ")", _real) ;// *(real, int) : real
		opSignatures.put("*(" + _integer.getName() + ',' + _real.getName() + ")", _real) ;// *(int, real) : real
		opSignatures.put("/(" + _integer.getName() + ',' + _integer.getName() + ")", _integer) ;// /(int, int) : int
		opSignatures.put("/(" + _real.getName() + ',' + _real.getName() + ")", _real) ;// /(real, real) : real
		opSignatures.put("/(" + _real.getName() + ',' + _integer.getName() + ")", _real) ;// /(real, int) : real
		opSignatures.put("/(" + _integer.getName() + ',' + _real.getName() + ")", _real) ;// /(int, real) : real// /(int, int) : int
		opSignatures.put("mod(" + _integer.getName() + ',' + _integer.getName() + ")", _integer) ;// mod(int, int) : int
		binaryOpTypeBinding.get("*").put(_integer, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("*").put(_real, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("*").get(_integer).add(_integer) ;
		binaryOpTypeBinding.get("*").get(_integer).add(_real) ;
		binaryOpTypeBinding.get("*").get(_real).add(_real) ;
		binaryOpTypeBinding.get("*").get(_real).add(_integer) ;
		binaryOpTypeBinding.get("/").put(_integer, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("/").put(_real, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("/").get(_integer).add(_integer) ;
		binaryOpTypeBinding.get("/").get(_integer).add(_real) ;
		binaryOpTypeBinding.get("/").get(_real).add(_real) ;
		binaryOpTypeBinding.get("/").get(_real).add(_integer) ;
		binaryOpTypeBinding.get("mod").put(_integer, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("mod").get(_integer).add(_integer) ;
		
		//'+' | '-'
		opSignatures.put("+(" + _integer.getName() + ',' + _integer.getName() + ")", _integer) ;// +(int, int) : int
		opSignatures.put("+(" + _real.getName() + ',' + _real.getName() + ")", _real) ;// +(real, real) : real
		opSignatures.put("+(" + _real.getName() + ',' + _integer.getName() + ")", _real) ;// +(real, int) : real
		opSignatures.put("+(" + _integer.getName() + ',' + _real.getName() + ")", _real) ;// +(int, real) : real
		opSignatures.put("+(" + _datetime.getName() + ',' + _real.getName() + ")", _datetime) ;// +(date, real) : date
		opSignatures.put("+(" + _datetime.getName() + ',' + _nfp_duration.getName() + ")", _datetime) ;// +(date, nfp_duration) : date
		opSignatures.put("+(" + _nfp_duration.getName() + ',' + _nfp_duration.getName() + ")", _nfp_duration) ;// +(nfp_duration, nfp_duration) : nfp_duration
		opSignatures.put("+(" + _real.getName() + ',' + _datetime.getName() + ")", _datetime) ;// +(real, date) : date
		opSignatures.put("-(" + _integer.getName() + ',' + _integer.getName() + ")", _integer) ;// _(int, int) : int
		opSignatures.put("-(" + _real.getName() + ',' + _real.getName() + ")", _real) ;// -(real, real) : real
		opSignatures.put("-(" + _real.getName() + ',' + _integer.getName() + ")", _real) ;// -(real, int) : real
		opSignatures.put("-(" + _integer.getName() + ',' + _real.getName() + ")", _real) ;// -(int, real) : real
		opSignatures.put("-(" + _datetime.getName() + ',' + _datetime.getName() + ")", _real) ;// -(date, date) : real
		opSignatures.put("-(" + _datetime.getName() + ',' + _nfp_duration.getName() + ")", _datetime) ;// -(date, nfp_duration) : date
		opSignatures.put("-(" + _nfp_duration.getName() + ',' + _nfp_duration.getName() + ")", _nfp_duration) ;// -(nfp_duration, nfp_duration) : nfp_duration
		binaryOpTypeBinding.get("+").put(_integer, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("+").put(_real, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("+").put(_datetime, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("+").put(_nfp_duration, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("+").get(_integer).add(_integer) ;
		binaryOpTypeBinding.get("+").get(_integer).add(_real) ;
		binaryOpTypeBinding.get("+").get(_real).add(_real) ;
		binaryOpTypeBinding.get("+").get(_real).add(_integer) ;
		binaryOpTypeBinding.get("+").get(_real).add(_datetime) ;
		binaryOpTypeBinding.get("+").get(_datetime).add(_real) ;
		binaryOpTypeBinding.get("+").get(_datetime).add(_nfp_duration) ;
		binaryOpTypeBinding.get("+").get(_nfp_duration).add(_nfp_duration) ;
		binaryOpTypeBinding.get("-").put(_integer, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("-").put(_real, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("-").put(_datetime, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("-").put(_nfp_duration, new ArrayList<Type>()) ;
		binaryOpTypeBinding.get("-").get(_integer).add(_integer) ;
		binaryOpTypeBinding.get("-").get(_integer).add(_real) ;
		binaryOpTypeBinding.get("-").get(_real).add(_real) ;
		binaryOpTypeBinding.get("-").get(_real).add(_integer) ;
		binaryOpTypeBinding.get("-").get(_datetime).add(_datetime) ;
		binaryOpTypeBinding.get("-").get(_datetime).add(_nfp_duration) ;
		binaryOpTypeBinding.get("-").get(_nfp_duration).add(_nfp_duration) ;
	}
	
	public static void setExpectedType(Type _expectedType) {
		expectedType = _expectedType;
	}

	public static Type getExpectedType() {
		return expectedType;
	}
	
	public static Namespace getModel() {
		return model ;
	}
	
	public static Element getContextElement() {
		return contextElement ;
	}
	
	public class VSLValidationResult {
		private Type inferedType ;
		private boolean errorFound ;
		private EObject validatedRule ;
		private int validatedFeature ;
		private String errorMessage = "" ;
		
		public VSLValidationResult(EObject validatedRule,
									int validatedFeature,
									Type inferedType, 
									boolean errorFound,
									String errorMessage) {
			this.validatedRule = validatedRule ;
			this.validatedFeature = validatedFeature ;
			this.inferedType = inferedType ;
			this.errorFound = errorFound ;
			this.errorMessage = this.errorMessage + errorMessage ;
		}
		public EObject validatedRule() {return this.validatedRule ;}
		public int validatedFeature() {return this.validatedFeature ;}
		public boolean errorFound() {return this.errorFound ;}
		public Type inferedType() {return this.inferedType ;}
		public String errorMessage() {return this.errorMessage;}
	}
	
	public VSLValidationResult checkBinaryExpression(VSLValidationResult[] validationResults, EList<String> operators) {
		
		String operator = operators.get(0) ;
		Integer potentialErrorFeature = null ;
		EObject potentialErrorSource = validationResults[1].validatedRule() ;
		
		if (operator.equals("+") || operator.equals("-")) { // Additive op
			potentialErrorFeature = VSLPackage.ADDITIVE_EXPRESSION__OP ;
			while (potentialErrorSource != null && ! (potentialErrorSource instanceof AdditiveExpression))
				potentialErrorSource = potentialErrorSource.eContainer() ;
		}
		else if (operator.equals("*") || operator.equals("/") || operator.equals("mod")) { // Multiplicative op
			potentialErrorFeature = VSLPackage.MULTIPLICATIVE_EXPRESSION__OP ;
			while (potentialErrorSource != null && ! (potentialErrorSource instanceof MultiplicativeExpression))
				potentialErrorSource = potentialErrorSource.eContainer() ;
		}
		else if (operator.equals("==") || operator.equals("<>") ) { // Equality op
			potentialErrorFeature = VSLPackage.EQUALITY_EXPRESSION__OP ;
			while (potentialErrorSource != null && ! (potentialErrorSource instanceof EqualityExpression))
				potentialErrorSource = potentialErrorSource.eContainer() ;
		}
		else if (operator.equals("and") || operator.equals("or") || operator.equals("xor")) { // AndOrXor op
			potentialErrorFeature = VSLPackage.AND_OR_XOR_EXPRESSION__OP ;
			while (potentialErrorSource != null && ! (potentialErrorSource instanceof AndOrXorExpression))
				potentialErrorSource = potentialErrorSource.eContainer() ;
		}
		else { // Relational op
			potentialErrorFeature = VSLPackage.RELATIONAL_EXPRESSION__OP ;
			while (potentialErrorSource != null && ! (potentialErrorSource instanceof RelationalExpression))
				potentialErrorSource = potentialErrorSource.eContainer() ;
		}
		
		//EClass contextRuleMetaclass = potentialErrorSource.eClass() ;
		
		VSLValidationResult validationResult = new VSLValidationResult(potentialErrorSource, potentialErrorFeature, validationResults[0].inferedType(), false, "") ;
		
		for (int i = 1 ; i < validationResults.length ; i ++) {
			Type inferedType =  findReturnTypeOfBinaryOperator(operators.get(i-1), 
															   validationResult.inferedType(),
															   validationResults[i].inferedType()) ;
			if (inferedType == null) {
				String errorMessage = "" + VSLErrorMessage.getUndefinedBinaryOperatorSignatureMessage(
																operators.get(i-1),
																validationResult.inferedType().getName(),
																validationResults[i].inferedType().getName()) ;
				return new VSLValidationResult(potentialErrorSource, potentialErrorFeature, null, true, errorMessage) ;
			}
			validationResult = new VSLValidationResult(potentialErrorSource, potentialErrorFeature, inferedType, false, "") ;
		}
		
		return validationResult ;
	}
	
	private Type findReturnTypeOfBinaryOperator(String operator, Type firstOperandType, Type secondOperandType) {
		String signature = "" + operator + "(" + firstOperandType.getName() + ',' + secondOperandType.getName() + ")" ;
		return opSignatures.get(signature) ;
	}
	
	private Type findReturnTypeOfUnaryOperator(String operator, Type operandType) {
		String signature = "" + operator + "(" + operandType.getName() + ")" ;
		return opSignatures.get(signature) ;
	}
	
	public static VSLJavaValidator eInstance = new VSLJavaValidator() ;
	
	public VSLValidationResult checkExpressionRule (Expression exp) {
		return checkAndOrXorExpression(exp.getExp()) ; 
	}
	
	public VSLValidationResult checkAndOrXorExpression(AndOrXorExpression exp) {
		if (exp.getExp().size()==1) {
			return eInstance.checkEqualityExpression(exp.getExp().get(0)) ;
		}
		else {
			boolean errorFound = false ;
			int errorIndex = 0 ;
			VSLValidationResult[] validationResults = new VSLValidationResult[exp.getExp().size()] ;
			for (int i = 0 ; i < exp.getExp().size() && !errorFound ; i ++) {
				validationResults[i] = eInstance.checkEqualityExpression(exp.getExp().get(i)) ;
				errorFound = validationResults[i].errorFound() ;
				errorIndex = i ;
			}
			if (errorFound) return  validationResults[errorIndex];
			
			return eInstance.checkBinaryExpression(validationResults, exp.getOp()) ;
		}
	}
	
	public VSLValidationResult checkEqualityExpression(EqualityExpression exp) {
		if (exp.getExp().size()==1) {
			return eInstance.checkRelationalExpression(exp.getExp().get(0)) ;
		}
		else {
			boolean errorFound = false ;
			int errorIndex = 0 ;
			VSLValidationResult[] validationResults = new VSLValidationResult[exp.getExp().size()] ;
			for (int i = 0 ; i < exp.getExp().size() && !errorFound ; i ++) {
				validationResults[i] = eInstance.checkRelationalExpression(exp.getExp().get(i)) ;
				errorFound = validationResults[i].errorFound() ;
				errorIndex = i ;
			}
			if (errorFound) return  validationResults[errorIndex];
			
			return eInstance.checkBinaryExpression(validationResults, exp.getOp()) ;
		}
	}
	
	public VSLValidationResult checkRelationalExpression(RelationalExpression exp) {
		if (exp.getExp().size()==1) {
			return eInstance.checkConditionalExpression(exp.getExp().get(0)) ;
		}
		else {
			boolean errorFound = false ;
			int errorIndex = 0 ;
			VSLValidationResult[] validationResults = new VSLValidationResult[exp.getExp().size()] ;
			for (int i = 0 ; i < exp.getExp().size() && !errorFound ; i ++) {
				validationResults[i] = eInstance.checkConditionalExpression(exp.getExp().get(i)) ;
				errorFound = validationResults[i].errorFound() ;
				errorIndex = i ;
			}
			if (errorFound) return  validationResults[errorIndex];
			
			return eInstance.checkBinaryExpression(validationResults, exp.getOp()) ;
		}
	}
	
	public VSLValidationResult checkConditionalExpression(ConditionalExpression exp) {
		if (exp.getExp().size()==1) {
			return eInstance.checkAdditiveExpression(exp.getExp().get(0)) ;
		}
		else if (exp.getExp().size()!=3) {
			String errorMessage = VSLErrorMessage.getInvalidNumberOfExpressionsInConditionalExpression() ;
			return new VSLValidationResult(exp, VSLPackage.CONDITIONAL_EXPRESSION, null, true, errorMessage) ;
		}
		else { 
			// first check the condition
			VSLValidationResult conditionValiditionResult = checkAdditiveExpression(exp.getExp().get(0)) ;
			if (conditionValiditionResult.errorFound()) 
				return conditionValiditionResult ;
			else if (conditionValiditionResult.inferedType() != null 
					&& !conditionValiditionResult.inferedType().conformsTo(_boolean)) {
				String errorMessage = VSLErrorMessage.getInvalidExpressionType("Boolean", conditionValiditionResult.inferedType().getName()) ;
				conditionValiditionResult.errorFound = true ;
				conditionValiditionResult.errorMessage = errorMessage ;
				return conditionValiditionResult ;
			}
			// then check the THEN and ELSE expression
			VSLValidationResult thenValidationResult = checkAdditiveExpression(exp.getExp().get(1)) ;
			VSLValidationResult elseValidationResult = checkAdditiveExpression(exp.getExp().get(2)) ;
			if (thenValidationResult.errorFound())
				return thenValidationResult ;
			if (elseValidationResult.errorFound())
				return elseValidationResult ;
			Type thenType = thenValidationResult.inferedType() ;
			Type elseType = elseValidationResult.inferedType() ;
			if (thenType == elseType)
				return new VSLValidationResult(exp, VSLPackage.CONDITIONAL_EXPRESSION, thenType, false, "") ;
			else if (thenType.conformsTo(elseType))
				return new VSLValidationResult(exp, VSLPackage.CONDITIONAL_EXPRESSION, elseType, false, "") ;
			else if (elseType.conformsTo(thenType))
				return new VSLValidationResult(exp, VSLPackage.CONDITIONAL_EXPRESSION, thenType, false, "") ;
			else {
				String errorMessage = VSLErrorMessage.getInvalidExpressionType(thenType.getName(), elseType.getName()) ;
				return new VSLValidationResult(exp.getExp().get(2), VSLPackage.ADDITIVE_EXPRESSION, elseType, true, errorMessage) ;
			}
		}
	}
	
	public VSLValidationResult checkAdditiveExpression(AdditiveExpression exp) {
		if (exp.getExp().size()==1) {
			return eInstance.checkMultiplicativeExpression(exp.getExp().get(0)) ;
		}
		else {
			boolean errorFound = false ;
			int errorIndex = 0 ;
			VSLValidationResult[] validationResults = new VSLValidationResult[exp.getExp().size()] ;
			for (int i = 0 ; i < exp.getExp().size() && !errorFound ; i ++) {
				validationResults[i] = eInstance.checkMultiplicativeExpression(exp.getExp().get(i)) ;
				errorFound = validationResults[i].errorFound() ;
				errorIndex = i ;
			}
			if (errorFound) return  validationResults[errorIndex];
			
			return eInstance.checkBinaryExpression(validationResults, exp.getOp()) ;
		}
	}
	
	public VSLValidationResult checkMultiplicativeExpression(MultiplicativeExpression exp) {
		if (exp.getExp().size()==0) {
			return new VSLValidationResult(exp, 0, null, false, "") ;
		}
		if (exp.getExp().size()==1) {
			return eInstance.checkUnaryExpression(exp.getExp().get(0)) ;
		}
		else {
			boolean errorFound = false ;
			int errorIndex = 0 ;
			VSLValidationResult[] validationResults = new VSLValidationResult[exp.getExp().size()] ;
			for (int i = 0 ; i < exp.getExp().size() && !errorFound ; i ++) {
				validationResults[i] = eInstance.checkUnaryExpression(exp.getExp().get(i)) ;
				errorFound = validationResults[i].errorFound() ;
				errorIndex = i ;
			}
			if (errorFound) return  validationResults[errorIndex];
			
			return eInstance.checkBinaryExpression(validationResults, exp.getOp()) ;
		}
	}
	
	public VSLValidationResult checkUnaryExpression (UnaryExpression exp) {
		Type inferedType = null ;
		if (exp.getUnary() != null) {
			VSLValidationResult nestedUnaryValidationResult = eInstance.checkUnaryExpression(exp.getUnary()) ;
			if (nestedUnaryValidationResult.errorFound())
				return nestedUnaryValidationResult ;
			inferedType = this.findReturnTypeOfUnaryOperator(exp.getOp(), nestedUnaryValidationResult.inferedType()) ;
			if (inferedType == null) {
				String errorMessage = "" + VSLErrorMessage.getUndefinedUnaryOperatorSignatureMessage(exp.getOp(), nestedUnaryValidationResult.inferedType.getName()) ;
				return new VSLValidationResult(exp, VSLPackage.UNARY_EXPRESSION__OP, null, true, errorMessage) ;
			}
		}
		else if (exp.getExp() != null) {
			VSLValidationResult nestedPrimaryValidationResult = eInstance.checkPrimaryExpression(exp.getExp()) ;
			if (nestedPrimaryValidationResult.errorFound())
				return nestedPrimaryValidationResult ;
			else
				inferedType = nestedPrimaryValidationResult.inferedType() ;
		}
		return new VSLValidationResult(exp, 0, inferedType, false, "") ;
	}
	
	public VSLValidationResult checkPrimaryExpression (PrimaryExpression exp) {
		Type inferedType = null ;
		VSLValidationResult prefixValidationResult = eInstance.checkValueSpecification(exp.getPrefix()) ; 
		if (prefixValidationResult.errorFound())
			return prefixValidationResult ;
		inferedType = prefixValidationResult.inferedType() ;
		
		if (exp.getSuffix() != null) {
			VSLValidationResult suffixValidationResult = eInstance.checkSuffixExpression(exp.getSuffix()) ;
			if (suffixValidationResult.errorFound())
				return suffixValidationResult ;
			inferedType = suffixValidationResult.inferedType() ;
		}
		
		return new VSLValidationResult(exp, 0, inferedType, false, "") ;
	}
	
	public VSLValidationResult checkValueSpecification(ValueSpecification valueSpec) {
		Type inferedType = null ;
		if (valueSpec instanceof IntegerLiteralRule)
			inferedType = _integer ;
		else if (valueSpec instanceof UnlimitedLiteralRule)
			inferedType = _unlimitedNatural ;
		else if (valueSpec instanceof RealLiteralRule)
			inferedType = _real ;
		else if (valueSpec instanceof DateTimeLiteralRule)
			inferedType = _datetime ;
		else if (valueSpec instanceof BooleanLiteralRule)
			inferedType = _boolean ;
		else if (valueSpec instanceof StringLiteralRule)
			inferedType = _string ;
		else if (valueSpec instanceof NullLiteralRule) {
			ScopingHelper scopingHelper = VSLScopeProvider.eInstance.new ScopingHelper(valueSpec) ;
			inferedType = scopingHelper.getClassifierForScoping() ;
		}
		else if (valueSpec instanceof DefaultLiteralRule) {
			ScopingHelper scopingHelper = VSLScopeProvider.eInstance.new ScopingHelper(valueSpec) ;
			inferedType = scopingHelper.getClassifierForScoping() ;
		}
		else if (valueSpec instanceof NameOrChoiceOrBehaviorCall) {
			return checkNameOrChoiceOrBehaviorCall((NameOrChoiceOrBehaviorCall)valueSpec) ;
		}
		else if (valueSpec instanceof Interval) {
			return checkInterval((Interval)valueSpec) ;
		}
		else if (valueSpec instanceof CollectionOrTuple) {
			return checkCollectionOrTuple((CollectionOrTuple)valueSpec) ;
		}
		else if (valueSpec instanceof Tuple) {
			return checkTuple((Tuple)valueSpec) ;
		}
		else if (valueSpec instanceof TimeExpression) {
			return checkTimeExpression((TimeExpression)valueSpec) ;
		}
		else if (valueSpec instanceof VariableDeclaration) {
			return checkVariableDeclarion((VariableDeclaration)valueSpec) ;
		}
		else if (valueSpec instanceof Expression) {
			return checkExpressionRule((Expression)valueSpec) ;
		}
		return new VSLValidationResult(valueSpec, 0, inferedType, false, "") ;
	}
	
	
	public VSLValidationResult checkVariableDeclarion(VariableDeclaration valueSpec) {
		Classifier inferedType = valueSpec.getType() != null ? (Classifier)valueSpec.getType().getType() : VSLScopeProvider.eInstance.new ScopingHelper(valueSpec).getClassifierForScoping() ;
		VSLValidationResult initValidationResult = null ;
		if (valueSpec.getInitValue() != null)
			initValidationResult = checkExpressionRule(valueSpec.getInitValue()) ;
		if (initValidationResult != null && initValidationResult.errorFound())
			return initValidationResult ;
		if (initValidationResult != null && initValidationResult.inferedType() != inferedType && !((Classifier)initValidationResult.inferedType()).getGenerals().contains(inferedType)) {
			String errorMessage = VSLErrorMessage.getInvalidExpressionType(inferedType.getName(), initValidationResult.inferedType.getName()) ;
			return new VSLValidationResult(valueSpec.getInitValue(), VSLPackage.EXPRESSION, initValidationResult.inferedType(), true, errorMessage) ;
		}
		
		return new VSLValidationResult(valueSpec, 0, inferedType, false, "");
	}

	public VSLValidationResult checkTimeExpression(TimeExpression valueSpec) {
		Expression index = null ;
		Expression condition = null ;
		Type inferedType = _real ;
		if (valueSpec instanceof InstantObsExpression) {
			inferedType = _datetime ;
			InstantObsExpression instantObs = (InstantObsExpression)valueSpec ;
			index = instantObs.getIndex() ;
			condition = instantObs.getCondition() ; 
		}
		else if (valueSpec instanceof DurationObsExpression) {
			inferedType = _real ;
			DurationObsExpression durationObs = (DurationObsExpression)valueSpec ;
			index = durationObs.getIndex() ;
			condition = durationObs.getCondition() ;
		}
		if (index != null) {
			VSLValidationResult checkIndex = checkExpressionRule(index) ;
			if (checkIndex.errorFound()) 
				return checkIndex ;
			Classifier locallyInferedType = (Classifier)checkIndex.inferedType() ;
			if (locallyInferedType != _integer && !locallyInferedType.getGenerals().contains(_integer) && !locallyInferedType.getName().equals(_integer.getName())) {
				String errorMessage = VSLErrorMessage.getInvalidExpressionType(_integer.getName(), locallyInferedType.getName()) ;
				return new VSLValidationResult(index, VSLPackage.EXPRESSION, locallyInferedType, true, errorMessage) ;
			}
		}
		if (condition != null) {
			VSLValidationResult checkCondition = checkExpressionRule(condition) ;
			if (checkCondition.errorFound()) 
				return checkCondition ;
			Classifier locallyInferedType = (Classifier) checkCondition.inferedType() ;
			if (locallyInferedType != _boolean && !locallyInferedType.getGenerals().contains(_boolean) && !locallyInferedType.getName().equals(_boolean.getName())) {
				String errorMessage = VSLErrorMessage.getInvalidExpressionType(_boolean.getName(), locallyInferedType.getName()) ;
				return new VSLValidationResult(condition, VSLPackage.EXPRESSION, locallyInferedType, true, errorMessage) ;
			}
		}
		
		return new VSLValidationResult(valueSpec, VSLPackage.TIME_EXPRESSION, inferedType, false, "") ;
	}

	public VSLValidationResult checkCollectionOrTuple(CollectionOrTuple valueSpec) {
		List<VSLValidationResult> listOfValidationResults = new ArrayList<VSLJavaValidator.VSLValidationResult>() ;
		if (valueSpec.getListOfValues() != null) {
			for (Expression exp : valueSpec.getListOfValues().getValues()) {
				VSLValidationResult expValidationResult = checkExpressionRule(exp) ;
				listOfValidationResults.add(expValidationResult) ;
				if (expValidationResult.errorFound())
					return expValidationResult ;
			}
		}
		ScopingHelper scopingHelper = VSLScopeProvider.eInstance.new ScopingHelper(valueSpec) ;
		Type expectedType = scopingHelper.getClassifierForScoping() ;
		MultiplicityElement expectedMultiplicity = scopingHelper.getExpectedMultiplicity() ;
		if (VSLContextUtil.isATupleType((Classifier)expectedType)) {
			if (expectedMultiplicity.getUpper() == 1) {
				List<NamedElement> tupleAttribs = VSLContextUtil.getTupleAttribs((Classifier)expectedType) ;
				for (int i = 0 ; i<tupleAttribs.size() && i<listOfValidationResults.size() ; i++) {
					Type inferedType = listOfValidationResults.get(i).inferedType() ;
					Type locallyExpectedType = ((Property)tupleAttribs.get(i)).getType() ;
					if (inferedType != locallyExpectedType && !((Classifier)inferedType).getGenerals().contains(locallyExpectedType)) {
						String errorMessage = "" + VSLErrorMessage.getInvalidExpressionType(locallyExpectedType.getName(), inferedType.getName()) ;
						return new VSLValidationResult(listOfValidationResults.get(i).validatedRule(), VSLPackage.EXPRESSION, inferedType, true, errorMessage) ;
					}
				}
			}
			else {
				for (VSLValidationResult validationResult : listOfValidationResults) {
					Type inferedType = validationResult.inferedType() ;
					if (inferedType != expectedType && ! ((Classifier)expectedType).getGenerals().contains(expectedType)) {
						String errorMessage = "" + VSLErrorMessage.getInvalidExpressionType(expectedType.getName(), inferedType.getName()) ;
						return new VSLValidationResult(validationResult.validatedRule(), VSLPackage.EXPRESSION, inferedType, true, errorMessage) ;
					}
				}
			}
		}
		else if (VSLContextUtil.isACollectionType((Classifier)expectedType)) {
			Property collectionAttib = (Property)VSLContextUtil.getCollectionAttrib((Classifier)expectedType) ;
			Type locallyExpectedType = collectionAttib.getType() ;
			for (VSLValidationResult validationResult : listOfValidationResults) {
				Type inferedType = validationResult.inferedType() ;
				if (inferedType != locallyExpectedType && ! ((Classifier)locallyExpectedType).getGenerals().contains(locallyExpectedType)) {
					String errorMessage = "" + VSLErrorMessage.getInvalidExpressionType(expectedType.getName(), inferedType.getName()) ;
					return new VSLValidationResult(validationResult.validatedRule(), VSLPackage.EXPRESSION, inferedType, true, errorMessage) ;
				}
					
			}
		}
		return new VSLValidationResult(valueSpec, 0, expectedType, false, "") ;
	}

	
	public VSLValidationResult checkSuffixExpression (SuffixExpression exp) {
		if (exp instanceof PropertyCallExpression) {
			return checkPropertyCallExpression((PropertyCallExpression)exp) ;
		}
		else { // instance of OperationCallExpression
			return checkOperationCallExpression((OperationCallExpression)exp) ;
		}
	}
	
	public VSLValidationResult checkPropertyCallExpression (PropertyCallExpression exp) {
		Property p = exp.getProperty() ;
		Type inferedType = null ;
		if (p.getType() == null) {
			String errorMessage = VSLErrorMessage.getUntypedPropertyMessage(p.getName()) ;
			return new VSLValidationResult(exp, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ID, null, true, errorMessage) ;
		}
		else
			inferedType = p.getType() ;
		if (exp.getSuffix() != null) {
			VSLValidationResult suffixValidationResult = eInstance.checkSuffixExpression(exp.getSuffix()) ;
			if (suffixValidationResult.errorFound())
				return suffixValidationResult ;
			inferedType = suffixValidationResult.inferedType() ;
		}
		 
		return new VSLValidationResult(exp, VSLPackage.PROPERTY_CALL_EXPRESSION, inferedType, false, "") ;
	}
	
	public VSLValidationResult checkOperationCallExpression (OperationCallExpression exp) {
		Operation b = exp.getOperation() ;
		Type inferedType = null ;
		Type returnType = null ;
		List<String> expectedTypeNames = new ArrayList<String>() ;
		for (int i = 0 ; i < b.getOwnedParameters().size(); i++) {
			Parameter p = b.getOwnedParameters().get(i) ;
			if (p.getDirection() == ParameterDirectionKind.RETURN_LITERAL)
				returnType = p.getType() ;
			else
				expectedTypeNames.add(p.getType().getName()) ;
		}
		if (returnType == null) {
			String errorMessage = VSLErrorMessage.getOperationWithoutReturnParameterMessage(b.getName()) ;
			return new VSLValidationResult(exp, VSLPackage.OPERATION_CALL_EXPRESSION__OPERATION, null, true, errorMessage) ;
		}
		else {
			inferedType = returnType ;
			if (exp.getArguments() == null && (b.getOwnedParameters().size()-1)>0) { // -1 => retrieves the return parameter
				String errorMessage = VSLErrorMessage.getInvalidNumberOfArgumentsForOperationCall(b.getName(), expectedTypeNames) ;
				return new VSLValidationResult(exp, VSLPackage.OPERATION_CALL_EXPRESSION__ARGUMENTS, inferedType, true, errorMessage) ;
			}
			else {
				if (exp.getArguments()!=null ) { // -1 => retrieves the return parameter
					if ((exp.getArguments().getValues().size() != b.getOwnedParameters().size()-1)) {
						String errorMessage = VSLErrorMessage.getInvalidNumberOfArgumentsForOperationCall(b.getName(), expectedTypeNames) ;
						return new VSLValidationResult(exp, VSLPackage.OPERATION_CALL_EXPRESSION__ARGUMENTS, inferedType, true, errorMessage) ;
					}
					List<Parameter> inOutParameters = new ArrayList<Parameter>() ;
					for (Parameter p : b.getOwnedParameters())
						if (p.getDirection() != ParameterDirectionKind.RETURN_LITERAL)
							inOutParameters.add(p) ;
					List<VSLValidationResult> argumentValidationResults = new ArrayList<VSLJavaValidator.VSLValidationResult>() ;
					for (Expression e : exp.getArguments().getValues()) {
						VSLValidationResult argumentValidationResult = checkExpressionRule(e) ;
						argumentValidationResults.add(argumentValidationResult) ;
						if (argumentValidationResult.errorFound())
							return argumentValidationResult ;
					}

					List<String> foundTypeNames = new ArrayList<String>() ;
					boolean errorFound = false ;
					for (int i = 0 ; i<argumentValidationResults.size() ; i++) {
						Type expectedType = inOutParameters.get(i).getType() ;
						Type foundType = argumentValidationResults.get(i).inferedType() ;
						foundTypeNames.add(foundType.getName()) ;
						if (VSLContextUtil.isAChoiceType((Classifier)expectedType)) {
							boolean choiceAttribFound = false ;
							List<NamedElement> allChoiceAttribs = VSLContextUtil.getChoiceAttribs((Classifier)expectedType) ;
							for (NamedElement choiceAttrib : allChoiceAttribs) {
								Property p = (Property)choiceAttrib ;
								if (foundType.conformsTo(p.getType()))
									choiceAttribFound = true ;
							}
							if (! choiceAttribFound) {
								if (! foundType.conformsTo(expectedType))
									errorFound = true ;
							}
						}
						else 
							if (! foundType.conformsTo(expectedType)) errorFound = true ;
					}
					if (errorFound) {
						String errorMessage = VSLErrorMessage.getInvalidArgumentsForOperationCall(b.getName(), expectedTypeNames, foundTypeNames) ;
						return new VSLValidationResult(exp, VSLPackage.OPERATION_CALL_EXPRESSION__ARGUMENTS, inferedType, errorFound, errorMessage) ;
					}
				}
			}
		}
		if (exp.getSuffix() != null) {
			VSLValidationResult suffixValidationResult = eInstance.checkSuffixExpression(exp.getSuffix()) ;
			if (suffixValidationResult.errorFound())
				return suffixValidationResult ;
			inferedType = suffixValidationResult.inferedType() ;
		}
		return new VSLValidationResult(exp, VSLPackage.OPERATION_CALL_EXPRESSION, inferedType, false, "") ;
	}
	
	public VSLValidationResult checkInterval(Interval interval) {
		
		
		if (interval.getLower() == null) {
			return new VSLValidationResult(interval, VSLPackage.INTERVAL__LOWER, null, true, "") ;
		}
		else if (interval.getUpper() == null) {
			return new VSLValidationResult(interval, VSLPackage.INTERVAL__UPPER, null, true, "") ;
		}	
		VSLValidationResult lowerValidationResult = checkExpressionRule(interval.getLower()) ;
		if (lowerValidationResult.errorFound())
			return lowerValidationResult ;
		VSLValidationResult upperValidationResult = checkExpressionRule(interval.getUpper()) ;
		if (upperValidationResult.errorFound())
			return upperValidationResult ;
		
		ScopingHelper scopingHelper = VSLScopeProvider.eInstance.new ScopingHelper(interval) ;
		Type expectedType = scopingHelper.getClassifierForScoping() ;
		if (VSLContextUtil.isAnIntervalType((Classifier)expectedType)) {
			Property intervalAttrib = (Property)VSLContextUtil.getIntervalAttrib((Classifier)expectedType) ;
			expectedType = intervalAttrib.getType() ;
		}
		
		Type lowerType = lowerValidationResult.inferedType() ;
		if (lowerType == null || (lowerType != expectedType && !((Classifier)lowerType).getGenerals().contains(expectedType))) {
			String errorMessage = VSLErrorMessage.getInvalidExpressionType(expectedType.getName(), lowerType != null ? lowerType.getName() : "NULL") ;
			return new VSLValidationResult(interval.getLower(), VSLPackage.EXPRESSION, lowerType, true, errorMessage) ;
		}
		Type upperType = upperValidationResult.inferedType() ;
		if (upperType == null || (upperType != expectedType && !((Classifier)upperType).getGenerals().contains(expectedType))) {
			String errorMessage = VSLErrorMessage.getInvalidExpressionType(expectedType.getName(), upperType != null ? upperType.getName() : "NULL") ;
			return new VSLValidationResult(interval.getUpper(), VSLPackage.EXPRESSION, upperType, true, errorMessage) ;
		}
		
		return new VSLValidationResult(interval, VSLPackage.INTERVAL, expectedType, false, "") ;
	}
	
	
	public VSLValidationResult checkNameOrChoiceOrBehaviorCall(NameOrChoiceOrBehaviorCall exp) {
		Type inferedType = null ;
		if (exp.getId() != null) {
			// First handle the case where if a stereotype or metaclass instance is expected
			// This is normally out of the scope of VSL, but has been added for convenience
			ScopingHelper helper = VSLScopeProvider.eInstance.new ScopingHelper(exp.eContainer()) ;
			if (helper.isExpectedTypeAStereotype()) { 
				// errors are automatically handled by scoping
				Stereotype expectedStereotype = (Stereotype) helper.getClassifierForScoping() ;
				return new VSLValidationResult(exp, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL , expectedStereotype, false, "") ;
			}
			else if (helper.isExpectedTypeAUMLMetaclass()) {
				// errors are automatically handled by scoping
				org.eclipse.uml2.uml.Class expectedMetaclass = (org.eclipse.uml2.uml.Class) helper.getClassifierForScoping() ;
				return new VSLValidationResult(exp, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL , expectedMetaclass, false, "") ;
			}
			// default cases
			else if (exp.getId() instanceof Property) {
				Property p = (Property)exp.getId() ;
				if (p.getType() == null) {
					String errorMessage = VSLErrorMessage.getUntypedPropertyMessage(p.getName()) ;
					return new VSLValidationResult(exp, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ID, inferedType, true, errorMessage) ;
				}
				else {
					inferedType = p.getType() ;
					if (VSLContextUtil.isAChoiceType((Classifier)p.getOwner())) {
						if (exp.getArguments() == null || exp.getArguments().getValues().isEmpty()) {
							String errorMessage = VSLErrorMessage.getMissingArgumentForChosenAlternativeMessage(p.getName(), p.getType().getName()) ;
							return new VSLValidationResult(exp, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS, null, true, errorMessage) ;
						}
						else if (exp.getArguments().getValues().size() > 1) {
							String errorMessage = VSLErrorMessage.getTooManyArgumentsForChosenAlternativeMessage(p.getName(), p.getType().getName()) ;
							return new VSLValidationResult(exp, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS, null, true, errorMessage) ;
						}
						else { // number of arguments == 1
							VSLValidationResult nestedArgumentValidationResult = checkExpressionRule(exp.getArguments().getValues().get(0)) ;
							if (nestedArgumentValidationResult.errorFound())
								return nestedArgumentValidationResult ;
							ScopingHelper scopingHelper = VSLScopeProvider.eInstance.new ScopingHelper(exp.getArguments().getValues().get(0)) ;
							if (! nestedArgumentValidationResult.inferedType().conformsTo(scopingHelper.getClassifierForScoping())) {
								String errorMessage = VSLErrorMessage.getInvalidArgumentForChosenAlternativeMessage(p.getName(), 
																									scopingHelper.getClassifierForScoping().getName(), 
																									nestedArgumentValidationResult.inferedType().getName()) ;
								return new VSLValidationResult(exp.getArguments().getValues().get(0), VSLPackage.EXPRESSION, inferedType, true, errorMessage) ;
							}
						}
					}
				}
			}
			else if (exp.getId() instanceof EnumerationLiteral) {
				EnumerationLiteral literal = (EnumerationLiteral)exp.getId() ;
				return new VSLValidationResult(exp, 0, literal.getEnumeration(), false, "") ;
			}
			else if (exp.getId() instanceof Behavior) {
				Behavior b = (Behavior)exp.getId() ;
				Type returnType = null ;
				List<String> expectedTypeNames = new ArrayList<String>() ;
				for (int i = 0 ; i < b.getOwnedParameters().size(); i++) {
					Parameter p = b.getOwnedParameters().get(i) ;
					if (p.getDirection() == ParameterDirectionKind.RETURN_LITERAL)
						returnType = p.getType() ;
					else
						expectedTypeNames.add(p.getType().getName()) ;
				}
				if (returnType == null) {
					String errorMessage = VSLErrorMessage.getBehaviorWithoutReturnParameterMessage(b.getName()) ;
					return new VSLValidationResult(exp, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ID, inferedType, true, errorMessage) ;
				}
				else {
					inferedType = returnType ;
					if (exp.getArguments() == null && expectedTypeNames.size()>0) {
						String errorMessage = VSLErrorMessage.getMissingArgumentsForBehaviorCall(b.getName(), expectedTypeNames) ;
						return new VSLValidationResult(exp, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS, inferedType, true, errorMessage) ;
					}
					else if (exp.getArguments() != null && exp.getArguments().getValues().size() != b.getOwnedParameters().size()-1) { // -1 => retrieves the return parameter
						String errorMessage = VSLErrorMessage.getInvalidNumberOfArgumentsForBehaviorCall(b.getName(), expectedTypeNames) ;
						return new VSLValidationResult(exp, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS, inferedType, true, errorMessage) ;
					}
					else {
						List<Parameter> inOutParameters = new ArrayList<Parameter>() ;
						for (Parameter p : b.getOwnedParameters())
							if (p.getDirection() != ParameterDirectionKind.RETURN_LITERAL)
								inOutParameters.add(p) ;
						List<VSLValidationResult> argumentValidationResults = new ArrayList<VSLJavaValidator.VSLValidationResult>() ;
						if (exp.getArguments() != null)
							for (Expression e : exp.getArguments().getValues()) {
								VSLValidationResult argumentValidationResult = checkExpressionRule(e) ;
								argumentValidationResults.add(argumentValidationResult) ;
								if (argumentValidationResult.errorFound())
									return argumentValidationResult ;
							}
						
						List<String> foundTypeNames = new ArrayList<String>() ;
						boolean errorFound = false ;
						for (int i = 0 ; i<argumentValidationResults.size() ; i++) {
							Type expectedType = inOutParameters.get(i).getType() ;
							Type foundType = argumentValidationResults.get(i).inferedType() ;
							if (foundType == null) {
								errorFound = true ;
							}
							else {
								foundTypeNames.add(foundType.getName()) ;
								if (! foundType.conformsTo(expectedType)) errorFound = true ;
							}
						}
						if (errorFound) {
							String errorMessage = VSLErrorMessage.getInvalidArgumentsForBehaviorCall(b.getName(), expectedTypeNames, foundTypeNames) ;
							return new VSLValidationResult(exp, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS, inferedType, errorFound, errorMessage) ;
						}
					}
				}
			}
		}
		return new VSLValidationResult(exp, 0, inferedType, false, "") ;
	}

	public VSLValidationResult checkTuple(Tuple exp) {
		ScopingHelper scopingHelper = VSLScopeProvider.eInstance.new ScopingHelper(exp) ;
		for (ValueNamePair vnp : exp.getListOfValueNamePairs().getValueNamePairs()) {
			VSLValidationResult valueNamePairValidationResult = checkValueNamePair(vnp) ;
			if (valueNamePairValidationResult.errorFound())
				return valueNamePairValidationResult ;
		}
		Classifier classifierForScoping = scopingHelper.getClassifierForScoping() ;
		if (VSLContextUtil.isATupleType(classifierForScoping))
			return new VSLValidationResult(exp, VSLPackage.TUPLE, classifierForScoping, false, "") ;
		else
			// Temporary solution: We have a tuple expression, and the expected type is not a tuple. The following implementation forces
			// the type of the expression to be an nfp_duration (which is inline with the temporary implementation of scoping)
			// TODO : Make it generic, and rely on the stereotype <<Operator>> to infer the type of a tuple expression, 
			// when it is used as an argument for a binary operator
			return new VSLValidationResult(exp, VSLPackage.TUPLE, _nfp_duration, false, "") ;
	}
	
	public VSLValidationResult checkValueNamePair(ValueNamePair exp) {
		if (exp.getProperty() == null) {
			return new VSLValidationResult(exp, VSLPackage.VALUE_NAME_PAIR__PROPERTY, null, true, "") ;
		}
		else if (exp.getProperty().getType() == null) {
			String errorMessage = VSLErrorMessage.getUntypedPropertyMessage(exp.getProperty().getName()) ;
			return new VSLValidationResult(exp, VSLPackage.VALUE_NAME_PAIR__PROPERTY, null, true, errorMessage) ;
		}	
		VSLValidationResult valueValidationResult = checkExpressionRule(exp.getValue()) ;
		if (valueValidationResult.errorFound())
			return valueValidationResult ;
		Type inferedType = valueValidationResult.inferedType() ;
		if (inferedType.getName().equals(exp.getProperty().getType().getName()))
			return new VSLValidationResult(exp, VSLPackage.VALUE_NAME_PAIR, inferedType, false, "") ;
		else if (!inferedType.conformsTo(exp.getProperty().getType())) {
			String errorMessage = VSLErrorMessage.getInvalidExpressionType(exp.getProperty().getType().getName(), inferedType.getName()) ;
			return new VSLValidationResult(exp.getValue(), VSLPackage.EXPRESSION, inferedType, true, errorMessage) ;
		}
		return new VSLValidationResult(exp, VSLPackage.VALUE_NAME_PAIR, inferedType, false, "") ;
	}
	
	public static CollectionOrTuple isACollection(Expression exp) {
		return isACollection(exp.getExp()) ;
	}
	
	private static CollectionOrTuple isACollection(AndOrXorExpression exp) {
		return isACollection(exp.getExp().get(0)) ;
	}
	
	private static CollectionOrTuple isACollection(EqualityExpression exp) {
		return isACollection(exp.getExp().get(0)) ;
	}
	
	private static CollectionOrTuple isACollection(RelationalExpression exp) {
		return isACollection(exp.getExp().get(0)) ;
	}
	
	private static CollectionOrTuple isACollection(ConditionalExpression exp) {
		if (exp.getExp().size() == 1)
			return isACollection(exp.getExp().get(0)) ;
		if (exp.getExp().size() == 3) {
			CollectionOrTuple coll = isACollection(exp.getExp().get(1)) ;
			return coll != null ? isACollection(exp.getExp().get(2)) : null ;
		}
		return null ;
	}
	
	private static CollectionOrTuple isACollection(AdditiveExpression exp) {
		return isACollection(exp.getExp().get(0)) ;
	}
	
	private static CollectionOrTuple isACollection(MultiplicativeExpression exp) {
		return exp.getExp().isEmpty() ? null : isACollection(exp.getExp().get(0)) ;
	}
	
	private static CollectionOrTuple isACollection(UnaryExpression exp) {
		return isACollection(exp.getExp()) ;
	}
	
	private static CollectionOrTuple isACollection(PrimaryExpression exp) {
		return exp.getSuffix() == null ? isACollection(exp.getPrefix()) : null ;
	}
	
	private static CollectionOrTuple isACollection(ValueSpecification exp) {
		return exp instanceof CollectionOrTuple ? (CollectionOrTuple) exp : null ;
	}
}

