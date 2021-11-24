package com.unitintegrationtesting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UnitIntegrationTestingApplicationTests {

    Calculator calculator = new Calculator();

    @Test
    void itShouldAddNumbers() {

        //given
        int numberOne = 10;
        int numberTwo = 20;

        //when
        int result = calculator.add(numberOne, numberTwo);

        //then
        assertThat(result).isEqualTo(30);
    }

    class Calculator{
        int add(int a, int b){
            return a + b;
        }
    }

}
