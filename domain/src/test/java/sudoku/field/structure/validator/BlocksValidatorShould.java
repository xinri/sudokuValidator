package sudoku.field.structure.validator;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author hlay
 * @version 1.0
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/blocks/blockValidation.feature", glue = "")
public class BlocksValidatorShould {

}
