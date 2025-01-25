package com.beuben.pokemontcgcollectorbackend.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

import static com.beuben.pokemontcgcollectorbackend.architecture.ArchUnitConstants.*;

@AnalyzeClasses(packages = "com.beuben.pokemontcgcollectorbackend..",
    importOptions = ImportOption.DoNotIncludeTests.class)
public class NamingTest {

  @ArchTest
  public static final ArchRule usecaseClassesMustBeNamedWithUsecaseSuffix =
      ArchRuleDefinition.classes()
          .that().areTopLevelClasses()
          .and().resideInAPackage("..usecase..")
          .should().haveSimpleNameEndingWith(USECASE_SUFFIX);

  @ArchTest
  public static final ArchRule mapperClassesMustBeNamedWithMapperSuffix =
      ArchRuleDefinition.classes()
          .that().areTopLevelClasses()
          .and().resideInAPackage("..mapper..")
          .should().haveSimpleNameEndingWith(MAPPER_SUFFIX);

  @ArchTest
  public static final ArchRule controllerClassesMustBeNamedWithControllerSuffix =
      ArchRuleDefinition.classes()
          .that().resideInAPackage("..controller..")
          .should().haveSimpleNameEndingWith(CONTROLLER_SUFFIX);

  @ArchTest
  public static final ArchRule dtoClassesMustBeNamedWithDTOSuffix =
      ArchRuleDefinition.classes()
          .that().areTopLevelClasses()
          .and().resideInAPackage("..result..")
          .should().haveSimpleNameEndingWith(DTO_SUFFIX);

  @ArchTest
  public static final ArchRule commandClassesMustBeNamedWithCommandSuffix =
      ArchRuleDefinition.classes()
          .that().areTopLevelClasses()
          .and().resideInAPackage("..command..")
          .should().haveSimpleNameEndingWith(COMMAND_SUFFIX);

  @ArchTest
  public static final ArchRule entityClassesMustBeNamedWithEntitySuffix =
      ArchRuleDefinition.classes()
          .that().areTopLevelClasses()
          .and().resideInAPackage("..entity..")
          .should().haveSimpleNameEndingWith(ENTITY_SUFFIX);

  @ArchTest
  public static final ArchRule adapterClassesMustBeNamedWithAdapterSuffix =
      ArchRuleDefinition.classes()
          .that().areTopLevelClasses()
          .and().resideInAPackage("..adapter..")
          .should().haveSimpleNameEndingWith(ADAPTER_SUFFIX);

  @ArchTest
  public static final ArchRule repositoryClassesMustBeNamedWithRepositorySuffix =
      ArchRuleDefinition.classes()
          .that().areTopLevelClasses()
          .and().resideInAPackage("..repository..")
          .should().haveSimpleNameEndingWith(REPOSITORY_SUFFIX);
}
