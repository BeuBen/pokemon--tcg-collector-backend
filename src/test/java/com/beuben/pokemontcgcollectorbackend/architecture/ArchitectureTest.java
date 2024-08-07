package com.beuben.pokemontcgcollectorbackend.architecture;

import com.beuben.pokemontcgcollectorbackend.architecture.rules.HaveAssociatedTestClassCondition;
import com.beuben.pokemontcgcollectorbackend.architecture.rules.HaveThreeParametersMaxCondition;
import com.beuben.pokemontcgcollectorbackend.architecture.rules.ImplementMethodCondition;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

import static com.beuben.pokemontcgcollectorbackend.architecture.ArchUnitConstants.EXECUTE_METHOD;

@AnalyzeClasses(packages = "com.beuben.pokemontcgcollectorbackend..",
    importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchitectureTest {

  @ArchTest
  public static final ArchRule usecaseClassesMustHaveAnExecuteMethod =
      ArchRuleDefinition.classes()
          .that().resideInAPackage("..usecase..")
          .should(ImplementMethodCondition.implementMethod(EXECUTE_METHOD));

  @ArchTest
  public static final ArchRule mapperClassesMustHaveAssociatedTestClass =
      ArchRuleDefinition.classes()
          .that().resideInAPackage("..mapper..")
          .and().areInterfaces()
          .should(HaveAssociatedTestClassCondition.haveAssociatedTestClass());

  // TODO uncomment when i will find a way to test controllers with testcontainers
//  @ArchTest
//  public static final ArchRule controllerClassesMustHaveAssociatedTestClass =
//      ArchRuleDefinition.classes()
//          .that().resideInAPackage("..controller..")
//          .should(HaveAssociatedTestClassCondition.haveAssociatedTestClass());

  @ArchTest
  public static final ArchRule methodsMustHaveThreeParametersMax =
      ArchRuleDefinition.methods()
          .that().areDeclaredInClassesThat().areTopLevelClasses()
          .and().areDeclaredInClassesThat().resideOutsideOfPackages("..controller..", "..core.configuration..")
          .should(HaveThreeParametersMaxCondition.haveThreeParametersMax());
}
