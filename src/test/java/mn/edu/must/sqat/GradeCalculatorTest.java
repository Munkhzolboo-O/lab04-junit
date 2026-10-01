package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {
       @Test
@DisplayName("95 оноо A дүн байх ёстой")
void score95IsA() {
    // Arrange
    GradeCalculator calc = new GradeCalculator();

    // Act
    String result = calc.letterGrade(95);

    // Assert
    assertEquals("A", result);
}
  @Test
@DisplayName("90 оноо яг A байх ёстой")
void score90IsA() {
    // Arrange
    GradeCalculator calc = new GradeCalculator();

    // Act
    String result = calc.letterGrade(90);

    // Assert
    assertEquals("A", result);
}
@ParameterizedTest
@DisplayName("Үсгэн дүнгийн хязгаарын утгууд зөв байх ёстой")
@CsvSource({
    "95, A",
    "90, A",
    "89.99, B",
    "80, B",
    "70, C",
    "60, D",
    "59.99, F",
    "0, F",
    "100, A"
})
void letterGradeBoundaries(double score, String expected) {
    // Arrange
    GradeCalculator calc = new GradeCalculator();

    // Act
    String result = calc.letterGrade(score);

    // Assert
    assertEquals(expected, result);
}
@Test
@DisplayName("-1 оноо IllegalArgumentException өгөх ёстой")
void negativeScoreThrowsException() {
    // Arrange
    GradeCalculator calc = new GradeCalculator();

    // Act & Assert
    assertThrows(IllegalArgumentException.class,
            () -> calc.letterGrade(-1));
}
@Test
@DisplayName("Бүх оноо дээд хязгаартай үед нийлбэр 100 байх ёстой")
void totalScoreMaximumIs100() {
    // Arrange
    GradeCalculator calc = new GradeCalculator();

    // Act
    double result = calc.totalScore(10, 40, 10, 10, 30);

    // Assert
    assertEquals(100.0, result);
}

@Test
@DisplayName("101 оноо IllegalArgumentException өгөх ёстой")
void scoreAbove100ThrowsException() {
    // Arrange
    GradeCalculator calc = new GradeCalculator();

    // Act & Assert
    assertThrows(IllegalArgumentException.class,
            () -> calc.letterGrade(101));
}	
@Test
@DisplayName("Сөрөг ирцийн оноо exception өгөх ёстой")
void negativeAttendanceThrowsException() {
    // Arrange
    GradeCalculator calc = new GradeCalculator();

    // Act & Assert
    assertThrows(IllegalArgumentException.class,
            () -> calc.totalScore(-5, 40, 10, 10, 30));
}

@Test
@DisplayName("Лабын оноо 40-өөс их бол exception өгөх ёстой")
void labAboveMaximumThrowsException() {
    // Arrange
    GradeCalculator calc = new GradeCalculator();

    // Act & Assert
    assertThrows(IllegalArgumentException.class,
            () -> calc.totalScore(10, 41, 10, 10, 30));
}
@ParameterizedTest
@DisplayName("Нийлбэр оноо зөв тооцогдох ёстой")
@CsvSource({
    "10, 40, 10, 10, 30, 100",
    "5, 20, 5, 5, 15, 50",
    "0, 0, 0, 0, 0, 0",
    "8, 35, 7, 9, 25, 84"
})
void totalScoreParameterized(double att, double lab, double quiz1,
                             double quiz2, double exam, double expected) {
    // Arrange
    GradeCalculator calc = new GradeCalculator();

    // Act
    double result = calc.totalScore(att, lab, quiz1, quiz2, exam);

    // Assert
    assertEquals(expected, result);
}
}