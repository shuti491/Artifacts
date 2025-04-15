package hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

//@RunWith(JUnitPlatform.class)
@Execution(ExecutionMode.CONCURRENT)

public class CalcTest {
  private Calc basicSalaryCalculator;

  @BeforeEach
  void init() {
    basicSalaryCalculator = new Calc();
  }

  @Test
  void testBasicSalaryWithValidSalary() throws InterruptedException {
		Thread.sleep(5000);
    	System.out.println("Test1 Running " + this.getClass().getSimpleName() +
                " on " + Thread.currentThread().getName());
    double basicSalary = 4000;
    basicSalaryCalculator.setBasicSalary(basicSalary);

    double expectedSocialInsurance = basicSalary * 0.25;
    assertEquals(expectedSocialInsurance,
      basicSalaryCalculator.getSocialInsurance());

    double expectedAddionalBonus = basicSalary * 0.1;
    assertEquals(expectedAddionalBonus,
      basicSalaryCalculator.getAdditionalBonus());

    double expectedGross = basicSalary + expectedSocialInsurance
      + expectedAddionalBonus;
    assertEquals(expectedGross, basicSalaryCalculator.getGrossSalary());

  }

  @DisplayName("Test BasicSalaryCalculator with invalid salary")
  @Test
  void testBasicSalaryWithInValidSalary() throws InterruptedException {
	  Thread.sleep(5000);
  	System.out.println("Test2 Running " + this.getClass().getSimpleName() +
              " on " + Thread.currentThread().getName());

    double basicSalary = -100;
    assertThrows(IllegalArgumentException.class, () -> {
      basicSalaryCalculator.setBasicSalary(basicSalary);
    });

  }

  @AfterEach
  void tearDown() {
    basicSalaryCalculator = null;
  }
}
