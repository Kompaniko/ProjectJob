import org.example.Account;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import static java.lang.System.out;


import static org.junit.jupiter.api.Assertions.*;


public class TestAccount {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = out;


    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    // проверка метода CheckNameToEmboss при передаче ему валидного имени
    @Test
    public void testCheckNameToEmboss_validName() {
        // тестовые данные
        String name = "Олег Петрович";
        Account account = new Account(name);
        // действие
        String result = account.checkNameToEmboss();
        // результат
        assertEquals("Имя и фамилия подходят для тиснения", result);
    }


    // тест на проверку имени с длиной больше 19 символов
    @Test
    public void testCheckNameToEmboss_longName() {
        String name = "Анастасия Михайлова Ольгертовна";
        Account account = new Account(name);
        // действие
        String result = account.checkNameToEmboss();
        // результат
        assertEquals("Имя и фамилия не подходят для тиснения", result);

    }

    // тест на проверку имени с пробелом в начале
    @Test
    public void testCheckNameToEmboss_atStart() {
        String name = " Александр Пушкин";
        Account account = new Account(name);
        // действие
        String result = account.checkNameToEmboss();
        // результат
        assertEquals("Имя и фамилия не подходят для тиснения", result);
    }

    // тест на проверку имени с пробелом в конце
    @Test
    public void testCheckNameToEmboss_atEnd() {
        String name = " Александр Пушкин ";
        Account account = new Account(name);
        // действие
        String result = account.checkNameToEmboss();
        // результат
        assertEquals("Имя и фамилия не подходят для тиснения", result);

    }

    //
    @Test
    public void testCheckNameToEmboss_twoSpaces() {
        String name = "Александр Пушкин ";
        Account account = new Account(name);
        // действие
        String result = account.checkNameToEmboss();
        // результат
        assertEquals("Имя и фамилия не подходят для тиснения", result);
    }

    // проверка имени без пробела
    @Test
    public void testCheckNameToEmboss_noSpaces() {
        String name = "АлександрПушкин";
        Account account = new Account(name);
        // действие
        String result = account.checkNameToEmboss();
        // результат
        assertEquals("Имя и фамилия не подходят для тиснения", result);

    }

    // тест на проверку имени с длиной меньше 3 символов
    @Test
    public void testCheckNameToEmboss_shortName() {
        String name = "Але";
        Account account = new Account(name);
        // действие
        String result = account.checkNameToEmboss();
        // результат
        assertEquals("Имя и фамилия не подходят для тиснения", result);
    }
}