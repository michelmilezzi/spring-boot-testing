package br.com.michelmilezzi.DemoApp.service;

import br.com.michelmilezzi.DemoApp.domain.Invoice;
import br.com.michelmilezzi.DemoApp.exception.InvalidInvoiceException;

public interface InvoiceService {

    void calculateTaxes(Invoice invoice);

    Double calculateSomethingComplex(Invoice invoice);

    void validateInvoice(Invoice invoice) throws InvalidInvoiceException;
}
