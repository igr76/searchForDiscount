package com.example.searchfordiscount;

import com.example.searchfordiscount.service.SearchService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SearchServiceTest {

    SearchService service = new SearchService();

   // String string="скидкa 20 процентов";
    @Test
    void searchDiscountTest() {
        String string="скидкa 20 процентов";
        assertThat(service.searchDiscount(string)).isEqualTo("скидкa 20 процентов ,");

    }
}
