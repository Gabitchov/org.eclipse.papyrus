/**
 */
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationFactoryImpl extends EFactoryImpl implements OperationFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static OperationFactory init()
  {
    try
    {
      OperationFactory theOperationFactory = (OperationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/uml/textedit/operation/xtext/Operation"); 
      if (theOperationFactory != null)
      {
        return theOperationFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new OperationFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case OperationPackage.OPERATION_DEFINITION_OR_STUB: return createOperationDefinitionOrStub();
      case OperationPackage.OPERATION_DECLARATION: return createOperationDeclaration();
      case OperationPackage.FORMAL_PARAMETERS: return createFormalParameters();
      case OperationPackage.FORMAL_PARAMETER_LIST: return createFormalParameterList();
      case OperationPackage.FORMAL_PARAMETER: return createFormalParameter();
      case OperationPackage.TYPE_PART: return createTypePart();
      case OperationPackage.MULTIPLICITY: return createMultiplicity();
      case OperationPackage.MULTIPLICITY_RANGE: return createMultiplicityRange();
      case OperationPackage.NUMBER_LITERAL_WITHOUT_SUFFIX: return createNUMBER_LITERAL_WITHOUT_SUFFIX();
      case OperationPackage.INTEGER_LITERAL_WITHOUT_SUFFIX: return createINTEGER_LITERAL_WITHOUT_SUFFIX();
      case OperationPackage.UNLIMITED_LITERAL_WITHOUT_SUFFIX: return createUNLIMITED_LITERAL_WITHOUT_SUFFIX();
      case OperationPackage.TYPE_NAME: return createTypeName();
      case OperationPackage.REDEFINITION_CLAUSE: return createRedefinitionClause();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case OperationPackage.VISIBILITY_INDICATOR:
        return createVisibilityIndicatorFromString(eDataType, initialValue);
      case OperationPackage.PARAMETER_DIRECTION:
        return createParameterDirectionFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case OperationPackage.VISIBILITY_INDICATOR:
        return convertVisibilityIndicatorToString(eDataType, instanceValue);
      case OperationPackage.PARAMETER_DIRECTION:
        return convertParameterDirectionToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationDefinitionOrStub createOperationDefinitionOrStub()
  {
    OperationDefinitionOrStubImpl operationDefinitionOrStub = new OperationDefinitionOrStubImpl();
    return operationDefinitionOrStub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationDeclaration createOperationDeclaration()
  {
    OperationDeclarationImpl operationDeclaration = new OperationDeclarationImpl();
    return operationDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameters createFormalParameters()
  {
    FormalParametersImpl formalParameters = new FormalParametersImpl();
    return formalParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameterList createFormalParameterList()
  {
    FormalParameterListImpl formalParameterList = new FormalParameterListImpl();
    return formalParameterList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameter createFormalParameter()
  {
    FormalParameterImpl formalParameter = new FormalParameterImpl();
    return formalParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypePart createTypePart()
  {
    TypePartImpl typePart = new TypePartImpl();
    return typePart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Multiplicity createMultiplicity()
  {
    MultiplicityImpl multiplicity = new MultiplicityImpl();
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityRange createMultiplicityRange()
  {
    MultiplicityRangeImpl multiplicityRange = new MultiplicityRangeImpl();
    return multiplicityRange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NUMBER_LITERAL_WITHOUT_SUFFIX createNUMBER_LITERAL_WITHOUT_SUFFIX()
  {
    NUMBER_LITERAL_WITHOUT_SUFFIXImpl numbeR_LITERAL_WITHOUT_SUFFIX = new NUMBER_LITERAL_WITHOUT_SUFFIXImpl();
    return numbeR_LITERAL_WITHOUT_SUFFIX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public INTEGER_LITERAL_WITHOUT_SUFFIX createINTEGER_LITERAL_WITHOUT_SUFFIX()
  {
    INTEGER_LITERAL_WITHOUT_SUFFIXImpl integeR_LITERAL_WITHOUT_SUFFIX = new INTEGER_LITERAL_WITHOUT_SUFFIXImpl();
    return integeR_LITERAL_WITHOUT_SUFFIX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UNLIMITED_LITERAL_WITHOUT_SUFFIX createUNLIMITED_LITERAL_WITHOUT_SUFFIX()
  {
    UNLIMITED_LITERAL_WITHOUT_SUFFIXImpl unlimiteD_LITERAL_WITHOUT_SUFFIX = new UNLIMITED_LITERAL_WITHOUT_SUFFIXImpl();
    return unlimiteD_LITERAL_WITHOUT_SUFFIX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeName createTypeName()
  {
    TypeNameImpl typeName = new TypeNameImpl();
    return typeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RedefinitionClause createRedefinitionClause()
  {
    RedefinitionClauseImpl redefinitionClause = new RedefinitionClauseImpl();
    return redefinitionClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VisibilityIndicator createVisibilityIndicatorFromString(EDataType eDataType, String initialValue)
  {
    VisibilityIndicator result = VisibilityIndicator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertVisibilityIndicatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterDirection createParameterDirectionFromString(EDataType eDataType, String initialValue)
  {
    ParameterDirection result = ParameterDirection.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertParameterDirectionToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationPackage getOperationPackage()
  {
    return (OperationPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static OperationPackage getPackage()
  {
    return OperationPackage.eINSTANCE;
  }

} //OperationFactoryImpl
