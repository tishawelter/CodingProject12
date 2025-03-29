package com.promineotech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			
		} else {
			assertThatThrownBy(() ->  testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream argumentsForAddPositive() {
		// @Formatter:off
			return Stream.of
			(	arguments(1, 5, 6, false),
				arguments(5, 5, 10, false),
				arguments(7, 9, 16, false),
				arguments(-1, 5, 14, true),
				arguments(1, -3, -2, true),
				arguments(-2, -3, -5, true),
				arguments(0, 0, 0, true),
				arguments(44, 0, 44, true),
				arguments(-7, 0, -7, true),
				arguments(0, -24, -24, true)				
			);
			// @Formatter:on
		} 
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(15, 25)).isEqualTo(40);
		assertThat(testDemo.addPositive(1, 1)).isEqualTo(2);
		assertThat(testDemo.addPositive(35, 25)).isEqualTo(60);
		assertThat(testDemo.addPositive(22, 11)).isEqualTo(33);
	}
	
	
	@Test
	// this tests the find average of an array of given numbers
	void testFindAverage() {
		int[] numbers = {1, 4, 6, 7, 10};
		double expectedAverage = 5.6;
		assertThat(expectedAverage).isEqualTo(5.6);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
}
