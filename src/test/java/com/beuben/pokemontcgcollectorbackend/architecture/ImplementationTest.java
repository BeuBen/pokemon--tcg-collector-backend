package com.beuben.pokemontcgcollectorbackend.architecture;

import com.beuben.pokemontcgcollectorbackend.architecture.rules.ImplementAtLeastOneInterfaceCondition;
import com.beuben.pokemontcgcollectorbackend.architecture.rules.ImplementOnlyInterfaceFromPackageCondition;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "com.beuben.pokemontcgcollectorbackend..",
    importOptions = ImportOption.DoNotIncludeTests.class)
public class ImplementationTest {

  @ArchTest
  public static final ArchRule usecaseClassesMustImplementInterfaces =
      ArchRuleDefinition.classes()
          .that().resideInAPackage("..usecase..")
          .should(ImplementAtLeastOneInterfaceCondition.implementAtLeastOneInterface());

  @ArchTest
  public static final ArchRule usecaseClassesMustImplementOnlyPortInInterfaces =
      ArchRuleDefinition.classes()
          .that().resideInAPackage("..usecase..")
          .should(ImplementOnlyInterfaceFromPackageCondition.implementOnlyInterfaceFromPackage("application.port.in"));

  @ArchTest
  public static final ArchRule adapterClassesMustImplementInterfaces =
      ArchRuleDefinition.classes()
          .that().resideInAPackage("..adapter..")
          .and().areNotEnums()
          .should(ImplementAtLeastOneInterfaceCondition.implementAtLeastOneInterface());

  @ArchTest
  public static final ArchRule adapterClassesMustImplementOnlyPortOutInterfaces =
      ArchRuleDefinition.classes()
          .that().resideInAPackage("..adapter..")
          .and().areNotEnums()
          .should(ImplementOnlyInterfaceFromPackageCondition.implementOnlyInterfaceFromPackage("application.port.out"));
}
