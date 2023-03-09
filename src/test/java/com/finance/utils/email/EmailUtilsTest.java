package com.finance.utils.email;


import com.finance.util.email.EmailUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailUtilsTest {

        @Test
        void parseEmail_whenArgIsNull_thenReturnFalse() {
            Assertions.assertFalse(EmailUtils.mailValidate(""));
        }

    }
