package com.cateno.resources;

import com.cateno.exceptions.TimeException;
import com.cateno.models.DollarQuote;
import com.cateno.services.DollarQuoteService;
import com.cateno.views.DollarQuoteView;
import com.cateno.views.ExceptionView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.time.LocalDate;

@RestController
@RequestMapping("/dollar")
public class DollarQuoteResource {

    @Inject
    DollarQuoteService iDollarQuoteService;

    @GetMapping
    public ResponseEntity getQuoteToday() throws TimeException {
        DollarQuote quote =
                this.iDollarQuoteService.getDollarQuoteByDate(LocalDate.now());

        return ResponseEntity.ok(new DollarQuoteView(quote));
    }

    @GetMapping("/{date}")
    public ResponseEntity getQuoteByDate(@PathVariable String date) throws TimeException {
        DollarQuote quote =
                this.iDollarQuoteService
                        .getDollarQuoteByDate(LocalDate.parse(date));

        return ResponseEntity.ok(new DollarQuoteView(quote));
    }
}
