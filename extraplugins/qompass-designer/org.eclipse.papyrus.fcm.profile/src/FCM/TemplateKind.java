/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Template Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see FCM.FCMPackage#getTemplateKind()
 * @model
 * @generated
 */
public enum TemplateKind implements Enumerator {
	/**
	 * The '<em><b>Pass Formal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASS_FORMAL_VALUE
	 * @generated
	 * @ordered
	 */
	PASS_FORMAL(0, "PassFormal", "PassFormal"),

	/**
	 * The '<em><b>Loop Operations</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOOP_OPERATIONS_VALUE
	 * @generated
	 * @ordered
	 */
	LOOP_OPERATIONS(1, "LoopOperations", "LoopOperations"),

	/**
	 * The '<em><b>Loop Property</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOOP_PROPERTY_VALUE
	 * @generated
	 * @ordered
	 */
	LOOP_PROPERTY(2, "LoopProperty", "LoopProperty"), /**
	 * The '<em><b>Accumulate</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCUMULATE_VALUE
	 * @generated
	 * @ordered
	 */
	ACCUMULATE(3, "Accumulate", "Accumulate"),

	/**
	 * The '<em><b>Loop Literals</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOOP_LITERALS_VALUE
	 * @generated
	 * @ordered
	 */
	LOOP_LITERALS(4, "LoopLiterals", "LoopLiterals"),

	/**
	 * The '<em><b>Late Evaluation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LATE_EVALUATION_VALUE
	 * @generated
	 * @ordered
	 */
	LATE_EVALUATION(5, "LateEvaluation", "LateEvaluation"), /**
	 * The '<em><b>Loop Ports</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOOP_PORTS_VALUE
	 * @generated
	 * @ordered
	 */
	LOOP_PORTS(6, "LoopPorts", "LoopPorts"), /**
	 * The '<em><b>Pass Classifier</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASS_CLASSIFIER_VALUE
	 * @generated
	 * @ordered
	 */
	PASS_CLASSIFIER(7, "PassClassifier", "PassClassifier");

	/**
	 * The '<em><b>Pass Formal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pass Formal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PASS_FORMAL
	 * @model name="PassFormal"
	 * @generated
	 * @ordered
	 */
	public static final int PASS_FORMAL_VALUE = 0;

	/**
	 * The '<em><b>Loop Operations</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Loop Operations</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOOP_OPERATIONS
	 * @model name="LoopOperations"
	 * @generated
	 * @ordered
	 */
	public static final int LOOP_OPERATIONS_VALUE = 1;

	/**
	 * The '<em><b>Loop Property</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Loop Property</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOOP_PROPERTY
	 * @model name="LoopProperty"
	 * @generated
	 * @ordered
	 */
	public static final int LOOP_PROPERTY_VALUE = 2;

	/**
	 * The '<em><b>Accumulate</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Accumulate</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCUMULATE
	 * @model name="Accumulate"
	 * @generated
	 * @ordered
	 */
	public static final int ACCUMULATE_VALUE = 3;

	/**
	 * The '<em><b>Loop Literals</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Loop Literals</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOOP_LITERALS
	 * @model name="LoopLiterals"
	 * @generated
	 * @ordered
	 */
	public static final int LOOP_LITERALS_VALUE = 4;

	/**
	 * The '<em><b>Late Evaluation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * LateEvaluation is more a tempalte binding rather than a template definition. In
	 * <!-- end-model-doc -->
	 * @see #LATE_EVALUATION
	 * @model name="LateEvaluation"
	 * @generated
	 * @ordered
	 */
	public static final int LATE_EVALUATION_VALUE = 5;

	/**
	 * The '<em><b>Loop Ports</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Loop Ports</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOOP_PORTS
	 * @model name="LoopPorts"
	 * @generated
	 * @ordered
	 */
	public static final int LOOP_PORTS_VALUE = 6;

	/**
	 * The '<em><b>Pass Classifier</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pass Classifier</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PASS_CLASSIFIER
	 * @model name="PassClassifier"
	 * @generated
	 * @ordered
	 */
	public static final int PASS_CLASSIFIER_VALUE = 7;

	/**
	 * An array of all the '<em><b>Template Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TemplateKind[] VALUES_ARRAY =
		new TemplateKind[] {
			PASS_FORMAL,
			LOOP_OPERATIONS,
			LOOP_PROPERTY,
			ACCUMULATE,
			LOOP_LITERALS,
			LATE_EVALUATION,
			LOOP_PORTS,
			PASS_CLASSIFIER,
		};

	/**
	 * A public read-only list of all the '<em><b>Template Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TemplateKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Template Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TemplateKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TemplateKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Template Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TemplateKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TemplateKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Template Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TemplateKind get(int value) {
		switch (value) {
			case PASS_FORMAL_VALUE: return PASS_FORMAL;
			case LOOP_OPERATIONS_VALUE: return LOOP_OPERATIONS;
			case LOOP_PROPERTY_VALUE: return LOOP_PROPERTY;
			case ACCUMULATE_VALUE: return ACCUMULATE;
			case LOOP_LITERALS_VALUE: return LOOP_LITERALS;
			case LATE_EVALUATION_VALUE: return LATE_EVALUATION;
			case LOOP_PORTS_VALUE: return LOOP_PORTS;
			case PASS_CLASSIFIER_VALUE: return PASS_CLASSIFIER;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TemplateKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TemplateKind
