package com.beuben.pokemontcgcollectorbackend.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "com.beuben.pokemontcgcollectorbackend..",
    importOptions = ImportOption.DoNotIncludeTests.class)
public class IdentityTest {

  @ArchTest
  public static final ArchRule portClassesMustBeInterfaces =
      ArchRuleDefinition.classes()
          .that().resideInAPackage("..port..")
          .should().beInterfaces();

  @ArchTest
  public static final ArchRule dtoClassesMustBeRecordsOrEnums =
      ArchRuleDefinition.classes()
          .that().areTopLevelClasses()
          .and().resideInAPackage("..result..")
          .should().beRecords()
          .orShould().beEnums();
}
